package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzagm extends zzaeh {
    private final long zza;

    public zzagm(zzadw zzadwVar, long j) {
        super(zzadwVar);
        zzdd.zzd(zzadwVar.zzf() >= j);
        this.zza = j;
    }

    @Override // com.google.android.gms.internal.ads.zzaeh, com.google.android.gms.internal.ads.zzadw
    public final long zzd() {
        return super.zzd() - this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzaeh, com.google.android.gms.internal.ads.zzadw
    public final long zze() {
        return super.zze() - this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzaeh, com.google.android.gms.internal.ads.zzadw
    public final long zzf() {
        return super.zzf() - this.zza;
    }
}
