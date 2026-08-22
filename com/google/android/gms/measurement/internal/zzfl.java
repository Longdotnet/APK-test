package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes.dex */
public final class zzfl implements Thread.UncaughtExceptionHandler {
    public final /* synthetic */ zzfo zza;
    public final String zzb;

    public zzfl(zzfo zzfoVar, String str) {
        this.zza = zzfoVar;
        this.zzb = str;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        zzeh zzehVar = ((zzfr) this.zza.mBuilder).zzm;
        zzfr.zzR(zzehVar);
        zzehVar.zzd.zzb(th, this.zzb);
    }
}
