package com.daerisoft.thespikerm;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class YYFirebaseAnalytics extends RunnerSocial {
    public static final int EVENT_OTHER_SOCIAL = 70;
    public static Activity activity = RunnerActivity.CurrentActivity;

    public static Bundle jsonStringToBundle(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Bundle bundle = new Bundle();
            Iterator itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String str2 = (String) itKeys.next();
                if (jSONObject.get(str2) instanceof String) {
                    bundle.putString(str2, jSONObject.getString(str2));
                } else {
                    bundle.putDouble(str2, jSONObject.getDouble(str2));
                }
            }
            return bundle;
        } catch (Exception unused) {
            return new Bundle();
        }
    }

    public void FirebaseAnalytics_LogEvent(String str, String str2) {
        FirebaseAnalytics.getInstance(activity).logEvent(str, jsonStringToBundle(str2));
    }

    public void FirebaseAnalytics_ResetAnalyticsData() {
        FirebaseAnalytics.getInstance(activity).resetAnalyticsData();
    }

    public void FirebaseAnalytics_SetAnalyticsCollectionEnabled(double d) {
        FirebaseAnalytics.getInstance(activity).setAnalyticsCollectionEnabled(d >= 0.5d);
    }

    public void FirebaseAnalytics_SetConsent(double d, double d2) {
        try {
            HashMap map = new HashMap();
            if (d >= 0.5d) {
                map.put(FirebaseAnalytics.ConsentType.AD_STORAGE, FirebaseAnalytics.ConsentStatus.GRANTED);
            } else {
                map.put(FirebaseAnalytics.ConsentType.AD_STORAGE, FirebaseAnalytics.ConsentStatus.DENIED);
            }
            if (d2 >= 0.5d) {
                map.put(FirebaseAnalytics.ConsentType.ANALYTICS_STORAGE, FirebaseAnalytics.ConsentStatus.GRANTED);
            } else {
                map.put(FirebaseAnalytics.ConsentType.ANALYTICS_STORAGE, FirebaseAnalytics.ConsentStatus.DENIED);
            }
            FirebaseAnalytics.getInstance(activity).setConsent(map);
        } catch (Exception e) {
            Log.i(GooglePlayBillingService.TAG, "FirebaseAnalytics_SetConsent Exception: " + e.getMessage());
        }
    }

    public void FirebaseAnalytics_SetDefaultEventParameters(String str) {
        FirebaseAnalytics.getInstance(activity).setDefaultEventParameters(jsonStringToBundle(str));
    }

    public void FirebaseAnalytics_SetSessionTimeoutDuration(double d) {
        FirebaseAnalytics.getInstance(activity).setSessionTimeoutDuration((long) d);
    }

    public void FirebaseAnalytics_SetUserId(String str) {
        FirebaseAnalytics.getInstance(activity).setUserId(str);
    }

    public void FirebaseAnalytics_SetUserProperty(String str, String str2) {
        FirebaseAnalytics.getInstance(activity).setUserProperty(str, str2);
    }
}
