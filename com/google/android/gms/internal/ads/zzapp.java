package com.google.android.gms.internal.ads;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: loaded from: classes.dex */
public final class zzapp extends Thread {
    private static final boolean zza = zzaqp.zzb;
    private final BlockingQueue zzb;
    private final BlockingQueue zzc;
    private final zzapn zzd;
    private volatile boolean zze = false;
    private final zzaqq zzf;
    private final zzapu zzg;

    public zzapp(BlockingQueue blockingQueue, BlockingQueue blockingQueue2, zzapn zzapnVar, zzapu zzapuVar) {
        this.zzb = blockingQueue;
        this.zzc = blockingQueue2;
        this.zzd = zzapnVar;
        this.zzg = zzapuVar;
        this.zzf = new zzaqq(this, blockingQueue2, zzapuVar);
    }

    private void zzc() {
        zzaqd zzaqdVar = (zzaqd) this.zzb.take();
        zzaqdVar.zzm("cache-queue-take");
        zzaqdVar.zzt(1);
        try {
            zzaqdVar.zzw();
            zzapn zzapnVar = this.zzd;
            zzapm zzapmVarZza = zzapnVar.zza(zzaqdVar.zzj());
            if (zzapmVarZza == null) {
                zzaqdVar.zzm("cache-miss");
                if (!this.zzf.zzc(zzaqdVar)) {
                    this.zzc.put(zzaqdVar);
                }
            } else {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (zzapmVarZza.zza(jCurrentTimeMillis)) {
                    zzaqdVar.zzm("cache-hit-expired");
                    zzaqdVar.zze(zzapmVarZza);
                    if (!this.zzf.zzc(zzaqdVar)) {
                        this.zzc.put(zzaqdVar);
                    }
                } else {
                    zzaqdVar.zzm("cache-hit");
                    zzaqj zzaqjVarZzh = zzaqdVar.zzh(new zzapz(zzapmVarZza.zza, zzapmVarZza.zzg));
                    zzaqdVar.zzm("cache-hit-parsed");
                    if (!zzaqjVarZzh.zzc()) {
                        zzaqdVar.zzm("cache-parsing-failed");
                        zzapnVar.zzc(zzaqdVar.zzj(), true);
                        zzaqdVar.zze(null);
                        if (!this.zzf.zzc(zzaqdVar)) {
                            this.zzc.put(zzaqdVar);
                        }
                    } else if (zzapmVarZza.zzf < jCurrentTimeMillis) {
                        zzaqdVar.zzm("cache-hit-refresh-needed");
                        zzaqdVar.zze(zzapmVarZza);
                        zzaqjVarZzh.zzd = true;
                        if (this.zzf.zzc(zzaqdVar)) {
                            this.zzg.zzb(zzaqdVar, zzaqjVarZzh, null);
                        } else {
                            this.zzg.zzb(zzaqdVar, zzaqjVarZzh, new zzapo(this, zzaqdVar));
                        }
                    } else {
                        this.zzg.zzb(zzaqdVar, zzaqjVarZzh, null);
                    }
                }
            }
        } finally {
            zzaqdVar.zzt(2);
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        if (zza) {
            zzaqp.zzd("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.zzd.zzb();
        while (true) {
            try {
                zzc();
            } catch (InterruptedException unused) {
                if (this.zze) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzaqp.zzb("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    public final void zzb() {
        this.zze = true;
        interrupt();
    }
}
