package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzdvk implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzdvk(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
    }

    public static zzdvk zza(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzdvk(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdvd((zzdun) this.zza.zzb(), (zzdpw) this.zzb.zzb());
    }
}
