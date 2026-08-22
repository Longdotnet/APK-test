package com.google.android.gms.measurement.internal;

import android.os.Process;
import java.util.AbstractQueue;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: loaded from: classes.dex */
public final class zzfn extends Thread {
    public final /* synthetic */ zzfo zza;
    public final Object zzb;
    public final AbstractQueue zzc;
    public boolean zzd = false;

    /* JADX WARN: Multi-variable type inference failed */
    public zzfn(zzfo zzfoVar, String str, BlockingQueue blockingQueue) {
        this.zza = zzfoVar;
        com.google.android.gms.common.internal.zzah.checkNotNull(blockingQueue);
        this.zzb = new Object();
        this.zzc = (AbstractQueue) blockingQueue;
        setName(str);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        boolean z = false;
        while (!z) {
            try {
                this.zza.zzi.acquire();
                z = true;
            } catch (InterruptedException e) {
                zzeh zzehVar = ((zzfr) this.zza.mBuilder).zzm;
                zzfr.zzR(zzehVar);
                zzehVar.zzg.zzb(e, String.valueOf(getName()).concat(" was interrupted"));
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                zzfm zzfmVar = (zzfm) this.zzc.poll();
                if (zzfmVar != null) {
                    Process.setThreadPriority(true != zzfmVar.zza ? 10 : threadPriority);
                    zzfmVar.run();
                } else {
                    synchronized (this.zzb) {
                        if (this.zzc.peek() == null) {
                            this.zza.getClass();
                            try {
                                this.zzb.wait(30000L);
                            } catch (InterruptedException e2) {
                                zzeh zzehVar2 = ((zzfr) this.zza.mBuilder).zzm;
                                zzfr.zzR(zzehVar2);
                                zzehVar2.zzg.zzb(e2, String.valueOf(getName()).concat(" was interrupted"));
                            }
                        }
                    }
                    synchronized (this.zza.zzh) {
                        if (this.zzc.peek() == null) {
                            zzb();
                            zzb();
                            return;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            zzb();
            throw th;
        }
    }

    public final void zza() {
        synchronized (this.zzb) {
            this.zzb.notifyAll();
        }
    }

    public final void zzb() {
        synchronized (this.zza.zzh) {
            try {
                if (!this.zzd) {
                    this.zza.zzi.release();
                    this.zza.zzh.notifyAll();
                    zzfo zzfoVar = this.zza;
                    if (this == zzfoVar.zzb) {
                        zzfoVar.zzb = null;
                    } else if (this == zzfoVar.zzc) {
                        zzfoVar.zzc = null;
                    } else {
                        zzeh zzehVar = ((zzfr) zzfoVar.mBuilder).zzm;
                        zzfr.zzR(zzehVar);
                        zzehVar.zzd.zza("Current scheduler thread is neither worker nor network");
                    }
                    this.zzd = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
