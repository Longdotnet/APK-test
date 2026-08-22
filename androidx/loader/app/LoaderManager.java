package androidx.loader.app;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;

/* JADX INFO: loaded from: classes.dex */
public abstract class LoaderManager {
    public static LoaderManagerImpl getInstance(LifecycleOwner lifecycleOwner) {
        return new LoaderManagerImpl(lifecycleOwner, ((ViewModelStoreOwner) lifecycleOwner).getViewModelStore());
    }
}
