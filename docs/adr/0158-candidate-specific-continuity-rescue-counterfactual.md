# ADR 0158: Candidate-specific continuity rescue counterfactual

## Status

Accepted for Audio-to-Piano OSS Phase 69.

## Context

Phase 65 showed that harmony continuity was dormant on the pinned Spotify Basic Pitch repeated-progression corpus. Phase 66 proved that lowering only `HarmonyContinuityRelativeActivationFloor` did not exercise the policy. Phase 67 traced prior-harmony candidates and found adaptive density was the largest pre-selector blocker, while Phase 68 proved that globally lowering `AccompanimentRelativeActivationFloor` from `0.35` to `0.20` still produced identical output and zero continuity selections.

A global threshold change is therefore not justified. Before changing production selection policy, we need to know whether any *specific* Basic Pitch note that was already recognized as harmony and matches the previous chord's pitch class would improve canonical arrangement quality if it were allowed to compete downstream.

## Decision

Run Spotify Basic Pitch exactly once on the existing redistributable repeated-progression fixture and keep the original decoded notes as the evidence truth. Match recognized harmony notes to the labeled fixture using the existing `AudioTranscriptionEvaluator` one-to-one onset/pitch contract.

For each recognized harmony note whose pitch class also occurred in the immediately preceding labeled chord, run a bounded test-only activation rescue. Increase only that candidate's activation in small deterministic steps until the production arranger output changes or the bounded ceiling is reached. The counterfactual track is still evaluated against the *original* decoded-note evidence, so changing activation cannot manufacture an upstream recognition gain.

For every changed counterfactual report:

- candidate MIDI pitch, section and original/rescue activation;
- whether production harmony-continuity selections increased;
- global and per-section harmony retention deltas;
- melody retention;
- clutter-suppression delta;
- unmatched playback-event and event-count guards.

A counterfactual is promotable evidence only if it improves global or section harmony retention, loses no recognized melody or section harmony, adds no unmatched playback event, does not expand the arranged event count beyond source evidence, and keeps clutter suppression within `0.02` of production. A promotable result is evidence for a later production implementation, not permission for this evidence-only phase to mutate playback policy.

If no candidate is promotable, keep production unchanged and stop tuning continuity thresholds on this corpus; the next phase should either simplify/remove dormant continuity policy or move quality work to another measured bottleneck.

## OSS and packaging impact

Spotify Basic Pitch remains the AMT model/semantics source and Microsoft ONNX Runtime remains the native inference runtime. NAudio and DryWetMIDI boundaries are unchanged. No upstream implementation is copied and no Python, PyTorch, ffmpeg, Demucs model/runtime, NuGet package or native dependency is added. This phase has no client package/runtime cost and creates no new license or NOTICE obligation.

## Authority boundary

`RobloxPiano.Core.PerformanceTrack` remains authoritative. The activation rescue is test-only evidence generation; it never authorizes mutation of production scheduler, focus guard, Windows input, held-key/pedal ownership, Legacy baselines or Runtime Input P0.