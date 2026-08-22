package com.google.android.gms.common.logging;

import android.util.Log;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class Logger {
    public final String zza;
    public final String zzb;
    public final int zzd;

    public Logger(String str, String... strArr) {
        String string;
        int i = 2;
        if (strArr.length == 0) {
            string = "";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (String str2 : strArr) {
                if (sb.length() > 1) {
                    sb.append(",");
                }
                sb.append(str2);
            }
            sb.append("] ");
            string = sb.toString();
        }
        this.zzb = string;
        this.zza = str;
        Object[] objArr = {str, 23};
        if (!(str.length() <= 23)) {
            throw new IllegalArgumentException(String.format("tag \"%s\" is longer than the %d character maximum", objArr));
        }
        while (i <= 7 && !Log.isLoggable(this.zza, i)) {
            i++;
        }
        this.zzd = i;
    }

    public final void d(String str, Object... objArr) {
        if (this.zzd <= 3) {
            Log.d(this.zza, format(str, objArr));
        }
    }

    public final void e(String str, Exception exc, Object... objArr) {
        Log.e(this.zza, format(str, objArr), exc);
    }

    public final String format(String str, Object... objArr) {
        if (objArr.length > 0) {
            str = String.format(Locale.US, str, objArr);
        }
        return this.zzb.concat(str);
    }

    public final void v(String str, Object... objArr) {
        if (this.zzd <= 2) {
            Log.v(this.zza, format(str, objArr));
        }
    }

    public final void w(String str, Object... objArr) {
        Log.w(this.zza, format(str, objArr));
    }

    public final void e(String str, Object... objArr) {
        Log.e(this.zza, format(str, objArr));
    }
}
