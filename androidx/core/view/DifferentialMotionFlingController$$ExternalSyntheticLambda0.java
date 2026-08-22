package androidx.core.view;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Base64;
import android.util.Log;
import androidx.core.provider.FontProvider$$ExternalSyntheticLambda2;
import com.daerisoft.thespikerm.GamepadHandler_API19;
import com.daerisoft.thespikerm.YYGooglePlayServices;
import com.facebook.AccessTokenManager$$ExternalSyntheticLambda2;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest$Companion$$ExternalSyntheticLambda0;
import com.facebook.GraphRequestAsyncTask;
import com.facebook.GraphRequestBatch;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import com.facebook.UserSettingsManager;
import com.facebook.appevents.AppEventQueue$$ExternalSyntheticLambda0;
import com.facebook.appevents.AppEventsManager$start$1;
import com.facebook.appevents.aam.MetadataIndexer;
import com.facebook.appevents.codeless.CodelessManager;
import com.facebook.appevents.eventdeactivation.EventDeactivationManager;
import com.facebook.appevents.iap.InAppPurchaseManager;
import com.facebook.appevents.ml.ModelManager;
import com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.Utility$$ExternalSyntheticLambda5;
import com.facebook.internal.Validate;
import com.facebook.internal.instrument.InstrumentData;
import com.facebook.internal.instrument.anrreport.ANRDetector;
import com.facebook.internal.instrument.anrreport.ANRHandler;
import com.facebook.internal.instrument.crashreport.CrashHandler;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.internal.instrument.errorreport.ErrorReportData;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseCommonRegistrar;
import com.google.firebase.auth.zzaa;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.ComponentRegistrarProcessor;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.protobuf.DescriptorProtos;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.ExceptionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okio.Okio;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DifferentialMotionFlingController$$ExternalSyntheticLambda0 implements OnSuccessListener, FeatureManager.Callback, SQLiteEventStore.Function, LibraryVersionComponent.VersionExtractor, ComponentRegistrarProcessor, Deferred.DeferredHandler {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ DifferentialMotionFlingController$$ExternalSyntheticLambda0(int i) {
        this.$r8$classId = i;
    }

    private final void onCompleted$com$facebook$appevents$AppEventsManager$start$1$$ExternalSyntheticLambda5(boolean z) {
        int i = 1;
        if (z) {
            LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
            try {
                GraphRequest graphRequest = new GraphRequest(null, Intrinsics.stringPlus("/cloudbridge_settings", FacebookSdk.getApplicationId()), null, HttpMethod.GET, new GraphRequest$Companion$$ExternalSyntheticLambda0(i));
                GraphRequest.Companion companion = Logger.Companion;
                synchronized (FacebookSdk.loggingBehaviors) {
                }
                graphRequest.executeAsync();
            } catch (JSONException e) {
                GraphRequest.Companion companion2 = Logger.Companion;
                GraphRequest.Companion.log(loggingBehavior, "com.facebook.appevents.cloudbridge.AppEventsCAPIManager", " \n\nGraph Request Exception: \n=============\n%s\n\n ", ExceptionsKt.stackTraceToString(e));
            }
        }
    }

    private final void onCompleted$com$facebook$internal$instrument$InstrumentManager$$ExternalSyntheticLambda0(boolean z) {
        File[] fileArrListFiles;
        int i = 1;
        if (z) {
            synchronized (CrashHandler.Companion) {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                if (UserSettingsManager.getAutoLogAppEventsEnabled()) {
                    GraphRequest.Companion.sendExceptionReports();
                }
                if (CrashHandler.instance != null) {
                    Log.w("com.facebook.internal.instrument.crashreport.CrashHandler", "Already enabled!");
                } else {
                    CrashHandler crashHandler = new CrashHandler(Thread.getDefaultUncaughtExceptionHandler());
                    CrashHandler.instance = crashHandler;
                    Thread.setDefaultUncaughtExceptionHandler(crashHandler);
                }
            }
            FeatureManager featureManager = FeatureManager.INSTANCE;
            if (FeatureManager.isEnabled(FeatureManager.Feature.CrashShield)) {
                MapsKt__MapsKt.enabled = true;
                if (UserSettingsManager.getAutoLogAppEventsEnabled() && !Utility.isDataProcessingRestricted()) {
                    File instrumentReportDir = Headers.Companion.getInstrumentReportDir();
                    if (instrumentReportDir == null) {
                        fileArrListFiles = new File[0];
                    } else {
                        fileArrListFiles = instrumentReportDir.listFiles(new Utility$$ExternalSyntheticLambda5(3));
                        if (fileArrListFiles == null) {
                            fileArrListFiles = new File[0];
                        }
                    }
                    ArrayList arrayList = new ArrayList();
                    int length = fileArrListFiles.length;
                    int i2 = 0;
                    while (i2 < length) {
                        File file = fileArrListFiles[i2];
                        i2++;
                        InstrumentData instrumentDataLoad = GamepadHandler_API19.load(file);
                        if (instrumentDataLoad.isValid()) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("crash_shield", instrumentDataLoad.toString());
                                String str = GraphRequest.MIME_BOUNDARY;
                                arrayList.add(GraphRequest.Companion.newPostRequest(null, String.format("%s/instruments", Arrays.copyOf(new Object[]{FacebookSdk.getApplicationId()}, 1)), jSONObject, new AccessTokenManager$$ExternalSyntheticLambda2(instrumentDataLoad, i)));
                            } catch (JSONException unused) {
                            }
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        GraphRequestBatch graphRequestBatch = new GraphRequestBatch(arrayList);
                        String str2 = GraphRequest.MIME_BOUNDARY;
                        Validate.notEmptyAndContainsNoNulls(graphRequestBatch);
                        new GraphRequestAsyncTask(graphRequestBatch).executeOnExecutor(FacebookSdk.getExecutor(), new Void[0]);
                    }
                }
                CrashShieldHandler.enabled = true;
            }
            FeatureManager featureManager2 = FeatureManager.INSTANCE;
            FeatureManager.isEnabled(FeatureManager.Feature.ThreadCheck);
        }
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public Object apply(Object obj) {
        Cursor cursorRawQuery = ((SQLiteDatabase) obj).rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]);
        try {
            ArrayList arrayList = new ArrayList();
            while (cursorRawQuery.moveToNext()) {
                zzaa zzaaVarBuilder = AutoValue_TransportContext.builder();
                zzaaVarBuilder.setBackendName(cursorRawQuery.getString(1));
                zzaaVarBuilder.zzc = PriorityMapping.valueOf(cursorRawQuery.getInt(2));
                String string = cursorRawQuery.getString(3);
                zzaaVarBuilder.zzb = string == null ? null : Base64.decode(string, 0);
                arrayList.add(zzaaVarBuilder.m98build());
            }
            return arrayList;
        } finally {
            cursorRawQuery.close();
        }
    }

    @Override // com.google.firebase.platforminfo.LibraryVersionComponent.VersionExtractor
    public String extract(Object obj) {
        Context context = (Context) obj;
        switch (this.$r8$classId) {
            case 21:
                return FirebaseCommonRegistrar.lambda$getComponents$0(context);
            case 22:
                return FirebaseCommonRegistrar.lambda$getComponents$1(context);
            case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
                return FirebaseCommonRegistrar.lambda$getComponents$2(context);
            default:
                return FirebaseCommonRegistrar.lambda$getComponents$3(context);
        }
    }

    @Override // com.google.firebase.inject.Deferred.DeferredHandler
    public void handle(Provider provider) {
    }

    @Override // com.facebook.internal.FeatureManager.Callback
    public void onCompleted(boolean z) {
        File[] fileArrListFiles;
        int i = 4;
        switch (this.$r8$classId) {
            case 4:
                if (z && UserSettingsManager.getAutoLogAppEventsEnabled()) {
                    FeatureManager featureManager = FeatureManager.INSTANCE;
                    FeatureManager.checkFeature(new DifferentialMotionFlingController$$ExternalSyntheticLambda0(16), FeatureManager.Feature.CrashReport);
                    FeatureManager.checkFeature(new DifferentialMotionFlingController$$ExternalSyntheticLambda0(17), FeatureManager.Feature.ErrorReport);
                    FeatureManager.checkFeature(new DifferentialMotionFlingController$$ExternalSyntheticLambda0(18), FeatureManager.Feature.AnrReport);
                    return;
                }
                return;
            case 5:
                if (!z || CrashShieldHandler.isObjectCrashing(Okio.class)) {
                    return;
                }
                try {
                    FetchedAppSettingsManager.fetchedAppSettingsCallbacks.add(new AppEventsManager$start$1());
                    FetchedAppSettingsManager.loadAppSettingsAsync();
                    return;
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(Okio.class, th);
                    return;
                }
            case 6:
                if (z) {
                    FacebookSdk.hasCustomTabsPrefetching = true;
                    return;
                }
                return;
            case 7:
                if (z) {
                    FacebookSdk.ignoreAppSwitchToLoggedOut = true;
                    return;
                }
                return;
            case 8:
                if (z) {
                    FacebookSdk.bypassAppSwitch = true;
                    return;
                }
                return;
            case 9:
                if (!z || CrashShieldHandler.isObjectCrashing(MetadataIndexer.class)) {
                    return;
                }
                try {
                    try {
                        FacebookSdk.getExecutor().execute(new AppEventQueue$$ExternalSyntheticLambda0(i));
                        return;
                    } catch (Throwable th2) {
                        CrashShieldHandler.handleThrowable(MetadataIndexer.class, th2);
                        return;
                    }
                } catch (Exception unused) {
                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                    return;
                }
            case 10:
                if (z) {
                    RestrictiveDataManager restrictiveDataManager = RestrictiveDataManager.INSTANCE;
                    if (CrashShieldHandler.isObjectCrashing(RestrictiveDataManager.class)) {
                        return;
                    }
                    try {
                        RestrictiveDataManager.enabled = true;
                        RestrictiveDataManager.INSTANCE.initialize();
                        return;
                    } catch (Throwable th3) {
                        CrashShieldHandler.handleThrowable(RestrictiveDataManager.class, th3);
                        return;
                    }
                }
                return;
            case 11:
                if (z) {
                    ModelManager modelManager = ModelManager.INSTANCE;
                    if (CrashShieldHandler.isObjectCrashing(ModelManager.class)) {
                        return;
                    }
                    try {
                        Utility.runOnNonUiThread(new AppEventQueue$$ExternalSyntheticLambda0(10));
                        return;
                    } catch (Throwable th4) {
                        CrashShieldHandler.handleThrowable(ModelManager.class, th4);
                        return;
                    }
                }
                return;
            case 12:
                if (z) {
                    EventDeactivationManager eventDeactivationManager = EventDeactivationManager.INSTANCE;
                    if (CrashShieldHandler.isObjectCrashing(EventDeactivationManager.class)) {
                        return;
                    }
                    try {
                        EventDeactivationManager.enabled = true;
                        EventDeactivationManager.INSTANCE.initialize();
                        return;
                    } catch (Throwable th5) {
                        CrashShieldHandler.handleThrowable(EventDeactivationManager.class, th5);
                        return;
                    }
                }
                return;
            case 13:
                if (z) {
                    InAppPurchaseManager inAppPurchaseManager = InAppPurchaseManager.INSTANCE;
                    if (CrashShieldHandler.isObjectCrashing(InAppPurchaseManager.class)) {
                        return;
                    }
                    try {
                        InAppPurchaseManager.enabled.set(true);
                        InAppPurchaseManager.startTracking();
                        return;
                    } catch (Throwable th6) {
                        CrashShieldHandler.handleThrowable(InAppPurchaseManager.class, th6);
                        return;
                    }
                }
                return;
            case 14:
                onCompleted$com$facebook$appevents$AppEventsManager$start$1$$ExternalSyntheticLambda5(z);
                return;
            case 15:
                if (z) {
                    CodelessManager codelessManager = CodelessManager.INSTANCE;
                    if (CrashShieldHandler.isObjectCrashing(CodelessManager.class)) {
                        return;
                    }
                    try {
                        CodelessManager.isCodelessEnabled.set(true);
                        return;
                    } catch (Throwable th7) {
                        CrashShieldHandler.handleThrowable(CodelessManager.class, th7);
                        return;
                    }
                }
                CodelessManager codelessManager2 = CodelessManager.INSTANCE;
                if (CrashShieldHandler.isObjectCrashing(CodelessManager.class)) {
                    return;
                }
                try {
                    CodelessManager.isCodelessEnabled.set(false);
                    return;
                } catch (Throwable th8) {
                    CrashShieldHandler.handleThrowable(CodelessManager.class, th8);
                    return;
                }
            case 16:
                onCompleted$com$facebook$internal$instrument$InstrumentManager$$ExternalSyntheticLambda0(z);
                return;
            case 17:
                if (z) {
                    FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
                    if (!UserSettingsManager.getAutoLogAppEventsEnabled() || Utility.isDataProcessingRestricted()) {
                        return;
                    }
                    File instrumentReportDir = Headers.Companion.getInstrumentReportDir();
                    if (instrumentReportDir == null) {
                        fileArrListFiles = new File[0];
                    } else {
                        fileArrListFiles = instrumentReportDir.listFiles(new Utility$$ExternalSyntheticLambda5(4));
                        Intrinsics.checkNotNullExpressionValue(fileArrListFiles, "reportDir.listFiles { dir, name ->\n      name.matches(Regex(String.format(\"^%s[0-9]+.json$\", InstrumentUtility.ERROR_REPORT_PREFIX)))\n    }");
                    }
                    ArrayList arrayList = new ArrayList();
                    int length = fileArrListFiles.length;
                    int i2 = 0;
                    while (i2 < length) {
                        File file = fileArrListFiles[i2];
                        i2++;
                        Intrinsics.checkNotNullParameter(file, "file");
                        ErrorReportData errorReportData = new ErrorReportData();
                        String name = file.getName();
                        Intrinsics.checkNotNullExpressionValue(name, "file.name");
                        errorReportData.filename = name;
                        JSONObject file2 = Headers.Companion.readFile(name);
                        if (file2 != null) {
                            errorReportData.timestamp = Long.valueOf(file2.optLong("timestamp", 0L));
                            errorReportData.errorMessage = file2.optString("error_message", null);
                        }
                        if (errorReportData.errorMessage != null && errorReportData.timestamp != null) {
                            arrayList.add(errorReportData);
                        }
                    }
                    FontProvider$$ExternalSyntheticLambda2 fontProvider$$ExternalSyntheticLambda2 = new FontProvider$$ExternalSyntheticLambda2(3);
                    if (arrayList.size() > 1) {
                        Collections.sort(arrayList, fontProvider$$ExternalSyntheticLambda2);
                    }
                    JSONArray jSONArray = new JSONArray();
                    for (int i3 = 0; i3 < arrayList.size() && i3 < 1000; i3++) {
                        jSONArray.put(arrayList.get(i3));
                    }
                    Headers.Companion.sendReports("error_reports", jSONArray, new AccessTokenManager$$ExternalSyntheticLambda2(arrayList, 2));
                    return;
                }
                return;
            default:
                if (z) {
                    AtomicBoolean atomicBoolean = ANRHandler.enabled;
                    synchronized (ANRHandler.class) {
                        if (CrashShieldHandler.isObjectCrashing(ANRHandler.class)) {
                            return;
                        }
                        try {
                            if (ANRHandler.enabled.getAndSet(true)) {
                                return;
                            }
                            FacebookSdk facebookSdk3 = FacebookSdk.INSTANCE;
                            if (UserSettingsManager.getAutoLogAppEventsEnabled()) {
                                ANRHandler.sendANRReports();
                            }
                            int i4 = ANRDetector.myUid;
                            if (!CrashShieldHandler.isObjectCrashing(ANRDetector.class)) {
                                try {
                                    ANRDetector.scheduledExecutorService.scheduleAtFixedRate(ANRDetector.anrDetectorRunnable, 0L, 500, TimeUnit.MILLISECONDS);
                                } catch (Throwable th9) {
                                    CrashShieldHandler.handleThrowable(ANRDetector.class, th9);
                                }
                            }
                            break;
                        } catch (Throwable th10) {
                            CrashShieldHandler.handleThrowable(ANRHandler.class, th10);
                        }
                        return;
                    }
                }
                return;
        }
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Object obj) {
        YYGooglePlayServices.lambda$GooglePlayServices_SavedGames_ShowSavedGamesUI$0((Intent) obj);
    }

    @Override // com.google.firebase.components.ComponentRegistrarProcessor
    public List processRegistrar(ComponentRegistrar componentRegistrar) {
        return componentRegistrar.getComponents();
    }
}
