---
schema: 1
version: 0.32.0
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
5. When investigating Legacy x2 quality, open Support Center, start **Legacy A/B Campaign**, run the unchanged TXT/VPS song at 1.00x and then 2.00x, and inspect the controlled runtime verdict.
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
- Support Center can now create an explicit persisted Legacy reproduction campaign. Matching sessions carry the campaign provenance through their opaque session IDs into the verified Support Bundle.
- When explicit campaign provenance exists, comparison is restricted to that exact campaign and never falls back to unrelated or unscoped historical sessions.
- Older unscoped diagnostics retain the Phase 45 strict-adjacency/30-minute policy for backward-compatible support only.
- The Legacy ↔ Legacy x2 runtime verdict is diagnostic evidence only. It cannot replace the protected perceptual/listening baseline or automatically promote another playback behavior.
- Support Bundles persist privacy-safe quality and transport evidence, include an integrity manifest, and are verified before and after atomic export.
- Runtime authorization is scoped to the exact Roblox process lifetime; process replacement/restart requires verification again rather than reusing stale trust.
- Focus loss, pause/stop, failure, and cancellation retain emergency release-all/stuck-key prevention behavior.

## Phase 46 explicit Legacy reproduction campaign

- **Start Legacy A/B Campaign** snapshots a random campaign ID, canonical performance fingerprint, TXT/VPS source type, engine identity, Windows input profile and input-latency compensation for 30 minutes.
- The campaign is observability-only. Starting or cancelling it never starts playback, changes speed, seeks, authorizes Roblox, or injects input.
- A session receives campaign provenance only if its immutable session-start state still matches the campaign and its protected baseline start speed is exactly 1.00x or 2.00x.
- Changing the file/canonical track, source type, engine/input identity, latency setting, or starting at another speed fails closed: playback remains normal but the session is not admitted to the experiment.
- Campaign membership is carried in the existing opaque session ID (`baseline-{campaign}-{session}`), so exported Support Bundles retain experiment provenance without exposing full local paths or source bytes.
- For a tagged session, only the newest prior session with the same campaign ID can be its counterpart. Different campaign IDs and unscoped historical sessions are never eligible fallbacks.
- Unrelated untagged playback between the two campaign runs no longer destroys a deliberate experiment, because explicit provenance is stronger than temporal adjacency.
- Existing canonical/runtime identity, proportional 2x speed history, identical seek history, focus/interference and perceptual-promotion gates remain mandatory.

## Current boundaries

- AI is optional and is not required for playback/import/validation truth.
- Runtime timing/input evidence does not measure whether two performances sound perceptually equivalent; the protected Legacy/Legacy x2 perceptual baseline remains a separate acceptance requirement.
- The campaign guides the two runs but deliberately does not auto-run playback or force speed changes; client control remains explicit.
- Sessions from older versions have no campaign provenance and therefore use the stricter legacy adjacency heuristic rather than being retroactively assigned to a campaign.
- CI cannot observe a live Roblox client consuming synthetic input; explicit GUI input verification remains the client-side acceptance check for a real Roblox process.
- MIDI and MusicXML import canonical note/timing data; audio transcription/OMR is not silently attempted when confidence cannot be established.
- The executable is currently unsigned, so Windows SmartScreen may still show a reputation warning.
