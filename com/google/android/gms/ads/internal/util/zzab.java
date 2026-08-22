package com.google.android.gms.ads.internal.util;

/* JADX INFO: loaded from: classes.dex */
public final class zzab {
    public boolean zza;
    public float zzb;

    public final synchronized float zza() {
        if (!zzf()) {
            return 1.0f;
        }
        return this.zzb;
    }

    public final synchronized void zzc(boolean z) {
        this.zza = z;
    }

    public final synchronized void zzd(float f) {
        this.zzb = f;
    }

    public final synchronized boolean zze() {
        return this.zza;
    }

    public final synchronized boolean zzf() {
        return this.zzb >= 0.0f;
    }
}
