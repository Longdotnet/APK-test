package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzfee implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzfee(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
    }

    public static zzfee zza(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzfee(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzfed(((zzchl) this.zza).zza(), ((zzcic) this.zzb).zzb());
    }
}
