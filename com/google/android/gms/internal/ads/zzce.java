package com.google.android.gms.internal.ads;

import android.media.AudioManager;
import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public final class zzce {
    private AudioManager.OnAudioFocusChangeListener zza;
    private Handler zzb;
    private zze zzc = zze.zza;

    public zzce(int i) {
    }

    public final zzce zza(zze zzeVar) {
        this.zzc = zzeVar;
        return this;
    }

    public final zzce zzb(AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, Handler handler) {
        this.zza = onAudioFocusChangeListener;
        this.zzb = handler;
        return this;
    }

    public final zzch zzc() {
        AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = this.zza;
        if (onAudioFocusChangeListener == null) {
            throw new IllegalStateException("Can't build an AudioFocusRequestCompat instance without a listener");
        }
        Handler handler = this.zzb;
        handler.getClass();
        return new zzch(1, onAudioFocusChangeListener, handler, this.zzc, false);
    }
}
