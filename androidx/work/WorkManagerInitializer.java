package androidx.work;

import android.content.Context;
import androidx.startup.Initializer;
import androidx.work.impl.WorkManagerImpl;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class WorkManagerInitializer implements Initializer {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("WrkMgrInitializer");

    @Override // androidx.startup.Initializer
    public final Object create(Context context) {
        Logger$LogcatLogger.get().debug(TAG, "Initializing WorkManager with default configuration.", new Throwable[0]);
        WorkManagerImpl.initialize(context, new Configuration(new InputMergerFactory$1(20)));
        return WorkManagerImpl.getInstance(context);
    }

    @Override // androidx.startup.Initializer
    public final List dependencies() {
        return Collections.emptyList();
    }
}
