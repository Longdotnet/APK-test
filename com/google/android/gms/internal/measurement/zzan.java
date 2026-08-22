package com.google.android.gms.internal.measurement;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzan implements zzap {
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return obj instanceof zzan;
    }

    public final int hashCode() {
        return 1;
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final zzap zzbR(String str, zzg zzgVar, List list) {
        throw new IllegalStateException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("null has no function ", str));
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final zzap zzd() {
        return zzap.zzg;
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Boolean zzg() {
        return Boolean.FALSE;
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Double zzh() {
        return Double.valueOf(0.0d);
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final String zzi() {
        return "null";
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Iterator zzl() {
        return null;
    }
}
