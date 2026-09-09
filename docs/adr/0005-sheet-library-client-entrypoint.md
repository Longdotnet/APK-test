# ADR 0005: Deterministic Sheet Library as the client entrypoint

## Status
Accepted.

## Context

The production EXE had a Windows player shell, but the primary workflow still asked users to browse or drag-drop a file before every session. The legacy client expectation is a visible song list immediately after launch. Treating Browse as the main workflow is unnecessary client friction and makes imported files ephemeral rather than an owned product library.

## Decision

Double-click client mode opens a Sheet Library before the playback window.

The library is a deterministic service (`RobloxPiano.Library`) independent of WinForms. It:

- scans the managed LocalAppData library and an optional portable `sheets` directory next to the EXE;
- supports the current stable `.txt` and `.vps` formats only;
- parses metadata through the stable legacy importer so title/BPM/event count/duration are derived from playback truth rather than duplicated UI parsing;
- keeps invalid files visible with an explicit validation error instead of silently hiding or repairing them;
- validates before managed import;
- copies imports into the managed library with collision-safe filenames and never overwrites an existing song;
- exposes plain immutable catalog records to the UI.

The WinForms shell owns search/list presentation only. Selecting a valid catalog item persists the selected path through the existing client state and opens the production player. Playback, focus safety, timing, seek, speed, and release-all remain owned by Core/runtime services.

## Consequences

Normal users now get a song list first and Browse/drag-drop become ways to add songs rather than the only way to play. The single-EXE distribution invariant remains unchanged because the managed library is runtime user data, not an additional shipped dependency.

MIDI/MusicXML will enter the library only after their deterministic importer contracts exist. Unsupported formats are rejected rather than mislabeled as playable.

## Regression gates

A dedicated deterministic harness verifies valid/invalid catalog surfacing, managed + portable scanning, metadata extraction, unsupported-format rejection, validation-before-copy, and collision-safe import behavior. CI runs this harness before building/publishing the Windows client.
