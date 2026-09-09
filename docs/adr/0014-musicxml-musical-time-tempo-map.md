# ADR 0014: MusicXML musical-time tempo-map compilation

## Status
Accepted for production Phase 15.

## Context
Phase 13 converted MusicXML directly while advancing a cursor measured in seconds. Phase 14 correctly blocked tempo changes combined with `backup`/multi-voice input because rewinding a seconds cursor with the *current* BPM can land at the wrong musical position. The same representation also allowed a shorter later voice to leave the cursor before the real end of a measure, causing the next measure to begin too early.

These are silent playback-corruption risks: a score may import successfully but voices or later measures can be misaligned.

## Decision
MusicXML parsing now operates first in source musical time, expressed as quarter-note positions independent of tempo. Notes, rests, `backup`, `forward`, ties and direction offsets are resolved in this domain. Each measure tracks both a mutable voice cursor and the furthest musical extent reached by any voice; the next measure starts at that durable extent.

Tempo declarations become explicit markers on the musical timeline. After parsing, a deterministic tempo map integrates quarter positions into absolute seconds. Metronome beat units are normalized to quarter-note BPM. Simultaneous contradictory tempo declarations fail closed instead of choosing one by source order.

Only after this compilation are note endpoints grouped into canonical `PerformanceEvent` instances. The playback kernel remains source-neutral and receives the same absolute `PerformanceTrack` contract as TXT/VPS/MIDI.

## Consequences
- tempo changes can safely coexist with multi-voice `backup`/`forward`;
- MusicXML direction offsets that position tempo changes are supported deterministically;
- note durations that cross tempo boundaries are split mathematically by the tempo map without splitting canonical notes;
- measure progression follows the longest voice rather than whichever voice happened to be parsed last;
- ties crossing tempo boundaries preserve their musical endpoints and obtain correct absolute durations;
- conflicting tempo truth fails closed;
- Legacy/Legacy x2 and MIDI representation/playback are unchanged.

## Still fail-closed
Repeats/endings, tuplets, ornaments, pedal notation, grace/cue/unpitched notes, instrument transposition metadata and score-timewise remain outside the supported production subset until separately modeled and regression-gated.
