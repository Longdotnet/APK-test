package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzdwp implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzdwp(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
    }

    public static zzdwp zza(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzdwp(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdwo(((zzchl) this.zza).zza(), (zzdsj) this.zzb.zzb());
    }
}
