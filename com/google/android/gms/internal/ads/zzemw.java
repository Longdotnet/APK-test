package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzemw implements zzhgr {
    private final zzhha zza;

    private zzemw(zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzemw zza(zzhha zzhhaVar) {
        return new zzemw(zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzemv((Set) this.zza.zzb());
    }
}
