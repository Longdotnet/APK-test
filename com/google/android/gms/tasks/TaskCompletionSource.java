package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.zzah;

/* JADX INFO: loaded from: classes.dex */
public final class TaskCompletionSource {
    public final zzw zza = new zzw();

    public final void setException(Exception exc) {
        this.zza.zza(exc);
    }

    public final void setResult(Object obj) {
        this.zza.zzb(obj);
    }

    public final boolean trySetException(Exception exc) {
        zzw zzwVar = this.zza;
        zzwVar.getClass();
        zzah.checkNotNull(exc, "Exception must not be null");
        synchronized (zzwVar.zza) {
            try {
                if (zzwVar.zzc) {
                    return false;
                }
                zzwVar.zzc = true;
                zzwVar.zzf = exc;
                zzwVar.zzb.zzb((Task) zzwVar);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean trySetResult(Object obj) {
        zzw zzwVar = this.zza;
        synchronized (zzwVar.zza) {
            try {
                if (zzwVar.zzc) {
                    return false;
                }
                zzwVar.zzc = true;
                zzwVar.zze = obj;
                zzwVar.zzb.zzb((Task) zzwVar);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
