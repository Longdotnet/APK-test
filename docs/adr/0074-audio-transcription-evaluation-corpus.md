# ADR 0074: deterministic Audio-to-Piano evaluation corpus

## Status
Accepted.

## Context
The Audio-to-Piano pipeline can now classify generated arrangements as `Ready`, `NeedsReview`, or `Rejected`, but those readiness thresholds are engineering defaults. Before client-facing `Create Piano Version` promotion, we need repeatable ground-truth measurements that distinguish a recognizable transcription from one that merely emits plausible notes.

Spotify Basic Pitch is the transcription model, but production must not add Python/SciPy/mir_eval as client dependencies. The mature `mir_eval.transcription` convention is still a useful behavioral reference for note-level scoring.

## Decision
Add a native .NET `AudioTranscriptionEvaluator` and corpus aggregator. Evaluation is measurement-only and cannot mutate decoded notes, the canonical `PerformanceTrack`, scheduler state, or Roblox input.

Default note matching follows the mature mir_eval transcription convention where applicable to integer-MIDI Basic Pitch output:

- same MIDI note is required;
- onset tolerance is inclusive 50 ms;
- offset tolerance is the greater of 50 ms or 20% of reference-note duration;
- each reference/estimated note participates in at most one match;
- matching uses deterministic maximum-cardinality bipartite matching rather than a closest-first greedy pass.

The evaluator reports precision, recall, F1, false positives/negatives, and mean absolute onset/offset error. A corpus aggregator keeps per-case results and also reports micro and macro F1 so one large easy fixture cannot hide a weak case.

Synthetic regression fixtures cover exact notes, tolerance boundaries, duplicate estimates, an ambiguous graph where greedy matching undercounts, duration-relative offset tolerance, wrong pitch/late onset, clean-vs-degraded corpus aggregation, and cancellation. Future licensed/public-domain audio fixtures can use the same immutable reference-note contract without changing scoring semantics.

## OSS impact
No runtime dependency is added. `mir_eval` is used as a semantic reference only; no Python/SciPy/mir_eval code or package is redistributed. Existing Basic Pitch, ONNX Runtime and NAudio licensing/attribution remains unchanged.

## Consequences
Readiness calibration can now be based on stable note-level evidence rather than intuition. Phase 07 establishes the scoring/corpus boundary; it does not yet claim that current readiness thresholds are calibrated for mixed commercial songs. The next step is to run pinned Basic Pitch against a small redistributable synthetic/public-domain audio corpus, store baseline metrics, and then tune readiness thresholds only when the corpus demonstrates the change is justified.
