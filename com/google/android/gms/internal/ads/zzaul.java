package com.google.android.gms.internal.ads;

import android.util.Base64;

/* JADX INFO: loaded from: classes.dex */
public final class zzaul {
    public static String zza(byte[] bArr, boolean z) {
        return Base64.encodeToString(bArr, true != z ? 2 : 11);
    }

    public static byte[] zzb(String str, boolean z) {
        byte[] bArrDecode = Base64.decode(str, 2);
        if (bArrDecode.length != 0 || str.length() <= 0) {
            return bArrDecode;
        }
        throw new IllegalArgumentException("Unable to decode ".concat(str));
    }
}
