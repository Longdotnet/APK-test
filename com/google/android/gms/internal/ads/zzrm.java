package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.media.AudioTrack$StreamEventCallback;
import android.os.Handler;
import android.os.Looper;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class zzrm {
    final /* synthetic */ zzro zza;
    private final Handler zzb;
    private final AudioTrack$StreamEventCallback zzc;

    public zzrm(zzro zzroVar) {
        Objects.requireNonNull(zzroVar);
        this.zza = zzroVar;
        this.zzb = new Handler(Looper.myLooper());
        this.zzc = new zzrl(this);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.google.android.gms.internal.ads.zzrk] */
    public final void zza(AudioTrack audioTrack) {
        final Handler handler = this.zzb;
        Objects.requireNonNull(handler);
        audioTrack.registerStreamEventCallback(new Executor() { // from class: com.google.android.gms.internal.ads.zzrk
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                handler.post(runnable);
            }
        }, this.zzc);
    }

    public final void zzb(AudioTrack audioTrack) {
        audioTrack.unregisterStreamEventCallback(this.zzc);
        this.zzb.removeCallbacksAndMessages(null);
    }
}
