package androidx.savedstate;

import android.os.Bundle;
import androidx.activity.ComponentActivity$$ExternalSyntheticLambda1;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.arch.core.internal.SafeIterableMap.IteratorWithAdditions;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class SavedStateRegistryController {
    public boolean attached;
    public final SavedStateRegistryOwner owner;
    public final SavedStateRegistry savedStateRegistry = new SavedStateRegistry();

    public SavedStateRegistryController(SavedStateRegistryOwner savedStateRegistryOwner) {
        this.owner = savedStateRegistryOwner;
    }

    public final void performAttach() {
        SavedStateRegistryOwner savedStateRegistryOwner = this.owner;
        Lifecycle lifecycle = savedStateRegistryOwner.getLifecycle();
        if (((LifecycleRegistry) lifecycle).state != Lifecycle.State.INITIALIZED) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        lifecycle.addObserver(new Recreator(savedStateRegistryOwner));
        SavedStateRegistry savedStateRegistry = this.savedStateRegistry;
        savedStateRegistry.getClass();
        if (savedStateRegistry.attached) {
            throw new IllegalStateException("SavedStateRegistry was already attached.");
        }
        lifecycle.addObserver(new ComponentActivity$$ExternalSyntheticLambda1(savedStateRegistry, 2));
        savedStateRegistry.attached = true;
        this.attached = true;
    }

    public final void performRestore(Bundle bundle) {
        if (!this.attached) {
            performAttach();
        }
        LifecycleRegistry lifecycleRegistry = (LifecycleRegistry) this.owner.getLifecycle();
        if (lifecycleRegistry.state.compareTo(Lifecycle.State.STARTED) >= 0) {
            throw new IllegalStateException(("performRestore cannot be called when owner is " + lifecycleRegistry.state).toString());
        }
        SavedStateRegistry savedStateRegistry = this.savedStateRegistry;
        if (!savedStateRegistry.attached) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).");
        }
        if (savedStateRegistry.isRestored) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        savedStateRegistry.restoredState = bundle != null ? bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key") : null;
        savedStateRegistry.isRestored = true;
    }

    public final void performSave(Bundle outBundle) {
        Intrinsics.checkNotNullParameter(outBundle, "outBundle");
        SavedStateRegistry savedStateRegistry = this.savedStateRegistry;
        savedStateRegistry.getClass();
        Bundle bundle = new Bundle();
        Bundle bundle2 = savedStateRegistry.restoredState;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        SafeIterableMap safeIterableMap = savedStateRegistry.components;
        safeIterableMap.getClass();
        SafeIterableMap.IteratorWithAdditions iteratorWithAdditions = safeIterableMap.new IteratorWithAdditions();
        safeIterableMap.mIterators.put(iteratorWithAdditions, Boolean.FALSE);
        while (iteratorWithAdditions.hasNext()) {
            Map.Entry entry = (Map.Entry) iteratorWithAdditions.next();
            bundle.putBundle((String) entry.getKey(), ((SavedStateRegistry.SavedStateProvider) entry.getValue()).saveState());
        }
        if (bundle.isEmpty()) {
            return;
        }
        outBundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle);
    }
}
