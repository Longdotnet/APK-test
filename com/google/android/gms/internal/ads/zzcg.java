package com.google.android.gms.internal.ads;

import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
final class zzcg implements AudioManager.OnAudioFocusChangeListener {
    private final Handler zza;
    private final AudioManager.OnAudioFocusChangeListener zzb;

    public zzcg(AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, Handler handler) {
        this.zzb = onAudioFocusChangeListener;
        Looper looper = handler.getLooper();
        String str = zzex.zza;
        this.zza = new Handler(looper, null);
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(final int i) {
        zzex.zzP(this.zza, new Runnable() { // from class: com.google.android.gms.internal.ads.zzcf
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzb.onAudioFocusChange(i);
            }
        });
    }
}
