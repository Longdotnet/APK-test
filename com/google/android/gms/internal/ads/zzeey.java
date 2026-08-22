package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class zzeey implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzeey(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
    }

    public static zzeey zzc(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzeey(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzeex zzb() {
        return new zzeex((Context) this.zza.zzb(), (zzcpx) this.zzb.zzb());
    }
}
