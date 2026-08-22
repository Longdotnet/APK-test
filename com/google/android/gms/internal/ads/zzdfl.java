package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzdfl implements zzhgr {
    private final zzhha zza;

    private zzdfl(zzdff zzdffVar, zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzdfl zza(zzdff zzdffVar, zzhha zzhhaVar) {
        return new zzdfl(zzdffVar, zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set setSingleton = Collections.singleton(new zzddv((zzcur) this.zza.zzb(), zzcaf.zzg));
        zzhgz.zzb(setSingleton);
        return setSingleton;
    }
}
