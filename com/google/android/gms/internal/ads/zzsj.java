package com.google.android.gms.internal.ads;

import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public final class zzsj {
    public static final boolean zza;

    static {
        boolean z = false;
        if ("Amazon".equals(Build.MANUFACTURER)) {
            String str = Build.MODEL;
            if ("AFTM".equals(str) || "AFTB".equals(str)) {
                z = true;
            }
        }
        zza = z;
    }
}
