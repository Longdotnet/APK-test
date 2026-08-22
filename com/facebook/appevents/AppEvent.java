package com.facebook.appevents;

import android.os.Bundle;
import androidx.loader.app.gv.DYYbQc;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.eventdeactivation.EventDeactivationManager;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager;
import com.facebook.internal.Logger;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.google.firebase.inject.PVS.jIKWv;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.jvm.internal.DEXi.JuorMn;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class AppEvent implements Serializable {
    private static final long serialVersionUID = 1;
    public static final HashSet validatedIdentifiers = new HashSet();
    public final String checksum;
    public final boolean inBackground;
    public final boolean isImplicit;
    public final JSONObject jsonObject;
    public final String name;

    /* JADX INFO: loaded from: classes.dex */
    public final class SerializationProxyV2 implements Serializable {
        private static final long serialVersionUID = 20160803001L;
        public final String checksum;
        public final boolean inBackground;
        public final boolean isImplicit;
        public final String jsonString;

        public SerializationProxyV2(String str, String str2, boolean z, boolean z2) {
            this.jsonString = str;
            this.isImplicit = z;
            this.inBackground = z2;
            this.checksum = str2;
        }

        private final Object readResolve() {
            return new AppEvent(this.jsonString, this.checksum, this.isImplicit, this.inBackground);
        }
    }

    public AppEvent(String contextName, String eventName, Double d, Bundle bundle, boolean z, boolean z2, UUID uuid) {
        boolean zContains;
        Intrinsics.checkNotNullParameter(contextName, "contextName");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        this.isImplicit = z;
        this.inBackground = z2;
        this.name = eventName;
        GraphRequest.Companion.access$validateIdentifier(eventName);
        JSONObject jSONObject = new JSONObject();
        RestrictiveDataManager restrictiveDataManager = RestrictiveDataManager.INSTANCE;
        String str = null;
        if (!CrashShieldHandler.isObjectCrashing(RestrictiveDataManager.class)) {
            try {
                if (RestrictiveDataManager.enabled) {
                    RestrictiveDataManager restrictiveDataManager2 = RestrictiveDataManager.INSTANCE;
                    if (CrashShieldHandler.isObjectCrashing(restrictiveDataManager2)) {
                        zContains = false;
                    } else {
                        try {
                            zContains = RestrictiveDataManager.restrictedEvents.contains(eventName);
                        } catch (Throwable th) {
                            CrashShieldHandler.handleThrowable(restrictiveDataManager2, th);
                            zContains = false;
                        }
                    }
                    if (zContains) {
                        eventName = "_removed_";
                    }
                }
                str = eventName;
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(RestrictiveDataManager.class, th2);
            }
        }
        jSONObject.put(DYYbQc.KFUxzscA, str);
        jSONObject.put("_eventName_md5", GraphRequest.Companion.access$md5Checksum(str));
        jSONObject.put("_logTime", System.currentTimeMillis() / ((long) 1000));
        jSONObject.put("_ui", contextName);
        if (uuid != null) {
            jSONObject.put("_session_id", uuid);
        }
        if (bundle != null) {
            HashMap map = new HashMap();
            for (String str2 : bundle.keySet()) {
                Intrinsics.checkNotNullExpressionValue(str2, jIKWv.ZUvggqEZU);
                GraphRequest.Companion.access$validateIdentifier(str2);
                Object obj = bundle.get(str2);
                if (!(obj instanceof String) && !(obj instanceof Number)) {
                    throw new FacebookException(String.format("Parameter value '%s' for key '%s' should be a string or a numeric type.", Arrays.copyOf(new Object[]{obj, str2}, 2)));
                }
                map.put(str2, obj.toString());
            }
            if (!CrashShieldHandler.isObjectCrashing(IntegrityManager.class)) {
                try {
                    if (IntegrityManager.enabled && !map.isEmpty()) {
                        try {
                            List<String> list = CollectionsKt.toList(map.keySet());
                            JSONObject jSONObject2 = new JSONObject();
                            for (String str3 : list) {
                                Object obj2 = map.get(str3);
                                if (obj2 == null) {
                                    throw new IllegalStateException("Required value was null.");
                                }
                                String str4 = (String) obj2;
                                IntegrityManager integrityManager = IntegrityManager.INSTANCE;
                                if (integrityManager.shouldFilter(str3) || integrityManager.shouldFilter(str4)) {
                                    map.remove(str3);
                                    if (!IntegrityManager.isSampleEnabled) {
                                        str4 = "";
                                    }
                                    jSONObject2.put(str3, str4);
                                }
                            }
                            if (jSONObject2.length() != 0) {
                                String string = jSONObject2.toString();
                                Intrinsics.checkNotNullExpressionValue(string, "restrictiveParamJson.toString()");
                                map.put("_onDeviceParams", string);
                            }
                        } catch (Exception unused) {
                        }
                    }
                } catch (Throwable th3) {
                    CrashShieldHandler.handleThrowable(IntegrityManager.class, th3);
                }
            }
            RestrictiveDataManager restrictiveDataManager3 = RestrictiveDataManager.INSTANCE;
            boolean zIsObjectCrashing = CrashShieldHandler.isObjectCrashing(RestrictiveDataManager.class);
            String eventName2 = this.name;
            if (!zIsObjectCrashing) {
                try {
                    Intrinsics.checkNotNullParameter(eventName2, "eventName");
                    if (RestrictiveDataManager.enabled) {
                        HashMap map2 = new HashMap();
                        for (String str5 : new ArrayList(map.keySet())) {
                            String matchedRuleType = RestrictiveDataManager.INSTANCE.getMatchedRuleType(eventName2, str5);
                            if (matchedRuleType != null) {
                                map2.put(str5, matchedRuleType);
                                map.remove(str5);
                            }
                        }
                        if (!map2.isEmpty()) {
                            try {
                                JSONObject jSONObject3 = new JSONObject();
                                for (Map.Entry entry : map2.entrySet()) {
                                    jSONObject3.put((String) entry.getKey(), (String) entry.getValue());
                                }
                                map.put(JuorMn.xRypUrMlcAfrkFN, jSONObject3.toString());
                            } catch (JSONException unused2) {
                            }
                        }
                    }
                } catch (Throwable th4) {
                    CrashShieldHandler.handleThrowable(RestrictiveDataManager.class, th4);
                }
            }
            EventDeactivationManager eventDeactivationManager = EventDeactivationManager.INSTANCE;
            if (!CrashShieldHandler.isObjectCrashing(EventDeactivationManager.class)) {
                try {
                    Intrinsics.checkNotNullParameter(eventName2, "eventName");
                    if (EventDeactivationManager.enabled) {
                        ArrayList<String> arrayList = new ArrayList(map.keySet());
                        for (EventDeactivationManager.DeprecatedParamFilter deprecatedParamFilter : new ArrayList(EventDeactivationManager.deprecatedParamFilters)) {
                            if (Intrinsics.areEqual(deprecatedParamFilter.eventName, eventName2)) {
                                for (String str6 : arrayList) {
                                    if (deprecatedParamFilter.deprecateParams.contains(str6)) {
                                        map.remove(str6);
                                    }
                                }
                            }
                        }
                    }
                } catch (Throwable th5) {
                    CrashShieldHandler.handleThrowable(EventDeactivationManager.class, th5);
                }
            }
            for (String str7 : map.keySet()) {
                jSONObject.put(str7, map.get(str7));
            }
        }
        if (d != null) {
            jSONObject.put("_valueToSum", d.doubleValue());
        }
        if (this.inBackground) {
            jSONObject.put("_inBackground", "1");
        }
        if (this.isImplicit) {
            jSONObject.put("_implicitlyLogged", "1");
        } else {
            GraphRequest.Companion companion = Logger.Companion;
            Intrinsics.checkNotNullExpressionValue(jSONObject.toString(), "eventObject.toString()");
            synchronized (FacebookSdk.loggingBehaviors) {
            }
        }
        this.jsonObject = jSONObject;
        String string2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string2, "jsonObject.toString()");
        this.checksum = GraphRequest.Companion.access$md5Checksum(string2);
    }

    private final Object writeReplace() {
        String string = this.jsonObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "jsonObject.toString()");
        return new SerializationProxyV2(string, this.checksum, this.isImplicit, this.inBackground);
    }

    public final String toString() {
        JSONObject jSONObject = this.jsonObject;
        return String.format("\"%s\", implicit: %b, json: %s", Arrays.copyOf(new Object[]{jSONObject.optString("_eventName"), Boolean.valueOf(this.isImplicit), jSONObject.toString()}, 3));
    }

    public AppEvent(String str, String str2, boolean z, boolean z2) {
        JSONObject jSONObject = new JSONObject(str);
        this.jsonObject = jSONObject;
        this.isImplicit = z;
        String strOptString = jSONObject.optString("_eventName");
        Intrinsics.checkNotNullExpressionValue(strOptString, "jsonObject.optString(Constants.EVENT_NAME_EVENT_KEY)");
        this.name = strOptString;
        this.checksum = str2;
        this.inBackground = z2;
    }
}
