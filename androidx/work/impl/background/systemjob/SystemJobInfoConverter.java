package androidx.work.impl.background.systemjob;

import android.content.ComponentName;
import android.content.Context;
import androidx.work.Logger$LogcatLogger;

/* JADX INFO: loaded from: classes.dex */
public final class SystemJobInfoConverter {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("SystemJobInfoConverter");
    public final ComponentName mWorkServiceComponent;

    public SystemJobInfoConverter(Context context) {
        this.mWorkServiceComponent = new ComponentName(context.getApplicationContext(), (Class<?>) SystemJobService.class);
    }
}
