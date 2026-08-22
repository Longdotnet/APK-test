package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzaib extends zzadk implements zzaig {
    private final long zza;
    private final int zzb;
    private final int zzc;
    private final long zzd;

    public zzaib(long j, long j2, int i, int i2, boolean z) {
        super(j, j2, i, i2, false);
        this.zza = j2;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = j == -1 ? -1L : j;
    }

    @Override // com.google.android.gms.internal.ads.zzaig
    public final int zzc() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzaig
    public final long zzd() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzaig
    public final long zze(long j) {
        return zzb(j);
    }

    public final zzaib zzf(long j) {
        return new zzaib(j, this.zza, this.zzb, this.zzc, false);
    }
}
