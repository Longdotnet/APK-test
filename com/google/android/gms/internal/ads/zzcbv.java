package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzcbv {
    private long zzb;
    private final long zza = TimeUnit.MILLISECONDS.toNanos(((Long) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzV)).longValue());
    private boolean zzc = true;

    public final void zza(SurfaceTexture surfaceTexture, final zzcbg zzcbgVar) {
        if (zzcbgVar == null) {
            return;
        }
        long timestamp = surfaceTexture.getTimestamp();
        if (!this.zzc) {
            long j = timestamp - this.zzb;
            if (Math.abs(j) < this.zza) {
                return;
            }
        }
        this.zzc = false;
        this.zzb = timestamp;
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcbu
            @Override // java.lang.Runnable
            public final void run() {
                zzcbgVar.zzk();
            }
        });
    }

    public final void zzb() {
        this.zzc = true;
    }
}
