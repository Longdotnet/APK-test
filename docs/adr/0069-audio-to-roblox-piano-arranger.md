# ADR 0069: Deterministic Audio-to-Roblox piano arranger

## Status

Accepted.

## Context

Audio-to-Piano OSS Phases 01-03 established a production boundary from client-owned audio through NAudio normalization, Spotify Basic Pitch ONNX inference, and deterministic Basic Pitch note decoding. The resulting `BasicPitchTranscribedNote` values still describe piano pitches in a broad MIDI range and can contain dense polyphony, octave-equivalent collisions after range fitting, very short notes, overlapping ownership of the same eventual Roblox key, and low-activation events that should not be silently presented as high-confidence output.

The canonical playback model already exists in `RobloxPiano.Core`. Import/transcription code must adapt into that model rather than creating a parallel scheduler or input path.

## Decision

`RobloxPiano.Audio` references `RobloxPiano.Core` and owns a deterministic `RobloxPianoArranger` that converts decoded Basic Pitch notes directly into canonical `PerformanceTrack` events using the existing `MidiKeyboardProfile.RobloxClassic61` mapping.

The arranger:

- preserves source timing and positive duration;
- applies explicit transpose before range handling;
- octave-folds out-of-range notes by 12-semitone steps so pitch class is preserved inside the active 61-key Roblox profile;
- can fail/drop out-of-range notes deterministically when octave folding is disabled;
- rejects very short events before playback;
- groups near-simultaneous onsets into a small deterministic window;
- merges duplicate mapped pitches produced by octave folding, keeping the strongest/longest candidate;
- limits onset density while always preserving the highest mapped pitch as a melody-priority note, then keeps the strongest remaining accompaniment;
- prevents overlapping ownership of the same Roblox key by trimming or suppressing the earlier event before canonical playback edges are built;
- records arrangement diagnostics for folding, density reduction, duplicate merges, range drops, duration drops, overlap repair, and low-activation events;
- surfaces `RequiresReview` when deterministic quality evidence indicates density/range loss or low activation;
- honors cancellation and never schedules Windows input itself.

The output is the same `PerformanceTrack` consumed by existing playback, quality, timing, focus and stuck-key safety infrastructure. Metadata BPM is explicitly nominal until a later beat/tempo-analysis phase supplies measured tempo; absolute event timing remains authoritative.

## Consequences

The production architecture is now:

`client-owned audio -> NAudio normalize -> Basic Pitch ONNX -> deterministic note decoder -> deterministic Roblox piano arranger -> canonical PerformanceTrack -> existing playback kernel`.

This phase does not change `RobloxPiano.exe`, does not bundle the Basic Pitch model into the client, and does not modify Windows/Roblox input P0 behavior. It creates the first deterministic bridge from audio transcription into the same canonical track model used by existing MIDI/MusicXML flows.

Regression coverage protects classic-61 octave folding, melody-priority density limiting, folded-pitch deduplication, same-key overlap safety, low-activation review diagnostics, and cancellation.

## OSS / licensing impact

No new third-party package or copied upstream source is introduced in this phase. The arranger is Roblox-specific domain policy built over the existing canonical model. Existing NAudio (MIT), ONNX Runtime (MIT), and Basic Pitch (Apache-2.0 model/behavior reference) attribution remains unchanged.
