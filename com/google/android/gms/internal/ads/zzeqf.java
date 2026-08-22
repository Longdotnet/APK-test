package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class zzeqf implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzeqf(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
    }

    public static zzeqf zza(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzeqf(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final Object zzb() {
        return new zzeso(((zzepc) this.zza).zzb(), ((Integer) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzmP)).intValue(), (ScheduledExecutorService) this.zzb.zzb());
    }
}
