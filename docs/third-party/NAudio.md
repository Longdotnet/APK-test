# NAudio

RobloxPiano uses NAudio for the Audio-to-Piano ingest boundary.

- Upstream: `naudio/NAudio`
- Package: `NAudio` 3.1.0
- License: MIT
- Copyright: Mark Heath and contributors
- Purpose here: Windows audio decoding, float sample access, and WDL resampling before music transcription.

No NAudio playback engine owns RobloxPiano playback truth. Decoded samples are normalized at the import boundary; canonical `PerformanceTrack` state and the Roblox input scheduler remain repository-owned deterministic components.

When NAudio binaries are distributed with the client, retain the upstream MIT copyright and permission notice as required by the license.
