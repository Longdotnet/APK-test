package com.google.android.gms.internal.ads;

import android.media.MediaCodec;

/* JADX INFO: loaded from: classes.dex */
final class zzhn {
    private final MediaCodec.CryptoInfo zza;
    private final MediaCodec.CryptoInfo.Pattern zzb = zzhn$$ExternalSyntheticApiModelOutline0.m();

    public static /* bridge */ /* synthetic */ void zza(zzhn zzhnVar, int i, int i2) {
        MediaCodec.CryptoInfo.Pattern pattern = zzhnVar.zzb;
        pattern.set(i, i2);
        zzhnVar.zza.setPattern(pattern);
    }
}
