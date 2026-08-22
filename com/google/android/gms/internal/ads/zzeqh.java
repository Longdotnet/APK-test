package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class zzeqh implements zzhgr {
    private final zzhha zza;

    private zzeqh(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar2;
    }

    public static zzeqh zza(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzeqh(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final Object zzb() {
        return new zzeso(zzere.zzc(), ((Integer) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzmG)).intValue(), (ScheduledExecutorService) this.zza.zzb());
    }
}
