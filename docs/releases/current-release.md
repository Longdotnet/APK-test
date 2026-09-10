---
schema: 1
version: 0.31.2
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
5. When troubleshooting, open Support Center to inspect recent session-quality verdicts, controlled comparisons and save a verified Support Bundle.

## Production capability and reliability in this release

- Sheet Library is list-first; Browse and drag/drop remain import helpers rather than the primary workflow.
- The production client is a self-contained single EXE and requires no manual Python, Node, .NET SDK, Visual Studio, or PowerShell-module installation.
- Legacy and Legacy x2 remain preserved regression/perceptual baselines and are not silently replaced by newer playback work.
- Playback uses a canonical performance timeline isolated from TXT, MIDI, MusicXML, UI, AI, and the Windows input backend.
- Runtime transport evidence records deterministic timing, Windows input-call latency, focus interruptions, missing/interrupted edges, release-all evidence, and an ordered speed/seek control ledger.
- Playback-session diagnostics snapshot canonical track identity and immutable runtime/session-start provenance so later source-file edits or preference changes cannot rewrite evidence for the session that actually ran.
- Controlled same-settings A/B comparison fails closed unless canonical performance identity, runtime/input identity, start settings, latency compensation, and ordered transport history are equivalent.
- Support Center exposes a controlled Legacy ↔ Legacy x2 runtime comparison for TXT/VPS baseline runs: 1.0x and 2.0x must use the same canonical performance/runtime/input identity, the same latency compensation, identical seek positions, and speed transitions proportional by exactly 2x.
- Protected Legacy ↔ Legacy x2 pairing now requires the immediately previous protected baseline session globally within 30 minutes. A baseline run for another song/runtime identity breaks the reproduction sequence instead of being skipped to cherry-pick older evidence.
- The Legacy ↔ Legacy x2 runtime verdict is diagnostic evidence only. It cannot replace the protected perceptual/listening baseline or automatically promote another playback behavior.
- Support Bundles persist privacy-safe quality and transport evidence, include an integrity manifest, and are verified before and after atomic export.
- Runtime authorization is scoped to the exact Roblox process lifetime; process replacement/restart requires verification again rather than reusing stale trust.
- Focus loss, pause/stop, failure, and cancellation retain emergency release-all/stuck-key prevention behavior.

## Phase 45 strict Legacy reproduction adjacency

- Protected Legacy baseline evidence remains fresh: only prior protected baseline sessions from the last 30 minutes are eligible.
- The immediately previous protected baseline session globally is the only candidate. Identity checks happen after that session is selected; the comparator never searches farther back for a more convenient match.
- If that immediately previous baseline belongs to another canonical performance, source type, playback engine, Windows input profile, or input-latency setting, Support Center returns `NotComparable` and asks for a fresh back-to-back pair.
- If the immediately previous baseline is the same variant or its seek/speed history violates the controlled 2x relationship, it also blocks the comparison rather than allowing fallback to older evidence.
- This closes cross-song and cross-runtime historical cherry-picking such as `Legacy song A → Legacy song B → Legacy x2 song A` being incorrectly paired with the older song-A run.
- The adjacency rule affects diagnostics evidence only; it does not alter playback truth, Legacy defaults, scheduler timing, authorization lifetime, input dispatch, focus safety, or release-all behavior.

## Current boundaries

- AI is optional and is not required for playback/import/validation truth.
- Runtime timing/input evidence does not measure whether two performances sound perceptually equivalent; the protected Legacy/Legacy x2 perceptual baseline remains a separate acceptance requirement.
- This release strengthens reproduction adjacency but does not yet create an explicit persisted comparison campaign ID or automatically run the two baselines.
- CI cannot observe a live Roblox client consuming synthetic input; explicit GUI input verification remains the client-side acceptance check for a real Roblox process.
- MIDI and MusicXML import canonical note/timing data; audio transcription/OMR is not silently attempted when confidence cannot be established.
- The executable is currently unsigned, so Windows SmartScreen may still show a reputation warning.
