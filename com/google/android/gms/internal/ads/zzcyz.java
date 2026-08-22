package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzcyz implements zzhgr {
    private final zzhha zza;

    private zzcyz(zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzcyz zzc(zzhha zzhhaVar) {
        return new zzcyz(zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzcyy zzb() {
        return new zzcyy(((zzhhd) this.zza).zzb());
    }
}
