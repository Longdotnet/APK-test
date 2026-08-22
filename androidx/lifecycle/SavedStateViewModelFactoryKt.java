package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.Okio;

/* JADX INFO: loaded from: classes.dex */
public abstract class SavedStateViewModelFactoryKt {
    public static final List ANDROID_VIEWMODEL_SIGNATURE = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{Application.class, SavedStateHandle.class});
    public static final List VIEWMODEL_SIGNATURE = Okio.listOf(SavedStateHandle.class);

    public static final Constructor findMatchingConstructor(Class cls, List signature) {
        Intrinsics.checkNotNullParameter(signature, "signature");
        Constructor<?>[] constructors = cls.getConstructors();
        Intrinsics.checkNotNullExpressionValue(constructors, "modelClass.constructors");
        for (Constructor<?> constructor : constructors) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            Intrinsics.checkNotNullExpressionValue(parameterTypes, "constructor.parameterTypes");
            List list = ArraysKt.toList(parameterTypes);
            if (signature.equals(list)) {
                return constructor;
            }
            if (signature.size() == list.size() && list.containsAll(signature)) {
                throw new UnsupportedOperationException("Class " + cls.getSimpleName() + " must have parameters in the proper order: " + signature);
            }
        }
        return null;
    }

    public static final ViewModel newInstance(Class cls, Constructor constructor, Object... objArr) {
        try {
            return (ViewModel) constructor.newInstance(Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Failed to access " + cls, e);
        } catch (InstantiationException e2) {
            throw new RuntimeException("A " + cls + " cannot be instantiated.", e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException("An exception happened in constructor of " + cls, e3.getCause());
        }
    }
}
