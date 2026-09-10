# ADR 0051: Explicit Legacy baseline reproduction campaigns

## Status

Accepted for Production Phase 46.

## Context

Phases 43-45 made Legacy ↔ Legacy x2 runtime comparison fail closed and progressively removed historical cherry-picking. The remaining weakness was provenance: temporal adjacency could show that two runs were nearby and technically equivalent, but could not prove that the client deliberately created them as one reproduction experiment.

A production diagnostic must not infer experiment membership from filenames, timestamps, or convenient history when the product can capture that intent directly.

## Decision

Support Center can start an explicit, persisted Legacy A/B campaign for the currently selected TXT/VPS performance.

The campaign snapshots only the facts required to bind future baseline sessions safely:

- random campaign GUID;
- creation/expiry timestamps with a 30-minute lifetime;
- canonical `PerformanceTrack` SHA-256 fingerprint;
- TXT/VPS source type;
- input-latency compensation;
- playback-engine identity;
- Windows input-profile identity.

The campaign never owns playback state, changes speed, starts playback, seeks, authorizes Roblox, or emits input. The client still performs each run through the normal deterministic production transport.

A playback session is tagged only when its immutable session-start state still matches the persisted campaign and starts at a protected baseline speed (1.00x or 2.00x). If the source, canonical performance, runtime/input identity, latency setting, or protected speed no longer matches, tagging fails closed and playback proceeds normally as an unscoped session.

Campaign membership is encoded into the existing opaque session identifier as `baseline-{campaign-guid-N}-{session-guid-N}`. Session IDs already travel through persistent JSONL diagnostics and privacy-safe Support Bundles, so this carries explicit provenance through export without introducing a second mutable join table or exposing local source paths/bytes.

For sessions with campaign provenance, Legacy comparison may select only prior sessions carrying the exact same campaign GUID. It must never fall back to unscoped history or another campaign. The newest prior session within that campaign remains the sole candidate, so repeated same-variant or changed-transport runs still fail closed rather than cherry-picking an earlier clean member.

Sessions recorded before Phase 46 remain readable. When no explicit campaign provenance exists, the Phase 45 strict-adjacency/30-minute policy remains only as backward-compatible diagnostic behavior.

## Safety and product invariants

- Campaign state is diagnostics metadata only; deterministic transport remains playback truth.
- AI/network/quota are not involved.
- Legacy remains the protected default baseline; no campaign result can auto-promote Legacy x2.
- Focus loss, cancellation, failures and emergency release-all behavior are unchanged.
- Campaign IDs are random non-account identifiers and reveal no username, machine name, local path or source bytes.
- Invalid, malformed, expired or unreadable campaign state fails closed and cannot block ordinary playback.

## Validation

Regression coverage must prove that:

1. same-campaign Legacy and Legacy x2 can pair even when an unrelated untagged session occurs between them;
2. different campaigns never pair;
3. an explicit campaign never falls back to compatible unscoped history;
4. malformed campaign session IDs are treated as unscoped;
5. existing unscoped Phase 45 adjacency behavior remains intact;
6. proportional speed/seek history, interference and canonical/runtime identity gates remain enforced.

## Consequences

Runtime A/B evidence can now distinguish an intentional reproduction campaign from merely nearby history. The campaign remains deliberately manual: Support Center guides the client to run 1.00x and 2.00x, but does not automate Roblox input or change playback settings on the user's behalf. A future phase may add campaign progress/step enforcement or reference-audio evidence without weakening this provenance boundary.
