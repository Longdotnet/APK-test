---
schema: 1
version: 0.33.0
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
6. Save the verified Support Bundle when troubleshooting or sharing diagnostic evidence.

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
- Guided campaign admission now enforces the experiment order: exactly one Legacy 1.00x session first, then one Legacy x2 2.00x session. Wrong-order, duplicate or changed-condition playback remains normal but is excluded from new campaign evidence.
- Campaign progress is derived deterministically from persisted support-safe session evidence as `AwaitLegacy`, `AwaitLegacyX2`, `Completed` or `Invalidated`.
- Completed or invalid campaigns stop accepting new tagged sessions, preventing later playback from changing an already established experiment pair.
- Older unscoped diagnostics retain the Phase 45 strict-adjacency/30-minute policy for backward-compatible support only.
- The Legacy ↔ Legacy x2 runtime verdict is diagnostic evidence only. It cannot replace the protected perceptual/listening baseline or automatically promote another playback behavior.
- Support Bundles persist privacy-safe quality and transport evidence, include an integrity manifest, and are verified before and after atomic export.
- Runtime authorization is scoped to the exact Roblox process lifetime; process replacement/restart requires verification again rather than reusing stale trust.
- Focus loss, pause/stop, failure, and cancellation retain emergency release-all/stuck-key prevention behavior.

## Phase 47 guided Legacy A/B campaign state machine

- **Start Legacy A/B Campaign** snapshots a random campaign ID, canonical TXT/VPS performance fingerprint, engine identity, Windows input profile and input-latency compensation for 30 minutes.
- A new campaign begins in `AwaitLegacy`; only an otherwise matching Legacy 1.00x session can be admitted as Step 1.
- After valid Step 1 evidence is persisted, the campaign transitions to `AwaitLegacyX2`; only an otherwise matching Legacy x2 2.00x session can be admitted as Step 2.
- A valid ordered pair transitions to `Completed`. Completed campaigns no longer tag later playback, so additional sessions cannot silently replace or contaminate the pair.
- Persisted campaign evidence that violates canonical/runtime identity, order, protected variant, transport equivalence, campaign lifetime, or contains ambiguous extra tagged sessions transitions to `Invalidated` and fails closed for further membership.
- Campaign membership remains diagnostics-only. If session history cannot be read or campaign progress cannot be proven, playback continues with an ordinary unscoped session ID; diagnostics problems do not block scheduler/input behavior.
- Support Center displays the campaign state plus the exact next action and disables starting a replacement campaign while a valid two-step reproduction is still in progress. Cancel remains available.
- Step 2 must retain the existing controlled transport contract: identical seek targets and speed transitions scaled exactly 2x relative to Step 1.
- Starting Legacy x2 before Legacy, repeating Legacy when Step 2 is expected, changing the campaign song/runtime/latency conditions, or producing mismatched transport history cannot be repaired by cherry-picking older evidence. Start a fresh campaign instead.
- Existing opaque campaign/session provenance remains privacy-safe; no full local path, source bytes, raw key stream, username or machine identity is introduced by this state machine.

## Current boundaries

- AI is optional and is not required for playback/import/validation truth.
- Runtime timing/input evidence does not measure whether two performances sound perceptually equivalent; the protected Legacy/Legacy x2 perceptual baseline remains a separate acceptance requirement.
- Guided campaigns deliberately do not auto-run playback, change speed, seek, authorize Roblox, or inject input; client control remains explicit.
- An active campaign created by an older client can be invalidated after upgrade if its already-tagged evidence does not satisfy the new ordered state machine; starting a fresh campaign is the fail-closed recovery path.
- Sessions from older versions with no campaign provenance continue using the stricter legacy adjacency heuristic rather than being retroactively assigned to a campaign.
- CI cannot observe a live Roblox client consuming synthetic input; explicit GUI input verification remains the client-side acceptance check for a real Roblox process.
- MIDI and MusicXML import canonical note/timing data; audio transcription/OMR is not silently attempted when confidence cannot be established.
- The executable is currently unsigned, so Windows SmartScreen may still show a reputation warning.
