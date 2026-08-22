package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzeus implements zzhgr {
    private final zzhha zza;

    private zzeus(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar2;
    }

    public static zzeus zzc(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzeus(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzeur zzb() {
        return new zzeur(zzffu.zzc(), ((zzchl) this.zza).zza());
    }
}
