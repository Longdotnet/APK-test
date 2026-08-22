package androidx.lifecycle;

import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes.dex */
public final class SavedStateHandleSupport$savedStateHandlesVM$1$1 extends Lambda implements Function1 {
    public static final SavedStateHandleSupport$savedStateHandlesVM$1$1 INSTANCE = new SavedStateHandleSupport$savedStateHandlesVM$1$1(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        CreationExtras initializer = (CreationExtras) obj;
        Intrinsics.checkNotNullParameter(initializer, "$this$initializer");
        return new SavedStateHandlesVM();
    }
}
