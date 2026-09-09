# ADR 0017: Windows STA entrypoint and native SendInput ABI

## Status
Accepted for production client reliability hardening.

## Context
Real client testing exposed two failures that CI had not modeled:

1. the Sheet Library could open, but creating the playback form could later raise `DragDrop registration did not succeed` because WinForms/OLE drag-drop requires a stable STA UI entrypoint;
2. playback reached the Windows input backend but `SendInput` returned zero. The managed `INPUT` union only contained `KEYBDINPUT`, so `Marshal.SizeOf<INPUT>()` was smaller than the native Windows `INPUT` structure whose union is sized by `MOUSEINPUT`. `SendInput` requires the exact native structure size.

The second defect is particularly dangerous because all deterministic scheduling, focus and held-key safety can be correct while every real key dispatch still fails at the OS boundary.

## Decision
- The published executable uses an explicit synchronous `[STAThread]` startup object. Async CLI execution remains behind that synchronous Windows entrypoint.
- Production UI smoke creates native handles for both the Sheet Library and playback form, not only the first window.
- The Windows input interop model includes mouse, keyboard and hardware members in the explicit union so the managed ABI matches native `INPUT` sizing: 40 bytes on win-x64 and 28 bytes on win-x86.
- Every key dispatch validates that ABI before calling `SendInput`.
- A published `--input-abi-smoke` command validates the exact single-file executable used by clients without injecting real input.
- OS input rejection becomes a controlled `InvalidOperationException`-family playback failure. The existing transport catch/finally path logs diagnostics, stops playback and releases held state instead of allowing a `Win32Exception` to escape to the global UI error handler.
- Diagnostics distinguish a real Win32 error code from the zero-error UIPI case and tell the user to keep Roblox foreground and use the same Windows privilege level.

## Consequences
- The exact `cbSize` failure that produced `Windows SendInput failed` is regression-gated.
- OLE drag/drop apartment regressions are tested against both client windows in the published EXE.
- Focus loss, cancellation and release-all invariants remain unchanged.
- Legacy/Legacy x2, canonical playback, MIDI and MusicXML behavior are unaffected.
- Synthetic input can still be refused by Windows/UIPI or the real Roblox client; those cases are now controlled and diagnosable rather than unhandled.
