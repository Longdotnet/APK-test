package okhttp3.internal.platform.android;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public final class CloseGuard {
    public final Method getMethod;
    public final Method openMethod;
    public final Method warnIfOpenMethod;

    public /* synthetic */ CloseGuard(Method method, Method method2, Method method3) {
        this.getMethod = method;
        this.openMethod = method2;
        this.warnIfOpenMethod = method3;
    }
}
