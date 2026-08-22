package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import com.google.android.datatransport.runtime.dagger.internal.InstanceFactory;

/* JADX INFO: loaded from: classes.dex */
public abstract class ActivityResultContract {
    public abstract Intent createIntent(Context context, Object obj);

    public InstanceFactory getSynchronousResult(Context context, Object obj) {
        return null;
    }

    public abstract Object parseResult(int i, Intent intent);
}
