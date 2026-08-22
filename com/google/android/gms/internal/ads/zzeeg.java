package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class zzeeg implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzeeg(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
    }

    public static zzeeg zzc(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzeeg(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzeef zzb() {
        return new zzeef((Context) this.zza.zzb(), (zzcog) this.zzb.zzb());
    }
}
