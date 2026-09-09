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

No Python, Node.js, .NET SDK, Visual Studio, PowerShell modules, installer helper, or repository checkout is required for the client.

Every published release also includes `RobloxPiano.exe.sha256`. GitHub Actions artifacts remain short-lived engineering evidence and are not the normal distribution path.

## Normal client workflow

The primary experience is Library-first, not command-line and not Browse-first.

```text
Double-click RobloxPiano.exe
        ↓
Library opens immediately
        ↓
search local songs or online MIDI results
        ↓
optional: Add online result to Library
        ↓
select validated song
        ↓
Play
        ↓
app finds/activates RobloxPlayerBeta
        ↓
F6 slower | F7 faster | F8 pause/resume | F9 stop
```

The Library scans managed/portable `.txt`, `.vps`, `.mid`, and `.midi` songs. The same search box filters local songs immediately and can show up to ten deterministically ranked online MIDI candidates from public providers. Online candidates are never streamed directly into playback: the user explicitly adds one to Library, the file is size/host constrained, validated through the deterministic MIDI importer, and then played from local canonical state.

Browse and drag/drop remain import mechanisms rather than the main playback workflow. Imports are validated before entering the managed Library and collision-safe naming prevents accidental overwrite.

When a strictly newer stable Roblox Piano release is available, released clients can show an optional **Update & Restart** banner. Update/network failure does not block local search or playback. The new executable and checksum are downloaded from the GitHub Release, SHA-256 verified, staged locally, atomically installed only after the current client exits, verified again, and then restarted. The shipped EXE performs the updater role itself; no script, installer or second helper binary is required.

The desktop client also:

- automatically searches for a running Roblox player and excludes Roblox Studio;
- prefers the foreground Roblox player when more than one candidate exists;
- binds live playback to the selected Roblox process ID;
- best-effort restores/activates Roblox before playback starts;
- remembers client state under `%LOCALAPPDATA%\RobloxPiano`;
- registers global F6/F7/F8/F9 controls while keeping equivalent on-screen controls;
- writes best-effort local diagnostics under `%LOCALAPPDATA%\RobloxPiano\logs`;
- remains single-instance in interactive mode so two players cannot compete for keyboard injection;
- supports safe seek/transport without leaving held keys behind;
- keeps online discovery and update infrastructure optional to offline deterministic operation.

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
- absolute monotonic scheduling and explicit key-down/key-up edge planning;
- protected `Legacy x2` regression baseline;
- `PlaybackSessionClock` for rebased live speed;
- safe seek/transport with active-note re-entry and release-all behavior;
- reference-counted physical held-key ownership;
- canonical expressive sustain compilation;
- deterministic Standard MIDI import into the same canonical model;
- Roblox foreground/process focus guards;
- Windows `SendInput` backend using scan codes;
- managed/portable Library with deterministic validation and safe import;
- zero-config online MIDI discovery with deterministic ranking/dedupe and provider isolation;
- optional verified single-EXE self-update isolated from playback truth;
- playback-quality telemetry and deterministic scheduler A/B comparison;
- self-contained single-EXE production and release gates;
- immutable GitHub Release identities after a green exact-`main` production gate.

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

Internal updater command-line switches are implementation details and are not client controls. The CI-only no-restart updater mode is additionally gated by an environment variable and exists only to exercise the published EXE replacement path safely.

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
legacy TXT/VPS          Standard MIDI
      |                      |
      +-----------+----------+
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

client Library:
managed + portable roots
        -> deterministic validation
        -> local searchable Library
        -> optional public online discovery
        -> explicit validated local import
        -> selected canonical track

optional update plane:
GitHub stable Release metadata
        -> strict version/release contract
        -> trusted bounded EXE + checksum download
        -> staged SHA-256 verified executable
        -> wait old process exit
        -> atomic target-side replacement + final rehash
        -> restart installed client
```

The Core project targets plain `net10.0`; it does not reference Windows, Roblox, WinForms, AI, online providers, or updater UI. The updater trust/staging logic is also isolated in a platform-neutral `net10.0` project; WinForms owns only presentation and process restart orchestration. AI remains optional and is never required for deterministic parsing, validation, timeline ownership, playback, safety, transport, Library behavior, discovery mutation, or update verification.

## Production gates

Every PR to `main` must prove the slice can ship. The gate includes:

1. strict SemVer release identity;
2. deterministic Core build;
3. Legacy playback regressions;
4. transport regressions;
5. held-input ownership regressions;
6. expressive sustain regressions;
7. deterministic MIDI regressions;
8. timing calibration regressions;
9. Library regressions;
10. online discovery regressions;
11. safe self-update regressions;
12. playback-quality regressions;
13. Windows Forms client build;
14. self-contained `win-x64` single-file publish;
15. embedded EXE version contract;
16. published EXE `--help` smoke;
17. actual published single-EXE atomic self-replacement smoke;
18. dry-run playback-quality smoke;
19. malformed-baseline controlled-error regression;
20. CI evidence upload.

After the production gate succeeds on `main`, the release workflow checks out the exact validated SHA and reruns production regressions, including updater tests and the actual published single-EXE replacement smoke. It then generates SHA-256 evidence, creates the immutable-version GitHub Release, downloads the published EXE again, and verifies that downloaded asset against the candidate hash.

A release version is never silently overwritten. Future release-worthy changes must bump `VersionPrefix` in `Directory.Build.props`.

Real `RegisterHotKey`, `SetForegroundWindow`, Roblox acceptance of `SendInput`, and antivirus/SmartScreen behavior still require real Windows-client acceptance. The executable is currently unsigned, so Windows SmartScreen reputation/code-signing remains a separate production hardening concern.

## Architecture decisions

- `docs/adr/0001-production-playback-kernel.md`
- `docs/adr/0002-playback-quality-observability.md`
- `docs/adr/0003-production-client-runtime.md`
- `docs/adr/0004-safe-seekable-transport.md`
- `docs/adr/0005-production-sheet-library.md`
- `docs/adr/0006-production-release-channel.md`
- `docs/adr/0007-held-input-state-ownership.md`
- `docs/adr/0008-canonical-expressive-sustain.md`
- `docs/adr/0009-deterministic-standard-midi-import.md`
- `docs/adr/0010-simple-client-experience.md`
- `docs/adr/0011-zero-config-online-song-discovery.md`
- `docs/adr/0012-safe-single-exe-self-update.md`
