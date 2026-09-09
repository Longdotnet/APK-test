namespace RobloxPiano.Core;

/// <summary>
/// Owns logical held-key state above the platform input backend.
/// Overlapping canonical events for the same key acquire independent logical holds,
/// while the physical key is pressed only for the first hold and released only after
/// the final hold ends. Release-all atomically forgets every logical hold after the
/// underlying backend confirms the emergency release.
/// </summary>
public sealed class ReferenceCountedInputSink : IInputSink, IDisposable
{
    private readonly IInputSink _inner;
    private readonly SemaphoreSlim _gate = new(1, 1);
    private readonly Dictionary<char, int> _holds = new();
    private bool _disposed;

    public ReferenceCountedInputSink(IInputSink inner)
    {
        _inner = inner ?? throw new ArgumentNullException(nameof(inner));
    }

    public int LogicalHoldCount
    {
        get
        {
            _gate.Wait();
            try
            {
                ThrowIfDisposed();
                return _holds.Values.Sum();
            }
            finally
            {
                _gate.Release();
            }
        }
    }

    public async ValueTask KeyDownAsync(IReadOnlyList<char> keys, CancellationToken cancellationToken)
    {
        ArgumentNullException.ThrowIfNull(keys);
        cancellationToken.ThrowIfCancellationRequested();
        if (keys.Count == 0)
        {
            return;
        }

        await _gate.WaitAsync(cancellationToken).ConfigureAwait(false);
        try
        {
            ThrowIfDisposed();

            var transitions = keys
                .Distinct()
                .Where(key => !_holds.ContainsKey(key))
                .ToArray();

            if (transitions.Length > 0)
            {
                await _inner.KeyDownAsync(transitions, cancellationToken).ConfigureAwait(false);
            }

            foreach (var key in keys)
            {
                _holds.TryGetValue(key, out var count);
                _holds[key] = checked(count + 1);
            }
        }
        finally
        {
            _gate.Release();
        }
    }

    public async ValueTask KeyUpAsync(IReadOnlyList<char> keys, CancellationToken cancellationToken)
    {
        ArgumentNullException.ThrowIfNull(keys);
        cancellationToken.ThrowIfCancellationRequested();
        if (keys.Count == 0)
        {
            return;
        }

        await _gate.WaitAsync(cancellationToken).ConfigureAwait(false);
        try
        {
            ThrowIfDisposed();

            var decrements = new Dictionary<char, int>();
            foreach (var key in keys)
            {
                if (_holds.TryGetValue(key, out var current) && current > 0)
                {
                    decrements.TryGetValue(key, out var pending);
                    if (pending < current)
                    {
                        decrements[key] = pending + 1;
                    }
                }
            }

            if (decrements.Count == 0)
            {
                // A focus-loss/seek/stop release-all deliberately clears ownership.
                // Scheduled stale KeyUp edges from that old slice are therefore harmless.
                return;
            }

            var transitions = decrements
                .Where(pair => _holds[pair.Key] == pair.Value)
                .Select(pair => pair.Key)
                .ToArray();

            if (transitions.Length > 0)
            {
                await _inner.KeyUpAsync(transitions, cancellationToken).ConfigureAwait(false);
            }

            foreach (var pair in decrements)
            {
                var remaining = _holds[pair.Key] - pair.Value;
                if (remaining == 0)
                {
                    _holds.Remove(pair.Key);
                }
                else
                {
                    _holds[pair.Key] = remaining;
                }
            }
        }
        finally
        {
            _gate.Release();
        }
    }

    public async ValueTask ReleaseAllAsync(CancellationToken cancellationToken)
    {
        await _gate.WaitAsync(CancellationToken.None).ConfigureAwait(false);
        try
        {
            ThrowIfDisposed();
            await _inner.ReleaseAllAsync(cancellationToken).ConfigureAwait(false);
            _holds.Clear();
        }
        finally
        {
            _gate.Release();
        }
    }

    public void Dispose()
    {
        _gate.Wait();
        try
        {
            if (_disposed)
            {
                return;
            }

            _disposed = true;
            _holds.Clear();
        }
        finally
        {
            _gate.Release();
        }

        _gate.Dispose();
    }

    private void ThrowIfDisposed()
    {
        ObjectDisposedException.ThrowIf(_disposed, this);
    }
}
