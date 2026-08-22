package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzdtg implements zzhgr {
    private final zzhha zza;

    private zzdtg(zzdsy zzdsyVar, zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
    }

    public static zzdtg zza(zzdsy zzdsyVar, zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzdtg(zzdsyVar, zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set setZzh = zzdsy.zzh((zzdti) this.zza.zzb(), zzffu.zzc());
        zzhgz.zzb(setZzh);
        return setZzh;
    }
}
