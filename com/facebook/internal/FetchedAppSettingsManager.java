package com.facebook.internal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.AppEventsManager$start$1;
import com.google.android.gms.appset.vSSa.iafHZUfOuHNwvy;
import com.google.android.gms.games.provider.NtJ.wsbWxekY;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class FetchedAppSettingsManager {
    public static boolean printedSDKUpdatedMessage;
    public static final FetchedAppSettingsManager INSTANCE = new FetchedAppSettingsManager();
    public static final List APP_SETTING_FIELDS = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"supports_implicit_sdk_logging", "gdpv4_nux_content", "gdpv4_nux_enabled", "android_dialog_configs", "android_sdk_error_categories", "app_events_session_timeout", "app_events_feature_bitmask", "auto_event_mapping_android", "seamless_login", "smart_login_bookmark_icon_url", "smart_login_menu_icon_url", iafHZUfOuHNwvy.NduJWYHEfLVMw, "aam_rules", "suggested_events_setting"});
    public static final ConcurrentHashMap fetchedAppSettings = new ConcurrentHashMap();
    public static final AtomicReference loadingState = new AtomicReference(FetchAppSettingState.NOT_LOADED);
    public static final ConcurrentLinkedQueue fetchedAppSettingsCallbacks = new ConcurrentLinkedQueue();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: loaded from: classes.dex */
    public final class FetchAppSettingState {
        public static final /* synthetic */ FetchAppSettingState[] $VALUES;
        public static final FetchAppSettingState ERROR;
        public static final FetchAppSettingState LOADING;
        public static final FetchAppSettingState NOT_LOADED;
        public static final FetchAppSettingState SUCCESS;

        static {
            FetchAppSettingState fetchAppSettingState = new FetchAppSettingState("NOT_LOADED", 0);
            NOT_LOADED = fetchAppSettingState;
            FetchAppSettingState fetchAppSettingState2 = new FetchAppSettingState("LOADING", 1);
            LOADING = fetchAppSettingState2;
            FetchAppSettingState fetchAppSettingState3 = new FetchAppSettingState("SUCCESS", 2);
            SUCCESS = fetchAppSettingState3;
            FetchAppSettingState fetchAppSettingState4 = new FetchAppSettingState("ERROR", 3);
            ERROR = fetchAppSettingState4;
            $VALUES = new FetchAppSettingState[]{fetchAppSettingState, fetchAppSettingState2, fetchAppSettingState3, fetchAppSettingState4};
        }

        public static FetchAppSettingState valueOf(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return (FetchAppSettingState) Enum.valueOf(FetchAppSettingState.class, value);
        }

        public static FetchAppSettingState[] values() {
            return (FetchAppSettingState[]) Arrays.copyOf($VALUES, 4);
        }
    }

    public static JSONObject getAppSettingsQueryResponse() {
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(APP_SETTING_FIELDS);
        bundle.putString("fields", TextUtils.join(",", arrayList));
        String str = GraphRequest.MIME_BOUNDARY;
        GraphRequest graphRequestNewGraphPathRequest = GraphRequest.Companion.newGraphPathRequest(null, "app", null);
        graphRequestNewGraphPathRequest.forceApplicationRequest = true;
        graphRequestNewGraphPathRequest.parameters = bundle;
        JSONObject jSONObject = graphRequestNewGraphPathRequest.executeAndWait().jsonObject;
        return jSONObject == null ? new JSONObject() : jSONObject;
    }

    public static final FetchedAppSettings getAppSettingsWithoutQuery(String str) {
        return (FetchedAppSettings) fetchedAppSettings.get(str);
    }

    public static final void loadAppSettingsAsync() {
        Context applicationContext = FacebookSdk.getApplicationContext();
        String applicationId = FacebookSdk.getApplicationId();
        boolean zIsNullOrEmpty = Utility.isNullOrEmpty(applicationId);
        FetchAppSettingState fetchAppSettingState = FetchAppSettingState.ERROR;
        FetchedAppSettingsManager fetchedAppSettingsManager = INSTANCE;
        AtomicReference atomicReference = loadingState;
        if (zIsNullOrEmpty) {
            atomicReference.set(fetchAppSettingState);
            fetchedAppSettingsManager.pollCallbacks();
            return;
        }
        if (fetchedAppSettings.containsKey(applicationId)) {
            atomicReference.set(FetchAppSettingState.SUCCESS);
            fetchedAppSettingsManager.pollCallbacks();
            return;
        }
        FetchAppSettingState fetchAppSettingState2 = FetchAppSettingState.NOT_LOADED;
        FetchAppSettingState fetchAppSettingState3 = FetchAppSettingState.LOADING;
        while (!atomicReference.compareAndSet(fetchAppSettingState2, fetchAppSettingState3)) {
            if (atomicReference.get() != fetchAppSettingState2) {
                while (!atomicReference.compareAndSet(fetchAppSettingState, fetchAppSettingState3)) {
                    if (atomicReference.get() != fetchAppSettingState) {
                        fetchedAppSettingsManager.pollCallbacks();
                        return;
                    }
                }
                break;
            }
        }
        FacebookSdk.getExecutor().execute(new FetchedAppSettingsManager$$ExternalSyntheticLambda0(applicationContext, String.format("com.facebook.internal.APP_SETTINGS.%s", Arrays.copyOf(new Object[]{applicationId}, 1)), applicationId));
    }

    public static final FetchedAppSettings queryAppSettings(String applicationId, boolean z) {
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        if (!z) {
            ConcurrentHashMap concurrentHashMap = fetchedAppSettings;
            if (concurrentHashMap.containsKey(applicationId)) {
                return (FetchedAppSettings) concurrentHashMap.get(applicationId);
            }
        }
        FetchedAppSettingsManager fetchedAppSettingsManager = INSTANCE;
        FetchedAppSettings appSettingsFromJSON$facebook_core_release = parseAppSettingsFromJSON$facebook_core_release(applicationId, getAppSettingsQueryResponse());
        if (applicationId.equals(FacebookSdk.getApplicationId())) {
            loadingState.set(FetchAppSettingState.SUCCESS);
            fetchedAppSettingsManager.pollCallbacks();
        }
        return appSettingsFromJSON$facebook_core_release;
    }

    public final synchronized void pollCallbacks() {
        FetchAppSettingState fetchAppSettingState = (FetchAppSettingState) loadingState.get();
        if (FetchAppSettingState.NOT_LOADED != fetchAppSettingState && FetchAppSettingState.LOADING != fetchAppSettingState) {
            FetchedAppSettings fetchedAppSettings2 = (FetchedAppSettings) fetchedAppSettings.get(FacebookSdk.getApplicationId());
            Handler handler = new Handler(Looper.getMainLooper());
            if (FetchAppSettingState.ERROR == fetchAppSettingState) {
                while (true) {
                    ConcurrentLinkedQueue concurrentLinkedQueue = fetchedAppSettingsCallbacks;
                    if (concurrentLinkedQueue.isEmpty()) {
                        return;
                    } else {
                        handler.post(new FetchedAppSettingsManager$$ExternalSyntheticLambda1((AppEventsManager$start$1) concurrentLinkedQueue.poll()));
                    }
                }
            } else {
                while (true) {
                    ConcurrentLinkedQueue concurrentLinkedQueue2 = fetchedAppSettingsCallbacks;
                    if (concurrentLinkedQueue2.isEmpty()) {
                        return;
                    } else {
                        handler.post(new FetchedAppSettingsManager$$ExternalSyntheticLambda1((AppEventsManager$start$1) concurrentLinkedQueue2.poll(), fetchedAppSettings2));
                    }
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:63:0x0165  */
    /* JADX WARN: Code duplicated, block: B:92:0x01f6  */
    public static FetchedAppSettings parseAppSettingsFromJSON$facebook_core_release(String applicationId, JSONObject jSONObject) {
        HashMap map;
        HashMap map2;
        HashMap map3;
        String str;
        String str2;
        String str3;
        FacebookRequestErrorClassification facebookRequestErrorClassification;
        String strOptString;
        JSONArray jSONArray;
        FetchedAppSettings.DialogFeatureConfig dialogFeatureConfig;
        JSONArray jSONArrayOptJSONArray;
        int length;
        String str4;
        boolean z;
        int i;
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("android_sdk_error_categories");
        GraphRequest.Companion companion = FacebookRequestErrorClassification.Companion;
        String str5 = "name";
        if (jSONArrayOptJSONArray2 == null) {
            facebookRequestErrorClassification = null;
        } else {
            int length2 = jSONArrayOptJSONArray2.length();
            if (length2 > 0) {
                int i2 = 0;
                HashMap jSONDefinition = null;
                HashMap jSONDefinition2 = null;
                HashMap jSONDefinition3 = null;
                String strOptString2 = null;
                String strOptString3 = null;
                String strOptString4 = null;
                while (true) {
                    int i3 = i2 + 1;
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray2.optJSONObject(i2);
                    if (jSONObjectOptJSONObject == null || (strOptString = jSONObjectOptJSONObject.optString("name")) == null) {
                        jSONArray = jSONArrayOptJSONArray2;
                    } else {
                        jSONArray = jSONArrayOptJSONArray2;
                        if (strOptString.equalsIgnoreCase("other")) {
                            strOptString2 = jSONObjectOptJSONObject.optString("recovery_message", null);
                            jSONDefinition = GraphRequest.Companion.parseJSONDefinition(jSONObjectOptJSONObject);
                        } else if (strOptString.equalsIgnoreCase("transient")) {
                            strOptString3 = jSONObjectOptJSONObject.optString("recovery_message", null);
                            jSONDefinition2 = GraphRequest.Companion.parseJSONDefinition(jSONObjectOptJSONObject);
                        } else if (strOptString.equalsIgnoreCase("login_recoverable")) {
                            strOptString4 = jSONObjectOptJSONObject.optString("recovery_message", null);
                            jSONDefinition3 = GraphRequest.Companion.parseJSONDefinition(jSONObjectOptJSONObject);
                        }
                    }
                    if (i3 >= length2) {
                        break;
                    }
                    i2 = i3;
                    jSONArrayOptJSONArray2 = jSONArray;
                }
                map = jSONDefinition;
                map2 = jSONDefinition2;
                map3 = jSONDefinition3;
                str = strOptString2;
                str2 = strOptString3;
                str3 = strOptString4;
            } else {
                map = null;
                map2 = null;
                map3 = null;
                str = null;
                str2 = null;
                str3 = null;
            }
            facebookRequestErrorClassification = new FacebookRequestErrorClassification(map, map2, map3, str, str2, str3);
        }
        if (facebookRequestErrorClassification == null) {
            facebookRequestErrorClassification = companion.getDefaultErrorClassification();
        }
        FacebookRequestErrorClassification facebookRequestErrorClassification2 = facebookRequestErrorClassification;
        int iOptInt = jSONObject.optInt("app_events_feature_bitmask", 0);
        boolean z2 = (iOptInt & 8) != 0;
        boolean z3 = (iOptInt & 16) != 0;
        boolean z4 = (iOptInt & 32) != 0;
        JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("auto_event_mapping_android");
        if (jSONArrayOptJSONArray3 != null) {
            dialogFeatureConfig = null;
            if (Intrinsics.areEqual(null, Boolean.TRUE)) {
                StringsKt__IndentKt.sendMessage("OnReceiveMapping", jSONArrayOptJSONArray3.toString());
            }
        } else {
            dialogFeatureConfig = null;
        }
        boolean zOptBoolean = jSONObject.optBoolean("supports_implicit_sdk_logging", false);
        String strOptString5 = jSONObject.optString("gdpv4_nux_content", "");
        Intrinsics.checkNotNullExpressionValue(strOptString5, "settingsJSON.optString(APP_SETTING_NUX_CONTENT, \"\")");
        jSONObject.optBoolean("gdpv4_nux_enabled", false);
        int iOptInt2 = jSONObject.optInt("app_events_session_timeout", 60);
        EnumSet enumSet = SmartLoginOption.ALL;
        long jOptLong = jSONObject.optLong("seamless_login");
        EnumSet result = EnumSet.noneOf(SmartLoginOption.class);
        for (SmartLoginOption smartLoginOption : SmartLoginOption.ALL) {
            if ((smartLoginOption.value & jOptLong) != 0) {
                result.add(smartLoginOption);
            }
        }
        Intrinsics.checkNotNullExpressionValue(result, "result");
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("android_dialog_configs");
        HashMap map4 = new HashMap();
        if (jSONObjectOptJSONObject2 != null && (jSONArrayOptJSONArray = jSONObjectOptJSONObject2.optJSONArray("data")) != null && (length = jSONArrayOptJSONArray.length()) > 0) {
            int i4 = 0;
            while (true) {
                int i5 = i4 + 1;
                JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray.optJSONObject(i4);
                Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject3, "dialogConfigData.optJSONObject(i)");
                String dialogNameWithFeature = jSONObjectOptJSONObject3.optString(str5);
                if (Utility.isNullOrEmpty(dialogNameWithFeature)) {
                    jSONArrayOptJSONArray = jSONArrayOptJSONArray;
                    str4 = str5;
                    z = true;
                } else {
                    Intrinsics.checkNotNullExpressionValue(dialogNameWithFeature, "dialogNameWithFeature");
                    int i6 = 0;
                    List listSplit$default = StringsKt__StringsKt.split$default(dialogNameWithFeature, new String[]{"|"}, 0, 6);
                    if (listSplit$default.size() != 2) {
                        jSONArrayOptJSONArray = jSONArrayOptJSONArray;
                        str4 = str5;
                        z = true;
                    } else {
                        String str6 = (String) CollectionsKt.first(listSplit$default);
                        String str7 = (String) CollectionsKt.last(listSplit$default);
                        if (Utility.isNullOrEmpty(str6) || Utility.isNullOrEmpty(str7)) {
                            jSONArrayOptJSONArray = jSONArrayOptJSONArray;
                            str4 = str5;
                            z = true;
                            dialogFeatureConfig = null;
                        } else {
                            String strOptString6 = jSONObjectOptJSONObject3.optString("url");
                            if (!Utility.isNullOrEmpty(strOptString6)) {
                                Uri.parse(strOptString6);
                            }
                            JSONArray jSONArrayOptJSONArray4 = jSONObjectOptJSONObject3.optJSONArray("versions");
                            if (jSONArrayOptJSONArray4 != null) {
                                int length3 = jSONArrayOptJSONArray4.length();
                                int[] iArr = new int[length3];
                                if (length3 > 0) {
                                    z = true;
                                    while (true) {
                                        int i7 = i6 + 1;
                                        str4 = str5;
                                        int iOptInt3 = jSONArrayOptJSONArray4.optInt(i6, -1);
                                        if (iOptInt3 == -1) {
                                            String versionString = jSONArrayOptJSONArray4.optString(i6);
                                            if (!Utility.isNullOrEmpty(versionString)) {
                                                try {
                                                    Intrinsics.checkNotNullExpressionValue(versionString, "versionString");
                                                    i = Integer.parseInt(versionString);
                                                } catch (NumberFormatException unused) {
                                                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                                                    i = -1;
                                                }
                                                iOptInt3 = i;
                                            }
                                        }
                                        iArr[i6] = iOptInt3;
                                        if (i7 >= length3) {
                                            break;
                                        }
                                        i6 = i7;
                                        str5 = str4;
                                    }
                                } else {
                                    str4 = str5;
                                    z = true;
                                }
                            } else {
                                str4 = str5;
                                z = true;
                            }
                            dialogFeatureConfig = new FetchedAppSettings.DialogFeatureConfig();
                            dialogFeatureConfig.dialogName = str6;
                            dialogFeatureConfig.featureName = str7;
                        }
                    }
                }
                if (dialogFeatureConfig != null) {
                    String str8 = dialogFeatureConfig.dialogName;
                    Map map5 = (Map) map4.get(str8);
                    if (map5 == null) {
                        map5 = new HashMap();
                        map4.put(str8, map5);
                    }
                    map5.put(dialogFeatureConfig.featureName, dialogFeatureConfig);
                }
                if (i5 >= length) {
                    break;
                }
                dialogFeatureConfig = null;
                i4 = i5;
                jSONArrayOptJSONArray = jSONArrayOptJSONArray;
                str5 = str4;
            }
        }
        String strOptString7 = jSONObject.optString("smart_login_bookmark_icon_url");
        Intrinsics.checkNotNullExpressionValue(strOptString7, wsbWxekY.BJwU);
        String strOptString8 = jSONObject.optString("smart_login_menu_icon_url");
        Intrinsics.checkNotNullExpressionValue(strOptString8, "settingsJSON.optString(SMART_LOGIN_MENU_ICON_URL)");
        String strOptString9 = jSONObject.optString("sdk_update_message");
        Intrinsics.checkNotNullExpressionValue(strOptString9, "settingsJSON.optString(SDK_UPDATE_MESSAGE)");
        FetchedAppSettings fetchedAppSettings2 = new FetchedAppSettings(zOptBoolean, strOptString5, iOptInt2, result, map4, z2, facebookRequestErrorClassification2, strOptString7, strOptString8, z3, z4, jSONArrayOptJSONArray3, strOptString9, jSONObject.optString("aam_rules"), jSONObject.optString("suggested_events_setting"), jSONObject.optString("restrictive_data_filter_params"));
        fetchedAppSettings.put(applicationId, fetchedAppSettings2);
        return fetchedAppSettings2;
    }
}
