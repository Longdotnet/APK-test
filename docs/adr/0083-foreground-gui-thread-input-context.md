# ADR 0083: Foreground GUI-thread input context for Roblox field probes

## Status
Accepted

## Context

The P0 field gate is still unresolved: Windows can focus the Roblox process and observe a synthetic W key transition without proving that Roblox's game surface consumed it. Phase 67 made the selected/root window identity continuous and fail-closed, but foreground/root identity alone does not expose the foreground GUI thread's active/focus/capture state.

Windows exposes this state through `GetGUIThreadInfo`. Capturing it can distinguish a Roblox foreground window from a GUI thread whose focused child/root is elsewhere, while preserving the important distinction that GUI capture is not synonymous with keyboard capture.

## Decision

For every explicit Roblox input probe, capture `GetGUIThreadInfo` for the current foreground thread and correlate it with the existing stable probe ID.

Record:

- foreground GUI thread ID;
- active HWND;
- focus HWND;
- capture HWND;
- menu-owner HWND;
- move/size HWND;
- caret HWND;
- selected Roblox window-tree relation for active/focus/capture;
- Win32 error if the snapshot cannot be captured.

Focus classification is deterministic:

- exact selected window or selected target tree -> `TrustedTargetSurface`;
- same Roblox PID but alternate root -> `SameProcessAlternateRoot`;
- foreign process -> `DifferentProcess`;
- zero focus HWND -> `NoFocusedWindow`;
- unresolved relation -> `Unknown`.

The explicit key-state samples during the W hold include the same focus/capture context, so field logs can identify GUI-focus drift at the same failure boundary as Windows key-state evidence.

## Safety and authorization

This phase is forensic only. It does not add a new injection backend, relax focus guards, bypass UIPI/integrity/session/desktop constraints, or promote GUI-thread evidence into field success. Existing window-identity and focus-continuity authorization remains authoritative.

`hwndCapture` is logged as Windows GUI capture context only; it must never be described as proof of keyboard capture.

## Consequences

A client log can now distinguish:

1. selected Roblox window is foreground and GUI focus is inside the trusted target tree;
2. foreground belongs to Roblox but GUI focus is on another same-process root;
3. GUI focus points outside Roblox;
4. the GUI thread reports no focused HWND;
5. `GetGUIThreadInfo` cannot be captured because of a foreground-thread race or Win32 failure.

None of these states is `FIELD_CONFIRMED_PASS` without visible Roblox movement or an expected piano reaction.