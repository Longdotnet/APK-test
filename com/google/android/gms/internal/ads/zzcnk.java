package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzcnk implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzcnk(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
    }

    public static zzcnk zza(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzcnk(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcnj(((zzchl) this.zza).zza(), (zzayz) this.zzb.zzb());
    }
}
