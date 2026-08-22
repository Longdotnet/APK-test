package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzzy extends IOException {
    public zzzy(Throwable th) {
        super(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Unexpected ", th.getClass().getSimpleName(), th.getMessage() != null ? ": ".concat(String.valueOf(th.getMessage())) : ""), th);
    }
}
