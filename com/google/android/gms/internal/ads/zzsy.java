package com.google.android.gms.internal.ads;

import android.media.LoudnessCodecController$OnLoudnessCodecUpdateListener;
import android.media.MediaCodec;
import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzsy implements LoudnessCodecController$OnLoudnessCodecUpdateListener {
    public zzsy(zztb zztbVar) {
        Objects.requireNonNull(zztbVar);
    }

    public final Bundle onLoudnessCodecUpdate(MediaCodec mediaCodec, Bundle bundle) {
        return bundle;
    }
}
