package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.google.android.gms.common.wrappers.Wrappers;

/* JADX INFO: loaded from: classes.dex */
public final class zzchv implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzchv(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
    }

    public static zzchv zza(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzchv(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        try {
            return Wrappers.packageManager(((zzchl) this.zza).zza()).getPackageInfo(0, ((ApplicationInfo) this.zzb.zzb()).packageName);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }
}
