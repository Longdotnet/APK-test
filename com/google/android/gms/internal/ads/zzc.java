package com.google.android.gms.internal.ads;

import android.media.AudioAttributes;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public final class zzc {
    public final AudioAttributes zza;

    public /* synthetic */ zzc(zze zzeVar, zzd zzdVar) {
        AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(0).setFlags(0).setUsage(1);
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            usage.setAllowedCapturePolicy(1);
        }
        if (i >= 32) {
            usage.setSpatializationBehavior(0);
        }
        this.zza = usage.build();
    }
}
