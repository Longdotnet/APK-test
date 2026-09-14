---
schema: 1
version: 0.40.75
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
- The vocal stem remains authoritative for lead melody. Separated accompaniment is admitted only across sustained vocal-weak regions so instrumental intros, outros and hooks are less likely to disappear.
- Section fallback uses 400 ms windows and requires at least two consecutive eligible windows (about 0.8 seconds). Accompaniment is restrained to 0.24 gain, with 80 ms attack, 140 ms release and 0.98 peak protection.
- Existing melodic-periodicity gating continues to reject broadband/percussion-heavy fallback.
- v0.40.75 adds bass-dominance rejection: periodic accompaniment must now show credible lead-band periodicity that is not materially weaker than its bass-band periodicity before it can enter melody truth. Sustained bass lines can no longer unlock fallback merely because they are tonal and vocals are quiet.
- A lead hook mixed over restrained bass remains eligible, so bass suppression does not simply mute instrumental sections wholesale.
- Basic Pitch still runs once over the composed melody-focused source; canonical `PerformanceTrack` remains playback truth.
- First use downloads the pinned Windows sherpa-onnx runtime and Spleeter FP16 model archive into local caches. No Python, PyTorch, Node, Visual Studio, .NET SDK or manual model setup is required.
- The Spleeter archive remains fail-closed pinned to 35,271,738 bytes / SHA-256 `d54561979bd2e08a51e7dbd99ac36bb47564e089eefd403636dbca93e811bba2`.

## Musical quality evidence

- Existing pinned real Basic Pitch A/B remains protected: vocal melody identity stays **3/3 -> 3/3** while section-aware fallback recovers instrumental hook pitches **0/2 -> 2/2**.
- The same real-model fixture remains bounded at **3 -> 7 decoded notes**, with fallback active only across **6/12 windows (2.4 s of a 4.8 s fixture)** rather than contaminating the whole song.
- Deterministic Phase-0 regressions require a sustained low bass tone to reach RMS/source selection and then prove it is rejected specifically as bass-dominated.
- Companion regression proves a clear E4 lead hook remains admitted when a restrained E2 bass note is present underneath.
- Existing broadband/percussion rejection remains protected.
- Existing real 17.3-second CC0 mixed-song evidence remains protected: the Spleeter-first path previously reduced low-activation review regions from 3 to 1 while preserving the full timeline.
- Spleeter separation remains roughly 2-5 seconds warm-cache on the measured 8-logical-CPU Windows machine, versus roughly 108 seconds for the earlier CPU HTDemucs path.

## Diagnostics and cost

- Stem-composition diagnostics now distinguish energy-eligible, rejected-non-melodic and rejected-bass-dominated windows, alongside fallback windows/duration/gain and separation elapsed time. No raw private audio is logged.
- Bass rejection reuses the same bounded decimated autocorrelation analysis; it adds no separator/model/runtime download and no additional Basic Pitch inference.
- For long songs the managed PCM working set architecture is unchanged: at 22,050 Hz mono float, each four-minute full-length buffer is about 20 MiB. No-fallback composition reuses the vocal buffer; active fallback needs an additional output buffer.

## Validation

- Audio OSS gate validates pinned Basic Pitch readiness, decode/arrange regressions, generated MIDI parity, section-gating safety, anti-percussion gating, bass-dominance rejection and the real-model hook-recovery A/B.
- Production gate validates deterministic regressions, Windows client build, self-contained single-EXE publish, clean-machine smoke, STA UI startup, Windows input ABI and packaged Basic Pitch/ONNX smoke tests.

## Remaining Phase-0 quality gap

Phase 0 is still not complete. The next direct quality step is section-level dominant-melody selection with executable contour/onset evidence on broader legally usable weak-vocal, bass-heavy and fully instrumental fixtures. Bass rejection prevents an important class of false lead truth, but it does not yet identify every instrumental lead line or provide full-song ground truth across multiple genres.

## Troubleshooting

Source-separation or accompaniment-stem failures remain fail-visible instead of silently reverting to dense raw-full-mix transcription.