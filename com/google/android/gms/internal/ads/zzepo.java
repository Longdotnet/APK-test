package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: loaded from: classes.dex */
public final class zzepo implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;
    private final zzhha zzc;

    private zzepo(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
        this.zzc = zzhhaVar4;
    }

    public static zzepo zza(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4) {
        return new zzepo(zzhhaVar, zzhhaVar2, zzhhaVar3, zzhhaVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzeou(((zzert) this.zza).zzb(), ((Long) zzbet.zze.zze()).longValue(), (Clock) this.zzb.zzb(), zzffu.zzc(), (zzdsj) this.zzc.zzb());
    }
}
