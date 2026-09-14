---
schema: 1
version: 0.40.69
---
# Roblox Piano v{{VERSION}}

Validated commit: `{{COMMIT_SHA}}`
Distribution: self-contained Windows x64 single executable
Client dependencies: none required manually
SHA256: `{{SHA256}}`

## Client entrypoint and support contract

- **Sheet Library** remains the normal client starting point.
- **Support Bundle** remains the preferred way to preserve correlated Runtime Input and client diagnostic evidence when troubleshooting playback.
- Legacy and **Legacy x2** remain protected regression/perceptual baselines.

## Runtime Input production fix

- Production playback now uses the same Roblox-reactive Windows input semantics proven in field diagnostics: `SendInput` with physical scan-code events.
- Character-to-key mapping, focus protection, minimum key hold, held-key cleanup and emergency release behavior remain in place.
- `Verify Input & Play` and normal song playback now exercise the production Windows input sink instead of leaving the working scan-code path diagnostic-only.
- No audio-arrangement, MIDI import, song-library or unrelated client behavior is changed by this release.

## Client procedure

1. Open Roblox and enter the piano experience.
2. Start Roblox Piano from **Sheet Library** and select a valid song.
3. Use **Verify Input & Play** once for the current Roblox process when requested.
4. Confirm the W probe reacts inside Roblox, then start playback.
5. If Roblox is restarted, verify input again for the new process lifetime.
