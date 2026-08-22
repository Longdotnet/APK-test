package com.facebook;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.os.Trace;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.activity.ComponentDialog;
import androidx.appcompat.widget.AppCompatTextHelper;
import androidx.core.app.ActivityRecreator;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.os.TraceCompat;
import androidx.core.provider.FontsContractCompat$FontInfo;
import androidx.core.view.inputmethod.InputConnectionCompat$$ExternalSyntheticLambda0;
import androidx.emoji2.text.FontRequestEmojiCompatConfig;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.work.InputMergerFactory$1;
import com.facebook.appevents.AppEventQueue;
import com.facebook.appevents.FlushReason;
import com.facebook.appevents.cloudbridge.AppEventType;
import com.facebook.appevents.cloudbridge.AppEventUserAndAppDataField;
import com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformer;
import com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformerWebRequests;
import com.facebook.appevents.cloudbridge.ConversionsAPICustomEventField;
import com.facebook.appevents.cloudbridge.ConversionsAPIEventName;
import com.facebook.appevents.cloudbridge.ConversionsAPISection;
import com.facebook.appevents.cloudbridge.ConversionsAPIUserAndAppDataField;
import com.facebook.appevents.cloudbridge.CustomEventField;
import com.facebook.appevents.codeless.CodelessMatcher;
import com.facebook.appevents.codeless.internal.SensitiveUserDataUtils;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.appevents.suggestedevents.FeatureExtractor;
import com.facebook.appevents.suggestedevents.SuggestedEventViewHierarchy;
import com.facebook.appevents.suggestedevents.ViewObserver;
import com.facebook.appevents.suggestedevents.ViewOnClickListener;
import com.facebook.internal.FacebookWebFallbackDialog;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.DeviceAuthDialog;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.gms.ads.zza;
import com.google.android.gms.games.provider.NtJ.wsbWxekY;
import com.google.android.gms.internal.common.Ko.TSDAbK;
import com.google.firebase.installations.FirebaseInstallations;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;
import kotlin.ExceptionsKt;
import kotlin.UninitializedPropertyAccessException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt__IndentKt;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.Dispatcher;
import okio.AsyncTimeout;
import okio.Okio;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class AccessTokenManager$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ AccessTokenManager$$ExternalSyntheticLambda0(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    /* JADX WARN: Code duplicated, block: B:169:0x0351  */
    /* JADX WARN: Code duplicated, block: B:206:0x0421  */
    /* JADX WARN: Code duplicated, block: B:208:0x043b  */
    /* JADX WARN: Code duplicated, block: B:210:0x0441 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:211:0x0443  */
    /* JADX WARN: Code duplicated, block: B:212:0x0448  */
    /* JADX WARN: Code duplicated, block: B:214:0x044f  */
    /* JADX WARN: Code duplicated, block: B:215:0x0451  */
    /* JADX WARN: Code duplicated, block: B:217:0x0454  */
    /* JADX WARN: Code duplicated, block: B:218:0x045d  */
    /* JADX WARN: Code duplicated, block: B:220:0x0466  */
    /* JADX WARN: Code duplicated, block: B:222:0x046c A[LOOP:2: B:221:0x046a->B:222:0x046c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:223:0x0476  */
    /* JADX WARN: Code duplicated, block: B:226:0x0480 A[LOOP:3: B:224:0x047a->B:226:0x0480, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:236:0x049c  */
    /* JADX WARN: Code duplicated, block: B:241:0x04d0  */
    /* JADX WARN: Code duplicated, block: B:244:0x04f9  */
    /* JADX WARN: Code duplicated, block: B:247:0x0548 A[Catch: IOException -> 0x0570, UnknownHostException -> 0x0573, TryCatch #10 {UnknownHostException -> 0x0573, IOException -> 0x0570, blocks: (B:245:0x053d, B:247:0x0548, B:258:0x0578, B:260:0x0582, B:265:0x0592, B:267:0x05cf, B:275:0x05eb, B:280:0x05f2, B:281:0x05f5, B:282:0x05f6, B:250:0x0556, B:251:0x055a, B:253:0x0560, B:283:0x062b, B:284:0x0632), top: B:315:0x053d }] */
    /* JADX WARN: Code duplicated, block: B:249:0x0555  */
    /* JADX WARN: Code duplicated, block: B:250:0x0556 A[Catch: IOException -> 0x0570, UnknownHostException -> 0x0573, TryCatch #10 {UnknownHostException -> 0x0573, IOException -> 0x0570, blocks: (B:245:0x053d, B:247:0x0548, B:258:0x0578, B:260:0x0582, B:265:0x0592, B:267:0x05cf, B:275:0x05eb, B:280:0x05f2, B:281:0x05f5, B:282:0x05f6, B:250:0x0556, B:251:0x055a, B:253:0x0560, B:283:0x062b, B:284:0x0632), top: B:315:0x053d }] */
    /* JADX WARN: Code duplicated, block: B:253:0x0560 A[Catch: IOException -> 0x0570, UnknownHostException -> 0x0573, LOOP:5: B:251:0x055a->B:253:0x0560, LOOP_END, TryCatch #10 {UnknownHostException -> 0x0573, IOException -> 0x0570, blocks: (B:245:0x053d, B:247:0x0548, B:258:0x0578, B:260:0x0582, B:265:0x0592, B:267:0x05cf, B:275:0x05eb, B:280:0x05f2, B:281:0x05f5, B:282:0x05f6, B:250:0x0556, B:251:0x055a, B:253:0x0560, B:283:0x062b, B:284:0x0632), top: B:315:0x053d }] */
    /* JADX WARN: Code duplicated, block: B:264:0x0591  */
    /* JADX WARN: Code duplicated, block: B:267:0x05cf A[Catch: IOException -> 0x0570, UnknownHostException -> 0x0573, TRY_LEAVE, TryCatch #10 {UnknownHostException -> 0x0573, IOException -> 0x0570, blocks: (B:245:0x053d, B:247:0x0548, B:258:0x0578, B:260:0x0582, B:265:0x0592, B:267:0x05cf, B:275:0x05eb, B:280:0x05f2, B:281:0x05f5, B:282:0x05f6, B:250:0x0556, B:251:0x055a, B:253:0x0560, B:283:0x062b, B:284:0x0632), top: B:315:0x053d }] */
    /* JADX WARN: Code duplicated, block: B:270:0x05e3 A[Catch: all -> 0x05e7, TRY_LEAVE, TryCatch #5 {all -> 0x05e7, blocks: (B:268:0x05dd, B:270:0x05e3), top: B:310:0x05dd }] */
    /* JADX WARN: Code duplicated, block: B:283:0x062b A[Catch: IOException -> 0x0570, UnknownHostException -> 0x0573, TryCatch #10 {UnknownHostException -> 0x0573, IOException -> 0x0570, blocks: (B:245:0x053d, B:247:0x0548, B:258:0x0578, B:260:0x0582, B:265:0x0592, B:267:0x05cf, B:275:0x05eb, B:280:0x05f2, B:281:0x05f5, B:282:0x05f6, B:250:0x0556, B:251:0x055a, B:253:0x0560, B:283:0x062b, B:284:0x0632), top: B:315:0x053d }] */
    /* JADX WARN: Code duplicated, block: B:287:0x0667  */
    /* JADX WARN: Code duplicated, block: B:320:0x05ea A[EDGE_INSN: B:320:0x05ea->B:274:0x05ea BREAK  A[LOOP:4: B:310:0x05dd->B:321:?], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:355:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v109, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v130, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v132, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r11v19, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.facebook.LoggingBehavior] */
    /* JADX WARN: Type inference failed for: r7v17, types: [java.lang.Object, java.util.Map] */
    private final void run$com$facebook$appevents$cloudbridge$AppEventsConversionsAPITransformerWebRequests$$ExternalSyntheticLambda0() {
        String str;
        GraphRequest graphRequest;
        LoggingBehavior loggingBehavior;
        String str2;
        String str3;
        ?? ListOf;
        int iMax;
        List list;
        List transformedEvents$facebook_core_release;
        IntRange intRange;
        LinkedHashMap linkedHashMap;
        AppEventsConversionsAPITransformerWebRequests.CloudBridgeCredentials cloudBridgeCredentials;
        String str4;
        String string;
        Map mapSingletonMap;
        URLConnection uRLConnectionOpenConnection;
        HttpURLConnection httpURLConnection;
        String str5;
        Set<String> setKeySet;
        boolean z;
        StringBuilder sb;
        BufferedReader bufferedReader;
        String line;
        List transformedEvents$facebook_core_release2;
        int size;
        ArrayList arrayList;
        ListIterator listIterator;
        List listListOf;
        int size2;
        LinkedHashMap linkedHashMap2;
        AppEventType appEventType;
        AppEventUserAndAppDataField appEventUserAndAppDataField;
        AppEventType appEventType2;
        AppEventsConversionsAPITransformer.DataProcessingParameterName dataProcessingParameterName;
        ArrayList arrayList2;
        CustomEventField customEventField;
        ?? r2 = 2;
        String str6 = null;
        GraphRequest graphRequest2 = (GraphRequest) this.f$0;
        String str7 = graphRequest2.graphPath;
        List listSplit$default = str7 == null ? null : StringsKt__StringsKt.split$default(str7, new String[]{"/"}, 0, 6);
        LoggingBehavior loggingBehavior2 = LoggingBehavior.DEVELOPER_ERRORS;
        String str8 = TSDAbK.BxitJ;
        if (listSplit$default == null || listSplit$default.size() != 2) {
            GraphRequest.Companion companion = Logger.Companion;
            GraphRequest.Companion.log(loggingBehavior2, str8, "\n GraphPathComponents Error when logging: \n%s", graphRequest2);
            return;
        }
        try {
            AppEventsConversionsAPITransformerWebRequests.CloudBridgeCredentials cloudBridgeCredentials2 = AppEventsConversionsAPITransformerWebRequests.credentials;
            try {
                if (cloudBridgeCredentials2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("credentials");
                    throw null;
                }
                String str9 = cloudBridgeCredentials2.cloudBridgeURL;
                if (cloudBridgeCredentials2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("credentials");
                    throw null;
                }
                String str10 = str9 + "/capi/" + cloudBridgeCredentials2.datasetID + "/events";
                JSONObject jSONObject = graphRequest2.graphObject;
                LoggingBehavior loggingBehavior3 = LoggingBehavior.APP_EVENTS;
                if (jSONObject != null) {
                    LinkedHashMap mutableMap = MapsKt__MapsKt.toMutableMap(Utility.convertJSONObjectToHashMap(jSONObject));
                    String str11 = graphRequest2.tag;
                    if (str11 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
                    }
                    String str12 = "custom_events";
                    mutableMap.put("custom_events", str11);
                    StringBuilder sb2 = new StringBuilder();
                    for (String str13 : mutableMap.keySet()) {
                        sb2.append(str13);
                        sb2.append(" : ");
                        sb2.append(mutableMap.get(str13));
                        sb2.append(System.getProperty("line.separator"));
                    }
                    GraphRequest.Companion companion2 = Logger.Companion;
                    synchronized (FacebookSdk.loggingBehaviors) {
                    }
                    Object obj = AppEventsConversionsAPITransformer.topLevelTransformations;
                    LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                    LinkedHashMap linkedHashMap4 = new LinkedHashMap();
                    ArrayList<Map> arrayList3 = new ArrayList();
                    LinkedHashMap linkedHashMap5 = new LinkedHashMap();
                    Object obj2 = mutableMap.get("event");
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str14 = (String) obj2;
                    boolean zEquals = str14.equals("MOBILE_APP_INSTALL");
                    loggingBehavior = loggingBehavior2;
                    AppEventType appEventType3 = AppEventType.OTHER;
                    str = "POST";
                    AppEventType appEventType4 = AppEventType.CUSTOM;
                    AppEventType appEventType5 = zEquals ? AppEventType.MOBILE_APP_INSTALL : str14.equals("CUSTOM_APP_EVENTS") ? appEventType4 : appEventType3;
                    if (appEventType5 == appEventType3) {
                        graphRequest = graphRequest2;
                        appEventType = appEventType3;
                        str2 = str8;
                        str3 = str10;
                        linkedHashMap2 = mutableMap;
                    } else {
                        for (Map.Entry entry : mutableMap.entrySet()) {
                            String str15 = str8;
                            String rawValue = (String) entry.getKey();
                            GraphRequest graphRequest3 = graphRequest2;
                            Object value = entry.getValue();
                            String str16 = str10;
                            String str17 = "rawValue";
                            Intrinsics.checkNotNullParameter(rawValue, "rawValue");
                            AppEventUserAndAppDataField[] appEventUserAndAppDataFieldArrValuesCustom = AppEventUserAndAppDataField.valuesCustom();
                            LinkedHashMap linkedHashMap6 = mutableMap;
                            int length = appEventUserAndAppDataFieldArrValuesCustom.length;
                            AppEventType appEventType6 = appEventType3;
                            int i = 0;
                            while (true) {
                                if (i >= length) {
                                    appEventUserAndAppDataField = null;
                                    break;
                                }
                                int i2 = length;
                                appEventUserAndAppDataField = appEventUserAndAppDataFieldArrValuesCustom[i];
                                AppEventUserAndAppDataField[] appEventUserAndAppDataFieldArr = appEventUserAndAppDataFieldArrValuesCustom;
                                if (appEventUserAndAppDataField.rawValue.equals(rawValue)) {
                                    break;
                                }
                                i++;
                                length = i2;
                                appEventUserAndAppDataFieldArrValuesCustom = appEventUserAndAppDataFieldArr;
                            }
                            String str18 = wsbWxekY.KDECdqkFnMkhirG;
                            LinkedHashMap linkedHashMap7 = linkedHashMap5;
                            if (appEventUserAndAppDataField != null) {
                                Intrinsics.checkNotNullParameter(value, "value");
                                ?? r0 = AppEventsConversionsAPITransformer.topLevelTransformations;
                                AppEventsConversionsAPITransformer.SectionFieldMapping sectionFieldMapping = (AppEventsConversionsAPITransformer.SectionFieldMapping) r0.get(appEventUserAndAppDataField);
                                if (sectionFieldMapping != null) {
                                    int iOrdinal = sectionFieldMapping.section.ordinal();
                                    if (iOrdinal != 0) {
                                        if (iOrdinal == 1) {
                                            AppEventsConversionsAPITransformer.SectionFieldMapping sectionFieldMapping2 = (AppEventsConversionsAPITransformer.SectionFieldMapping) r0.get(appEventUserAndAppDataField);
                                            ConversionsAPIUserAndAppDataField conversionsAPIUserAndAppDataField = sectionFieldMapping2 == null ? null : sectionFieldMapping2.field;
                                            if (conversionsAPIUserAndAppDataField != null) {
                                                linkedHashMap4.put(conversionsAPIUserAndAppDataField.rawValue, value);
                                            }
                                        }
                                    } else if (appEventUserAndAppDataField == AppEventUserAndAppDataField.USER_DATA) {
                                        try {
                                            linkedHashMap3.putAll(Utility.convertJSONObjectToHashMap(new JSONObject((String) value)));
                                        } catch (JSONException e) {
                                            GraphRequest.Companion companion3 = Logger.Companion;
                                            GraphRequest.Companion.log(loggingBehavior3, "AppEventsConversionsAPITransformer", str18, value, e);
                                        }
                                    } else {
                                        AppEventsConversionsAPITransformer.SectionFieldMapping sectionFieldMapping3 = (AppEventsConversionsAPITransformer.SectionFieldMapping) r0.get(appEventUserAndAppDataField);
                                        ConversionsAPIUserAndAppDataField conversionsAPIUserAndAppDataField2 = sectionFieldMapping3 == null ? null : sectionFieldMapping3.field;
                                        if (conversionsAPIUserAndAppDataField2 != null) {
                                            linkedHashMap3.put(conversionsAPIUserAndAppDataField2.rawValue, value);
                                        }
                                    }
                                }
                                appEventType2 = appEventType4;
                                str12 = str12;
                            } else {
                                boolean zEquals2 = rawValue.equals(str12);
                                boolean z2 = value instanceof String;
                                if (appEventType5 == appEventType4 && zEquals2 && z2) {
                                    String appEvents = (String) value;
                                    Intrinsics.checkNotNullParameter(appEvents, "appEvents");
                                    ArrayList arrayList4 = new ArrayList();
                                    try {
                                        Iterator it = Utility.convertJSONArrayToList(new JSONArray(appEvents)).iterator();
                                        while (it.hasNext()) {
                                            appEventType2 = appEventType4;
                                            try {
                                                arrayList4.add(Utility.convertJSONObjectToHashMap(new JSONObject((String) it.next())));
                                                appEventType4 = appEventType2;
                                            } catch (JSONException e2) {
                                                e = e2;
                                                GraphRequest.Companion companion4 = Logger.Companion;
                                                GraphRequest.Companion.log(loggingBehavior3, "AppEventsConversionsAPITransformer", str18, appEvents, e);
                                                arrayList2 = null;
                                                if (arrayList2 != null) {
                                                    arrayList3.addAll(arrayList2);
                                                }
                                                linkedHashMap5 = linkedHashMap7;
                                                graphRequest2 = graphRequest3;
                                                str8 = str15;
                                                str10 = str16;
                                                mutableMap = linkedHashMap6;
                                                appEventType3 = appEventType6;
                                                appEventType4 = appEventType2;
                                                str12 = str12;
                                            }
                                        }
                                        appEventType2 = appEventType4;
                                        if (arrayList4.isEmpty()) {
                                            arrayList2 = null;
                                        } else {
                                            arrayList2 = new ArrayList();
                                            Iterator it2 = arrayList4.iterator();
                                            while (it2.hasNext()) {
                                                Map map = (Map) it2.next();
                                                LinkedHashMap linkedHashMap8 = new LinkedHashMap();
                                                LinkedHashMap linkedHashMap9 = new LinkedHashMap();
                                                for (String str19 : map.keySet()) {
                                                    Intrinsics.checkNotNullParameter(str19, str17);
                                                    Iterator it3 = it2;
                                                    CustomEventField[] customEventFieldArrValuesCustom = CustomEventField.valuesCustom();
                                                    String str20 = str17;
                                                    int length2 = customEventFieldArrValuesCustom.length;
                                                    String str21 = str12;
                                                    int i3 = 0;
                                                    while (true) {
                                                        if (i3 >= length2) {
                                                            customEventField = null;
                                                            break;
                                                        }
                                                        int i4 = length2;
                                                        customEventField = customEventFieldArrValuesCustom[i3];
                                                        CustomEventField[] customEventFieldArr = customEventFieldArrValuesCustom;
                                                        if (customEventField.rawValue.equals(str19)) {
                                                            break;
                                                        }
                                                        i3++;
                                                        length2 = i4;
                                                        customEventFieldArrValuesCustom = customEventFieldArr;
                                                    }
                                                    AppEventsConversionsAPITransformer.SectionCustomEventFieldMapping sectionCustomEventFieldMapping = (AppEventsConversionsAPITransformer.SectionCustomEventFieldMapping) AppEventsConversionsAPITransformer.customEventTransformations.get(customEventField);
                                                    if (customEventField != null && sectionCustomEventFieldMapping != null) {
                                                        ConversionsAPICustomEventField conversionsAPICustomEventField = sectionCustomEventFieldMapping.field;
                                                        ConversionsAPISection conversionsAPISection = sectionCustomEventFieldMapping.section;
                                                        if (conversionsAPISection == null) {
                                                            try {
                                                                String str22 = conversionsAPICustomEventField.rawValue;
                                                                if (customEventField == CustomEventField.EVENT_NAME && ((String) map.get(str19)) != null) {
                                                                    Object obj3 = map.get(str19);
                                                                    if (obj3 == null) {
                                                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                                                    }
                                                                    String str23 = (String) obj3;
                                                                    ?? r11 = AppEventsConversionsAPITransformer.standardEventTransformations;
                                                                    if (r11.containsKey(str23)) {
                                                                        ConversionsAPIEventName conversionsAPIEventName = (ConversionsAPIEventName) r11.get(str23);
                                                                        str23 = conversionsAPIEventName == null ? "" : conversionsAPIEventName.rawValue;
                                                                    }
                                                                    linkedHashMap9.put(str22, str23);
                                                                } else if (customEventField == CustomEventField.EVENT_TIME && ((Integer) map.get(str19)) != null) {
                                                                    Object obj4 = map.get(str19);
                                                                    if (obj4 == null) {
                                                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
                                                                    }
                                                                    Object objTransformValue$facebook_core_release = AppEventsConversionsAPITransformer.transformValue$facebook_core_release(obj4, str19);
                                                                    if (objTransformValue$facebook_core_release == null) {
                                                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
                                                                    }
                                                                    linkedHashMap9.put(str22, objTransformValue$facebook_core_release);
                                                                }
                                                            } catch (ClassCastException e3) {
                                                                GraphRequest.Companion companion5 = Logger.Companion;
                                                                GraphRequest.Companion.log(loggingBehavior3, "AppEventsConversionsAPITransformer", "\n transformEvents ClassCastException: \n %s ", ExceptionsKt.stackTraceToString(e3));
                                                            }
                                                        } else if (conversionsAPISection == ConversionsAPISection.CUSTOM_DATA) {
                                                            String str24 = conversionsAPICustomEventField.rawValue;
                                                            Object obj5 = map.get(str19);
                                                            if (obj5 == null) {
                                                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
                                                            }
                                                            Object objTransformValue$facebook_core_release2 = AppEventsConversionsAPITransformer.transformValue$facebook_core_release(obj5, str19);
                                                            if (objTransformValue$facebook_core_release2 == null) {
                                                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
                                                            }
                                                            linkedHashMap8.put(str24, objTransformValue$facebook_core_release2);
                                                        } else {
                                                            continue;
                                                        }
                                                    }
                                                    it2 = it3;
                                                    str17 = str20;
                                                    str12 = str21;
                                                }
                                                Iterator it4 = it2;
                                                String str25 = str17;
                                                String str26 = str12;
                                                if (!linkedHashMap8.isEmpty()) {
                                                    linkedHashMap9.put("custom_data", linkedHashMap8);
                                                }
                                                arrayList2.add(linkedHashMap9);
                                                it2 = it4;
                                                str17 = str25;
                                                str12 = str26;
                                            }
                                            str12 = str12;
                                        }
                                    } catch (JSONException e4) {
                                        e = e4;
                                        appEventType2 = appEventType4;
                                    }
                                    if (arrayList2 != null) {
                                        arrayList3.addAll(arrayList2);
                                    }
                                } else {
                                    appEventType2 = appEventType4;
                                    str12 = str12;
                                    AppEventsConversionsAPITransformer.DataProcessingParameterName[] dataProcessingParameterNameArrValuesCustom = AppEventsConversionsAPITransformer.DataProcessingParameterName.valuesCustom();
                                    int length3 = dataProcessingParameterNameArrValuesCustom.length;
                                    int i5 = 0;
                                    while (true) {
                                        if (i5 >= length3) {
                                            dataProcessingParameterName = null;
                                            break;
                                        }
                                        dataProcessingParameterName = dataProcessingParameterNameArrValuesCustom[i5];
                                        if (dataProcessingParameterName.rawValue.equals(rawValue)) {
                                            break;
                                        } else {
                                            i5++;
                                        }
                                    }
                                    if (dataProcessingParameterName != null) {
                                        linkedHashMap5 = linkedHashMap7;
                                        linkedHashMap5.put(rawValue, value);
                                    }
                                    graphRequest2 = graphRequest3;
                                    str8 = str15;
                                    str10 = str16;
                                    mutableMap = linkedHashMap6;
                                    appEventType3 = appEventType6;
                                    appEventType4 = appEventType2;
                                    str12 = str12;
                                }
                            }
                            linkedHashMap5 = linkedHashMap7;
                            graphRequest2 = graphRequest3;
                            str8 = str15;
                            str10 = str16;
                            mutableMap = linkedHashMap6;
                            appEventType3 = appEventType6;
                            appEventType4 = appEventType2;
                            str12 = str12;
                        }
                        graphRequest = graphRequest2;
                        str2 = str8;
                        str3 = str10;
                        linkedHashMap2 = mutableMap;
                        appEventType = appEventType3;
                    }
                    if (appEventType5 != appEventType) {
                        Object obj6 = linkedHashMap2.get("install_timestamp");
                        LinkedHashMap linkedHashMap10 = new LinkedHashMap();
                        linkedHashMap10.put("action_source", "app");
                        linkedHashMap10.put("user_data", linkedHashMap3);
                        linkedHashMap10.put("app_data", linkedHashMap4);
                        linkedHashMap10.putAll(linkedHashMap5);
                        int iOrdinal2 = appEventType5.ordinal();
                        if (iOrdinal2 != 0) {
                            if (iOrdinal2 == 1 && !arrayList3.isEmpty()) {
                                ListOf = new ArrayList();
                                for (Map map2 : arrayList3) {
                                    LinkedHashMap linkedHashMap11 = new LinkedHashMap();
                                    linkedHashMap11.putAll(linkedHashMap10);
                                    linkedHashMap11.putAll(map2);
                                    ListOf.add(linkedHashMap11);
                                }
                            }
                        } else if (obj6 != null) {
                            LinkedHashMap linkedHashMap12 = new LinkedHashMap();
                            linkedHashMap12.putAll(linkedHashMap10);
                            linkedHashMap12.put("event_name", "MobileAppInstall");
                            linkedHashMap12.put("event_time", obj6);
                            ListOf = Okio.listOf(linkedHashMap12);
                        }
                    }
                    if (ListOf == 0) {
                        return;
                    }
                    AppEventsConversionsAPITransformerWebRequests.getTransformedEvents$facebook_core_release().addAll(ListOf);
                    iMax = Math.max(0, AppEventsConversionsAPITransformerWebRequests.getTransformedEvents$facebook_core_release().size() - 1000);
                    list = EmptyList.INSTANCE;
                    if (iMax > 0) {
                        transformedEvents$facebook_core_release2 = AppEventsConversionsAPITransformerWebRequests.getTransformedEvents$facebook_core_release();
                        if (iMax >= 0) {
                            throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iMax, "Requested element count ", " is less than zero.").toString());
                        }
                        if (iMax == 0) {
                            listListOf = CollectionsKt.toList(transformedEvents$facebook_core_release2);
                        } else {
                            size = transformedEvents$facebook_core_release2.size() - iMax;
                            if (size <= 0) {
                                listListOf = list;
                            } else if (size == 1) {
                                listListOf = Okio.listOf(CollectionsKt.last(transformedEvents$facebook_core_release2));
                            } else {
                                arrayList = new ArrayList(size);
                                if (transformedEvents$facebook_core_release2 instanceof RandomAccess) {
                                    size2 = transformedEvents$facebook_core_release2.size();
                                    while (iMax < size2) {
                                        arrayList.add(transformedEvents$facebook_core_release2.get(iMax));
                                        iMax++;
                                    }
                                } else {
                                    listIterator = transformedEvents$facebook_core_release2.listIterator(iMax);
                                    while (listIterator.hasNext()) {
                                        arrayList.add(listIterator.next());
                                    }
                                }
                                listListOf = arrayList;
                            }
                        }
                        if (!(listListOf instanceof KMappedMarker) && !(listListOf instanceof KMutableList)) {
                            TypeIntrinsics.throwCce(listListOf, "kotlin.collections.MutableList");
                            throw null;
                        }
                        AppEventsConversionsAPITransformerWebRequests.transformedEvents = listListOf;
                    }
                    int iMin = Math.min(AppEventsConversionsAPITransformerWebRequests.getTransformedEvents$facebook_core_release().size(), 10);
                    transformedEvents$facebook_core_release = AppEventsConversionsAPITransformerWebRequests.getTransformedEvents$facebook_core_release();
                    intRange = new IntRange(0, iMin - 1, 1);
                    if (!intRange.isEmpty()) {
                        list = CollectionsKt.toList(transformedEvents$facebook_core_release.subList(0, intRange.last + 1));
                    }
                    AppEventsConversionsAPITransformerWebRequests.getTransformedEvents$facebook_core_release().subList(0, iMin).clear();
                    JSONArray jSONArray = new JSONArray((Collection) list);
                    linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put("data", jSONArray);
                    cloudBridgeCredentials = AppEventsConversionsAPITransformerWebRequests.credentials;
                    if (cloudBridgeCredentials != null) {
                        Intrinsics.throwUninitializedPropertyAccessException("credentials");
                        throw null;
                    }
                    linkedHashMap.put("accessKey", cloudBridgeCredentials.accessKey);
                    JSONObject jSONObject2 = new JSONObject((Map) linkedHashMap);
                    GraphRequest.Companion companion6 = Logger.Companion;
                    String string2 = jSONObject2.toString(2);
                    Intrinsics.checkNotNullExpressionValue(string2, "jsonBodyStr.toString(2)");
                    Object[] objArr = {str3, graphRequest, string2};
                    str4 = str2;
                    GraphRequest.Companion.log(loggingBehavior3, str4, "\nTransformed_CAPI_JSON:\nURL: %s\nFROM=========\n%s\n>>>>>>TO>>>>>>\n%s\n=============\n", objArr);
                    string = jSONObject2.toString();
                    mapSingletonMap = Collections.singletonMap("Content-Type", "application/json");
                    Intrinsics.checkNotNullExpressionValue(mapSingletonMap, "singletonMap(pair.first, pair.second)");
                    String urlStr = str3;
                    Intrinsics.checkNotNullParameter(urlStr, "urlStr");
                    try {
                        uRLConnectionOpenConnection = new URL(urlStr).openConnection();
                        if (uRLConnectionOpenConnection != null) {
                            throw new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
                        }
                        httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
                        str5 = str;
                        httpURLConnection.setRequestMethod(str5);
                        setKeySet = mapSingletonMap.keySet();
                        if (setKeySet == null) {
                            for (String str27 : setKeySet) {
                                httpURLConnection.setRequestProperty(str27, (String) mapSingletonMap.get(str27));
                            }
                        }
                        if (!httpURLConnection.getRequestMethod().equals(str5) || httpURLConnection.getRequestMethod().equals("PUT")) {
                            z = true;
                        } else {
                            z = false;
                        }
                        httpURLConnection.setDoOutput(z);
                        httpURLConnection.setConnectTimeout(60000);
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(bufferedOutputStream, "UTF-8"));
                        bufferedWriter.write(string);
                        bufferedWriter.flush();
                        bufferedWriter.close();
                        bufferedOutputStream.close();
                        sb = new StringBuilder();
                        if (AppEventsConversionsAPITransformerWebRequests.ACCEPTABLE_HTTP_RESPONSE.contains(Integer.valueOf(httpURLConnection.getResponseCode()))) {
                            bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
                            while (true) {
                                try {
                                    line = bufferedReader.readLine();
                                    if (line != null) {
                                        break;
                                    } else {
                                        sb.append(line);
                                    }
                                } catch (Throwable th) {
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        CloseableKt.closeFinally(bufferedReader, th);
                                        throw th2;
                                    }
                                }
                            }
                            CloseableKt.closeFinally(bufferedReader, null);
                        }
                        String string3 = sb.toString();
                        Intrinsics.checkNotNullExpressionValue(string3, "connResponseSB.toString()");
                        GraphRequest.Companion companion7 = Logger.Companion;
                        GraphRequest.Companion.log(loggingBehavior3, str4, "\nResponse Received: \n%s\n%s", string3, Integer.valueOf(httpURLConnection.getResponseCode()));
                        Utility.runOnNonUiThread(new GraphRequest$Companion$$ExternalSyntheticLambda1(Integer.valueOf(httpURLConnection.getResponseCode()), list, 13));
                        return;
                    } catch (UnknownHostException e5) {
                        GraphRequest.Companion companion8 = Logger.Companion;
                        GraphRequest.Companion.log(loggingBehavior3, str4, "Connection failed, retrying: \n%s", e5.toString());
                        Utility.runOnNonUiThread(new GraphRequest$Companion$$ExternalSyntheticLambda1(503, list, 13));
                        return;
                    } catch (IOException e6) {
                        GraphRequest.Companion companion9 = Logger.Companion;
                        GraphRequest.Companion.log(loggingBehavior, str4, "Send to server failed: \n%s", e6.toString());
                        return;
                    }
                }
                str = "POST";
                graphRequest = graphRequest2;
                loggingBehavior = loggingBehavior2;
                str2 = str8;
                str3 = str10;
                ListOf = 0;
                if (ListOf == 0) {
                    return;
                }
                AppEventsConversionsAPITransformerWebRequests.getTransformedEvents$facebook_core_release().addAll(ListOf);
                iMax = Math.max(0, AppEventsConversionsAPITransformerWebRequests.getTransformedEvents$facebook_core_release().size() - 1000);
                list = EmptyList.INSTANCE;
                if (iMax > 0) {
                    transformedEvents$facebook_core_release2 = AppEventsConversionsAPITransformerWebRequests.getTransformedEvents$facebook_core_release();
                    if (iMax >= 0) {
                        throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iMax, "Requested element count ", " is less than zero.").toString());
                    }
                    if (iMax == 0) {
                        listListOf = CollectionsKt.toList(transformedEvents$facebook_core_release2);
                    } else {
                        size = transformedEvents$facebook_core_release2.size() - iMax;
                        if (size <= 0) {
                            listListOf = list;
                        } else if (size == 1) {
                            listListOf = Okio.listOf(CollectionsKt.last(transformedEvents$facebook_core_release2));
                        } else {
                            arrayList = new ArrayList(size);
                            if (transformedEvents$facebook_core_release2 instanceof RandomAccess) {
                                size2 = transformedEvents$facebook_core_release2.size();
                                while (iMax < size2) {
                                    arrayList.add(transformedEvents$facebook_core_release2.get(iMax));
                                    iMax++;
                                }
                            } else {
                                listIterator = transformedEvents$facebook_core_release2.listIterator(iMax);
                                while (listIterator.hasNext()) {
                                    arrayList.add(listIterator.next());
                                }
                            }
                            listListOf = arrayList;
                        }
                    }
                    if (!(listListOf instanceof KMappedMarker)) {
                    }
                    AppEventsConversionsAPITransformerWebRequests.transformedEvents = listListOf;
                }
                int iMin2 = Math.min(AppEventsConversionsAPITransformerWebRequests.getTransformedEvents$facebook_core_release().size(), 10);
                transformedEvents$facebook_core_release = AppEventsConversionsAPITransformerWebRequests.getTransformedEvents$facebook_core_release();
                intRange = new IntRange(0, iMin2 - 1, 1);
                if (!intRange.isEmpty()) {
                    list = CollectionsKt.toList(transformedEvents$facebook_core_release.subList(0, intRange.last + 1));
                }
                AppEventsConversionsAPITransformerWebRequests.getTransformedEvents$facebook_core_release().subList(0, iMin2).clear();
                JSONArray jSONArray2 = new JSONArray((Collection) list);
                linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("data", jSONArray2);
                cloudBridgeCredentials = AppEventsConversionsAPITransformerWebRequests.credentials;
                if (cloudBridgeCredentials != null) {
                    Intrinsics.throwUninitializedPropertyAccessException("credentials");
                    throw null;
                }
                linkedHashMap.put("accessKey", cloudBridgeCredentials.accessKey);
                JSONObject jSONObject3 = new JSONObject((Map) linkedHashMap);
                GraphRequest.Companion companion10 = Logger.Companion;
                String string4 = jSONObject3.toString(2);
                Intrinsics.checkNotNullExpressionValue(string4, "jsonBodyStr.toString(2)");
                Object[] objArr2 = {str3, graphRequest, string4};
                str4 = str2;
                GraphRequest.Companion.log(loggingBehavior3, str4, "\nTransformed_CAPI_JSON:\nURL: %s\nFROM=========\n%s\n>>>>>>TO>>>>>>\n%s\n=============\n", objArr2);
                string = jSONObject3.toString();
                mapSingletonMap = Collections.singletonMap("Content-Type", "application/json");
                Intrinsics.checkNotNullExpressionValue(mapSingletonMap, "singletonMap(pair.first, pair.second)");
                String urlStr2 = str3;
                Intrinsics.checkNotNullParameter(urlStr2, "urlStr");
                uRLConnectionOpenConnection = new URL(urlStr2).openConnection();
                if (uRLConnectionOpenConnection != null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
                }
                httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
                str5 = str;
                httpURLConnection.setRequestMethod(str5);
                setKeySet = mapSingletonMap.keySet();
                if (setKeySet == null) {
                    while (r7.hasNext()) {
                        httpURLConnection.setRequestProperty(str27, (String) mapSingletonMap.get(str27));
                    }
                }
                if (httpURLConnection.getRequestMethod().equals(str5)) {
                    z = true;
                } else {
                    z = true;
                }
                httpURLConnection.setDoOutput(z);
                httpURLConnection.setConnectTimeout(60000);
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(httpURLConnection.getOutputStream());
                BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(bufferedOutputStream2, "UTF-8"));
                bufferedWriter2.write(string);
                bufferedWriter2.flush();
                bufferedWriter2.close();
                bufferedOutputStream2.close();
                sb = new StringBuilder();
                if (AppEventsConversionsAPITransformerWebRequests.ACCEPTABLE_HTTP_RESPONSE.contains(Integer.valueOf(httpURLConnection.getResponseCode()))) {
                    bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
                    while (true) {
                        line = bufferedReader.readLine();
                        if (line != null) {
                            break;
                            break;
                        }
                        sb.append(line);
                    }
                    CloseableKt.closeFinally(bufferedReader, null);
                }
                String string5 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(string5, "connResponseSB.toString()");
                GraphRequest.Companion companion11 = Logger.Companion;
                GraphRequest.Companion.log(loggingBehavior3, str4, "\nResponse Received: \n%s\n%s", string5, Integer.valueOf(httpURLConnection.getResponseCode()));
                Utility.runOnNonUiThread(new GraphRequest$Companion$$ExternalSyntheticLambda1(Integer.valueOf(httpURLConnection.getResponseCode()), list, 13));
                return;
            } catch (UninitializedPropertyAccessException e7) {
                e = e7;
            }
        } catch (UninitializedPropertyAccessException e8) {
            e = e8;
            r2 = loggingBehavior2;
            str6 = str8;
        }
        GraphRequest.Companion companion12 = Logger.Companion;
        GraphRequest.Companion.log(r2, str6, "\n Credentials not initialized Error when logging: \n%s", e);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        switch (this.$r8$classId) {
            case 0:
                ((AccessTokenManager) this.f$0).refreshCurrentAccessTokenImpl();
                return;
            case 1:
                ComponentActivity.ReportFullyDrawnExecutorImpl this$0 = (ComponentActivity.ReportFullyDrawnExecutorImpl) this.f$0;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                Runnable runnable = this$0.currentRunnable;
                if (runnable != null) {
                    runnable.run();
                    this$0.currentRunnable = null;
                    return;
                }
                return;
            case 2:
                ComponentDialog.$r8$lambda$qrzmfDOyDuplJFtpJLozn3P9EZI((ComponentDialog) this.f$0);
                return;
            case 3:
                Activity activity = (Activity) this.f$0;
                if (activity.isFinishing()) {
                    return;
                }
                int i = Build.VERSION.SDK_INT;
                if (i >= 28) {
                    Class cls = ActivityRecreator.activityThreadClass;
                    activity.recreate();
                    return;
                }
                Class cls2 = ActivityRecreator.activityThreadClass;
                boolean z = i == 26 || i == 27;
                Method method = ActivityRecreator.requestRelaunchActivityMethod;
                if ((!z || method != null) && (ActivityRecreator.performStopActivity2ParamsMethod != null || ActivityRecreator.performStopActivity3ParamsMethod != null)) {
                    try {
                        Object obj2 = ActivityRecreator.tokenField.get(activity);
                        if (obj2 != null && (obj = ActivityRecreator.mainThreadField.get(activity)) != null) {
                            Application application = activity.getApplication();
                            ActivityRecreator.LifecycleCheckCallbacks lifecycleCheckCallbacks = new ActivityRecreator.LifecycleCheckCallbacks(activity);
                            application.registerActivityLifecycleCallbacks(lifecycleCheckCallbacks);
                            Handler handler = ActivityRecreator.mainHandler;
                            handler.post(new zza(lifecycleCheckCallbacks, obj2, 1));
                            try {
                                if (i == 26 || i == 27) {
                                    Boolean bool = Boolean.FALSE;
                                    method.invoke(obj, obj2, null, null, 0, bool, null, null, bool, bool);
                                } else {
                                    activity.recreate();
                                }
                                handler.post(new zza(application, lifecycleCheckCallbacks, 2));
                                return;
                            } catch (Throwable th) {
                                handler.post(new zza(application, lifecycleCheckCallbacks, 2));
                                throw th;
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
                activity.recreate();
                return;
            case 4:
                ((AppCompatTextHelper.AnonymousClass1) this.f$0).getClass();
                return;
            case 5:
                FontRequestEmojiCompatConfig.FontRequestMetadataLoader fontRequestMetadataLoader = (FontRequestEmojiCompatConfig.FontRequestMetadataLoader) this.f$0;
                synchronized (fontRequestMetadataLoader.mLock) {
                    try {
                        if (fontRequestMetadataLoader.mCallback == null) {
                            return;
                        }
                        try {
                            FontsContractCompat$FontInfo fontsContractCompat$FontInfoRetrieveFontInfo = fontRequestMetadataLoader.retrieveFontInfo();
                            int i2 = fontsContractCompat$FontInfoRetrieveFontInfo.mResultCode;
                            if (i2 == 2) {
                                synchronized (fontRequestMetadataLoader.mLock) {
                                }
                            }
                            if (i2 != 0) {
                                throw new RuntimeException("fetchFonts result is not OK. (" + i2 + ")");
                            }
                            try {
                                int i3 = TraceCompat.$r8$clinit;
                                Trace.beginSection("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                                InputMergerFactory$1 inputMergerFactory$1 = fontRequestMetadataLoader.mFontProviderHelper;
                                Context context = fontRequestMetadataLoader.mContext;
                                inputMergerFactory$1.getClass();
                                Typeface typefaceCreateFromFontInfo = TypefaceCompat.sTypefaceCompatImpl.createFromFontInfo(context, new FontsContractCompat$FontInfo[]{fontsContractCompat$FontInfoRetrieveFontInfo}, 0);
                                MappedByteBuffer mappedByteBufferMmap = StringsKt__IndentKt.mmap(fontRequestMetadataLoader.mContext, fontsContractCompat$FontInfoRetrieveFontInfo.mUri);
                                if (mappedByteBufferMmap == null || typefaceCreateFromFontInfo == null) {
                                    throw new RuntimeException("Unable to open file.");
                                }
                                try {
                                    Trace.beginSection("EmojiCompat.MetadataRepo.create");
                                    Dispatcher dispatcher = new Dispatcher(typefaceCreateFromFontInfo, AsyncTimeout.Companion.read(mappedByteBufferMmap));
                                    Trace.endSection();
                                    Trace.endSection();
                                    synchronized (fontRequestMetadataLoader.mLock) {
                                        try {
                                            ExceptionsKt exceptionsKt = fontRequestMetadataLoader.mCallback;
                                            if (exceptionsKt != null) {
                                                exceptionsKt.onLoaded(dispatcher);
                                            }
                                        } catch (Throwable th2) {
                                            throw th2;
                                        }
                                        break;
                                    }
                                    fontRequestMetadataLoader.cleanUp();
                                    return;
                                } catch (Throwable th3) {
                                    int i4 = TraceCompat.$r8$clinit;
                                    Trace.endSection();
                                    throw th3;
                                }
                            } catch (Throwable th4) {
                                int i5 = TraceCompat.$r8$clinit;
                                Trace.endSection();
                                throw th4;
                            }
                            break;
                        } catch (Throwable th5) {
                            synchronized (fontRequestMetadataLoader.mLock) {
                                try {
                                    ExceptionsKt exceptionsKt2 = fontRequestMetadataLoader.mCallback;
                                    if (exceptionsKt2 != null) {
                                        exceptionsKt2.onFailed(th5);
                                    }
                                    fontRequestMetadataLoader.cleanUp();
                                    return;
                                } catch (Throwable th6) {
                                    throw th6;
                                }
                            }
                        }
                    } catch (Throwable th7) {
                        throw th7;
                    }
                }
            case 6:
                ProcessLifecycleOwner this$1 = (ProcessLifecycleOwner) this.f$0;
                Intrinsics.checkNotNullParameter(this$1, "this$0");
                int i6 = this$1.resumedCounter;
                LifecycleRegistry lifecycleRegistry = this$1.registry;
                if (i6 == 0) {
                    this$1.pauseSent = true;
                    lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
                }
                if (this$1.startedCounter == 0 && this$1.pauseSent) {
                    lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
                    this$1.stopSent = true;
                    return;
                }
                return;
            case 7:
                FlushReason reason = (FlushReason) this.f$0;
                if (CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
                    return;
                }
                try {
                    Intrinsics.checkNotNullParameter(reason, "$reason");
                    AppEventQueue.flushAndWait(reason);
                    return;
                } catch (Throwable th8) {
                    CrashShieldHandler.handleThrowable(AppEventQueue.class, th8);
                    return;
                }
            case 8:
                run$com$facebook$appevents$cloudbridge$AppEventsConversionsAPITransformerWebRequests$$ExternalSyntheticLambda0();
                return;
            case 9:
                CodelessMatcher this$2 = (CodelessMatcher) this.f$0;
                if (CrashShieldHandler.isObjectCrashing(CodelessMatcher.class)) {
                    return;
                }
                try {
                    Intrinsics.checkNotNullParameter(this$2, "this$0");
                    this$2.matchViews();
                    return;
                } catch (Throwable th9) {
                    CrashShieldHandler.handleThrowable(CodelessMatcher.class, th9);
                    return;
                }
            case 10:
                ViewObserver this$3 = (ViewObserver) this.f$0;
                if (CrashShieldHandler.isObjectCrashing(ViewObserver.class)) {
                    return;
                }
                try {
                    Intrinsics.checkNotNullParameter(this$3, "this$0");
                    WeakReference weakReference = this$3.activityWeakReference;
                    try {
                        View rootView = AppEventUtility.getRootView((Activity) weakReference.get());
                        Activity activity2 = (Activity) weakReference.get();
                        if (rootView != null && activity2 != null) {
                            for (View view : SuggestedEventViewHierarchy.getAllClickableViews(rootView)) {
                                if (!SensitiveUserDataUtils.isSensitiveUserData(view)) {
                                    String textOfViewRecursively = SuggestedEventViewHierarchy.getTextOfViewRecursively(view);
                                    if (textOfViewRecursively.length() > 0 && textOfViewRecursively.length() <= 300) {
                                        HashSet hashSet = ViewOnClickListener.viewsAttachedListener;
                                        String localClassName = activity2.getLocalClassName();
                                        Intrinsics.checkNotNullExpressionValue(localClassName, "activity.localClassName");
                                        FeatureExtractor.attachListener$facebook_core_release(view, rootView, localClassName);
                                    }
                                }
                            }
                            return;
                        }
                        return;
                    } catch (Exception unused2) {
                        return;
                    }
                } catch (Throwable th10) {
                    CrashShieldHandler.handleThrowable(ViewObserver.class, th10);
                    return;
                }
            case 11:
                FacebookWebFallbackDialog.$r8$lambda$v9EGjTJ8hS0baGhjnyMXvUVUBYI((FacebookWebFallbackDialog) this.f$0);
                return;
            case 12:
                FeatureManager.AnonymousClass1 anonymousClass1 = (FeatureManager.AnonymousClass1) this.f$0;
                FeatureManager featureManager = FeatureManager.INSTANCE;
                anonymousClass1.$callback.onCompleted(FeatureManager.isEnabled(anonymousClass1.$feature));
                return;
            case 13:
                DeviceAuthDialog this$4 = (DeviceAuthDialog) this.f$0;
                Intrinsics.checkNotNullParameter(this$4, "this$0");
                this$4.poll();
                return;
            case 14:
                WorkInitializer workInitializer = (WorkInitializer) this.f$0;
                workInitializer.getClass();
                ((SQLiteEventStore) workInitializer.guard).runCriticalSection(new InputConnectionCompat$$ExternalSyntheticLambda0(workInitializer, 11));
                return;
            default:
                ((FirebaseInstallations) this.f$0).lambda$getId$1();
                return;
        }
    }
}
