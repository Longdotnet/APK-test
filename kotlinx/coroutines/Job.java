package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes3.dex */
public interface Job extends CoroutineContext.Element {

    public final class Key implements CoroutineContext.Key {
        public static final /* synthetic */ Key $$INSTANCE$1 = new Key();
        public static final /* synthetic */ Key $$INSTANCE = new Key();
    }

    boolean isActive();
}
