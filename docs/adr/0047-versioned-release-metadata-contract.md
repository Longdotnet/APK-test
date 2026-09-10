# ADR 0047: Versioned release metadata contract

## Status

Accepted for Production Phase 42.

## Context

The production release workflow correctly built, checksummed, uploaded, downloaded, and re-hashed `RobloxPiano.exe`, but its GitHub Release body was a hard-coded PowerShell here-string. As the client evolved through transport-aware quality evidence, immutable session provenance, and persisted transport-history comparison, the executable advanced while the public Release body remained anchored to an older authorization-recovery phase.

A valid binary with stale public capability notes is a production defect: clients and support staff can make incorrect decisions even though CI is green.

## Decision

1. `docs/releases/current-release.md` is the versioned source of truth for the next production Release body.
2. The document declares `schema: 1` and a strict SemVer `version` in front matter. That version must exactly equal `Directory.Build.props` `VersionPrefix`.
3. The document carries exactly one each of `{{VERSION}}`, `{{COMMIT_SHA}}`, and `{{SHA256}}`. Only those immutable build-time facts are injected by the release workflow.
4. `production-gate` validates the notes contract before expensive build/test/publish work and requires the current Sheet Library, Legacy x2 baseline, and Support Bundle contracts to remain represented.
5. `production-release` repeats the validation on the exact main SHA that passed `production-gate`, renders the notes after the final EXE checksum exists, and refuses unresolved placeholders.
6. After GitHub Release creation, the workflow reads the Release back and verifies tag, title, exact target SHA, embedded SHA/checksum evidence, required assets, and downloaded EXE hash.
7. Published versions/tags remain immutable. A metadata correction for future clients requires a new SemVer version; no prior tag is moved or overwritten.

## Consequences

- Release notes evolve in normal code review beside the production changes they describe.
- A version bump without matching Release metadata fails before merge/release validation can succeed.
- A workflow refactor cannot silently republish stale capability text from a fixed script block.
- Public Release metadata becomes part of the same exact-SHA evidence chain as the executable and checksum.
- Existing self-contained distribution, deterministic playback truth, Legacy/Legacy x2 baselines, focus safety, release-all, importers, and support diagnostics are unchanged.

## Validation

Production gates must prove:

- `VersionPrefix` and release-notes front-matter version match exactly;
- required placeholders exist exactly once;
- current client entrypoint/regression/support contracts remain present;
- rendered notes contain the exact validated SHA and EXE SHA-256 with no unresolved placeholders;
- GitHub Release read-back matches tag/title/target SHA and contains both required assets;
- downloaded `RobloxPiano.exe` hashes to the exact release candidate;
- the existing deterministic build, regression, transport, input safety, import, quality, desktop recovery, self-contained publish, and client smoke gates remain green.
