package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzdux implements zzhgr {
    private final zzhha zza;

    private zzdux(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
    }

    public static zzddv zza(zzduw zzduwVar, Executor executor) {
        return new zzddv(zzduwVar, executor);
    }

    public static zzdux zzc(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzdux(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return zza((zzduw) this.zza.zzb(), zzffu.zzc());
    }
}
