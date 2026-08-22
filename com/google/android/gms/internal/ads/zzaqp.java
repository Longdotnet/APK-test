package com.google.android.gms.internal.ads;

import android.util.Log;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.games.event.AfJ.oKjScaD;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class zzaqp {
    public static final String zza = "Volley";
    public static final boolean zzb = Log.isLoggable("Volley", 2);
    private static final String zzc = zzaqp.class.getName();

    public static void zza(String str, Object... objArr) {
        Log.d(zza, zze(str, objArr));
    }

    public static void zzb(String str, Object... objArr) {
        Log.e(zza, zze(str, objArr));
    }

    public static void zzc(Throwable th, String str, Object... objArr) {
        Log.e(zza, zze(str, objArr), th);
    }

    public static void zzd(String str, Object... objArr) {
        if (zzb) {
            Log.v(zza, zze(str, objArr));
        }
    }

    private static String zze(String str, Object... objArr) {
        String strM;
        String str2 = String.format(Locale.US, str, objArr);
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        for (int i = 2; i < stackTrace.length; i++) {
            if (!stackTrace[i].getClassName().equals(zzc)) {
                String className = stackTrace[i].getClassName();
                String strSubstring = className.substring(className.lastIndexOf(46) + 1);
                strM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(strSubstring.substring(strSubstring.lastIndexOf(36) + 1), ".", stackTrace[i].getMethodName());
                Locale locale = Locale.US;
                long id = Thread.currentThread().getId();
                StringBuilder sb = new StringBuilder("[");
                sb.append(id);
                sb.append("] ");
                sb.append(strM);
                return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(sb, oKjScaD.iVvZrQEIdWgV, str2);
            }
        }
        strM = "<unknown>";
        Locale locale2 = Locale.US;
        long id2 = Thread.currentThread().getId();
        StringBuilder sb2 = new StringBuilder("[");
        sb2.append(id2);
        sb2.append("] ");
        sb2.append(strM);
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(sb2, oKjScaD.iVvZrQEIdWgV, str2);
    }
}
