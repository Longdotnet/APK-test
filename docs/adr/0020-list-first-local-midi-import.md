# ADR 0020: List-first local MIDI import

## Status
Accepted for production client v0.16.0.

## Context
The client already understood `.mid` and `.midi` as canonical playback sources, but local import was exposed only through a generic "Import Song" action. That made a real user workflow unnecessarily implicit: a user with one MIDI, many MIDI files, or a folder of songs should be able to add them to the Sheet Library and then choose from a persistent list.

Repeated imports also created numbered copies even when file contents were identical. For a library-oriented client this produces noisy duplicate rows and makes large local collections harder to manage.

## Decision

### 1. MIDI import is a first-class Library action
The desktop Library exposes explicit actions for importing MIDI files and a MIDI collection folder. Multi-select and drag/drop remain supported. Imported files do not bypass the Library to start playback; every valid source is copied into the managed Library and appears as a normal persistent row.

### 2. Batch ingestion stays deterministic
Batch input paths are normalized and sorted before processing. Directories are traversed deterministically for supported song files. A bounded safety limit prevents accidental recursive import of an unbounded filesystem tree.

Every candidate is parsed through the existing production `SongSourceLoader` before it can enter the managed Library. Invalid MIDI never becomes a playable row.

### 3. Duplicate identity is content-based
Batch import computes SHA-256 over valid source bytes and compares them with already-managed valid songs. Identical content is mapped to the existing Library row rather than creating `song (2).mid`, `song (3).mid`, and so on.

This deduplication applies to the list-oriented batch path. The lower-level single-file `Import` API keeps its existing collision-safe copy semantics for compatibility.

### 4. Source type is visible in the list
`SheetLibraryEntry` exposes a deterministic display format (`MIDI`, `MusicXML`, `VPS`, `TXT`) so the Library UI can show what kind of source each row came from and search by source type.

## Consequences
- Local MIDI collections become a list-first workflow instead of a browse-and-immediately-play workflow.
- Importing a folder can create many persistent playable rows in one operation.
- Duplicate MIDI content does not spam the Library list.
- Legacy TXT/VPS, MusicXML, online discovery, canonical playback, Legacy/Legacy x2, Roblox focus/input safety and release-all ownership remain unchanged.
- This does not implement audio-to-MIDI transcription. `.mp3`, `.wav`, `.flac`, etc. remain outside the deterministic playback-source contract until a dedicated MIR/transcription phase is production-ready.
