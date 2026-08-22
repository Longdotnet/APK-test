package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzdkz implements zzhgr {
    private final zzhha zza;

    private zzdkz(zzdky zzdkyVar, zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzdkz zza(zzdky zzdkyVar, zzhha zzhhaVar) {
        return new zzdkz(zzdkyVar, zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzdkw zzdkwVar = (zzdkw) this.zza.zzb();
        zzhgz.zzb(zzdkwVar);
        return zzdkwVar;
    }
}
