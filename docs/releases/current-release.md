---
schema: 1
version: 0.34.0
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
5. When investigating Legacy x2 quality, open Support Center and start **Legacy A/B Campaign**. The guided campaign shows the exact next action: Step 1 is Legacy 1.00x; after that evidence is recorded, Step 2 is Legacy x2 2.00x on the same unchanged TXT/VPS performance and controlled transport history.
6. Save the verified Support Bundle when troubleshooting or sharing diagnostic evidence. A completed explicit Legacy A/B campaign also emits a verified `.legacy-ab.json` experiment sidecar beside the exported ZIP.

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
- A completed explicit campaign can now emit a verifiable immutable experiment manifest containing the exact locked session IDs, canonical/runtime identity, deterministic runtime verdict, measured deltas, normalized transport-equivalence SHA-256 and a second SHA-256 over all manifest evidence fields.
- Experiment manifest verification fails closed on malformed campaign/session provenance or content tampering, and export uses temporary-file read-back verification before atomic replacement.
- Experiment manifest generation is diagnostics-only: a sidecar failure is logged without weakening the already-verified support ZIP or changing playback behavior.
- Campaign progress is derived deterministically from persisted support-safe session evidence as `AwaitLegacy`, `AwaitLegacyX2`, `Completed` or `Invalidated`.
- Completed or invalid campaigns stop accepting new tagged sessions, preventing later playback from changing an already established experiment pair.
- Older unscoped diagnostics retain the Phase 45 strict-adjacency/30-minute policy for backward-compatible support only.
- The Legacy ↔ Legacy x2 runtime verdict is diagnostic evidence only. It cannot replace the protected perceptual/listening baseline or automatically promote another playback behavior.
- Support Bundles persist privacy-safe quality and transport evidence, include an integrity manifest, and are verified before and after atomic export.
- Runtime authorization is scoped to the exact Roblox process lifetime; process replacement/restart requires verification again rather than reusing stale trust.
- Focus loss, pause/stop, failure, and cancellation retain emergency release-all/stuck-key prevention behavior.

## Phase 48 verifiable completed experiment manifest

- Support export derives the manifest only from an explicit campaign that still evaluates to `Completed`; incomplete, expired, invalidated or unscoped histories do not produce one.
- The locked Step-1 and Step-2 session IDs must both still exist in recent structured diagnostics, match the campaign canonical/runtime identity and satisfy the existing proportional-speed/identical-seek controlled-counterpart policy.
- The x2 comparison must resolve back to the exact locked Legacy session. A `NotComparable` result cannot be serialized as completed experiment evidence.
- `transportEquivalenceSha256` fingerprints the ordered Legacy/x2 control histories used for the controlled-pair proof.
- `evidenceSha256` covers campaign identity, timestamps, canonical fingerprint, source type, latency compensation, engine/input profile, both session IDs, verdict/deltas and the transport proof hash.
- Verification additionally proves both opaque session IDs belong to the manifest campaign. Recomputing a content hash with session IDs from another campaign still fails closed.
- The sidecar intentionally excludes full local sheet paths, source bytes, usernames, machine names, account identifiers and raw key-by-key timing samples.
- The export contract is additive and backward compatible: the existing three-entry verified support ZIP is unchanged; when completed experiment evidence exists, `<support-zip>.legacy-ab.json` is written beside it.
- If no completed campaign exists, any stale sidecar at the selected destination is removed rather than being accidentally reused for a later unrelated support export.
- Sidecar creation/verification errors are diagnostic failures only and cannot block or mutate deterministic playback truth.

## Current boundaries

- AI is optional and is not required for playback/import/validation truth.
- Runtime timing/input evidence does not measure whether two performances sound perceptually equivalent; the protected Legacy/Legacy x2 perceptual baseline remains a separate acceptance requirement.
- Guided campaigns deliberately do not auto-run playback, change speed, seek, authorize Roblox, or inject input; client control remains explicit.
- The completed experiment manifest is a support-export sidecar rather than a fourth entry inside the support ZIP, preserving the existing support-bundle schema/verifier contract.
- Sessions from older versions with no campaign provenance continue using the stricter legacy adjacency heuristic rather than being retroactively assigned to a campaign.
- CI cannot observe a live Roblox client consuming synthetic input; explicit GUI input verification remains the client-side acceptance check for a real Roblox process.
- MIDI and MusicXML import canonical note/timing data; audio transcription/OMR is not silently attempted when confidence cannot be established.
- The executable is currently unsigned, so Windows SmartScreen may still show a reputation warning.
