# ADR 0142: Audio review draft discovery read-I/O budget

## Status

Accepted.

## Context

Phase 49 introduced a disposable source-path lookup index for resumable Audio-to-Piano review drafts. Phase 50 rebuilds that index during bounded storage maintenance, and Phase 51 avoids rewriting an unchanged index. The remaining performance contract is the read side: a warm indexed lookup should not depend on parsing checkpoint JSON, while an index miss or corrupt index must stay bounded and fail back to authoritative checkpoint discovery.

The lookup index is not playback truth. A returned draft is still untrusted until `AudioReviewDraftStore.RestoreAsync` full-hashes the owned/local source, validates content-addressed evidence, deterministically replays explicit repair decisions, and verifies the rebuilt canonical `PerformanceTrack` fingerprint.

## Decision

Lock the existing discovery behavior with a production regression budget:

1. An indexed lookup may return a managed existing draft candidate without parsing that checkpoint JSON first. This keeps warm discovery independent from checkpoint document size and preserves the index as acceleration only.
2. Authoritative fallback discovery considers at most 256 newest bounded `.review.json` candidates. A matching checkpoint outside that set must not be opened or returned.
3. A missing/corrupt index falls back to bounded authoritative discovery. A successful fallback self-heals the requested source-to-draft index mapping so the next warm lookup no longer depends on parsing the checkpoint.
4. Malformed checkpoints remain untrusted. Discovery may skip them; only restore can authorize resumable state.
5. No change is made to Basic Pitch evidence, repair semantics, `PerformanceTrack`, Roblox scheduling/input, release truth, or the P0 field gate.

The regression uses observable I/O consequences rather than wall-clock timing: a deliberately malformed checkpoint must still resolve through an existing index entry, and a valid matching checkpoint placed as the 257th-oldest discovery candidate must remain invisible to fallback. These contracts are deterministic across CI machines and avoid pretending filesystem timing is a stable performance oracle.

## OSS / packaging impact

No new package, model, native runtime, Python/Node tooling, database, or media dependency is introduced. The slice reuses the existing .NET BCL file/JSON implementation and the previously established review-index architecture. Existing Basic Pitch, ONNX Runtime, NAudio, DryWetMIDI and attribution obligations are unchanged.

## Consequences

- Warm indexed discovery has a regression proving it does not require checkpoint JSON parsing before returning a candidate.
- Corrupt-index recovery remains fail-safe and self-healing.
- Fallback read work remains bounded to 256 candidates even with a larger draft corpus.
- This phase is a quality/performance contract only; it does not change client-facing behavior or require a SemVer/release bump.
