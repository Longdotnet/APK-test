package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: loaded from: classes.dex */
public final class zzehl implements zzhgr {
    private final zzehk zza;
    private final zzhha zzb;
    private final zzhha zzc;
    private final zzhha zzd;
    private final zzhha zze;

    private zzehl(zzehk zzehkVar, zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4) {
        this.zza = zzehkVar;
        this.zzb = zzhhaVar;
        this.zzc = zzhhaVar2;
        this.zzd = zzhhaVar3;
        this.zze = zzhhaVar4;
    }

    public static zzehl zza(zzehk zzehkVar, zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4) {
        return new zzehl(zzehkVar, zzhhaVar, zzhhaVar2, zzhhaVar3, zzhhaVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* synthetic */ Object zzb() {
        return this.zza.zza((Clock) this.zzb.zzb(), ((zzehe) this.zzc).zzb(), (zzedr) this.zzd.zzb(), (zzfjy) this.zze.zzb());
    }
}
