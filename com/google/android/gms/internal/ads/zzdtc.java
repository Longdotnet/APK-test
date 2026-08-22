package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzdtc implements zzhgr {
    private final zzdsy zza;
    private final zzhha zzb;

    private zzdtc(zzdsy zzdsyVar, zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzdsyVar;
        this.zzb = zzhhaVar;
    }

    public static zzdtc zza(zzdsy zzdsyVar, zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzdtc(zzdsyVar, zzhhaVar, zzhhaVar2);
    }

    public static Set zzc(zzdsy zzdsyVar, zzdti zzdtiVar, Executor executor) {
        Set setZzd = zzdsy.zzd(zzdtiVar, executor);
        zzhgz.zzb(setZzd);
        return setZzd;
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return zzc(this.zza, (zzdti) this.zzb.zzb(), zzffu.zzc());
    }
}
