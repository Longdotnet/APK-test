package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzcyf implements zzhgr {
    private final zzhha zza;

    private zzcyf(zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzcyf zza(zzhha zzhhaVar) {
        return new zzcyf(zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcye(((zzhhd) this.zza).zzb());
    }
}
