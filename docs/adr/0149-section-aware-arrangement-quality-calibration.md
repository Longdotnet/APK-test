# ADR 0149: Section-aware arrangement quality calibration

## Status

Accepted.

## Context

Phases 57 and 58 improved mixed full-song arrangement by replacing unconditional skyline melody protection and fixed-cap slot filling with confidence-gated melody continuity plus adaptive accompaniment density. The remaining quality gap appeared at section boundaries and in sections with one dominant melody activation:

1. pitch proximity could let a materially weaker transition/accompaniment voice inherit melody continuity into a new dense section; and
2. adaptive density compared accompaniment against the strongest activation in the entire cluster, so a very strong protected melody could raise the relative floor enough to remove moderate but coherent harmony.

Spotify Basic Pitch is polyphonic and instrument-agnostic but documents that it works best on one instrument at a time. Mixed full-song output therefore needs deterministic arrangement calibration rather than treating every simultaneous activation as equivalent musical evidence.

## Decision

`RobloxPianoArranger` keeps the existing canonical and density boundaries and adds two conservative calibrations:

- melody continuity candidates must satisfy the existing absolute/cluster confidence policy and additionally reach 80% of the credible skyline activation before pitch-proximity continuity may override that skyline;
- adaptive accompaniment density computes its relative activation threshold from the strongest non-melody accompaniment candidate, not from the protected melody activation.

The new continuity relative floor is bounded to `(0, 1]`, configurable for controlled evaluation, and fails closed when invalid. `MelodyContinuityConfidenceRejects` records cases where the new confidence guard changes the old proximity-only continuity choice.

## Quality corpus

The deterministic arranger regression now includes a labeled multi-section fixture spanning:

- sparse verse clusters that must not be thinned;
- an arpeggio/transition voice close to the prior melody pitch;
- a dense chorus whose stronger melody must not be captured by that weak transition voice;
- dominant-melody sections with moderate harmony that must survive adaptive density; and
- weak high mixed-audio clutter that must be suppressed.

The fixture requires complete expected melody retention, complete labeled strong-harmony retention, and complete labeled clutter suppression. Focused regressions separately preserve legitimate near-contour melody continuity and fixed-cap parity when adaptive density is disabled.

## OSS comparison

Spotify Basic Pitch remains the model and note-event semantics source. Microsoft ONNX Runtime remains the native .NET inference runtime, NAudio remains the Windows audio decode/resampling boundary, and DryWetMIDI remains the hardened MIDI verification/import boundary. No upstream implementation is copied for this phase.

Source separation remains deferred: this phase demonstrates a concrete deterministic arranger improvement without adding Demucs, Python, PyTorch, ffmpeg, another model, another NuGet package, or another native runtime.

## Authority and performance

The change performs only bounded comparisons over onset clusters that are already materialized by the arranger. It adds no inference pass, no audio decode pass, and no package/model footprint.

External libraries/models may decode and transcribe source data, but `RobloxPiano.Core.PerformanceTrack` remains canonical playback truth. This ADR does not modify the scheduler, Roblox focus/target guards, Windows input authorization, held-key/pedal ownership, emergency release behavior, or the separate Runtime Input P0 field gate.
