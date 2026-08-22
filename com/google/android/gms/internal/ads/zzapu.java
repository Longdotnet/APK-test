package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzapu {
    private final Executor zza;

    public zzapu(Handler handler) {
        this.zza = new zzaps(this, handler);
    }

    public final void zza(zzaqd zzaqdVar, zzaqm zzaqmVar) {
        zzaqdVar.zzm("post-error");
        ((zzaps) this.zza).zza.post(new zzapt(zzaqdVar, zzaqj.zza(zzaqmVar), null));
    }

    public final void zzb(zzaqd zzaqdVar, zzaqj zzaqjVar, Runnable runnable) {
        zzaqdVar.zzq();
        zzaqdVar.zzm("post-response");
        ((zzaps) this.zza).zza.post(new zzapt(zzaqdVar, zzaqjVar, runnable));
    }
}
