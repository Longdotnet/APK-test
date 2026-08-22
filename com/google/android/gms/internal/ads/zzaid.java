package com.google.android.gms.internal.ads;

import android.util.Pair;

/* JADX INFO: loaded from: classes.dex */
final class zzaid implements zzaig {
    private final long[] zza;
    private final long[] zzb;
    private final long zzc;

    private zzaid(long[] jArr, long[] jArr2, long j) {
        this.zza = jArr;
        this.zzb = jArr2;
        this.zzc = j == -9223372036854775807L ? zzex.zzs(jArr2[jArr2.length - 1]) : j;
    }

    public static zzaid zzb(long j, zzahi zzahiVar, long j2) {
        int[] iArr = zzahiVar.zzd;
        int length = iArr.length;
        int i = length + 1;
        long[] jArr = new long[i];
        long[] jArr2 = new long[i];
        jArr[0] = j;
        long j3 = 0;
        jArr2[0] = 0;
        for (int i2 = 1; i2 <= length; i2++) {
            int i3 = i2 - 1;
            j += (long) (zzahiVar.zzb + iArr[i3]);
            j3 += (long) (zzahiVar.zzc + zzahiVar.zze[i3]);
            jArr[i2] = j;
            jArr2[i2] = j3;
        }
        return new zzaid(jArr, jArr2, j2);
    }

    private static Pair zzf(long j, long[] jArr, long[] jArr2) {
        int iZzd = zzex.zzd(jArr, j, true, true);
        long j2 = jArr[iZzd];
        long j3 = jArr2[iZzd];
        int i = iZzd + 1;
        if (i == jArr.length) {
            return Pair.create(Long.valueOf(j2), Long.valueOf(j3));
        }
        long j4 = jArr[i];
        return Pair.create(Long.valueOf(j), Long.valueOf(((long) ((j4 == j2 ? 0.0d : (j - j2) / (j4 - j2)) * (jArr2[i] - j3))) + j3));
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final long zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzaig
    public final int zzc() {
        return -2147483647;
    }

    @Override // com.google.android.gms.internal.ads.zzaig
    public final long zzd() {
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzaig
    public final long zze(long j) {
        return zzex.zzs(((Long) zzf(j, this.zza, this.zzb).second).longValue());
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final zzaes zzg(long j) {
        String str = zzex.zza;
        Pair pairZzf = zzf(zzex.zzv(Math.max(0L, Math.min(j, this.zzc))), this.zzb, this.zza);
        zzaev zzaevVar = new zzaev(zzex.zzs(((Long) pairZzf.first).longValue()), ((Long) pairZzf.second).longValue());
        return new zzaes(zzaevVar, zzaevVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final boolean zzh() {
        return true;
    }
}
