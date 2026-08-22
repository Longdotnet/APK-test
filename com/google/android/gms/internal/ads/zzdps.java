package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzdps implements zzhgr {
    private final zzhha zza;

    private zzdps(zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzdps zzc(zzhha zzhhaVar) {
        return new zzdps(zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzdpr zzb() {
        return new zzdpr((zzcfg) this.zza.zzb());
    }
}
