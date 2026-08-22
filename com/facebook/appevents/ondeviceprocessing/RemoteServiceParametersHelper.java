package com.facebook.appevents.ondeviceprocessing;

import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.eventdeactivation.EventDeactivationManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class RemoteServiceParametersHelper {
    public static final RemoteServiceParametersHelper INSTANCE = new RemoteServiceParametersHelper();

    public static final Bundle buildEventsBundle(RemoteServiceWrapper.EventType eventType, String str, List list) {
        if (CrashShieldHandler.isObjectCrashing(RemoteServiceParametersHelper.class)) {
            return null;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("event", eventType.eventType);
            bundle.putString("app_id", str);
            if (RemoteServiceWrapper.EventType.CUSTOM_APP_EVENTS == eventType) {
                JSONArray jSONArrayBuildEventsJson = INSTANCE.buildEventsJson(str, list);
                if (jSONArrayBuildEventsJson.length() == 0) {
                    return null;
                }
                bundle.putString("custom_events", jSONArrayBuildEventsJson.toString());
            }
            return bundle;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(RemoteServiceParametersHelper.class, th);
            return null;
        }
    }

    public final JSONArray buildEventsJson(String str, List list) {
        boolean zEquals;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            ArrayList<AppEvent> mutableList = CollectionsKt.toMutableList(list);
            EventDeactivationManager.processEvents(mutableList);
            boolean z = false;
            if (!CrashShieldHandler.isObjectCrashing(this)) {
                try {
                    FetchedAppSettings fetchedAppSettingsQueryAppSettings = FetchedAppSettingsManager.queryAppSettings(str, false);
                    if (fetchedAppSettingsQueryAppSettings != null) {
                        z = fetchedAppSettingsQueryAppSettings.supportsImplicitLogging;
                    }
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(this, th);
                }
            }
            for (AppEvent appEvent : mutableList) {
                String str2 = appEvent.checksum;
                JSONObject jSONObject = appEvent.jsonObject;
                if (str2 == null) {
                    zEquals = true;
                } else {
                    String string = jSONObject.toString();
                    Intrinsics.checkNotNullExpressionValue(string, "jsonObject.toString()");
                    zEquals = GraphRequest.Companion.access$md5Checksum(string).equals(str2);
                }
                if (zEquals) {
                    boolean z2 = appEvent.isImplicit;
                    if (!z2 || (z2 && z)) {
                        jSONArray.put(jSONObject);
                    }
                } else {
                    Intrinsics.stringPlus(appEvent, "Event with invalid checksum: ");
                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                }
            }
            return jSONArray;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(this, th2);
            return null;
        }
    }
}
