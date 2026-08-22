package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzdrm implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzdrm(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
    }

    public static zzdrm zzc(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzdrm(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzdrl zzb() {
        return new zzdrl((zzbcc) this.zza.zzb(), ((zzhgv) this.zzb).zzb());
    }
}
