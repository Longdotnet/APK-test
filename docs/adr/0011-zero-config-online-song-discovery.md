# ADR 0011: Zero-config online song discovery stays optional to playback

## Status
Accepted

## Context

The production client can already import TXT/VPS/MID/MIDI into a local Sheet Library and play from canonical deterministic state. Requiring a normal user to leave the app, search Google, understand file formats, download a file, then return to import it is unnecessary product friction.

Online discovery is useful only if it does not turn playback into a network product. A provider outage, slow response, malformed remote file, changed API response, duplicate upload or malicious redirect must never corrupt the local Library or stop already-imported songs from playing.

## Decision

The existing Library search box becomes a unified local + optional-online search surface.

- Local Library filtering remains immediate and has no network dependency.
- After a short debounce, the client asks `SongDiscoveryService` for at most ten ranked online candidates.
- Initial zero-configuration providers use public machine-readable APIs rather than HTML scraping: Wikimedia Commons MediaWiki API and Internet Archive search/metadata APIs.
- Providers are isolated behind `ISongDiscoveryProvider`; one provider timing out or failing does not fail another provider or local Library behavior.
- Provider calls have bounded timeouts and are cancellable when the user keeps typing.
- Results are ranked deterministically from normalized title/token similarity, piano/MIDI hints, provider confidence and safe file-size metadata.
- Exact content identities (SHA-1/MD5 when a provider exposes one) and normalized metadata identities remove duplicate search results before the UI sees them.
- The UI shows only a simple star match, song title, creator when known and provider name. Provider/API internals stay hidden.
- Users explicitly choose **Add to Library**. Search never downloads a song in the background.
- Remote download is HTTPS-only, provider-host allowlisted, redirect target revalidated and capped at 5 MiB.
- Downloaded bytes are staged outside the Library, passed through the existing deterministic MIDI importer, and enter the managed Library only after full validation succeeds.
- Identical bytes already present in the managed Library are reused instead of creating another online duplicate.
- Recent successful query results are cached locally for seven-day search fallback. Cached discovery does not make playback depend on the network; an already-imported local song remains the only playback source.
- Detailed provider/download failures go to diagnostics. Normal UI reports a short retry/choose-another message.

## Provider boundaries

Provider adapters return metadata plus a trusted direct-download URL; they do not own parsing or playback. Current adapters are:

1. **Wikimedia Commons** — `generator=search` constrained with `filemime:midi`, plus `imageinfo` URL/size/hash metadata.
2. **Internet Archive** — Advanced Search for MIDI-related items, then the public item Metadata API to resolve concrete `.mid`/`.midi` files.

Adding a future provider must not require changing `PerformanceTrack`, `PlaybackKernel`, transport, Windows input or the Library persistence contract.

## Failure behavior

If all providers fail, local filtering/playback continue unchanged and a recent cached result list may be shown. Selecting a cached result can still fail to download when offline; that failure is contained to the explicit import attempt and does not mutate the Library.

A remote source is never trusted because its extension says MIDI. The same `MidiFileImporter` and canonical expressive compiler used for local MIDI validate the downloaded bytes before the file is admitted.

## Release impact

This is client-impacting and ships as v0.10.0. Production gate and production release both run a dedicated online-discovery regression harness covering ranking, ten-result limiting, provider failure isolation, cache fallback, provider JSON contracts, download size/host safety, malformed MIDI rejection and local duplicate reuse.
