# ADR 0016: First-run client library and optional shell drag/drop

## Status
Accepted for production client reliability hardening.

## Context
A clean client could successfully download and launch the self-contained executable yet see an empty Sheet Library because the production artifact intentionally contained only `RobloxPiano.exe`. The UI also enabled WinForms OLE drag/drop during form construction. On Windows environments where OLE shell registration is unavailable or rejected, `AllowDrop` can raise `DragDrop registration did not succeed`, surfacing a client error even though file-picker import and playback do not require drag/drop.

These are first-run product failures: packaging was technically self-contained, but the client did not provide useful offline content and an optional helper could break the primary experience.

## Decision
- The managed per-user Sheet Library bootstraps three small deterministic starter sheets when and only when the managed library contains no supported song files.
- Starter content is source text compiled through the normal deterministic Legacy importer. It does not bypass validation or playback contracts and adds no external runtime/assets dependency.
- Bootstrap is idempotent and never inserts starter songs into an existing managed library.
- Shell drag/drop is an optional capability. The form first creates and displays normally, then attempts OLE drag/drop registration after the window is shown.
- Registration failures are caught, logged and degraded to the always-available `Import Song...` picker; no error dialog is shown and the core client remains usable.
- The status hint reflects whether drag/drop is actually available instead of advertising a broken path.

## Consequences
- A clean-machine first launch has playable Library rows without a separate `assets` or `sheets` download.
- The single-file Release contract remains intact.
- Users can still import TXT/VPS/MIDI/MusicXML through the deterministic source-neutral boundary.
- Shell/OLE restrictions cannot block the list-first client entrypoint.
- Existing user libraries are never overwritten or polluted by bootstrap content.

## Regression requirements
Library tests must prove starter files are valid, idempotent and absent when user content already exists. Production gate must continue publishing exactly one self-contained executable before checksum generation and validate the downloadable Release artifact.
