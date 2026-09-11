# ADR 0082: Harmonic-suppression pressure in Audio-to-Piano readiness

## Status

Accepted for Audio-to-Piano OSS Phase 11, subject to exact-head and exact-main validation.

## Context

Phase 10 added conservative, fail-visible harmonic duplicate suppression after Basic Pitch decoding. The Phase 09/10 pinned-model piano-like corpus retained all 12/12 ground-truth notes while reducing estimated notes from 74 to 57, which means 17/74 decoded notes (about 23%) were classified as weak harmonic artifacts.

The existing readiness gate only evaluated the post-suppression arrangement. That creates a blind spot: a track can look structurally healthy after cleanup even when the raw model output required substantial harmonic repair. Automatically calling such a result `Ready` would hide uncertainty that the product quality contract says must remain visible.

Spotify Basic Pitch remains the upstream AMT/model semantic reference. Its documentation describes the model as instrument-agnostic and polyphonic but notes that it works best on one instrument at a time. Phase 11 therefore does not replace Basic Pitch post-processing or introduce a competing ML model; it turns already-recorded deterministic suppression evidence into an explicit product-readiness signal.

## Decision

Extend `AudioTranscriptionQualityEvaluator` with harmonic-suppression pressure:

- `HarmonicSuppressionRatio = suppressed decoded notes / decoded input notes`;
- ratios above 15% produce `NeedsReview` with `HARMONIC_ARTIFACTS_HIGH`;
- ratios above 50% produce `Rejected` with `HARMONIC_ARTIFACTS_CRITICAL`;
- exactly 15% remains eligible for `Ready` when all other quality dimensions pass;
- invalid/inverted thresholds fail closed;
- callers that do not supply suppression diagnostics retain backward-compatible zero-pressure behavior.

The production `AudioToPianoTranscriptionService` always supplies the real suppression diagnostics, so actual Audio-to-Piano results cannot silently bypass this signal.

The 15% ready boundary is intentionally below the roughly 23% artifact pressure observed in the deliberately harmonic-rich Phase 09/10 corpus. Such a corpus should remain reviewable rather than automatically promoted. The 50% rejection boundary is conservative: if more than half of decoded notes require deterministic artifact removal, the raw transcription is too unstable to present as a trustworthy automatic result without stronger evidence.

## Invariants

This phase does not mutate decoded notes, suppression decisions, arrangement output, canonical `PerformanceTrack`, scheduler/input behavior, focus authorization, held-key/pedal ownership or Legacy playback. Quality remains advisory/fail-visible and cannot authorize Roblox input.

## OSS and license impact

No new dependency, model, native binary or copied implementation is introduced. Existing NAudio, Microsoft ONNX Runtime and Spotify Basic Pitch attribution remains unchanged. The new thresholds and reason codes are repository-specific product policy calibrated from the existing deterministic corpus.

## Validation contract

Regression coverage must prove:

- zero/low suppression remains eligible for `Ready`;
- elevated suppression becomes `NeedsReview`;
- critical suppression becomes `Rejected`;
- boundary semantics are deterministic;
- invalid threshold ordering fails closed;
- existing Audio ingest, Basic Pitch, arranger, harmonic suppression and real-model corpus gates remain green.

This phase does not claim Audio-to-Roblox end-to-end playability; Runtime Input P0 remains independently field-gated.
