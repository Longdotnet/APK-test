package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzchs implements zzhgr {
    private final zzhha zza;

    private zzchs(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
    }

    public static zzchs zza(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzchs(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final Object zzb() {
        Set setSingleton = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzbP)).booleanValue() ? Collections.singleton(new zzddv((zzdup) this.zza.zzb(), zzffu.zzc())) : Collections.emptySet();
        zzhgz.zzb(setSingleton);
        return setSingleton;
    }
}
