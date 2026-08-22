package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzdoj implements zzhgr {
    private final zzhha zza;

    private zzdoj(zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzdoj zzc(zzhha zzhhaVar) {
        return new zzdoj(zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzdoi zzb() {
        return new zzdoi(((zzdjm) this.zza).zza());
    }
}
