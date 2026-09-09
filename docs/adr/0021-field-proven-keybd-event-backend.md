# ADR 0021: Field-proven Roblox keyboard backend

## Status
Accepted for production client v0.16.1.

## Context
Real Roblox acceptance testing exposed a second boundary after the v0.15.1 virtual-key hotfix. The client could successfully activate the exact Roblox window and enter playback without a `SendInput` error, yet the Roblox piano still consumed no notes.

The earlier PowerShell baseline that was confirmed to work on the same real-client path did not use `SendInput` for note dispatch. It resolved characters with `VkKeyScanW`, pressed character-scoped Shift/Ctrl/Alt modifiers, and emitted virtual-key down/up events through the Win32 `keybd_event` API. Later PowerShell experiments and the .NET client changed that final dispatch API to `SendInput`, which was not field-equivalent.

## Decision
The production Windows input sink now restores the full field-proven dispatch boundary:

- resolve each character through `VkKeyScanW`;
- preserve the existing mixed-chord modifier semantics;
- emit virtual-key down/up with `keybd_event`;
- pass scan code `0`;
- use flags `0` for key-down and `KEYEVENTF_KEYUP` for key-up;
- keep exact Roblox `MainWindowHandle` activation/focus gating;
- keep held-note ownership, release-all, cancellation, seek and focus-loss safety unchanged.

The existing `--input-abi-smoke` command remains as a release compatibility entrypoint, but it now validates the field-baseline event shape without sending a real key. Diagnostics record `backend=keybd_event` so field logs can prove which backend a client build is using.

## Consequences
`keybd_event` is a legacy Win32 API, but it is intentionally selected here because it is the strongest known-good field baseline for this product. This is a compatibility decision, not a claim that the API is generally preferable to `SendInput`.

CI can validate deterministic event construction and packaging, but only real Windows + Roblox testing can prove that Roblox consumes the synthetic keyboard event. If a future backend replaces `keybd_event`, it must first beat this baseline in real-client acceptance rather than only returning success from a Windows API.
