package com.google.android.gms.internal.ads;

import androidx.loader.app.gv.DYYbQc;

/* JADX INFO: loaded from: classes2.dex */
public final class zzhgz {
    public static Object zza(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }

    public static Object zzb(Object obj) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }

    public static void zzc(Object obj, Class cls) {
        if (obj == null) {
            throw new IllegalStateException(String.valueOf(cls.getCanonicalName()).concat(DYYbQc.GEwr));
        }
    }
}
