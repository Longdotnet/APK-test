package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzccd implements Runnable {
    private final zzcbp zza;
    private boolean zzb = false;

    public zzccd(zzcbp zzcbpVar) {
        this.zza = zzcbpVar;
    }

    private final void zzc() {
        com.google.android.gms.ads.internal.util.zzf zzfVar = com.google.android.gms.ads.internal.util.zzs.zza;
        zzfVar.removeCallbacks(this);
        zzfVar.postDelayed(this, 250L);
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzb) {
            return;
        }
        this.zza.zzt();
        zzc();
    }

    public final void zza() {
        this.zzb = true;
        this.zza.zzt();
    }

    public final void zzb() {
        this.zzb = false;
        zzc();
    }
}
