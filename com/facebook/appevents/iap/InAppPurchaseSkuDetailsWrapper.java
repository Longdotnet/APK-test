package com.facebook.appevents.iap;

import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.Headers;

/* JADX INFO: loaded from: classes.dex */
public final class InAppPurchaseSkuDetailsWrapper {
    public static final AtomicBoolean initialized = new AtomicBoolean(false);
    public static InAppPurchaseSkuDetailsWrapper instance;
    public final Method buildMethod;
    public final Class builderClazz;
    public final Method newBuilderMethod;
    public final Method setSkusListMethod;
    public final Method setTypeMethod;
    public final Class skuDetailsParamsClazz;

    public InAppPurchaseSkuDetailsWrapper(Class cls, Class cls2, Method method, Method method2, Method method3, Method method4) {
        this.skuDetailsParamsClazz = cls;
        this.builderClazz = cls2;
        this.newBuilderMethod = method;
        this.setTypeMethod = method2;
        this.setSkusListMethod = method3;
        this.buildMethod = method4;
    }

    public final Object getSkuDetailsParams(ArrayList arrayList) {
        Object objInvokeMethod;
        Object objInvokeMethod2;
        Class cls = this.builderClazz;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Object objInvokeMethod3 = Headers.Companion.invokeMethod(this.skuDetailsParamsClazz, this.newBuilderMethod, null, new Object[0]);
            if (objInvokeMethod3 != null && (objInvokeMethod = Headers.Companion.invokeMethod(cls, this.setTypeMethod, objInvokeMethod3, "inapp")) != null && (objInvokeMethod2 = Headers.Companion.invokeMethod(cls, this.setSkusListMethod, objInvokeMethod, arrayList)) != null) {
                return Headers.Companion.invokeMethod(cls, this.buildMethod, objInvokeMethod2, new Object[0]);
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
            return null;
        }
    }
}
