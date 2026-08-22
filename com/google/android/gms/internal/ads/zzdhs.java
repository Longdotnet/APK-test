package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzdhs implements zzhgr {
    private final zzhha zza;

    private zzdhs(zzdhp zzdhpVar, zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzdhs zza(zzdhp zzdhpVar, zzhha zzhhaVar) {
        return new zzdhs(zzdhpVar, zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final zzdiy zzb() {
        zzdix zzdixVar = (zzdix) this.zza.zzb();
        zzhgz.zzb(zzdixVar);
        return zzdixVar;
    }
}
