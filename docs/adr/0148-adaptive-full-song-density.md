# ADR 0148: Adaptive accompaniment density for mixed full-song transcription

## Status

Accepted.

## Context

Phase 57 improved deterministic melody protection for dense Basic Pitch onset clusters, but the hard density cap still filled every available Roblox chord slot with the strongest remaining notes. That is safe for clean piano material, yet full mixed recordings can contain many low-activation accompaniment, bleed or harmonic candidates. Filling six slots merely because six slots are available can make a generated Roblox piano version noisier and less recognizable.

Spotify Basic Pitch is instrument-agnostic and polyphonic but explicitly works best on one instrument at a time. Its note-event amplitude is therefore useful confidence evidence, not proof that every decoded simultaneous pitch belongs in a piano arrangement. Source separation remains intentionally deferred until deterministic post-processing is shown to be insufficient.

## Decision

`RobloxPianoArranger` keeps `MaxSimultaneousNotes` as an absolute hard cap and adds a conservative adaptive accompaniment policy only when a deduplicated onset cluster already exceeds that cap:

- the Phase-57 confidence-gated/continuity-selected melody is always protected;
- accompaniment candidates must pass both an absolute activation floor and a relative-to-cluster activation floor before consuming one of the remaining Roblox chord slots;
- sparse clusters at or below the hard cap are never thinned by this policy;
- dense clusters containing strong harmony may still fill the entire hard cap;
- callers can disable adaptive density to retain the previous fixed-cap behavior for controlled parity/debugging;
- `AdaptiveDensityDrops` reports notes removed beyond the mandatory hard-cap overflow, while `DensityDrops` continues to report all density removals;
- invalid thresholds fail closed during options validation.

The default accompaniment floors are deliberately permissive: 0.18 absolute activation and 0.35 relative to the strongest note in the cluster. They are deterministic arrangement policy, not a source-separation claim.

## Validation

Regression coverage models three production-relevant shapes:

1. a sparse verse within the hard cap must remain untouched;
2. a dense chorus with four strong musical voices plus weak mixed-audio clutter must retain the melody/strong harmony while dropping weak slot-fillers;
3. a dense all-strong harmony must still use the configured hard cap, proving adaptive density does not flatten strong chords.

A parity fixture also disables adaptive density and verifies the prior fixed-cap count, and threshold validation remains fail-closed.

## OSS comparison and packaging impact

Spotify Basic Pitch remains the transcription/model-semantics source. Its public note-event contract exposes amplitude in the 0..1 range, which is reused as bounded deterministic evidence. Microsoft ONNX Runtime, NAudio and DryWetMIDI remain unchanged. No upstream source is copied and no new model/runtime/library is introduced.

Python, PyTorch, ffmpeg and Demucs are still not shipped. There is no new third-party license or NOTICE obligation.

## Authority boundary

Adaptive density can only decide which already-decoded notes survive deterministic arrangement. The result is still adapted immediately into `RobloxPiano.Core.PerformanceTrack`, which remains canonical playback truth. This change does not touch the scheduler, focus guard, Roblox target selection, held-key/pedal ownership or Windows input authorization. Runtime Input P0 remains a separate field gate.
