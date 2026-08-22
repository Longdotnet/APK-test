package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzaiu implements zzaiq {
    private final zzen zza;
    private final int zzb;
    private final int zzc;
    private int zzd;
    private int zze;

    public zzaiu(zzfd zzfdVar) {
        zzen zzenVar = zzfdVar.zza;
        this.zza = zzenVar;
        zzenVar.zzL(12);
        this.zzc = zzenVar.zzp() & 255;
        this.zzb = zzenVar.zzp();
    }

    @Override // com.google.android.gms.internal.ads.zzaiq
    public final int zza() {
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzaiq
    public final int zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzaiq
    public final int zzc() {
        int i = this.zzc;
        if (i == 8) {
            return this.zza.zzm();
        }
        if (i == 16) {
            return this.zza.zzq();
        }
        int i2 = this.zzd;
        this.zzd = i2 + 1;
        if (i2 % 2 != 0) {
            return this.zze & 15;
        }
        int iZzm = this.zza.zzm();
        this.zze = iZzm;
        return (iZzm & 240) >> 4;
    }
}
