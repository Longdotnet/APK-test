package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzdbl implements zzhgr {
    private final zzhha zza;

    private zzdbl(zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzdbl zza(zzhha zzhhaVar) {
        return new zzdbl(zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdbk(((zzhhd) this.zza).zzb());
    }
}
