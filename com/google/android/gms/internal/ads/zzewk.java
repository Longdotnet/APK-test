package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzewk implements zzhgr {
    private final zzewi zza;

    private zzewk(zzewi zzewiVar) {
        this.zza = zzewiVar;
    }

    public static zzewk zza(zzewi zzewiVar) {
        return new zzewk(zzewiVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final Integer zzb() {
        return Integer.valueOf(this.zza.zza());
    }
}
