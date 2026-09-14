# ADR 0165: Lead-first separated-stem fusion in production Audio-to-Piano

## Context

`main` already routes normal desktop MP3 Create Piano Version through pinned `demucs-rs v0.3.4` / `htdemucs` source separation before Basic Pitch. That removed drums/bass/accompaniment from melody truth, but the first production integration transcribed only `vocals.wav`. A vocals-only piano can preserve the sung lead while losing enough chord identity that a full-song arrangement becomes thin or less recognizable.

The separator also emits `other.wav` and `bass.wav`. The product goal is a piano reduction, not a vocal transcription and not a reconstruction of the original waveform. Bass and drums must not regain control of lead-note truth.

## Decision

For separated full-song input, normalize `vocals.wav` and `other.wav` independently to the Basic Pitch sample rate, then build one deterministic lead-first transcription input:

- vocals gain: `1.00`;
- other gain: `0.22`;
- bass: excluded;
- drums: not requested from the production separator invocation;
- peak protection: if the deterministic sum exceeds `0.98`, scale the complete mixed stem input uniformly so relative balance is preserved.

Basic Pitch continues to run once on the bounded normalized result. Existing harmonic suppression, Roblox arrangement policy, quality/review gates and canonical `PerformanceTrack` remain authoritative. No third-party playback engine is introduced.

The `0.22` accompaniment gain is guarded by executable pinned-model evidence. The synthetic separated-stem A/B preserves all three lead pitches, recovers all three accompaniment chord tones, and keeps decoded-note growth bounded (`7 -> 14` notes in the current fixture) instead of reintroducing the raw full-mix note spray.

## Provenance correction

The production separator obtains `htdemucs.safetensors` from the URL declared by `demucs-rs v0.3.4`. The current upstream artifact is 84,030,696 bytes with SHA-256 `8193504cdfb3943adaf039b8acb524a46e87ebf232c383ac7a32c80a6578423e`. The prior integration pinned different bytes and would reject the model after successful separation. Production now pins the actual upstream artifact and retains fail-closed hash verification.

`demucs-rs` is Apache-2.0. The HTDemucs weights are derived from the MIT-licensed Demucs project and are distributed by the upstream model host under MIT metadata. RobloxPiano does not embed the separator or model in `RobloxPiano.exe`; first use downloads/caches them locally and verifies the pinned identities. Runtime attribution is included in the embedded third-party notices.

## Consequences

The normal MP3 path now becomes: local song -> Demucs stems -> vocals + restrained `other` -> Basic Pitch -> deterministic reduction -> canonical `PerformanceTrack`. The release remains a single `RobloxPiano.exe`; the local separator/model cache is an on-demand runtime dependency, not a user-installed developer tool.

Measured local cache footprint for the current Windows deployment is approximately 33,881,088 bytes for `demucs.exe` plus 84,030,696 bytes for `htdemucs.safetensors` (about 118 MB total). No Python, PyTorch, Node, SDK or FFmpeg installation is required from the user.

Source separation remains a quality boundary only. It does not own Library persistence, Roblox scheduler/focus/input behavior, held-key state or playback truth.
