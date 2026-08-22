package com.facebook.appevents.iap;

import android.content.Context;
import androidx.work.impl.constraints.controllers.pST.ehgOP;
import com.facebook.appevents.AppEventQueue$$ExternalSyntheticLambda0;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.Headers;

/* JADX INFO: loaded from: classes2.dex */
public final class InAppPurchaseAutoLogger {
    public static final InAppPurchaseAutoLogger INSTANCE = new InAppPurchaseAutoLogger();

    /* JADX WARN: Code duplicated, block: B:13:0x002b  */
    /* JADX WARN: Code duplicated, block: B:92:0x01af  */
    public static void createInstance(Context context) {
        AtomicBoolean atomicBoolean;
        AtomicBoolean atomicBoolean2;
        InAppPurchaseSkuDetailsWrapper inAppPurchaseSkuDetailsWrapper;
        Class cls;
        Object obj;
        int i = 0;
        InAppPurchaseSkuDetailsWrapper inAppPurchaseSkuDetailsWrapper2 = InAppPurchaseSkuDetailsWrapper.instance;
        Object objInvokeMethod = null;
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseSkuDetailsWrapper.class)) {
            atomicBoolean = null;
        } else {
            try {
                atomicBoolean = InAppPurchaseSkuDetailsWrapper.initialized;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(InAppPurchaseSkuDetailsWrapper.class, th);
                atomicBoolean = null;
            }
        }
        if (!atomicBoolean.get()) {
            Class cls2 = Headers.Companion.getClass("com.android.billingclient.api.SkuDetailsParams");
            Class cls3 = Headers.Companion.getClass("com.android.billingclient.api.SkuDetailsParams$Builder");
            if (cls2 != null && cls3 != null) {
                Method method = Headers.Companion.getMethod(cls2, "newBuilder", new Class[0]);
                Method method2 = Headers.Companion.getMethod(cls3, "setType", String.class);
                Method method3 = Headers.Companion.getMethod(cls3, "setSkusList", List.class);
                Method method4 = Headers.Companion.getMethod(cls3, "build", new Class[0]);
                if (method != null && method2 != null && method3 != null && method4 != null) {
                    InAppPurchaseSkuDetailsWrapper inAppPurchaseSkuDetailsWrapper3 = new InAppPurchaseSkuDetailsWrapper(cls2, cls3, method, method2, method3, method4);
                    if (!CrashShieldHandler.isObjectCrashing(InAppPurchaseSkuDetailsWrapper.class)) {
                        try {
                            InAppPurchaseSkuDetailsWrapper.instance = inAppPurchaseSkuDetailsWrapper3;
                        } catch (Throwable th2) {
                            CrashShieldHandler.handleThrowable(InAppPurchaseSkuDetailsWrapper.class, th2);
                        }
                    }
                }
            }
            if (CrashShieldHandler.isObjectCrashing(InAppPurchaseSkuDetailsWrapper.class)) {
                atomicBoolean2 = null;
            } else {
                try {
                    atomicBoolean2 = InAppPurchaseSkuDetailsWrapper.initialized;
                } catch (Throwable th3) {
                    CrashShieldHandler.handleThrowable(InAppPurchaseSkuDetailsWrapper.class, th3);
                    atomicBoolean2 = null;
                }
            }
            atomicBoolean2.set(true);
            if (CrashShieldHandler.isObjectCrashing(InAppPurchaseSkuDetailsWrapper.class)) {
                inAppPurchaseSkuDetailsWrapper = null;
            } else {
                try {
                    inAppPurchaseSkuDetailsWrapper = InAppPurchaseSkuDetailsWrapper.instance;
                } catch (Throwable th4) {
                    CrashShieldHandler.handleThrowable(InAppPurchaseSkuDetailsWrapper.class, th4);
                    inAppPurchaseSkuDetailsWrapper = null;
                }
            }
        } else if (CrashShieldHandler.isObjectCrashing(InAppPurchaseSkuDetailsWrapper.class)) {
            inAppPurchaseSkuDetailsWrapper = null;
        } else {
            try {
                inAppPurchaseSkuDetailsWrapper = InAppPurchaseSkuDetailsWrapper.instance;
            } catch (Throwable th5) {
                CrashShieldHandler.handleThrowable(InAppPurchaseSkuDetailsWrapper.class, th5);
                inAppPurchaseSkuDetailsWrapper = null;
            }
        }
        InAppPurchaseSkuDetailsWrapper inAppPurchaseSkuDetailsWrapper4 = inAppPurchaseSkuDetailsWrapper;
        if (inAppPurchaseSkuDetailsWrapper4 == null) {
            return;
        }
        Class cls4 = Headers.Companion.getClass("com.android.billingclient.api.BillingClient");
        Class cls5 = Headers.Companion.getClass("com.android.billingclient.api.Purchase");
        Class cls6 = Headers.Companion.getClass("com.android.billingclient.api.Purchase$PurchasesResult");
        Class cls7 = Headers.Companion.getClass("com.android.billingclient.api.SkuDetails");
        Class cls8 = Headers.Companion.getClass("com.android.billingclient.api.PurchaseHistoryRecord");
        Class cls9 = Headers.Companion.getClass("com.android.billingclient.api.SkuDetailsResponseListener");
        Class cls10 = Headers.Companion.getClass("com.android.billingclient.api.PurchaseHistoryResponseListener");
        if (cls4 == null || cls6 == null || cls5 == null || cls7 == null || cls9 == null || cls8 == null || cls10 == null) {
            return;
        }
        Method method5 = Headers.Companion.getMethod(cls4, "queryPurchases", String.class);
        Method method6 = Headers.Companion.getMethod(cls6, "getPurchasesList", new Class[0]);
        Method method7 = Headers.Companion.getMethod(cls5, "getOriginalJson", new Class[0]);
        Method method8 = Headers.Companion.getMethod(cls7, "getOriginalJson", new Class[0]);
        Method method9 = Headers.Companion.getMethod(cls8, "getOriginalJson", new Class[0]);
        if (CrashShieldHandler.isObjectCrashing(inAppPurchaseSkuDetailsWrapper4)) {
            cls = null;
        } else {
            try {
                cls = inAppPurchaseSkuDetailsWrapper4.skuDetailsParamsClazz;
            } catch (Throwable th6) {
                CrashShieldHandler.handleThrowable(inAppPurchaseSkuDetailsWrapper4, th6);
                cls = null;
            }
        }
        Method method10 = Headers.Companion.getMethod(cls4, "querySkuDetailsAsync", cls, cls9);
        Method method11 = Headers.Companion.getMethod(cls4, ehgOP.qCT, String.class, cls10);
        if (method5 == null || method6 == null || method7 == null || method8 == null || method9 == null || method10 == null || method11 == null) {
            return;
        }
        Class cls11 = Headers.Companion.getClass("com.android.billingclient.api.BillingClient$Builder");
        Class cls12 = Headers.Companion.getClass("com.android.billingclient.api.PurchasesUpdatedListener");
        if (cls11 == null || cls12 == null) {
            obj = null;
        } else {
            Method method12 = Headers.Companion.getMethod(cls4, "newBuilder", Context.class);
            Method method13 = Headers.Companion.getMethod(cls11, "enablePendingPurchases", new Class[0]);
            Method method14 = Headers.Companion.getMethod(cls11, "setListener", cls12);
            Method method15 = Headers.Companion.getMethod(cls11, "build", new Class[0]);
            if (method12 == null || method13 == null || method14 == null || method15 == null) {
                obj = null;
            } else {
                Object objInvokeMethod2 = Headers.Companion.invokeMethod(cls4, method12, null, context);
                if (objInvokeMethod2 != null) {
                    Object objInvokeMethod3 = Headers.Companion.invokeMethod(cls11, method14, objInvokeMethod2, Proxy.newProxyInstance(cls12.getClassLoader(), new Class[]{cls12}, new InAppPurchaseBillingClientWrapper.PurchasesUpdatedListenerWrapper(i)));
                    if (objInvokeMethod3 == null) {
                        obj = null;
                    } else {
                        Object objInvokeMethod4 = Headers.Companion.invokeMethod(cls11, method13, objInvokeMethod3, new Object[0]);
                        objInvokeMethod = objInvokeMethod4 == null ? null : Headers.Companion.invokeMethod(cls11, method15, objInvokeMethod4, new Object[0]);
                    }
                }
                obj = objInvokeMethod;
            }
        }
        if (obj == null) {
            return;
        }
        InAppPurchaseBillingClientWrapper inAppPurchaseBillingClientWrapper = new InAppPurchaseBillingClientWrapper(context, obj, cls4, cls6, cls5, cls7, cls8, cls9, cls10, method5, method6, method7, method8, method9, method10, method11, inAppPurchaseSkuDetailsWrapper4);
        if (!CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapper.class)) {
            try {
                InAppPurchaseBillingClientWrapper.instance = inAppPurchaseBillingClientWrapper;
            } catch (Throwable th7) {
                CrashShieldHandler.handleThrowable(InAppPurchaseBillingClientWrapper.class, th7);
            }
        }
        InAppPurchaseBillingClientWrapper inAppPurchaseBillingClientWrapperAccess$getInstance$cp = InAppPurchaseBillingClientWrapper.access$getInstance$cp();
        if (inAppPurchaseBillingClientWrapperAccess$getInstance$cp == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper");
        }
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapper.class)) {
            return;
        }
        try {
            inAppPurchaseBillingClientWrapperAccess$getInstance$cp.startConnection();
        } catch (Throwable th8) {
            CrashShieldHandler.handleThrowable(InAppPurchaseBillingClientWrapper.class, th8);
        }
    }

    public static ConcurrentHashMap getPurchaseDetailsMap() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapper.class)) {
            return null;
        }
        try {
            return InAppPurchaseBillingClientWrapper.purchaseDetailsMap;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(InAppPurchaseBillingClientWrapper.class, th);
            return null;
        }
    }

    public static AtomicBoolean isServiceConnected() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapper.class)) {
            return null;
        }
        try {
            return InAppPurchaseBillingClientWrapper.isServiceConnected;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(InAppPurchaseBillingClientWrapper.class, th);
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x002e A[Catch: all -> 0x0034, TRY_LEAVE, TryCatch #1 {, blocks: (B:10:0x0015, B:18:0x0028, B:20:0x002e, B:25:0x0036, B:32:0x0049, B:31:0x0046, B:17:0x0024, B:14:0x0020, B:28:0x0042), top: B:51:0x0015, outer: #3, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x0036 A[Catch: all -> 0x0034, TRY_ENTER, TRY_LEAVE, TryCatch #1 {, blocks: (B:10:0x0015, B:18:0x0028, B:20:0x002e, B:25:0x0036, B:32:0x0049, B:31:0x0046, B:17:0x0024, B:14:0x0020, B:28:0x0042), top: B:51:0x0015, outer: #3, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x0042 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static final void startIapLogging(Context context) {
        AtomicBoolean atomicBoolean;
        InAppPurchaseBillingClientWrapper inAppPurchaseBillingClientWrapperAccess$getInstance$cp;
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseAutoLogger.class)) {
            return;
        }
        try {
            if (Headers.Companion.getClass("com.android.billingclient.api.Purchase") == null) {
                return;
            }
            synchronized (InAppPurchaseBillingClientWrapper.Companion) {
                AtomicBoolean atomicBoolean2 = null;
                if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapper.class)) {
                    atomicBoolean = null;
                    if (atomicBoolean.get()) {
                        inAppPurchaseBillingClientWrapperAccess$getInstance$cp = InAppPurchaseBillingClientWrapper.access$getInstance$cp();
                    } else {
                        createInstance(context);
                        if (!CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapper.class)) {
                            try {
                                atomicBoolean2 = InAppPurchaseBillingClientWrapper.initialized;
                            } catch (Throwable th) {
                                CrashShieldHandler.handleThrowable(InAppPurchaseBillingClientWrapper.class, th);
                            }
                        }
                        atomicBoolean2.set(true);
                        inAppPurchaseBillingClientWrapperAccess$getInstance$cp = InAppPurchaseBillingClientWrapper.access$getInstance$cp();
                    }
                } else {
                    try {
                        atomicBoolean = InAppPurchaseBillingClientWrapper.initialized;
                    } catch (Throwable th2) {
                        CrashShieldHandler.handleThrowable(InAppPurchaseBillingClientWrapper.class, th2);
                        atomicBoolean = null;
                    }
                    if (atomicBoolean.get()) {
                        inAppPurchaseBillingClientWrapperAccess$getInstance$cp = InAppPurchaseBillingClientWrapper.access$getInstance$cp();
                    } else {
                        createInstance(context);
                        if (!CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapper.class)) {
                            atomicBoolean2 = InAppPurchaseBillingClientWrapper.initialized;
                        }
                        atomicBoolean2.set(true);
                        inAppPurchaseBillingClientWrapperAccess$getInstance$cp = InAppPurchaseBillingClientWrapper.access$getInstance$cp();
                    }
                }
                throw th;
            }
            if (inAppPurchaseBillingClientWrapperAccess$getInstance$cp != null && isServiceConnected().get()) {
                if (InAppPurchaseLoggerManager.eligibleQueryPurchaseHistory()) {
                    inAppPurchaseBillingClientWrapperAccess$getInstance$cp.queryPurchaseHistory(new AppEventQueue$$ExternalSyntheticLambda0(7));
                } else {
                    inAppPurchaseBillingClientWrapperAccess$getInstance$cp.queryPurchase(new AppEventQueue$$ExternalSyntheticLambda0(8));
                }
            }
        } catch (Throwable th3) {
            CrashShieldHandler.handleThrowable(InAppPurchaseAutoLogger.class, th3);
        }
    }

    public void logPurchase() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            InAppPurchaseLoggerManager inAppPurchaseLoggerManager = InAppPurchaseLoggerManager.INSTANCE;
            InAppPurchaseAutoLogger inAppPurchaseAutoLogger = InAppPurchaseBillingClientWrapper.Companion;
            ConcurrentHashMap purchaseDetailsMap = getPurchaseDetailsMap();
            ConcurrentHashMap concurrentHashMap = null;
            if (!CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapper.class)) {
                try {
                    concurrentHashMap = InAppPurchaseBillingClientWrapper.skuDetailsMap;
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(InAppPurchaseBillingClientWrapper.class, th);
                }
            }
            InAppPurchaseLoggerManager.filterPurchaseLogging(purchaseDetailsMap, concurrentHashMap);
            getPurchaseDetailsMap().clear();
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(this, th2);
        }
    }
}
