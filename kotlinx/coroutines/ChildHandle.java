package kotlinx.coroutines;

/* JADX INFO: loaded from: classes3.dex */
public interface ChildHandle extends DisposableHandle {
    boolean childCancelled(Throwable th);
}
