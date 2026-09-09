# ADR 0018: Deterministic MusicXML repeat normalization

## Status
Accepted for production client v0.15.0.

## Context
The canonical MusicXML timing compiler intentionally failed closed on repeat and ending markup because silently ignoring structural playback controls changes the song. That protected correctness, but it also rejected common scores whose musical notes/timing were otherwise already supported.

Repeats are score-structure semantics, not playback-engine semantics. The canonical performance timeline and Windows input backend must remain unaware of MusicXML repeat syntax.

## Decision
Add a production MusicXML normalization boundary before conformance and canonical timing compilation.

Supported subset:
- forward/backward two-pass repeats;
- backward repeat without an explicit forward marker repeats from score start;
- first and second endings;
- sequential, non-nested repeat regions.

The normalizer clones and linearizes measures, strips only handled `repeat`/`ending` control markup, then passes the normalized score through the existing production conformance gate and MusicXML importer. Desktop `SongSourceLoader` uses this production boundary for both sync and async paths.

Fail closed for:
- nested repeats;
- repeat counts other than two;
- malformed/unclosed ending ranges;
- ending numbers other than 1 or 2;
- invalid repeat direction/type metadata.

A deterministic expansion safety bound prevents malformed structure from becoming an unbounded loop.

## Consequences
Canonical `PerformanceTrack`, playback kernel, Legacy/Legacy x2 baseline, MIDI ingestion, focus guard and Windows input safety remain unchanged. Common repeated MusicXML scores become playable without teaching the playback engine about notation structure.

Da capo/dal segno/coda, arbitrary repeat counts, nested repeats and complex ending schemes remain unsupported until each can be modeled and regression-tested without guessing.

## Validation
A dedicated repeat regression harness covers simple repeats, first/second endings, sequential repeats, implicit score-start repeats, unsupported structures and the actual desktop/library loading boundary. Production gate and production release both run this harness before publishing the single-EXE client.
