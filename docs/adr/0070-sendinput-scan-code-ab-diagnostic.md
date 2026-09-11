# ADR 0070: SendInput scan-code A/B diagnostic

## Status

Accepted for production diagnostics. Normal playback remains unchanged.

## Context

The P0 field gate still requires an observable Roblox reaction. The product now has two controlled field paths: the exact PowerShell-oracle `VkKeyScanW + keybd_event(scan=0)` path and a second `keybd_event` variant carrying a real non-zero keyboard scan code. Neither path should be promoted without real field evidence.

If both paths reach the Windows input boundary while Roblox stays foreground and neither produces visible movement or a piano note, one unresolved variable is the injection API itself. Microsoft documents `SendInput` as the supported API for synthesizing keyboard input, while `keybd_event` is retained for compatibility. A controlled comparison can therefore provide evidence without replacing the production backend by assumption.

## Decision

Add a third explicit **SendInput Diagnostic** to the Roblox Input Check dialog. It:

1. reuses the same PowerShell-oracle W virtual-key reference and keyboard layout;
2. resolves the same physical scan code through `MapVirtualKeyExW(..., MAPVK_VK_TO_VSC_EX, oracle HKL)`;
3. emits scan-code-only `KEYBDINPUT` records through `SendInput` using `KEYEVENTF_SCANCODE`, with `KEYEVENTF_EXTENDEDKEY` only when Windows reports an extended scan code;
4. preserves the same stable foreground, desktop-parity, cancellation and key-release safety gates used by earlier probes;
5. verifies `SendInput` inserted exactly one event and records the Win32 error when it did not;
6. samples Windows virtual-key state and foreground identity while the key is held;
7. records dedicated `SENDINPUT_*` forensic stages and a human-observation verdict;
8. can never set `RobloxInputHealthSession` to Confirmed and can never switch normal playback.

The field sequence is deliberate: exact PowerShell oracle first, physical-scan `keybd_event` second, SendInput scan-code diagnostic third. This minimizes variables changed between experiments.

## Evidence interpretation

- Oracle reacts: use the existing acceptance logic; no alternate diagnostic is needed.
- Physical-scan `keybd_event` reacts while oracle does not: scan-code presence is the leading candidate; production still remains unchanged until separately promoted with regression protection.
- SendInput reacts while both `keybd_event` variants do not: the injection API semantic is isolated as a strong candidate; production still remains unchanged.
- All three paths show safe Windows delivery and stable Roblox foreground but none visibly reacts: mapping, simple scan-code presence and the `keybd_event` versus `SendInput` distinction are weaker suspects. Investigation should move to Roblox/game input consumption, environment/session/overlay/security policy or a requirement not represented by supported Windows synthetic-input APIs.

## Safety and non-goals

This diagnostic does not bypass Windows or Roblox security boundaries, does not attempt driver/HID emulation, does not inject into another process, and does not weaken privilege or input-desktop checks. If UIPI, desktop or another Windows policy blocks injection, the probe fails closed and reports that boundary.

## Consequences

The client gains a higher-information field experiment while retaining the field-proven playback baseline. Release diagnostics can distinguish three native emission semantics with correlated probe IDs, and every diagnostic exit retains best-effort KeyUp behavior to prevent stuck input.
