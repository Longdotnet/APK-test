# Roblox Piano

Production-oriented Windows playback tooling for Roblox virtual-piano experiences.

## Download for clients

Normal clients should use **GitHub Releases**, not GitHub Actions artifacts.

Latest client asset:

```text
https://github.com/Longdotnet/APK-test/releases/latest/download/RobloxPiano.exe
```

Release page:

```text
https://github.com/Longdotnet/APK-test/releases
```

The client distribution remains one self-contained Windows x64 executable:

```text
RobloxPiano.exe
```

No Python, Node.js, .NET SDK, Visual Studio, PowerShell modules, or repository checkout is required for the client.

Every published release also includes `RobloxPiano.exe.sha256` so the downloaded asset can be verified. GitHub Actions artifacts remain short-lived engineering evidence and are not the normal distribution path.

## Normal client workflow

The primary experience is list-first, not command-line and not Browse-first.

```text
Double-click RobloxPiano.exe
        ↓
Sheet Library opens
        ↓
select/search a validated sheet
        ↓
Play
        ↓
app finds/activates RobloxPlayerBeta
        ↓
F6 slower | F7 faster | F8 pause/resume | F9 stop
```

The Sheet Library scans validated managed/portable sheet locations and presents the available `.txt` / `.vps` songs as a list. Browse and drag/drop remain import mechanisms for adding new sheets; they are not the main playback workflow. Imports are validated before entering the managed library and collision-safe naming prevents accidental overwrite.

The desktop client also:

- automatically searches for a running Roblox player and excludes Roblox Studio;
- prefers the foreground Roblox player when more than one candidate exists;
- binds live playback to the selected Roblox process ID;
- best-effort restores/activates Roblox before the sheet countdown starts;
- remembers client state under `%LOCALAPPDATA%\RobloxPiano`;
- registers global F6/F7/F8/F9 controls while keeping equivalent on-screen controls;
- writes best-effort local diagnostics under `%LOCALAPPDATA%\RobloxPiano\logs`;
- remains single-instance in interactive mode so two players cannot compete for keyboard injection;
- supports safe seek/transport without leaving held keys behind.

Live controls:

```text
F6  speed -0.10x
F7  speed +0.10x
F8  pause / resume
F9  stop
```

Live speed is clamped to `0.25x`–`4.00x`. Speed changes rebase the playback time-domain at the current instant, so changing speed does not restart the song or intentionally jump the canonical score timeline.

F8 pause deliberately enters the same safety path as losing Roblox focus: held keys are released and logical song progress is frozen until playback is resumed. F9 cancellation ends in the kernel release-all path.

## Production playback foundation

The product preserves measurable working baselines instead of replacing them with unverified rewrites.

Included now:

- canonical `PerformanceTrack` / `PerformanceEvent` model independent of legacy sheet syntax, UI, AI, and Windows input;
- absolute monotonic scheduling;
- explicit key-down/key-up edge planning;
- preserved `Legacy x2` regression baseline;
- `PlaybackSessionClock` for rebased live speed;
- safe seek/transport with active-note re-entry and release-all behavior;
- Roblox foreground/process focus guards;
- Windows `SendInput` backend using scan codes;
- deterministic legacy `.txt` / `.vps` validation;
- managed/portable Sheet Library with search and safe import;
- playback-quality telemetry and deterministic scheduler A/B comparison;
- regression harnesses for legacy playback, transport, library behavior, and timing quality;
- self-contained single-EXE production gate;
- immutable GitHub Release channel after a green `main` production gate.

The experimental V5 `{duration}` syntax remains rejected by the stable legacy parser because it degraded the perceived result compared with the previous sheet at `x2`. Duration-aware behavior belongs in the canonical model and must beat the baseline before promotion.

## Developer / CI mode

The CLI remains available for engineering, automation, validation, and quality evidence. It is not required client knowledge.

```powershell
dotnet run --project src/RobloxPiano.App/RobloxPiano.App.csproj -- song.txt
dotnet run --project src/RobloxPiano.App/RobloxPiano.App.csproj -- song.txt --speed 2
```

Safe diagnostic modes:

```powershell
dotnet run --project src/RobloxPiano.App/RobloxPiano.App.csproj -- song.txt --validate-only
dotnet run --project src/RobloxPiano.App/RobloxPiano.App.csproj -- song.txt --dry-run
```

Production executable diagnostic usage:

```text
RobloxPiano.exe <sheet.txt> [--speed N] [--start-delay S] [--dry-run] [--validate-only]
    [--quality-report report.json] [--baseline-report baseline.json] [--quality-gate]
```

For the protected regression baseline:

```text
RobloxPiano.exe chac-ai-do-se-ve.txt --speed 2
```

## Playback quality telemetry

The diagnostic CLI can record scheduler execution without changing the client distribution contract:

```text
RobloxPiano.exe song.txt --speed 2 --quality-report legacy-x2.json
```

Reports contain plan fingerprint/speed, planned/dispatched/missing edges, timing error, input-call duration, focus pauses, failures, and worst timing samples. Foreground-focus pauses are measured separately and normalized out of scheduler drift.

A/B example:

```text
RobloxPiano.exe song.txt --speed 2 --quality-report candidate.json \
  --baseline-report legacy-x2.json --quality-gate
```

The scheduler A/B layer measures execution quality only; it does not claim perceptual similarity to a reference recording.

## Legacy sheet compatibility

Supported headers:

```text
TITLE=Song
AUTHOR=Author
BPM=100
SUBDIV=4
START_DELAY=5
CHORD_HOLD=0.75
PRINT_MODE=current
LOOPS=1
```

Body example:

```text
t r w
[ad] t r
... [Oad]
```

- each printable token is one note step;
- `[ad]` is one chord step;
- each `.` is one rest step;
- `|` and `-` remain compatibility separators and do not advance time;
- uppercase/symbol characters remain distinct for Windows keyboard modifiers;
- malformed chords and timing metadata fail explicitly.

## Architecture boundary

```text
legacy TXT/VPS    future MIDI / MusicXML / OMR
      |                        |
      +-----------+------------+
                  v
        canonical PerformanceTrack
                  |
                  v
            PlaybackPlanner
                  |
                  v
            PlaybackKernel
                  |
        +---------+----------+
        |                    |
   IFocusGate             IInputSink
        |                    |
 Roblox process         Windows SendInput

interactive runtime:
PlaybackSessionClock  <--- F6/F7 live speed
PlaybackSessionFocus  <--- F8 pause + Roblox focus
Transport slicing     <--- seek / restart safely

client library:
managed + portable sheet roots
        -> deterministic validation
        -> searchable Sheet Library
        -> selected canonical track
```

The Core project targets plain `net10.0`; it does not reference Windows, Roblox, WinForms, AI, or a particular importer. AI remains optional and is never required for deterministic parsing, validation, timeline ownership, playback, safety, transport, or library behavior.

## Production gates

Every PR to `main` must prove the slice can ship:

1. validate strict SemVer release identity;
2. deterministic core build;
3. legacy regression harness;
4. transport regression harness;
5. sheet-library regression harness;
6. playback-quality regression harness;
7. Windows Forms client build;
8. self-contained `win-x64` single-file publish;
9. embedded EXE version matches the repository release version;
10. published EXE `--help` smoke test;
11. dry-run quality report smoke test;
12. malformed-baseline controlled-error regression;
13. CI artifact upload for acceptance evidence.

After the production gate succeeds on `main`, the release workflow checks out the exact validated SHA, reruns production regressions, publishes the EXE, generates SHA-256 evidence, creates immutable `vX.Y.Z` GitHub Release assets, downloads the published EXE again, and verifies its hash.

A release version is never silently overwritten. Future release-worthy changes must bump `VersionPrefix` in `Directory.Build.props`.

Real `RegisterHotKey`, `SetForegroundWindow`, and Roblox acceptance of `SendInput` still require real Windows + Roblox acceptance testing. The executable is currently unsigned, so Windows SmartScreen reputation/code-signing remains a separate production hardening concern.

## Architecture decisions

- `docs/adr/0001-production-playback-kernel.md`
- `docs/adr/0002-playback-quality-observability.md`
- `docs/adr/0003-production-client-runtime.md`
- `docs/adr/0004-safe-seekable-transport.md`
- `docs/adr/0005-production-sheet-library.md`
- `docs/adr/0006-production-release-channel.md`
