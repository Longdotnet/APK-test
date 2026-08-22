package com.google.android.gms.internal.ads;

import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public final class zzaq {
    private static final HashSet zza = new HashSet();
    private static String zzb = "media3.common";

    public static synchronized String zza() {
        return zzb;
    }

    public static synchronized void zzb(String str) {
        if (zza.add(str)) {
            zzb = zzb + ", " + str;
        }
    }
}
