package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class zzdd {
    public static int zza(int i, int i2, int i3) {
        if (i < 0 || i >= i3) {
            throw new IndexOutOfBoundsException();
        }
        return i;
    }

    public static Object zzb(Object obj) {
        if (obj != null) {
            return obj;
        }
        throw new IllegalStateException();
    }

    public static String zzc(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException();
        }
        return str;
    }

    public static void zzd(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void zze(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException((String) obj);
        }
    }

    public static void zzf(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void zzg(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }
}
