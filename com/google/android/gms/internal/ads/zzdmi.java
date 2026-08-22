package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzdmi implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzdmi(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3) {
        this.zza = zzhhaVar2;
        this.zzb = zzhhaVar3;
    }

    public static zzdmi zzc(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3) {
        return new zzdmi(zzhhaVar, zzhhaVar2, zzhhaVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzdmh zzb() {
        return new zzdmh(zzffu.zzc(), ((zzdmd) this.zza).zzb(), (zzdsd) this.zzb.zzb());
    }
}
