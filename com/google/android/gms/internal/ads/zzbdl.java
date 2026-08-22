package com.google.android.gms.internal.ads;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class zzbdl {
    public static boolean zza(zzbdt zzbdtVar, zzbdq zzbdqVar, String... strArr) {
        if (zzbdqVar == null) {
            return false;
        }
        com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
        zzbdtVar.zze(zzbdqVar, SystemClock.elapsedRealtime(), strArr);
        return true;
    }
}
