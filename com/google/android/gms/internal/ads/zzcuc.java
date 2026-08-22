package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzcuc implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzcuc(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
    }

    public static zzcuc zza(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzcuc(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzddv((zzdam) this.zza.zzb(), (Executor) this.zzb.zzb());
    }
}
