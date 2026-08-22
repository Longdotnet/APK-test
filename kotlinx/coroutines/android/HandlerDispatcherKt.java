package kotlinx.coroutines.android;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import com.facebook.appevents.suggestedevents.naLU.DaWYVMJ;
import java.lang.reflect.InvocationTargetException;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class HandlerDispatcherKt {
    private static volatile Choreographer choreographer;

    static {
        Object objCreateFailure;
        try {
            objCreateFailure = new HandlerContext(asHandler(Looper.getMainLooper()));
        } catch (Throwable th) {
            objCreateFailure = StringsKt__IndentKt.createFailure(th);
        }
        if (objCreateFailure instanceof Result.Failure) {
            objCreateFailure = null;
        }
    }

    public static final Handler asHandler(Looper looper) throws IllegalAccessException, InvocationTargetException {
        if (Build.VERSION.SDK_INT < 28) {
            try {
                return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
            } catch (NoSuchMethodException unused) {
                return new Handler(looper);
            }
        }
        Object objInvoke = Handler.class.getDeclaredMethod(DaWYVMJ.OsZQpldUl, Looper.class).invoke(null, looper);
        Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type android.os.Handler");
        return (Handler) objInvoke;
    }
}
