package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzewp implements zzhgr {
    private final zzewi zza;

    private zzewp(zzewi zzewiVar) {
        this.zza = zzewiVar;
    }

    public static zzewp zza(zzewi zzewiVar) {
        return new zzewp(zzewiVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final Integer zzb() {
        return Integer.valueOf(this.zza.zzc());
    }
}
