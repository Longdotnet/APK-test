package com.facebook.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import com.facebook.AccessTokenManager$$ExternalSyntheticLambda0;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.internal.gatekeeper.GateKeeper;
import com.google.android.gms.ads.internal.offline.buffering.Dk.eoBKjVuj;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FetchedAppGateKeepersManager {
    public static final ConcurrentLinkedQueue callbacks;
    public static final ConcurrentHashMap fetchedAppGateKeepers;
    public static Fragment.AnonymousClass7 gateKeeperRuntimeCache;
    public static final AtomicBoolean isLoading;
    public static Long timestamp;

    static {
        String str;
        Reflection.factory.getClass();
        new ClassReference(FetchedAppGateKeepersManager.class);
        if (!FetchedAppGateKeepersManager.class.isAnonymousClass()) {
            if (FetchedAppGateKeepersManager.class.isLocalClass()) {
                String simpleName = FetchedAppGateKeepersManager.class.getSimpleName();
                Method enclosingMethod = FetchedAppGateKeepersManager.class.getEnclosingMethod();
                if (enclosingMethod != null) {
                    StringsKt__StringsKt.substringAfter$default(simpleName, enclosingMethod.getName() + '$');
                } else {
                    Constructor<?> enclosingConstructor = FetchedAppGateKeepersManager.class.getEnclosingConstructor();
                    if (enclosingConstructor != null) {
                        StringsKt__StringsKt.substringAfter$default(simpleName, enclosingConstructor.getName() + '$');
                    } else {
                        int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) simpleName, '$', 0, false, 6);
                        if (iIndexOf$default != -1) {
                            Intrinsics.checkNotNullExpressionValue(simpleName.substring(iIndexOf$default + 1, simpleName.length()), "this as java.lang.String…ing(startIndex, endIndex)");
                        }
                    }
                }
            } else {
                boolean zIsArray = FetchedAppGateKeepersManager.class.isArray();
                LinkedHashMap linkedHashMap = ClassReference.simpleNames;
                if (zIsArray) {
                    Class<?> componentType = FetchedAppGateKeepersManager.class.getComponentType();
                    if (componentType.isPrimitive() && (str = (String) linkedHashMap.get(componentType.getName())) != null) {
                        str.concat("Array");
                    }
                }
            }
        }
        isLoading = new AtomicBoolean(false);
        callbacks = new ConcurrentLinkedQueue();
        fetchedAppGateKeepers = new ConcurrentHashMap();
    }

    public static JSONObject getAppGateKeepersQueryResponse() {
        Bundle bundle = new Bundle();
        bundle.putString("platform", "android");
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        bundle.putString("sdk_version", "16.0.0");
        bundle.putString("fields", "gatekeepers");
        String str = GraphRequest.MIME_BOUNDARY;
        GraphRequest graphRequestNewGraphPathRequest = GraphRequest.Companion.newGraphPathRequest(null, String.format("app/%s", Arrays.copyOf(new Object[]{"mobile_sdk_gk"}, 1)), null);
        graphRequestNewGraphPathRequest.parameters = bundle;
        JSONObject jSONObject = graphRequestNewGraphPathRequest.executeAndWait().jsonObject;
        return jSONObject == null ? new JSONObject() : jSONObject;
    }

    public static final boolean getGateKeeperForKey(String name, String str, boolean z) {
        HashMap map;
        ConcurrentHashMap concurrentHashMap;
        Boolean bool;
        Intrinsics.checkNotNullParameter(name, "name");
        ArrayList<GateKeeper> arrayList = null;
        loadAppGateKeepersAsync(null);
        ConcurrentHashMap concurrentHashMap2 = fetchedAppGateKeepers;
        if (concurrentHashMap2.containsKey(str)) {
            Fragment.AnonymousClass7 anonymousClass7 = gateKeeperRuntimeCache;
            if (anonymousClass7 != null && (concurrentHashMap = (ConcurrentHashMap) ((ConcurrentHashMap) anonymousClass7.this$0).get(str)) != null) {
                arrayList = new ArrayList(concurrentHashMap.size());
                Iterator it = concurrentHashMap.entrySet().iterator();
                while (it.hasNext()) {
                    arrayList.add((GateKeeper) ((Map.Entry) it.next()).getValue());
                }
            }
            if (arrayList != null) {
                map = new HashMap();
                for (GateKeeper gateKeeper : arrayList) {
                    map.put(gateKeeper.name, Boolean.valueOf(gateKeeper.value));
                }
            } else {
                HashMap map2 = new HashMap();
                JSONObject jSONObject = (JSONObject) concurrentHashMap2.get(str);
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                Iterator itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String key = (String) itKeys.next();
                    Intrinsics.checkNotNullExpressionValue(key, "key");
                    map2.put(key, Boolean.valueOf(jSONObject.optBoolean(key)));
                }
                Fragment.AnonymousClass7 anonymousClass8 = gateKeeperRuntimeCache;
                if (anonymousClass8 == null) {
                    anonymousClass8 = new Fragment.AnonymousClass7();
                }
                ArrayList<GateKeeper> arrayList2 = new ArrayList(map2.size());
                for (Map.Entry entry : map2.entrySet()) {
                    arrayList2.add(new GateKeeper((String) entry.getKey(), ((Boolean) entry.getValue()).booleanValue()));
                }
                ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
                for (GateKeeper gateKeeper2 : arrayList2) {
                    concurrentHashMap3.put(gateKeeper2.name, gateKeeper2);
                }
                ((ConcurrentHashMap) anonymousClass8.this$0).put(str, concurrentHashMap3);
                gateKeeperRuntimeCache = anonymousClass8;
                map = map2;
            }
        } else {
            map = new HashMap();
        }
        return (map.containsKey(name) && (bool = (Boolean) map.get(name)) != null) ? bool.booleanValue() : z;
    }

    public static final synchronized void loadAppGateKeepersAsync(FeatureManager.AnonymousClass1 anonymousClass1) {
        if (anonymousClass1 != null) {
            try {
                callbacks.add(anonymousClass1);
            } catch (Throwable th) {
                throw th;
            }
        }
        String applicationId = FacebookSdk.getApplicationId();
        Long l = timestamp;
        if (l != null && System.currentTimeMillis() - l.longValue() < 3600000 && fetchedAppGateKeepers.containsKey(applicationId)) {
            pollCallbacks();
            return;
        }
        Context applicationContext = FacebookSdk.getApplicationContext();
        String str = String.format("com.facebook.internal.APP_GATEKEEPERS.%s", Arrays.copyOf(new Object[]{applicationId}, 1));
        JSONObject jSONObject = null;
        String string = applicationContext.getSharedPreferences("com.facebook.internal.preferences.APP_GATEKEEPERS", 0).getString(str, null);
        if (!Utility.isNullOrEmpty(string)) {
            try {
                jSONObject = new JSONObject(string);
            } catch (JSONException unused) {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            }
            if (jSONObject != null) {
                parseAppGateKeepersFromJSON$facebook_core_release(applicationId, jSONObject);
            }
        }
        Executor executor = FacebookSdk.getExecutor();
        if (isLoading.compareAndSet(false, true)) {
            executor.execute(new FetchedAppSettingsManager$$ExternalSyntheticLambda0(applicationId, applicationContext, str));
        }
    }

    public static void pollCallbacks() {
        Handler handler = new Handler(Looper.getMainLooper());
        while (true) {
            ConcurrentLinkedQueue concurrentLinkedQueue = callbacks;
            if (concurrentLinkedQueue.isEmpty()) {
                return;
            }
            FeatureManager.AnonymousClass1 anonymousClass1 = (FeatureManager.AnonymousClass1) concurrentLinkedQueue.poll();
            if (anonymousClass1 != null) {
                handler.post(new AccessTokenManager$$ExternalSyntheticLambda0(anonymousClass1, 12));
            }
        }
    }

    public static final synchronized JSONObject parseAppGateKeepersFromJSON$facebook_core_release(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        try {
            jSONObject2 = (JSONObject) fetchedAppGateKeepers.get(str);
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("data");
            int i = 0;
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray == null ? null : jSONArrayOptJSONArray.optJSONObject(0);
            if (jSONObjectOptJSONObject == null) {
                jSONObjectOptJSONObject = new JSONObject();
            }
            JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("gatekeepers");
            if (jSONArrayOptJSONArray2 == null) {
                jSONArrayOptJSONArray2 = new JSONArray();
            }
            int length = jSONArrayOptJSONArray2.length();
            if (length > 0) {
                while (true) {
                    int i2 = i + 1;
                    try {
                        JSONObject jSONObject3 = jSONArrayOptJSONArray2.getJSONObject(i);
                        jSONObject2.put(jSONObject3.getString(eoBKjVuj.JSCu), jSONObject3.getBoolean(FirebaseAnalytics.Param.VALUE));
                    } catch (JSONException unused) {
                        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                    }
                    if (i2 >= length) {
                        break;
                    }
                    i = i2;
                }
            }
            fetchedAppGateKeepers.put(str, jSONObject2);
        } catch (Throwable th) {
            throw th;
        }
        return jSONObject2;
    }
}
