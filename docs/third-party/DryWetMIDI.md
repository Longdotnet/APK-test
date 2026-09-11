# DryWetMIDI

Roblox Piano uses `Melanchall.DryWetMidi.Nativeless` **8.0.3** only to write Standard MIDI Files for generated Audio-to-Piano results.

- Upstream: https://github.com/melanchall/drywetmidi/tree/v8.0.3
- Package: `Melanchall.DryWetMidi.Nativeless` 8.0.3
- License: MIT
- Copyright: Copyright (c) 2018 Maxim Dobroselsky

The nativeless package is intentional: generated-track persistence needs SMF serialization, not MIDI devices, playback, recording, or native multimedia integrations. `RobloxPiano.Core.PerformanceTrack` remains authoritative; DryWetMIDI never schedules Roblox input or owns playback state.

Before a generated MIDI is committed to the managed Library, Roblox Piano reads the produced bytes back through its existing production `MidiFileImporter` and verifies Roblox-key identity plus start/end timing parity within one MIDI tick. A failed parity check leaves no Library file behind.

The full MIT license text is embedded in the production executable and is available through `RobloxPiano.exe --third-party-notices`.
