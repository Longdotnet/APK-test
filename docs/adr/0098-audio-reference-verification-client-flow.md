# ADR 0098: Owned-audio verification gates the online fast path

Status: Accepted

## Context

Phase 21 can convert verified reference-audio timeline alignment into immutable `HighConfidence`, `Review`, or `Mismatch` evidence, but Sheet Library discovery still exposes online MIDI candidates primarily through metadata ranking. A same-title MIDI can therefore be useful as a discovery lead without proving that it represents the client's intended recording.

The client already ships NAudio for bounded local decode/resampling and already has the canonical `SongSourceLoader`, reference timeline aligner, and confidence policy. Adding another decoder, Python runtime, ffmpeg, or an online fingerprinting service would duplicate solved infrastructure, enlarge the self-contained package, and weaken the local/authorized-audio boundary.

## Decision

1. Sheet Library exposes `Verify with my audio...` for a selected online MIDI candidate.
2. The client chooses an owned/local WAV, MP3, AIFF, or AIF file. NAudio decodes it locally, averages to mono, deterministically resamples to 22,050 Hz, and enforces a five-minute reference bound.
3. The normalized stream is encoded to deterministic PCM16 WAV evidence and passed to the existing `ReferenceAudioAnalyzer`. No reference audio is uploaded.
4. The selected online MIDI is downloaded only from the existing provider allow-list into an operation-scoped temporary directory with the same five-MiB download bound used by online import.
5. The temporary MIDI is parsed through production `SongSourceLoader` into canonical `PerformanceTrack`; no alternate MIDI playback engine becomes product truth.
6. Existing `ReferenceAudioTimelineAligner` and `ReferenceCandidateConfidencePolicy` produce hash-bound evidence. The candidate is classified as `High confidence`, `Review`, or `Mismatch`.
7. A verified `High confidence` candidate is promoted as the existing-source fast path. Once a candidate has verified `Review` or `Mismatch` evidence, that candidate is blocked from Add-to-Library in the discovery surface and the client is directed to another candidate or `Create Piano Version`.
8. Verification never writes to the Library. Temporary candidate bytes are deleted best-effort on success, cancellation, and failure.
9. Unverified discovery remains available for backwards compatibility, but the UI explicitly states that metadata is not recording proof.
10. Runtime Input, scheduler, focus authorization, held-key/pedal ownership, Legacy, and Legacy x2 are outside this phase.

## OSS comparison

NAudio already supplies the Windows decode / `ISampleProvider` / resampling boundary required by the product and is already bundled. Mature music-similarity systems often add chroma/DTW or heavier fingerprinting stacks; that can be evaluated later if onset/tempo evidence proves insufficient. Phase 22 deliberately adapts existing deterministic evidence rather than introducing another runtime before product evidence requires it.

## Consequences

- Clients can test recording equivalence before persisting a discovered MIDI.
- Same-title metadata can no longer override an explicit non-high-confidence result on that candidate.
- Reference verification remains lawful/local: it operates on audio the client explicitly selects and does not add a media downloader or access-control bypass.
- Five-minute reference analysis and five-MiB candidate download limits keep memory/network work bounded.
- Onset/tempo alignment is not waveform identity. `Review` remains explicit rather than silently guessed; future chroma/section evidence can strengthen the same assessment boundary without changing canonical playback truth.
