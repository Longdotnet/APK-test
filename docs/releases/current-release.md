---
schema: 1
version: 0.40.73
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

## Full-song MP3/WAV -> recognizable piano

- Normal desktop MP3/WAV Create Piano Version uses `sherpa-onnx v1.13.8` with the Spleeter 2-stem FP16 model before Basic Pitch.
- The vocal stem remains authoritative for lead melody. The separated accompaniment is admitted only across sustained vocal-weak regions so instrumental intros, outros and hooks are less likely to disappear.
- Section fallback uses 400 ms analysis windows and requires at least two consecutive eligible windows (about 0.8 seconds). Accompaniment is restrained to 0.24 gain, with 80 ms attack, 140 ms release and 0.98 peak protection.
- Short breaths and isolated accompaniment/percussion bursts do not unlock fallback. There is no wholesale raw-full-mix fallback.
- Basic Pitch still runs once over the composed melody-focused source; canonical `PerformanceTrack` remains the playback truth.
- First use downloads the pinned Windows sherpa-onnx runtime and Spleeter FP16 model archive into local caches. No Python, PyTorch, Node, Visual Studio, .NET SDK or manual model setup is required.
- The Spleeter archive remains fail-closed pinned to 35,271,738 bytes / SHA-256 `d54561979bd2e08a51e7dbd99ac36bb47564e089eefd403636dbca93e811bba2`.

## Musical quality evidence

- Pinned real Basic Pitch A/B on separated melody/hook evidence keeps vocal melody identity at **3/3 -> 3/3** while recovering instrumental hook pitches from **0/2 -> 2/2**.
- The same A/B grows decoded notes from **3 -> 7**, within the bounded anti-note-spray budget, and enables fallback for only **6/12 windows (2.4 s of a 4.8 s fixture)** rather than contaminating the whole song with accompaniment.
- Existing real 17.3-second CC0 mixed-song evidence remains protected: the Spleeter-first path previously reduced low-activation review regions from 3 to 1 while preserving the full timeline.
- Spleeter separation remains roughly 2-5 seconds warm-cache on the measured 8-logical-CPU Windows machine, versus roughly 108 seconds for the earlier CPU HTDemucs path.

## Diagnostics and cost

- Create Piano diagnostics now identify `vocal-priority+section-fallback`, fallback windows/duration/gain and separation elapsed time without logging private audio.
- This release adds no separator model/runtime download and no additional Basic Pitch inference. It does decode the existing accompaniment stem and performs one bounded O(N) section-composition pass before inference.
- For long songs the extra managed PCM working set is visible: at 22,050 Hz mono float, each four-minute full-length buffer is about 20 MiB. No-fallback composition reuses the vocal buffer; active fallback needs an additional output buffer.

## Validation

- Audio OSS gate validates pinned Basic Pitch readiness, decode/arrange regressions, generated MIDI parity, section-gating safety and the real-model hook-recovery A/B.
- Production gate validates deterministic regressions, Windows client build, self-contained single-EXE publish, clean-machine smoke, STA UI startup, Windows input ABI and packaged Basic Pitch/ONNX smoke tests.

## Remaining Phase-0 quality gap

This is a production recognizability improvement, not the end of Phase 0. Broader legally usable full-song coverage is still required, especially weak-vocal, percussion-heavy, bass-heavy and fully instrumental songs. Instrumental songs may need deterministic dominant-melody source selection rather than treating accompaniment as a generic fallback.

## Troubleshooting

Source-separation or accompaniment-stem failures remain fail-visible instead of silently reverting to dense raw-full-mix transcription.