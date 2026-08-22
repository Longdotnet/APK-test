package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
abstract class zzagf {
    protected final zzafb zza;

    public zzagf(zzafb zzafbVar) {
        this.zza = zzafbVar;
    }

    public abstract boolean zza(zzen zzenVar);

    public abstract boolean zzb(zzen zzenVar, long j);

    public final boolean zzf(zzen zzenVar, long j) {
        return zza(zzenVar) && zzb(zzenVar, j);
    }
}
