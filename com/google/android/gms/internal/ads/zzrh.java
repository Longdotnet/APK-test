package com.google.android.gms.internal.ads;

import android.media.AudioDeviceInfo;
import android.media.AudioRouting;
import android.media.AudioRouting$OnRoutingChangedListener;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
final class zzrh {
    private final AudioTrack zza;
    private final zzpo zzb;
    private AudioRouting$OnRoutingChangedListener zzc = new AudioRouting$OnRoutingChangedListener() { // from class: com.google.android.gms.internal.ads.zzrg
        public final void onRoutingChanged(AudioRouting audioRouting) {
            zzrh.zza(this.zza, audioRouting);
        }
    };

    public zzrh(AudioTrack audioTrack, zzpo zzpoVar) {
        this.zza = audioTrack;
        this.zzb = zzpoVar;
        audioTrack.addOnRoutingChangedListener(this.zzc, new Handler(Looper.myLooper()));
    }

    public static /* synthetic */ void zza(zzrh zzrhVar, AudioRouting audioRouting) {
        AudioDeviceInfo routedDevice;
        if (zzrhVar.zzc == null || (routedDevice = audioRouting.getRoutedDevice()) == null) {
            return;
        }
        zzrhVar.zzb.zzi(routedDevice);
    }

    public final void zzb() {
        AudioRouting$OnRoutingChangedListener audioRouting$OnRoutingChangedListener = this.zzc;
        audioRouting$OnRoutingChangedListener.getClass();
        this.zza.removeOnRoutingChangedListener(zzhn$$ExternalSyntheticApiModelOutline0.m(audioRouting$OnRoutingChangedListener));
        this.zzc = null;
    }
}
