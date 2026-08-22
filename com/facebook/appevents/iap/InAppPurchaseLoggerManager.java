package com.facebook.appevents.iap;

import android.content.SharedPreferences;
import com.facebook.FacebookSdk;
import com.facebook.appevents.internal.AutomaticAnalyticsLogger;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class InAppPurchaseLoggerManager {
    public static SharedPreferences sharedPreferences;
    public static final InAppPurchaseLoggerManager INSTANCE = new InAppPurchaseLoggerManager();
    public static final CopyOnWriteArraySet cachedPurchaseSet = new CopyOnWriteArraySet();
    public static final ConcurrentHashMap cachedPurchaseMap = new ConcurrentHashMap();

    public static final boolean eligibleQueryPurchaseHistory() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseLoggerManager.class)) {
            return false;
        }
        try {
            INSTANCE.readPurchaseCache();
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            SharedPreferences sharedPreferences2 = sharedPreferences;
            if (sharedPreferences2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                throw null;
            }
            long j = sharedPreferences2.getLong("LAST_QUERY_PURCHASE_HISTORY_TIME", 0L);
            if (j != 0 && jCurrentTimeMillis - j < 86400) {
                return false;
            }
            SharedPreferences sharedPreferences3 = sharedPreferences;
            if (sharedPreferences3 != null) {
                sharedPreferences3.edit().putLong("LAST_QUERY_PURCHASE_HISTORY_TIME", jCurrentTimeMillis).apply();
                return true;
            }
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
            throw null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(InAppPurchaseLoggerManager.class, th);
            return false;
        }
    }

    public static final void filterPurchaseLogging(ConcurrentHashMap purchaseDetailsMap, ConcurrentHashMap skuDetailsMap) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseLoggerManager.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(purchaseDetailsMap, "purchaseDetailsMap");
            Intrinsics.checkNotNullParameter(skuDetailsMap, "skuDetailsMap");
            InAppPurchaseLoggerManager inAppPurchaseLoggerManager = INSTANCE;
            inAppPurchaseLoggerManager.readPurchaseCache();
            LinkedHashMap linkedHashMapConstructLoggingReadyMap$facebook_core_release = inAppPurchaseLoggerManager.constructLoggingReadyMap$facebook_core_release(inAppPurchaseLoggerManager.cacheDeDupPurchase$facebook_core_release(purchaseDetailsMap), skuDetailsMap);
            if (CrashShieldHandler.isObjectCrashing(inAppPurchaseLoggerManager)) {
                return;
            }
            try {
                for (Map.Entry entry : linkedHashMapConstructLoggingReadyMap$facebook_core_release.entrySet()) {
                    String str = (String) entry.getKey();
                    String str2 = (String) entry.getValue();
                    if (str != null && str2 != null) {
                        AutomaticAnalyticsLogger.logPurchase(str, str2, false);
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(inAppPurchaseLoggerManager, th);
            }
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(InAppPurchaseLoggerManager.class, th2);
        }
    }

    public final HashMap cacheDeDupPurchase$facebook_core_release(ConcurrentHashMap purchaseDetailsMap) {
        CopyOnWriteArraySet copyOnWriteArraySet;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(purchaseDetailsMap, "purchaseDetailsMap");
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            Iterator it = MapsKt__MapsKt.toMap(purchaseDetailsMap).entrySet().iterator();
            while (true) {
                boolean zHasNext = it.hasNext();
                copyOnWriteArraySet = cachedPurchaseSet;
                if (!zHasNext) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                String str = (String) entry.getKey();
                JSONObject jSONObject = (JSONObject) entry.getValue();
                try {
                    if (jSONObject.has("purchaseToken")) {
                        String string = jSONObject.getString("purchaseToken");
                        if (cachedPurchaseMap.containsKey(string)) {
                            purchaseDetailsMap.remove(str);
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append((Object) string);
                            sb.append(';');
                            sb.append(jCurrentTimeMillis);
                            copyOnWriteArraySet.add(sb.toString());
                        }
                    }
                } catch (Exception unused) {
                }
            }
            SharedPreferences sharedPreferences2 = sharedPreferences;
            if (sharedPreferences2 != null) {
                sharedPreferences2.edit().putStringSet("PURCHASE_DETAILS_SET", copyOnWriteArraySet).apply();
                return new HashMap(purchaseDetailsMap);
            }
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
            throw null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
            return null;
        }
    }

    public final void clearOutdatedProductInfoInCache$facebook_core_release() {
        CopyOnWriteArraySet copyOnWriteArraySet;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            SharedPreferences sharedPreferences2 = sharedPreferences;
            if (sharedPreferences2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                throw null;
            }
            long j = sharedPreferences2.getLong("LAST_CLEARED_TIME", 0L);
            if (j == 0) {
                SharedPreferences sharedPreferences3 = sharedPreferences;
                if (sharedPreferences3 != null) {
                    sharedPreferences3.edit().putLong("LAST_CLEARED_TIME", jCurrentTimeMillis).apply();
                    return;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                    throw null;
                }
            }
            if (jCurrentTimeMillis - j > 604800) {
                ConcurrentHashMap concurrentHashMap = cachedPurchaseMap;
                Iterator it = MapsKt__MapsKt.toMap(concurrentHashMap).entrySet().iterator();
                while (true) {
                    boolean zHasNext = it.hasNext();
                    copyOnWriteArraySet = cachedPurchaseSet;
                    if (!zHasNext) {
                        break;
                    }
                    Map.Entry entry = (Map.Entry) it.next();
                    String str = (String) entry.getKey();
                    long jLongValue = ((Number) entry.getValue()).longValue();
                    if (jCurrentTimeMillis - jLongValue > 86400) {
                        copyOnWriteArraySet.remove(str + ';' + jLongValue);
                        concurrentHashMap.remove(str);
                    }
                }
                SharedPreferences sharedPreferences4 = sharedPreferences;
                if (sharedPreferences4 != null) {
                    sharedPreferences4.edit().putStringSet("PURCHASE_DETAILS_SET", copyOnWriteArraySet).putLong("LAST_CLEARED_TIME", jCurrentTimeMillis).apply();
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                    throw null;
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
        }
    }

    public final LinkedHashMap constructLoggingReadyMap$facebook_core_release(HashMap purchaseDetailsMap, ConcurrentHashMap skuDetailsMap) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(purchaseDetailsMap, "purchaseDetailsMap");
            Intrinsics.checkNotNullParameter(skuDetailsMap, "skuDetailsMap");
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : purchaseDetailsMap.entrySet()) {
                String str = (String) entry.getKey();
                JSONObject jSONObject = (JSONObject) entry.getValue();
                JSONObject jSONObject2 = (JSONObject) skuDetailsMap.get(str);
                if (jSONObject != null && jSONObject.has("purchaseTime")) {
                    try {
                        if (jCurrentTimeMillis - (jSONObject.getLong("purchaseTime") / 1000) <= 86400 && jSONObject2 != null) {
                            String string = jSONObject.toString();
                            Intrinsics.checkNotNullExpressionValue(string, "purchaseDetail.toString()");
                            String string2 = jSONObject2.toString();
                            Intrinsics.checkNotNullExpressionValue(string2, "skuDetail.toString()");
                            linkedHashMap.put(string, string2);
                        }
                    } catch (Exception unused) {
                    }
                }
            }
            return linkedHashMap;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
            return null;
        }
    }

    public final void readPurchaseCache() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            SharedPreferences sharedPreferences2 = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.internal.SKU_DETAILS", 0);
            SharedPreferences sharedPreferences3 = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.internal.PURCHASE", 0);
            if (sharedPreferences2.contains("LAST_CLEARED_TIME")) {
                sharedPreferences2.edit().clear().apply();
                sharedPreferences3.edit().clear().apply();
            }
            SharedPreferences sharedPreferences4 = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.internal.iap.PRODUCT_DETAILS", 0);
            Intrinsics.checkNotNullExpressionValue(sharedPreferences4, "getApplicationContext().getSharedPreferences(PRODUCT_DETAILS_STORE, Context.MODE_PRIVATE)");
            sharedPreferences = sharedPreferences4;
            CopyOnWriteArraySet copyOnWriteArraySet = cachedPurchaseSet;
            Set<String> stringSet = sharedPreferences4.getStringSet("PURCHASE_DETAILS_SET", new HashSet());
            if (stringSet == null) {
                stringSet = new HashSet<>();
            }
            copyOnWriteArraySet.addAll(stringSet);
            Iterator it = copyOnWriteArraySet.iterator();
            while (it.hasNext()) {
                List listSplit$default = StringsKt__StringsKt.split$default((String) it.next(), new String[]{";"}, 2, 2);
                cachedPurchaseMap.put(listSplit$default.get(0), Long.valueOf(Long.parseLong((String) listSplit$default.get(1))));
            }
            clearOutdatedProductInfoInCache$facebook_core_release();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
        }
    }
}
