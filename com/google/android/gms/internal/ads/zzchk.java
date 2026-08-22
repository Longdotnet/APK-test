package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;

/* JADX INFO: loaded from: classes.dex */
public final class zzchk implements zzhgr {
    private final zzhha zza;

    private zzchk(zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzchk zza(zzhha zzhhaVar) {
        return new zzchk(zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        ApplicationInfo applicationInfo = ((zzchl) this.zza).zza().getApplicationInfo();
        zzhgz.zzb(applicationInfo);
        return applicationInfo;
    }
}
