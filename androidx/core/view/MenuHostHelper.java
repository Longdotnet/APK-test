package androidx.core.view;

import android.view.MenuItem;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class MenuHostHelper {
    public final Runnable mOnInvalidateMenuCallback;
    public final CopyOnWriteArrayList mMenuProviders = new CopyOnWriteArrayList();
    public final HashMap mProviderToLifecycleContainers = new HashMap();

    public final class LifecycleContainer {
        public final Lifecycle mLifecycle;
        public LifecycleEventObserver mObserver;

        public LifecycleContainer(Lifecycle lifecycle, LifecycleEventObserver lifecycleEventObserver) {
            this.mLifecycle = lifecycle;
            this.mObserver = lifecycleEventObserver;
            lifecycle.addObserver(lifecycleEventObserver);
        }
    }

    public MenuHostHelper(Runnable runnable) {
        this.mOnInvalidateMenuCallback = runnable;
    }

    public final boolean onMenuItemSelected(MenuItem menuItem) {
        Iterator it = this.mMenuProviders.iterator();
        while (it.hasNext()) {
            if (FragmentManager.this.dispatchOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final void removeMenuProvider(MenuProvider menuProvider) {
        this.mMenuProviders.remove(menuProvider);
        LifecycleContainer lifecycleContainer = (LifecycleContainer) this.mProviderToLifecycleContainers.remove(menuProvider);
        if (lifecycleContainer != null) {
            lifecycleContainer.mLifecycle.removeObserver(lifecycleContainer.mObserver);
            lifecycleContainer.mObserver = null;
        }
        this.mOnInvalidateMenuCallback.run();
    }
}
