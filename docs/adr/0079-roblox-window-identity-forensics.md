# ADR 0079: Roblox foreground/root-window identity forensics

## Status

Accepted for Production Phase 66 while the Roblox Runtime Input P0 field gate remains unproven.

## Context

The P0 probes already correlate Roblox PID/HWND, foreground PID/HWND/TID, keyboard layout, integrity, input desktop, Windows session, key state and continuous focus. `RobloxWindowTarget.IsForeground` intentionally treats another foreground HWND owned by the same Roblox PID as focused. That is useful for normal focus safety, but it leaves a forensic ambiguity: a Roblox process can keep the same PID while its top-level window/root surface changes, or an overlay/splash/alternate top-level window in the same process can become foreground. A field log could therefore say focus was continuously held without showing whether the attempt stayed on the originally selected Roblox root window.

## Decision

Add a diagnostic-only Windows window-identity snapshot for every explicit P0 input attempt. Capture the foreground window, its `GA_ROOT` and `GA_ROOTOWNER`, owning process IDs, privacy-safe Win32 class names, and the selected Roblox process's current `MainWindowHandle`.

Classify the foreground relation deterministically as `ExactTarget`, `TargetWindowTree`, `SameProcessAlternateRoot`, `DifferentProcess`, or `Unknown`. Emit `TARGET_WINDOW_REPLACED` when the selected Roblox process remains alive but its current main HWND differs from the selected target HWND. Emit `SAME_PROCESS_ALTERNATE_ROOT` as context when foreground remains in the Roblox PID but is not rooted at the selected HWND.

The same relation/replacement evidence is included in key-state samples under the stable probe ID so transient window replacement can be located inside one field attempt.

## Safety and scope

This phase does not add or promote an input injection backend. It does not bypass Roblox or Windows security behavior, change canonical playback truth, alter Legacy baselines, or take ownership of Audio-to-Piano. Existing focus-loss release-all behavior remains authoritative.

A stale/replaced target window is invalid evidence for Roblox consumption even if the PID remains alive. CI/window diagnostics are not a substitute for visible Roblox movement or piano-note reaction.

## Validation

Regression coverage locks the pure window-relation classifier and the live-process/main-window replacement predicate. Production and Audio OSS gates must both pass on the exact PR head and exact merged main SHA before release.
