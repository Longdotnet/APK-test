package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzddd implements zzhgr {
    private final zzhha zza;

    private zzddd(zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzddd zzc(zzhha zzhhaVar) {
        return new zzddd(zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzddc zzb() {
        return new zzddc(((zzhhd) this.zza).zzb());
    }
}
