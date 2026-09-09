namespace RobloxPiano.App;

internal enum PlaybackSessionResultKind
{
    Completed = 0,
    Cancelled = 1,
    AuthorizationLost = 2,
    InputFailed = 3,
    SourceFailed = 4,
    RuntimeFailed = 5
}

internal sealed record PlaybackSessionResult(
    PlaybackSessionResultKind Kind,
    TimeSpan Position,
    RobloxPlaybackAuthorizationFailure? AuthorizationFailure = null,
    Exception? Exception = null)
{
    public bool ShouldReturnToLibrary => Kind == PlaybackSessionResultKind.AuthorizationLost;

    public static PlaybackSessionResult SourceFailure(Exception exception, TimeSpan position)
    {
        ArgumentNullException.ThrowIfNull(exception);
        return new PlaybackSessionResult(PlaybackSessionResultKind.SourceFailed, position, Exception: exception);
    }
}

internal static class PlaybackSessionResultCapture
{
    public static async Task<PlaybackSessionResult> RunAsync(
        Func<Task> runSession,
        Func<TimeSpan> positionProvider)
    {
        ArgumentNullException.ThrowIfNull(runSession);
        ArgumentNullException.ThrowIfNull(positionProvider);

        try
        {
            await runSession().ConfigureAwait(true);
            return new PlaybackSessionResult(PlaybackSessionResultKind.Completed, positionProvider());
        }
        catch (OperationCanceledException exception)
        {
            return new PlaybackSessionResult(PlaybackSessionResultKind.Cancelled, positionProvider(), Exception: exception);
        }
        catch (RobloxPlaybackAuthorizationException exception)
        {
            return new PlaybackSessionResult(
                PlaybackSessionResultKind.AuthorizationLost,
                positionProvider(),
                exception.Failure,
                exception);
        }
        catch (WindowsInputInjectionException exception)
        {
            return new PlaybackSessionResult(PlaybackSessionResultKind.InputFailed, positionProvider(), Exception: exception);
        }
        catch (Exception exception) when (
            exception is IOException
            or UnauthorizedAccessException
            or InvalidOperationException
            or ArgumentException
            or OverflowException)
        {
            return new PlaybackSessionResult(PlaybackSessionResultKind.RuntimeFailed, positionProvider(), Exception: exception);
        }
    }
}

internal sealed record PlaybackSessionPresentation(
    string StatusText,
    string? DialogTitle,
    string? DialogMessage,
    MessageBoxIcon DialogIcon,
    bool ReturnToLibrary);

internal static class PlaybackSessionPresentationPolicy
{
    public static PlaybackSessionPresentation Describe(PlaybackSessionResult result)
    {
        ArgumentNullException.ThrowIfNull(result);

        if (result.Kind == PlaybackSessionResultKind.AuthorizationLost)
        {
            var failure = result.AuthorizationFailure ?? RobloxPlaybackAuthorizationFailure.VerificationRequired;
            var recovery = RobloxPlaybackAuthorizationRecoveryPolicy.Describe(failure);
            return new PlaybackSessionPresentation(
                recovery.PlayerStatusText,
                recovery.DialogTitle,
                recovery.DialogMessage,
                MessageBoxIcon.Warning,
                true);
        }

        return result.Kind switch
        {
            PlaybackSessionResultKind.Completed => new PlaybackSessionPresentation(
                "Playback complete.", null, null, MessageBoxIcon.None, false),

            PlaybackSessionResultKind.Cancelled => new PlaybackSessionPresentation(
                "Playback stopped safely.", null, null, MessageBoxIcon.None, false),

            PlaybackSessionResultKind.InputFailed => new PlaybackSessionPresentation(
                "Windows input delivery failed. Diagnostics were saved automatically.",
                "Input delivery failed",
                "Playback stopped safely because Windows could not emit one or more piano keys. Open Diagnostics for the exact key/input failure, then use Test Roblox Input before trying again.",
                MessageBoxIcon.Warning,
                false),

            PlaybackSessionResultKind.SourceFailed => new PlaybackSessionPresentation(
                "The selected song could not be loaded for playback.",
                "Song could not be loaded",
                result.Exception?.Message ?? "The selected song could not be loaded.",
                MessageBoxIcon.Warning,
                false),

            _ => new PlaybackSessionPresentation(
                "Playback had a problem. Diagnostics were saved automatically.",
                "Playback stopped",
                "Playback stopped safely. Try Play again. Technical details were saved automatically in Diagnostics.",
                MessageBoxIcon.Warning,
                false)
        };
    }
}
