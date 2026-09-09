# ADR 0029: Gate playback on process-scoped Roblox input readiness

## Status

Accepted for production client v0.18.2.

## Context

The client already records deterministic Roblox input health as `Unknown`, `Confirmed`, or `Blocked`, scoped to the exact Roblox Player PID that was tested. The Sheet Library still launched playback without consulting that state, so a normal client could press Play while input was known to be blocked or had never been verified for the current Roblox process.

That made the diagnostic contract advisory rather than operational and allowed avoidable silent playback attempts.

## Decision

The Sheet Library owns a deterministic playback preflight policy immediately before it launches the player window:

- no Roblox Player target -> playback cannot launch;
- `Unknown` readiness for the current PID -> run the GUI input check before playback;
- `Blocked` readiness for the current PID -> require a successful retest before playback;
- `Confirmed` readiness for the current PID -> playback may launch without repeating the check;
- readiness recorded for any other PID is treated as `Unknown`, never as authorization.

After the input-check dialog closes, the Library resolves the preferred Roblox target again and reevaluates readiness. It resolves and reevaluates one final time immediately before creating the player window. A Roblox restart or target PID change therefore invalidates stale confirmation rather than carrying trust across processes.

The Play button remains the primary action. For a playable song it communicates the required state directly: `Verify Input & Play`, `Retest Input to Play`, `Play`, or `Open Roblox to Play`.

## Safety and architecture

This preflight is deterministic and in-memory. AI, network access, quotas, and external services are not involved. It does not weaken the runtime focus guard, PID authorization boundary, cancellation, emergency release-all, or held-key ownership rules.

The playback engine and canonical performance model remain source-neutral and unaware of this GUI/client readiness policy.

## Validation

The published executable input-compatibility smoke must cover no-target, unknown, confirmed, blocked, and stale-confirmation/different-PID decisions. The normal production gate continues to cover Legacy/Legacy x2, transport, input ownership, MIDI, MusicXML, timing, Library, quality, Windows publish, STA startup, and input ABI behavior.
