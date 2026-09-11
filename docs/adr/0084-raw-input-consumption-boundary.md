# ADR 0084: Raw Input consumption boundary for Roblox field probes

## Status
Accepted

## Context

The P0 field gate remains unresolved. RobloxPiano can establish focus/window/session/desktop parity and observe a synthetic W transition through Windows without proving that the Roblox experience consumes the same input path.

Windows Raw Input is a materially different consumption path because applications may receive device-originated `WM_INPUT` packets rather than relying only on translated keyboard state/messages. A synthetic `keybd_event`/`SendInput` transition therefore cannot be described as equivalent to a hardware Raw Input packet.

Public Win32 APIs expose the machine's Raw Input device inventory, but `GetRegisteredRawInputDevices` reports registrations for the calling process only. RobloxPiano cannot truthfully query another process's registration state with that API.

## Decision

Every explicit Roblox field probe captures the global Raw Input device inventory with `GetRawInputDeviceList` and records counts for keyboard, mouse and HID classes under the existing stable probe ID.

Target registration visibility is always reported as `UNOBSERVABLE_CROSS_PROCESS`. We intentionally do not log raw device names/paths because they are unnecessary for this failure boundary and could expose unrelated machine-specific identifiers.

When at least one keyboard-class Raw Input device exists, diagnostics emit `RAW_INPUT_CONSUMPTION_UNOBSERVABLE`: this is context, not a blocker and not proof Roblox uses Raw Input. It explicitly prevents a Windows key-state observation from being promoted into evidence of a hardware-originated Raw Input packet.

## Safety and authorization

This phase is forensic only. It does not inspect Roblox memory, inject a driver, emulate a hardware device, bypass UIPI/platform security, or change the production input backend. Focus-loss release, held-key/pedal ownership and the Legacy baseline remain unchanged.

## Consequences

Field evidence can now distinguish:

1. Windows synthetic key-state was observed while physical keyboard-class Raw Input devices exist;
2. Raw Input device inventory was unavailable;
3. the target process's Raw Input registration/consumption path remains unknown by design.

Only visible Roblox movement or the expected piano reaction is `FIELD_CONFIRMED_PASS`.
