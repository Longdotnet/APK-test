# ADR 0009: Deterministic Standard MIDI ingestion

## Status

Accepted for the Core ingestion layer. Desktop Sheet Library exposure remains intentionally disabled until the player can load MIDI through the same file-loader boundary without falling back to text parsing.

## Context

The production kernel, transport, held-input ownership, timing calibration, and expressive sustain compiler now operate on canonical `PerformanceTrack` data. MIDI is the next importer boundary, but it must not teach the playback kernel about MIDI files or silently reinterpret unsupported musical state.

A production importer must therefore:

- parse Standard MIDI deterministically without AI or network access;
- preserve absolute timing across tempo changes;
- pair NoteOn/NoteOff into explicit durations;
- treat NoteOn velocity 0 as NoteOff;
- support running status and formats 0/1;
- convert CC64 sustain into canonical expressive controls only when semantics are representable;
- map pitches through an explicit keyboard profile rather than embedding pitch logic in the scheduler;
- fail closed for out-of-range notes, dangling notes, malformed chunks, unsupported SMPTE timing, conflicting tempo state, or channel/pedal semantics that the canonical model cannot represent faithfully.

## Decision

`MidiFileImporter` lives in `RobloxPiano.Core` and returns `ExpressivePerformanceTrack`. The existing `ExpressivePerformanceCompiler` lowers sustain into duration-aware `PerformanceTrack` before transport/playback. The kernel therefore remains source-agnostic.

The initial keyboard profile is the common 61-key C2-C7 Virtual Piano / Roblox-style QWERTY layout. It is represented explicitly as `MidiKeyboardProfile.RobloxClassic61`; MIDI pitches outside 36..96 are rejected by default instead of silently folded into another octave. A bounded transpose option exists at the importer boundary for future product UI.

Standard MIDI format 0 and format 1 with PPQ timing are accepted. SMPTE division is rejected for now. Tempo changes are merged into an absolute tick-to-time map. Conflicting tempo changes at the same tick are rejected rather than resolved by accidental track ordering.

CC64 sustain is imported for a single note-bearing channel. If a file has multiple note-bearing channels and sustain is present, import fails with a grounded error because the current canonical sustain control is global. Applying one channel's pedal globally would alter other channels and violate source truth.

Desktop `.mid` / `.midi` visibility remains off in this phase. The existing Sheet Library continues to expose only `.txt` / `.vps` until `ClientMainForm` is migrated from direct `LegacySheetParser` calls to a source-neutral file loader. This avoids advertising a client workflow that cannot yet play the file correctly.

## Consequences

Positive:

- MIDI timing and note duration become deterministic Core facts.
- Legacy TXT/VPS behavior and `Legacy x2` fingerprints are untouched.
- Sustain uses the same canonical compiler and safety behavior as future importers.
- Unsupported state fails explicitly instead of producing plausible-but-wrong music.
- Future desktop integration does not require changing the playback kernel.

Tradeoffs / follow-up:

- multi-channel pedal semantics need channel-aware expressive state or a deterministic piano-flattening policy before they can be accepted;
- desktop file loading must be unified before MIDI is shown in the Sheet Library;
- velocity is parsed only as NoteOn/nonzero state in this phase because the canonical playback/input backend has no velocity authority yet;
- additional game keyboard profiles and user-visible transpose controls belong at the importer/profile boundary, not in playback scheduling.

## Verification

The dedicated MIDI regression harness covers classic C2-C7 mapping, format-0 parsing, tempo changes, running status, velocity-zero NoteOff, CC64 sustain compilation, out-of-range failure, dangling notes, multi-channel sustain rejection, and SMPTE rejection. Both the production gate and release candidate gate must run this harness.
