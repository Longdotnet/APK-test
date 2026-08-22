package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzewm implements zzhgr {
    private final zzewi zza;

    private zzewm(zzewi zzewiVar) {
        this.zza = zzewiVar;
    }

    public static zzewm zza(zzewi zzewiVar) {
        return new zzewm(zzewiVar);
    }

    public static boolean zzd(zzewi zzewiVar) {
        return zzewiVar.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final Boolean zzb() {
        return Boolean.valueOf(this.zza.zzj());
    }
}
