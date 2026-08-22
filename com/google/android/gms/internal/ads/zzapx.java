package com.google.android.gms.internal.ads;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: loaded from: classes.dex */
public final class zzapx extends Thread {
    private final BlockingQueue zza;
    private final zzapw zzb;
    private final zzapn zzc;
    private volatile boolean zzd = false;
    private final zzapu zze;

    public zzapx(BlockingQueue blockingQueue, zzapw zzapwVar, zzapn zzapnVar, zzapu zzapuVar) {
        this.zza = blockingQueue;
        this.zzb = zzapwVar;
        this.zzc = zzapnVar;
        this.zze = zzapuVar;
    }

    private void zzb() {
        zzaqd zzaqdVar = (zzaqd) this.zza.take();
        SystemClock.elapsedRealtime();
        zzaqdVar.zzt(3);
        try {
            try {
                zzaqdVar.zzm("network-queue-take");
                zzaqdVar.zzw();
                TrafficStats.setThreadStatsTag(zzaqdVar.zzc());
                zzapz zzapzVarZza = this.zzb.zza(zzaqdVar);
                zzaqdVar.zzm("network-http-complete");
                if (zzapzVarZza.zze && zzaqdVar.zzv()) {
                    zzaqdVar.zzp("not-modified");
                    zzaqdVar.zzr();
                } else {
                    zzaqj zzaqjVarZzh = zzaqdVar.zzh(zzapzVarZza);
                    zzaqdVar.zzm("network-parse-complete");
                    zzapm zzapmVar = zzaqjVarZzh.zzb;
                    if (zzapmVar != null) {
                        this.zzc.zzd(zzaqdVar.zzj(), zzapmVar);
                        zzaqdVar.zzm("network-cache-written");
                    }
                    zzaqdVar.zzq();
                    this.zze.zzb(zzaqdVar, zzaqjVarZzh, null);
                    zzaqdVar.zzs(zzaqjVarZzh);
                }
            } catch (zzaqm e) {
                SystemClock.elapsedRealtime();
                this.zze.zza(zzaqdVar, e);
                zzaqdVar.zzr();
            } catch (Exception e2) {
                zzaqp.zzc(e2, "Unhandled exception %s", e2.toString());
                zzaqm zzaqmVar = new zzaqm(e2);
                SystemClock.elapsedRealtime();
                this.zze.zza(zzaqdVar, zzaqmVar);
                zzaqdVar.zzr();
            }
        } finally {
            zzaqdVar.zzt(4);
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                zzb();
            } catch (InterruptedException unused) {
                if (this.zzd) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzaqp.zzb("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    public final void zza() {
        this.zzd = true;
        interrupt();
    }
}
