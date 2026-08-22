package androidx.lifecycle.viewmodel;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class MutableCreationExtras extends CreationExtras {
    public /* synthetic */ MutableCreationExtras(int i) {
        this(CreationExtras.Empty.INSTANCE);
    }

    public MutableCreationExtras(CreationExtras initialExtras) {
        Intrinsics.checkNotNullParameter(initialExtras, "initialExtras");
        this.map.putAll(initialExtras.map);
    }
}
