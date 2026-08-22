package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class Recreator implements LifecycleEventObserver {
    public final SavedStateRegistryOwner owner;

    public Recreator(SavedStateRegistryOwner savedStateRegistryOwner) {
        this.owner = savedStateRegistryOwner;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event != Lifecycle.Event.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        lifecycleOwner.getLifecycle().removeObserver(this);
        SavedStateRegistryOwner savedStateRegistryOwner = this.owner;
        Bundle bundleConsumeRestoredStateForKey = savedStateRegistryOwner.getSavedStateRegistry().consumeRestoredStateForKey("androidx.savedstate.Restarter");
        if (bundleConsumeRestoredStateForKey == null) {
            return;
        }
        ArrayList<String> stringArrayList = bundleConsumeRestoredStateForKey.getStringArrayList("classes_to_restore");
        if (stringArrayList == null) {
            throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
        }
        for (String str : stringArrayList) {
            try {
                Class<? extends U> clsAsSubclass = Class.forName(str, false, Recreator.class.getClassLoader()).asSubclass(SavedStateRegistry.AutoRecreated.class);
                Intrinsics.checkNotNullExpressionValue(clsAsSubclass, "{\n                Class.…class.java)\n            }");
                try {
                    Constructor declaredConstructor = clsAsSubclass.getDeclaredConstructor(null);
                    declaredConstructor.setAccessible(true);
                    try {
                        Object objNewInstance = declaredConstructor.newInstance(null);
                        Intrinsics.checkNotNullExpressionValue(objNewInstance, "{\n                constr…wInstance()\n            }");
                        if (!(savedStateRegistryOwner instanceof ViewModelStoreOwner)) {
                            throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner");
                        }
                        ViewModelStore viewModelStore = ((ViewModelStoreOwner) savedStateRegistryOwner).getViewModelStore();
                        SavedStateRegistry savedStateRegistry = savedStateRegistryOwner.getSavedStateRegistry();
                        viewModelStore.getClass();
                        LinkedHashMap linkedHashMap = viewModelStore.map;
                        for (String key : new HashSet(linkedHashMap.keySet())) {
                            Intrinsics.checkNotNullParameter(key, "key");
                            ViewModel viewModel = (ViewModel) linkedHashMap.get(key);
                            Intrinsics.checkNotNull(viewModel);
                            ViewTreeLifecycleOwner.attachHandleIfNeeded(viewModel, savedStateRegistry, savedStateRegistryOwner.getLifecycle());
                        }
                        if (!new HashSet(linkedHashMap.keySet()).isEmpty()) {
                            savedStateRegistry.runOnNextRecreation();
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Failed to instantiate ", str), e);
                    }
                } catch (NoSuchMethodException e2) {
                    throw new IllegalStateException("Class " + clsAsSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e2);
                }
            } catch (ClassNotFoundException e3) {
                throw new RuntimeException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Class ", str, " wasn't found"), e3);
            }
        }
    }
}
