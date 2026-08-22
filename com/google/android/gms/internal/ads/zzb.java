package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzb {
    public static final zzb zza = new zzb(null, new zza[0], 0, -9223372036854775807L, 0);
    private static final zza zze = new zza(0).zzb(0);
    private final zza[] zzf;
    public final long zzc = 0;
    public final int zzb = 0;
    public final int zzd = 0;

    static {
        String str = zzex.zza;
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
    }

    private zzb(Object obj, zza[] zzaVarArr, long j, long j2, int i) {
        this.zzf = zzaVarArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && zzb.class == obj.getClass() && Arrays.equals(this.zzf, ((zzb) obj).zzf);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zzf) + (((int) (-9223372036854775807L)) * 961);
    }

    public final String toString() {
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("AdPlaybackState(adsId=null, adResumePositionUs=0, adGroups=[", "])");
    }

    public final zza zza(int i) {
        return i < 0 ? zze : this.zzf[i];
    }

    public final boolean zzb(int i) {
        zza(-1);
        return false;
    }
}
