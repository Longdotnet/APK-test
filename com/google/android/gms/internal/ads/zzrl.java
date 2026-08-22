package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.media.AudioTrack$StreamEventCallback;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzrl extends AudioTrack$StreamEventCallback {
    final /* synthetic */ zzrm zza;

    public zzrl(zzrm zzrmVar) {
        Objects.requireNonNull(zzrmVar);
        this.zza = zzrmVar;
    }

    public final void onDataRequest(AudioTrack audioTrack, int i) {
        zzro zzroVar = this.zza.zza;
        if (audioTrack.equals(zzroVar.zzu) && zzroVar.zzq != null && zzroVar.zzS) {
            zzroVar.zzq.zzb();
        }
    }

    public final void onPresentationEnded(AudioTrack audioTrack) {
        zzro zzroVar = this.zza.zza;
        if (audioTrack.equals(zzroVar.zzu)) {
            zzroVar.zzR = true;
        }
    }

    public final void onTearDown(AudioTrack audioTrack) {
        zzro zzroVar = this.zza.zza;
        if (audioTrack.equals(zzroVar.zzu) && zzroVar.zzq != null && zzroVar.zzS) {
            zzroVar.zzq.zzb();
        }
    }
}
