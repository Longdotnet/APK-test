package androidx.work;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.dynamite.DynamiteModule$VersionPolicy$IVersions;

/* JADX INFO: loaded from: classes.dex */
public final class Logger$LogcatLogger implements DynamiteModule$VersionPolicy$IVersions {
    public static Logger$LogcatLogger sLogger;
    public int mLoggingLevel;

    public /* synthetic */ Logger$LogcatLogger(int i) {
        this.mLoggingLevel = i;
    }

    public static synchronized Logger$LogcatLogger get() {
        try {
            if (sLogger == null) {
                sLogger = new Logger$LogcatLogger(3);
            }
        } catch (Throwable th) {
            throw th;
        }
        return sLogger;
    }

    public static String tagWithPrefix(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(23);
        sb.append("WM-");
        if (length >= 20) {
            sb.append(str.substring(0, 20));
        } else {
            sb.append(str);
        }
        return sb.toString();
    }

    public void debug(String str, String str2, Throwable... thArr) {
        if (this.mLoggingLevel <= 3) {
            if (thArr.length >= 1) {
                Log.d(str, str2, thArr[0]);
            } else {
                Log.d(str, str2);
            }
        }
    }

    public void error(String str, String str2, Throwable... thArr) {
        if (this.mLoggingLevel <= 6) {
            if (thArr.length >= 1) {
                Log.e(str, str2, thArr[0]);
            } else {
                Log.e(str, str2);
            }
        }
    }

    public void info(String str, String str2, Throwable... thArr) {
        if (this.mLoggingLevel <= 4) {
            if (thArr.length >= 1) {
                Log.i(str, str2, thArr[0]);
            } else {
                Log.i(str, str2);
            }
        }
    }

    public void warning(String str, String str2, Throwable... thArr) {
        if (this.mLoggingLevel <= 5) {
            if (thArr.length >= 1) {
                Log.w(str, str2, thArr[0]);
            } else {
                Log.w(str, str2);
            }
        }
    }

    @Override // com.google.android.gms.dynamite.DynamiteModule$VersionPolicy$IVersions
    public int zza(Context context, String str) {
        return this.mLoggingLevel;
    }

    @Override // com.google.android.gms.dynamite.DynamiteModule$VersionPolicy$IVersions
    public int zzb(Context context, String str, boolean z) {
        return 0;
    }
}
