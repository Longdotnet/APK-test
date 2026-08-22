package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzdec implements zzhgr {
    private final zzhha zza;

    private zzdec(zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzdec zza(zzhha zzhhaVar) {
        return new zzdec(zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdeb(((zzhhd) this.zza).zzb());
    }
}
