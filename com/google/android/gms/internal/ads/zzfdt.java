package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;

/* JADX INFO: loaded from: classes.dex */
public final class zzfdt {
    public static void zza(Context context, boolean z) {
        if (z) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("This request is sent from a test device.");
        } else {
            com.google.android.gms.ads.internal.util.client.zzf zzfVar = com.google.android.gms.ads.internal.client.zzbb.zzb.zzc;
            String strM$1 = CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Use RequestConfiguration.Builder().setTestDeviceIds(Arrays.asList(\"", com.google.android.gms.ads.internal.util.client.zzf.zzD(context), "\")) to get test ads on this device.");
            int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzi(strM$1);
        }
    }

    public static void zzb(int i, Throwable th, String str) {
        String strM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, "Ad failed to load : ");
        int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
        com.google.android.gms.ads.internal.util.client.zzo.zzi(strM);
        com.google.android.gms.ads.internal.util.zze.zzb(str, th);
        if (i == 3) {
            return;
        }
        com.google.android.gms.ads.internal.zzv.zza.zzi.zzv(th, str);
    }
}
