package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class zzeqe implements zzhgr {
    private final zzhha zza;

    private zzeqe(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar2;
    }

    public static zzeqe zza(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzeqe(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final Object zzb() {
        zzfyv zzfyvVarZzn;
        zzeow zzeowVarZzc = zzeoy.zzc();
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.zza.zzb();
        zzbcv zzbcvVar = zzbde.zzet;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            zzfyvVarZzn = zzfyv.zzo(new zzeso(zzeowVarZzc, ((Integer) zzbdVar.zzd.zzb(zzbde.zzeu)).intValue(), scheduledExecutorService));
        } else {
            zzfyvVarZzn = zzfyv.zzn();
        }
        zzhgz.zzb(zzfyvVarZzn);
        return zzfyvVarZzn;
    }
}
