package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzafz extends zzadg {
    public zzafz(final zzaeg zzaegVar, int i, long j, long j2) {
        long j3;
        Objects.requireNonNull(zzaegVar);
        zzadd zzaddVar = new zzadd() { // from class: com.google.android.gms.internal.ads.zzafw
            @Override // com.google.android.gms.internal.ads.zzadd
            public final long zza(long j4) {
                return zzaegVar.zzb(j4);
            }
        };
        zzafx zzafxVar = new zzafx(zzaegVar, i, null);
        long jZza = zzaegVar.zza();
        long j4 = zzaegVar.zzj;
        int i2 = zzaegVar.zzd;
        if (i2 > 0) {
            j3 = ((((long) i2) + ((long) zzaegVar.zzc)) / 2) + 1;
        } else {
            int i3 = zzaegVar.zza;
            long j5 = 4096;
            if (i3 == zzaegVar.zzb && i3 > 0) {
                j5 = i3;
            }
            j3 = (((j5 * ((long) zzaegVar.zzg)) * ((long) zzaegVar.zzh)) / 8) + 64;
        }
        super(zzaddVar, zzafxVar, jZza, 0L, j4, j, j2, j3, Math.max(6, zzaegVar.zzc));
    }
}
