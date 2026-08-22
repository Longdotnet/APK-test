package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzcpa implements zzhgr {
    private final zzcoz zza;
    private final zzhha zzb;

    private zzcpa(zzcoz zzcozVar, zzhha zzhhaVar) {
        this.zza = zzcozVar;
        this.zzb = zzhhaVar;
    }

    public static zzcpa zza(zzcoz zzcozVar, zzhha zzhhaVar) {
        return new zzcpa(zzcozVar, zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* synthetic */ Object zzb() {
        return this.zza.zzd(((zzhhd) this.zzb).zzb());
    }
}
