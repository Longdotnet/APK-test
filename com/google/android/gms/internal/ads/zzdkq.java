package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzdkq implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzdkq(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
    }

    public static zzdkq zza(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzdkq(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdkp((zzdpj) this.zza.zzb(), ((zzdhu) this.zzb).zzc());
    }
}
