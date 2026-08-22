package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class zzcvu implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;
    private final zzhha zzc;

    private zzcvu(zzcvt zzcvtVar, zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
        this.zzc = zzhhaVar3;
    }

    public static zzcvu zza(zzcvt zzcvtVar, zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4) {
        return new zzcvu(zzcvtVar, zzhhaVar, zzhhaVar2, zzhhaVar3, zzhhaVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return zzcvt.zza((Context) this.zza.zzb(), ((zzchz) this.zzb).zza(), ((zzcrr) this.zzc).zzc(), zzcjx.zzc());
    }
}
