package kotlinx.coroutines;

/* JADX INFO: loaded from: classes3.dex */
public final class NonDisposableHandle implements DisposableHandle, ChildHandle {
    public static final NonDisposableHandle INSTANCE = new NonDisposableHandle();

    @Override // kotlinx.coroutines.ChildHandle
    public final boolean childCancelled(Throwable th) {
        return false;
    }

    @Override // kotlinx.coroutines.DisposableHandle
    public final void dispose() {
    }

    public final String toString() {
        return "NonDisposableHandle";
    }
}
