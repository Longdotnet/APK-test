---
schema: 1
version: 0.40.71
---
# Roblox Piano v{{VERSION}}

Validated commit: `{{COMMIT_SHA}}`
Distribution: self-contained Windows x64 single executable
Client dependencies: none required manually
SHA256: `{{SHA256}}`

## Client entrypoint and support contract

- **Sheet Library** remains the normal client starting point.
- **Support Bundle** remains the preferred playback/support evidence export path.
- Legacy and **Legacy x2** remain protected regression/perceptual baselines.

## Full-song MP3 -> recognizable piano

- Normal desktop MP3 Create Piano Version now uses the pinned native `demucs-rs v0.3.4` / `htdemucs` separator before Basic Pitch instead of treating the complete mixed spectrum as note truth.
- The lead/vocal stem remains dominant while the separated `other` stem is reintroduced at a restrained deterministic `0.22` gain so useful chord identity can survive without letting drums or bass dominate the melody.
- The separated bass stem is not fed into Basic Pitch, and the production separator does not request the drums stem for transcription.
- The stem mix applies deterministic peak protection before the existing Basic Pitch, harmonic suppression, Roblox density/range reduction and canonical `PerformanceTrack` stages.
- First source-separation use downloads the pinned Windows separator and HTDemucs model into local caches; RobloxPiano verifies their expected identities. No Python, PyTorch, Node, Visual Studio, .NET SDK or manual model setup is required.
- Corrected the HTDemucs provenance pin to the actual upstream 84,030,696-byte model with SHA-256 `8193504cdfb3943adaf039b8acb524a46e87ebf232c383ac7a32c80a6578423e`, preventing a successful separator run from being rejected afterward.
- Embedded third-party notices now include the separator and HTDemucs/Demucs model lineage.

## Quality evidence

- Pinned Basic Pitch A/B preserves the three lead notes from the vocals-only control and recovers all three tested accompaniment chord tones after restrained stem fusion.
- The A/B decoded-note count is bounded at `7 -> 14`, demonstrating added harmony without returning to unconstrained full-mix note spray.
- Audio OSS regression coverage includes deterministic stem balance, clipping protection, cancellation-safe bounded mixing and the existing decode/arrange pipeline.

## Validation

- Audio OSS gate validates pinned Basic Pitch model readiness, stem fusion, decode/arrange regressions, generated MIDI parity and real-model quality evidence.
- Production gate validates the Windows client build, self-contained single-EXE publish, STA UI startup, Windows input ABI and packaged audio model/ONNX runtime smoke tests.

## Troubleshooting

Create Piano Version diagnostics report the input strategy and separation elapsed time without logging private audio. If source separation fails, the operation remains fail-visible instead of silently reverting to dense raw-full-mix transcription.
