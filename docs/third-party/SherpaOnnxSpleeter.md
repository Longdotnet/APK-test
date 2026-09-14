# sherpa-onnx / Spleeter source separation

RobloxPiano uses the native Windows CLI distributed by `k2-fsa/sherpa-onnx` as a local source-separation sidecar before Basic Pitch transcription of user-owned full-song audio.

- Runtime upstream: `k2-fsa/sherpa-onnx`
- Pinned runtime: `v1.13.8`, Windows x64 shared MD no-TTS archive
- Runtime archive SHA-256: `876e6b89b8cf84a3a1b375a397507f2cfe9c227c2a945411a11a668475fcb5d3`
- Runtime license: Apache License 2.0
- Model: Spleeter 2-stem FP16 (`vocals`, `accompaniment`), distributed by sherpa-onnx
- Model archive: 35,271,738 bytes / SHA-256 `d54561979bd2e08a51e7dbd99ac36bb47564e089eefd403636dbca93e811bba2`
- Model lineage: Deezer Spleeter; upstream Spleeter source code is MIT licensed.

The release EXE does not embed the sherpa-onnx runtime or Spleeter model archive. First use downloads them into RobloxPiano's local cache and verifies pinned identities before accepting separated output. No Python/PyTorch runtime or manual model setup is required.

The upstream sherpa-onnx release currently serves model-archive bytes whose SHA-256 differs from its companion `checksum.txt`. RobloxPiano pins the release asset bytes observed from GitHub instead of trusting the stale checksum file, while retaining exact length + SHA-256 verification.

Source separation owns only stem generation. RobloxPiano owns stem selection, Basic Pitch transcription, deterministic arrangement, canonical `PerformanceTrack`, Library persistence and Roblox playback truth.
