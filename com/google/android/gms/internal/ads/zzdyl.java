package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzdyl implements zzhgr {
    private final zzhha zza;

    private zzdyl(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
    }

    public static zzdyl zzc(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzdyl(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzdyk zzb() {
        return new zzdyk(((zzchl) this.zza).zza(), zzffu.zzc());
    }
}
