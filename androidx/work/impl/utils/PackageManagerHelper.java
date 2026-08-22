package androidx.work.impl.utils;

import android.content.ComponentName;
import android.content.Context;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.work.Logger$LogcatLogger;

/* JADX INFO: loaded from: classes.dex */
public abstract class PackageManagerHelper {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("PackageManagerHelper");

    public static void setComponentEnabled(Context context, Class cls, boolean z) {
        String str = TAG;
        try {
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, cls.getName()), z ? 1 : 2, 1);
            Logger$LogcatLogger.get().debug(str, cls.getName() + " " + (z ? "enabled" : "disabled"), new Throwable[0]);
        } catch (Exception e) {
            Logger$LogcatLogger.get().debug(str, CoroutineAdapterKt$$ExternalSyntheticLambda0.m(cls.getName(), " could not be ", z ? "enabled" : "disabled"), e);
        }
    }
}
