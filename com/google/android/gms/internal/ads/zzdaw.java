package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzdaw implements zzhgr {
    private final zzhha zza;

    private zzdaw(zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzdaw zza(zzhha zzhhaVar) {
        return new zzdaw(zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdav(((zzhhd) this.zza).zzb());
    }
}
