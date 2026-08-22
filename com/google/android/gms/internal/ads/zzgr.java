package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzgr implements zzgi {
    private zzhj zzb;
    private String zzc;
    private boolean zzf;
    private final zzhd zza = new zzhd();
    private int zzd = 8000;
    private int zze = 8000;

    public final zzgr zzb(boolean z) {
        this.zzf = true;
        return this;
    }

    public final zzgr zzc(int i) {
        this.zzd = i;
        return this;
    }

    public final zzgr zzd(int i) {
        this.zze = i;
        return this;
    }

    public final zzgr zze(zzhj zzhjVar) {
        this.zzb = zzhjVar;
        return this;
    }

    public final zzgr zzf(String str) {
        this.zzc = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzgi
    /* JADX INFO: renamed from: zzg, reason: merged with bridge method [inline-methods] */
    public final zzgw zza() {
        zzgw zzgwVar = new zzgw(this.zzc, this.zzd, this.zze, this.zzf, false, this.zza, null, false, null);
        zzhj zzhjVar = this.zzb;
        if (zzhjVar != null) {
            zzgwVar.zzf(zzhjVar);
        }
        return zzgwVar;
    }
}
