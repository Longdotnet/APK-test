package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzcyv extends zzdbt {
    private final ScheduledExecutorService zzb;
    private final Clock zzc;
    private final zzdsj zzd;
    private long zze;
    private long zzf;
    private long zzg;
    private long zzh;
    private boolean zzi;
    private ScheduledFuture zzj;
    private ScheduledFuture zzk;

    public zzcyv(ScheduledExecutorService scheduledExecutorService, Clock clock, zzdsj zzdsjVar) {
        super(Collections.emptySet());
        this.zze = -1L;
        this.zzf = -1L;
        this.zzg = -1L;
        this.zzh = -1L;
        this.zzi = false;
        this.zzb = scheduledExecutorService;
        this.zzc = clock;
        this.zzd = zzdsjVar;
    }

    private final synchronized void zzf(long j) {
        try {
            ScheduledFuture scheduledFuture = this.zzj;
            if (scheduledFuture != null && !scheduledFuture.isDone()) {
                this.zzj.cancel(false);
            }
            ((DefaultClock) this.zzc).getClass();
            this.zze = SystemClock.elapsedRealtime() + j;
            this.zzj = this.zzb.schedule(new zzcys(this, null), j, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            throw th;
        }
    }

    private final synchronized void zzg(long j) {
        try {
            ScheduledFuture scheduledFuture = this.zzk;
            if (scheduledFuture != null && !scheduledFuture.isDone()) {
                this.zzk.cancel(false);
            }
            ((DefaultClock) this.zzc).getClass();
            this.zzf = SystemClock.elapsedRealtime() + j;
            this.zzk = this.zzb.schedule(new zzcyt(this, null), j, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zza() {
        this.zzi = false;
        zzf(0L);
    }

    public final synchronized void zzb() {
        try {
            if (this.zzi) {
                return;
            }
            ScheduledFuture scheduledFuture = this.zzj;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                this.zzg = -1L;
            } else {
                this.zzj.cancel(false);
                long j = this.zze;
                ((DefaultClock) this.zzc).getClass();
                this.zzg = j - SystemClock.elapsedRealtime();
            }
            ScheduledFuture scheduledFuture2 = this.zzk;
            if (scheduledFuture2 == null || scheduledFuture2.isCancelled()) {
                this.zzh = -1L;
            } else {
                this.zzk.cancel(false);
                long j2 = this.zzf;
                ((DefaultClock) this.zzc).getClass();
                this.zzh = j2 - SystemClock.elapsedRealtime();
            }
            this.zzi = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zzc() {
        ScheduledFuture scheduledFuture;
        ScheduledFuture scheduledFuture2;
        try {
            if (this.zzi) {
                if (this.zzg > 0 && (scheduledFuture2 = this.zzj) != null && scheduledFuture2.isCancelled()) {
                    zzf(this.zzg);
                }
                if (this.zzh > 0 && (scheduledFuture = this.zzk) != null && scheduledFuture.isCancelled()) {
                    zzg(this.zzh);
                }
                this.zzi = false;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zzd(int i) {
        com.google.android.gms.ads.internal.util.zze.zza("In scheduleRefresh: " + i);
        if (i > 0) {
            long millis = TimeUnit.SECONDS.toMillis(i);
            if (this.zzi) {
                long j = this.zzg;
                if (j <= 0 || millis >= j) {
                    millis = j;
                }
                this.zzg = millis;
                return;
            }
            ((DefaultClock) this.zzc).getClass();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            zzbcv zzbcvVar = zzbde.zznE;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
            if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
                long j2 = this.zze;
                if (jElapsedRealtime >= j2 || j2 - jElapsedRealtime > millis) {
                    zzf(millis);
                    if (((Boolean) zzbdVar.zzd.zzb(zzbde.zznQ)).booleanValue()) {
                        zzdsi zzdsiVarZza = this.zzd.zza();
                        zzdsiVarZza.zzb("action", "rtnc");
                        zzdsiVarZza.zzi();
                    }
                }
            } else {
                long j3 = this.zze;
                if (jElapsedRealtime > j3 || j3 - jElapsedRealtime > millis) {
                    zzf(millis);
                }
            }
        }
    }

    public final synchronized void zze(int i) {
        com.google.android.gms.ads.internal.util.zze.zza("In scheduleShowRefreshedAd: " + i);
        if (i > 0) {
            long millis = TimeUnit.SECONDS.toMillis(i);
            if (this.zzi) {
                long j = this.zzh;
                if (j <= 0 || millis >= j) {
                    millis = j;
                }
                this.zzh = millis;
                return;
            }
            ((DefaultClock) this.zzc).getClass();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zznE)).booleanValue()) {
                if (jElapsedRealtime == this.zzf) {
                    com.google.android.gms.ads.internal.util.zze.zza("In scheduleShowRefreshedAd: currentTimeMs = scheduledShowTimeMs");
                }
                long j2 = this.zzf;
                if (jElapsedRealtime >= j2 || j2 - jElapsedRealtime > millis) {
                    zzg(millis);
                }
            } else {
                long j3 = this.zzf;
                if (jElapsedRealtime > j3 || j3 - jElapsedRealtime > millis) {
                    zzg(millis);
                }
            }
        }
    }
}
