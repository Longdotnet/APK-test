# ADR 0016: First-run library and drag/drop resilience

## Status
Accepted for production Phase 17.

## Context
A clean v0.14.1 client exposed two production problems from real Windows use:

1. the release contract intentionally ships a single `RobloxPiano.exe`, while the Sheet Library only scanned `%LOCALAPPDATA%/RobloxPiano/sheets` and an optional `sheets` folder beside the executable. A first-time user therefore saw an unexplained empty list;
2. WinForms OLE drag/drop registration could throw `DragDrop registration did not succeed` while constructing the main form. Drag/drop is only an import helper, but the exception was surfaced as a product error and could block the normal first-run experience.

## Decision
- Keep the single-file release contract. Do not require an external assets/sheets bundle.
- Seed two small original deterministic starter sheets into the managed LocalAppData library only when both managed and portable catalogs are empty.
- Validate starter sheet content through the same deterministic legacy parser before writing it.
- Never overwrite or add starter content when the user already has any library song.
- Add an explicit `Open Library Folder` action so users do not need to know or guess the LocalAppData path.
- Use an explicit synchronous STA executable entrypoint for WinForms/OLE startup.
- Treat drag/drop registration as optional capability. If Windows still rejects OLE registration because of desktop/elevation/session constraints, log the failure and keep `Import Song...`, online discovery, Library browsing and playback usable.

## Consequences
- A clean client immediately shows playable offline content without network or manual dependencies.
- Normal releases remain one self-contained `RobloxPiano.exe` plus checksum.
- The authoritative managed song folder remains `%LOCALAPPDATA%/RobloxPiano/sheets`; a `sheets` directory beside the executable remains an optional portable catalog.
- Drag/drop can no longer be a startup blocker.
- AI/network availability remains irrelevant to first-run playback truth.
- Legacy playback and the Legacy x2 regression baseline are unchanged.
