package com.facebook.appevents.iap;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.fragment.app.Fragment;
import com.facebook.FacebookSdk;
import com.facebook.UserSettingsManager;
import com.facebook.appevents.internal.AutomaticAnalyticsLogger;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.google.android.gms.games.provider.NtJ.wsbWxekY;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class InAppPurchaseActivityLifecycleTracker {
    public static InAppPurchaseActivityLifecycleTracker$initializeIfNotInitialized$2 callbacks;
    public static Boolean hasBillingActivity;
    public static Boolean hasBillingService;
    public static Object inAppBillingObj;
    public static Intent intent;
    public static final AtomicBoolean isTracking = new AtomicBoolean(false);
    public static InAppPurchaseActivityLifecycleTracker$initializeIfNotInitialized$1 serviceConnection;

    public static final void access$logPurchase(Context context, ArrayList arrayList, boolean z) {
        if (arrayList.isEmpty()) {
            return;
        }
        HashMap map = new HashMap();
        ArrayList<String> arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String purchase = (String) it.next();
            try {
                String sku = new JSONObject(purchase).getString("productId");
                Intrinsics.checkNotNullExpressionValue(sku, "sku");
                Intrinsics.checkNotNullExpressionValue(purchase, "purchase");
                map.put(sku, purchase);
                arrayList2.add(sku);
            } catch (JSONException e) {
                Log.e("com.facebook.appevents.iap.InAppPurchaseActivityLifecycleTracker", "Error parsing in-app purchase data.", e);
            }
        }
        InAppPurchaseEventManager inAppPurchaseEventManager = InAppPurchaseEventManager.INSTANCE;
        Object obj = inAppBillingObj;
        LinkedHashMap linkedHashMap = null;
        if (!CrashShieldHandler.isObjectCrashing(InAppPurchaseEventManager.class)) {
            InAppPurchaseEventManager inAppPurchaseEventManager2 = InAppPurchaseEventManager.INSTANCE;
            try {
                LinkedHashMap skuDetailsFromCache = inAppPurchaseEventManager2.readSkuDetailsFromCache(arrayList2);
                ArrayList arrayList3 = new ArrayList();
                for (String str : arrayList2) {
                    if (!skuDetailsFromCache.containsKey(str)) {
                        arrayList3.add(str);
                    }
                }
                skuDetailsFromCache.putAll(inAppPurchaseEventManager2.getSkuDetailsFromGoogle(context, arrayList3, obj, z));
                linkedHashMap = skuDetailsFromCache;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(InAppPurchaseEventManager.class, th);
            }
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String str2 = (String) entry.getKey();
            String str3 = (String) entry.getValue();
            String str4 = (String) map.get(str2);
            if (str4 != null) {
                AutomaticAnalyticsLogger.logPurchase(str4, str3, z);
            }
        }
    }

    public static final void startIapLogging() {
        if (hasBillingService == null) {
            Boolean boolValueOf = Boolean.valueOf(Headers.Companion.getClass("com.android.vending.billing.IInAppBillingService$Stub") != null);
            hasBillingService = boolValueOf;
            if (!boolValueOf.equals(Boolean.FALSE)) {
                hasBillingActivity = Boolean.valueOf(Headers.Companion.getClass(wsbWxekY.DtnspgjjRCUVV) != null);
                InAppPurchaseEventManager inAppPurchaseEventManager = InAppPurchaseEventManager.INSTANCE;
                if (!CrashShieldHandler.isObjectCrashing(InAppPurchaseEventManager.class)) {
                    try {
                        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
                        SharedPreferences sharedPreferences = InAppPurchaseEventManager.skuDetailSharedPrefs;
                        long j = sharedPreferences.getLong("LAST_CLEARED_TIME", 0L);
                        if (j == 0) {
                            sharedPreferences.edit().putLong("LAST_CLEARED_TIME", jCurrentTimeMillis).apply();
                        } else if (jCurrentTimeMillis - j > 604800) {
                            sharedPreferences.edit().clear().putLong("LAST_CLEARED_TIME", jCurrentTimeMillis).apply();
                        }
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(InAppPurchaseEventManager.class, th);
                    }
                }
                Intent intent2 = new Intent("com.android.vending.billing.InAppBillingService.BIND").setPackage("com.android.vending");
                Intrinsics.checkNotNullExpressionValue(intent2, "Intent(\"com.android.vending.billing.InAppBillingService.BIND\")\n            .setPackage(\"com.android.vending\")");
                intent = intent2;
                serviceConnection = new InAppPurchaseActivityLifecycleTracker$initializeIfNotInitialized$1();
                callbacks = new InAppPurchaseActivityLifecycleTracker$initializeIfNotInitialized$2();
            }
        }
        if (Intrinsics.areEqual(hasBillingService, Boolean.FALSE)) {
            return;
        }
        Fragment.AnonymousClass7 anonymousClass7 = AutomaticAnalyticsLogger.internalAppEventsLogger;
        FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
        if (appSettingsWithoutQuery != null && UserSettingsManager.getAutoLogAppEventsEnabled() && appSettingsWithoutQuery.iAPAutomaticLoggingEnabled && isTracking.compareAndSet(false, true)) {
            Context applicationContext = FacebookSdk.getApplicationContext();
            if (applicationContext instanceof Application) {
                Application application = (Application) applicationContext;
                InAppPurchaseActivityLifecycleTracker$initializeIfNotInitialized$2 inAppPurchaseActivityLifecycleTracker$initializeIfNotInitialized$2 = callbacks;
                if (inAppPurchaseActivityLifecycleTracker$initializeIfNotInitialized$2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("callbacks");
                    throw null;
                }
                application.registerActivityLifecycleCallbacks(inAppPurchaseActivityLifecycleTracker$initializeIfNotInitialized$2);
                Intent intent3 = intent;
                if (intent3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("intent");
                    throw null;
                }
                InAppPurchaseActivityLifecycleTracker$initializeIfNotInitialized$1 inAppPurchaseActivityLifecycleTracker$initializeIfNotInitialized$1 = serviceConnection;
                if (inAppPurchaseActivityLifecycleTracker$initializeIfNotInitialized$1 != null) {
                    applicationContext.bindService(intent3, inAppPurchaseActivityLifecycleTracker$initializeIfNotInitialized$1, 1);
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("serviceConnection");
                    throw null;
                }
            }
        }
    }
}
