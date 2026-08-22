package com.google.android.gms.internal.games_v2;

/* JADX INFO: loaded from: classes.dex */
public final class zzhs {
    public static Object[] zza(Object[] objArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            zzb(objArr[i2], i2);
        }
        return objArr;
    }

    public static Object zzb(Object obj, int i) {
        if (obj != null) {
            return obj;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 9);
        sb.append("at index ");
        sb.append(i);
        throw new NullPointerException(sb.toString());
    }
}
