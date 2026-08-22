package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzdtb implements zzhgr {
    private final zzhha zza;

    private zzdtb(zzdsy zzdsyVar, zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
    }

    public static zzdtb zza(zzdsy zzdsyVar, zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzdtb(zzdsyVar, zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set setZzc = zzdsy.zzc((zzdti) this.zza.zzb(), zzffu.zzc());
        zzhgz.zzb(setZzc);
        return setZzc;
    }
}
