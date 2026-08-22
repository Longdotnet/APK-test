package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class zzeqi implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzeqi(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
    }

    public static zzeqi zza(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzeqi(zzhhaVar, zzhhaVar2);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0031  */
    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final Object zzb() {
        zzfyv zzfyvVarZzn;
        zzerg zzergVarZzb = ((zzeri) this.zza).zzb();
        Context contextZza = ((zzchl) this.zzb).zza();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzlO)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
            if (com.google.android.gms.ads.internal.util.zzs.zzC(contextZza)) {
                zzfyvVarZzn = zzfyv.zzo(zzergVarZzb);
            } else {
                zzfyvVarZzn = zzfyv.zzn();
            }
        } else {
            zzfyvVarZzn = zzfyv.zzn();
        }
        zzhgz.zzb(zzfyvVarZzn);
        return zzfyvVarZzn;
    }
}
