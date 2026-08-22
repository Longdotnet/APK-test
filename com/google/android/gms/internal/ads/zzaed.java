package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzaed {
    public static zzav zza(zzadw zzadwVar, boolean z) {
        zzav zzavVarZza = new zzael().zza(zzadwVar, z ? null : zzahe.zza);
        if (zzavVarZza == null || zzavVarZza.zza() == 0) {
            return null;
        }
        return zzavVarZza;
    }

    public static zzaef zzb(zzen zzenVar) {
        zzenVar.zzM(1);
        int iZzo = zzenVar.zzo();
        long jZzc = zzenVar.zzc();
        long j = iZzo;
        int i = iZzo / 18;
        long[] jArrCopyOf = new long[i];
        long[] jArrCopyOf2 = new long[i];
        for (int i2 = 0; i2 < i; i2++) {
            long jZzt = zzenVar.zzt();
            if (jZzt == -1) {
                jArrCopyOf = Arrays.copyOf(jArrCopyOf, i2);
                jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i2);
                break;
            }
            jArrCopyOf[i2] = jZzt;
            jArrCopyOf2[i2] = zzenVar.zzt();
            zzenVar.zzM(2);
        }
        zzenVar.zzM((int) ((jZzc + j) - ((long) zzenVar.zzc())));
        return new zzaef(jArrCopyOf, jArrCopyOf2);
    }
}
