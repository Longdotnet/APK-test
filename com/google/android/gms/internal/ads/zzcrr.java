package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzcrr implements zzhgr {
    private final zzcrq zza;

    private zzcrr(zzcrq zzcrqVar) {
        this.zza = zzcrqVar;
    }

    public static zzcrr zza(zzcrq zzcrqVar) {
        return new zzcrr(zzcrqVar);
    }

    public static zzfca zzd(zzcrq zzcrqVar) {
        zzfca zzfcaVarZza = zzcrqVar.zza();
        zzhgz.zzb(zzfcaVarZza);
        return zzfcaVarZza;
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }

    public final zzfca zzc() {
        return zzd(this.zza);
    }
}
