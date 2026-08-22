package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzdyr implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzdyr(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
    }

    public static zzdyr zzc(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzdyr(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzdyq zzb() {
        return new zzdyq(((zzchl) this.zza).zza(), (zzbyo) this.zzb.zzb());
    }
}
