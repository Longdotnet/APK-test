# ADR 0012: Deterministic MusicXML ingestion

## Status
Accepted

## Context

Roblox Piano already has a canonical `PerformanceTrack`, legacy TXT/VPS compatibility and deterministic Standard MIDI ingestion. MusicXML is the next useful notation boundary because it carries explicit pitch, duration, rests, chords, voices and ties without requiring playback to know anything about score syntax.

The production requirement is the same as MIDI: notation is untrusted input. Unsupported or ambiguous notation must fail closed instead of being silently guessed, and the resulting playback truth must be canonical deterministic state rather than UI-owned behavior.

## Decision

- Add `MusicXmlImporter` in Core; it has no UI, network, AI or Windows-input dependency.
- Support `score-partwise` MusicXML, divisions, explicit tempos, rests, chords, `backup`/`forward` voice movement, pitch alteration, measured note duration and simple tie chains.
- Convert pitches through the same `MidiKeyboardProfile` used by Standard MIDI so C2..C7 and transpose/range behavior are identical across importers.
- Group notes with identical canonical start/end times into one chord event.
- Emit only `PerformanceTrack`; playback and transport remain source-neutral.
- `.musicxml` and `.xml` enter through `SongSourceLoader` and are validated before the Sheet Library admits them.
- Unsupported score-timewise documents, grace notes, malformed XML, invalid durations, broken tie chains, impossible backup movement and out-of-range notes fail with controlled `FormatException` messages.
- No AI repair occurs implicitly. Future repair/review may suggest transformations, but deterministic import owns acceptance and canonical truth.

## Known boundary

This slice intentionally does not guess tuplets, ornaments, grace timing, pedal notation, dynamics, repeats/endings or MusicXML timewise scores. Those require explicit deterministic semantics and regression fixtures before admission. Files using unsupported constructs should be exported/flattened to measured score-partwise notation or MIDI rather than silently approximated.

## Release impact

This is a client/import capability and ships as v0.11.0. Production CI adds a dedicated MusicXML regression harness covering chord grouping, rests, voice backup, tempo, tie duration, range rejection and malformed/unsupported input while preserving the Legacy x2 and MIDI regression gates.
