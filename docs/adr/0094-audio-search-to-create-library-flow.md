# ADR 0094: Audio search-to-create Library flow

## Status
Accepted

## Context

A normal client starts in Sheet Library and usually knows a song identity before they have a local filename. Existing discovery can find public MIDI candidates, while Audio-to-Piano can transcribe owned/local audio. Before this phase those paths were separate: the Create Piano Version surface was not directly available from the search/library workflow, and generated track identity defaulted to the audio filename even when the client had already searched for the intended song.

## Decision

- Sheet Library remains the primary client entry point and existing local/online MIDI discovery remains the fast path.
- Sheet Library exposes **Create Piano Version...** beside its primary actions. The current search text is handed to the create surface as suggested song identity.
- Search text is metadata only. It never authorizes, locates, downloads or captures copyrighted audio. Transcription still requires audio the client explicitly chooses from local storage and is authorized to use.
- Suggested identity is normalized deterministically: trim/collapse whitespace and controls, cap it at 120 characters, then fall back to the selected audio basename and finally `Generated Piano`.
- The normalized identity is passed to the existing `AudioToPianoClientJob` and therefore becomes the canonical generated `PerformanceTrack.Title`; the local audio filename no longer silently overrides an explicit song identity.
- Preview/readiness behavior is unchanged. `Ready` and explicitly reviewed `NeedsReview` results may be persisted; `Rejected` results cannot be added.
- Persistence continues through `GeneratedTrackLibraryWriter`: deterministic DryWetMIDI serialization followed by production MIDI re-import/parity verification and atomic Library commit.
- After a successful Add to Library, the create form returns the committed path and Sheet Library refreshes/selects that exact entry without bypassing normal validation.

## Architectural boundaries

`RobloxPiano.Core.PerformanceTrack` remains authoritative. This phase does not replace the scheduler, focus guard, input authorization, held-key/pedal ownership, Legacy baseline, or Runtime Input P0 field gate. It also does not promote online MIDI discovery to product truth: same-title candidates still require deterministic validation and are only a convenience fast path.

## OSS impact

No new dependency is introduced. The flow continues to reuse Spotify Basic Pitch semantics/model, Microsoft ONNX Runtime, NAudio and Melanchall DryWetMIDI through the existing production boundaries. Existing Apache-2.0/MIT attribution and bundled notices remain sufficient.

## Consequences

The user journey becomes one coherent surface: search for a song, use a suitable existing source when available, or fall back to owned/local audio while preserving the intended song identity through Create -> Preview -> review -> Add to Library. End-to-end Roblox play remains contingent on the separate Runtime Input field gate.
