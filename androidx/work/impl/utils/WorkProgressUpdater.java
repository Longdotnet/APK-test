package androidx.work.impl.utils;

import androidx.work.Logger$LogcatLogger;
import androidx.work.impl.WorkDatabase;
import com.google.firebase.auth.zzaa;

/* JADX INFO: loaded from: classes.dex */
public final class WorkProgressUpdater {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("WorkProgressUpdater");
    public final zzaa mTaskExecutor;
    public final WorkDatabase mWorkDatabase;

    public WorkProgressUpdater(WorkDatabase workDatabase, zzaa zzaaVar) {
        this.mWorkDatabase = workDatabase;
        this.mTaskExecutor = zzaaVar;
    }
}
