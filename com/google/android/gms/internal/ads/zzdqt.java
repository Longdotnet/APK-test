package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzdqt implements zzhgr {
    private final zzhha zza;

    private zzdqt(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar2;
    }

    public static zzdqt zza(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzdqt(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final Object zzb() {
        zzgdy zzgdyVarZzc = zzffu.zzc();
        Set setSingleton = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzft)).booleanValue() ? Collections.singleton(new zzddv(((zzdrm) this.zza).zzb(), zzgdyVarZzc)) : Collections.emptySet();
        zzhgz.zzb(setSingleton);
        return setSingleton;
    }
}
