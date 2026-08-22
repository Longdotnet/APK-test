package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzclx implements zzhgr {
    private final zzhha zza;

    private zzclx(zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzclx zza(zzhha zzhhaVar) {
        return new zzclx(zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzclw(((zzchl) this.zza).zza());
    }
}
