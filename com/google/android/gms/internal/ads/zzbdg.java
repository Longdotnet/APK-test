package com.google.android.gms.internal.ads;

import android.os.StrictMode;

/* JADX INFO: loaded from: classes.dex */
public final class zzbdg {
    public static Object zza(zzfwh zzfwhVar) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        try {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().permitDiskWrites().build());
            return zzfwhVar.zza();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }
}
