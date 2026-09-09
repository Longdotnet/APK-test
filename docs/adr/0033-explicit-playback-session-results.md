# ADR 0033: Explicit playback session results

## Status

Accepted for production Phase 28.

## Context

The desktop player previously treated exceptions as its playback state machine. Completion, cancellation, Roblox authorization loss, Windows input injection failure and generic runtime failure were distinguished directly in `ClientMainForm` catch blocks. Phase 27 made authorization recovery deterministic, but WinForms still owned exception classification and therefore coupled client UX to runtime implementation details.

That coupling made it harder to test session outcomes independently, add diagnostics/telemetry later, or introduce another UI/headless runner without duplicating exception knowledge.

## Decision

Playback execution now crosses the desktop boundary through `PlaybackSessionResult`.

The production result kinds are:

- `Completed`
- `Cancelled`
- `AuthorizationLost`
- `InputFailed`
- `SourceFailed`
- `RuntimeFailed`

`PlaybackSessionResultCapture` is the only boundary that translates expected runtime exceptions from an active playback task into session outcomes. It preserves final playback position and diagnostic exception detail. Roblox authorization failure also preserves the typed process-lifetime failure (`VerificationRequired`, `ProcessEnded`, or `ProcessReplaced`).

Source loading failures use the same result contract before an active transport session exists.

`ClientMainForm` no longer branches on playback exceptions. It renders the result through `PlaybackSessionPresentationPolicy`, performs cleanup/release-all through the existing transport disposal path, and returns to the Sheet Library only when the typed result requires it.

## Invariants

- The canonical performance timeline and transport engine remain independent of WinForms and source format.
- Authorization loss remains fail-closed and still returns to the Sheet Library only after playback cleanup.
- Cancellation remains a normal safe outcome, not an error dialog.
- Windows input injection failures are distinguishable from generic runtime failures and give the client a deterministic `Test Roblox Input` recovery path.
- Diagnostic exception detail may be retained in the result for logging, but UI behavior must branch on `PlaybackSessionResultKind`, not exception types.
- Legacy and Legacy x2 playback behavior are unchanged.

## Validation

`RobloxPiano.AppRecoveryTests` covers result capture and presentation for completion, cancellation, process authorization loss, Windows input failure, source failure, and generic runtime failure. Existing production gates continue to cover transport cleanup, held-input release, focus safety, source importers, self-contained publish and published-client smoke tests.
