package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzdna implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzdna(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
    }

    public static zzdna zza(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzdna(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdmz((zzdio) this.zza.zzb(), ((zzdjm) this.zzb).zza());
    }
}
