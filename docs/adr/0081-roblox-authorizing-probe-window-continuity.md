# ADR 0081: Roblox authorizing probe window-identity continuity

## Status

Accepted for P0 field input hardening.

## Context

Phase 66 made foreground/root-window identity observable, but the authorizing PowerShell-oracle probe still treated any foreground HWND owned by the selected Roblox PID as sufficient focus. A Roblox splash, alternate top-level surface, overlay-like same-process root, or a replacement `MainWindowHandle` could therefore appear while `W` was held and still leave the probe eligible as native-delivery evidence.

That is too weak for an authorization path. Same PID does not prove that the selected game surface remained the input consumer.

## Decision

The authorizing `Test Roblox Input` probe now requires a trusted Roblox window surface both before injection and throughout the hold interval.

A trusted surface is narrowly defined as:

- the exact selected Roblox HWND; or
- a foreground HWND whose root/root-owner resolves to the selected Roblox window tree;
- and the selected process must not have replaced its current `MainWindowHandle`.

`SameProcessAlternateRoot`, `DifferentProcess`, `Unknown`, and a known live main-window replacement are not trusted for authorization.

Stable-focus acquisition resets unless both ordinary Roblox foreground ownership and trusted window identity remain true. During the W hold, identity is sampled at the same 25 ms cadence as focus continuity. The first untrusted sample is sticky for the attempt, emits `WINDOW_IDENTITY_LOST_DURING_HOLD / WINDOW_IDENTITY_LOST_BEFORE_UP`, and causes immediate release rather than waiting for the nominal hold duration.

`NativeDeliveryObserved` now requires window identity to have remained trusted continuously. A distinct `WindowIdentityLostDuringProbe` assessment tells the client to re-run input verification against the current game window.

## Safety and scope

- Loss of trusted window identity stops the authorizing input attempt and release-all remains in `finally`.
- No new injection API or platform-security bypass is introduced.
- The PowerShell-oracle key mapping remains unchanged.
- Normal scheduler/playback mapping, Legacy baseline, held-key/pedal ownership and Audio-to-Piano code are unchanged.
- Diagnostic A/B probes remain non-authorizing; this decision protects the path that can unlock Play.

## Evidence contract

An attempt that ever sees same-PID alternate-root or main-window replacement cannot become trusted merely because the original HWND later regains foreground. Logs preserve the first loss time plus target/current-main/foreground/root handles and relation under the existing stable probe ID.

This does not prove Roblox consumed input. `FIELD PASS` still requires visible movement or the expected Roblox piano note from a real client.

## Consequences

The probe may reject some same-process Roblox surfaces that previously counted as focused. That is intentional: a false negative can be retried after rebinding the current game window; a false positive could incorrectly authorize normal playback based on input sent to the wrong Roblox surface.
