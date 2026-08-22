package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzewn implements zzhgr {
    private final zzewi zza;

    private zzewn(zzewi zzewiVar) {
        this.zza = zzewiVar;
    }

    public static zzewn zza(zzewi zzewiVar) {
        return new zzewn(zzewiVar);
    }

    public static String zzd(zzewi zzewiVar) {
        String strZzg = zzewiVar.zzg();
        zzhgz.zzb(strZzg);
        return strZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }

    public final String zzc() {
        return zzd(this.zza);
    }
}
