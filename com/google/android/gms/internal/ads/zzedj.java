package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzedj implements zzhgr {
    private final zzhha zza;

    private zzedj(zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzedj zza(zzhha zzhhaVar) {
        return new zzedj(zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzedi(((zzchl) this.zza).zza());
    }
}
