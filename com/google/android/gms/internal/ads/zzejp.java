package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzejp implements zzhgr {
    private final zzhha zza;

    private zzejp(zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzejp zzc(zzhha zzhhaVar) {
        return new zzejp(zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzejo zzb() {
        return new zzejo((zzdgf) this.zza.zzb());
    }
}
