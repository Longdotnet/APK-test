package kotlinx.coroutines;

import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
public abstract class CoroutineDispatcher extends AbstractCoroutineContextElement implements ContinuationInterceptor {
    public static final Key Key = new Key(ContinuationInterceptor.Key.$$INSTANCE, Key.AnonymousClass1.INSTANCE);

    public final class Key implements CoroutineContext.Key {
        public final Lambda safeCast;
        public final CoroutineContext.Key topmostKey;

        /* JADX INFO: renamed from: kotlinx.coroutines.CoroutineDispatcher$Key$1, reason: invalid class name */
        public final class AnonymousClass1 extends Lambda implements Function1 {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1(1);

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                CoroutineContext.Element element = (CoroutineContext.Element) obj;
                if (element instanceof CoroutineDispatcher) {
                    return (CoroutineDispatcher) element;
                }
                return null;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Key(CoroutineContext.Key baseKey, Function1 function1) {
            Intrinsics.checkNotNullParameter(baseKey, "baseKey");
            this.safeCast = (Lambda) function1;
            this.topmostKey = baseKey instanceof Key ? ((Key) baseKey).topmostKey : baseKey;
        }
    }

    public CoroutineDispatcher() {
        super(ContinuationInterceptor.Key.$$INSTANCE);
    }

    public abstract void dispatch(CoroutineContext coroutineContext, Runnable runnable);

    /* JADX WARN: Type inference failed for: r4v2, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
    @Override // kotlin.coroutines.AbstractCoroutineContextElement, kotlin.coroutines.CoroutineContext
    public final CoroutineContext.Element get(CoroutineContext.Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (!(key instanceof Key)) {
            if (ContinuationInterceptor.Key.$$INSTANCE == key) {
                return this;
            }
            return null;
        }
        Key key2 = (Key) key;
        CoroutineContext.Key key3 = this.key;
        if (key3 != key2 && key2.topmostKey != key3) {
            return null;
        }
        CoroutineContext.Element element = (CoroutineContext.Element) key2.safeCast.invoke(this);
        if (element instanceof CoroutineContext.Element) {
            return element;
        }
        return null;
    }

    public boolean isDispatchNeeded() {
        return !(this instanceof Unconfined);
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
    @Override // kotlin.coroutines.AbstractCoroutineContextElement, kotlin.coroutines.CoroutineContext
    public final CoroutineContext minusKey(CoroutineContext.Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        boolean z = key instanceof Key;
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        if (z) {
            Key key2 = (Key) key;
            CoroutineContext.Key key3 = this.key;
            if ((key3 == key2 || key2.topmostKey == key3) && ((CoroutineContext.Element) key2.safeCast.invoke(this)) != null) {
                return emptyCoroutineContext;
            }
        } else if (ContinuationInterceptor.Key.$$INSTANCE == key) {
            return emptyCoroutineContext;
        }
        return this;
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + BuildersKt.getHexAddress(this);
    }
}
