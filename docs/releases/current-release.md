---
schema: 1
version: 0.40.77
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
- Section fallback still uses 400 ms windows and requires at least two consecutive eligible windows (about 0.8 seconds), with 80 ms attack, 140 ms release and 0.98 peak protection.
- Melodic-periodicity, bass-dominance and dominant-contour continuity gates continue to decide whether an accompaniment section is credible lead material.
- v0.40.77 changes what happens after a section passes those gates: production no longer feeds the entire accompaniment waveform into Basic Pitch. Each accepted window becomes a deterministic monophonic lead guide at the detected pitch, snapped to the nearest equal-tempered piano semitone and scaled from that window's accompaniment RMS.
- The pitch guide removes residual chord, bass and percussion waveform before the existing Basic Pitch pass while preserving section timing. This matches Roblox piano's discrete semitone output domain instead of quantizing timing or section boundaries.
- If an active pitch-guided window has no credible lead pitch, it fails closed instead of reverting to raw accompaniment.
- Phrase gaps still reset contour continuity, so later instrumental phrases may legitimately restart in another register.
- Basic Pitch still runs once over the vocal-plus-guided-lead source; canonical `PerformanceTrack` remains playback truth.
- First use downloads the pinned Windows sherpa-onnx runtime and Spleeter FP16 model archive into local caches. No Python, PyTorch, Node, Visual Studio, .NET SDK or manual model setup is required.
- The Spleeter archive remains fail-closed pinned to 35,271,738 bytes / SHA-256 `d54561979bd2e08a51e7dbd99ac36bb47564e089eefd403636dbca93e811bba2`.

## Musical quality evidence

- The protected real Basic Pitch A/B keeps vocal melody identity at **3/3 -> 3/3** and instrumental hook recovery at **0/2 -> 2/2** after the pitch-guided production change.
- The pitch-guided real-model path remains bounded rather than spraying notes; exact-head CI is required to preserve the fixture's note-budget contract and full 4.8-second timeline.
- A new deterministic mixed fixture contains a clear E4 lead plus measurable E2 bass and B4 chord leakage. Before Basic Pitch, the pitch-guided production source must keep the selected lead dominant while materially suppressing the bass/chord components instead of passing their original waveform through.
- Existing coherent-contour, discontinuous-contour, phrase-gap reset, bass-only rejection, lead-over-restrained-bass and broadband/percussion regressions remain protected.
- Existing real 17.3-second CC0 mixed-song evidence remains protected: the Spleeter-first path previously reduced low-activation review regions from 3 to 1 while preserving the full timeline.
- Spleeter separation remains roughly 2-5 seconds warm-cache on the measured 8-logical-CPU Windows machine, versus roughly 108 seconds for the earlier CPU HTDemucs path.

## Diagnostics and cost

- Stem-composition diagnostics now expose `PitchGuidedFallbackWindows` in addition to energy-eligible, non-melodic, bass-dominated, discontinuous and active fallback counts. No raw private audio is logged.
- Pitch guidance reuses the dominant frequency already produced by bounded decimated autocorrelation and the existing accompaniment window RMS. It adds no separator/model/runtime download and no additional Basic Pitch inference.
- The equal-tempered guide frequency is computed once per active window; synthesis remains O(sample count) within the already allocated composition output buffer.
- Per-section state remains O(window count). At 400 ms windows, a four-minute song has about 600 windows, so the added frequency/RMS arrays remain only a few KiB.
- Full-song managed PCM architecture remains unchanged: at 22,050 Hz mono float, each four-minute full-length buffer is about 20 MiB. No-fallback composition reuses the vocal buffer; active fallback needs the existing additional output buffer.

## Validation

- Audio OSS gate validates pinned Basic Pitch readiness, decode/arrange regressions, generated MIDI parity, anti-percussion gating, bass-dominance rejection, dominant-melody contour continuity, pitch-guide isolation and the real-model vocal/hook A/B.
- Production gate validates deterministic regressions, Windows client build, self-contained single-EXE publish, clean-machine smoke, STA UI startup, Windows input ABI and packaged Basic Pitch/ONNX smoke tests.
- Merge remains fail-closed on exact-head CI and current-main drift; client-impacting release is created only from validated `main`.

## Remaining Phase-0 quality gap

Phase 0 is still not complete. Pitch-guided fallback prevents an accepted instrumental section from carrying its full chord/bass/percussion waveform into melody truth, but broader legally usable weak-vocal, dense-accompaniment and fully instrumental corpus evidence with reference contour/onset scoring is still required. The next direct quality step is multi-song section-level lead scoring plus sparse harmony extraction after lead identity is stable.

## Troubleshooting

Source-separation or accompaniment-source failures remain fail-visible instead of silently reverting to dense raw-full-mix transcription.