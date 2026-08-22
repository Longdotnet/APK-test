package com.facebook.appevents.eventdeactivation;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEvent;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.google.android.gms.auth.IJ.gZrKCJ;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class EventDeactivationManager {
    public static boolean enabled;
    public static final EventDeactivationManager INSTANCE = new EventDeactivationManager();
    public static final ArrayList deprecatedParamFilters = new ArrayList();
    public static final HashSet deprecatedEvents = new HashSet();

    /* JADX INFO: loaded from: classes.dex */
    public final class DeprecatedParamFilter {
        public ArrayList deprecateParams;
        public String eventName;
    }

    public static final void processEvents(ArrayList events) {
        if (CrashShieldHandler.isObjectCrashing(EventDeactivationManager.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(events, "events");
            if (enabled) {
                Iterator it = events.iterator();
                while (it.hasNext()) {
                    if (deprecatedEvents.contains(((AppEvent) it.next()).name)) {
                        it.remove();
                    }
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(EventDeactivationManager.class, th);
        }
    }

    public final synchronized void initialize() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
            FetchedAppSettings fetchedAppSettingsQueryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
            if (fetchedAppSettingsQueryAppSettings == null) {
                return;
            }
            String str = fetchedAppSettingsQueryAppSettings.restrictiveDataSetting;
            if (str != null && str.length() > 0) {
                JSONObject jSONObject = new JSONObject(str);
                deprecatedParamFilters.clear();
                Iterator itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String key = (String) itKeys.next();
                    JSONObject jSONObject2 = jSONObject.getJSONObject(key);
                    if (jSONObject2 != null) {
                        if (jSONObject2.optBoolean(gZrKCJ.mBvY)) {
                            HashSet hashSet = deprecatedEvents;
                            Intrinsics.checkNotNullExpressionValue(key, "key");
                            hashSet.add(key);
                        } else {
                            JSONArray jSONArrayOptJSONArray = jSONObject2.optJSONArray("deprecated_param");
                            Intrinsics.checkNotNullExpressionValue(key, "key");
                            ArrayList arrayList = new ArrayList();
                            DeprecatedParamFilter deprecatedParamFilter = new DeprecatedParamFilter();
                            deprecatedParamFilter.eventName = key;
                            deprecatedParamFilter.deprecateParams = arrayList;
                            if (jSONArrayOptJSONArray != null) {
                                deprecatedParamFilter.deprecateParams = Utility.convertJSONArrayToList(jSONArrayOptJSONArray);
                            }
                            deprecatedParamFilters.add(deprecatedParamFilter);
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
