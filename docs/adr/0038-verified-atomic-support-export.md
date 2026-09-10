# ADR 0038: Verified atomic support-bundle export

## Status

Accepted.

## Context

Phase 32 made the generated support ZIP self-verifying through `manifest.json`, SHA-256 and exact byte length. The Support Center, however, still copied the generated ZIP directly to the user's chosen destination without enforcing that verifier. That left a client-facing integrity gap: a damaged generated bundle or a copy/write failure could still produce a file that looked successfully exported even though support should not trust it.

Support evidence is diagnostics only. Export hardening must not become playback truth, authorization state, or a new runtime dependency.

## Decision

Support Center exports now use a single deterministic `SupportBundleExport` boundary.

1. Generate the privacy-safe support bundle in the normal diagnostics location.
2. Verify the generated bundle before any user destination is touched.
3. Copy to a sibling temporary file at the chosen destination.
4. Verify the copied temporary bundle again.
5. Atomically move the verified temporary file into the final destination with overwrite semantics.
6. On any failure, remove temporary output and preserve any existing destination unchanged.

The UI reports success only after both source and destination verification pass. Tampered or malformed bundles fail closed with an integrity-specific error.

## Consequences

- A visible `Save Support Bundle...` success now means the exact exported ZIP has passed deterministic manifest/hash verification.
- Existing destination files are not destroyed by a failed verification attempt.
- Partial copy artifacts are not left behind under normal exception paths.
- The bundle remains local-only and privacy-reduced; no new telemetry, network service, account identity, raw logs, username, machine name, or full source path is introduced.
- Playback, focus guard, release-all, Roblox process authorization and canonical timing remain independent of support export.

## Regression contract

The Windows app recovery regression harness must prove that:

- a valid bundle exports byte-for-byte and verifies at the destination;
- no temporary export files remain after success;
- a tampered source bundle is rejected before replacing an existing destination;
- failed export leaves the existing destination intact and leaves no temporary file.
