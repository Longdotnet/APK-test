package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzckj implements zzhgr {
    private final zzhha zza;

    private zzckj(zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzckj zza(zzhha zzhhaVar) {
        return new zzckj(zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new com.google.android.gms.ads.internal.util.zzbo(((zzchl) this.zza).zza());
    }
}
