package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzcpj implements zzhgr {
    private final zzcoz zza;
    private final zzhha zzb;

    private zzcpj(zzcoz zzcozVar, zzhha zzhhaVar) {
        this.zza = zzcozVar;
        this.zzb = zzhhaVar;
    }

    public static zzcpj zza(zzcoz zzcozVar, zzhha zzhhaVar) {
        return new zzcpj(zzcozVar, zzhhaVar);
    }

    public static Set zzc(zzcoz zzcozVar, zzcqp zzcqpVar) {
        Set setSingleton = Collections.singleton(new zzddv(zzcqpVar, zzcaf.zzg));
        zzhgz.zzb(setSingleton);
        return setSingleton;
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return zzc(this.zza, (zzcqp) this.zzb.zzb());
    }
}
