package com.google.android.gms.internal.ads;

import com.google.android.gms.measurement.internal.RVw.ZRqOdXiy;
import okhttp3.internal.concurrent.onZL.mnwSv;

/* JADX INFO: loaded from: classes2.dex */
public final class zzboh extends zzcar {
    private final com.google.android.gms.ads.internal.util.zzbd zzb;
    private final Object zza = new Object();
    private boolean zzc = false;
    private int zzd = 0;

    public zzboh(com.google.android.gms.ads.internal.util.zzbd zzbdVar) {
        this.zzb = zzbdVar;
    }

    public final void zzc() {
        com.google.android.gms.ads.internal.util.zze.zza("maybeDestroy: Trying to acquire lock");
        synchronized (this.zza) {
            try {
                com.google.android.gms.ads.internal.util.zze.zza("maybeDestroy: Lock acquired");
                com.google.android.gms.common.internal.zzah.checkState$1(this.zzd >= 0);
                if (this.zzc && this.zzd == 0) {
                    com.google.android.gms.ads.internal.util.zze.zza("No reference is left (including root). Cleaning up engine.");
                    zzj(new zzbog(this), new zzcan());
                } else {
                    com.google.android.gms.ads.internal.util.zze.zza("There are still references to the engine. Not destroying.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        com.google.android.gms.ads.internal.util.zze.zza("maybeDestroy: Lock released");
    }

    public final void zzd() {
        com.google.android.gms.ads.internal.util.zze.zza("releaseOneReference: Trying to acquire lock");
        synchronized (this.zza) {
            com.google.android.gms.ads.internal.util.zze.zza("releaseOneReference: Lock acquired");
            com.google.android.gms.common.internal.zzah.checkState$1(this.zzd > 0);
            com.google.android.gms.ads.internal.util.zze.zza("Releasing 1 reference for JS Engine");
            this.zzd--;
            zzc();
        }
        com.google.android.gms.ads.internal.util.zze.zza("releaseOneReference: Lock released");
    }

    public final zzboc zza() {
        zzboc zzbocVar = new zzboc(this);
        com.google.android.gms.ads.internal.util.zze.zza(mnwSv.zJgQNmAB);
        synchronized (this.zza) {
            com.google.android.gms.ads.internal.util.zze.zza("createNewReference: Lock acquired");
            zzj(new zzbod(this, zzbocVar), new zzboe(this, zzbocVar));
            com.google.android.gms.common.internal.zzah.checkState$1(this.zzd >= 0);
            this.zzd++;
        }
        com.google.android.gms.ads.internal.util.zze.zza("createNewReference: Lock released");
        return zzbocVar;
    }

    public final void zzb() {
        com.google.android.gms.ads.internal.util.zze.zza(ZRqOdXiy.gPahBWtieSHuB);
        synchronized (this.zza) {
            com.google.android.gms.ads.internal.util.zze.zza("markAsDestroyable: Lock acquired");
            com.google.android.gms.common.internal.zzah.checkState$1(this.zzd >= 0);
            com.google.android.gms.ads.internal.util.zze.zza("Releasing root reference. JS Engine will be destroyed once other references are released.");
            this.zzc = true;
            zzc();
        }
        com.google.android.gms.ads.internal.util.zze.zza("markAsDestroyable: Lock released");
    }
}
