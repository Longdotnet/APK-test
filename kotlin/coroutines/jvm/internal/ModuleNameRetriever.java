package kotlin.coroutines.jvm.internal;

import okhttp3.internal.platform.android.CloseGuard;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ModuleNameRetriever {
    public static CloseGuard cache;
    public static final CloseGuard notOnJava9 = new CloseGuard(null, null, null);
}
