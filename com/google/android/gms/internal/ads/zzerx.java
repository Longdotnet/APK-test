package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzerx implements zzhgr {
    private final zzhha zza;

    private zzerx(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar2;
    }

    public static zzerx zzc(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzerx(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzerv zzb() {
        return new zzerv(zzffu.zzc(), (zzdvi) this.zza.zzb());
    }
}
