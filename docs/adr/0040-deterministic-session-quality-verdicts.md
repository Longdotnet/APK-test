# ADR 0040: Deterministic session quality verdicts

## Status
Accepted

## Context

Phase 34 made live playback quality measurable across seek and dynamic-speed transport segments. Support Center could show p95 timing error, input-call latency, focus interruptions, missing dispatches and failures, but a normal client or support operator still had to interpret those raw numbers manually.

That interpretation must not become an AI-owned or UI-local guess. The same evidence should always produce the same client guidance, while preserving the raw transport metrics as the diagnostic source of truth.

## Decision

Introduce a deterministic `PlaybackSessionQualityAssessmentPolicy` in the desktop support boundary. It derives one primary verdict from the already persisted privacy-reduced session quality evidence:

- `DispatchLoss` when unexpected missing edges or playback failures exist.
- `FocusInterrupted` when Roblox lost foreground focus during playback.
- `InputLatencyHigh` when Windows input-call latency exceeds conservative field-support thresholds.
- `TimingDegraded` when scheduler p95 or maximum absolute timing error exceeds conservative field-support thresholds.
- `Healthy` when none of the above conditions is present.
- `Unavailable` for older sessions without transport-aware evidence.

Priority is deliberate: deterministic dispatch loss outranks focus, input-call latency and timing because incomplete playback cannot be called healthy even when its timing samples look good. Focus interruption outranks timing because the safety contract intentionally pauses input while Roblox is not foreground. Input-call latency outranks scheduler timing because a late Windows delivery can make playback sound late even if scheduler timing itself is acceptable.

The initial support thresholds are intentionally conservative and explicit in code:

- p95 absolute scheduler error: 12 ms
- maximum absolute scheduler error: 30 ms
- mean input-call duration: 4 ms
- maximum input-call duration: 15 ms

These thresholds are client-support classifications, not automatic scheduler-promotion gates. Legacy and Legacy x2 regression/A-B promotion remains governed by measured baseline comparison and must not be replaced by these labels.

## Client behavior

Support Center adds a `Quality` column and selected-session details include the verdict, a concise evidence summary and an actionable next step. Guidance distinguishes focus loss, Windows input delivery, scheduler timing and unexpected dispatch loss so a client is not told to change speed or sheet content for an unrelated input/focus problem.

## Boundaries

- Raw deterministic metrics remain the evidence; the verdict is a derived presentation/support classification.
- The policy does not mutate playback state, authorization, scheduler timing, import results or held-key ownership.
- AI, network availability and quota do not participate.
- Existing privacy-safe support bundles continue to carry the raw aggregate evidence, allowing the verdict to be reproduced without persisting a second source of truth.
- Seek-interrupted edges remain excluded from unexpected dispatch loss under ADR 0039.

## Regression requirements

Production validation must prove at least:

1. clean evidence is `Healthy`;
2. dispatch loss has highest diagnostic priority;
3. focus interruption is explained as a foreground-window safety event;
4. high Windows input-call latency is distinguishable from scheduler timing degradation;
5. timing degradation guidance preserves the Legacy/Legacy x2 comparison workflow.
