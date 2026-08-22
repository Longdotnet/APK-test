package androidx.work.impl.background.systemalarm;

import android.content.Context;
import androidx.work.Logger$LogcatLogger;
import androidx.work.impl.constraints.WorkConstraintsTracker;

/* JADX INFO: loaded from: classes.dex */
public final class ConstraintsCommandHandler {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("ConstraintsCmdHandler");
    public final Context mContext;
    public final int mStartId;
    public final WorkConstraintsTracker mWorkConstraintsTracker;

    public ConstraintsCommandHandler(Context context, int i, SystemAlarmDispatcher systemAlarmDispatcher) {
        this.mContext = context;
        this.mStartId = i;
        this.mWorkConstraintsTracker = new WorkConstraintsTracker(context, systemAlarmDispatcher.mTaskExecutor, null);
    }
}
