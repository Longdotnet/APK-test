package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzfkm implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzfkm(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
    }

    public static zzfkm zzc(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzfkm(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzfkl zzb() {
        return new zzfkl((zzdsj) this.zza.zzb(), ((zzchl) this.zzb).zza());
    }
}
