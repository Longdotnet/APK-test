# ADR 0027 — GUI Roblox input acceptance check

Status: Accepted

## Context

The production Windows input boundary can prove that Roblox was selected, foreground focus stayed on the selected Roblox process, and Windows observed the synthetic key state. CI can validate the native packet contract, but it cannot prove that the Roblox client or a specific piano experience consumed that synthetic input.

The existing `--roblox-input-field-test` developer command established a real-machine probe using the same production input sink, but a normal client who only double-clicks `RobloxPiano.exe` should not need a console or command-line knowledge to diagnose "Play runs but Roblox does nothing".

## Decision

The Sheet Library exposes **Test Roblox Input** as a first-class client action. It opens a dedicated input-check dialog that:

1. finds the preferred Roblox Player target using the same production process policy;
2. asks for explicit consent before emitting input;
3. activates Roblox and requires the existing stable-foreground interval;
4. holds the production W key long enough for a visible field observation;
5. records OS/native evidence through the existing diagnostics path;
6. asks the user whether Roblox actually reacted;
7. maps native evidence plus the explicit observation to a deterministic verdict and next action.

The verdict model distinguishes activation failure, unstable focus, Windows key-state failure, focus loss during the probe, native delivery awaiting human observation, Roblox non-reaction after native delivery, and confirmed Roblox reaction.

No AI or network call participates in the verdict. A user observation can confirm Roblox consumption, but it does not mutate playback state or importer truth.

## Safety

The probe uses the same key sink and release-all safety path as production playback. It sends only one bounded W hold after explicit user consent and only while the selected Roblox PID remains foreground. The dialog never treats Windows-level delivery alone as proof that Roblox consumed the input.

## Validation

The published-client UI smoke must instantiate the input-check dialog on STA. The Windows input compatibility smoke deterministically exercises every verdict branch and requires each verdict to include actionable client guidance. Existing playback, MIDI/MusicXML, timing, focus, held-state and Legacy/Legacy x2 regressions remain unchanged.
