---
schema: 1
version: 0.40.78
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
- The vocal stem remains authoritative for lead melody. Sustained vocal-weak sections may recover a pitch-guided instrumental lead, but raw accompaniment never replaces melody truth.
- Section fallback still uses 400 ms windows and requires at least two consecutive eligible windows (about 0.8 seconds), with 80 ms attack, 140 ms release and 0.98 peak protection.
- Melodic-periodicity, bass-dominance and dominant-contour continuity gates continue to decide whether an accompaniment section is credible lead material. Accepted instrumental windows become a monophonic equal-tempered pitch guide rather than raw accompaniment waveform.
- v0.40.78 adds a separate harmony path after lead identity is locked. The separated accompaniment is analyzed by the already-packaged Basic Pitch model with stricter note thresholds, Melodia recovery disabled and pitch bends disabled.
- Harmony evidence is then reduced deterministically around protected lead onsets: at most two harmony notes per lead onset, distinct pitch classes, 3-24 semitones below the lead, minimum duration/confidence gates, and output activation capped below the lead activation.
- Selected harmony enters the existing deterministic Roblox arranger only after lead transcription and harmonic suppression. Existing harmony voicing, bass-anchor, continuity and density policy remain authoritative; canonical `PerformanceTrack` remains playback truth.
- The second accompaniment pass deliberately trades additional transcription time for chord identity without mixing drums/bass back into the lead inference source. It introduces no new model/runtime/package dependency.
- First use still downloads the pinned Windows sherpa-onnx runtime and Spleeter FP16 model archive into local caches. No Python, PyTorch, Node, Visual Studio, .NET SDK or manual model setup is required.
- The Spleeter archive remains fail-closed pinned to 35,271,738 bytes / SHA-256 `d54561979bd2e08a51e7dbd99ac36bb47564e089eefd403636dbca93e811bba2`.

## Musical quality evidence

- Existing protected real Basic Pitch A/B must continue to keep vocal melody identity at **3/3 -> 3/3** and instrumental hook recovery at **0/2 -> 2/2** after the pitch-guided production change.
- New sparse-harmony regressions require accompaniment to remain below the protected lead, cap each lead onset to at most two support notes, deduplicate octave-equivalent pitch classes, and reject accompaniment that does not coincide with lead timing.
- Existing coherent-contour, discontinuous-contour, phrase-gap reset, bass-only rejection, lead-over-restrained-bass and broadband/percussion regressions remain protected.
- Existing real 17.3-second CC0 mixed-song evidence remains protected: the Spleeter-first path previously reduced low-activation review regions from 3 to 1 while preserving the full timeline.
- Spleeter separation remains roughly 2-5 seconds warm-cache on the measured 8-logical-CPU Windows machine, versus roughly 108 seconds for the earlier CPU HTDemucs path.

## Diagnostics and cost

- Create Piano diagnostics now expose accompaniment `HarmonyDecodedNotes`, sparse-harmony selection diagnostics, and separate harmony inference/decode/suppression/selection elapsed times. No raw private audio is logged.
- Sparse-harmony selection reports protected lead count, accompaniment count, candidate/selected counts, above-lead or out-of-window rejection, low-confidence rejection, duplicate-pitch-class drops and lead onsets receiving harmony.
- The harmony selector is bounded by decoded-note evidence and keeps at most two support notes per lead onset. It does not allocate another full-song PCM output buffer beyond the already decoded separated accompaniment.
- The material runtime cost is one additional Basic Pitch inference over the separated accompaniment on the normal full-song separation path. This is intentional for Phase 0 quality and is observable separately from lead inference.
- No additional model, separator runtime or downloadable asset is introduced, so release/package model footprint remains unchanged apart from application code.

## Validation

- Audio OSS gate must validate pinned Basic Pitch readiness, decode/arrange regressions, generated MIDI parity, anti-percussion gating, bass-dominance rejection, dominant-melody contour continuity, pitch-guide isolation, sparse-harmony selection and the real-model vocal/hook A/B.
- Production gate must validate deterministic regressions, Windows client build, self-contained single-EXE publish, clean-machine smoke, STA UI startup, Windows input ABI and packaged Basic Pitch/ONNX smoke tests.
- Merge remains fail-closed on exact-head CI and current-main drift; client-impacting release is created only from validated `main`.

## Remaining Phase-0 quality gap

Phase 0 is still not complete. The production path now separates lead truth from supporting harmony, but broader legally usable weak-vocal, dense-accompaniment, bass-heavy and fully instrumental corpus evidence with reference contour/onset scoring is still required. The next direct quality step is multi-song section-level scoring of melody recall, rhythm/onset identity, false-note rate and whether sparse harmony improves recognition without exceeding Roblox density budgets.

## Troubleshooting

Source-separation, accompaniment-analysis or harmony-selection failures remain fail-visible instead of silently reverting to dense raw-full-mix transcription.