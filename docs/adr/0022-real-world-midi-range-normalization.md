# ADR 0022: Real-world MIDI range normalization

## Status
Accepted for production client v0.16.2.

## Context
The v0.16.0 list-first MIDI workflow validated every MIDI note directly against the classic Roblox 61-key profile (MIDI 36..96). Real-world MIDI files often contain General MIDI percussion on channel 10, where note 35 is a bass drum, plus melodic material that may sit slightly above or below the Roblox keyboard range. Rejecting the whole file because of those events makes otherwise playable MIDI impossible to import.

Silently clamping individual notes would be worse: it changes intervals and can turn percussion into arbitrary piano notes.

## Decision
The deterministic MIDI importer now applies two compatibility rules before canonical playback events are built:

1. General MIDI channel 10 percussion is ignored by default for piano playback. Note-on, note-off and sustain events from that channel do not become Roblox piano keys.
2. The remaining melodic note range is auto-fitted with one global semitone transpose when the complete melodic span can fit inside the active keyboard profile. The chosen adjustment is the smallest shift toward zero that brings both range endpoints inside the profile.

Explicit `TransposeSemitones` is applied first. Callers that require the old strict behavior can set `AutoFitToKeyboardRange: false`; callers that intentionally want channel 10 treated melodically can set `IgnoreGeneralMidiPercussion: false`.

If the melodic span itself is wider than the active Roblox keyboard, import still fails closed rather than folding, clamping or independently octave-shifting notes.

## Consequences
Common General MIDI files containing drums no longer fail because of drum notes such as 35. Slightly out-of-range piano arrangements import without asking a normal client to edit the MIDI first, while timing and relative intervals remain unchanged.

The raw MIDI file remains the Library asset. Normalization is deterministic at load time, so the same source bytes produce the same canonical playback on validation and playback.
