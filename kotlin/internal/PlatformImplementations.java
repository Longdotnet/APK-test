package kotlin.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.FallbackThreadLocalRandom;
import kotlin.random.Random;

/* JADX INFO: loaded from: classes3.dex */
public class PlatformImplementations {

    public abstract class ReflectThrowable {
        public static final Method addSuppressed;

        static {
            Method method;
            Method[] throwableMethods = Throwable.class.getMethods();
            Intrinsics.checkNotNullExpressionValue(throwableMethods, "throwableMethods");
            int length = throwableMethods.length;
            int i = 0;
            while (true) {
                method = null;
                if (i >= length) {
                    break;
                }
                Method method2 = throwableMethods[i];
                if (Intrinsics.areEqual(method2.getName(), "addSuppressed")) {
                    Class<?>[] parameterTypes = method2.getParameterTypes();
                    Intrinsics.checkNotNullExpressionValue(parameterTypes, "it.parameterTypes");
                    if (Intrinsics.areEqual(parameterTypes.length == 1 ? parameterTypes[0] : null, Throwable.class)) {
                        method = method2;
                        break;
                    }
                }
                i++;
            }
            addSuppressed = method;
            int length2 = throwableMethods.length;
            for (int i2 = 0; i2 < length2 && !Intrinsics.areEqual(throwableMethods[i2].getName(), "getSuppressed"); i2++) {
            }
        }
    }

    public void addSuppressed(Throwable cause, Throwable exception) throws IllegalAccessException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(cause, "cause");
        Intrinsics.checkNotNullParameter(exception, "exception");
        Method method = ReflectThrowable.addSuppressed;
        if (method != null) {
            method.invoke(cause, exception);
        }
    }

    public Random defaultPlatformRandom() {
        return new FallbackThreadLocalRandom();
    }
}
