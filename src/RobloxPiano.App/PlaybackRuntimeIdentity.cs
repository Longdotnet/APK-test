namespace RobloxPiano.App;

/// <summary>
/// Stable identifiers persisted with playback diagnostics so support A/B never compares
/// evidence produced by different runtime engines or Windows input profiles.
/// </summary>
internal static class PlaybackRuntimeIdentity
{
    internal const string Engine = "production-transport-v1";
    internal const string InputProfile = "roblox-player:keybd_event:focus-guarded-v1";
}
