package androidx.fragment.app;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.savedstate.SavedStateRegistry;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class FragmentManager$$ExternalSyntheticLambda5 implements SavedStateRegistry.SavedStateProvider {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ FragmentManager$$ExternalSyntheticLambda5(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
    public final Bundle saveState() {
        switch (this.$r8$classId) {
            case 0:
                return ((FragmentManagerImpl) this.f$0).saveAllStateInternal();
            default:
                FragmentActivity fragmentActivity = (FragmentActivity) this.f$0;
                fragmentActivity.markFragmentsCreated();
                fragmentActivity.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
                return new Bundle();
        }
    }
}
