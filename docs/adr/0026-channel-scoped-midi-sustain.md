# ADR 0026 — Channel-scoped MIDI sustain lowering

## Status

Accepted for production v0.17.0.

## Context

Standard MIDI files can carry melodic notes on multiple channels while CC64 sustain is meaningful only for one or some of those channels. Roblox Piano's canonical expressive control model intentionally represents sustain as a global control because the playback kernel targets one physical Roblox keyboard, not MIDI channels.

Previously the MIDI importer rejected every file that combined sustain with more than one note-bearing channel. That was safe but unnecessarily excluded common exported/arranged MIDI. Converting all channel CC64 events into one global pedal stream would be worse: a pedal on channel 1 could incorrectly extend notes from channel 2 and create stuck/retrigger problems.

## Decision

Keep the existing single-channel sustain path unchanged as a regression baseline. When a MIDI contains multiple note-bearing channels and at least one relevant CC64 stream:

1. parse and validate notes, tempo, range policy, percussion filtering and transpose exactly as before;
2. normalize CC64 state independently per MIDI channel;
3. deterministically extend each note only according to sustain state on that note's own channel;
4. repair an unterminated SustainDown by extending to the MIDI timeline end, matching the existing expressive compiler safety behavior;
5. clip an extended note at the next NoteOn of the same effective pitch across all channels so the single Roblox key can be physically retriggered;
6. lower the result into ordinary duration-aware `PerformanceEvent` values and emit no global sustain controls for that multi-channel case.

Malformed per-channel pedal state still fails closed. In particular, a SustainUp with no preceding SustainDown is rejected instead of guessed.

## Consequences

- multi-channel MIDI with channel-local sustain can enter the normal deterministic Library/playback flow;
- sustain on one channel cannot silently over-sustain another channel;
- the playback kernel, transport, Windows input backend and AI boundary remain unchanged and source-agnostic;
- same-pitch cross-channel retriggers retain KeyUp-before-KeyDown safety;
- existing single-channel sustain output remains on the previously tested canonical expressive path;
- the lowering loses MIDI channel identity after import by design because the production canonical playback model represents the one Roblox keyboard, not a multitimbral synthesizer.

## Rejected alternatives

- **Merge all CC64 streams into global sustain:** deterministic but musically incorrect and prone to over-sustain.
- **Teach the playback kernel MIDI channels:** violates the source-neutral canonical architecture.
- **Continue rejecting all multi-channel sustain MIDI:** safe but causes avoidable real-client import failures for common files.
