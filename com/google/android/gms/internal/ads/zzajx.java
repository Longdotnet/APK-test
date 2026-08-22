package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzajx implements zzakc {
    private final zzaeg zza;
    private final zzaef zzb;
    private long zzc = -1;
    private long zzd = -1;

    public zzajx(zzaeg zzaegVar, zzaef zzaefVar) {
        this.zza = zzaegVar;
        this.zzb = zzaefVar;
    }

    public final void zza(long j) {
        this.zzc = j;
    }

    @Override // com.google.android.gms.internal.ads.zzakc
    public final long zzd(zzadw zzadwVar) {
        long j = this.zzd;
        if (j < 0) {
            return -1L;
        }
        this.zzd = -1L;
        return -(j + 2);
    }

    @Override // com.google.android.gms.internal.ads.zzakc
    public final zzaeu zze() {
        zzdd.zzf(this.zzc != -1);
        return new zzaee(this.zza, this.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzakc
    public final void zzg(long j) {
        long[] jArr = this.zzb.zza;
        this.zzd = jArr[zzex.zzd(jArr, j, true, true)];
    }
}
