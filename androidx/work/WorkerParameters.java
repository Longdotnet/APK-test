package androidx.work;

import androidx.work.impl.utils.WorkForegroundUpdater;
import androidx.work.impl.utils.WorkProgressUpdater;
import com.google.firebase.auth.zzaa;
import java.util.HashSet;
import java.util.UUID;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class WorkerParameters {
    public ExecutorService mBackgroundExecutor;
    public WorkForegroundUpdater mForegroundUpdater;
    public UUID mId;
    public Data mInputData;
    public WorkProgressUpdater mProgressUpdater;
    public int mRunAttemptCount;
    public zzaa mRuntimeExtras;
    public HashSet mTags;
    public zzaa mWorkTaskExecutor;
    public WorkerFactory.AnonymousClass1 mWorkerFactory;
}
