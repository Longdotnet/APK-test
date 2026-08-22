package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzdic implements zzhgr {
    private final zzhha zza;

    private zzdic(zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzdic zzc(zzhha zzhhaVar) {
        return new zzdic(zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzdib zzb() {
        return new zzdib(((zzdjm) this.zza).zza());
    }
}
