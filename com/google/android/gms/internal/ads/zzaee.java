package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzaee implements zzaeu {
    private final zzaeg zza;
    private final long zzb;

    public zzaee(zzaeg zzaegVar, long j) {
        this.zza = zzaegVar;
        this.zzb = j;
    }

    private final zzaev zzb(long j, long j2) {
        return new zzaev((j * 1000000) / ((long) this.zza.zze), this.zzb + j2);
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final long zza() {
        return this.zza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final zzaes zzg(long j) {
        zzaeg zzaegVar = this.zza;
        zzaef zzaefVar = zzaegVar.zzk;
        zzdd.zzb(zzaefVar);
        long[] jArr = zzaefVar.zza;
        long[] jArr2 = zzaefVar.zzb;
        int iZzd = zzex.zzd(jArr, zzaegVar.zzb(j), true, false);
        zzaev zzaevVarZzb = zzb(iZzd == -1 ? 0L : jArr[iZzd], iZzd != -1 ? jArr2[iZzd] : 0L);
        if (zzaevVarZzb.zzb == j || iZzd == jArr.length - 1) {
            return new zzaes(zzaevVarZzb, zzaevVarZzb);
        }
        int i = iZzd + 1;
        return new zzaes(zzaevVarZzb, zzb(jArr[i], jArr2[i]));
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final boolean zzh() {
        return true;
    }
}
