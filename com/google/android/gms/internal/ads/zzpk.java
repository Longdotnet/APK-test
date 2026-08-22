package com.google.android.gms.internal.ads;

import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzpk extends AudioDeviceCallback {
    final /* synthetic */ zzpo zza;

    public /* synthetic */ zzpk(zzpo zzpoVar, zzpn zzpnVar) {
        Objects.requireNonNull(zzpoVar);
        this.zza = zzpoVar;
    }

    @Override // android.media.AudioDeviceCallback
    public final void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
        zzpo zzpoVar = this.zza;
        zzpoVar.zzk(zzpj.zzc(zzpoVar.zza, zzpoVar.zzh, zzpoVar.zzg));
    }

    @Override // android.media.AudioDeviceCallback
    public final void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
        zzpo zzpoVar = this.zza;
        zzpp zzppVar = zzpoVar.zzg;
        String str = zzex.zza;
        for (AudioDeviceInfo audioDeviceInfo : audioDeviceInfoArr) {
            if (Objects.equals(audioDeviceInfo, zzppVar)) {
                zzpoVar.zzg = null;
                break;
            }
        }
        zzpoVar.zzk(zzpj.zzc(zzpoVar.zza, zzpoVar.zzh, zzpoVar.zzg));
    }
}
