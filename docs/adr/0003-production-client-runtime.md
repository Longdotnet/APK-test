# ADR-0003: Production client runtime and live controls

- Status: Accepted
- Date: 2026-09-09

## Context

The first two production slices established a deterministic playback kernel, a protected Legacy x2 baseline, quality telemetry, A/B scheduler comparison, and a self-contained single-EXE distribution gate.

That foundation accidentally regressed the actual client experience. The working PowerShell prototype had already proved a more useful interaction model: locate Roblox automatically, let the player choose a sheet, and control playback with F6/F7/F8/F9. Requiring a normal client to understand command-line arguments such as `--speed` or `--quality-report` would turn a production foundation into a developer tool.

The product therefore needs two surfaces over the same core:

- an interactive Windows client optimized for normal players;
- a diagnostic CLI retained for CI, regression, validation, and engineering evidence.

## Decision

### 1. Double-click launches the product shell

Running `RobloxPiano.exe` without arguments opens a Windows desktop client. The console window is hidden immediately.

The normal workflow is:

```text
RobloxPiano.exe
      ↓
auto-discover Roblox
      ↓
browse / drag-drop .txt or .vps
      ↓
Play
      ↓
F6 slower | F7 faster | F8 pause/resume | F9 stop
```

The existing CLI remains available when explicit arguments are supplied. CLI switches are an engineering interface, not required client knowledge.

### 2. Do not create a second playback scheduler for live speed

The canonical `PlaybackKernel` remains the only scheduler. Live speed is implemented by `PlaybackSessionClock`, an `IMonotonicClock` time-domain transform over a real monotonic wall clock.

Changing speed rebases the virtual clock at the exact current wall-clock position, then changes only the rate of future virtual time. Canonical track time therefore does not jump backward, restart, or skip because F6/F7 was pressed.

The interactive kernel runs with `PlaybackOptions.Speed = 1`. The session clock supplies the live rate. The fixed-speed CLI continues using the original `StopwatchClock` + `PlaybackOptions.Speed` path, preserving scheduler-quality comparability with existing reports.

### 3. User pause reuses focus-loss safety

F8 pause is deliberately not implemented as a separate note-hold state machine.

`PlaybackSessionFocusGate` returns false when either:

- the selected Roblox process is no longer foreground; or
- the user has paused the session.

This sends both cases through the existing kernel behavior:

```text
inactive
  ↓
ReleaseAll
  ↓
freeze logical playback target via paused duration
  ↓
wait
  ↓
resume from the same canonical timeline position
```

F9 cancels the session; the kernel `finally` path still owns final release-all safety.

### 4. Bind playback to one discovered Roblox process

Discovery prefers the currently foreground Roblox player. Otherwise it selects a live player window, preferring `RobloxPlayerBeta`, and excludes Roblox Studio.

Once playback starts, focus checks are bound to that process ID rather than accepting any process with `Roblox` in its name. This avoids silently sending notes to an unrelated Roblox/Studio window.

Window activation is best effort because Windows foreground-stealing policy can reject `SetForegroundWindow`. A failed activation does not bypass safety; the client tells the user to click Roblox during the countdown and the kernel waits until the selected target is truly foreground.

### 5. Global F6-F9 controls are convenience, not a safety dependency

The client registers F6-F9 with `RegisterHotKey` and `MOD_NOREPEAT`:

- F6: speed -0.10x
- F7: speed +0.10x
- F8: pause/resume
- F9: stop

Speed is clamped to 0.25x–4.0x.

Global hotkey registration can fail if another application owns a key. The client reports that failure and keeps equivalent on-screen controls available. Playback safety must not depend on successful hotkey registration.

### 6. The interactive client is single-instance

A named local mutex prevents two product-shell instances from simultaneously registering the same hotkeys or injecting competing note streams. Diagnostic CLI executions remain separate and are not governed by the UI mutex.

### 7. Client state and diagnostics are local and non-critical

The client persists only usability state under `%LOCALAPPDATA%\RobloxPiano`:

- last sheet path;
- preferred playback speed.

Best-effort daily diagnostics are written under `%LOCALAPPDATA%\RobloxPiano\logs`. Logging and state persistence swallow their own filesystem failures so they cannot interrupt live playback.

No AI, network API, credential, Python runtime, Node runtime, or developer SDK is introduced into the client critical path.

## Regression policy

Automated deterministic coverage must prove:

- a speed change rebases without a virtual timeline discontinuity;
- playback-time delay scales correctly against wall time;
- user pause participates in the focus safety gate;
- client speed limits clamp extreme positive values and reject invalid/non-positive values;
- all previous legacy parser, Legacy x2, release-all, quality, packaging, and malformed-input regressions stay green.

Real `RegisterHotKey`, Roblox foreground activation, and Roblox acceptance of `SendInput` cannot be truthfully validated on a headless GitHub Actions runner. Those remain explicit real-client acceptance tests rather than being falsely represented by unit tests.

## Consequences

The repository is more complex internally because it now contains both a product shell and diagnostic CLI, but the external client contract becomes simpler:

```text
Download RobloxPiano.exe
Double-click
Choose sheet
Play
```

The single-file release invariant remains unchanged.
