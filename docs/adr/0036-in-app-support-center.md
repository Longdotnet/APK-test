# ADR 0036: In-app Session Diagnostics / Support Center

## Status
Accepted

## Context

Production Phase 30 creates a privacy-reduced, bounded support bundle automatically, but normal clients still have to browse `%LOCALAPPDATA%` manually to inspect or share it. That is not acceptable as the normal support workflow for a self-contained desktop product.

## Decision

The Sheet Library exposes a `Support Center` as a secondary client workflow. The Support Center reads only the bounded structured playback-session diagnostics already owned by `PlaybackSessionDiagnostics`; it does not read raw logs as playback truth and it does not participate in authorization, import, scheduling, or input dispatch.

The view shows recent session outcome, source filename/type, final position, speed/latency settings, Roblox process identity, typed authorization failure and sanitized exception evidence. Full local source paths remain excluded from the support-facing model.

The client can rebuild the latest bounded support bundle and save a copy through a normal Windows Save dialog. Bundle creation remains best-effort diagnostics: failure to read or save support evidence must not mutate playback state, input readiness, Roblox authorization, held-key state, or canonical performance data.

## Consequences

- A normal client can reach support evidence from the list-first Sheet Library without knowing filesystem paths.
- Support reports retain deterministic structured evidence instead of requiring screenshots or ad-hoc raw log copying.
- The privacy boundary from ADR 0035 remains authoritative: filename rather than full source path, bounded sanitized exception text, no raw JSONL/log inclusion in the exported ZIP.
- The Support Center is intentionally read-only with respect to playback truth and authorization.

## Release identity

This client-facing phase is released as `0.21.0` because it adds a substantial support/diagnostics workflow to the production desktop shell.
