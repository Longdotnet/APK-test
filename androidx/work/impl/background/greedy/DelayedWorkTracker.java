package androidx.work.impl.background.greedy;

import androidx.work.Logger$LogcatLogger;
import com.facebook.AccessTokenCache;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class DelayedWorkTracker {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("DelayedWorkTracker");
    public final GreedyScheduler mGreedyScheduler;
    public final AccessTokenCache mRunnableScheduler;
    public final HashMap mRunnables = new HashMap();

    public DelayedWorkTracker(GreedyScheduler greedyScheduler, AccessTokenCache accessTokenCache) {
        this.mGreedyScheduler = greedyScheduler;
        this.mRunnableScheduler = accessTokenCache;
    }
}
