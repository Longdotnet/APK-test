package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzddt implements zzhgr {
    private final zzhha zza;

    private zzddt(zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzddt zza(zzhha zzhhaVar) {
        return new zzddt(zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdds(((zzhhd) this.zza).zzb());
    }
}
