package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzdvo implements zzhgr {
    private final zzhha zza;

    private zzdvo(zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzdvo zza(zzhha zzhhaVar) {
        return new zzdvo(zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdwl(((zzchl) this.zza).zza());
    }
}
