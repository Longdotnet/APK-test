package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzdgd implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzdgd(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
    }

    public static zzdgd zza(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzdgd(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdgc((zzcye) this.zza.zzb(), (zzddp) this.zzb.zzb());
    }
}
