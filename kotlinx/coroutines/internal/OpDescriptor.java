package kotlinx.coroutines.internal;

import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class OpDescriptor {
    public abstract Object perform(Object obj);

    public final String toString() {
        return getClass().getSimpleName() + '@' + BuildersKt.getHexAddress(this);
    }
}
