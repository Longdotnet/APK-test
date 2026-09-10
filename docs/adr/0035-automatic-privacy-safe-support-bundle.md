# ADR 0035: Automatic privacy-safe support bundle

## Status

Accepted for Production Phase 30.

## Context

Production Phase 29 made every desktop playback session persist a typed local JSONL diagnostic record. That evidence is useful to engineering, but asking a normal client to locate, understand, select, and send raw diagnostic files is not a production support workflow. Raw session records also intentionally retain the full local source path for on-machine troubleshooting, so copying those files directly can reveal local folder names unnecessarily.

The client needs a sendable artifact that is generated without AI, network access, developer tools, or manual log assembly, and diagnostic failure must never affect playback truth or input safety.

## Decision

After a structured playback-session record is appended successfully, the desktop client refreshes one bounded artifact:

`%LOCALAPPDATA%\RobloxPiano\logs\RobloxPiano-support-latest.zip`

The refresh is deterministic and best-effort. It runs under the same in-process diagnostics serialization gate, and a failure to build the support ZIP is logged but must not change playback/session outcome, authorization, focus safety, or release-all behavior.

The ZIP contains only:

- `support.json` — at most the 20 newest valid playback-session records, transformed into a support schema;
- `README.txt` — explains what the artifact is and that raw local paths/logs are intentionally excluded.

Raw `sessions-*.jsonl` files are never embedded in the ZIP.

## Privacy boundary

The local JSONL store remains the detailed on-machine source of truth. The sendable support representation is deliberately narrower:

- full `SourcePath` is replaced by source file name only;
- exception messages replace the exact source path and the current user-profile prefix when present;
- sanitized exception messages are single-line and bounded to 500 characters;
- no song contents, account information, network tokens, raw log files, or AI context are included.

This is a privacy reduction boundary, not a security sandbox. Future fields added to the support schema must be reviewed explicitly before publication.

## Corruption and retention behavior

Support collection tolerates a malformed/truncated JSONL line, such as one left by power loss during append, and preserves surrounding valid sessions. Reading recent records is bounded and keeps only the newest records required for support output. The existing 30 daily JSONL-file retention remains unchanged.

The ZIP is written to a temporary sibling file and atomically replaced only after the archive closes successfully, preventing a partially rewritten `RobloxPiano-support-latest.zip` from becoming the normal support artifact.

## Client recovery UX

Input, source, and generic runtime playback failures tell the user the exact support-bundle path. Authorization-loss recovery continues to prioritize returning to Sheet Library and re-verifying the current Roblox process; the bundle must not become an authorization mechanism.

## Regression contract

Production desktop regression coverage must prove:

1. malformed JSONL lines do not discard neighboring valid sessions;
2. recent-session collection is bounded and newest-first;
3. support records retain useful session/process/settings evidence while excluding full source paths;
4. the ZIP contains only the explicit support document and README, not raw JSONL/log files;
5. support generation remains local and deterministic.

## Consequences

A normal client reporting a repeated playback/input/source failure can send one stable ZIP instead of manually collecting raw logs. Engineering receives typed session history while unnecessary local path disclosure is reduced. The next client-experience step may add an in-app viewer or one-click Open/Copy/Export actions over this stable backend contract without changing playback truth.
