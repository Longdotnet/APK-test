package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzdfs implements zzhgr {
    private final zzhha zza;

    private zzdfs(zzdff zzdffVar, zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzdfs zza(zzdff zzdffVar, zzhha zzhhaVar) {
        return new zzdfs(zzdffVar, zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set setSingleton = Collections.singleton(new zzddv((zzcur) this.zza.zzb(), zzcaf.zzg));
        zzhgz.zzb(setSingleton);
        return setSingleton;
    }
}
