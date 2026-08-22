package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzfnp implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        if (zzfns.zzc != null) {
            zzfns.zzc.post(zzfns.zzd);
            zzfns.zzc.postDelayed(zzfns.zze, 200L);
        }
    }
}
