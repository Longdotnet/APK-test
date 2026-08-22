package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzcqv implements zzhgr {
    private final zzcqs zza;

    private zzcqv(zzcqs zzcqsVar) {
        this.zza = zzcqsVar;
    }

    public static zzcqv zza(zzcqs zzcqsVar) {
        return new zzcqv(zzcqsVar);
    }

    public static zzcyv zzd(zzcqs zzcqsVar) {
        return zzcqsVar.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }

    public final zzcyv zzc() {
        return zzd(this.zza);
    }
}
