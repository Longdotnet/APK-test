package androidx.lifecycle;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.lang.reflect.Constructor;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class SavedStateViewModelFactory implements ViewModelProvider$Factory {
    public final Application application;
    public final Bundle defaultArgs;
    public final ViewModelProvider$AndroidViewModelFactory factory;
    public final Lifecycle lifecycle;
    public final SavedStateRegistry savedStateRegistry;

    public SavedStateViewModelFactory(Application application, SavedStateRegistryOwner savedStateRegistryOwner, Bundle bundle) {
        ViewModelProvider$AndroidViewModelFactory viewModelProvider$AndroidViewModelFactory;
        this.savedStateRegistry = savedStateRegistryOwner.getSavedStateRegistry();
        this.lifecycle = savedStateRegistryOwner.getLifecycle();
        this.defaultArgs = bundle;
        this.application = application;
        if (application != null) {
            if (ViewModelProvider$AndroidViewModelFactory.sInstance == null) {
                ViewModelProvider$AndroidViewModelFactory.sInstance = new ViewModelProvider$AndroidViewModelFactory(application);
            }
            viewModelProvider$AndroidViewModelFactory = ViewModelProvider$AndroidViewModelFactory.sInstance;
            Intrinsics.checkNotNull(viewModelProvider$AndroidViewModelFactory);
        } else {
            viewModelProvider$AndroidViewModelFactory = new ViewModelProvider$AndroidViewModelFactory(null);
        }
        this.factory = viewModelProvider$AndroidViewModelFactory;
    }

    @Override // androidx.lifecycle.ViewModelProvider$Factory
    public final ViewModel create(Class cls, MutableCreationExtras mutableCreationExtras) {
        SavedStateHandleSupport$DEFAULT_ARGS_KEY$1 savedStateHandleSupport$DEFAULT_ARGS_KEY$1 = SavedStateHandleSupport$DEFAULT_ARGS_KEY$1.INSTANCE$1;
        LinkedHashMap linkedHashMap = mutableCreationExtras.map;
        String str = (String) linkedHashMap.get(savedStateHandleSupport$DEFAULT_ARGS_KEY$1);
        if (str == null) {
            throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        }
        if (linkedHashMap.get(ViewTreeLifecycleOwner.SAVED_STATE_REGISTRY_OWNER_KEY) == null || linkedHashMap.get(ViewTreeLifecycleOwner.VIEW_MODEL_STORE_OWNER_KEY) == null) {
            if (this.lifecycle != null) {
                return create(cls, str);
            }
            throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
        }
        Application application = (Application) linkedHashMap.get(SavedStateHandleSupport$DEFAULT_ARGS_KEY$1.INSTANCE);
        boolean zIsAssignableFrom = AndroidViewModel.class.isAssignableFrom(cls);
        Constructor constructorFindMatchingConstructor = (!zIsAssignableFrom || application == null) ? SavedStateViewModelFactoryKt.findMatchingConstructor(cls, SavedStateViewModelFactoryKt.VIEWMODEL_SIGNATURE) : SavedStateViewModelFactoryKt.findMatchingConstructor(cls, SavedStateViewModelFactoryKt.ANDROID_VIEWMODEL_SIGNATURE);
        if (constructorFindMatchingConstructor == null) {
            return this.factory.create(cls, mutableCreationExtras);
        }
        return (!zIsAssignableFrom || application == null) ? SavedStateViewModelFactoryKt.newInstance(cls, constructorFindMatchingConstructor, ViewTreeLifecycleOwner.createSavedStateHandle(mutableCreationExtras)) : SavedStateViewModelFactoryKt.newInstance(cls, constructorFindMatchingConstructor, application, ViewTreeLifecycleOwner.createSavedStateHandle(mutableCreationExtras));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ViewModel create(Class cls, String str) {
        Constructor constructorFindMatchingConstructor;
        ViewModel viewModelNewInstance;
        Object obj;
        Application application;
        Lifecycle lifecycle = this.lifecycle;
        if (lifecycle != null) {
            boolean zIsAssignableFrom = AndroidViewModel.class.isAssignableFrom(cls);
            if (zIsAssignableFrom && this.application != null) {
                constructorFindMatchingConstructor = SavedStateViewModelFactoryKt.findMatchingConstructor(cls, SavedStateViewModelFactoryKt.ANDROID_VIEWMODEL_SIGNATURE);
            } else {
                constructorFindMatchingConstructor = SavedStateViewModelFactoryKt.findMatchingConstructor(cls, SavedStateViewModelFactoryKt.VIEWMODEL_SIGNATURE);
            }
            if (constructorFindMatchingConstructor == null) {
                if (this.application != null) {
                    return this.factory.create(cls);
                }
                if (ViewModelProvider$NewInstanceFactory.sInstance == null) {
                    ViewModelProvider$NewInstanceFactory.sInstance = new ViewModelProvider$NewInstanceFactory();
                }
                ViewModelProvider$NewInstanceFactory viewModelProvider$NewInstanceFactory = ViewModelProvider$NewInstanceFactory.sInstance;
                Intrinsics.checkNotNull(viewModelProvider$NewInstanceFactory);
                return viewModelProvider$NewInstanceFactory.create(cls);
            }
            SavedStateRegistry savedStateRegistry = this.savedStateRegistry;
            Intrinsics.checkNotNull(savedStateRegistry);
            Bundle bundle = this.defaultArgs;
            Bundle bundleConsumeRestoredStateForKey = savedStateRegistry.consumeRestoredStateForKey(str);
            Class[] clsArr = SavedStateHandle.ACCEPTABLE_CLASSES;
            SavedStateHandle savedStateHandleCreateHandle = ViewTreeLifecycleOwner.createHandle(bundleConsumeRestoredStateForKey, bundle);
            SavedStateHandleController savedStateHandleController = new SavedStateHandleController(str, savedStateHandleCreateHandle);
            savedStateHandleController.attachToLifecycle(lifecycle, savedStateRegistry);
            Lifecycle.State state = ((LifecycleRegistry) lifecycle).state;
            if (state != Lifecycle.State.INITIALIZED && state.compareTo(Lifecycle.State.STARTED) < 0) {
                lifecycle.addObserver(new LegacySavedStateHandleController$tryToAddRecreator$1(lifecycle, savedStateRegistry));
            } else {
                savedStateRegistry.runOnNextRecreation();
            }
            if (zIsAssignableFrom && (application = this.application) != null) {
                viewModelNewInstance = SavedStateViewModelFactoryKt.newInstance(cls, constructorFindMatchingConstructor, application, savedStateHandleCreateHandle);
            } else {
                viewModelNewInstance = SavedStateViewModelFactoryKt.newInstance(cls, constructorFindMatchingConstructor, savedStateHandleCreateHandle);
            }
            synchronized (viewModelNewInstance.mBagOfTags) {
                try {
                    obj = viewModelNewInstance.mBagOfTags.get("androidx.lifecycle.savedstate.vm.tag");
                    if (obj == null) {
                        viewModelNewInstance.mBagOfTags.put("androidx.lifecycle.savedstate.vm.tag", savedStateHandleController);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (obj != null) {
                savedStateHandleController = obj;
            }
            if (viewModelNewInstance.mCleared) {
                ViewModel.closeWithRuntimeException(savedStateHandleController);
            }
            return viewModelNewInstance;
        }
        throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
    }

    @Override // androidx.lifecycle.ViewModelProvider$Factory
    public final ViewModel create(Class cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return create(cls, canonicalName);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
}
