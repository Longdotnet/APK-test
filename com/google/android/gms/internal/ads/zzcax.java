package com.google.android.gms.internal.ads;

import android.media.MediaPlayer;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzcax implements Runnable {
    final /* synthetic */ MediaPlayer zza;
    final /* synthetic */ zzcbf zzb;

    public zzcax(zzcbf zzcbfVar, MediaPlayer mediaPlayer) {
        this.zza = mediaPlayer;
        Objects.requireNonNull(zzcbfVar);
        this.zzb = zzcbfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcbf zzcbfVar = this.zzb;
        zzcbf.zzm(zzcbfVar, this.zza);
        if (zzcbfVar.zzr != null) {
            zzcbfVar.zzr.zzf();
        }
    }
}
