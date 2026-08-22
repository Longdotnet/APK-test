package androidx.lifecycle;

import android.app.Application;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class ViewModelProvider$AndroidViewModelFactory extends ViewModelProvider$NewInstanceFactory {
    public static ViewModelProvider$AndroidViewModelFactory sInstance;
    public final Application application;

    public ViewModelProvider$AndroidViewModelFactory(Application application) {
        this.application = application;
    }

    @Override // androidx.lifecycle.ViewModelProvider$NewInstanceFactory, androidx.lifecycle.ViewModelProvider$Factory
    public final ViewModel create(Class cls, MutableCreationExtras mutableCreationExtras) {
        if (this.application != null) {
            return create(cls);
        }
        Application application = (Application) mutableCreationExtras.map.get(SavedStateHandleSupport$DEFAULT_ARGS_KEY$1.INSTANCE);
        if (application != null) {
            return create(cls, application);
        }
        if (AndroidViewModel.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
        }
        return super.create(cls);
    }

    @Override // androidx.lifecycle.ViewModelProvider$NewInstanceFactory, androidx.lifecycle.ViewModelProvider$Factory
    public final ViewModel create(Class cls) {
        Application application = this.application;
        if (application != null) {
            return create(cls, application);
        }
        throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
    }

    public final ViewModel create(Class cls, Application application) {
        if (AndroidViewModel.class.isAssignableFrom(cls)) {
            try {
                ViewModel viewModel = (ViewModel) cls.getConstructor(Application.class).newInstance(application);
                Intrinsics.checkNotNullExpressionValue(viewModel, "{\n                try {\n…          }\n            }");
                return viewModel;
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Cannot create an instance of " + cls, e);
            } catch (InstantiationException e2) {
                throw new RuntimeException("Cannot create an instance of " + cls, e2);
            } catch (NoSuchMethodException e3) {
                throw new RuntimeException("Cannot create an instance of " + cls, e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("Cannot create an instance of " + cls, e4);
            }
        }
        return super.create(cls);
    }
}
