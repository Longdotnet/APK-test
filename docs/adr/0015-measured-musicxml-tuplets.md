# ADR 0015: Measured MusicXML tuplets

## Status
Accepted for production Phase 16.

## Context
MusicXML tuplets are commonly represented with two independent concepts: the note `duration`, which is the authoritative measured playback length in divisions, and `time-modification` / `tuplet` elements, which describe the notated ratio and visual grouping. Earlier production gates rejected every tuplet to avoid silent timing loss before the importer had a musical-time representation.

Phase 15 changed MusicXML compilation to quarter-note musical positions and a deterministic tempo map. With that model, a triplet note whose duration is two divisions out of six already occupies exactly one third of a quarter note regardless of its visual notation metadata.

Rejecting all such scores now blocks valid client imports without protecting playback truth.

## Decision
Measured tuplets are part of the production MusicXML subset.

- Canonical timing continues to come only from the note `duration` and current `divisions` value.
- `time-modification` is accepted when `actual-notes` and `normal-notes` are positive integers.
- `tuplet` notation is accepted for deterministic `start` and `stop` grouping markers.
- Invalid ratio metadata or unknown tuplet notation types fail closed with localized conformance diagnostics.
- Tuplet metadata never rescales a note a second time; doing so would double-apply the ratio because MusicXML duration already carries the measured playback length.
- Tempo-map integration remains authoritative when a tempo change occurs between tuplet notes.

## Consequences
- ordinary triplets and other measured n:m tuplets import instead of being rejected;
- tuplets coexist with tempo changes, voices, backup/forward, ties and the canonical playback kernel without a source-specific playback path;
- malformed tuplet metadata is surfaced deterministically rather than guessed;
- Legacy TXT/VPS, MIDI and Legacy x2 behavior are unchanged.

## Still fail-closed
Repeats/endings, ornaments, pedal notation, grace/cue/unpitched notes, instrument transposition metadata and score-timewise remain outside the supported production subset until separately modeled and regression-gated.
