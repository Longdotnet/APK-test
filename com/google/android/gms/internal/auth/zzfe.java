package com.google.android.gms.internal.auth;

/* JADX INFO: loaded from: classes.dex */
abstract class zzfe {
    private static final zzfe zza;
    private static final zzfe zzb;

    static {
        zzfb zzfbVar = null;
        zza = new zzfc(zzfbVar);
        zzb = new zzfd(zzfbVar);
    }

    public /* synthetic */ zzfe(zzfb zzfbVar) {
    }

    public static zzfe zzc() {
        return zza;
    }

    public static zzfe zzd() {
        return zzb;
    }

    public abstract void zza(Object obj, long j);

    public abstract <L> void zzb(Object obj, Object obj2, long j);
}
