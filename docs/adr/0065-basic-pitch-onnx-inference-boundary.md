# ADR 0065: Basic Pitch ONNX inference boundary

## Status
Accepted.

## Context
Audio-to-Piano Phase 01 established deterministic mono 22.05 kHz ingest. The next production boundary is Automatic Music Transcription model inference. Reimplementing Spotify Basic Pitch's neural network is unnecessary and would add correctness risk; shipping Python/TensorFlow/PyTorch to clients would violate the self-contained Windows product goal.

## Decision
Use Spotify Basic Pitch's Apache-2.0 ICASSP 2022 `nmp.onnx` model through Microsoft's MIT-licensed `Microsoft.ML.OnnxRuntime` .NET package.

The inference boundary preserves upstream semantics:

- input `serving_default_input_2:0`;
- outputs `StatefulPartitionedCall:1` (note), `StatefulPartitionedCall:2` (onset), and `StatefulPartitionedCall:0` (contour);
- mono 22,050 Hz input;
- 43,844-sample windows (`2 * 22050 - 256`);
- 30 annotation-frame overlap, corresponding to 7,680 audio samples;
- 3,840 zero samples prepended before chunking;
- output overlap trimmed equally from both sides;
- 88 note/onset bins and 264 contour bins;
- final output trimmed to the original audio's annotation-frame length using Spotify's integer 86 FPS contract.

`BasicPitchInferenceService` reuses one `InferenceSession` for repeated calls. Long audio is sent to ONNX Runtime in bounded chunk batches rather than allocating one unbounded model batch for an entire song.

## Model provenance
CI downloads the model from pinned Spotify Basic Pitch commit `fa5997af0a8210982619003269994a1be25eddf3` and verifies both:

- Git blob ID `c30e5f9438e798604b7177aa26be1fe64482f767`;
- byte length `230444`.

This phase does not yet redistribute the model inside `RobloxPiano.exe`; production embedding/package provenance is a later client-impacting slice. The CI real-model gate proves the C# inference path against the actual pinned model now.

## Architecture boundary
The output is immutable raw activation evidence only (`note`, `onset`, `contour`). Model output does not mutate canonical `PerformanceTrack` state and does not own Roblox playback. Note-event decoding, arrangement, confidence/review, and canonical adaptation are later deterministic layers.

## Failure behavior
The boundary fails closed for wrong sample rate, empty/non-finite input, missing model tensor names, unexpected output shapes, malformed output lengths, and invalid batch configuration. Cancellation is observed between bounded inference batches.

## Regression protection
`RobloxPiano.AudioTests` verifies the exact chunk/overlap constants and executes a real inference against the pinned ONNX model in `audio-oss-gate`. The gate verifies output frame/bin shapes and finite probability-range activations.
