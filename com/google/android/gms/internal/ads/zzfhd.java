package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzfhd implements zzhgr {
    private final zzhha zza;

    private zzfhd(zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzfhd zzc(zzhha zzhhaVar) {
        return new zzfhd(zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzfgz zzb() {
        return new zzfgz(((zzhhd) this.zza).zzb());
    }
}
