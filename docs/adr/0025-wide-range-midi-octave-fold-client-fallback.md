# ADR 0025 — Wide-range MIDI octave-fold client fallback

Status: Accepted for production client v0.16.5.

## Context

Real client import exposed a common Standard MIDI case that the deterministic core intentionally rejected: a melodic range can be wider than the Roblox classic 61-key range even after General MIDI percussion is removed. A real example reported range `32..107` while the physical Roblox profile is `36..96`.

The core importer correctly reported that no single global transpose can fit all notes. That is a useful strict validation boundary, but using it as the desktop client's final behavior makes ordinary downloaded MIDI unusable and forces users to manually edit/arrange files before they can even try them.

## Decision

1. Preserve `MidiFileImporter` as the strict first attempt. Existing in-range MIDI, deterministic global auto-fit, tempo, sustain, percussion filtering and canonical timing behavior remain unchanged.
2. Only when the strict importer returns the specific "melodic range cannot fit ... with one global transpose" failure, the desktop source loader retries through a client compatibility profile.
3. The fallback exposes logical MIDI notes `0..127`, but maps every logical pitch to the same pitch class folded by whole octaves into the physical Roblox classic range `36..96`.
4. Notes already inside `36..96` map exactly as before. Only out-of-range notes change octave; the original MIDI file is never rewritten.
5. Compatibility metadata explicitly reports the fallback, for example `octave-folded wide range 32..107 into Roblox 36..96`. It remains visible in the Library and counts as a compatibility-adjusted import.
6. General MIDI percussion channel 10 remains ignored by the same production importer policy. Any unrelated structural/sustain/timing failure is still surfaced rather than hidden by the range fallback.

## Consequences

- Wide real-world MIDI can enter the Library and playback flow instead of being rejected solely because its register exceeds 61 keys.
- Pitch class is preserved for every folded note, while exact octave/register fidelity may change for notes outside the Roblox physical range.
- Ordinary MIDI that already works does not enter the fallback and therefore keeps its previous behavior.
- The fallback is deterministic, offline and does not depend on AI or a network service.

## Regression contract

CI must cover the reported `32..107` range case end-to-end through `SheetLibraryService.ImportBatch`, prove that it creates one valid playable Library row with no warning/failure, and prove the compatibility row states that octave folding was applied.
