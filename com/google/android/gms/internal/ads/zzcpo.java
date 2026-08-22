package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzcpo implements zzhgr {
    private final zzhha zza;

    private zzcpo(zzcoz zzcozVar, zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
    }

    public static zzcpo zza(zzcoz zzcozVar, zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzcpo(zzcozVar, zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzddv((zzcqw) this.zza.zzb(), zzffu.zzc());
    }
}
