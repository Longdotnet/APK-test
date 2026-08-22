package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class zzewh implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzewh(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3) {
        this.zza = zzhhaVar2;
        this.zzb = zzhhaVar3;
    }

    public static zzewh zza(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3) {
        return new zzewh(zzhhaVar, zzhhaVar2, zzhhaVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzewf(zzckx.zza(), (ScheduledExecutorService) this.zza.zzb(), ((zzchl) this.zzb).zza());
    }
}
