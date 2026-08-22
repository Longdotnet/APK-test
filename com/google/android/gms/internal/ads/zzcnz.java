package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzcnz implements zzazw {
    private final ScheduledExecutorService zza;
    private final Clock zzb;
    private ScheduledFuture zzc;
    private long zzd = -1;
    private long zze = -1;
    private Runnable zzf = null;
    private boolean zzg = false;

    public zzcnz(ScheduledExecutorService scheduledExecutorService, Clock clock) {
        this.zza = scheduledExecutorService;
        this.zzb = clock;
        com.google.android.gms.ads.internal.zzv.zza.zzh.zzc(this);
    }

    @Override // com.google.android.gms.internal.ads.zzazw
    public final void zza(boolean z) {
        if (z) {
            zzc();
        } else {
            zzb();
        }
    }

    public final synchronized void zzb() {
        try {
            if (this.zzg) {
                return;
            }
            ScheduledFuture scheduledFuture = this.zzc;
            if (scheduledFuture == null || scheduledFuture.isDone()) {
                this.zze = -1L;
            } else {
                this.zzc.cancel(true);
                long j = this.zzd;
                ((DefaultClock) this.zzb).getClass();
                this.zze = j - SystemClock.elapsedRealtime();
            }
            this.zzg = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zzc() {
        ScheduledFuture scheduledFuture;
        try {
            if (this.zzg) {
                if (this.zze > 0 && (scheduledFuture = this.zzc) != null && scheduledFuture.isCancelled()) {
                    this.zzc = this.zza.schedule(this.zzf, this.zze, TimeUnit.MILLISECONDS);
                }
                this.zzg = false;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zzd(int i, Runnable runnable) {
        this.zzf = runnable;
        ((DefaultClock) this.zzb).getClass();
        long j = i;
        this.zzd = SystemClock.elapsedRealtime() + j;
        this.zzc = this.zza.schedule(runnable, j, TimeUnit.MILLISECONDS);
    }
}
