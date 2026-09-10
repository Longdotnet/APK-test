---
schema: 1
version: 0.31.1
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
- Legacy ↔ Legacy x2 counterpart selection is now bounded to the newest same-identity protected baseline within 30 minutes. It never skips a newer failed/mismatched reproduction attempt to cherry-pick an older session.
- The Legacy ↔ Legacy x2 runtime verdict is diagnostic evidence only. It cannot replace the protected perceptual/listening baseline or automatically promote another playback behavior.
- Support Bundles persist privacy-safe quality and transport evidence, include an integrity manifest, and are verified before and after atomic export.
- Runtime authorization is scoped to the exact Roblox process lifetime; process replacement/restart requires verification again rather than reusing stale trust.
- Focus loss, pause/stop, failure, and cancellation retain emergency release-all/stuck-key prevention behavior.

## Phase 44 bounded Legacy reproduction pairing

- Protected Legacy baseline evidence must be fresh: only prior same-identity baseline sessions from the last 30 minutes are eligible.
- The newest protected baseline with the same canonical fingerprint, source type, engine, Windows input profile and latency compensation is the only candidate. Older sessions are never searched as fallback evidence.
- If that newest run is the same variant, Support Center returns `NotComparable` and asks for the opposite variant next instead of reusing an older run.
- If that newest opposite variant changed seek targets or violated the exact 2x speed-history relationship, Support Center returns `NotComparable` and asks for a fresh back-to-back pair.
- This prevents stale-session reuse and historical cherry-picking while preserving the existing focus/dispatch/playback interference gate.
- The 30-minute bound affects diagnostics evidence only; it does not alter playback, authorization lifetime, scheduler timing, input dispatch or release-all behavior.

## Current boundaries

- AI is optional and is not required for playback/import/validation truth.
- Runtime timing/input evidence does not measure whether two performances sound perceptually equivalent; the protected Legacy/Legacy x2 perceptual baseline remains a separate acceptance requirement.
- This release hardens historical pairing but does not yet create an explicit persisted comparison campaign ID or automatically run the two baselines.
- CI cannot observe a live Roblox client consuming synthetic input; explicit GUI input verification remains the client-side acceptance check for a real Roblox process.
- MIDI and MusicXML import canonical note/timing data; audio transcription/OMR is not silently attempted when confidence cannot be established.
- The executable is currently unsigned, so Windows SmartScreen may still show a reputation warning.
