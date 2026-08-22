package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzboc extends zzcar {
    private final Object zza = new Object();
    private final zzboh zzb;
    private boolean zzc;

    public zzboc(zzboh zzbohVar) {
        this.zzb = zzbohVar;
    }

    public final void zzb() {
        com.google.android.gms.ads.internal.util.zze.zza("release: Trying to acquire lock");
        synchronized (this.zza) {
            try {
                com.google.android.gms.ads.internal.util.zze.zza("release: Lock acquired");
                if (this.zzc) {
                    com.google.android.gms.ads.internal.util.zze.zza("release: Lock already released");
                    return;
                }
                this.zzc = true;
                zzj(new zzbnz(this), new zzcan());
                zzj(new zzboa(this), new zzbob(this));
                com.google.android.gms.ads.internal.util.zze.zza("release: Lock released");
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
