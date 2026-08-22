package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes.dex */
final class zzflu extends TimerTask {
    final /* synthetic */ Timer zza;
    final /* synthetic */ zzflw zzb;
    final /* synthetic */ zzcfx zzc;

    public zzflu(zzflw zzflwVar, zzcfx zzcfxVar, Timer timer) {
        this.zzc = zzcfxVar;
        this.zza = timer;
        Objects.requireNonNull(zzflwVar);
        this.zzb = zzflwVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        this.zzb.zzh();
        zzcfy.zzaI(this.zzc.zza, true);
        this.zza.cancel();
    }
}
