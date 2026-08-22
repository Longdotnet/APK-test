package androidx.lifecycle;

import java.io.Closeable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes.dex */
public final class ViewModelStore {
    public final LinkedHashMap map = new LinkedHashMap();

    public final void clear() {
        for (ViewModel viewModel : this.map.values()) {
            viewModel.mCleared = true;
            HashMap map = viewModel.mBagOfTags;
            if (map != null) {
                synchronized (map) {
                    try {
                        Iterator it = viewModel.mBagOfTags.values().iterator();
                        while (it.hasNext()) {
                            ViewModel.closeWithRuntimeException(it.next());
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            LinkedHashSet linkedHashSet = viewModel.mCloseables;
            if (linkedHashSet != null) {
                synchronized (linkedHashSet) {
                    try {
                        Iterator it2 = viewModel.mCloseables.iterator();
                        while (it2.hasNext()) {
                            ViewModel.closeWithRuntimeException((Closeable) it2.next());
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
            viewModel.onCleared();
        }
        this.map.clear();
    }
}
