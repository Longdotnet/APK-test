package kotlin.coroutines;

/* JADX INFO: loaded from: classes3.dex */
public interface Continuation {
    CoroutineContext getContext();

    void resumeWith(Object obj);
}
