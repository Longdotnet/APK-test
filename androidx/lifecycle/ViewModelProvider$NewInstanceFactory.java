package androidx.lifecycle;

import androidx.lifecycle.viewmodel.MutableCreationExtras;
import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public class ViewModelProvider$NewInstanceFactory implements ViewModelProvider$Factory {
    public static ViewModelProvider$NewInstanceFactory sInstance;

    @Override // androidx.lifecycle.ViewModelProvider$Factory
    public ViewModel create(Class cls, MutableCreationExtras mutableCreationExtras) {
        return create(cls);
    }

    @Override // androidx.lifecycle.ViewModelProvider$Factory
    public ViewModel create(Class cls) throws InvocationTargetException {
        try {
            Object objNewInstance = cls.getDeclaredConstructor(null).newInstance(null);
            Intrinsics.checkNotNullExpressionValue(objNewInstance, "{\n                modelC…wInstance()\n            }");
            return (ViewModel) objNewInstance;
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Cannot create an instance of " + cls, e);
        } catch (InstantiationException e2) {
            throw new RuntimeException("Cannot create an instance of " + cls, e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("Cannot create an instance of " + cls, e3);
        }
    }
}
