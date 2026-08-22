package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzcpg implements zzhgr {
    private final zzhha zza;

    private zzcpg(zzcoz zzcozVar, zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzcpg zza(zzcoz zzcozVar, zzhha zzhhaVar) {
        return new zzcpg(zzcozVar, zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzddv(((zzcpv) this.zza).zzb(), zzcaf.zza);
    }
}
