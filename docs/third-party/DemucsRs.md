# demucs-rs / HTDemucs

RobloxPiano uses the native Windows CLI from `nikhilunni/demucs-rs` as a local source-separation sidecar before Basic Pitch transcription of user-owned full-song audio.

- Upstream: `nikhilunni/demucs-rs`
- Pinned release: `v0.3.4`
- Runtime asset: `demucs-x86_64-pc-windows-msvc.zip`
- Runtime archive SHA-256: `67e77186295a00758df0b760f3345fd0b9081b328f923ecc35307f6190f472d1`
- License: Apache License 2.0
- Model: `htdemucs`, 4 stems (`drums`, `bass`, `other`, `vocals`)
- Model cache identity enforced by RobloxPiano: 84,030,696 bytes / SHA-256 `8193504cdfb3943adaf039b8acb524a46e87ebf232c383ac7a32c80a6578423e`
- Model lineage: Meta Research Demucs / HTDemucs, whose upstream project is MIT licensed.

The released `RobloxPiano.exe` does not embed the demucs-rs executable or HTDemucs model. On first use of source separation it downloads the pinned Windows engine and the upstream CLI downloads the pinned model, after which RobloxPiano verifies the expected bytes before accepting output. No Python or PyTorch runtime is required.

`demucs-rs` owns only source separation. RobloxPiano owns stem selection/mixing, Basic Pitch transcription, deterministic arrangement, canonical `PerformanceTrack`, Library persistence and Roblox playback truth.

The production stem policy deliberately excludes the separated drums and bass from Basic Pitch input. Vocals remain at full gain and the `other` stem is reintroduced at a restrained deterministic gain to recover useful harmony without allowing percussion/bass energy to become lead truth.
