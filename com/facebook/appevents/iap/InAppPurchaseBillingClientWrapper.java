package com.facebook.appevents.iap;

import android.content.Context;
import com.facebook.GraphRequest$Companion$$ExternalSyntheticLambda1;
import com.facebook.appevents.AppEventQueue$$ExternalSyntheticLambda0;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.google.android.gms.ads.internal.offline.buffering.Dk.eoBKjVuj;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class InAppPurchaseBillingClientWrapper {
    public static InAppPurchaseBillingClientWrapper instance;
    public final Object billingClient;
    public final Class billingClientClazz;
    public final Context context;
    public final Method getOriginalJsonMethod;
    public final Method getOriginalJsonPurchaseHistoryMethod;
    public final Method getOriginalJsonSkuMethod;
    public final Method getPurchaseListMethod;
    public final CopyOnWriteArraySet historyPurchaseSet = new CopyOnWriteArraySet();
    public final InAppPurchaseSkuDetailsWrapper inAppPurchaseSkuDetailsWrapper;
    public final Class purchaseClazz;
    public final Class purchaseHistoryRecordClazz;
    public final Class purchaseHistoryResponseListenerClazz;
    public final Class purchaseResultClazz;
    public final Method queryPurchaseHistoryAsyncMethod;
    public final Method queryPurchasesMethod;
    public final Method querySkuDetailsAsyncMethod;
    public final Class skuDetailsClazz;
    public final Class skuDetailsResponseListenerClazz;
    public static final InAppPurchaseAutoLogger Companion = new InAppPurchaseAutoLogger();
    public static final AtomicBoolean initialized = new AtomicBoolean(false);
    public static final AtomicBoolean isServiceConnected = new AtomicBoolean(false);
    public static final ConcurrentHashMap purchaseDetailsMap = new ConcurrentHashMap();
    public static final ConcurrentHashMap skuDetailsMap = new ConcurrentHashMap();

    public final class PurchasesUpdatedListenerWrapper implements InvocationHandler {
        public final /* synthetic */ int $r8$classId;

        public /* synthetic */ PurchasesUpdatedListenerWrapper(int i) {
            this.$r8$classId = i;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object proxy, Method m, Object[] objArr) {
            switch (this.$r8$classId) {
                case 0:
                    if (!CrashShieldHandler.isObjectCrashing(this)) {
                        try {
                            Intrinsics.checkNotNullParameter(proxy, "proxy");
                            Intrinsics.checkNotNullParameter(m, "m");
                        } catch (Throwable th) {
                            CrashShieldHandler.handleThrowable(this, th);
                        }
                    }
                    break;
                default:
                    if (!CrashShieldHandler.isObjectCrashing(this)) {
                        try {
                            Intrinsics.checkNotNullParameter(proxy, "proxy");
                            Intrinsics.checkNotNullParameter(m, "m");
                            if (Intrinsics.areEqual(m.getName(), "onBillingSetupFinished")) {
                                InAppPurchaseAutoLogger inAppPurchaseAutoLogger = InAppPurchaseBillingClientWrapper.Companion;
                                InAppPurchaseAutoLogger.isServiceConnected().set(true);
                            } else {
                                String name = m.getName();
                                Intrinsics.checkNotNullExpressionValue(name, "m.name");
                                if (name.endsWith("onBillingServiceDisconnected")) {
                                    InAppPurchaseAutoLogger inAppPurchaseAutoLogger2 = InAppPurchaseBillingClientWrapper.Companion;
                                    InAppPurchaseAutoLogger.isServiceConnected().set(false);
                                }
                            }
                        } catch (Throwable th2) {
                            CrashShieldHandler.handleThrowable(this, th2);
                        }
                    }
                    break;
            }
            return null;
            return null;
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public final class SkuDetailsResponseListenerWrapper implements InvocationHandler {
        public final /* synthetic */ int $r8$classId = 1;
        public final Runnable runnable;
        public final /* synthetic */ InAppPurchaseBillingClientWrapper this$0;

        public SkuDetailsResponseListenerWrapper(InAppPurchaseBillingClientWrapper this$0, GraphRequest$Companion$$ExternalSyntheticLambda1 graphRequest$Companion$$ExternalSyntheticLambda1) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this.this$0 = this$0;
            this.runnable = graphRequest$Companion$$ExternalSyntheticLambda1;
        }

        public void getPurchaseHistoryRecord(List list) {
            Class cls;
            Method method;
            Context context;
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                for (Object obj : list) {
                    try {
                        boolean zIsObjectCrashing = CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapper.class);
                        InAppPurchaseBillingClientWrapper inAppPurchaseBillingClientWrapper = this.this$0;
                        CopyOnWriteArraySet copyOnWriteArraySet = null;
                        if (zIsObjectCrashing) {
                            cls = null;
                        } else {
                            try {
                                cls = inAppPurchaseBillingClientWrapper.purchaseHistoryRecordClazz;
                            } catch (Throwable th) {
                                CrashShieldHandler.handleThrowable(InAppPurchaseBillingClientWrapper.class, th);
                                cls = null;
                            }
                        }
                        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapper.class)) {
                            method = null;
                        } else {
                            try {
                                method = inAppPurchaseBillingClientWrapper.getOriginalJsonPurchaseHistoryMethod;
                            } catch (Throwable th2) {
                                CrashShieldHandler.handleThrowable(InAppPurchaseBillingClientWrapper.class, th2);
                                method = null;
                            }
                        }
                        Object objInvokeMethod = Headers.Companion.invokeMethod(cls, method, obj, new Object[0]);
                        String str = objInvokeMethod instanceof String ? (String) objInvokeMethod : null;
                        if (str != null) {
                            JSONObject jSONObject = new JSONObject(str);
                            if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapper.class)) {
                                context = null;
                            } else {
                                try {
                                    context = inAppPurchaseBillingClientWrapper.context;
                                } catch (Throwable th3) {
                                    CrashShieldHandler.handleThrowable(InAppPurchaseBillingClientWrapper.class, th3);
                                    context = null;
                                }
                            }
                            jSONObject.put("packageName", context.getPackageName());
                            if (jSONObject.has("productId")) {
                                String skuID = jSONObject.getString("productId");
                                if (!CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapper.class)) {
                                    try {
                                        copyOnWriteArraySet = inAppPurchaseBillingClientWrapper.historyPurchaseSet;
                                    } catch (Throwable th4) {
                                        CrashShieldHandler.handleThrowable(InAppPurchaseBillingClientWrapper.class, th4);
                                    }
                                }
                                copyOnWriteArraySet.add(skuID);
                                InAppPurchaseAutoLogger inAppPurchaseAutoLogger = InAppPurchaseBillingClientWrapper.Companion;
                                ConcurrentHashMap purchaseDetailsMap = InAppPurchaseAutoLogger.getPurchaseDetailsMap();
                                Intrinsics.checkNotNullExpressionValue(skuID, "skuID");
                                purchaseDetailsMap.put(skuID, jSONObject);
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
                ((GraphRequest$Companion$$ExternalSyntheticLambda1) this.runnable).run();
            } catch (Throwable th5) {
                CrashShieldHandler.handleThrowable(this, th5);
            }
        }

        public void parseSkuDetails(List list) {
            Class cls;
            Method method;
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                for (Object obj : list) {
                    try {
                        boolean zIsObjectCrashing = CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapper.class);
                        ConcurrentHashMap concurrentHashMap = null;
                        InAppPurchaseBillingClientWrapper inAppPurchaseBillingClientWrapper = this.this$0;
                        if (zIsObjectCrashing) {
                            cls = null;
                        } else {
                            try {
                                cls = inAppPurchaseBillingClientWrapper.skuDetailsClazz;
                            } catch (Throwable th) {
                                CrashShieldHandler.handleThrowable(InAppPurchaseBillingClientWrapper.class, th);
                                cls = null;
                            }
                        }
                        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapper.class)) {
                            method = null;
                        } else {
                            try {
                                method = inAppPurchaseBillingClientWrapper.getOriginalJsonSkuMethod;
                            } catch (Throwable th2) {
                                CrashShieldHandler.handleThrowable(InAppPurchaseBillingClientWrapper.class, th2);
                                method = null;
                            }
                        }
                        Object objInvokeMethod = Headers.Companion.invokeMethod(cls, method, obj, new Object[0]);
                        String str = objInvokeMethod instanceof String ? (String) objInvokeMethod : null;
                        if (str != null) {
                            JSONObject jSONObject = new JSONObject(str);
                            if (jSONObject.has("productId")) {
                                String skuID = jSONObject.getString("productId");
                                InAppPurchaseAutoLogger inAppPurchaseAutoLogger = InAppPurchaseBillingClientWrapper.Companion;
                                if (!CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapper.class)) {
                                    try {
                                        concurrentHashMap = InAppPurchaseBillingClientWrapper.skuDetailsMap;
                                    } catch (Throwable th3) {
                                        CrashShieldHandler.handleThrowable(InAppPurchaseBillingClientWrapper.class, th3);
                                    }
                                }
                                Intrinsics.checkNotNullExpressionValue(skuID, "skuID");
                                concurrentHashMap.put(skuID, jSONObject);
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
                this.runnable.run();
            } catch (Throwable th4) {
                CrashShieldHandler.handleThrowable(this, th4);
            }
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object proxy, Method m, Object[] objArr) {
            switch (this.$r8$classId) {
                case 0:
                    if (!CrashShieldHandler.isObjectCrashing(this)) {
                        try {
                            Intrinsics.checkNotNullParameter(proxy, "proxy");
                            Intrinsics.checkNotNullParameter(m, "m");
                            if (Intrinsics.areEqual(m.getName(), "onSkuDetailsResponse")) {
                                Object obj = objArr == null ? null : objArr[1];
                                if (obj != null && (obj instanceof List)) {
                                    parseSkuDetails((List) obj);
                                }
                            }
                        } catch (Throwable th) {
                            CrashShieldHandler.handleThrowable(this, th);
                        }
                    }
                    break;
                default:
                    if (!CrashShieldHandler.isObjectCrashing(this)) {
                        try {
                            Intrinsics.checkNotNullParameter(proxy, eoBKjVuj.LafsiN);
                            Intrinsics.checkNotNullParameter(m, "method");
                            if (Intrinsics.areEqual(m.getName(), "onPurchaseHistoryResponse")) {
                                Object obj2 = objArr == null ? null : objArr[1];
                                if (obj2 != null && (obj2 instanceof List)) {
                                    getPurchaseHistoryRecord((List) obj2);
                                }
                            }
                        } catch (Throwable th2) {
                            CrashShieldHandler.handleThrowable(this, th2);
                        }
                    }
                    break;
            }
            return null;
            return null;
        }

        public SkuDetailsResponseListenerWrapper(InAppPurchaseBillingClientWrapper this$0, Runnable runnable) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this.this$0 = this$0;
            this.runnable = runnable;
        }
    }

    public InAppPurchaseBillingClientWrapper(Context context, Object obj, Class cls, Class cls2, Class cls3, Class cls4, Class cls5, Class cls6, Class cls7, Method method, Method method2, Method method3, Method method4, Method method5, Method method6, Method method7, InAppPurchaseSkuDetailsWrapper inAppPurchaseSkuDetailsWrapper) {
        this.context = context;
        this.billingClient = obj;
        this.billingClientClazz = cls;
        this.purchaseResultClazz = cls2;
        this.purchaseClazz = cls3;
        this.skuDetailsClazz = cls4;
        this.purchaseHistoryRecordClazz = cls5;
        this.skuDetailsResponseListenerClazz = cls6;
        this.purchaseHistoryResponseListenerClazz = cls7;
        this.queryPurchasesMethod = method;
        this.getPurchaseListMethod = method2;
        this.getOriginalJsonMethod = method3;
        this.getOriginalJsonSkuMethod = method4;
        this.getOriginalJsonPurchaseHistoryMethod = method5;
        this.querySkuDetailsAsyncMethod = method6;
        this.queryPurchaseHistoryAsyncMethod = method7;
        this.inAppPurchaseSkuDetailsWrapper = inAppPurchaseSkuDetailsWrapper;
    }

    public static final /* synthetic */ InAppPurchaseBillingClientWrapper access$getInstance$cp() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapper.class)) {
            return null;
        }
        try {
            return instance;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(InAppPurchaseBillingClientWrapper.class, th);
            return null;
        }
    }

    public final void queryPurchase(AppEventQueue$$ExternalSyntheticLambda0 appEventQueue$$ExternalSyntheticLambda0) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Object objInvokeMethod = Headers.Companion.invokeMethod(this.purchaseResultClazz, this.getPurchaseListMethod, Headers.Companion.invokeMethod(this.billingClientClazz, this.queryPurchasesMethod, this.billingClient, "inapp"), new Object[0]);
            List list = objInvokeMethod instanceof List ? (List) objInvokeMethod : null;
            if (list == null) {
                return;
            }
            try {
                ArrayList arrayList = new ArrayList();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    Object objInvokeMethod2 = Headers.Companion.invokeMethod(this.purchaseClazz, this.getOriginalJsonMethod, it.next(), new Object[0]);
                    String str = objInvokeMethod2 instanceof String ? (String) objInvokeMethod2 : null;
                    if (str != null) {
                        JSONObject jSONObject = new JSONObject(str);
                        if (jSONObject.has("productId")) {
                            String skuID = jSONObject.getString("productId");
                            arrayList.add(skuID);
                            ConcurrentHashMap concurrentHashMap = purchaseDetailsMap;
                            Intrinsics.checkNotNullExpressionValue(skuID, "skuID");
                            concurrentHashMap.put(skuID, jSONObject);
                        }
                    }
                }
                querySkuDetailsAsync(arrayList, appEventQueue$$ExternalSyntheticLambda0);
            } catch (JSONException unused) {
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
        }
    }

    public final void queryPurchaseHistory(AppEventQueue$$ExternalSyntheticLambda0 appEventQueue$$ExternalSyntheticLambda0) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            GraphRequest$Companion$$ExternalSyntheticLambda1 graphRequest$Companion$$ExternalSyntheticLambda1 = new GraphRequest$Companion$$ExternalSyntheticLambda1(this, appEventQueue$$ExternalSyntheticLambda0, 17);
            Class cls = this.purchaseHistoryResponseListenerClazz;
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                Headers.Companion.invokeMethod(this.billingClientClazz, this.queryPurchaseHistoryAsyncMethod, this.billingClient, "inapp", Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new SkuDetailsResponseListenerWrapper(this, graphRequest$Companion$$ExternalSyntheticLambda1)));
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(this, th);
            }
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(this, th2);
        }
    }

    public final void querySkuDetailsAsync(ArrayList arrayList, Runnable runnable) {
        Class cls = this.skuDetailsResponseListenerClazz;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Object objNewProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new SkuDetailsResponseListenerWrapper(this, runnable));
            Headers.Companion.invokeMethod(this.billingClientClazz, this.querySkuDetailsAsyncMethod, this.billingClient, this.inAppPurchaseSkuDetailsWrapper.getSkuDetailsParams(arrayList), objNewProxyInstance);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
        }
    }

    public final void startConnection() {
        Method method;
        int i = 1;
        Class cls = this.billingClientClazz;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Class cls2 = Headers.Companion.getClass("com.android.billingclient.api.BillingClientStateListener");
            if (cls2 == null || (method = Headers.Companion.getMethod(cls, "startConnection", cls2)) == null) {
                return;
            }
            Headers.Companion.invokeMethod(cls, method, this.billingClient, Proxy.newProxyInstance(cls2.getClassLoader(), new Class[]{cls2}, new PurchasesUpdatedListenerWrapper(i)));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
        }
    }
}
