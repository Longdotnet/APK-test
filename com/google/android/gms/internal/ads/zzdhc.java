package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzdhc implements zzhgr {
    private final zzhha zza;

    private zzdhc(zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzdhc zza(zzhha zzhhaVar) {
        return new zzdhc(zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set setSingleton = ((zzdgz) this.zza).zzc().zze() != null ? Collections.singleton("banner") : Collections.emptySet();
        zzhgz.zzb(setSingleton);
        return setSingleton;
    }
}
