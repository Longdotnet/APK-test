package com.facebook.appevents.restrictivedatafilter;

import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class RestrictiveDataManager {
    public static boolean enabled;
    public static final RestrictiveDataManager INSTANCE = new RestrictiveDataManager();
    public static final ArrayList restrictiveParamFilters = new ArrayList();
    public static final CopyOnWriteArraySet restrictedEvents = new CopyOnWriteArraySet();

    public final class RestrictiveParamFilter {
        public String eventName;
        public HashMap restrictiveParams;
    }

    public final String getMatchedRuleType(String str, String str2) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            try {
                for (RestrictiveParamFilter restrictiveParamFilter : new ArrayList(restrictiveParamFilters)) {
                    if (restrictiveParamFilter != null && Intrinsics.areEqual(str, restrictiveParamFilter.eventName)) {
                        for (String str3 : restrictiveParamFilter.restrictiveParams.keySet()) {
                            if (Intrinsics.areEqual(str2, str3)) {
                                return (String) restrictiveParamFilter.restrictiveParams.get(str3);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                Log.w("com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager", "getMatchedRuleType failed", e);
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
            return null;
        }
    }

    public final void initialize() {
        String str;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
            FetchedAppSettings fetchedAppSettingsQueryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
            if (fetchedAppSettingsQueryAppSettings != null && (str = fetchedAppSettingsQueryAppSettings.restrictiveDataSetting) != null && str.length() != 0) {
                JSONObject jSONObject = new JSONObject(str);
                ArrayList arrayList = restrictiveParamFilters;
                arrayList.clear();
                CopyOnWriteArraySet copyOnWriteArraySet = restrictedEvents;
                copyOnWriteArraySet.clear();
                Iterator itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String key = (String) itKeys.next();
                    JSONObject jSONObject2 = jSONObject.getJSONObject(key);
                    if (jSONObject2 != null) {
                        JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("restrictive_param");
                        Intrinsics.checkNotNullExpressionValue(key, "key");
                        HashMap map = new HashMap();
                        RestrictiveParamFilter restrictiveParamFilter = new RestrictiveParamFilter();
                        restrictiveParamFilter.eventName = key;
                        restrictiveParamFilter.restrictiveParams = map;
                        if (jSONObjectOptJSONObject != null) {
                            restrictiveParamFilter.restrictiveParams = Utility.convertJSONObjectToStringMap(jSONObjectOptJSONObject);
                            arrayList.add(restrictiveParamFilter);
                        }
                        if (jSONObject2.has("process_event_name")) {
                            copyOnWriteArraySet.add(key);
                        }
                    }
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
        }
    }
}
