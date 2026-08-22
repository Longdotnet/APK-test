package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzav {
    private final zzau[] zza;

    public zzav(long j, zzau... zzauVarArr) {
        this.zza = zzauVarArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && zzav.class == obj.getClass() && Arrays.equals(this.zza, ((zzav) obj).zza);
    }

    public final int hashCode() {
        return (Arrays.hashCode(this.zza) * 31) + ((int) (-9223372034707292159L));
    }

    public final String toString() {
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("entries=", Arrays.toString(this.zza), "");
    }

    public final int zza() {
        return this.zza.length;
    }

    public final zzau zzb(int i) {
        return this.zza[i];
    }

    public final zzav zzc(zzau... zzauVarArr) {
        int length = zzauVarArr.length;
        if (length == 0) {
            return this;
        }
        zzau[] zzauVarArr2 = this.zza;
        String str = zzex.zza;
        int length2 = zzauVarArr2.length;
        Object[] objArrCopyOf = Arrays.copyOf(zzauVarArr2, length2 + length);
        System.arraycopy(zzauVarArr, 0, objArrCopyOf, length2, length);
        return new zzav(-9223372036854775807L, (zzau[]) objArrCopyOf);
    }

    public final zzav zzd(zzav zzavVar) {
        return zzavVar == null ? this : zzc(zzavVar.zza);
    }

    public zzav(List list) {
        this.zza = (zzau[]) list.toArray(new zzau[0]);
    }
}
