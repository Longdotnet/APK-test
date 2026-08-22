package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class zzctj implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzctj(zzcti zzctiVar, zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
    }

    public static zzctj zza(zzcti zzctiVar, zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzctj(zzctiVar, zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new com.google.android.gms.ads.internal.zzb((Context) this.zza.zzb(), (zzbya) this.zzb.zzb());
    }
}
