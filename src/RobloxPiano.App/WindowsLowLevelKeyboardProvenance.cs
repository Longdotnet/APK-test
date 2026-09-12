using System.ComponentModel;
using System.Diagnostics;
using System.Runtime.InteropServices;

namespace RobloxPiano.App;

internal enum WindowsLowLevelKeyboardProvenanceKind
{
    Unknown = 0,
    NotInjected = 1,
    Injected = 2,
    LowerIntegrityInjected = 3
}

internal readonly record struct WindowsLowLevelKeyboardEventEvidence(
    bool IsTargetVirtualKey,
    bool IsDown,
    bool IsUp,
    uint VirtualKey,
    uint ScanCode,
    uint Flags,
    WindowsLowLevelKeyboardProvenanceKind Provenance);

internal readonly record struct WindowsLowLevelKeyboardProvenanceSnapshot(
    bool HookArmed,
    bool TargetDownObserved,
    bool TargetUpObserved,
    uint DownFlags,
    uint UpFlags,
    uint DownScanCode,
    uint UpScanCode,
    WindowsLowLevelKeyboardProvenanceKind DownProvenance,
    WindowsLowLevelKeyboardProvenanceKind UpProvenance)
{
    public int TargetEventCount { get; init; }
    public int NotInjectedTargetEventCount { get; init; }
    public int InjectedTargetEventCount { get; init; }
    public int LowerIntegrityInjectedTargetEventCount { get; init; }
    public bool UnexpectedTargetTransitionObserved { get; init; }

    internal bool InjectedPairObserved => HookArmed
        && TargetDownObserved
        && TargetUpObserved
        && DownProvenance is WindowsLowLevelKeyboardProvenanceKind.Injected or WindowsLowLevelKeyboardProvenanceKind.LowerIntegrityInjected
        && UpProvenance is WindowsLowLevelKeyboardProvenanceKind.Injected or WindowsLowLevelKeyboardProvenanceKind.LowerIntegrityInjected;

    internal bool PhysicalTargetContaminationObserved => NotInjectedTargetEventCount > 0;

    internal bool UncontaminatedInjectedPairObserved => InjectedPairObserved
        && TargetEventCount == 2
        && !UnexpectedTargetTransitionObserved
        && !PhysicalTargetContaminationObserved;
}

/// <summary>
/// Bounded, diagnostic-only WH_KEYBOARD_LL observer for one explicit synthetic probe key.
/// It never blocks, rewrites or injects input and ignores every unrelated key.
/// </summary>
internal sealed class WindowsLowLevelKeyboardProvenance : IDisposable
{
    private const int WhKeyboardLl = 13;
    private const int WmKeyDown = 0x0100;
    private const int WmKeyUp = 0x0101;
    private const int WmSysKeyDown = 0x0104;
    private const int WmSysKeyUp = 0x0105;
    internal const uint LlkhfLowerIlInjected = 0x02;
    internal const uint LlkhfInjected = 0x10;

    private readonly string probeId;
    private readonly string path;
    private readonly ushort virtualKey;
    private readonly HookProc callback;
    private readonly object stateGate = new();
    private IntPtr hook;
    private long? observationStartedAt;
    private bool observationActive;
    private bool targetDownObserved;
    private bool targetUpObserved;
    private uint downFlags;
    private uint upFlags;
    private uint downScanCode;
    private uint upScanCode;
    private WindowsLowLevelKeyboardProvenanceKind downProvenance;
    private WindowsLowLevelKeyboardProvenanceKind upProvenance;
    private int targetEventCount;
    private int notInjectedTargetEventCount;
    private int injectedTargetEventCount;
    private int lowerIntegrityInjectedTargetEventCount;
    private bool unexpectedTargetTransitionObserved;

    internal WindowsLowLevelKeyboardProvenance(string probeId, string path, ushort virtualKey)
    {
        ArgumentException.ThrowIfNullOrWhiteSpace(probeId);
        ArgumentException.ThrowIfNullOrWhiteSpace(path);
        if (virtualKey == 0)
        {
            throw new ArgumentOutOfRangeException(nameof(virtualKey));
        }

        this.probeId = probeId;
        this.path = path;
        this.virtualKey = virtualKey;
        callback = OnKeyboard;
    }

    internal void Start()
    {
        var module = GetModuleHandleW(null);
        hook = SetWindowsHookExW(WhKeyboardLl, callback, module, 0);
        if (hook == IntPtr.Zero)
        {
            throw new Win32Exception(
                Marshal.GetLastWin32Error(),
                "Could not arm bounded synthetic low-level keyboard provenance observer.");
        }

        ClientDiagnostics.Log(
            $"INPUT_FORENSIC probe={probeId} stage=LOWLEVEL_PROVENANCE_ARMED path={path} " +
            $"vk=0x{virtualKey:X2} hook=WH_KEYBOARD_LL privacy=TARGET_KEY_ONLY blocksInput=false productionChanged=false.");
    }

    internal void BeginObservation()
    {
        lock (stateGate)
        {
            observationStartedAt = Stopwatch.GetTimestamp();
            observationActive = true;
        }
    }

    internal WindowsLowLevelKeyboardProvenanceSnapshot EndObservation()
    {
        lock (stateGate)
        {
            observationActive = false;
            var snapshot = SnapshotCore();
            RobloxInputMatrixProbeEvidenceRegistry.Record(probeId, snapshot);
            ClientDiagnostics.Log(
                $"INPUT_FORENSIC probe={probeId} stage=LOWLEVEL_PROVENANCE_SUMMARY path={path} " +
                $"hookArmed={snapshot.HookArmed} downObserved={snapshot.TargetDownObserved} upObserved={snapshot.TargetUpObserved} " +
                $"downFlags=0x{snapshot.DownFlags:X} upFlags=0x{snapshot.UpFlags:X} " +
                $"downScan=0x{snapshot.DownScanCode:X} upScan=0x{snapshot.UpScanCode:X} " +
                $"downProvenance={snapshot.DownProvenance} upProvenance={snapshot.UpProvenance} " +
                $"targetEvents={snapshot.TargetEventCount} nonInjectedEvents={snapshot.NotInjectedTargetEventCount} " +
                $"injectedEvents={snapshot.InjectedTargetEventCount} lowerIntegrityInjectedEvents={snapshot.LowerIntegrityInjectedTargetEventCount} " +
                $"unexpectedTransition={snapshot.UnexpectedTargetTransitionObserved} physicalTargetContamination={snapshot.PhysicalTargetContaminationObserved} " +
                $"injectedPairObserved={snapshot.InjectedPairObserved} uncontaminatedInjectedPairObserved={snapshot.UncontaminatedInjectedPairObserved} " +
                "matrixEvidenceRecorded=true productionChanged=false.");
            return snapshot;
        }
    }

    internal WindowsLowLevelKeyboardProvenanceSnapshot Snapshot()
    {
        lock (stateGate)
        {
            return SnapshotCore();
        }
    }

    internal static WindowsLowLevelKeyboardProvenanceKind Classify(uint flags)
    {
        if ((flags & LlkhfLowerIlInjected) != 0)
        {
            return WindowsLowLevelKeyboardProvenanceKind.LowerIntegrityInjected;
        }

        if ((flags & LlkhfInjected) != 0)
        {
            return WindowsLowLevelKeyboardProvenanceKind.Injected;
        }

        return WindowsLowLevelKeyboardProvenanceKind.NotInjected;
    }

    internal static WindowsLowLevelKeyboardEventEvidence ClassifyEvent(
        ushort targetVirtualKey,
        uint observedVirtualKey,
        uint scanCode,
        uint flags,
        nint message)
    {
        var isDown = message == WmKeyDown || message == WmSysKeyDown;
        var isUp = message == WmKeyUp || message == WmSysKeyUp;
        return new WindowsLowLevelKeyboardEventEvidence(
            observedVirtualKey == targetVirtualKey,
            isDown,
            isUp,
            observedVirtualKey,
            scanCode,
            flags,
            Classify(flags));
    }

    internal static WindowsLowLevelKeyboardProvenanceSnapshot BuildSnapshotForDiagnostics(
        bool hookArmed,
        IReadOnlyList<WindowsLowLevelKeyboardEventEvidence> events)
    {
        ArgumentNullException.ThrowIfNull(events);

        var targetEvents = events
            .Where(evidence => evidence.IsTargetVirtualKey && (evidence.IsDown || evidence.IsUp))
            .ToArray();

        var firstDown = targetEvents.FirstOrDefault(evidence => evidence.IsDown);
        var firstUp = targetEvents.FirstOrDefault(evidence => evidence.IsUp);
        var targetDownObserved = targetEvents.Any(evidence => evidence.IsDown);
        var targetUpObserved = targetEvents.Any(evidence => evidence.IsUp);
        var expectedDown = true;
        var unexpectedTransition = false;
        foreach (var evidence in targetEvents)
        {
            if (expectedDown)
            {
                if (!evidence.IsDown)
                {
                    unexpectedTransition = true;
                }
                else
                {
                    expectedDown = false;
                }
            }
            else
            {
                if (!evidence.IsUp)
                {
                    unexpectedTransition = true;
                }
                else
                {
                    expectedDown = true;
                }
            }
        }

        if (targetEvents.Length != 2 || expectedDown is false)
        {
            unexpectedTransition = true;
        }

        return new WindowsLowLevelKeyboardProvenanceSnapshot(
            hookArmed,
            targetDownObserved,
            targetUpObserved,
            targetDownObserved ? firstDown.Flags : 0,
            targetUpObserved ? firstUp.Flags : 0,
            targetDownObserved ? firstDown.ScanCode : 0,
            targetUpObserved ? firstUp.ScanCode : 0,
            targetDownObserved ? firstDown.Provenance : WindowsLowLevelKeyboardProvenanceKind.Unknown,
            targetUpObserved ? firstUp.Provenance : WindowsLowLevelKeyboardProvenanceKind.Unknown)
        {
            TargetEventCount = targetEvents.Length,
            NotInjectedTargetEventCount = targetEvents.Count(evidence => evidence.Provenance == WindowsLowLevelKeyboardProvenanceKind.NotInjected),
            InjectedTargetEventCount = targetEvents.Count(evidence => evidence.Provenance == WindowsLowLevelKeyboardProvenanceKind.Injected),
            LowerIntegrityInjectedTargetEventCount = targetEvents.Count(evidence => evidence.Provenance == WindowsLowLevelKeyboardProvenanceKind.LowerIntegrityInjected),
            UnexpectedTargetTransitionObserved = unexpectedTransition
        };
    }

    public void Dispose()
    {
        lock (stateGate)
        {
            observationActive = false;
        }

        if (hook != IntPtr.Zero)
        {
            _ = UnhookWindowsHookEx(hook);
            hook = IntPtr.Zero;
        }
    }

    private WindowsLowLevelKeyboardProvenanceSnapshot SnapshotCore()
        => new(
            hook != IntPtr.Zero,
            targetDownObserved,
            targetUpObserved,
            downFlags,
            upFlags,
            downScanCode,
            upScanCode,
            downProvenance,
            upProvenance)
        {
            TargetEventCount = targetEventCount,
            NotInjectedTargetEventCount = notInjectedTargetEventCount,
            InjectedTargetEventCount = injectedTargetEventCount,
            LowerIntegrityInjectedTargetEventCount = lowerIntegrityInjectedTargetEventCount,
            UnexpectedTargetTransitionObserved = unexpectedTargetTransitionObserved
        };

    private IntPtr OnKeyboard(int code, IntPtr wParam, IntPtr lParam)
    {
        if (code >= 0)
        {
            var data = Marshal.PtrToStructure<KbdLlHookStruct>(lParam);
            var evidence = ClassifyEvent(virtualKey, data.VirtualKey, data.ScanCode, data.Flags, wParam);
            if (evidence.IsTargetVirtualKey && (evidence.IsDown || evidence.IsUp))
            {
                lock (stateGate)
                {
                    if (observationActive)
                    {
                        targetEventCount++;
                        switch (evidence.Provenance)
                        {
                            case WindowsLowLevelKeyboardProvenanceKind.NotInjected:
                                notInjectedTargetEventCount++;
                                break;
                            case WindowsLowLevelKeyboardProvenanceKind.Injected:
                                injectedTargetEventCount++;
                                break;
                            case WindowsLowLevelKeyboardProvenanceKind.LowerIntegrityInjected:
                                lowerIntegrityInjectedTargetEventCount++;
                                break;
                        }

                        if (evidence.IsDown)
                        {
                            if (targetDownObserved || targetUpObserved)
                            {
                                unexpectedTargetTransitionObserved = true;
                            }

                            if (!targetDownObserved)
                            {
                                targetDownObserved = true;
                                downFlags = evidence.Flags;
                                downScanCode = evidence.ScanCode;
                                downProvenance = evidence.Provenance;
                            }
                        }
                        else if (evidence.IsUp)
                        {
                            if (!targetDownObserved || targetUpObserved)
                            {
                                unexpectedTargetTransitionObserved = true;
                            }

                            if (!targetUpObserved)
                            {
                                targetUpObserved = true;
                                upFlags = evidence.Flags;
                                upScanCode = evidence.ScanCode;
                                upProvenance = evidence.Provenance;
                            }
                        }

                        var elapsed = observationStartedAt is null
                            ? TimeSpan.Zero
                            : Stopwatch.GetElapsedTime(observationStartedAt.Value);

                        ClientDiagnostics.Log(
                            $"INPUT_FORENSIC probe={probeId} stage=LOWLEVEL_PROVENANCE_EVENT path={path} " +
                            $"event={(evidence.IsDown ? "DOWN" : "UP")} vk=0x{evidence.VirtualKey:X2} scanCode=0x{evidence.ScanCode:X2} " +
                            $"flags=0x{evidence.Flags:X} provenance={evidence.Provenance} targetEventIndex={targetEventCount} " +
                            $"unexpectedTransition={unexpectedTargetTransitionObserved} " +
                            $"elapsedMs={elapsed.TotalMilliseconds.ToString("0.###", System.Globalization.CultureInfo.InvariantCulture)} " +
                            "privacy=TARGET_KEY_ONLY productionChanged=false.");
                    }
                }
            }
        }

        return CallNextHookEx(hook, code, wParam, lParam);
    }

    [StructLayout(LayoutKind.Sequential)]
    private readonly struct KbdLlHookStruct
    {
        public readonly uint VirtualKey;
        public readonly uint ScanCode;
        public readonly uint Flags;
        public readonly uint Time;
        public readonly UIntPtr ExtraInfo;
    }

    private delegate IntPtr HookProc(int code, IntPtr wParam, IntPtr lParam);

    [DllImport("user32.dll", SetLastError = true, CharSet = CharSet.Unicode)]
    private static extern IntPtr SetWindowsHookExW(int hookId, HookProc callback, IntPtr module, uint threadId);

    [DllImport("user32.dll", SetLastError = true)]
    [return: MarshalAs(UnmanagedType.Bool)]
    private static extern bool UnhookWindowsHookEx(IntPtr hook);

    [DllImport("user32.dll")]
    private static extern IntPtr CallNextHookEx(IntPtr hook, int code, IntPtr wParam, IntPtr lParam);

    [DllImport("kernel32.dll", CharSet = CharSet.Unicode)]
    private static extern IntPtr GetModuleHandleW(string? moduleName);
}
