package com.google.android.gms.measurement.internal;

import androidx.lifecycle.hSi.sgtsHsWT;
import com.google.android.gms.appset.vSSa.iafHZUfOuHNwvy;
import com.google.android.gms.games.event.AfJ.oKjScaD;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class zzfo extends zzgl {
    public static final AtomicLong zza = new AtomicLong(Long.MIN_VALUE);
    public zzfn zzb;
    public zzfn zzc;
    public final PriorityBlockingQueue zzd;
    public final LinkedBlockingQueue zze;
    public final zzfl zzf;
    public final zzfl zzg;
    public final Object zzh;
    public final Semaphore zzi;

    public zzfo(zzfr zzfrVar) {
        super(zzfrVar);
        this.zzh = new Object();
        this.zzi = new Semaphore(2);
        this.zzd = new PriorityBlockingQueue();
        this.zze = new LinkedBlockingQueue();
        this.zzf = new zzfl(this, "Thread death: Uncaught exception on worker thread");
        this.zzg = new zzfl(this, "Thread death: Uncaught exception on network thread");
    }

    public final void zzax() {
        if (Thread.currentThread() != this.zzc) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    public final boolean zzf() {
        return false;
    }

    public final zzfm zzh(Callable callable) {
        zzu();
        zzfm zzfmVar = new zzfm(this, callable, false);
        if (Thread.currentThread() == this.zzb) {
            if (!this.zzd.isEmpty()) {
                zzeh zzehVar = ((zzfr) this.mBuilder).zzm;
                zzfr.zzR(zzehVar);
                zzehVar.zzg.zza("Callable skipped the worker queue.");
            }
            zzfmVar.run();
        } else {
            zzt(zzfmVar);
        }
        return zzfmVar;
    }

    public final void zzo(Runnable runnable) {
        zzu();
        zzfm zzfmVar = new zzfm(this, runnable, false, "Task exception on network thread");
        synchronized (this.zzh) {
            try {
                this.zze.add(zzfmVar);
                zzfn zzfnVar = this.zzc;
                if (zzfnVar == null) {
                    zzfn zzfnVar2 = new zzfn(this, "Measurement Network", this.zze);
                    this.zzc = zzfnVar2;
                    zzfnVar2.setUncaughtExceptionHandler(this.zzg);
                    this.zzc.start();
                } else {
                    zzfnVar.zza();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzp(Runnable runnable) {
        zzu();
        zzt(new zzfm(this, runnable, false, "Task exception on worker thread"));
    }

    public final void zzq(Runnable runnable) {
        zzu();
        zzt(new zzfm(this, runnable, true, "Task exception on worker thread"));
    }

    public final boolean zzs() {
        return Thread.currentThread() == this.zzb;
    }

    public final Object zzd(AtomicReference atomicReference, long j, String str, Runnable runnable) {
        String str2 = iafHZUfOuHNwvy.onBtQXG;
        synchronized (atomicReference) {
            zzfo zzfoVar = ((zzfr) this.mBuilder).zzn;
            zzfr.zzR(zzfoVar);
            zzfoVar.zzp(runnable);
            try {
                atomicReference.wait(j);
            } catch (InterruptedException unused) {
                zzeh zzehVar = ((zzfr) this.mBuilder).zzm;
                zzfr.zzR(zzehVar);
                zzehVar.zzg.zza(str2.concat(str));
                return null;
            }
        }
        Object obj = atomicReference.get();
        if (obj == null) {
            zzeh zzehVar2 = ((zzfr) this.mBuilder).zzm;
            zzfr.zzR(zzehVar2);
            zzehVar2.zzg.zza("Timed out waiting for ".concat(str));
        }
        return obj;
    }

    public final void zzt(zzfm zzfmVar) {
        synchronized (this.zzh) {
            try {
                this.zzd.add(zzfmVar);
                zzfn zzfnVar = this.zzb;
                if (zzfnVar == null) {
                    zzfn zzfnVar2 = new zzfn(this, sgtsHsWT.PoZJmZmUQMyIWf, this.zzd);
                    this.zzb = zzfnVar2;
                    zzfnVar2.setUncaughtExceptionHandler(this.zzf);
                    this.zzb.start();
                } else {
                    zzfnVar.zza();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.core.app.NotificationCompat$Style
    public final void zzg() {
        if (Thread.currentThread() == this.zzb) {
        } else {
            throw new IllegalStateException(oKjScaD.BGP);
        }
    }
}
