# ADR 0068: Controlled physical-key A/B probe

## Status

Accepted for production diagnostics. Normal playback remains unchanged.

## Context

The P0 acceptance gate still requires visible Roblox reaction. Phase 59 replayed the exact known-good PowerShell mapping contract (`VkKeyScanW` plus `keybd_event` with scan code `0`) and separated it from production foreground-layout mapping. If Windows observes that virtual key while Roblox remains foreground but Roblox still does not react, the next useful boundary is whether Roblox/game keyboard capture distinguishes legacy virtual-key emission from a key event that carries the keyboard's physical scan code.

Changing normal playback to a different native-input semantic without field evidence would violate the existing field-proven baseline and could create a false fix. We therefore need an explicit A/B experiment that is isolated from playback authorization.

## Decision

`Test Roblox Input` keeps its Phase 59 behavior and remains the only path that may confirm process-scoped input readiness.

A second explicit **Physical-Key Diagnostic** is available only as an opt-in diagnostic. It:

1. focuses the selected Roblox process and requires the same stable foreground and input-desktop safety checks;
2. resolves the W virtual key through the PowerShell-oracle mapping so character mapping is held constant;
3. resolves the physical scan code with `MapVirtualKeyExW(..., MAPVK_VK_TO_VSC_EX, oracle HKL)`;
4. dispatches the same W through `keybd_event` with that non-zero scan code;
5. samples Windows key state and foreground identity while the key is held;
6. asks the human whether Roblox visibly moved or produced the W-bound piano note;
7. logs a dedicated `PHYSICAL_*` forensic trail and a final `PHYSICAL_SCAN_*` verdict.

The diagnostic is fail-closed:

- scan code `0` is rejected because that would duplicate the existing PowerShell-oracle path;
- unsupported virtual-key width is rejected;
- known Windows input-desktop mismatch prevents injection;
- cancellation and all exit paths send a best-effort key-up;
- a visible physical-key reaction **never** marks normal playback confirmed and never changes the production input backend.

## Evidence interpretation

- PowerShell-oracle reacts: the existing field gate behaves as before; no physical fallback is needed to authorize playback.
- PowerShell-oracle does not react, physical scan-code diagnostic reacts: physical-key/scan-code acceptance is isolated as a strong candidate. Production remains gated until the result is reviewed and a separate production change is regression-protected.
- Neither reacts while both native paths are observed and Roblox remains foreground: simple character mapping and scan-code presence become weaker suspects. Investigation moves toward Roblox/game capture behavior, Raw Input semantics, privilege/session/overlay boundaries, or another native-consumption difference.

## Consequences

The client gains a much higher-information field experiment without silently mutating the playback engine. Diagnostics now distinguish an exact legacy virtual-key path from a controlled non-zero-scan-code variant, while Legacy playback, foreground authorization, held-key ownership, emergency release-all and Audio-to-Piano work remain untouched.
