package com.google.android.gms.internal.games_v2;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline0;

/* JADX INFO: loaded from: classes.dex */
final class zzgn {
    public static void zza(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("null key in entry: null=".concat(String.valueOf(obj2)));
        }
        if (obj2 != null) {
            return;
        }
        String string = obj.toString();
        throw new NullPointerException(Fragment$$ExternalSyntheticOutline0.m(new StringBuilder(string.length() + 26), "null value in entry: ", string, "=null"));
    }

    public static int zzb(int i, String str) {
        if (i >= 0) {
            return i;
        }
        StringBuilder sb = new StringBuilder(str.length() + 29 + String.valueOf(i).length());
        sb.append(str);
        sb.append(" cannot be negative but was: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }
}
