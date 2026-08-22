package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzdtq implements zzhgr {
    private final zzhha zza;

    private zzdtq(zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzdtp zzc(zzble zzbleVar) {
        return new zzdtp(zzbleVar);
    }

    public static zzdtq zzd(zzhha zzhhaVar) {
        return new zzdtq(zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzdtp zzb() {
        return new zzdtp((zzble) this.zza.zzb());
    }
}
