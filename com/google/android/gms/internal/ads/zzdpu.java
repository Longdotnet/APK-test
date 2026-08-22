package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzdpu implements zzhgr {
    private final zzhha zza;

    private zzdpu(zzdpt zzdptVar, zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzdpu zza(zzdpt zzdptVar, zzhha zzhhaVar) {
        return new zzdpu(zzdptVar, zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzddv(((zzdps) this.zza).zzb(), zzcaf.zzf);
    }
}
