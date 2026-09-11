# ADR 0072: Field probe focus continuity is sticky and fail-closed

## Status
Accepted

## Context

The P0 Roblox field probe previously required stable foreground before injection, but after KeyDown it sampled Windows key state at 0/25/50 ms and then waited until the nominal 650 ms hold ended. `ForegroundHeldDuringProbe` was derived only from `target.IsForeground` at the end.

That creates a false-positive boundary: an overlay, notification, Alt-Tab, Roblox process/window transition, or other transient foreground change can take focus during the held W and return it before KeyUp. The final sample can then say Roblox held foreground even though it did not. It also keeps W held until the nominal end instead of releasing as soon as sampled focus loss is known, contradicting the input safety invariant.

## Decision

The authorizing PowerShell-oracle field probe now samples foreground continuity and Windows key-down state throughout the complete held-key interval at a bounded 25 ms cadence.

Focus evidence is sticky:

- once any sample reports that the exact Roblox target is not foreground, later focus recovery cannot restore `ForegroundHeldDuringProbe`;
- the first sampled loss timestamp is retained;
- the probe stops the hold loop immediately and issues KeyUp/release-all rather than waiting for 650 ms;
- every sample is emitted under the same stable probe ID as `HOLD_SAMPLE_NNN`;
- a sampled focus loss emits `FOCUS_LOST_DURING_HOLD` with `action=RELEASE_IMMEDIATELY`;
- a probe with any sampled focus loss can never count as native delivery and can never authorize playback.

The production playback backend, character mapping, scheduler, Legacy baselines, physical-key diagnostic, SendInput diagnostic, and Audio-to-Piano subsystem are unchanged.

## Consequences

This does not prove Roblox consumes synthetic input. It makes the remaining field evidence more trustworthy and closes a safety hole around transient focus loss. A client still must visibly observe movement or the expected piano note before P0 is declared field-confirmed.

The 25 ms cadence is intentionally bounded to avoid a busy loop while reducing the prior ~600 ms blind interval. Future work may apply the same sticky continuity primitive to diagnostic-only A/B probes, but those diagnostics remain non-authorizing regardless of result.
