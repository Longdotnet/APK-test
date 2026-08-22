package androidx.lifecycle;

import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactory;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.lifecycle.viewmodel.ViewModelInitializer;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import com.daerisoft.thespikerm.R;
import com.google.firebase.auth.zzaa;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes.dex */
public abstract class ViewTreeLifecycleOwner {
    public static final SavedStateHandleSupport$DEFAULT_ARGS_KEY$1 SAVED_STATE_REGISTRY_OWNER_KEY = new SavedStateHandleSupport$DEFAULT_ARGS_KEY$1();
    public static final SavedStateHandleSupport$DEFAULT_ARGS_KEY$1 VIEW_MODEL_STORE_OWNER_KEY = new SavedStateHandleSupport$DEFAULT_ARGS_KEY$1();
    public static final SavedStateHandleSupport$DEFAULT_ARGS_KEY$1 DEFAULT_ARGS_KEY = new SavedStateHandleSupport$DEFAULT_ARGS_KEY$1();

    public static final void attachHandleIfNeeded(ViewModel viewModel, SavedStateRegistry registry, Lifecycle lifecycle) {
        Object obj;
        Intrinsics.checkNotNullParameter(registry, "registry");
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        HashMap map = viewModel.mBagOfTags;
        if (map == null) {
            obj = null;
        } else {
            synchronized (map) {
                obj = viewModel.mBagOfTags.get("androidx.lifecycle.savedstate.vm.tag");
            }
        }
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) obj;
        if (savedStateHandleController == null || savedStateHandleController.isAttached) {
            return;
        }
        savedStateHandleController.attachToLifecycle(lifecycle, registry);
        Lifecycle.State state = ((LifecycleRegistry) lifecycle).state;
        if (state == Lifecycle.State.INITIALIZED || state.compareTo(Lifecycle.State.STARTED) >= 0) {
            registry.runOnNextRecreation();
        } else {
            lifecycle.addObserver(new LegacySavedStateHandleController$tryToAddRecreator$1(lifecycle, registry));
        }
    }

    public static SavedStateHandle createHandle(Bundle bundle, Bundle bundle2) {
        if (bundle == null) {
            if (bundle2 == null) {
                return new SavedStateHandle();
            }
            HashMap map = new HashMap();
            for (String key : bundle2.keySet()) {
                Intrinsics.checkNotNullExpressionValue(key, "key");
                map.put(key, bundle2.get(key));
            }
            return new SavedStateHandle(map);
        }
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("keys");
        ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("values");
        if (parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) {
            throw new IllegalStateException("Invalid bundle passed as restored state");
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int size = parcelableArrayList.size();
        for (int i = 0; i < size; i++) {
            Object obj = parcelableArrayList.get(i);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            linkedHashMap.put((String) obj, parcelableArrayList2.get(i));
        }
        return new SavedStateHandle(linkedHashMap);
    }

    public static final SavedStateHandle createSavedStateHandle(MutableCreationExtras mutableCreationExtras) {
        SavedStateHandleSupport$DEFAULT_ARGS_KEY$1 savedStateHandleSupport$DEFAULT_ARGS_KEY$1 = SAVED_STATE_REGISTRY_OWNER_KEY;
        LinkedHashMap linkedHashMap = mutableCreationExtras.map;
        SavedStateRegistryOwner savedStateRegistryOwner = (SavedStateRegistryOwner) linkedHashMap.get(savedStateHandleSupport$DEFAULT_ARGS_KEY$1);
        if (savedStateRegistryOwner == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
        }
        ViewModelStoreOwner viewModelStoreOwner = (ViewModelStoreOwner) linkedHashMap.get(VIEW_MODEL_STORE_OWNER_KEY);
        if (viewModelStoreOwner == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }
        Bundle bundle = (Bundle) linkedHashMap.get(DEFAULT_ARGS_KEY);
        String str = (String) linkedHashMap.get(SavedStateHandleSupport$DEFAULT_ARGS_KEY$1.INSTANCE$1);
        if (str == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
        }
        SavedStateRegistry.SavedStateProvider savedStateProvider = savedStateRegistryOwner.getSavedStateRegistry().getSavedStateProvider();
        SavedStateHandlesProvider savedStateHandlesProvider = savedStateProvider instanceof SavedStateHandlesProvider ? (SavedStateHandlesProvider) savedStateProvider : null;
        if (savedStateHandlesProvider == null) {
            throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
        }
        SavedStateHandlesVM savedStateHandlesVM = getSavedStateHandlesVM(viewModelStoreOwner);
        SavedStateHandle savedStateHandle = (SavedStateHandle) savedStateHandlesVM.handles.get(str);
        if (savedStateHandle != null) {
            return savedStateHandle;
        }
        Class[] clsArr = SavedStateHandle.ACCEPTABLE_CLASSES;
        savedStateHandlesProvider.performRestore();
        Bundle bundle2 = savedStateHandlesProvider.restoredState;
        Bundle bundle3 = bundle2 != null ? bundle2.getBundle(str) : null;
        Bundle bundle4 = savedStateHandlesProvider.restoredState;
        if (bundle4 != null) {
            bundle4.remove(str);
        }
        Bundle bundle5 = savedStateHandlesProvider.restoredState;
        if (bundle5 != null && bundle5.isEmpty()) {
            savedStateHandlesProvider.restoredState = null;
        }
        SavedStateHandle savedStateHandleCreateHandle = createHandle(bundle3, bundle);
        savedStateHandlesVM.handles.put(str, savedStateHandleCreateHandle);
        return savedStateHandleCreateHandle;
    }

    public static final void enableSavedStateHandles(SavedStateRegistryOwner savedStateRegistryOwner) {
        Lifecycle.State state = ((LifecycleRegistry) savedStateRegistryOwner.getLifecycle()).state;
        if (state != Lifecycle.State.INITIALIZED && state != Lifecycle.State.CREATED) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (savedStateRegistryOwner.getSavedStateRegistry().getSavedStateProvider() == null) {
            SavedStateHandlesProvider savedStateHandlesProvider = new SavedStateHandlesProvider(savedStateRegistryOwner.getSavedStateRegistry(), (ViewModelStoreOwner) savedStateRegistryOwner);
            savedStateRegistryOwner.getSavedStateRegistry().registerSavedStateProvider("androidx.lifecycle.internal.SavedStateHandlesProvider", savedStateHandlesProvider);
            savedStateRegistryOwner.getLifecycle().addObserver(new SavedStateHandleAttacher(savedStateHandlesProvider));
        }
    }

    public static final SavedStateHandlesVM getSavedStateHandlesVM(ViewModelStoreOwner viewModelStoreOwner) {
        ArrayList arrayList = new ArrayList();
        Reflection.factory.getClass();
        Class jClass = new ClassReference(SavedStateHandlesVM.class).getJClass();
        Intrinsics.checkNotNull(jClass, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        arrayList.add(new ViewModelInitializer(jClass));
        ViewModelInitializer[] viewModelInitializerArr = (ViewModelInitializer[]) arrayList.toArray(new ViewModelInitializer[0]);
        return (SavedStateHandlesVM) new zzaa(viewModelStoreOwner.getViewModelStore(), new InitializerViewModelFactory((ViewModelInitializer[]) Arrays.copyOf(viewModelInitializerArr, viewModelInitializerArr.length)), viewModelStoreOwner instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) viewModelStoreOwner).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE).get(SavedStateHandlesVM.class, "androidx.lifecycle.internal.SavedStateHandlesVM");
    }

    public static final void set(View view, LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setTag(R.id.view_tree_lifecycle_owner, lifecycleOwner);
    }
}
