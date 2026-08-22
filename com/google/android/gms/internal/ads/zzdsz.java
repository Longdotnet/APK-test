package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzdsz implements zzhgr {
    private final zzhha zza;

    private zzdsz(zzdsy zzdsyVar, zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
    }

    public static zzdsz zza(zzdsy zzdsyVar, zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzdsz(zzdsyVar, zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set setZza = zzdsy.zza((zzdti) this.zza.zzb(), zzffu.zzc());
        zzhgz.zzb(setZza);
        return setZza;
    }
}
