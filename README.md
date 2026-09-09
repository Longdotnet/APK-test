# Roblox Piano

Production-oriented Windows playback tooling for Roblox virtual-piano experiences.

## Client contract

The client distribution target is intentionally simple:

```text
RobloxPiano.exe
```

A normal Windows user should not need Python, Node.js, the .NET SDK, Visual Studio, PowerShell modules, or a repository checkout. CI enforces a self-contained `win-x64` single-file publish and fails if the publish directory contains anything other than `RobloxPiano.exe`.

## Production playback foundation

The product deliberately preserves a measurable baseline instead of replacing working behavior with unverified rewrites.

Included now:

- canonical performance events independent of legacy sheet syntax;
- absolute monotonic scheduling based on `Stopwatch`;
- edge planning with explicit key-down/key-up events;
- configurable playback speed, including the important `Legacy x2` regression baseline;
- Roblox foreground focus guard;
- best-effort release-all safety on focus loss, cancellation, input failure, or normal completion;
- Windows `SendInput` backend using scan codes rather than text injection;
- deterministic legacy `.txt` parser with validation instead of silent malformed-sheet repair;
- playback-quality instrumentation around the stable Core interfaces rather than a second scheduler implementation;
- JSON quality reports with planned/dispatched/missing edges, timing error, input-call duration, focus pauses, failures, and worst timing samples;
- deterministic A/B comparison guarded by a canonical playback-plan fingerprint;
- zero-dependency deterministic regression/quality harnesses;
- GitHub Actions production gate that builds, runs regressions, publishes, smoke-tests, and uploads a single `RobloxPiano.exe` artifact.

The experimental V5 `{duration}` syntax is deliberately rejected by the stable legacy parser. The earlier duration experiment degraded the perceived result compared with the old sheet at `x2`; it must not silently change baseline semantics. Duration-aware performance belongs in the canonical model and will only be promoted when it beats the baseline through appropriate regression and A/B validation.

## Run from source

Requires the .NET 10 SDK only for development:

```powershell
dotnet run --project src/RobloxPiano.App/RobloxPiano.App.csproj -- song.txt
dotnet run --project src/RobloxPiano.App/RobloxPiano.App.csproj -- song.txt --speed 2
```

Useful safe modes:

```powershell
# Parser + planner validation; never sends keyboard input.
dotnet run --project src/RobloxPiano.App/RobloxPiano.App.csproj -- song.txt --validate-only

# Runs the real scheduler but traces events instead of injecting keys.
dotnet run --project src/RobloxPiano.App/RobloxPiano.App.csproj -- song.txt --dry-run
```

Production executable usage:

```text
RobloxPiano.exe <sheet.txt> [--speed N] [--start-delay S] [--dry-run] [--validate-only]
    [--quality-report report.json] [--baseline-report baseline.json] [--quality-gate]
```

For the current regression baseline:

```text
RobloxPiano.exe chac-ai-do-se-ve.txt --speed 2
```

## Playback quality telemetry

The client can record deterministic scheduler execution without changing the single-EXE distribution contract:

```text
RobloxPiano.exe song.txt --speed 2 --quality-report legacy-x2.json
```

A report contains:

- deterministic plan fingerprint and speed;
- planned/dispatched/missing edge counts;
- input/safety failure count;
- focus-pause count and duration;
- mean signed/absolute timing error;
- p95 and worst absolute timing error;
- mean/max input-call duration;
- worst timing samples for diagnostics.

Timing error is measured relative to the first actual dispatch. Deliberate foreground-focus pauses are measured separately and normalized out of scheduler timing so an alt-tab pause is not misreported as clock drift.

### A/B scheduler comparison

Capture the known baseline first:

```text
RobloxPiano.exe song.txt --speed 2 --quality-report legacy-x2.json
```

Then compare a later candidate using the same canonical plan and speed:

```text
RobloxPiano.exe song.txt --speed 2 \
  --quality-report candidate.json \
  --baseline-report legacy-x2.json
```

For CI/promotion-style execution:

```text
RobloxPiano.exe song.txt --speed 2 \
  --quality-report candidate.json \
  --baseline-report legacy-x2.json \
  --quality-gate
```

`--quality-gate` succeeds only for `Better` or `Equivalent`. It returns a non-zero exit code for `Worse`, `Inconclusive`, or `Incomparable` candidates.

Important: this A/B layer measures **scheduler execution quality**, not whether the song sounds more like a reference recording. Different canonical music plans intentionally compare as `Incomparable`. Perceptual/reference-audio analysis belongs in a later layer instead of overstating what scheduler metrics prove.

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

Body semantics:

```text
t r w
[ad] t r
... [Oad]
```

- each printable token is one note step;
- `[ad]` is one chord step;
- each `.` is one rest step;
- `|` and `-` remain compatibility separators and do not advance time;
- uppercase/symbol characters remain distinct so the Windows adapter can apply keyboard modifiers;
- malformed chords and invalid timing metadata fail explicitly.

## Architecture boundary

```text
legacy TXT (future: MIDI / MusicXML / OMR)
                 |
                 v
       canonical PerformanceTrack
                 |
                 v
          PlaybackPlanner
          key-down / key-up
                 |
                 v
          PlaybackKernel
       monotonic absolute time
                 |
       +---------+----------+
       |                    |
  IFocusGate             IInputSink
       |                    |
       +------ PlaybackInstrumentation ------+
       |                                     |
 Roblox foreground                    Windows SendInput
                       \
                        -> PlaybackQualityCollector -> JSON/A-B
```

The core project targets plain `net10.0`; it does not reference Windows, Roblox, UI, AI, or a particular importer. `RobloxPiano.App` is the Windows adapter/product host.

AI is intentionally not on the critical path. Future AI capabilities may advise or repair low-confidence music interpretation, but deterministic parsing, validation, timeline ownership, playback, safety, and quality telemetry continue to work without AI, network access, API quota, or model availability.

## Production gates

Every PR to `main` must prove the slice can ship:

1. deterministic core builds with warnings treated as errors;
2. legacy regression harness passes;
3. playback-quality regression harness passes;
4. Windows client builds;
5. self-contained `win-x64` single-file publish succeeds;
6. distribution contains exactly `RobloxPiano.exe`;
7. the published EXE starts successfully with `--help`;
8. a published-EXE dry-run produces a valid quality JSON report;
9. the EXE is uploaded as a CI artifact for client testing.

Architecture decisions:

- `docs/adr/0001-production-playback-kernel.md`
- `docs/adr/0002-playback-quality-observability.md`
