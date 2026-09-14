---
schema: 1
version: 0.40.72
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

- Normal desktop MP3 Create Piano Version now uses `sherpa-onnx v1.13.8` with the Spleeter 2-stem FP16 vocal model before Basic Pitch, replacing the multi-minute CPU HTDemucs path.
- Separated vocals are fed directly into Basic Pitch; accompaniment is not reintroduced into lead-note truth, so drums/bass cannot dominate the generated melody.
- First use downloads the pinned Windows sherpa-onnx runtime and Spleeter FP16 model archive into local caches. No Python, PyTorch, Node, Visual Studio, .NET SDK or manual model setup is required.
- The Spleeter archive is fail-closed pinned to the actual GitHub release asset: 35,271,738 bytes / SHA-256 `d54561979bd2e08a51e7dbd99ac36bb47564e089eefd403636dbca93e811bba2`.
- This release fixes a first-run blocker where sherpa-onnx's companion `checksum.txt` advertises stale bytes (`c6c5...`) that no longer match the official release asset served by GitHub.
## Quality evidence

- On a real 17.3-second CC0 mixed-song fixture from Free Music Archive, raw full-mix Basic Pitch produced 20 events and 3 low-activation review regions.
- Warm-cache Spleeter vocals-first reduced that to 1 review region while preserving the full 17.3-second timeline, with 28 decoded/events in the vocals-only path.
- Spleeter separation measured about 2-5 seconds on the local 8-logical-CPU Windows machine, versus about 108 seconds for CPU HTDemucs on the same song. The production separator therefore stays in the practical client latency class while still improving the low-confidence signal over raw full mix.
## Validation

- Audio OSS gate validates pinned Basic Pitch model readiness, stem fusion, decode/arrange regressions, generated MIDI parity and real-model quality evidence.
- Production gate validates the Windows client build, self-contained single-EXE publish, STA UI startup, Windows input ABI and packaged audio model/ONNX runtime smoke tests.

## Troubleshooting

Create Piano Version diagnostics report the input strategy and separation elapsed time without logging private audio. If source separation fails, the operation remains fail-visible instead of silently reverting to dense raw-full-mix transcription.
