# ADR 0077: Windows session parity for P0 input forensics

## Status
Accepted for P0 field diagnostics.

## Context
The live Roblox acceptance gate remains unproven. The field diagnostic matrix already separates `keybd_event` versus `SendInput` and virtual-key versus physical scan-code semantics, while also recording focus continuity, keyboard layout, integrity/elevation and input-desktop parity.

If all supported injection variants establish Windows key-down evidence while Roblox still does not react, the next useful boundary is the Windows interactive-session context. A local console session, an RDP/remote session, and a cross-session process mismatch are materially different environments even when foreground HWND/PID evidence looks superficially healthy.

## Decision
Capture Windows logon/session evidence for every P0 probe using supported Windows APIs:

- `ProcessIdToSessionId` for RobloxPiano and the selected Roblox process;
- `WTSGetActiveConsoleSessionId` for the current active console session;
- deterministic `Same`, `Different`, or `Unknown` session parity;
- whether app and target session IDs equal the active console session;
- Win32 error codes when session identity cannot be resolved.

A known app/target session mismatch emits a structured `SESSION_BLOCKER / WINDOWS_SESSION_MISMATCH` forensic event. A same-session probe that is not in the active console emits `SESSION_CONTEXT / NON_CONSOLE_INTERACTIVE_SESSION`. The latter is context, not proof of failure, because supported remote-session behavior must be established by field evidence rather than assumed.

This phase does not add another injection mechanism, does not bypass Windows or Roblox security boundaries, and does not promote any diagnostic backend into production playback.

## Field interpretation

- `sessionParity=Different`: do not use the attempt as evidence about Roblox input consumption; rerun Roblox and RobloxPiano in the same interactive Windows session.
- `sessionParity=Same` with both processes in the active console: session mismatch is a weaker suspect.
- `sessionParity=Same` but `targetIsActiveConsole=false`: preserve the evidence and compare against a local-console run before attributing failure to mapping or scheduler behavior.
- `sessionParity=Unknown`: retain the Win32 error codes and avoid drawing a session conclusion.
- Even perfect session parity plus Windows key-down evidence is not a field PASS. Only visible Roblox movement or a W-bound piano reaction satisfies the acceptance gate.

## Consequences
The support log can now distinguish a Windows session/RDP boundary from mapping/API/focus failures in one client capture. Normal playback, focus authorization, Legacy baselines, held-key ownership, scheduler and Audio-to-Piano remain unchanged.
