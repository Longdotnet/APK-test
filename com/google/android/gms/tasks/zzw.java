package com.google.android.gms.tasks;

import android.app.Activity;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.internal.zzah;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzw extends Task {
    public final Object zza = new Object();
    public final zzr zzb = new zzr();
    public boolean zzc;
    public volatile boolean zzd;
    public Object zze;
    public Exception zzf;

    @Override // com.google.android.gms.tasks.Task
    public final zzw addOnCompleteListener(Activity activity, OnCompleteListener onCompleteListener) {
        zzh zzhVar = new zzh(TaskExecutors.MAIN_THREAD, onCompleteListener);
        this.zzb.zza(zzhVar);
        zzv.zza(activity).zzb(zzhVar);
        zzi();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final zzw addOnFailureListener(OnFailureListener onFailureListener) {
        addOnFailureListener(TaskExecutors.MAIN_THREAD, onFailureListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final zzw addOnSuccessListener(Executor executor, OnSuccessListener onSuccessListener) {
        this.zzb.zza(new zzh(executor, onSuccessListener));
        zzi();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final zzw continueWith(Executor executor, Continuation continuation) {
        zzw zzwVar = new zzw();
        this.zzb.zza(new zzd(executor, continuation, zzwVar, 0));
        zzi();
        return zzwVar;
    }

    @Override // com.google.android.gms.tasks.Task
    public final zzw continueWithTask(Executor executor, Continuation continuation) {
        zzw zzwVar = new zzw();
        this.zzb.zza(new zzd(executor, continuation, zzwVar, 1));
        zzi();
        return zzwVar;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Exception getException() {
        Exception exc;
        synchronized (this.zza) {
            exc = this.zzf;
        }
        return exc;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Object getResult() {
        Object obj;
        synchronized (this.zza) {
            try {
                zzah.checkState(this.zzc, "Task is not yet complete");
                if (this.zzd) {
                    throw new CancellationException("Task is already canceled.");
                }
                Exception exc = this.zzf;
                if (exc != null) {
                    throw new RuntimeExecutionException(exc);
                }
                obj = this.zze;
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    public final Object getResult$1() {
        Object obj;
        synchronized (this.zza) {
            try {
                zzah.checkState(this.zzc, "Task is not yet complete");
                if (this.zzd) {
                    throw new CancellationException("Task is already canceled.");
                }
                if (ApiException.class.isInstance(this.zzf)) {
                    throw ((Throwable) ApiException.class.cast(this.zzf));
                }
                Exception exc = this.zzf;
                if (exc != null) {
                    throw new RuntimeExecutionException(exc);
                }
                obj = this.zze;
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    @Override // com.google.android.gms.tasks.Task
    public final boolean isComplete() {
        boolean z;
        synchronized (this.zza) {
            z = this.zzc;
        }
        return z;
    }

    @Override // com.google.android.gms.tasks.Task
    public final boolean isSuccessful() {
        boolean z;
        synchronized (this.zza) {
            try {
                z = false;
                if (this.zzc && !this.zzd && this.zzf == null) {
                    z = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public final void zza(Exception exc) {
        zzah.checkNotNull(exc, "Exception must not be null");
        synchronized (this.zza) {
            zzh();
            this.zzc = true;
            this.zzf = exc;
        }
        this.zzb.zzb((Task) this);
    }

    public final void zzb(Object obj) {
        synchronized (this.zza) {
            zzh();
            this.zzc = true;
            this.zze = obj;
        }
        this.zzb.zzb((Task) this);
    }

    public final void zzc() {
        synchronized (this.zza) {
            try {
                if (this.zzc) {
                    return;
                }
                this.zzc = true;
                this.zzd = true;
                this.zzb.zzb((Task) this);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzh() {
        String strConcat;
        if (this.zzc) {
            int i = DuplicateTaskCompletionException.$r8$clinit;
            if (!isComplete()) {
                throw new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
            }
            Exception exception = getException();
            if (exception != null) {
                strConcat = "failure";
            } else if (isSuccessful()) {
                strConcat = "result ".concat(String.valueOf(getResult()));
            } else {
                strConcat = this.zzd ? "cancellation" : "unknown issue";
            }
        }
    }

    public final void zzi() {
        synchronized (this.zza) {
            try {
                if (this.zzc) {
                    this.zzb.zzb((Task) this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.tasks.Task
    public final zzw addOnFailureListener(Executor executor, OnFailureListener onFailureListener) {
        this.zzb.zza(new zzh(executor, onFailureListener));
        zzi();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final zzw addOnCompleteListener(OnCompleteListener onCompleteListener) {
        this.zzb.zza(new zzh(TaskExecutors.MAIN_THREAD, onCompleteListener));
        zzi();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final zzw addOnCompleteListener(Executor executor, OnCompleteListener onCompleteListener) {
        this.zzb.zza(new zzh(executor, onCompleteListener));
        zzi();
        return this;
    }
}
