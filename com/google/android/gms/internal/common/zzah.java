package com.google.android.gms.internal.common;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import org.jspecify.nullness.NullMarked;

/* JADX INFO: loaded from: classes.dex */
@NullMarked
public final class zzah {
    public static Object[] zza(Object[] objArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (objArr[i2] == null) {
                throw new NullPointerException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i2, "at index "));
            }
        }
        return objArr;
    }
}
