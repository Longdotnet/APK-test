package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzcpm implements zzhgr {
    private final zzhha zza;

    private zzcpm(zzcoz zzcozVar, zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzcpm zza(zzcoz zzcozVar, zzhha zzhhaVar) {
        return new zzcpm(zzcozVar, zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set setSingleton = Collections.singleton(new zzddv((zzcqp) this.zza.zzb(), zzcaf.zzg));
        zzhgz.zzb(setSingleton);
        return setSingleton;
    }
}
