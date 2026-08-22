package com.google.android.gms.common.internal;

/* JADX INFO: loaded from: classes.dex */
public final class GmsLogger {
    public final String zza;
    public final String zzb;

    public GmsLogger(String str, String str2) {
        Object[] objArr = {str, 23};
        if (!(str.length() <= 23)) {
            throw new IllegalArgumentException(String.format("tag \"%s\" is longer than the %d character maximum", objArr));
        }
        this.zza = str;
        this.zzb = (str2 == null || str2.length() <= 0) ? null : str2;
    }

    public final String zza(String str) {
        String str2 = this.zzb;
        return str2 == null ? str : str2.concat(str);
    }
}
