# ADR 0147: Confidence-gated melody continuity for full-song mixtures

## Status

Accepted.

## Context

The original deterministic Roblox arranger protected the highest mapped pitch whenever an onset cluster exceeded the playable density limit. That skyline rule is cheap and useful for clean piano material, but it is too optimistic for mixed full-song audio: Spotify Basic Pitch is polyphonic and instrument-agnostic yet explicitly works best on one instrument at a time, so dense mixtures can contain weak high harmonics or unrelated upper voices alongside a stronger melodic contour.

Protecting the absolute highest pitch regardless of activation can therefore discard a more plausible melody note while retaining a low-confidence overtone. Shipping source separation to every client is not justified until deterministic post-processing is shown to be insufficient, and Python/PyTorch Demucs remains outside the production packaging contract.

## Decision

`RobloxPianoArranger` keeps the existing canonical `PerformanceTrack` boundary but strengthens melody selection before density reduction:

- each onset cluster first deduplicates octave-folded mapped pitches exactly as before;
- a melody candidate must pass both an absolute Basic Pitch activation floor and a relative-to-cluster activation floor when possible;
- if the absolute skyline note fails that credibility gate, it is not protected solely because it is highest;
- the first credible cluster uses the highest credible pitch as the deterministic melody seed;
- adjacent clusters inside a bounded continuity window prefer the credible pitch nearest the previous melody, prioritizing candidates inside a bounded semitone leap before activation/duration/pitch tie-breakers;
- density reduction then preserves that selected melody and fills remaining slots with the strongest accompaniment candidates;
- `WeakSkylineRejects` and `MelodyContinuitySelections` diagnostics expose when the stronger policy materially changed the old skyline choice;
- invalid melody thresholds fail closed during options validation;
- timing, durations, range folding, same-key ownership repair, canonical event creation and Windows input behavior remain unchanged.

Defaults are intentionally conservative: 0.25 absolute activation floor, 0.55 relative activation floor, 12-semitone continuity leap and a 1.5-second continuity window. These values are deterministic arrangement policy, not claims of source-separation or waveform identity.

## Validation

Regression fixtures cover two full-mixture failure shapes that the previous rule could not represent safely:

1. a very weak upper overtone above a strong chord must be dropped under density pressure instead of being protected as melody;
2. a credible melody moving from MIDI 72 to 74 must survive the next dense cluster even when a higher competing MIDI-84 voice has slightly greater activation.

Existing octave folding, duplicate mapped-pitch merging, same-key overlap safety, low-confidence review diagnostics, cancellation, real-model Basic Pitch E2E and generated-MIDI parity remain gates.

## OSS comparison and packaging impact

Spotify Basic Pitch remains the transcription/model-semantics source and exposes note-event amplitude in the 0..1 range. Mature melody-extraction work such as Melodia reinforces that melody extraction from polyphonic mixtures is a distinct problem rather than equivalent to choosing the highest simultaneous pitch. The production implementation does not copy Melodia or add a new dependency; it uses bounded deterministic policy over already-decoded Basic Pitch notes.

No new NuGet package, native runtime or model is added. NAudio, ONNX Runtime, Basic Pitch and DryWetMIDI attribution remains unchanged. Python, PyTorch, ffmpeg and Demucs are not added to the client.

## Authority boundary

The arranger may select which decoded notes survive density reduction, but its output is immediately adapted into the existing canonical `RobloxPiano.Core.PerformanceTrack`. It does not schedule playback, select Roblox windows, inject keys, own held-key/pedal state or authorize input. Runtime Input P0 remains a separate field gate.
