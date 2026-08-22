package com.google.android.gms.internal.appset;

/* JADX INFO: loaded from: classes.dex */
final class zzj implements Runnable {
    final /* synthetic */ zzl zza;

    public /* synthetic */ zzj(zzl zzlVar, zzi zziVar) {
        this.zza = zzlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long jZza = this.zza.zza();
        if (jZza == -1 || System.currentTimeMillis() <= jZza) {
            return;
        }
        zzl.zze(this.zza.zzb);
    }
}
