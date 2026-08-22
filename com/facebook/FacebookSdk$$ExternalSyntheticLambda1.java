package com.facebook;

import android.content.Context;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class FacebookSdk$$ExternalSyntheticLambda1 implements Callable {
    @Override // java.util.concurrent.Callable
    public final Object call() {
        Context context = FacebookSdk.applicationContext;
        if (context != null) {
            return context.getCacheDir();
        }
        Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
        throw null;
    }
}
