# Spotify Basic Pitch

RobloxPiano uses the Spotify Basic Pitch ICASSP 2022 ONNX model and follows its published preprocessing/inference tensor contract for Automatic Music Transcription.

- Upstream: `spotify/basic-pitch`
- Pinned source commit used by CI: `fa5997af0a8210982619003269994a1be25eddf3`
- Model path upstream: `basic_pitch/saved_models/icassp_2022/nmp.onnx`
- Model Git blob: `c30e5f9438e798604b7177aa26be1fe64482f767`
- License: Apache License 2.0
- Copyright: Spotify AB
- Purpose here: audio-to-note/onset/contour model inference only.

Basic Pitch does not own RobloxPiano playback truth. Its model output is evidence consumed by deterministic repository-owned postprocessing and canonical performance adapters.

If the Basic Pitch model or adapted upstream code is redistributed with a client artifact, retain the Apache-2.0 license and applicable attribution/NOTICE requirements.
