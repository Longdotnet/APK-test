package androidx.lifecycle.viewmodel;

import androidx.lifecycle.SavedStateHandleSupport$savedStateHandlesVM$1$1;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider$Factory;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class InitializerViewModelFactory implements ViewModelProvider$Factory {
    public final ViewModelInitializer[] initializers;

    public InitializerViewModelFactory(ViewModelInitializer... initializers) {
        Intrinsics.checkNotNullParameter(initializers, "initializers");
        this.initializers = initializers;
    }

    @Override // androidx.lifecycle.ViewModelProvider$Factory
    public final ViewModel create(Class cls) {
        throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
    }

    @Override // androidx.lifecycle.ViewModelProvider$Factory
    public final ViewModel create(Class cls, MutableCreationExtras mutableCreationExtras) {
        ViewModel viewModel = null;
        for (ViewModelInitializer viewModelInitializer : this.initializers) {
            if (viewModelInitializer.clazz.equals(cls)) {
                viewModel = (ViewModel) SavedStateHandleSupport$savedStateHandlesVM$1$1.INSTANCE.invoke(mutableCreationExtras);
            }
        }
        if (viewModel != null) {
            return viewModel;
        }
        throw new IllegalArgumentException("No initializer set for given class ".concat(cls.getName()));
    }
}
