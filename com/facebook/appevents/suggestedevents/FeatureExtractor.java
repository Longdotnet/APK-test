package com.facebook.appevents.suggestedevents;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import androidx.lifecycle.hSi.sgtsHsWT;
import androidx.sqlite.db.framework.VERT.YcVWhnLsj;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest$Companion$$ExternalSyntheticLambda1;
import com.facebook.appevents.AppEventsLoggerImpl;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.google.android.gms.ads.rewarded.zQ.yzwzcWHcnH;
import com.google.android.gms.common.stats.ZnFR.FKidOcdAYt;
import com.google.android.gms.games.provider.NtJ.wsbWxekY;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.regex.Pattern;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class FeatureExtractor {
    public static final FeatureExtractor INSTANCE = new FeatureExtractor();
    public static Object eventInfo;
    public static boolean initialized;
    public static Object languageInfo;
    public static JSONObject rules;
    public static Object textTypeInfo;

    public static final boolean access$queryHistoryAndProcess(String str, String str2) {
        HashSet hashSet = ViewOnClickListener.viewsAttachedListener;
        PredictionHistoryManager predictionHistoryManager = PredictionHistoryManager.INSTANCE;
        String str3 = null;
        if (!CrashShieldHandler.isObjectCrashing(PredictionHistoryManager.class)) {
            try {
                LinkedHashMap linkedHashMap = PredictionHistoryManager.clickedViewPaths;
                if (linkedHashMap.containsKey(str)) {
                    str3 = (String) linkedHashMap.get(str);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(PredictionHistoryManager.class, th);
            }
        }
        if (str3 == null) {
            return false;
        }
        if (!str3.equals("other")) {
            Utility.runOnNonUiThread(new GraphRequest$Companion$$ExternalSyntheticLambda1(str3, str2, 19));
        }
        return true;
    }

    public static final float[] getDenseFeatures(String str, JSONObject jSONObject) {
        if (CrashShieldHandler.isObjectCrashing(FeatureExtractor.class)) {
            return null;
        }
        try {
            if (!initialized) {
                return null;
            }
            float[] fArr = new float[30];
            for (int i = 0; i < 30; i++) {
                fArr[i] = 0.0f;
            }
            try {
                String lowerCase = str.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                JSONObject jSONObject2 = new JSONObject(jSONObject.optJSONObject("view").toString());
                String screenName = jSONObject.optString("screenname");
                JSONArray jSONArray = new JSONArray();
                FeatureExtractor featureExtractor = INSTANCE;
                featureExtractor.pruneTree(jSONObject2, jSONArray);
                featureExtractor.sum(fArr, featureExtractor.parseFeatures(jSONObject2));
                JSONObject interactedNode = featureExtractor.getInteractedNode(jSONObject2);
                if (interactedNode == null) {
                    return null;
                }
                Intrinsics.checkNotNullExpressionValue(screenName, "screenName");
                String string = jSONObject2.toString();
                Intrinsics.checkNotNullExpressionValue(string, "viewTree.toString()");
                featureExtractor.sum(fArr, featureExtractor.nonparseFeatures(interactedNode, jSONArray, screenName, string, lowerCase));
            } catch (JSONException unused) {
            }
            return fArr;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(FeatureExtractor.class, th);
            return null;
        }
    }

    public static final String getTextFeature(String buttonText, String activityName, String str) {
        if (CrashShieldHandler.isObjectCrashing(FeatureExtractor.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(buttonText, "buttonText");
            Intrinsics.checkNotNullParameter(activityName, "activityName");
            String str2 = str + " | " + activityName + ", " + buttonText;
            if (str2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = str2.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
            return lowerCase;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(FeatureExtractor.class, th);
            return null;
        }
    }

    public static final void initialize(File file) {
        if (CrashShieldHandler.isObjectCrashing(FeatureExtractor.class)) {
            return;
        }
        try {
            try {
                rules = new JSONObject();
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                fileInputStream.close();
                rules = new JSONObject(new String(bArr, Charsets.UTF_8));
                languageInfo = MapsKt__MapsKt.mapOf(new Pair("ENGLISH", "1"), new Pair("GERMAN", "2"), new Pair("SPANISH", "3"), new Pair("JAPANESE", "4"));
                eventInfo = MapsKt__MapsKt.mapOf(new Pair("VIEW_CONTENT", "0"), new Pair("SEARCH", "1"), new Pair("ADD_TO_CART", "2"), new Pair("ADD_TO_WISHLIST", "3"), new Pair(FKidOcdAYt.NUM, "4"), new Pair("ADD_PAYMENT_INFO", "5"), new Pair("PURCHASE", "6"), new Pair("LEAD", "7"), new Pair("COMPLETE_REGISTRATION", sgtsHsWT.EKX));
                textTypeInfo = MapsKt__MapsKt.mapOf(new Pair("BUTTON_TEXT", "1"), new Pair("PAGE_TITLE", "2"), new Pair("RESOLVED_DOCUMENT_LINK", "3"), new Pair("BUTTON_ID", "4"));
                initialized = true;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(FeatureExtractor.class, th);
            }
        } catch (Exception unused) {
        }
    }

    public static void processPredictedResult(String event, String str, float[] fArr) throws Throwable {
        boolean zContains;
        boolean zContains2;
        SuggestedEventsManager suggestedEventsManager = SuggestedEventsManager.INSTANCE;
        if (CrashShieldHandler.isObjectCrashing(SuggestedEventsManager.class)) {
            zContains = false;
        } else {
            try {
                Intrinsics.checkNotNullParameter(event, "event");
                zContains = SuggestedEventsManager.productionEvents.contains(event);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(SuggestedEventsManager.class, th);
                zContains = false;
            }
        }
        if (zContains) {
            AppEventsLoggerImpl appEventsLoggerImpl = new AppEventsLoggerImpl(FacebookSdk.getApplicationContext(), (String) null);
            if (CrashShieldHandler.isObjectCrashing(appEventsLoggerImpl)) {
                return;
            }
            try {
                Bundle bundle = new Bundle();
                bundle.putString("_is_suggested_event", wsbWxekY.grGvLZ);
                bundle.putString("_button_text", str);
                appEventsLoggerImpl.logEvent(event, bundle);
                return;
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(appEventsLoggerImpl, th2);
                return;
            }
        }
        SuggestedEventsManager suggestedEventsManager2 = SuggestedEventsManager.INSTANCE;
        if (CrashShieldHandler.isObjectCrashing(SuggestedEventsManager.class)) {
            zContains2 = false;
        } else {
            try {
                Intrinsics.checkNotNullParameter(event, "event");
                zContains2 = SuggestedEventsManager.eligibleEvents.contains(event);
            } catch (Throwable th3) {
                CrashShieldHandler.handleThrowable(SuggestedEventsManager.class, th3);
                zContains2 = false;
            }
        }
        if (zContains2) {
            Bundle bundle2 = new Bundle();
            try {
                bundle2.putString("event_name", event);
                JSONObject jSONObject = new JSONObject();
                StringBuilder sb = new StringBuilder();
                int length = fArr.length;
                int i = 0;
                while (i < length) {
                    float f = fArr[i];
                    i++;
                    sb.append(f);
                    sb.append(",");
                }
                jSONObject.put("dense", sb.toString());
                jSONObject.put("button_text", str);
                bundle2.putString("metadata", jSONObject.toString());
                String str2 = GraphRequest.MIME_BOUNDARY;
                GraphRequest graphRequestNewPostRequest = GraphRequest.Companion.newPostRequest(null, String.format(Locale.US, "%s/suggested_events", Arrays.copyOf(new Object[]{FacebookSdk.getApplicationId()}, 1)), null, null);
                graphRequestNewPostRequest.parameters = bundle2;
                graphRequestNewPostRequest.executeAndWait();
            } catch (JSONException unused) {
            }
        }
    }

    public JSONObject getInteractedNode(JSONObject jSONObject) {
        int length;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            if (jSONObject.optBoolean("is_interacted")) {
                return jSONObject;
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("childviews");
            if (jSONArrayOptJSONArray != null && (length = jSONArrayOptJSONArray.length()) > 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i);
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "children.getJSONObject(i)");
                    JSONObject interactedNode = getInteractedNode(jSONObject2);
                    if (interactedNode != null) {
                        return interactedNode;
                    }
                    if (i2 >= length) {
                        break;
                    }
                    i = i2;
                }
            }
        } catch (JSONException unused) {
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
        }
        return null;
    }

    public boolean matchIndicators(String[] strArr, String[] strArr2) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                String str = strArr[i];
                i++;
                int length2 = strArr2.length;
                int i2 = 0;
                while (i2 < length2) {
                    String str2 = strArr2[i2];
                    i2++;
                    if (StringsKt__StringsKt.contains$default(str2, str)) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
            return false;
        }
    }

    public float[] nonparseFeatures(JSONObject jSONObject, JSONArray jSONArray, String str, String str2, String str3) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            float[] fArr = new float[30];
            int i = 0;
            for (int i2 = 0; i2 < 30; i2++) {
                fArr[i2] = 0.0f;
            }
            int length = jSONArray.length();
            fArr[3] = length > 1 ? length - 1.0f : 0.0f;
            try {
                int length2 = jSONArray.length();
                if (length2 > 0) {
                    while (true) {
                        int i3 = i + 1;
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        Intrinsics.checkNotNullExpressionValue(jSONObject2, "siblings.getJSONObject(i)");
                        if (!CrashShieldHandler.isObjectCrashing(this)) {
                            try {
                                if (((jSONObject2.optInt("classtypebitmask") & 1) << 5) > 0) {
                                    fArr[9] = fArr[9] + 1.0f;
                                }
                            } catch (Throwable th) {
                                CrashShieldHandler.handleThrowable(this, th);
                            }
                        }
                        if (i3 >= length2) {
                            break;
                        }
                        i = i3;
                    }
                }
            } catch (JSONException unused) {
            }
            fArr[13] = -1.0f;
            fArr[14] = -1.0f;
            String str4 = str + '|' + str3;
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            updateHintAndTextRecursively(jSONObject, sb2, sb);
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "hintSB.toString()");
            String string2 = sb2.toString();
            Intrinsics.checkNotNullExpressionValue(string2, "textSB.toString()");
            fArr[15] = regexMatched("COMPLETE_REGISTRATION", "BUTTON_TEXT", string2) ? 1.0f : 0.0f;
            fArr[16] = regexMatched("COMPLETE_REGISTRATION", "PAGE_TITLE", str4) ? 1.0f : 0.0f;
            fArr[17] = regexMatched("COMPLETE_REGISTRATION", "BUTTON_ID", string) ? 1.0f : 0.0f;
            fArr[18] = StringsKt__StringsKt.contains$default(str2, "password") ? 1.0f : 0.0f;
            fArr[19] = regexMatched("(?i)(confirm.*password)|(password.*(confirmation|confirm)|confirmation)", str2) ? 1.0f : 0.0f;
            fArr[20] = regexMatched("(?i)(sign in)|login|signIn", str2) ? 1.0f : 0.0f;
            fArr[21] = regexMatched("(?i)(sign.*(up|now)|registration|register|(create|apply).*(profile|account)|open.*account|account.*(open|creation|application)|enroll|join.*now)", str2) ? 1.0f : 0.0f;
            fArr[22] = regexMatched("PURCHASE", "BUTTON_TEXT", string2) ? 1.0f : 0.0f;
            fArr[24] = regexMatched("PURCHASE", "PAGE_TITLE", str4) ? 1.0f : 0.0f;
            fArr[25] = regexMatched("(?i)add to(\\s|\\Z)|update(\\s|\\Z)|cart", string2) ? 1.0f : 0.0f;
            fArr[27] = regexMatched("(?i)add to(\\s|\\Z)|update(\\s|\\Z)|cart|shop|buy", str4) ? 1.0f : 0.0f;
            fArr[28] = regexMatched("LEAD", "BUTTON_TEXT", string2) ? 1.0f : 0.0f;
            fArr[29] = regexMatched("LEAD", "PAGE_TITLE", str4) ? 1.0f : 0.0f;
            return fArr;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(this, th2);
            return null;
        }
    }

    public float[] parseFeatures(JSONObject jSONObject) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            float[] fArr = new float[30];
            int i = 0;
            for (int i2 = 0; i2 < 30; i2++) {
                fArr[i2] = 0.0f;
            }
            String strOptString = jSONObject.optString("text");
            Intrinsics.checkNotNullExpressionValue(strOptString, "node.optString(TEXT_KEY)");
            String lowerCase = strOptString.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
            String strOptString2 = jSONObject.optString("hint");
            Intrinsics.checkNotNullExpressionValue(strOptString2, "node.optString(HINT_KEY)");
            String lowerCase2 = strOptString2.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase()");
            String strOptString3 = jSONObject.optString("classname");
            Intrinsics.checkNotNullExpressionValue(strOptString3, "node.optString(CLASS_NAME_KEY)");
            String lowerCase3 = strOptString3.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase3, "(this as java.lang.String).toLowerCase()");
            int iOptInt = jSONObject.optInt("inputtype", -1);
            String[] strArr = {lowerCase, lowerCase2};
            if (matchIndicators(new String[]{"$", "amount", FirebaseAnalytics.Param.PRICE, "total"}, strArr)) {
                fArr[0] = fArr[0] + 1.0f;
            }
            if (matchIndicators(new String[]{"password", "pwd"}, strArr)) {
                fArr[1] = fArr[1] + 1.0f;
            }
            if (matchIndicators(new String[]{"tel", "phone"}, strArr)) {
                fArr[2] = fArr[2] + 1.0f;
            }
            if (matchIndicators(new String[]{FirebaseAnalytics.Event.SEARCH}, strArr)) {
                fArr[4] = fArr[4] + 1.0f;
            }
            if (iOptInt >= 0) {
                fArr[5] = fArr[5] + 1.0f;
            }
            if (iOptInt == 3 || iOptInt == 2) {
                fArr[6] = fArr[6] + 1.0f;
            }
            if (iOptInt == 32 || Patterns.EMAIL_ADDRESS.matcher(lowerCase).matches()) {
                fArr[7] = fArr[7] + 1.0f;
            }
            if (StringsKt__StringsKt.contains$default(lowerCase3, "checkbox")) {
                fArr[8] = fArr[8] + 1.0f;
            }
            if (matchIndicators(new String[]{"complete", "confirm", "done", "submit"}, new String[]{lowerCase})) {
                fArr[10] = fArr[10] + 1.0f;
            }
            if (StringsKt__StringsKt.contains$default(lowerCase3, "radio") && StringsKt__StringsKt.contains$default(lowerCase3, "button")) {
                fArr[12] = fArr[12] + 1.0f;
            }
            try {
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("childviews");
                int length = jSONArrayOptJSONArray.length();
                if (length > 0) {
                    while (true) {
                        int i3 = i + 1;
                        JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i);
                        Intrinsics.checkNotNullExpressionValue(jSONObject2, "childViews.getJSONObject(i)");
                        sum(fArr, parseFeatures(jSONObject2));
                        if (i3 >= length) {
                            break;
                        }
                        i = i3;
                    }
                }
            } catch (JSONException unused) {
            }
            return fArr;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
            return null;
        }
    }

    public boolean pruneTree(JSONObject jSONObject, JSONArray jSONArray) {
        boolean z;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            if (jSONObject.optBoolean("is_interacted")) {
                return true;
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("childviews");
            int length = jSONArrayOptJSONArray.length();
            if (length <= 0) {
                z = false;
                break;
            }
            int i = 0;
            while (true) {
                int i2 = i + 1;
                if (jSONArrayOptJSONArray.getJSONObject(i).optBoolean("is_interacted")) {
                    z = true;
                    break;
                }
                if (i2 >= length) {
                    z = false;
                    break;
                }
                i = i2;
            }
            boolean z2 = z;
            JSONArray jSONArray2 = new JSONArray();
            if (z) {
                int length2 = jSONArrayOptJSONArray.length();
                if (length2 > 0) {
                    int i3 = 0;
                    while (true) {
                        int i4 = i3 + 1;
                        jSONArray.put(jSONArrayOptJSONArray.getJSONObject(i3));
                        if (i4 >= length2) {
                            break;
                        }
                        i3 = i4;
                    }
                }
            } else {
                int length3 = jSONArrayOptJSONArray.length();
                if (length3 > 0) {
                    int i5 = 0;
                    while (true) {
                        int i6 = i5 + 1;
                        JSONObject child = jSONArrayOptJSONArray.getJSONObject(i5);
                        Intrinsics.checkNotNullExpressionValue(child, "child");
                        if (pruneTree(child, jSONArray)) {
                            jSONArray2.put(child);
                            z2 = true;
                        }
                        if (i6 >= length3) {
                            break;
                        }
                        i5 = i6;
                    }
                }
                jSONObject.put("childviews", jSONArray2);
            }
            return z2;
        } catch (JSONException unused) {
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
            return false;
        }
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object, java.util.Map] */
    public boolean regexMatched(String str, String str2, String str3) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        JSONObject jSONObjectOptJSONObject3;
        JSONObject jSONObjectOptJSONObject4;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            JSONObject jSONObject = rules;
            String strOptString = null;
            if (jSONObject == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rules");
                throw null;
            }
            JSONObject jSONObjectOptJSONObject5 = jSONObject.optJSONObject("rulesForLanguage");
            if (jSONObjectOptJSONObject5 == null) {
                jSONObjectOptJSONObject = null;
            } else {
                ?? r4 = languageInfo;
                if (r4 == 0) {
                    Intrinsics.throwUninitializedPropertyAccessException("languageInfo");
                    throw null;
                }
                jSONObjectOptJSONObject = jSONObjectOptJSONObject5.optJSONObject((String) r4.get("ENGLISH"));
            }
            if (jSONObjectOptJSONObject == null || (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("rulesForEvent")) == null) {
                jSONObjectOptJSONObject3 = null;
            } else {
                ?? r1 = eventInfo;
                if (r1 == 0) {
                    Intrinsics.throwUninitializedPropertyAccessException("eventInfo");
                    throw null;
                }
                jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject((String) r1.get(str));
            }
            if (jSONObjectOptJSONObject3 != null && (jSONObjectOptJSONObject4 = jSONObjectOptJSONObject3.optJSONObject("positiveRules")) != null) {
                ?? r0 = textTypeInfo;
                if (r0 == 0) {
                    Intrinsics.throwUninitializedPropertyAccessException("textTypeInfo");
                    throw null;
                }
                strOptString = jSONObjectOptJSONObject4.optString((String) r0.get(str2));
            }
            if (strOptString == null) {
                return false;
            }
            return regexMatched(strOptString, str3);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
            return false;
        }
    }

    public void sum(float[] fArr, float[] fArr2) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            int length = fArr.length - 1;
            if (length < 0) {
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i + 1;
                fArr[i] = fArr[i] + fArr2[i];
                if (i2 > length) {
                    return;
                } else {
                    i = i2;
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
        }
    }

    public static void attachListener$facebook_core_release(View view, View view2, String str) {
        HashSet hashSet;
        Field declaredField;
        Field declaredField2;
        Object obj;
        Intrinsics.checkNotNullParameter(view, YcVWhnLsj.PND);
        int iHashCode = view.hashCode();
        HashSet hashSet2 = ViewOnClickListener.viewsAttachedListener;
        HashSet hashSet3 = null;
        if (CrashShieldHandler.isObjectCrashing(ViewOnClickListener.class)) {
            hashSet = null;
        } else {
            try {
                hashSet = ViewOnClickListener.viewsAttachedListener;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(ViewOnClickListener.class, th);
                hashSet = null;
            }
        }
        if (hashSet.contains(Integer.valueOf(iHashCode))) {
            return;
        }
        ViewHierarchy viewHierarchy = ViewHierarchy.INSTANCE;
        ViewOnClickListener viewOnClickListener = new ViewOnClickListener(view, view2, str);
        if (!CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            try {
                try {
                    declaredField = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
                    try {
                        declaredField2 = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnClickListener");
                    } catch (ClassNotFoundException | NoSuchFieldException unused) {
                        declaredField2 = null;
                    }
                } catch (Exception unused2) {
                } catch (Throwable th2) {
                    CrashShieldHandler.handleThrowable(ViewHierarchy.class, th2);
                }
            } catch (ClassNotFoundException | NoSuchFieldException unused3) {
                declaredField = null;
            }
            if (declaredField == null || declaredField2 == null) {
                view.setOnClickListener(viewOnClickListener);
            } else {
                declaredField.setAccessible(true);
                declaredField2.setAccessible(true);
                try {
                    declaredField.setAccessible(true);
                    obj = declaredField.get(view);
                } catch (IllegalAccessException unused4) {
                    obj = null;
                }
                if (obj == null) {
                    view.setOnClickListener(viewOnClickListener);
                } else {
                    declaredField2.set(obj, viewOnClickListener);
                }
            }
        }
        if (!CrashShieldHandler.isObjectCrashing(ViewOnClickListener.class)) {
            try {
                hashSet3 = ViewOnClickListener.viewsAttachedListener;
            } catch (Throwable th3) {
                CrashShieldHandler.handleThrowable(ViewOnClickListener.class, th3);
            }
        }
        hashSet3.add(Integer.valueOf(iHashCode));
    }

    public void updateHintAndTextRecursively(JSONObject jSONObject, StringBuilder sb, StringBuilder sb2) {
        int length;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            String strOptString = jSONObject.optString("text", "");
            Intrinsics.checkNotNullExpressionValue(strOptString, "view.optString(TEXT_KEY, \"\")");
            String lowerCase = strOptString.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
            String strOptString2 = jSONObject.optString("hint", "");
            Intrinsics.checkNotNullExpressionValue(strOptString2, "view.optString(HINT_KEY, \"\")");
            String lowerCase2 = strOptString2.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase()");
            if (lowerCase.length() > 0) {
                sb.append(lowerCase);
                sb.append(" ");
            }
            if (lowerCase2.length() > 0) {
                sb2.append(lowerCase2);
                sb2.append(" ");
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("childviews");
            if (jSONArrayOptJSONArray == null || (length = jSONArrayOptJSONArray.length()) <= 0) {
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i + 1;
                try {
                    JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i);
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, yzwzcWHcnH.KVNDwWvZUPSnGoR);
                    updateHintAndTextRecursively(jSONObject2, sb, sb2);
                } catch (JSONException unused) {
                }
                if (i2 >= length) {
                    return;
                } else {
                    i = i2;
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
        }
    }

    public boolean regexMatched(String str, String str2) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            return Pattern.compile(str).matcher(str2).find();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
            return false;
        }
    }
}
