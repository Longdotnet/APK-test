package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzdta implements zzhgr {
    private final zzhha zza;

    private zzdta(zzdsy zzdsyVar, zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
    }

    public static zzdta zza(zzdsy zzdsyVar, zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzdta(zzdsyVar, zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set setZzb = zzdsy.zzb((zzdti) this.zza.zzb(), zzffu.zzc());
        zzhgz.zzb(setZzb);
        return setZzb;
    }
}
