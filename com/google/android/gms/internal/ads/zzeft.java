package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class zzeft implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzeft(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
    }

    public static zzeft zzc(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzeft(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzefs zzb() {
        return new zzefs((Context) this.zza.zzb(), (zzdgf) this.zzb.zzb());
    }
}
