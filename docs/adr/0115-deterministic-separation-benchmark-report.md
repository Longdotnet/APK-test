# ADR 0115: Deterministic source-separation benchmark report

## Status

Accepted for Audio-to-Piano OSS Phase 32.

## Context

Phase 31 binds a paired demucs.cpp benchmark to exact verified executable, model, and lawful corpus bytes before and after measurement. The resulting `DemucsCppVerifiedBenchmarkRun` is trustworthy in memory, but it is not yet a portable review artifact. A real corpus run needs a deterministic machine-readable record that can be archived, compared, hashed, and reproduced without leaking workstation paths or introducing timestamps that make identical evidence differ across machines.

Source separation remains optional. Production adoption still depends on measured quality/resource evidence passing the existing `AudioSourceSeparationAdoptionEvaluator`; this reporting layer cannot authorize or mutate production transcription or Roblox playback state.

## Decision

Add `DemucsCppBenchmarkReportWriter` with schema `roblox-piano.audio.separation-benchmark.v1`.

The report contains:

- verified provenance identity, exact upstream commit, executable hash, and model hash;
- stable corpus case names and content hashes, but no machine-local audio paths;
- per-case direct/candidate note counts, precision, recall, F1, onset/offset error, F1 delta, elapsed time, peak working set, and bundle bytes;
- corpus resource measurements;
- final `Adopt`, `Review`, or `Reject` decision plus quality deltas and reason codes.

Corpus and measured cases are sorted by ordinal stable identity before serialization. Reason codes are sorted as well. The artifact contains no clock time, random identifier, current machine path, or environment-dependent formatting. UTF-8 JSON bytes are hashed with SHA-256 and returned with the report so identical verified evidence produces the same report digest.

The writer fails closed if measured case identities do not exactly match the verified provenance corpus, if assessment case count disagrees with measurements, or if assessment resources differ from benchmark resources.

`WriteFile` is intentionally a thin engineering convenience. It writes the deterministic bytes to a caller-selected local path and performs no upload, discovery, download, or media acquisition.

## OSS and licensing impact

This phase does not copy, bundle, download, or redistribute demucs.cpp, Demucs models, Spotify Basic Pitch code/models, Python, PyTorch, or ffmpeg. It only serializes evidence already produced by the repository's existing engineering benchmark pipeline, so there is no new runtime dependency or NOTICE/license obligation.

## Consequences

A lawful real-corpus run can now produce a stable artifact suitable for code review, CI artifact retention, side-by-side regression comparison, and independent reruns. Production package size and client inference cost remain unchanged.

## Next step

Add an engineering command/harness that accepts an explicit pinned benchmark manifest, invokes Phase 31 `RunNativeAsync` with the existing Basic Pitch transcription path, writes this report, and exposes the report as a CI artifact. Real source-separation production integration remains blocked until lawful corpus evidence returns `Adopt` within quality, memory, runtime, and package budgets.
