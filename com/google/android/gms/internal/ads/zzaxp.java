package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes.dex */
public final class zzaxp implements Callable {
    private final zzawx zza;
    private final zzast zzb;

    public zzaxp(zzawx zzawxVar, zzast zzastVar) {
        this.zza = zzawxVar;
        this.zzb = zzastVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws ExecutionException, InterruptedException {
        zzawx zzawxVar = this.zza;
        if (zzawxVar.zzk() != null) {
            zzawxVar.zzk().get();
        }
        zzatq zzatqVarZzc = zzawxVar.zzc();
        if (zzatqVarZzc == null) {
            return null;
        }
        try {
            zzast zzastVar = this.zzb;
            synchronized (zzastVar) {
                try {
                    zzastVar.zzaY(zzatqVarZzc.zzaV(), zzgyr.zza());
                } catch (Throwable th) {
                    throw th;
                }
            }
            return null;
        } catch (zzgzw | NullPointerException unused) {
            return null;
        }
    }
}
