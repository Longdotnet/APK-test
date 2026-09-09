# ADR 0006: Production release channel

## Status

Accepted

## Context

The production gate already produced a validated self-contained `RobloxPiano.exe`, but only as a GitHub Actions artifact. Actions artifacts are useful for engineering evidence and short-lived acceptance testing; they are not an appropriate client distribution surface because they are buried under workflow runs, expire, and do not provide a stable `Releases` download path.

The product contract requires a normal Windows client to find and download one executable without understanding CI, cloning the repository, or installing developer tooling.

## Decision

1. `VersionPrefix` in `Directory.Build.props` is the release version source of truth.
2. Production releases use immutable SemVer tags (`vX.Y.Z`). A published version is never silently moved to a new commit.
3. A GitHub Release is created only after the `production-gate` workflow succeeds for `main`.
4. The release workflow checks out the exact validated commit SHA, reruns the deterministic build/regression gates, publishes the self-contained `win-x64` single executable, smoke-tests it, and verifies its embedded product version.
5. Every release publishes exactly these client-facing integrity assets:
   - `RobloxPiano.exe`
   - `RobloxPiano.exe.sha256`
6. The workflow downloads the just-published EXE again and verifies its SHA-256 hash, proving the client-visible asset matches the validated candidate.
7. Existing GitHub Actions artifacts remain CI evidence only; they are not the normal client download path.
8. The stable client navigation path is GitHub `Releases`, with `/releases/latest/download/RobloxPiano.exe` available for the newest non-prerelease version.
9. Future release-worthy merges must bump `VersionPrefix`; feature slices normally bump minor while production fixes normally bump patch. The release job preserves an existing release instead of overwriting it when the version was not bumped.

## Consequences

- Clients get a visible durable Release page and a one-click EXE asset.
- The executable remains dependency-free for the client.
- CI and release provenance are linked to an exact commit.
- Release identity is reproducible and immutable instead of being a mutable `latest.exe` upload.
- Version bumps become an explicit production responsibility.
- The executable is still unsigned; SmartScreen reputation/code-signing is a separate hardening concern and must be communicated rather than hidden.
