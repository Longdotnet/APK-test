package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzaox {
    public final int zza;
    public final long zzb;

    private zzaox(int i, long j) {
        this.zza = i;
        this.zzb = j;
    }

    public static zzaox zza(zzadw zzadwVar, zzen zzenVar) {
        zzadwVar.zzh(zzenVar.zzN(), 0, 8);
        zzenVar.zzL(0);
        return new zzaox(zzenVar.zzg(), zzenVar.zzs());
    }
}
