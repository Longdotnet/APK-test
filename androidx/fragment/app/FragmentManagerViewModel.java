package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider$Factory;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.loader.app.LoaderManagerImpl;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentManagerViewModel extends ViewModel {
    public static final AnonymousClass1 FACTORY = new AnonymousClass1(0);
    public final boolean mStateAutomaticallySaved;
    public final HashMap mRetainedFragments = new HashMap();
    public final HashMap mChildNonConfigs = new HashMap();
    public final HashMap mViewModelStores = new HashMap();
    public boolean mHasBeenCleared = false;
    public boolean mIsStateSaved = false;

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentManagerViewModel$1, reason: invalid class name */
    public final class AnonymousClass1 implements ViewModelProvider$Factory {
        public final /* synthetic */ int $r8$classId;

        public /* synthetic */ AnonymousClass1(int i) {
            this.$r8$classId = i;
        }

        @Override // androidx.lifecycle.ViewModelProvider$Factory
        public final ViewModel create(Class cls, MutableCreationExtras mutableCreationExtras) {
            switch (this.$r8$classId) {
                case 0:
                    break;
            }
            return create(cls);
        }

        @Override // androidx.lifecycle.ViewModelProvider$Factory
        public final ViewModel create(Class cls) {
            switch (this.$r8$classId) {
                case 0:
                    return new FragmentManagerViewModel(true);
                default:
                    return new LoaderManagerImpl.LoaderViewModel();
            }
        }
    }

    public FragmentManagerViewModel(boolean z) {
        this.mStateAutomaticallySaved = z;
    }

    public final void addRetainedFragment(Fragment fragment) {
        if (this.mIsStateSaved) {
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
                return;
            }
            return;
        }
        HashMap map = this.mRetainedFragments;
        if (map.containsKey(fragment.mWho)) {
            return;
        }
        map.put(fragment.mWho, fragment);
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
        }
    }

    public final void clearNonConfigState(Fragment fragment) {
        if (Log.isLoggable("FragmentManager", 3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + fragment);
        }
        clearNonConfigStateInternal(fragment.mWho);
    }

    public final void clearNonConfigStateInternal(String str) {
        HashMap map = this.mChildNonConfigs;
        FragmentManagerViewModel fragmentManagerViewModel = (FragmentManagerViewModel) map.get(str);
        if (fragmentManagerViewModel != null) {
            fragmentManagerViewModel.onCleared();
            map.remove(str);
        }
        HashMap map2 = this.mViewModelStores;
        ViewModelStore viewModelStore = (ViewModelStore) map2.get(str);
        if (viewModelStore != null) {
            viewModelStore.clear();
            map2.remove(str);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || FragmentManagerViewModel.class != obj.getClass()) {
            return false;
        }
        FragmentManagerViewModel fragmentManagerViewModel = (FragmentManagerViewModel) obj;
        return this.mRetainedFragments.equals(fragmentManagerViewModel.mRetainedFragments) && this.mChildNonConfigs.equals(fragmentManagerViewModel.mChildNonConfigs) && this.mViewModelStores.equals(fragmentManagerViewModel.mViewModelStores);
    }

    public final int hashCode() {
        return this.mViewModelStores.hashCode() + ((this.mChildNonConfigs.hashCode() + (this.mRetainedFragments.hashCode() * 31)) * 31);
    }

    @Override // androidx.lifecycle.ViewModel
    public final void onCleared() {
        if (Log.isLoggable("FragmentManager", 3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.mHasBeenCleared = true;
    }

    public final void removeRetainedFragment(Fragment fragment) {
        if (this.mIsStateSaved) {
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else {
            if (this.mRetainedFragments.remove(fragment.mWho) == null || !Log.isLoggable("FragmentManager", 2)) {
                return;
            }
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator it = this.mRetainedFragments.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator it2 = this.mChildNonConfigs.keySet().iterator();
        while (it2.hasNext()) {
            sb.append((String) it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator it3 = this.mViewModelStores.keySet().iterator();
        while (it3.hasNext()) {
            sb.append((String) it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
