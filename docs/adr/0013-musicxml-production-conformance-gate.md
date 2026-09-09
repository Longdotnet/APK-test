# ADR 0013: MusicXML production conformance gate

## Status
Accepted for production phase 14.

## Context
Phase 13 introduced deterministic score-partwise MusicXML ingestion, but MusicXML contains constructs whose audible meaning cannot be preserved by the current canonical importer. Silently ignoring repeats, endings, tuplets, ornaments, pedal notation, grace/cue/unpitched notes, direction offsets, transposition metadata, or timing combinations that the importer cannot model would create the worst client failure mode: a file appears to import successfully but plays the wrong song.

A specific correctness hazard exists when a measure combines multiple tempo changes with `backup`/multi-voice navigation. The current importer advances a seconds-based cursor. Rewinding a divisions duration using only the current tempo can misalign a second voice relative to the first voice after an intra-measure tempo change.

## Decision
The production client boundary performs a deterministic conformance analysis before compiling MusicXML to `PerformanceTrack`.

The analyzer returns stable diagnostics with codes, severity, message, part and measure. Constructs that can change audible pitch, order, duration, repetition, sustain or timing but are not yet modeled are errors rather than warnings. Client loading fails closed on the first deterministic production error.

The initial blocking set includes:

- repeats and alternate endings;
- tuplets/time-modification;
- ornaments;
- pedal notation;
- grace, cue and unpitched notes;
- direction offsets;
- instrument transpose metadata;
- multiple tempo changes in a measure that also uses `backup`.

This gate is deterministic, offline and independent of AI/network availability. It does not alter Legacy or MIDI playback baselines.

## Consequences
Clients receive an actionable error instead of subtly incorrect playback. Unsupported MusicXML can be expanded incrementally only after a construct has a deterministic canonical representation and regression coverage. The conformance API can later drive a richer import-review UI without moving source-specific semantics into playback.
