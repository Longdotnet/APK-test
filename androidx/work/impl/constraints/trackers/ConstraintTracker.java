package androidx.work.impl.constraints.trackers;

import android.content.Context;
import androidx.work.Logger$LogcatLogger;
import androidx.work.impl.constraints.controllers.ConstraintController;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.android.gms.ads.zza;
import com.google.android.gms.tasks.zzu;
import com.google.firebase.auth.zzaa;
import java.util.ArrayList;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes.dex */
public abstract class ConstraintTracker {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("ConstraintTracker");
    public final Context mAppContext;
    public Object mCurrentState;
    public final TaskExecutor mTaskExecutor;
    public final Object mLock = new Object();
    public final LinkedHashSet mListeners = new LinkedHashSet();

    public ConstraintTracker(Context context, TaskExecutor taskExecutor) {
        this.mAppContext = context.getApplicationContext();
        this.mTaskExecutor = taskExecutor;
    }

    public abstract Object getInitialState();

    public final void removeListener(ConstraintController constraintController) {
        synchronized (this.mLock) {
            try {
                if (this.mListeners.remove(constraintController) && this.mListeners.isEmpty()) {
                    stopTracking();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void setState(Object obj) {
        synchronized (this.mLock) {
            try {
                Object obj2 = this.mCurrentState;
                if (obj2 != obj && (obj2 == null || !obj2.equals(obj))) {
                    this.mCurrentState = obj;
                    ((zzu) ((zzaa) this.mTaskExecutor).zzc).execute(new zza((Object) this, (Object) new ArrayList(this.mListeners), 9, false));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract void startTracking();

    public abstract void stopTracking();
}
