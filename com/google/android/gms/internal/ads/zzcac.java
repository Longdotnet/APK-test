package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.util.Hex;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class zzcac implements Executor {
    private final Handler zza = new com.google.android.gms.ads.internal.util.zzf(Looper.getMainLooper());

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            this.zza.post(runnable);
            return;
        }
        try {
            runnable.run();
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
            Context contextZzd = com.google.android.gms.ads.internal.zzv.zza.zzi.zzd();
            if (contextZzd != null) {
                try {
                    if (((Boolean) zzbfn.zzb.zze()).booleanValue()) {
                        Hex.addDynamiteErrorToDropBox(contextZzd, th);
                    }
                } catch (IllegalStateException unused) {
                }
            }
            throw th;
        }
    }
}
