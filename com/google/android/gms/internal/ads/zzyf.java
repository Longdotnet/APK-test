package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzyf extends zzyp implements Comparable {
    private final int zze;
    private final int zzf;

    public zzyf(int i, zzbm zzbmVar, int i2, zzyi zzyiVar, int i3) {
        super(i, zzbmVar, i2);
        this.zze = zzmb.zza(i3, zzyiVar.zzR) ? 1 : 0;
        this.zzf = this.zzd.zza();
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzyf zzyfVar) {
        return Integer.compare(this.zzf, zzyfVar.zzf);
    }

    @Override // com.google.android.gms.internal.ads.zzyp
    public final int zzb() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzyp
    public final /* bridge */ /* synthetic */ boolean zzc(zzyp zzypVar) {
        return false;
    }
}
