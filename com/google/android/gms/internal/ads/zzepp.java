package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: loaded from: classes.dex */
public final class zzepp implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzepp(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4) {
        this.zza = zzhhaVar2;
        this.zzb = zzhhaVar4;
    }

    public static zzepp zza(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4) {
        return new zzepp(zzhhaVar, zzhhaVar2, zzhhaVar3, zzhhaVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzeou(zzesb.zzc(), ((Long) zzbet.zzf.zze()).longValue(), (Clock) this.zza.zzb(), zzffu.zzc(), (zzdsj) this.zzb.zzb());
    }
}
