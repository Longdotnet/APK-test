package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;

/* JADX INFO: loaded from: classes.dex */
public final class zzesi implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;
    private final zzhha zzc;

    private zzesi(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4) {
        this.zza = zzhhaVar2;
        this.zzb = zzhhaVar3;
        this.zzc = zzhhaVar4;
    }

    public static zzesi zza(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4) {
        return new zzesi(zzhhaVar, zzhhaVar2, zzhhaVar3, zzhhaVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzesg(zzffu.zzc(), ((zzcvp) this.zza).zzc(), (PackageInfo) this.zzb.zzb(), ((zzchi) this.zzc).zzb());
    }
}
