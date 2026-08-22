package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzcxt implements zzhgr {
    private final zzhha zza;

    private zzcxt(zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzcxt zza(zzhha zzhhaVar) {
        return new zzcxt(zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcxs(((zzhhd) this.zza).zzb());
    }
}
