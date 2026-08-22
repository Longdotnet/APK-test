package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.logging.Logger;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
final class zzx {
    private static final Logger zza = Logger.getLogger(zzx.class.getName());
    private static final zzw zzb = new zzw(null);

    private zzx() {
    }

    public static zzq zza(String str) {
        return new zzt(Pattern.compile("[.-]"));
    }

    public static String zzb(String str) {
        return str == null ? "" : str;
    }

    public static boolean zzc(String str) {
        return str == null || str.isEmpty();
    }
}
