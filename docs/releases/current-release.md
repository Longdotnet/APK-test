---
schema: 1
version: 0.35.0
---
# Roblox Piano v{{VERSION}}

Validated commit: `{{COMMIT_SHA}}`
Distribution: self-contained Windows x64 single executable
Client dependencies: none required manually
SHA256: `{{SHA256}}`

## Client flow

1. Download `RobloxPiano.exe` and double-click it; the Sheet Library remains the normal starting point.
2. Open Roblox, enter the target piano game, select or import a playable song, and use **Verify Input & Play** when the current Roblox process has not yet been confirmed.
3. Keep Roblox focused while playback is active. Losing target focus fails closed for input and transport cleanup releases held keys/pedal state.
4. Use Play/Pause/Stop/Seek and speed controls from the production desktop client; deterministic transport state remains authoritative.
5. When investigating Legacy x2 quality, open Support Center and start **Legacy A/B Campaign**. Step 1 is Legacy 1.00x and Step 2 is Legacy x2 2.00x on the same unchanged TXT/VPS performance and controlled transport history.
6. Completed explicit campaigns are now persisted into a verified local experiment archive automatically; saving a Support Bundle can still emit a verified `.legacy-ab.json` sidecar for sharing.

## Production capability and reliability in this release

- Sheet Library is list-first; Browse and drag/drop remain import helpers rather than the primary workflow.
- The production client is a self-contained single EXE and requires no manual Python, Node, .NET SDK, Visual Studio, or PowerShell-module installation.
- Legacy and Legacy x2 remain preserved regression/perceptual baselines and are not silently replaced by newer playback work.
- Playback uses a canonical performance timeline isolated from TXT, MIDI, MusicXML, UI, AI, and the Windows input backend.
- Runtime transport evidence records deterministic timing, Windows input-call latency, focus interruptions, missing/interrupted edges, release-all evidence, and an ordered speed/seek control ledger.
- Playback-session diagnostics snapshot canonical track identity and immutable runtime/session-start provenance so later source-file edits or preference changes cannot rewrite evidence for the session that actually ran.
- Controlled same-settings A/B comparison fails closed unless canonical performance identity, runtime/input identity, start settings, latency compensation, and ordered transport history are equivalent.
- Support Center exposes a controlled Legacy ↔ Legacy x2 runtime comparison for TXT/VPS baseline runs: 1.0x and 2.0x must use the same canonical performance/runtime/input identity, the same latency compensation, identical seek positions, and speed transitions proportional by exactly 2x.
- Explicit Legacy reproduction campaigns carry privacy-safe campaign provenance through opaque session IDs into the verified Support Bundle and never fall back to unrelated historical sessions.
- Guided campaign admission enforces exactly one Legacy 1.00x session first and one Legacy x2 2.00x session second. Wrong-order, duplicate or changed-condition playback remains normal but is excluded from new campaign evidence.
- A completed explicit campaign emits a verifiable immutable experiment manifest containing the exact locked session IDs, canonical/runtime identity, deterministic runtime verdict, measured deltas, normalized transport-equivalence SHA-256 and a second SHA-256 over all manifest evidence fields.
- Completed manifests are now copied into a durable bounded archive immediately after the completing session is safely persisted. Historical experiment evidence therefore survives active-campaign expiry and recent-session rotation.
- Archive admission and reads verify the manifest; identical re-archive is idempotent, conflicting evidence for the same campaign identity is rejected, and corrupt entries fail closed without hiding other valid experiments.
- Archive retention is bounded to the newest 50 verified experiments; unverifiable entries are retained for manual inspection rather than silently deleted.
- Experiment archive/manifest generation is diagnostics-only: archive or sidecar failure is logged without weakening the verified support bundle or changing playback behavior.
- Campaign progress is derived deterministically from persisted support-safe session evidence as `AwaitLegacy`, `AwaitLegacyX2`, `Completed` or `Invalidated`.
- Completed or invalid campaigns stop accepting new tagged sessions, preventing later playback from changing an already established experiment pair.
- Older unscoped diagnostics retain the strict-adjacency/30-minute policy for backward-compatible support only.
- The Legacy ↔ Legacy x2 runtime verdict is diagnostic evidence only. It cannot replace the protected perceptual/listening baseline or automatically promote another playback behavior.
- Support Bundles persist privacy-safe quality and transport evidence, include an integrity manifest, and are verified before and after atomic export.
- Runtime authorization is scoped to the exact Roblox process lifetime; process replacement/restart requires verification again rather than reusing stale trust.
- Focus loss, pause/stop, failure, and cancellation retain emergency release-all/stuck-key prevention behavior.

## Phase 49 durable completed experiment archive

- The Step-2 session persistence path attempts archive capture only after structured diagnostics and the latest support bundle are written and verified.
- Archive capture reuses the Phase 48 completed-manifest builder, so incomplete, expired, invalidated, malformed, cross-campaign, or uncontrolled transport pairs cannot enter the archive.
- Archive files use completion time plus campaign id as stable identity and are written with the same verified atomic writer as exported manifests.
- Repeating capture for an identical campaign/evidence hash returns the same entry without creating duplicates.
- If the same archive identity already exists with different verified evidence, persistence fails closed rather than overwriting prior experiment history.
- Reading the archive verifies every returned manifest. A corrupt/unreadable entry is logged and skipped while remaining valid experiments stay available.
- Retention keeps the newest 50 verified experiments. Unverifiable files are intentionally not garbage-collected because their chronology/identity cannot be trusted.
- The durable archive keeps only privacy-safe experiment evidence and adds no sheet paths, source bytes, usernames, machine names, account identifiers, or raw input samples.
- Archive failure is isolated from playback/session truth: a completed playback session remains completed even when diagnostics storage is unavailable.

## Current boundaries

- AI is optional and is not required for playback/import/validation truth.
- Runtime timing/input evidence does not measure whether two performances sound perceptually equivalent; the protected Legacy/Legacy x2 perceptual baseline remains a separate acceptance requirement.
- Guided campaigns deliberately do not auto-run playback, change speed, seek, authorize Roblox, or inject input; client control remains explicit.
- The completed experiment manifest remains a support-export sidecar rather than a fourth entry inside the support ZIP, preserving the support-bundle verifier contract.
- The archive is local diagnostics evidence; client-facing archive browsing/re-export UX can build on this verified store without reconstructing old experiments from current session history.
- Sessions from older versions with no campaign provenance continue using the stricter legacy adjacency heuristic rather than being retroactively assigned to a campaign.
- CI cannot observe a live Roblox client consuming synthetic input; explicit GUI input verification remains the client-side acceptance check for a real Roblox process.
- MIDI and MusicXML import canonical note/timing data; audio transcription/OMR is not silently attempted when confidence cannot be established.
- The executable is currently unsigned, so Windows SmartScreen may still show a reputation warning.
