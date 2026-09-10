# ADR 0037: Verifiable support bundle and bounded environment evidence

## Status
Accepted for Production Phase 32.

## Context

Phase 30/31 made support evidence privacy-safe and client-accessible, but the ZIP itself still had two production support gaps:

1. a copied/truncated/corrupted bundle could look valid to a client or support engineer even when `support.json` was damaged;
2. clean-machine failures could not be correlated with the minimum runtime/architecture facts needed to distinguish Windows/runtime compatibility from playback logic.

Raw logs, usernames, machine names and full local paths are not acceptable substitutes. Support evidence must remain diagnostics-only and must never become playback truth or authorization state.

## Decision

The automatic support bundle is upgraded to schema v2 and contains exactly three bounded entries:

- `support.json` — privacy-reduced recent session evidence plus bounded environment and outcome-summary facts;
- `manifest.json` — SHA-256 and exact byte length of `support.json`, client version, generation time and session count;
- `README.txt` — human-readable support instructions and integrity hash.

The environment block is intentionally restricted to:

- OS description;
- OS architecture;
- process architecture;
- .NET runtime description;
- 64-bit process flag;
- processor count.

It must not add username, machine name, account ID, network identifiers, full executable path or full sheet path.

`VerifySupportBundle` deterministically requires the three-entry shape, verifies `support.json` SHA-256 and byte length against the manifest, deserializes the payload and verifies its session count. Automatic bundle refresh performs this verification after the atomic write and logs a diagnostic warning if verification fails. Verification failure cannot affect playback, focus safety, input release or Roblox authorization.

Outcome summary counts `Completed`, `Cancelled`, `AuthorizationLost`, `InputFailed`, `SourceFailed`, `RuntimeFailed` and unknown outcomes so support can distinguish an isolated client report from a repeated failure pattern without scanning raw logs.

## Consequences

- A support engineer can detect a damaged or partially transferred payload before trusting its evidence.
- Clean-machine support gets architecture/runtime evidence without collecting identity-bearing machine data.
- Existing JSONL session persistence stays schema v1; only the exported support bundle moves to schema v2, preserving compatibility with historical local session files.
- The bundle remains small, local-only, best-effort and independent of AI/network availability.
- Both production gate and release gate inherit the AppRecovery regression that verifies privacy reduction, three-entry bounded shape, exact hash/length coverage and tamper rejection.
