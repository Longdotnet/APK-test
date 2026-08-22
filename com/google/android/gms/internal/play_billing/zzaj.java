package com.google.android.gms.internal.play_billing;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline0;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.auth.IJ.gZrKCJ;

/* JADX INFO: loaded from: classes2.dex */
final class zzaj {
    private final Object zza;
    private final Object zzb;
    private final Object zzc;

    public zzaj(Object obj, Object obj2, Object obj3) {
        this.zza = obj;
        this.zzb = obj2;
        this.zzc = obj3;
    }

    public final IllegalArgumentException zza() {
        Object obj = this.zzc;
        Object obj2 = this.zzb;
        Object obj3 = this.zza;
        String strValueOf = String.valueOf(obj3);
        String strValueOf2 = String.valueOf(obj2);
        return new IllegalArgumentException(Fragment$$ExternalSyntheticOutline0.m(CoroutineAdapterKt$$ExternalSyntheticLambda0.m22m(gZrKCJ.QsTiM, strValueOf, "=", strValueOf2, " and "), String.valueOf(obj3), "=", String.valueOf(obj)));
    }
}
