package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class zzfni {
    public static void zza() {
        if (!zzflj.zzb()) {
            throw new IllegalStateException("Method called before OM SDK activation");
        }
    }

    public static void zzb(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static void zzc(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void zzd(String str, int i, String str2) {
        if (str.length() > 256) {
            throw new IllegalArgumentException("CustomReferenceData is greater than 256 characters");
        }
    }
}
