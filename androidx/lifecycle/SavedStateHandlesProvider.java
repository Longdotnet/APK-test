package androidx.lifecycle;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;
import java.util.Map;
import kotlin.SynchronizedLazyImpl;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Handshake;

/* JADX INFO: loaded from: classes.dex */
public final class SavedStateHandlesProvider implements SavedStateRegistry.SavedStateProvider {
    public boolean restored;
    public Bundle restoredState;
    public final SavedStateRegistry savedStateRegistry;
    public final SynchronizedLazyImpl viewModel$delegate;

    public SavedStateHandlesProvider(SavedStateRegistry savedStateRegistry, ViewModelStoreOwner viewModelStoreOwner) {
        Intrinsics.checkNotNullParameter(savedStateRegistry, "savedStateRegistry");
        this.savedStateRegistry = savedStateRegistry;
        this.viewModel$delegate = new SynchronizedLazyImpl(new Handshake.AnonymousClass2(viewModelStoreOwner, 1));
    }

    public final void performRestore() {
        if (this.restored) {
            return;
        }
        Bundle bundleConsumeRestoredStateForKey = this.savedStateRegistry.consumeRestoredStateForKey("androidx.lifecycle.internal.SavedStateHandlesProvider");
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.restoredState;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        if (bundleConsumeRestoredStateForKey != null) {
            bundle.putAll(bundleConsumeRestoredStateForKey);
        }
        this.restoredState = bundle;
        this.restored = true;
    }

    @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
    public final Bundle saveState() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.restoredState;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        for (Map.Entry entry : ((SavedStateHandlesVM) this.viewModel$delegate.getValue()).handles.entrySet()) {
            String str = (String) entry.getKey();
            Bundle bundleSaveState = ((SavedStateHandle) entry.getValue()).savedStateProvider.saveState();
            if (!Intrinsics.areEqual(bundleSaveState, Bundle.EMPTY)) {
                bundle.putBundle(str, bundleSaveState);
            }
        }
        this.restored = false;
        return bundle;
    }
}
