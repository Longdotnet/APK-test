package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: loaded from: classes.dex */
public final class zzdsx implements zzhgr {
    private final zzhha zza;

    private zzdsx(zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzdsx zza(zzhha zzhhaVar) {
        return new zzdsx(zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdsw((Clock) this.zza.zzb());
    }
}
