# ADR 0012: Safe self-update for the single-EXE client

## Status
Accepted

## Context

Roblox Piano now ships frequently through immutable GitHub Releases. The normal client distribution is one self-contained `RobloxPiano.exe`, but without an update path a client must return to GitHub, identify the newest release and replace the executable manually.

A conventional installer/updater would reintroduce exactly the client dependencies this product removed. More importantly, update/network state must never become part of deterministic playback truth: a client with no internet connection must retain the same local Library, parsing, transport and keyboard-safety behavior.

## Decision

Self-update is an optional client convenience layered above the deterministic product core.

### Release discovery

- Only the latest stable GitHub Release from `Longdotnet/APK-test` is considered.
- Release versions use strict `vX.Y.Z` ordering. Same-version and downgrade candidates are ignored.
- A candidate release must target an immutable 40-character commit SHA rather than a moving branch name.
- `RobloxPiano.exe` and `RobloxPiano.exe.sha256` are both mandatory assets.
- The executable asset is size-bounded before staging.

Update checks run asynchronously after the Sheet Library is usable. Failure, timeout, malformed metadata or no network hides the update surface and leaves local Library/playback unaffected.

### Download trust

Downloads must begin at the GitHub release origin over HTTPS. Redirects are followed manually and only to the explicit GitHub release-asset host allowlist.

The checksum file must identify exactly `RobloxPiano.exe` and contain exactly one SHA-256 value. If GitHub exposes an asset SHA-256 digest, that digest and the checksum asset must agree before the executable is downloaded. Downloaded bytes are then re-hashed, size-checked against release metadata, written through a temporary file, and re-hashed from disk before the staged file becomes eligible for installation.

### Replacement model

The new executable is staged under `%LOCALAPPDATA%\RobloxPiano\updates\<tag>\RobloxPiano.exe`.

No helper program, script, installer or external runtime is introduced. The staged new `RobloxPiano.exe` acts as the temporary updater:

1. the running client launches the staged executable with an internal updater command;
2. the current client exits normally;
3. the staged executable waits for the original process to terminate;
4. it re-verifies its own SHA-256;
5. it copies a verified candidate beside the installed executable;
6. replacement uses the filesystem's target-side replace operation with a temporary backup;
7. the final installed executable is re-hashed;
8. only after verification succeeds is the backup removed and the updated client restarted.

Pre-replacement verification failure leaves the installed executable untouched. A final verification failure attempts to restore the backup and is treated as an update failure, not as permission to continue silently.

### Installation boundary

Automatic replacement is available only when the current process is the real `RobloxPiano.exe` outside the updater staging root. `dotnet.exe`, test hosts and staged updater copies are not treated as installed clients.

The update banner is explicit and non-blocking. The client chooses **Update & Restart** or **Later**; update availability never blocks Play.

### CI escape hatch

The internal `--ci-no-restart` flag exists only when `ROBLOXPIANO_UPDATE_TEST=1`. Production-gate and production-release use it to execute the actual published single executable from the real updater staging root, replace a disposable target executable, and verify the final SHA-256 without opening the GUI. Normal users cannot use this flag to suppress the updater contract accidentally.

## Invariants preserved

- AI remains optional and is not involved in update truth or mutation.
- Offline Library and playback remain fully usable when update infrastructure is unavailable.
- Legacy TXT/VPS and the protected Legacy x2 baseline are unchanged.
- MIDI lowering, expressive sustain, transport, held-key ownership, focus loss and release-all safety are unchanged.
- The client distribution remains one self-contained Windows x64 executable.
- Published tags/releases are immutable identities; a new client-impacting phase must use a new `VersionPrefix`.

## Verification

The updater regression harness covers strict version ordering, release-contract validation, same/older-version rejection, trusted and untrusted redirects, checksum/digest/size staging, evidence disagreement, atomic replacement and preservation of the old target on pre-replacement verification failure.

The production gate additionally publishes the real single EXE and executes its internal updater mode against a disposable target. The production-release workflow repeats both updater regressions and the real published-EXE replacement smoke before release creation, then retains the existing post-publish download/hash verification.
