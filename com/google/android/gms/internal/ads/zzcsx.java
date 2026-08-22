package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzcsx implements zzhgr {
    private final zzhha zza;

    private zzcsx(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
    }

    public static zzcsx zza(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzcsx(zzhhaVar, zzhhaVar2);
    }

    public static zzddv zzc(zzcnc zzcncVar, Executor executor) {
        return new zzddv(zzcncVar, executor);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return zzc((zzcnc) this.zza.zzb(), zzffu.zzc());
    }
}
