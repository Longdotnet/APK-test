package com.facebook;

import android.content.SharedPreferences;
import com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformerWebRequests;
import com.facebook.appevents.codeless.ViewIndexer;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import kotlin.ExceptionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class GraphRequest$Companion$$ExternalSyntheticLambda0 implements GraphRequest.Callback {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ GraphRequest$Companion$$ExternalSyntheticLambda0(int i) {
        this.$r8$classId = i;
    }

    private final void onCompleted$com$facebook$GraphRequest$Companion$$ExternalSyntheticLambda0(GraphResponse graphResponse) {
    }

    @Override // com.facebook.GraphRequest.Callback
    public final void onCompleted(GraphResponse graphResponse) {
        Object obj;
        boolean zBooleanValue = false;
        switch (this.$r8$classId) {
            case 0:
                return;
            case 1:
                LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
                FacebookRequestError facebookRequestError = graphResponse.error;
                Object obj2 = null;
                linkedHashMap = null;
                linkedHashMap = null;
                linkedHashMap = null;
                linkedHashMap = null;
                linkedHashMap = null;
                linkedHashMap = null;
                linkedHashMap = null;
                linkedHashMap = null;
                LinkedHashMap linkedHashMap = null;
                if (facebookRequestError != null) {
                    GraphRequest.Companion companion = Logger.Companion;
                    facebookRequestError.toString();
                    String.valueOf(facebookRequestError.exception);
                    synchronized (FacebookSdk.loggingBehaviors) {
                    }
                    if (!CrashShieldHandler.isObjectCrashing(MapsKt__MapsKt.class)) {
                        try {
                            SharedPreferences sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.sdk.CloudBridgeSavedCredentials", 0);
                            if (sharedPreferences != null) {
                                String string = sharedPreferences.getString("dataset_id", null);
                                String string2 = sharedPreferences.getString("endpoint", null);
                                String string3 = sharedPreferences.getString("access_key", null);
                                if (string != null && !StringsKt__StringsKt.isBlank(string) && string2 != null && !StringsKt__StringsKt.isBlank(string2) && string3 != null && !StringsKt__StringsKt.isBlank(string3)) {
                                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                                    linkedHashMap2.put("endpoint", string2);
                                    linkedHashMap2.put("dataset_id", string);
                                    linkedHashMap2.put("access_key", string3);
                                    GraphRequest.Companion.log(loggingBehavior, "com.facebook.appevents.cloudbridge.AppEventsCAPIManager", " \n\nLoading Cloudbridge settings from saved Prefs: \n================\n DATASETID: %s\n URL: %s \n ACCESSKEY: %s \n\n ", string, string2, string3);
                                    linkedHashMap = linkedHashMap2;
                                }
                            }
                        } catch (Throwable th) {
                            CrashShieldHandler.handleThrowable(MapsKt__MapsKt.class, th);
                        }
                    }
                    if (linkedHashMap != null) {
                        URL url = new URL(String.valueOf(linkedHashMap.get("endpoint")));
                        HashSet hashSet = AppEventsConversionsAPITransformerWebRequests.ACCEPTABLE_HTTP_RESPONSE;
                        AppEventsConversionsAPITransformerWebRequests.configure(String.valueOf(linkedHashMap.get("dataset_id")), url.getProtocol() + "://" + ((Object) url.getHost()), String.valueOf(linkedHashMap.get("access_key")));
                        MapsKt__MapsKt.isEnabled = true;
                        return;
                    }
                    return;
                }
                GraphRequest.Companion companion2 = Logger.Companion;
                GraphRequest.Companion.log(loggingBehavior, "com.facebook.appevents.cloudbridge.AppEventsCAPIManager", " \n\nGraph Response Received: \n================\n%s\n\n ", graphResponse);
                JSONObject jSONObject = graphResponse.graphObject;
                if (jSONObject == null) {
                    obj = null;
                } else {
                    try {
                        obj = jSONObject.get("data");
                    } catch (NullPointerException e) {
                        GraphRequest.Companion companion3 = Logger.Companion;
                        GraphRequest.Companion.log(loggingBehavior, "com.facebook.appevents.cloudbridge.AppEventsCAPIManager", "CloudBridge Settings API response is not a valid json: \n%s ", ExceptionsKt.stackTraceToString(e));
                        return;
                    } catch (JSONException e2) {
                        GraphRequest.Companion companion4 = Logger.Companion;
                        GraphRequest.Companion.log(loggingBehavior, "com.facebook.appevents.cloudbridge.AppEventsCAPIManager", "CloudBridge Settings API response is not a valid json: \n%s ", ExceptionsKt.stackTraceToString(e2));
                        return;
                    }
                }
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONArray");
                }
                ArrayList arrayListConvertJSONArrayToList = Utility.convertJSONArrayToList((JSONArray) obj);
                if (!arrayListConvertJSONArrayToList.isEmpty()) {
                    obj2 = arrayListConvertJSONArrayToList.get(0);
                }
                HashMap mapConvertJSONObjectToHashMap = Utility.convertJSONObjectToHashMap(new JSONObject((String) obj2));
                String str = (String) mapConvertJSONObjectToHashMap.get("endpoint");
                String str2 = (String) mapConvertJSONObjectToHashMap.get("dataset_id");
                String str3 = (String) mapConvertJSONObjectToHashMap.get("access_key");
                if (str == null || str2 == null || str3 == null) {
                    GraphRequest.Companion.log(loggingBehavior, "com.facebook.appevents.cloudbridge.AppEventsCAPIManager", "CloudBridge Settings API response doesn't have valid data");
                    return;
                }
                try {
                    AppEventsConversionsAPITransformerWebRequests.configure(str2, str, str3);
                    MapsKt__MapsKt.setSavedCloudBridgeCredentials$facebook_core_release(mapConvertJSONObjectToHashMap);
                    if (mapConvertJSONObjectToHashMap.get("is_enabled") != null) {
                        Object obj3 = mapConvertJSONObjectToHashMap.get("is_enabled");
                        if (obj3 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                        }
                        zBooleanValue = ((Boolean) obj3).booleanValue();
                    }
                    MapsKt__MapsKt.isEnabled = zBooleanValue;
                    return;
                } catch (MalformedURLException e3) {
                    GraphRequest.Companion companion5 = Logger.Companion;
                    GraphRequest.Companion.log(loggingBehavior, "com.facebook.appevents.cloudbridge.AppEventsCAPIManager", "CloudBridge Settings API response doesn't have valid url\n %s ", ExceptionsKt.stackTraceToString(e3));
                    return;
                }
            default:
                GraphRequest.Companion companion6 = Logger.Companion;
                GraphRequest.Companion.log(LoggingBehavior.APP_EVENTS, ViewIndexer.access$getTAG$cp(), "App index sent to FB!");
                return;
        }
    }
}
