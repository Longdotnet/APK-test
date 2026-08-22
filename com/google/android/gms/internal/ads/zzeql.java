package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class zzeql implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzeql(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
    }

    public static zzeql zza(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzeql(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final Object zzb() {
        return new zzeso(((zzerx) this.zza).zzb(), ((Integer) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzmF)).intValue(), (ScheduledExecutorService) this.zzb.zzb());
    }
}
