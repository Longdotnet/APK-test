# ADR 0152: Mixed-song chorus harmony voicing

## Status

Accepted.

## Context

Phase 61 real-model mixed-instrument evidence retained all recognized melody and 75% of recognized harmony overall, but the dense chorus retained only 2/4 recognized harmony notes. Phase 62 then made the audio regression harness fail closed, so that weakness can now be treated as an authoritative product-quality signal rather than a best-effort log.

Spotify Basic Pitch is instrument-agnostic and polyphonic, but its own project documentation notes that it works best on one instrument at a time. In a full-song mixture, near-confidence octave/harmonic activations can therefore compete with useful chord tones. The Roblox arranger has a hard simultaneous-note budget, so pure activation ranking can spend a scarce slot on a redundant octave while dropping a useful bass/root or another pitch class.

The goal is not to infer musical truth from a waveform after the fact. It is to make deterministic, bounded use of the note evidence already emitted by Basic Pitch while keeping `RobloxPiano.Core.PerformanceTrack` authoritative.

## Decision

For dense clusters that already exceed `MaxSimultaneousNotes` and pass adaptive accompaniment confidence filtering:

1. Preserve the existing protected melody decision unchanged.
2. Reserve the lowest accompaniment as a bass/harmonic anchor only when its activation is at least 55% of the strongest surviving accompaniment.
3. Group remaining accompaniment by pitch class. Within a pitch class, if a lower octave representative is within 85% of the strongest representative's activation, prefer the lower representative.
4. Fill remaining scarce accompaniment slots with distinct pitch classes before redundant octave representatives.
5. If slots remain, fall back to the existing deterministic confidence ordering.
6. Never exceed the existing hard simultaneous-note cap and never synthesize a note that Basic Pitch did not decode.

`HarmonyVoicingSelections` records clusters where this policy changes the previous pure-activation baseline. Both new relative thresholds validate fail-closed in `(0, 1]`.

## Real-model quality gate

The redistributable mixed-instrument fixture remains the decision evidence for whether native source separation is justified. Phase 63 tightens it to require:

- recognized melody retention >= 85%;
- recognized harmony retention >= 75% overall;
- chorus recognized harmony evidence >= 4 notes;
- chorus recognized harmony retention >= 75%;
- clutter suppression >= 25%;
- no increase in unmatched arranged events;
- event count not greater than source decoded event count.

The source-separation decision gate now treats chorus harmony retention below 75% as evidence to benchmark a native separation path. If the deterministic voicing meets the floor, Demucs remains deferred.

## OSS and licensing impact

Spotify Basic Pitch remains the model and transcription-semantics reference. Microsoft ONNX Runtime, NAudio and DryWetMIDI boundaries remain unchanged. No upstream source code is copied by this phase, and no new package, model, native runtime, Python, PyTorch, ffmpeg or Demucs artifact is distributed. There is therefore no new third-party license or NOTICE obligation.

## Runtime Input boundary

This decision changes audio arrangement only. It does not modify Roblox target discovery, focus guards, input authorization, scheduler, held-key/pedal ownership, Windows key injection or emergency release behavior. Runtime Input remains `NOT YET PROVEN` until the separate field gate is explicitly satisfied.
