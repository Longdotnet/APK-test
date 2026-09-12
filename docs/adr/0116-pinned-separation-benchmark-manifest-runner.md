# ADR 0116: Pinned source-separation benchmark manifest runner

## Status

Accepted for Audio-to-Piano OSS Phase 33.

## Context

Phases 30–32 established exact executable/model/corpus provenance, protected measurements against mid-run drift, and emitted deterministic benchmark reports. Running that stack still required bespoke caller setup, which makes real lawful-corpus experiments unnecessarily easy to misconfigure and hard to reproduce.

Source separation remains engineering-only. It must not enter the production Audio-to-Piano path until measured evidence passes the existing adoption gate, and this work must not touch Roblox Runtime Input P0 semantics.

## Decision

Add `DemucsCppBenchmarkManifestRunner` as the single engineering entry point for a pinned native benchmark.

A manifest explicitly provides:

- schema `roblox-piano.audio.separation-benchmark-manifest.v1`;
- full 40-character demucs.cpp upstream commit identity;
- absolute local executable/model paths and exact SHA-256 pins;
- deterministic extra-runtime byte accounting and bounded timeout/input/output limits;
- lawful corpus case identities, absolute audio paths, content SHA-256, durations, and ground-truth notes.

The runner validates the manifest, builds the existing `DemucsCppVerifiedBenchmarkRequest`, invokes Phase 31 `RunNativeAsync`, then writes the Phase 32 deterministic JSON report plus a conventional `.sha256` sidecar. Manifest parsing is bounded to 4 MiB and 256 cases, rejects duplicate identities, malformed hashes, relative paths, invalid durations, and empty ground truth.

No PATH search, executable/model/media download, URL fetching, YouTube extraction, or implicit corpus discovery is allowed. The caller still supplies the existing direct and separated-stem Basic Pitch transcription delegates so production model semantics stay centralized rather than duplicated in benchmark configuration.

## Example manifest

```json
{
  "SchemaVersion": "roblox-piano.audio.separation-benchmark-manifest.v1",
  "UpstreamCommitSha": "0123456789abcdef0123456789abcdef01234567",
  "ExecutablePath": "C:\\bench\\demucs.exe",
  "ExecutableSha256": "<64 hex>",
  "ModelPath": "C:\\bench\\ggml-model-6s.bin",
  "ModelSha256": "<64 hex>",
  "AdditionalRuntimeBytes": 0,
  "TimeoutSeconds": 600,
  "Corpus": [
    {
      "Name": "owned-song-01",
      "InputAudioPath": "C:\\bench\\corpus\\owned-song-01.wav",
      "Sha256": "<64 hex>",
      "DurationMilliseconds": 183000,
      "ReferenceNotes": [
        { "StartMilliseconds": 125, "EndMilliseconds": 410, "MidiNote": 64 }
      ]
    }
  ]
}
```

## Consequences

A lawful corpus run can now be launched through one validated API call and produces reviewable report + checksum artifacts without weakening Phases 30–32 provenance contracts. Production client package size, Basic Pitch client behavior, canonical `PerformanceTrack`, scheduler, focus guard, input authorization, Legacy playback, and the Runtime Input P0 field gate remain unchanged.

This phase does not copy, bundle, download, or redistribute demucs.cpp, Demucs models, Spotify Basic Pitch code/models, Python, PyTorch, ffmpeg, or third-party media, so it adds no runtime dependency or redistribution obligation.

## Next step

Run the manifest harness against an owned/licensed multi-song corpus and exact locally built/pinned demucs.cpp six-source artifacts. Retain the deterministic report and checksum as CI/review evidence. Production separation remains blocked unless the measured adoption decision is `Adopt` within quality, memory, runtime, and package budgets.