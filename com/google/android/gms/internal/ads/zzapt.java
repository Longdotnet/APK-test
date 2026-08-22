package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzapt implements Runnable {
    private final zzaqd zza;
    private final zzaqj zzb;
    private final Runnable zzc;

    public zzapt(zzaqd zzaqdVar, zzaqj zzaqjVar, Runnable runnable) {
        this.zza = zzaqdVar;
        this.zzb = zzaqjVar;
        this.zzc = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzaqd zzaqdVar = this.zza;
        zzaqdVar.zzw();
        zzaqj zzaqjVar = this.zzb;
        if (zzaqjVar.zzc()) {
            zzaqdVar.zzo(zzaqjVar.zza);
        } else {
            zzaqdVar.zzn(zzaqjVar.zzc);
        }
        if (zzaqjVar.zzd) {
            zzaqdVar.zzm("intermediate-response");
        } else {
            zzaqdVar.zzp("done");
        }
        Runnable runnable = this.zzc;
        if (runnable != null) {
            runnable.run();
        }
    }
}
