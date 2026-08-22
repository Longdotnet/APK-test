package androidx.core.app;

import android.app.AppOpsManager;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public abstract class AppOpsManagerCompat$Api29Impl {
    public static int checkOpNoThrow(AppOpsManager appOpsManager, String str, int i, String str2) {
        if (appOpsManager == null) {
            return 1;
        }
        return appOpsManager.checkOpNoThrow(str, i, str2);
    }

    public static String getOpPackageName(Context context) {
        return context.getOpPackageName();
    }

    public static AppOpsManager getSystemService(Context context) {
        return (AppOpsManager) context.getSystemService(AppOpsManager.class);
    }
}
