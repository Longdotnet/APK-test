# ADR 0057: Deterministic reference-audio timeline alignment

## Status

Accepted.

## Context

Phase 51 established deterministic local extraction of onset and tempo evidence from explicitly supported PCM16 WAV reference audio. The next production need is to compare that immutable reference evidence with the canonical performance timeline without introducing an audio/AI dependency into playback truth.

A useful comparison must distinguish a constant recording offset from residual timing error, bind results to exact reference bytes/features and canonical performance identity, account for playback speed, and fail closed when required evidence is absent or malformed.

## Decision

Add `ReferenceAudioTimelineAligner` in `RobloxPiano.Core` as evidence-only infrastructure.

The aligner:

- accepts an already verified `ReferenceAudioAnalysis`, a canonical `PerformanceTrack`, and an explicit playback speed;
- converts canonical event starts into candidate onsets at that speed without mutating the track;
- searches a bounded ±2000 ms global offset on a fixed 10 ms grid;
- performs monotonic one-to-one onset matching with a fixed 120 ms tolerance;
- selects the alignment by highest matched count, then lowest mean residual error, then smallest absolute offset, with deterministic tie-breaking;
- records match coverage, recovered offset, mean and P95 residual timing error, and candidate/reference tempo ratio;
- binds the evidence to reference content SHA-256, reference feature SHA-256, canonical track SHA-256 and playback speed;
- emits and verifies a separate evidence SHA-256 over all normalized fields.

The verifier fails closed on unsupported schema, malformed hashes, impossible counts/ranges, inconsistent coverage or modified evidence.

## Safety and ownership boundary

Reference alignment is diagnostics evidence only. It MUST NOT:

- mutate canonical events or importer output;
- control Play/Pause/Stop/Seek or speed;
- authorize a Roblox process or dispatch/release keyboard/pedal state;
- select or promote a playback engine;
- promote Legacy x2 over Legacy;
- call AI, network services, codec services or external runtimes.

A good alignment score is not by itself a perceptual-quality verdict. It only proves deterministic timing relationship between detected reference onsets and canonical event starts under the stated speed and bounded alignment policy.

## Regression requirements

Production regression coverage must prove deterministic repeated evidence, recovery of a known constant offset without track mutation, speed-sensitive evidence/tempo ratio, and fail-closed rejection of tampered evidence.

Any future semantic change to alignment search grid, tolerance, matching policy, metric definitions or evidence canonicalization requires a schema/version boundary rather than silently reinterpreting historical evidence.
