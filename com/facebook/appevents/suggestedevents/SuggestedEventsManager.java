package com.facebook.appevents.suggestedevents;

import android.app.Activity;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventQueue$$ExternalSyntheticLambda0;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.appevents.ml.ModelManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import okio.Okio;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class SuggestedEventsManager {
    public static final SuggestedEventsManager INSTANCE = new SuggestedEventsManager();
    public static final AtomicBoolean enabled = new AtomicBoolean(false);
    public static final LinkedHashSet productionEvents = new LinkedHashSet();
    public static final LinkedHashSet eligibleEvents = new LinkedHashSet();

    public static final synchronized void enable() {
        if (CrashShieldHandler.isObjectCrashing(SuggestedEventsManager.class)) {
            return;
        }
        try {
            FacebookSdk.getExecutor().execute(new AppEventQueue$$ExternalSyntheticLambda0(13));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(SuggestedEventsManager.class, th);
        }
    }

    public static final void trackActivity(Activity activity) {
        if (CrashShieldHandler.isObjectCrashing(SuggestedEventsManager.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(activity, "activity");
            try {
                if (enabled.get()) {
                    boolean z = false;
                    if (!CrashShieldHandler.isObjectCrashing(FeatureExtractor.class)) {
                        try {
                            z = FeatureExtractor.initialized;
                        } catch (Throwable th) {
                            CrashShieldHandler.handleThrowable(FeatureExtractor.class, th);
                        }
                    }
                    if (z) {
                        if (productionEvents.isEmpty()) {
                            if (!eligibleEvents.isEmpty()) {
                            }
                        }
                        HashMap map = ViewObserver.observers;
                        Okio.startTrackingActivity(activity);
                        return;
                    }
                }
                HashMap map2 = ViewObserver.observers;
                Okio.stopTrackingActivity(activity);
            } catch (Exception unused) {
            }
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(SuggestedEventsManager.class, th2);
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
            if (fetchedAppSettingsQueryAppSettings == null || (str = fetchedAppSettingsQueryAppSettings.suggestedEventsSetting) == null) {
                return;
            }
            populateEventsFromRawJsonString$facebook_core_release(str);
            if (productionEvents.isEmpty() && eligibleEvents.isEmpty()) {
                return;
            }
            File ruleFile = ModelManager.getRuleFile();
            if (ruleFile == null) {
                return;
            }
            FeatureExtractor.initialize(ruleFile);
            WeakReference weakReference = ActivityLifecycleTracker.currActivity;
            Activity activity = weakReference != null ? (Activity) weakReference.get() : null;
            if (activity != null) {
                trackActivity(activity);
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
        }
    }

    public final void populateEventsFromRawJsonString$facebook_core_release(String str) {
        JSONArray jSONArray;
        int length;
        JSONArray jSONArray2;
        int length2;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i = 0;
            if (jSONObject.has("production_events") && (length2 = (jSONArray2 = jSONObject.getJSONArray("production_events")).length()) > 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    LinkedHashSet linkedHashSet = productionEvents;
                    String string = jSONArray2.getString(i2);
                    Intrinsics.checkNotNullExpressionValue(string, "jsonArray.getString(i)");
                    linkedHashSet.add(string);
                    if (i3 >= length2) {
                        break;
                    } else {
                        i2 = i3;
                    }
                }
            }
            if (!jSONObject.has("eligible_for_prediction_events") || (length = (jSONArray = jSONObject.getJSONArray("eligible_for_prediction_events")).length()) <= 0) {
                return;
            }
            while (true) {
                int i4 = i + 1;
                LinkedHashSet linkedHashSet2 = eligibleEvents;
                String string2 = jSONArray.getString(i);
                Intrinsics.checkNotNullExpressionValue(string2, "jsonArray.getString(i)");
                linkedHashSet2.add(string2);
                if (i4 >= length) {
                    return;
                } else {
                    i = i4;
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
        }
    }
}
