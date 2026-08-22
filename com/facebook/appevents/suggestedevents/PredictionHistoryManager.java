package com.facebook.appevents.suggestedevents;

import android.content.SharedPreferences;
import android.view.View;
import com.facebook.FacebookSdk;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.google.android.gms.common.util.concurrent.dN.MnHfHMYQDPUO;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class PredictionHistoryManager {
    public static final PredictionHistoryManager INSTANCE = new PredictionHistoryManager();
    public static final LinkedHashMap clickedViewPaths = new LinkedHashMap();
    public static final AtomicBoolean initialized = new AtomicBoolean(false);
    public static SharedPreferences shardPreferences;

    public static final String getPathID(View view, String text) {
        if (CrashShieldHandler.isObjectCrashing(PredictionHistoryManager.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(text, "text");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("text", text);
                JSONArray jSONArray = new JSONArray();
                while (view != null) {
                    jSONArray.put(view.getClass().getSimpleName());
                    view = ViewHierarchy.getParentOfView(view);
                }
                jSONObject.put("classname", jSONArray);
            } catch (JSONException unused) {
            }
            return Utility.sha256hash(jSONObject.toString());
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(PredictionHistoryManager.class, th);
            return null;
        }
    }

    public final void initAndWait() {
        String str = "";
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            AtomicBoolean atomicBoolean = initialized;
            if (atomicBoolean.get()) {
                return;
            }
            SharedPreferences sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.internal.SUGGESTED_EVENTS_HISTORY", 0);
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, "FacebookSdk.getApplicationContext()\n            .getSharedPreferences(CLICKED_PATH_STORE, Context.MODE_PRIVATE)");
            shardPreferences = sharedPreferences;
            LinkedHashMap linkedHashMap = clickedViewPaths;
            String string = sharedPreferences.getString("SUGGESTED_EVENTS_HISTORY", "");
            if (string != null) {
                str = string;
            }
            linkedHashMap.putAll(Utility.jsonStrToMap(str));
            atomicBoolean.set(true);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
        }
    }

    public static final void addPrediction(String str, String predictedEvent) {
        if (CrashShieldHandler.isObjectCrashing(PredictionHistoryManager.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(predictedEvent, "predictedEvent");
            if (!initialized.get()) {
                INSTANCE.initAndWait();
            }
            LinkedHashMap linkedHashMap = clickedViewPaths;
            linkedHashMap.put(str, predictedEvent);
            SharedPreferences sharedPreferences = shardPreferences;
            if (sharedPreferences != null) {
                sharedPreferences.edit().putString("SUGGESTED_EVENTS_HISTORY", Utility.mapToJsonStr(MapsKt__MapsKt.toMap(linkedHashMap))).apply();
            } else {
                Intrinsics.throwUninitializedPropertyAccessException(MnHfHMYQDPUO.oeQcntHbNO);
                throw null;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(PredictionHistoryManager.class, th);
        }
    }
}
