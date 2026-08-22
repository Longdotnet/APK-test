package kotlin;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
public final class SynchronizedLazyImpl implements Lazy, Serializable {
    public Lambda initializer;
    public volatile Object _value = UNINITIALIZED_VALUE.INSTANCE;
    public final Object lock = this;

    /* JADX WARN: Multi-variable type inference failed */
    public SynchronizedLazyImpl(Function0 function0) {
        this.initializer = (Lambda) function0;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object, kotlin.jvm.functions.Function0, kotlin.jvm.internal.Lambda] */
    @Override // kotlin.Lazy
    public final Object getValue() {
        Object objInvoke;
        Object obj = this._value;
        UNINITIALIZED_VALUE uninitialized_value = UNINITIALIZED_VALUE.INSTANCE;
        if (obj != uninitialized_value) {
            return obj;
        }
        synchronized (this.lock) {
            objInvoke = this._value;
            if (objInvoke == uninitialized_value) {
                ?? r1 = this.initializer;
                Intrinsics.checkNotNull(r1);
                objInvoke = r1.invoke();
                this._value = objInvoke;
                this.initializer = null;
            }
        }
        return objInvoke;
    }

    public final String toString() {
        return this._value != UNINITIALIZED_VALUE.INSTANCE ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
