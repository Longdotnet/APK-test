# ADR 0024 — Visible MIDI compatibility decisions

Status: Accepted

## Context

`v0.16.2` deliberately made real-world Standard MIDI ingestion more tolerant by ignoring General MIDI percussion channel 10 and by applying one deterministic global transpose when a melodic range can fit the classic Roblox 61-key profile.

Those compatibility rules improve import success, but a silent transpose or silent track omission is still a source transformation. A production client must not make a song sound different from its source without telling the user what deterministic rule was applied.

The canonical playback model and `MidiFileImporter` remain the authority for whether a MIDI is valid and playable. Diagnostics must not become a second playback engine or a new failure dependency.

## Decision

1. Add a deterministic, best-effort `MidiImportInspector` that reads Standard MIDI structure only to describe compatibility decisions:
   - melodic source range;
   - requested and effective transpose;
   - automatic range-fit adjustment;
   - effective range after transpose;
   - count of General MIDI percussion NoteOn events ignored by the production policy.
2. `MidiFileImporter` remains the validation/playback truth. Inspection failure returns no metadata and must never make a MIDI fail if the production importer accepts it.
3. `SongSourceLoader` carries optional compatibility metadata beside the canonical `PerformanceTrack`; the playback engine remains source-neutral and never consumes this metadata.
4. Sheet Library rows expose a dedicated **Import compatibility** column. In-range MIDI reports `source preserved`; adjusted MIDI reports exact deterministic transformations such as `range auto-fit +1 st, ignored 1 drum note`.
5. Batch import counts and diagnostics surface compatibility-adjusted songs. Search may match compatibility text so users can find auto-fitted or drum-filtered entries.
6. No AI or network service participates in inspection, validation, import, or playback.

## Consequences

- Clients can distinguish fidelity-preserving MIDI from compatibility-normalized MIDI before pressing Play.
- Existing range-normalization playback behavior is unchanged; this phase makes its decisions observable rather than altering canonical timing or input dispatch.
- The inspector intentionally duplicates only the minimum Standard MIDI framing needed for observability. Any parser disagreement is fail-soft because only `MidiFileImporter` may block playback.
- The v0.16.3 self-target exclusion hotfix remains inherited unchanged.
- Future user-controlled transpose/profile settings can build on this metadata without coupling UI state into the playback kernel.

## Regression contract

CI must prove that:

- auto-fit and ignored percussion are reported with exact counts/ranges;
- ordinary in-range MIDI reports `source preserved`;
- malformed diagnostic input fails soft;
- Sheet Library persists and rescans compatibility metadata;
- the client cannot target itself as Roblox;
- Legacy, MusicXML, timing, focus/input and release behavior remain unchanged.
