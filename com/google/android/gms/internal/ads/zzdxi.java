package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class zzdxi implements zzhgr {
    private final zzhha zza;

    private zzdxi(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
    }

    public static zzdxi zza(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzdxi(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final zzdye zzb() {
        return new zzdye((Context) this.zza.zzb(), zzffu.zzc());
    }
}
