package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzewj implements zzhgr {
    private final zzewi zza;

    private zzewj(zzewi zzewiVar) {
        this.zza = zzewiVar;
    }

    public static zzewj zza(zzewi zzewiVar) {
        return new zzewj(zzewiVar);
    }

    public static String zzd(zzewi zzewiVar) {
        String strZze = zzewiVar.zze();
        zzhgz.zzb(strZze);
        return strZze;
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }

    public final String zzc() {
        return zzd(this.zza);
    }
}
