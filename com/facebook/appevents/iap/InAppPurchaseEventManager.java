package com.facebook.appevents.iap;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.Headers;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class InAppPurchaseEventManager {
    public static final InAppPurchaseEventManager INSTANCE = new InAppPurchaseEventManager();
    public static final HashMap methodMap = new HashMap();
    public static final HashMap classMap = new HashMap();
    public static final String PACKAGE_NAME = FacebookSdk.getApplicationContext().getPackageName();
    public static final SharedPreferences skuDetailSharedPrefs = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.internal.SKU_DETAILS", 0);
    public static final SharedPreferences purchaseInappSharedPrefs = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.internal.PURCHASE", 0);

    public static final ArrayList getPurchasesInapp(Context context, Object obj) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseEventManager.class)) {
            return null;
        }
        try {
            InAppPurchaseEventManager inAppPurchaseEventManager = INSTANCE;
            return inAppPurchaseEventManager.filterPurchases(inAppPurchaseEventManager.getPurchases(context, obj, "inapp"));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(InAppPurchaseEventManager.class, th);
            return null;
        }
    }

    public final ArrayList filterPurchases(ArrayList arrayList) {
        SharedPreferences sharedPreferences = purchaseInappSharedPrefs;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            ArrayList arrayList2 = new ArrayList();
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String string = jSONObject.getString("productId");
                    long j = jSONObject.getLong("purchaseTime");
                    String string2 = jSONObject.getString("purchaseToken");
                    if (jCurrentTimeMillis - (j / 1000) <= 86400 && !Intrinsics.areEqual(sharedPreferences.getString(string, ""), string2)) {
                        editorEdit.putString(string, string2);
                        arrayList2.add(str);
                    }
                } catch (JSONException unused) {
                }
            }
            editorEdit.apply();
            return arrayList2;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
            return null;
        }
    }

    public final Class getClass(Context context, String str) {
        Class<?> clsLoadClass;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        HashMap map = classMap;
        try {
            Class cls = (Class) map.get(str);
            if (cls != null) {
                return cls;
            }
            if (CrashShieldHandler.isObjectCrashing(Headers.Companion.class)) {
                clsLoadClass = null;
            } else {
                try {
                    clsLoadClass = context.getClassLoader().loadClass(str);
                } catch (ClassNotFoundException unused) {
                    clsLoadClass = null;
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(Headers.Companion.class, th);
                    clsLoadClass = null;
                }
            }
            if (clsLoadClass != null) {
                map.put(str, clsLoadClass);
            }
            return clsLoadClass;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(this, th2);
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:32:0x0090  */
    public final Method getMethod(Class cls, String str) {
        Class[] clsArr;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            HashMap map = methodMap;
            Method method = (Method) map.get(str);
            if (method != null) {
                return method;
            }
            switch (str) {
                case "getPurchases":
                    Class TYPE = Integer.TYPE;
                    Intrinsics.checkNotNullExpressionValue(TYPE, "TYPE");
                    clsArr = new Class[]{TYPE, String.class, String.class, String.class};
                    break;
                case "isBillingSupported":
                    Class TYPE2 = Integer.TYPE;
                    Intrinsics.checkNotNullExpressionValue(TYPE2, "TYPE");
                    clsArr = new Class[]{TYPE2, String.class, String.class};
                    break;
                case "asInterface":
                    clsArr = new Class[]{IBinder.class};
                    break;
                case "getPurchaseHistory":
                    Class TYPE3 = Integer.TYPE;
                    Intrinsics.checkNotNullExpressionValue(TYPE3, "TYPE");
                    clsArr = new Class[]{TYPE3, String.class, String.class, String.class, Bundle.class};
                    break;
                case "getSkuDetails":
                    Class TYPE4 = Integer.TYPE;
                    Intrinsics.checkNotNullExpressionValue(TYPE4, "TYPE");
                    clsArr = new Class[]{TYPE4, String.class, String.class, Bundle.class};
                    break;
                default:
                    clsArr = null;
                    break;
            }
            Method declaredMethod$facebook_core_release = clsArr == null ? Headers.Companion.getDeclaredMethod$facebook_core_release(cls, str, null) : Headers.Companion.getDeclaredMethod$facebook_core_release(cls, str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
            if (declaredMethod$facebook_core_release != null) {
                map.put(str, declaredMethod$facebook_core_release);
            }
            return declaredMethod$facebook_core_release;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0065  */
    public final ArrayList getPurchaseHistory(Context context, Object obj) {
        char c;
        ArrayList<String> stringArrayList;
        char c2;
        char c3 = 0;
        char c4 = 1;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            if (isBillingSupported(context, obj, "inapp")) {
                int i = 0;
                boolean z = false;
                String string = null;
                while (true) {
                    Bundle bundle = new Bundle();
                    Object[] objArr = new Object[5];
                    objArr[c3] = 6;
                    objArr[c4] = PACKAGE_NAME;
                    objArr[2] = "inapp";
                    objArr[3] = string;
                    objArr[4] = bundle;
                    Object objInvokeMethod = invokeMethod(context, "com.android.vending.billing.IInAppBillingService", "getPurchaseHistory", obj, objArr);
                    if (objInvokeMethod != null) {
                        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
                        Bundle bundle2 = (Bundle) objInvokeMethod;
                        if (bundle2.getInt("RESPONSE_CODE") != 0 || (stringArrayList = bundle2.getStringArrayList("INAPP_PURCHASE_DATA_LIST")) == null) {
                            c = c4;
                            string = null;
                        } else {
                            Iterator<String> it = stringArrayList.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    c = c4;
                                    break;
                                }
                                String next = it.next();
                                try {
                                    try {
                                        if (jCurrentTimeMillis - (new JSONObject(next).getLong("purchaseTime") / 1000) > 1200) {
                                            c = 1;
                                            z = true;
                                            break;
                                        }
                                        arrayList.add(next);
                                        c2 = 1;
                                        i++;
                                    } catch (JSONException unused) {
                                        c2 = 1;
                                    }
                                } catch (JSONException unused2) {
                                    c2 = c4;
                                }
                                c4 = c2;
                            }
                            string = bundle2.getString("INAPP_CONTINUATION_TOKEN");
                        }
                    } else {
                        c = c4;
                        string = null;
                    }
                    if (i >= 30 || string == null || z) {
                        break;
                    }
                    c4 = c;
                    c3 = 0;
                }
            }
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x005d  */
    /* JADX WARN: Code duplicated, block: B:24:0x0062 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:31:0x0064 A[EDGE_INSN: B:31:0x0064->B:25:0x0064 BREAK  A[LOOP:0: B:11:0x001a->B:33:?], SYNTHETIC] */
    public final ArrayList getPurchases(Context context, Object obj, String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            if (obj != null && isBillingSupported(context, obj, str)) {
                int size = 0;
                String string = null;
                do {
                    Object objInvokeMethod = invokeMethod(context, "com.android.vending.billing.IInAppBillingService", "getPurchases", obj, new Object[]{3, PACKAGE_NAME, str, string});
                    if (objInvokeMethod == null) {
                        string = null;
                        if (size < 30) {
                            break;
                            break;
                        }
                    } else {
                        Bundle bundle = (Bundle) objInvokeMethod;
                        if (bundle.getInt("RESPONSE_CODE") == 0) {
                            ArrayList<String> stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                            if (stringArrayList == null) {
                                break;
                            }
                            size += stringArrayList.size();
                            arrayList.addAll(stringArrayList);
                            string = bundle.getString("INAPP_CONTINUATION_TOKEN");
                        } else {
                            string = null;
                        }
                        if (size < 30) {
                            break;
                        }
                    }
                } while (string != null);
            }
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
            return null;
        }
    }

    public final LinkedHashMap getSkuDetailsFromGoogle(Context context, ArrayList arrayList, Object obj, boolean z) {
        int size;
        int i = 0;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (obj != null && !arrayList.isEmpty()) {
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("ITEM_ID_LIST", arrayList);
                Object objInvokeMethod = invokeMethod(context, "com.android.vending.billing.IInAppBillingService", "getSkuDetails", obj, new Object[]{3, PACKAGE_NAME, z ? "subs" : "inapp", bundle});
                if (objInvokeMethod != null) {
                    Bundle bundle2 = (Bundle) objInvokeMethod;
                    if (bundle2.getInt("RESPONSE_CODE") == 0) {
                        ArrayList<String> stringArrayList = bundle2.getStringArrayList("DETAILS_LIST");
                        if (stringArrayList != null && arrayList.size() == stringArrayList.size() && (size = arrayList.size() - 1) >= 0) {
                            while (true) {
                                int i2 = i + 1;
                                Object obj2 = arrayList.get(i);
                                Intrinsics.checkNotNullExpressionValue(obj2, "skuList[i]");
                                String str = stringArrayList.get(i);
                                Intrinsics.checkNotNullExpressionValue(str, "skuDetailsList[i]");
                                linkedHashMap.put(obj2, str);
                                if (i2 > size) {
                                    break;
                                }
                                i = i2;
                            }
                        }
                        writeSkuDetailsToCache(linkedHashMap);
                    }
                }
            }
            return linkedHashMap;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
            return null;
        }
    }

    public final Object invokeMethod(Context context, String str, String str2, Object obj, Object[] objArr) {
        Method method;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Class cls = getClass(context, str);
            if (cls == null || (method = getMethod(cls, str2)) == null) {
                return null;
            }
            return Headers.Companion.invokeMethod(cls, method, obj, Arrays.copyOf(objArr, objArr.length));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
            return null;
        }
    }

    public final boolean isBillingSupported(Context context, Object obj, String str) {
        if (CrashShieldHandler.isObjectCrashing(this) || obj == null) {
            return false;
        }
        try {
            Object objInvokeMethod = invokeMethod(context, "com.android.vending.billing.IInAppBillingService", "isBillingSupported", obj, new Object[]{3, PACKAGE_NAME, str});
            return objInvokeMethod != null && ((Integer) objInvokeMethod).intValue() == 0;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
            return false;
        }
    }

    public final LinkedHashMap readSkuDetailsFromCache(ArrayList arrayList) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String sku = (String) it.next();
                String string = skuDetailSharedPrefs.getString(sku, null);
                if (string != null) {
                    List listSplit$default = StringsKt__StringsKt.split$default(string, new String[]{";"}, 2, 2);
                    if (jCurrentTimeMillis - Long.parseLong((String) listSplit$default.get(0)) < 43200) {
                        Intrinsics.checkNotNullExpressionValue(sku, "sku");
                        linkedHashMap.put(sku, listSplit$default.get(1));
                    } else {
                        continue;
                    }
                }
            }
            return linkedHashMap;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
            return null;
        }
    }

    public final void writeSkuDetailsToCache(LinkedHashMap linkedHashMap) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            SharedPreferences.Editor editorEdit = skuDetailSharedPrefs.edit();
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                editorEdit.putString((String) entry.getKey(), jCurrentTimeMillis + ';' + ((String) entry.getValue()));
            }
            editorEdit.apply();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
        }
    }
}
