using System.Diagnostics;

namespace RobloxPiano.App;

/// <summary>
/// Cooperative cross-process lease for review-draft mutations and destructive evidence GC.
/// The lease is acceleration/safety coordination only; it never authorizes restore or playback.
/// Ownership is the lifetime of an exclusive FileStream handle, so the OS releases it when a
/// process exits or crashes. The sentinel file intentionally remains on disk and carries no state.
/// </summary>
internal sealed class AudioReviewDraftStorageLease : IDisposable
{
    internal const string FileName = "review-storage.lease";
    internal static readonly TimeSpan WriterAcquireTimeout = TimeSpan.FromSeconds(5);
    internal static readonly TimeSpan MaintenanceAcquireTimeout = TimeSpan.FromMilliseconds(250);
    private static readonly TimeSpan RetryDelay = TimeSpan.FromMilliseconds(25);

    private readonly FileStream stream;
    private bool disposed;

    private AudioReviewDraftStorageLease(FileStream stream)
        => this.stream = stream;

    public static async Task<AudioReviewDraftStorageLease> AcquireAsync(
        AudioReviewDraftStore store,
        CancellationToken cancellationToken = default)
        => await AcquireAsync(GetRootDirectory(store), WriterAcquireTimeout, cancellationToken).ConfigureAwait(false);

    internal static async Task<AudioReviewDraftStorageLease> AcquireAsync(
        string rootDirectory,
        TimeSpan timeout,
        CancellationToken cancellationToken = default)
    {
        ArgumentException.ThrowIfNullOrWhiteSpace(rootDirectory);
        if (timeout < TimeSpan.Zero)
            throw new ArgumentOutOfRangeException(nameof(timeout));

        var root = Path.GetFullPath(rootDirectory);
        Directory.CreateDirectory(root);
        var stopwatch = Stopwatch.StartNew();
        Exception? lastContention = null;

        while (true)
        {
            cancellationToken.ThrowIfCancellationRequested();
            try
            {
                return new AudioReviewDraftStorageLease(OpenExclusive(root));
            }
            catch (Exception exception) when (exception is IOException or UnauthorizedAccessException)
            {
                lastContention = exception;
            }

            if (stopwatch.Elapsed >= timeout)
                throw new IOException("Audio review storage is busy in another app instance. Retry after the other review save/cleanup finishes.", lastContention);

            var remaining = timeout - stopwatch.Elapsed;
            var delay = remaining < RetryDelay ? remaining : RetryDelay;
            if (delay > TimeSpan.Zero)
                await Task.Delay(delay, cancellationToken).ConfigureAwait(false);
        }
    }

    internal static bool TryAcquire(
        string rootDirectory,
        TimeSpan timeout,
        out AudioReviewDraftStorageLease? lease)
    {
        ArgumentException.ThrowIfNullOrWhiteSpace(rootDirectory);
        if (timeout < TimeSpan.Zero)
            throw new ArgumentOutOfRangeException(nameof(timeout));

        var root = Path.GetFullPath(rootDirectory);
        Directory.CreateDirectory(root);
        var stopwatch = Stopwatch.StartNew();
        while (true)
        {
            try
            {
                lease = new AudioReviewDraftStorageLease(OpenExclusive(root));
                return true;
            }
            catch (Exception exception) when (exception is IOException or UnauthorizedAccessException)
            {
                if (stopwatch.Elapsed >= timeout)
                {
                    lease = null;
                    return false;
                }
            }

            var remaining = timeout - stopwatch.Elapsed;
            var sleep = remaining < RetryDelay ? remaining : RetryDelay;
            if (sleep > TimeSpan.Zero)
                Thread.Sleep(sleep);
        }
    }

    internal static string GetRootDirectory(AudioReviewDraftStore store)
    {
        ArgumentNullException.ThrowIfNull(store);
        var sentinelDraftPath = store.GetDraftPath(new string('0', 64));
        return Path.GetDirectoryName(sentinelDraftPath)
            ?? throw new InvalidOperationException("Audio review draft storage root could not be resolved.");
    }

    private static FileStream OpenExclusive(string root)
        => new(
            Path.Combine(root, FileName),
            FileMode.OpenOrCreate,
            FileAccess.ReadWrite,
            FileShare.None,
            bufferSize: 1,
            options: FileOptions.None);

    public void Dispose()
    {
        if (disposed)
            return;
        disposed = true;
        stream.Dispose();
    }
}
