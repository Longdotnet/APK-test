package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
final class zztk {
    private static Boolean zza;

    public static int zza(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        if (Build.VERSION.SDK_INT < 29) {
            return 0;
        }
        Boolean bool = zza;
        if (bool == null || !bool.booleanValue()) {
            return zztj.zza(videoCapabilities, i, i2, d);
        }
        return 0;
    }
}
