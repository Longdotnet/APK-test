# ADR 0010: Simple client experience over deterministic internals

## Status
Accepted

## Context

The production core now has multiple technical controls and safety mechanisms: source importers, Legacy compatibility, MIDI parsing, expressive sustain compilation, timing calibration, transport, focus guards, global hotkeys, release-all and diagnostics. Exposing those concepts directly makes the normal Windows client behave like a developer tool.

The product contract is instead: download one EXE, open the Sheet Library, choose/import a song, open Roblox, and Play.

## Decision

The normal desktop path is library-first and action-first.

- Sheet Library continuously discovers Roblox and exposes one primary **Play** action only when the selected song is valid and Roblox is available.
- Selecting Play opens the playback surface and starts the selected song automatically; a second technical setup step is not required.
- `Import Song` is source-neutral. TXT, VPS, MID and MIDI route through `SongSourceLoader`, which deterministically lowers every supported input into canonical `PerformanceTrack` data before transport/playback.
- The UI never asks the client to choose Legacy, MIDI importer, scheduler, sustain compiler or playback engine.
- The playback surface shows only Roblox readiness, song identity, Play/Pause/Stop and seek in the default view.
- Speed controls, latency override, hotkey status, raw file path and diagnostics remain available under a collapsed **Advanced** section for troubleshooting and power users.
- Missing Roblox is an inline readiness state, not a blocking technical error dialog.
- Playback failures stop safely and tell the user to retry; detailed exception data is written to diagnostics automatically.
- Focus loss, stop, cancellation and input failure continue to rely on the existing deterministic safety ownership. Simplifying the UI does not weaken those invariants.

## Source-neutral loading

`RobloxPiano.Library.SongSourceLoader` is the desktop boundary between files and canonical playback:

- `.txt` / `.vps` -> `LegacySheetParser` -> `PerformanceTrack`
- `.mid` / `.midi` -> `MidiFileImporter` -> expressive compiler -> `PerformanceTrack`

The library and player consume the same loader. A format therefore cannot appear playable in the Library while being routed through a different parser at playback time.

## Legacy baseline

Legacy TXT/VPS parsing and the Legacy x2 quality baseline are unchanged. The UI does not promote a new scheduler or mutate canonical timing. Advanced timing override still defaults to 0 ms.

## Verification

The song-library regression harness covers both text and MIDI through the same loader, managed/portable discovery, validation-before-import, collision-safe MIDI imports, malformed MIDI rejection and unsupported extensions. Existing Core, Legacy, transport, held-input, expressive, MIDI, timing and playback-quality gates remain mandatory. Windows client build, self-contained single-EXE publish and release download/hash verification remain unchanged.
