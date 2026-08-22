package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzdfx implements zzhgr {
    private final zzhha zza;

    private zzdfx(zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzdfx zza(zzhha zzhhaVar) {
        return new zzdfx(zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set setSingleton = Collections.singleton(new zzddv((zzdgq) this.zza.zzb(), zzcaf.zzg));
        zzhgz.zzb(setSingleton);
        return setSingleton;
    }
}
