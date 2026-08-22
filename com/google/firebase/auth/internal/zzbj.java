package com.google.firebase.auth.internal;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbj implements Executor {
    public static final zzbj zza = new zzbj();
    public final Handler zzb = new com.google.android.gms.internal.p002firebaseauthapi.zzg(Looper.getMainLooper());

    public static zzbj zza() {
        return zza;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.zzb.post(runnable);
    }
}
