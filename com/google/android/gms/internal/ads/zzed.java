package com.google.android.gms.internal.ads;

import android.media.MediaFormat;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzed {
    public static void zza(MediaFormat mediaFormat, String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }

    public static void zzb(MediaFormat mediaFormat, List list) {
        for (int i = 0; i < list.size(); i++) {
            mediaFormat.setByteBuffer(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, "csd-"), ByteBuffer.wrap((byte[]) list.get(i)));
        }
    }
}
