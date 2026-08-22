package com.google.android.gms.internal.ads;

import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzch {
    private final AudioManager.OnAudioFocusChangeListener zzb;
    private final Handler zzc;
    private final zze zzd;
    private final Object zzf;
    private final int zza = 1;
    private final boolean zze = false;

    public zzch(int i, AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, Handler handler, zze zzeVar, boolean z) {
        this.zzc = handler;
        this.zzd = zzeVar;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 26) {
            this.zzb = new zzcg(onAudioFocusChangeListener, handler);
        } else {
            this.zzb = onAudioFocusChangeListener;
        }
        this.zzf = i2 >= 26 ? zzch$$ExternalSyntheticApiModelOutline0.m().setAudioAttributes(zzeVar.zza().zza).setWillPauseWhenDucked(false).setOnAudioFocusChangeListener(onAudioFocusChangeListener, handler).build() : null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzch)) {
            return false;
        }
        zzch zzchVar = (zzch) obj;
        int i = zzchVar.zza;
        return Objects.equals(this.zzb, zzchVar.zzb) && Objects.equals(this.zzc, zzchVar.zzc) && Objects.equals(this.zzd, zzchVar.zzd);
    }

    public final int hashCode() {
        return Objects.hash(1, this.zzb, this.zzc, this.zzd, Boolean.FALSE);
    }

    public final AudioFocusRequest zza() {
        Object obj = this.zzf;
        obj.getClass();
        return zzch$$ExternalSyntheticApiModelOutline0.m(obj);
    }

    public final AudioManager.OnAudioFocusChangeListener zzb() {
        return this.zzb;
    }

    public final zze zzc() {
        return this.zzd;
    }
}
