package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzcxg implements zzhgr {
    private final zzhha zza;

    private zzcxg(zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzcxg zza(zzhha zzhhaVar) {
        return new zzcxg(zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcxf(((zzhhd) this.zza).zzb());
    }
}
