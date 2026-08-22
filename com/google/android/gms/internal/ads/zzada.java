package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzada implements zzaeu {
    private final zzadd zza;
    private final long zzb;
    private final long zzc;
    private final long zzd;
    private final long zze;
    private final long zzf;

    public zzada(zzadd zzaddVar, long j, long j2, long j3, long j4, long j5, long j6) {
        this.zza = zzaddVar;
        this.zzb = j;
        this.zzc = j3;
        this.zzd = j4;
        this.zze = j5;
        this.zzf = j6;
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final long zza() {
        return this.zzb;
    }

    public final long zzf(long j) {
        return this.zza.zza(j);
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final zzaes zzg(long j) {
        zzaev zzaevVar = new zzaev(j, zzadc.zzf(this.zza.zza(j), 0L, this.zzc, this.zzd, this.zze, this.zzf));
        return new zzaes(zzaevVar, zzaevVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final boolean zzh() {
        return true;
    }
}
