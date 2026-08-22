package kotlin.jvm.internal;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.util.Arrays;
import kotlin.UninitializedPropertyAccessException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Intrinsics {
    public static boolean areEqual(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static void checkNotNull(Object obj) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException();
        sanitizeStackTrace(nullPointerException, Intrinsics.class.getName());
        throw nullPointerException;
    }

    public static void checkNotNullExpressionValue(Object obj, String str) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException(str.concat(" must not be null"));
        sanitizeStackTrace(nullPointerException, Intrinsics.class.getName());
        throw nullPointerException;
    }

    public static void checkNotNullParameter(Object obj, String str) {
        if (obj == null) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            String name = Intrinsics.class.getName();
            int i = 0;
            while (!stackTrace[i].getClassName().equals(name)) {
                i++;
            }
            while (stackTrace[i].getClassName().equals(name)) {
                i++;
            }
            StackTraceElement stackTraceElement = stackTrace[i];
            StringBuilder sbM22m = CoroutineAdapterKt$$ExternalSyntheticLambda0.m22m("Parameter specified as non-null is null: method ", stackTraceElement.getClassName(), ".", stackTraceElement.getMethodName(), ", parameter ");
            sbM22m.append(str);
            NullPointerException nullPointerException = new NullPointerException(sbM22m.toString());
            sanitizeStackTrace(nullPointerException, Intrinsics.class.getName());
            throw nullPointerException;
        }
    }

    public static int compare(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    public static void sanitizeStackTrace(RuntimeException runtimeException, String str) {
        StackTraceElement[] stackTrace = runtimeException.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        runtimeException.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i + 1, length));
    }

    public static String stringPlus(Object obj, String str) {
        return str + obj;
    }

    public static void throwUninitializedPropertyAccessException(String str) {
        UninitializedPropertyAccessException uninitializedPropertyAccessException = new UninitializedPropertyAccessException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("lateinit property ", str, " has not been initialized"));
        sanitizeStackTrace(uninitializedPropertyAccessException, Intrinsics.class.getName());
        throw uninitializedPropertyAccessException;
    }

    public static void checkNotNull(Object obj, String str) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException(str);
        sanitizeStackTrace(nullPointerException, Intrinsics.class.getName());
        throw nullPointerException;
    }
}
