package com.google.android.gms.internal.auth;

import android.net.Uri;
import androidx.collection.ArrayMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzcq {
    private static final ArrayMap zza = new ArrayMap();

    public static synchronized Uri zza(String str) {
        Uri uri;
        try {
            ArrayMap arrayMap = zza;
            uri = (Uri) arrayMap.getOrDefault("com.google.android.gms.auth_account", null);
            if (uri == null) {
                String strValueOf = String.valueOf(Uri.encode("com.google.android.gms.auth_account"));
                uri = Uri.parse(strValueOf.length() != 0 ? "content://com.google.android.gms.phenotype/".concat(strValueOf) : new String("content://com.google.android.gms.phenotype/"));
                arrayMap.put("com.google.android.gms.auth_account", uri);
            }
        } catch (Throwable th) {
            throw th;
        }
        return uri;
    }
}
