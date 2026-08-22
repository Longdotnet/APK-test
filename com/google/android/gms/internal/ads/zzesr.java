package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

/* JADX INFO: loaded from: classes.dex */
public final class zzesr implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;
    private final zzhha zzc;

    private zzesr(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
        this.zzc = zzhhaVar3;
    }

    public static zzesr zzc(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3) {
        return new zzesr(zzhhaVar, zzhhaVar2, zzhhaVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzesp zzb() {
        return new zzesp((ApplicationInfo) this.zza.zzb(), (PackageInfo) this.zzb.zzb(), ((zzchl) this.zzc).zza());
    }
}
