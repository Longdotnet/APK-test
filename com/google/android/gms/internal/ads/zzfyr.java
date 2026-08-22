package com.google.android.gms.internal.ads;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline0;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.firebase.inject.PVS.jIKWv;
import kotlinx.coroutines.internal.Jbo.ygoi;

/* JADX INFO: loaded from: classes2.dex */
final class zzfyr {
    private final Object zza;
    private final Object zzb;
    private final Object zzc;

    public zzfyr(Object obj, Object obj2, Object obj3) {
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
        String strValueOf3 = String.valueOf(obj3);
        String strValueOf4 = String.valueOf(obj);
        String str = jIKWv.DdjxRn;
        return new IllegalArgumentException(Fragment$$ExternalSyntheticOutline0.m(CoroutineAdapterKt$$ExternalSyntheticLambda0.m22m("Multiple entries with same key: ", strValueOf, str, strValueOf2, ygoi.DSbWyiOuiWh), strValueOf3, str, strValueOf4));
    }
}
