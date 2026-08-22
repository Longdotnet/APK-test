package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzdtf implements zzhgr {
    private final zzhha zza;

    private zzdtf(zzdsy zzdsyVar, zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
    }

    public static zzdtf zza(zzdsy zzdsyVar, zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzdtf(zzdsyVar, zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set setZzg = zzdsy.zzg((zzdti) this.zza.zzb(), zzffu.zzc());
        zzhgz.zzb(setZzg);
        return setZzg;
    }
}
