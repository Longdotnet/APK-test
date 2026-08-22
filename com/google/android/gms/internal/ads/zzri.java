package com.google.android.gms.internal.ads;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
final class zzri {
    private Exception zza;
    private long zzb = -9223372036854775807L;
    private long zzc = -9223372036854775807L;

    public final void zza() {
        this.zza = null;
        this.zzb = -9223372036854775807L;
        this.zzc = -9223372036854775807L;
    }

    public final void zzb(Exception exc) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (this.zza == null) {
            this.zza = exc;
        }
        if (this.zzb == -9223372036854775807L && !zzro.zzM()) {
            this.zzb = 200 + jElapsedRealtime;
        }
        long j = this.zzb;
        if (j == -9223372036854775807L || jElapsedRealtime < j) {
            this.zzc = jElapsedRealtime + 50;
            return;
        }
        Exception exc2 = this.zza;
        if (exc2 != exc) {
            exc2.addSuppressed(exc);
        }
        Exception exc3 = this.zza;
        zza();
        throw exc3;
    }

    public final boolean zzc() {
        if (this.zza == null) {
            return false;
        }
        return zzro.zzM() || SystemClock.elapsedRealtime() < this.zzc;
    }
}
