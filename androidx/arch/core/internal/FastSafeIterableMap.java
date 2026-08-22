package androidx.arch.core.internal;

import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class FastSafeIterableMap extends SafeIterableMap {
    public final HashMap mHashMap = new HashMap();

    @Override // androidx.arch.core.internal.SafeIterableMap
    public final SafeIterableMap.Entry get(Object obj) {
        return (SafeIterableMap.Entry) this.mHashMap.get(obj);
    }

    @Override // androidx.arch.core.internal.SafeIterableMap
    public final Object remove(Object obj) {
        Object objRemove = super.remove(obj);
        this.mHashMap.remove(obj);
        return objRemove;
    }
}
