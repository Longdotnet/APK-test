package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzcuv implements zzhgr {
    private final zzhha zza;

    private zzcuv(zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzcuv zza(zzhha zzhhaVar) {
        return new zzcuv(zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcuu(((zzcru) this.zza).zzc());
    }
}
