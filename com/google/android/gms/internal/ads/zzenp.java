package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzenp implements zzhgr {
    private final zzhha zza;

    private zzenp(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar2;
    }

    public static zzenp zzc(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzenp(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzenn zzb() {
        return new zzenn(zzffu.zzc(), (zzbzs) this.zza.zzb());
    }
}
