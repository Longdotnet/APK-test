package com.facebook.appevents;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import androidx.room.RoomOpenHelper;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.aam.MetadataIndexer;
import com.facebook.appevents.aam.MetadataRule;
import com.facebook.appevents.iap.InAppPurchaseActivityLifecycleTracker;
import com.facebook.appevents.iap.InAppPurchaseAutoLogger;
import com.facebook.appevents.iap.InAppPurchaseEventManager;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.appevents.internal.SessionInfo;
import com.facebook.appevents.ml.ModelManager;
import com.facebook.appevents.suggestedevents.SuggestedEventsManager;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FetchedAppGateKeepersManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Validate;
import com.facebook.internal.instrument.anrreport.ANRDetector;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AlarmManagerSchedulerBroadcastReceiver;
import com.google.android.gms.common.stats.ZnFR.FKidOcdAYt;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import okio.AsyncTimeout;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class AppEventQueue$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ AppEventQueue$$ExternalSyntheticLambda0(int i) {
        this.$r8$classId = i;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0135 A[Catch: all -> 0x00f4, Exception -> 0x0156, TryCatch #21 {Exception -> 0x0156, all -> 0x00f4, blocks: (B:71:0x00d6, B:73:0x00e7, B:76:0x00ee, B:80:0x00fb, B:83:0x010b, B:85:0x0111, B:101:0x014c, B:96:0x012b, B:97:0x012e, B:100:0x0135, B:79:0x00f6), top: B:263:0x00d6 }] */
    /* JADX WARN: Code duplicated, block: B:97:0x012e A[Catch: all -> 0x00f4, Exception -> 0x0156, TryCatch #21 {Exception -> 0x0156, all -> 0x00f4, blocks: (B:71:0x00d6, B:73:0x00e7, B:76:0x00ee, B:80:0x00fb, B:83:0x010b, B:85:0x0111, B:101:0x014c, B:96:0x012b, B:97:0x012e, B:100:0x0135, B:79:0x00f6), top: B:263:0x00d6 }] */
    /* JADX WARN: Code duplicated, block: B:99:0x0134  */
    @Override // java.lang.Runnable
    public final void run() {
        String str;
        InAppPurchaseEventManager inAppPurchaseEventManager;
        Class cls;
        Set setKeySet = null;
        setKeySet = null;
        arrayListFilterPurchases = null;
        arrayListFilterPurchases = null;
        sessionInfo = null;
        sessionInfo = null;
        SessionInfo sessionInfo = null;
        ArrayList arrayListFilterPurchases = null;
        ArrayList arrayListFilterPurchases2 = null;
        switch (this.$r8$classId) {
            case 0:
                if (CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
                    return;
                }
                try {
                    AppEventQueue.scheduledFuture = null;
                    if (GraphRequest.Companion.getFlushBehavior() != AppEventsLogger$FlushBehavior.EXPLICIT_ONLY) {
                        AppEventQueue.flushAndWait(FlushReason.TIMER);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(AppEventQueue.class, th);
                    return;
                }
            case 1:
                AnalyticsUserIDStore.initAndWait();
                return;
            case 2:
                if (CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
                    return;
                }
                try {
                    AsyncTimeout.Companion.persistEvents(AppEventQueue.appEventCollection);
                    AppEventQueue.appEventCollection = new AppEventCollection();
                    return;
                } catch (Throwable th2) {
                    CrashShieldHandler.handleThrowable(AppEventQueue.class, th2);
                    return;
                }
            case 3:
                HashSet hashSet = new HashSet();
                AppEventCollection appEventCollection = AppEventQueue.appEventCollection;
                if (!CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
                    try {
                        setKeySet = AppEventQueue.appEventCollection.keySet();
                    } catch (Throwable th3) {
                        CrashShieldHandler.handleThrowable(AppEventQueue.class, th3);
                    }
                    break;
                }
                Iterator it = setKeySet.iterator();
                while (it.hasNext()) {
                    hashSet.add(((AccessTokenAppIdPair) it.next()).applicationId);
                }
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    FetchedAppSettingsManager.queryAppSettings((String) it2.next(), true);
                }
                return;
            case 4:
                if (CrashShieldHandler.isObjectCrashing(MetadataIndexer.class)) {
                    return;
                }
                try {
                    AttributionIdentifiers attributionIdentifiers = Validate.getAttributionIdentifiers(FacebookSdk.getApplicationContext());
                    if (attributionIdentifiers == null || !attributionIdentifiers.isTrackingLimited) {
                        MetadataIndexer metadataIndexer = MetadataIndexer.INSTANCE;
                        if (!CrashShieldHandler.isObjectCrashing(metadataIndexer)) {
                            try {
                                FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
                                FetchedAppSettings fetchedAppSettingsQueryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
                                if (fetchedAppSettingsQueryAppSettings != null && (str = fetchedAppSettingsQueryAppSettings.rawAamRules) != null) {
                                    try {
                                        MetadataRule.access$getRules$cp().clear();
                                        JvmClassMappingKt.constructRules(new JSONObject(str));
                                        break;
                                    } catch (JSONException unused) {
                                    }
                                }
                            } catch (Throwable th4) {
                                CrashShieldHandler.handleThrowable(metadataIndexer, th4);
                            }
                        }
                        MetadataIndexer.enabled = true;
                        return;
                    }
                    return;
                } catch (Throwable th5) {
                    CrashShieldHandler.handleThrowable(MetadataIndexer.class, th5);
                    return;
                }
            case 5:
                Context applicationContext = FacebookSdk.getApplicationContext();
                InAppPurchaseEventManager inAppPurchaseEventManager2 = InAppPurchaseEventManager.INSTANCE;
                ArrayList purchasesInapp = InAppPurchaseEventManager.getPurchasesInapp(applicationContext, InAppPurchaseActivityLifecycleTracker.inAppBillingObj);
                if (purchasesInapp.isEmpty()) {
                    Object obj = InAppPurchaseActivityLifecycleTracker.inAppBillingObj;
                    if (!CrashShieldHandler.isObjectCrashing(InAppPurchaseEventManager.class)) {
                        try {
                            arrayListFilterPurchases2 = (obj != null && (cls = (inAppPurchaseEventManager = InAppPurchaseEventManager.INSTANCE).getClass(applicationContext, "com.android.vending.billing.IInAppBillingService")) != null && inAppPurchaseEventManager.getMethod(cls, "getPurchaseHistory") != null) ? inAppPurchaseEventManager.filterPurchases(inAppPurchaseEventManager.getPurchaseHistory(applicationContext, obj)) : new ArrayList();
                        } catch (Throwable th6) {
                            CrashShieldHandler.handleThrowable(InAppPurchaseEventManager.class, th6);
                        }
                    }
                    purchasesInapp = arrayListFilterPurchases2;
                    break;
                }
                InAppPurchaseActivityLifecycleTracker.access$logPurchase(applicationContext, purchasesInapp, false);
                return;
            case 6:
                Context applicationContext2 = FacebookSdk.getApplicationContext();
                InAppPurchaseEventManager inAppPurchaseEventManager3 = InAppPurchaseEventManager.INSTANCE;
                InAppPurchaseActivityLifecycleTracker.access$logPurchase(applicationContext2, InAppPurchaseEventManager.getPurchasesInapp(applicationContext2, InAppPurchaseActivityLifecycleTracker.inAppBillingObj), false);
                Object obj2 = InAppPurchaseActivityLifecycleTracker.inAppBillingObj;
                if (!CrashShieldHandler.isObjectCrashing(InAppPurchaseEventManager.class)) {
                    try {
                        InAppPurchaseEventManager inAppPurchaseEventManager4 = InAppPurchaseEventManager.INSTANCE;
                        arrayListFilterPurchases = inAppPurchaseEventManager4.filterPurchases(inAppPurchaseEventManager4.getPurchases(applicationContext2, obj2, "subs"));
                    } catch (Throwable th7) {
                        CrashShieldHandler.handleThrowable(InAppPurchaseEventManager.class, th7);
                    }
                    break;
                }
                InAppPurchaseActivityLifecycleTracker.access$logPurchase(applicationContext2, arrayListFilterPurchases, true);
                return;
            case 7:
                if (CrashShieldHandler.isObjectCrashing(InAppPurchaseAutoLogger.class)) {
                    return;
                }
                try {
                    InAppPurchaseAutoLogger.INSTANCE.logPurchase();
                    return;
                } catch (Throwable th8) {
                    CrashShieldHandler.handleThrowable(InAppPurchaseAutoLogger.class, th8);
                    return;
                }
            case 8:
                if (CrashShieldHandler.isObjectCrashing(InAppPurchaseAutoLogger.class)) {
                    return;
                }
                try {
                    InAppPurchaseAutoLogger.INSTANCE.logPurchase();
                    return;
                } catch (Throwable th9) {
                    CrashShieldHandler.handleThrowable(InAppPurchaseAutoLogger.class, th9);
                    return;
                }
            case 9:
                if (ActivityLifecycleTracker.currentSession == null) {
                    SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext());
                    long j = defaultSharedPreferences.getLong("com.facebook.appevents.SessionInfo.sessionStartTime", 0L);
                    long j2 = defaultSharedPreferences.getLong("com.facebook.appevents.SessionInfo.sessionEndTime", 0L);
                    String string = defaultSharedPreferences.getString("com.facebook.appevents.SessionInfo.sessionId", null);
                    if (j != 0 && j2 != 0 && string != null) {
                        SessionInfo sessionInfo2 = new SessionInfo(Long.valueOf(j), Long.valueOf(j2));
                        sessionInfo2.interruptionCount = defaultSharedPreferences.getInt("com.facebook.appevents.SessionInfo.interruptionCount", 0);
                        SharedPreferences defaultSharedPreferences2 = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext());
                        sessionInfo2.sourceApplicationInfo = defaultSharedPreferences2.contains("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage") ? new RoomOpenHelper.ValidationResult(defaultSharedPreferences2.getString("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage", null), defaultSharedPreferences2.getBoolean("com.facebook.appevents.SourceApplicationInfo.openedByApplink", false)) : null;
                        sessionInfo2.diskRestoreTime = Long.valueOf(System.currentTimeMillis());
                        UUID uuidFromString = UUID.fromString(string);
                        Intrinsics.checkNotNullExpressionValue(uuidFromString, "fromString(sessionIDStr)");
                        sessionInfo2.sessionId = uuidFromString;
                        sessionInfo = sessionInfo2;
                    }
                    ActivityLifecycleTracker.currentSession = sessionInfo;
                    return;
                }
                return;
            case 10:
                if (CrashShieldHandler.isObjectCrashing(ModelManager.class)) {
                    return;
                }
                try {
                    SharedPreferences sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences(FKidOcdAYt.nWblFmcfbpnwST, 0);
                    String string2 = sharedPreferences.getString("models", null);
                    JSONObject jSONObject = (string2 == null || string2.length() == 0) ? new JSONObject() : new JSONObject(string2);
                    long j3 = sharedPreferences.getLong("model_request_timestamp", 0L);
                    FeatureManager featureManager = FeatureManager.INSTANCE;
                    boolean zIsEnabled = FeatureManager.isEnabled(FeatureManager.Feature.ModelRequest);
                    ModelManager modelManager = ModelManager.INSTANCE;
                    if (!zIsEnabled || jSONObject.length() == 0 || CrashShieldHandler.isObjectCrashing(modelManager) || j3 == 0) {
                        jSONObject = modelManager.fetchModels();
                        if (jSONObject == null) {
                            return;
                        } else {
                            sharedPreferences.edit().putString("models", jSONObject.toString()).putLong("model_request_timestamp", System.currentTimeMillis()).apply();
                        }
                    } else {
                        try {
                            if (System.currentTimeMillis() - j3 >= 259200000) {
                                jSONObject = modelManager.fetchModels();
                                if (jSONObject == null) {
                                    return;
                                } else {
                                    sharedPreferences.edit().putString("models", jSONObject.toString()).putLong("model_request_timestamp", System.currentTimeMillis()).apply();
                                }
                            }
                        } catch (Throwable th10) {
                            CrashShieldHandler.handleThrowable(modelManager, th10);
                        }
                    }
                    modelManager.addModels(jSONObject);
                    modelManager.enableMTML();
                    return;
                } catch (Exception unused2) {
                    return;
                } catch (Throwable th11) {
                    CrashShieldHandler.handleThrowable(ModelManager.class, th11);
                    return;
                }
            case 11:
                if (CrashShieldHandler.isObjectCrashing(ModelManager.class)) {
                    return;
                }
                try {
                    SuggestedEventsManager.enable();
                    return;
                } catch (Throwable th12) {
                    CrashShieldHandler.handleThrowable(ModelManager.class, th12);
                    return;
                }
            case 12:
                if (CrashShieldHandler.isObjectCrashing(ModelManager.class)) {
                    return;
                }
                try {
                    if (CrashShieldHandler.isObjectCrashing(IntegrityManager.class)) {
                        return;
                    }
                    try {
                        IntegrityManager.enabled = true;
                        AtomicBoolean atomicBoolean = FetchedAppGateKeepersManager.isLoading;
                        IntegrityManager.isSampleEnabled = FetchedAppGateKeepersManager.getGateKeeperForKey("FBSDKFeatureIntegritySample", FacebookSdk.getApplicationId(), false);
                        return;
                    } catch (Throwable th13) {
                        CrashShieldHandler.handleThrowable(IntegrityManager.class, th13);
                        return;
                    }
                } catch (Throwable th14) {
                    CrashShieldHandler.handleThrowable(ModelManager.class, th14);
                    return;
                }
            case 13:
                if (CrashShieldHandler.isObjectCrashing(SuggestedEventsManager.class)) {
                    return;
                }
                try {
                    AtomicBoolean atomicBoolean2 = SuggestedEventsManager.enabled;
                    if (atomicBoolean2.get()) {
                        return;
                    }
                    atomicBoolean2.set(true);
                    SuggestedEventsManager.INSTANCE.initialize();
                    return;
                } catch (Throwable th15) {
                    CrashShieldHandler.handleThrowable(SuggestedEventsManager.class, th15);
                    return;
                }
            case 14:
                AtomicBoolean atomicBoolean3 = NativeProtocol.protocolVersionsAsyncUpdating;
                try {
                    if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
                        return;
                    }
                    try {
                        Iterator it3 = NativeProtocol.facebookAppInfoList.iterator();
                        while (it3.hasNext()) {
                            ((NativeProtocol.KatanaAppInfo) it3.next()).fetchAvailableVersions(true);
                        }
                        atomicBoolean3.set(false);
                        return;
                    } catch (Throwable th16) {
                        atomicBoolean3.set(false);
                        throw th16;
                    }
                } catch (Throwable th17) {
                    CrashShieldHandler.handleThrowable(NativeProtocol.class, th17);
                    return;
                }
            case 15:
                if (CrashShieldHandler.isObjectCrashing(ANRDetector.class)) {
                    return;
                }
                try {
                    Object systemService = FacebookSdk.getApplicationContext().getSystemService("activity");
                    if (systemService == null) {
                        throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
                    }
                    ANRDetector.checkProcessError((ActivityManager) systemService);
                    return;
                } catch (Exception unused3) {
                    return;
                } catch (Throwable th18) {
                    CrashShieldHandler.handleThrowable(ANRDetector.class, th18);
                    return;
                }
            default:
                int i = AlarmManagerSchedulerBroadcastReceiver.$r8$clinit;
                return;
        }
    }
}
