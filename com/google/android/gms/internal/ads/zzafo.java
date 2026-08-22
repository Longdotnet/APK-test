package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzafo implements zzafj {
    public final int zza;
    public final int zzb;
    public final int zzc;

    private zzafo(int i, int i2, int i3, int i4) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
    }

    public static zzafo zzb(zzen zzenVar) {
        int iZzi = zzenVar.zzi();
        zzenVar.zzM(8);
        int iZzi2 = zzenVar.zzi();
        int iZzi3 = zzenVar.zzi();
        zzenVar.zzM(4);
        int iZzi4 = zzenVar.zzi();
        zzenVar.zzM(12);
        return new zzafo(iZzi, iZzi2, iZzi3, iZzi4);
    }

    @Override // com.google.android.gms.internal.ads.zzafj
    public final int zza() {
        return 1751742049;
    }
}
