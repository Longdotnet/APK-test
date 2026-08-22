package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzcqs {
    private final zzcyv zza;
    private final zzdbb zzb;

    public zzcqs(zzcyv zzcyvVar, zzdbb zzdbbVar) {
        this.zza = zzcyvVar;
        this.zzb = zzdbbVar;
    }

    public final zzcyv zza() {
        return this.zza;
    }

    public final zzdbb zzb() {
        return this.zzb;
    }

    public final zzddv zzc() {
        zzdbb zzdbbVar = this.zzb;
        return zzdbbVar != null ? new zzddv(zzdbbVar, zzcaf.zzg) : new zzddv(new zzcqr(this), zzcaf.zzg);
    }
}
