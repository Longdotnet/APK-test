---
schema: 1
version: 0.40.76
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
- Existing melodic-periodicity gating continues to reject broadband/percussion-heavy fallback, and bass-dominance gating continues to reject tonal low-frequency accompaniment that is not credible lead melody.
- v0.40.76 adds dominant-melody contour continuity before accompaniment may become lead truth. Each accepted tonal window now carries its estimated lead pitch; a contiguous candidate section containing an implausible adjacent pitch jump is rejected atomically rather than feeding a jumping chord/overtone sequence into Basic Pitch.
- Real phrase gaps reset continuity, so a later instrumental phrase may legitimately restart in another register instead of being forced near the previous phrase.
- Basic Pitch still runs once over the composed melody-focused source; canonical `PerformanceTrack` remains playback truth.
- First use downloads the pinned Windows sherpa-onnx runtime and Spleeter FP16 model archive into local caches. No Python, PyTorch, Node, Visual Studio, .NET SDK or manual model setup is required.
- The Spleeter archive remains fail-closed pinned to 35,271,738 bytes / SHA-256 `d54561979bd2e08a51e7dbd99ac36bb47564e089eefd403636dbca93e811bba2`.

## Musical quality evidence

- Exact-head real Basic Pitch A/B keeps vocal melody identity at **3/3 -> 3/3** while section-aware fallback recovers instrumental hook pitches **0/2 -> 2/2**.
- The same real-model fixture remains bounded at **3 -> 7 decoded notes**, with fallback active only across **6/12 windows (2.4 s of a 4.8 s fixture)** rather than contaminating the whole song.
- New deterministic contour regressions prove a coherent **E4-F4-G4-A4** instrumental phrase remains eligible, while an erratic tonal section with large register jumps is rejected as a whole before transcription.
- A large pitch/register change separated by a genuine phrase gap remains eligible, preventing continuity cleanup from flattening distinct song sections.
- Existing bass-only rejection, lead-over-restrained-bass admission and broadband/percussion rejection remain protected.
- Existing real 17.3-second CC0 mixed-song evidence remains protected: the Spleeter-first path previously reduced low-activation review regions from 3 to 1 while preserving the full timeline.
- Spleeter separation remains roughly 2-5 seconds warm-cache on the measured 8-logical-CPU Windows machine, versus roughly 108 seconds for the earlier CPU HTDemucs path.

## Diagnostics and cost

- Stem-composition diagnostics now additionally expose `RejectedDiscontinuousLeadWindows` beside energy-eligible, non-melodic and bass-dominated rejection counts. No raw private audio is logged.
- Pitch continuity reuses the lead-frequency estimate already produced by bounded decimated autocorrelation. It adds no separator/model/runtime download and no additional Basic Pitch inference.
- The added per-section state is O(window count): at 400 ms windows, a four-minute song has about 600 windows, so the lead-frequency array is only about 4.8 KiB plus small boolean arrays.
- Full-song managed PCM architecture is unchanged: at 22,050 Hz mono float, each four-minute full-length buffer is about 20 MiB. No-fallback composition reuses the vocal buffer; active fallback needs an additional output buffer.

## Validation

- Audio OSS gate validates pinned Basic Pitch readiness, decode/arrange regressions, generated MIDI parity, anti-percussion gating, bass-dominance rejection, dominant-melody contour continuity and the real-model hook-recovery A/B.
- Production gate validates deterministic regressions, Windows client build, self-contained single-EXE publish, clean-machine smoke, STA UI startup, Windows input ABI and packaged Basic Pitch/ONNX smoke tests.

## Remaining Phase-0 quality gap

Phase 0 is still not complete. The next direct quality step is broader legally usable weak-vocal, dense-accompaniment and fully instrumental corpus evidence with reference contour/onset scoring. The current 2-stem path can now reject major percussion, bass and discontinuous-pitch failure modes, but it still needs stronger section-level dominant-source confidence and sparse harmony extraction across multiple real songs before recognizable-song quality can be declared solved.

## Troubleshooting

Source-separation or accompaniment-stem failures remain fail-visible instead of silently reverting to dense raw-full-mix transcription.