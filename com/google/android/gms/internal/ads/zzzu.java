package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.os.Trace;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzzu extends Handler implements Runnable {
    final /* synthetic */ zzaaa zza;
    private final zzzv zzb;
    private final long zzc;
    private zzzs zzd;
    private IOException zze;
    private int zzf;
    private Thread zzg;
    private boolean zzh;
    private volatile boolean zzi;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzzu(zzaaa zzaaaVar, Looper looper, zzzv zzzvVar, zzzs zzzsVar, int i, long j) {
        super(looper);
        Objects.requireNonNull(zzaaaVar);
        this.zza = zzaaaVar;
        this.zzb = zzzvVar;
        this.zzd = zzzsVar;
        this.zzc = j;
    }

    private final void zzd() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = jElapsedRealtime - this.zzc;
        zzzs zzzsVar = this.zzd;
        zzzsVar.getClass();
        zzzsVar.zzL(this.zzb, jElapsedRealtime, j, this.zzf);
        this.zze = null;
        zzaaa zzaaaVar = this.zza;
        zzaai zzaaiVar = zzaaaVar.zzc;
        zzzu zzzuVar = zzaaaVar.zzd;
        zzzuVar.getClass();
        zzaaiVar.execute(zzzuVar);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (this.zzi) {
            return;
        }
        int i = message.what;
        if (i == 1) {
            zzd();
            return;
        }
        if (i == 4) {
            throw ((Error) message.obj);
        }
        zzaaa zzaaaVar = this.zza;
        zzaaaVar.zzd = null;
        long j = this.zzc;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j2 = jElapsedRealtime - j;
        zzzs zzzsVar = this.zzd;
        zzzsVar.getClass();
        if (this.zzh) {
            zzzsVar.zzJ(this.zzb, jElapsedRealtime, j2, false);
            return;
        }
        int i2 = message.what;
        if (i2 == 2) {
            try {
                zzzsVar.zzK(this.zzb, jElapsedRealtime, j2);
                return;
            } catch (RuntimeException e) {
                zzea.zzd("LoadTask", "Unexpected exception handling load completed", e);
                this.zza.zze = new zzzy(e);
                return;
            }
        }
        if (i2 != 3) {
            return;
        }
        IOException iOException = (IOException) message.obj;
        this.zze = iOException;
        int i3 = this.zzf + 1;
        this.zzf = i3;
        zzzt zzztVarZzu = zzzsVar.zzu(this.zzb, jElapsedRealtime, j2, iOException, i3);
        if (zzztVarZzu.zza == 3) {
            zzaaaVar.zze = this.zze;
        } else if (zzztVarZzu.zza != 2) {
            if (zzztVarZzu.zza == 1) {
                this.zzf = 1;
            }
            zzc(zzztVarZzu.zzb != -9223372036854775807L ? zzztVarZzu.zzb : Math.min((this.zzf - 1) * 1000, 5000));
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        try {
            synchronized (this) {
                z = this.zzh;
                this.zzg = Thread.currentThread();
            }
            if (!z) {
                zzzv zzzvVar = this.zzb;
                Trace.beginSection("load:".concat(zzzvVar.getClass().getSimpleName()));
                try {
                    zzzvVar.zzh();
                    Trace.endSection();
                } catch (Throwable th) {
                    Trace.endSection();
                    throw th;
                }
            }
            synchronized (this) {
                this.zzg = null;
                Thread.interrupted();
            }
            if (this.zzi) {
                return;
            }
            sendEmptyMessage(2);
        } catch (IOException e) {
            if (this.zzi) {
                return;
            }
            obtainMessage(3, e).sendToTarget();
        } catch (Exception e2) {
            if (this.zzi) {
                return;
            }
            zzea.zzd("LoadTask", "Unexpected exception loading stream", e2);
            obtainMessage(3, new zzzy(e2)).sendToTarget();
        } catch (OutOfMemoryError e3) {
            if (this.zzi) {
                return;
            }
            zzea.zzd("LoadTask", "OutOfMemory error loading stream", e3);
            obtainMessage(3, new zzzy(e3)).sendToTarget();
        } catch (Error e4) {
            if (!this.zzi) {
                zzea.zzd("LoadTask", "Unexpected error loading stream", e4);
                obtainMessage(4, e4).sendToTarget();
            }
            throw e4;
        }
    }

    public final void zza(boolean z) {
        this.zzi = z;
        this.zze = null;
        if (hasMessages(1)) {
            this.zzh = true;
            removeMessages(1);
            if (!z) {
                sendEmptyMessage(2);
            }
        } else {
            synchronized (this) {
                try {
                    this.zzh = true;
                    this.zzb.zzg();
                    Thread thread = this.zzg;
                    if (thread != null) {
                        thread.interrupt();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (z) {
            this.zza.zzd = null;
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            zzzs zzzsVar = this.zzd;
            zzzsVar.getClass();
            zzzsVar.zzJ(this.zzb, jElapsedRealtime, jElapsedRealtime - this.zzc, true);
            this.zzd = null;
        }
    }

    public final void zzb(int i) {
        IOException iOException = this.zze;
        if (iOException != null && this.zzf > i) {
            throw iOException;
        }
    }

    public final void zzc(long j) {
        zzaaa zzaaaVar = this.zza;
        zzdd.zzf(zzaaaVar.zzd == null);
        zzaaaVar.zzd = this;
        if (j > 0) {
            sendEmptyMessageDelayed(1, j);
        } else {
            zzd();
        }
    }
}
