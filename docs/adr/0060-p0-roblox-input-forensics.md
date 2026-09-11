# ADR 0060 — P0 Roblox input forensics before feature expansion

Status: Accepted for production client v0.40.1.

## Context

Real-client feedback remains the highest-value unresolved product blocker: the desktop client can activate/focus Roblox, but Roblox piano input has not yet been field-confirmed after the recent backend parity fixes. The earlier PowerShell baseline remains field-proven, while CI can only prove construction and Windows-side behavior, not that Roblox consumes the synthetic event.

Previous diagnostics sampled general playback dispatch and did not provide one compact, correlated record proving exactly where a single field probe stopped. That made repeated fixes vulnerable to treating focus or API invocation as equivalent to end-to-end Roblox acceptance.

## Decision

Until the real-client field gate is confirmed, Roblox input acceptance is P0 and feature expansion must not be used as a substitute for resolving it.

The real-machine `W` field probe now emits an unsampled forensic sequence with a unique `probe` id. It records:

- requested character and Unicode code point;
- raw `VkKeyScanW` result, resolved virtual key and modifier mask;
- active keyboard layout for the probe thread;
- app PID/thread, selected Roblox PID/HWND and foreground PID/HWND;
- exact production backend identity (`keybd_event`);
- key state before DOWN, immediately after DOWN, after 25 ms, after 50 ms, before UP and after UP;
- elapsed physical hold time and whether the selected Roblox process remained foreground;
- an explicit machine-readable verdict distinguishing Windows-path observation from Roblox reaction confirmation.

The probe still uses the exact production `WindowsKeyboardInputSink`; no alternate diagnostic-only injection path is introduced.

## Interpretation

- `vkKeyScanRaw`/`resolvedVk` wrong or unmapped: investigate keyboard-layout/character mapping before scheduler or Roblox behavior.
- foreground target mismatch: focus/target selection remains the blocker.
- key state never becomes DOWN: native Windows injection remains the blocker.
- Windows key state becomes DOWN while Roblox stays foreground, but the user reports no reaction: investigate Roblox synthetic-input acceptance, integrity/privilege mismatch, overlays or game-specific capture. The scheduler is not the current suspect.
- user confirms visible Roblox reaction: native acceptance is field-confirmed for that Roblox process; only then should song-level playback behavior be investigated above the native boundary.

## Consequences

CI still cannot claim Roblox consumes input. A successful build/release proves diagnostics and production-path integrity only. The client-side human observation remains the final oracle for Roblox reaction.

Forensic logging is intentionally local and contains process/window identifiers and keyboard-layout metadata but no song content, credentials or network calls. General playback dispatch sampling remains bounded; the explicit field probe is unsampled because it is short and diagnostic by design.
