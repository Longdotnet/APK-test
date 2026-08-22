package androidx.activity;

import android.content.res.Resources;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes.dex */
public final class SystemBarStyle$Companion$auto$1 extends Lambda implements Function1 {
    public static final SystemBarStyle$Companion$auto$1 INSTANCE = new SystemBarStyle$Companion$auto$1(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Resources resources = (Resources) obj;
        Intrinsics.checkNotNullParameter(resources, "resources");
        return Boolean.valueOf((resources.getConfiguration().uiMode & 48) == 32);
    }
}
