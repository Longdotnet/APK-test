package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: loaded from: classes.dex */
public final class zzcsr implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzcsr(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
    }

    public static zzcsr zza(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzcsr(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcsq((Clock) this.zza.zzb(), (zzbzl) this.zzb.zzb());
    }
}
