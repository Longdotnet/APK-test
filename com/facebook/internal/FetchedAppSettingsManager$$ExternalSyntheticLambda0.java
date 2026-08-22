package com.facebook.internal;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.fragment.app.Fragment;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.UserSettingsManager;
import com.facebook.appevents.AnalyticsUserIDStore;
import com.facebook.appevents.AppEventQueue$$ExternalSyntheticLambda0;
import com.facebook.appevents.AppEventsLoggerImpl;
import com.facebook.appevents.UserDataStore;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.appevents.internal.AppEventsLoggerUtility;
import com.facebook.appevents.internal.AutomaticAnalyticsLogger;
import com.facebook.appevents.ondeviceprocessing.OnDeviceProcessingManager;
import com.facebook.appevents.ondeviceprocessing.RemoteServiceWrapper;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.Validate;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.collections.EmptyList;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class FetchedAppSettingsManager$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId = 0;
    public final /* synthetic */ Context f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ String f$2;

    public /* synthetic */ FetchedAppSettingsManager$$ExternalSyntheticLambda0(Context context, String str, String str2) {
        this.f$0 = context;
        this.f$1 = str;
        this.f$2 = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        JSONObject jSONObject;
        final int i = 1;
        final int i2 = 0;
        switch (this.$r8$classId) {
            case 0:
                Context context = this.f$0;
                String str = this.f$1;
                String str2 = this.f$2;
                SharedPreferences sharedPreferences = context.getSharedPreferences("com.facebook.internal.preferences.APP_SETTINGS", 0);
                FetchedAppSettings appSettingsFromJSON$facebook_core_release = null;
                String string = sharedPreferences.getString(str, null);
                boolean zIsNullOrEmpty = Utility.isNullOrEmpty(string);
                FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
                if (!zIsNullOrEmpty) {
                    if (string == null) {
                        throw new IllegalStateException("Required value was null.");
                    }
                    try {
                        jSONObject = new JSONObject(string);
                    } catch (JSONException unused) {
                        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                        jSONObject = null;
                    }
                    if (jSONObject != null) {
                        appSettingsFromJSON$facebook_core_release = FetchedAppSettingsManager.parseAppSettingsFromJSON$facebook_core_release(str2, jSONObject);
                    }
                    break;
                }
                JSONObject appSettingsQueryResponse = FetchedAppSettingsManager.getAppSettingsQueryResponse();
                FetchedAppSettingsManager.parseAppSettingsFromJSON$facebook_core_release(str2, appSettingsQueryResponse);
                sharedPreferences.edit().putString(str, appSettingsQueryResponse.toString()).apply();
                if (appSettingsFromJSON$facebook_core_release != null) {
                    String str3 = appSettingsFromJSON$facebook_core_release.sdkUpdateMessage;
                    if (!FetchedAppSettingsManager.printedSDKUpdatedMessage && str3.length() > 0) {
                        FetchedAppSettingsManager.printedSDKUpdatedMessage = true;
                        Log.w("FetchedAppSettingsManager", str3);
                    }
                }
                JSONObject appGateKeepersQueryResponse = FetchedAppGateKeepersManager.getAppGateKeepersQueryResponse();
                FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.internal.preferences.APP_GATEKEEPERS", 0).edit().putString(String.format("com.facebook.internal.APP_GATEKEEPERS.%s", Arrays.copyOf(new Object[]{str2}, 1)), appGateKeepersQueryResponse.toString()).apply();
                FetchedAppGateKeepersManager.parseAppGateKeepersFromJSON$facebook_core_release(str2, appGateKeepersQueryResponse);
                Fragment.AnonymousClass7 anonymousClass7 = AutomaticAnalyticsLogger.internalAppEventsLogger;
                Context applicationContext = FacebookSdk.getApplicationContext();
                final String applicationId = FacebookSdk.getApplicationId();
                if (UserSettingsManager.getAutoLogAppEventsEnabled()) {
                    if (applicationContext instanceof Application) {
                        Application application = (Application) applicationContext;
                        if (!FacebookSdk.sdkInitialized.get()) {
                            throw new FacebookException("The Facebook sdk must be initialized before calling activateApp");
                        }
                        ReentrantReadWriteLock reentrantReadWriteLock = AnalyticsUserIDStore.lock;
                        if (!AnalyticsUserIDStore.initialized) {
                            if (AppEventsLoggerImpl.access$getBackgroundExecutor$cp() == null) {
                                GraphRequest.Companion.initializeTimersIfNeeded();
                            }
                            ScheduledThreadPoolExecutor scheduledThreadPoolExecutorAccess$getBackgroundExecutor$cp = AppEventsLoggerImpl.access$getBackgroundExecutor$cp();
                            if (scheduledThreadPoolExecutorAccess$getBackgroundExecutor$cp == null) {
                                throw new IllegalStateException("Required value was null.");
                            }
                            scheduledThreadPoolExecutorAccess$getBackgroundExecutor$cp.execute(new AppEventQueue$$ExternalSyntheticLambda0(i));
                        }
                        UserDataStore userDataStore = UserDataStore.INSTANCE;
                        if (!CrashShieldHandler.isObjectCrashing(UserDataStore.class)) {
                            try {
                                if (!UserDataStore.initialized.get()) {
                                    UserDataStore.INSTANCE.initAndWait();
                                    break;
                                }
                            } catch (Throwable th) {
                                CrashShieldHandler.handleThrowable(UserDataStore.class, th);
                            }
                        }
                        FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
                        if (!CrashShieldHandler.isObjectCrashing(FacebookSdk.class)) {
                            try {
                                final Context applicationContext2 = application.getApplicationContext();
                                FacebookSdk.getExecutor().execute(new Runnable() { // from class: com.facebook.FacebookSdk$$ExternalSyntheticLambda8
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        String str4 = applicationId;
                                        Context applicationContext3 = applicationContext2;
                                        switch (i2) {
                                            case 0:
                                                FacebookSdk facebookSdk3 = FacebookSdk.INSTANCE;
                                                Intrinsics.checkNotNullExpressionValue(applicationContext3, "applicationContext");
                                                if (CrashShieldHandler.isObjectCrashing(facebookSdk3)) {
                                                    return;
                                                }
                                                try {
                                                    AttributionIdentifiers attributionIdentifiers = Validate.getAttributionIdentifiers(applicationContext3);
                                                    SharedPreferences sharedPreferences2 = applicationContext3.getSharedPreferences("com.facebook.sdk.attributionTracking", 0);
                                                    String strStringPlus = Intrinsics.stringPlus("ping", str4);
                                                    long j = sharedPreferences2.getLong(strStringPlus, 0L);
                                                    try {
                                                        HashMap map = AppEventsLoggerUtility.API_ACTIVITY_TYPE_TO_STRING;
                                                        JSONObject jSONObjectForGraphAPICall = AppEventsLoggerUtility.getJSONObjectForGraphAPICall(AppEventsLoggerUtility.GraphAPIActivityType.MOBILE_INSTALL_EVENT, attributionIdentifiers, CloseableKt.getAnonymousAppDeviceGUID(applicationContext3), FacebookSdk.getLimitEventAndDataUsage(applicationContext3), applicationContext3);
                                                        String str5 = String.format("%s/activities", Arrays.copyOf(new Object[]{str4}, 1));
                                                        FacebookSdk.graphRequestCreator.getClass();
                                                        String str6 = GraphRequest.MIME_BOUNDARY;
                                                        GraphRequest graphRequestNewPostRequest = GraphRequest.Companion.newPostRequest(null, str5, jSONObjectForGraphAPICall, null);
                                                        if (j == 0 && graphRequestNewPostRequest.executeAndWait().error == null) {
                                                            SharedPreferences.Editor editorEdit = sharedPreferences2.edit();
                                                            editorEdit.putLong(strStringPlus, System.currentTimeMillis());
                                                            editorEdit.apply();
                                                            return;
                                                        }
                                                        return;
                                                    } catch (JSONException e) {
                                                        throw new FacebookException("An error occurred while publishing install.", e);
                                                    }
                                                } catch (Exception unused2) {
                                                    return;
                                                } catch (Throwable th2) {
                                                    CrashShieldHandler.handleThrowable(facebookSdk3, th2);
                                                    return;
                                                }
                                            default:
                                                if (CrashShieldHandler.isObjectCrashing(OnDeviceProcessingManager.class)) {
                                                    return;
                                                }
                                                try {
                                                    SharedPreferences sharedPreferences3 = applicationContext3.getSharedPreferences("com.facebook.sdk.attributionTracking", 0);
                                                    String strStringPlus2 = Intrinsics.stringPlus("pingForOnDevice", str4);
                                                    if (sharedPreferences3.getLong(strStringPlus2, 0L) == 0) {
                                                        if (!CrashShieldHandler.isObjectCrashing(RemoteServiceWrapper.class)) {
                                                            try {
                                                                RemoteServiceWrapper.INSTANCE.sendEvents(RemoteServiceWrapper.EventType.MOBILE_APP_INSTALL, str4, EmptyList.INSTANCE);
                                                            } catch (Throwable th3) {
                                                                CrashShieldHandler.handleThrowable(RemoteServiceWrapper.class, th3);
                                                            }
                                                            break;
                                                        }
                                                        SharedPreferences.Editor editorEdit2 = sharedPreferences3.edit();
                                                        editorEdit2.putLong(strStringPlus2, System.currentTimeMillis());
                                                        editorEdit2.apply();
                                                        return;
                                                    }
                                                    return;
                                                } catch (Throwable th4) {
                                                    CrashShieldHandler.handleThrowable(OnDeviceProcessingManager.class, th4);
                                                    return;
                                                }
                                        }
                                    }
                                });
                                FeatureManager featureManager = FeatureManager.INSTANCE;
                                if (FeatureManager.isEnabled(FeatureManager.Feature.OnDeviceEventProcessing) && OnDeviceProcessingManager.isOnDeviceProcessingEnabled() && !CrashShieldHandler.isObjectCrashing(OnDeviceProcessingManager.class)) {
                                    try {
                                        final Context applicationContext3 = FacebookSdk.getApplicationContext();
                                        FacebookSdk.getExecutor().execute(new Runnable() { // from class: com.facebook.FacebookSdk$$ExternalSyntheticLambda8
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                String str4 = applicationId;
                                                Context applicationContext4 = applicationContext3;
                                                switch (i) {
                                                    case 0:
                                                        FacebookSdk facebookSdk3 = FacebookSdk.INSTANCE;
                                                        Intrinsics.checkNotNullExpressionValue(applicationContext4, "applicationContext");
                                                        if (CrashShieldHandler.isObjectCrashing(facebookSdk3)) {
                                                            return;
                                                        }
                                                        try {
                                                            AttributionIdentifiers attributionIdentifiers = Validate.getAttributionIdentifiers(applicationContext4);
                                                            SharedPreferences sharedPreferences2 = applicationContext4.getSharedPreferences("com.facebook.sdk.attributionTracking", 0);
                                                            String strStringPlus = Intrinsics.stringPlus("ping", str4);
                                                            long j = sharedPreferences2.getLong(strStringPlus, 0L);
                                                            try {
                                                                HashMap map = AppEventsLoggerUtility.API_ACTIVITY_TYPE_TO_STRING;
                                                                JSONObject jSONObjectForGraphAPICall = AppEventsLoggerUtility.getJSONObjectForGraphAPICall(AppEventsLoggerUtility.GraphAPIActivityType.MOBILE_INSTALL_EVENT, attributionIdentifiers, CloseableKt.getAnonymousAppDeviceGUID(applicationContext4), FacebookSdk.getLimitEventAndDataUsage(applicationContext4), applicationContext4);
                                                                String str5 = String.format("%s/activities", Arrays.copyOf(new Object[]{str4}, 1));
                                                                FacebookSdk.graphRequestCreator.getClass();
                                                                String str6 = GraphRequest.MIME_BOUNDARY;
                                                                GraphRequest graphRequestNewPostRequest = GraphRequest.Companion.newPostRequest(null, str5, jSONObjectForGraphAPICall, null);
                                                                if (j == 0 && graphRequestNewPostRequest.executeAndWait().error == null) {
                                                                    SharedPreferences.Editor editorEdit = sharedPreferences2.edit();
                                                                    editorEdit.putLong(strStringPlus, System.currentTimeMillis());
                                                                    editorEdit.apply();
                                                                    return;
                                                                }
                                                                return;
                                                            } catch (JSONException e) {
                                                                throw new FacebookException("An error occurred while publishing install.", e);
                                                            }
                                                        } catch (Exception unused2) {
                                                            return;
                                                        } catch (Throwable th2) {
                                                            CrashShieldHandler.handleThrowable(facebookSdk3, th2);
                                                            return;
                                                        }
                                                    default:
                                                        if (CrashShieldHandler.isObjectCrashing(OnDeviceProcessingManager.class)) {
                                                            return;
                                                        }
                                                        try {
                                                            SharedPreferences sharedPreferences3 = applicationContext4.getSharedPreferences("com.facebook.sdk.attributionTracking", 0);
                                                            String strStringPlus2 = Intrinsics.stringPlus("pingForOnDevice", str4);
                                                            if (sharedPreferences3.getLong(strStringPlus2, 0L) == 0) {
                                                                if (!CrashShieldHandler.isObjectCrashing(RemoteServiceWrapper.class)) {
                                                                    try {
                                                                        RemoteServiceWrapper.INSTANCE.sendEvents(RemoteServiceWrapper.EventType.MOBILE_APP_INSTALL, str4, EmptyList.INSTANCE);
                                                                    } catch (Throwable th3) {
                                                                        CrashShieldHandler.handleThrowable(RemoteServiceWrapper.class, th3);
                                                                    }
                                                                    break;
                                                                }
                                                                SharedPreferences.Editor editorEdit2 = sharedPreferences3.edit();
                                                                editorEdit2.putLong(strStringPlus2, System.currentTimeMillis());
                                                                editorEdit2.apply();
                                                                return;
                                                            }
                                                            return;
                                                        } catch (Throwable th4) {
                                                            CrashShieldHandler.handleThrowable(OnDeviceProcessingManager.class, th4);
                                                            return;
                                                        }
                                                }
                                            }
                                        });
                                    } catch (Throwable th2) {
                                        CrashShieldHandler.handleThrowable(OnDeviceProcessingManager.class, th2);
                                    }
                                }
                            } catch (Throwable th3) {
                                CrashShieldHandler.handleThrowable(FacebookSdk.class, th3);
                            }
                        }
                        ActivityLifecycleTracker.startTracking(application, applicationId);
                    } else {
                        Log.w("com.facebook.appevents.internal.AutomaticAnalyticsLogger", "Automatic logging of basic events will not happen, because FacebookSdk.getApplicationContext() returns object that is not instance of android.app.Application. Make sure you call FacebookSdk.sdkInitialize() from Application class and pass application context.");
                    }
                    break;
                }
                FetchedAppSettingsManager.loadingState.set(FetchedAppSettingsManager.fetchedAppSettings.containsKey(str2) ? FetchedAppSettingsManager.FetchAppSettingState.SUCCESS : FetchedAppSettingsManager.FetchAppSettingState.ERROR);
                fetchedAppSettingsManager.pollCallbacks();
                return;
            default:
                String str4 = this.f$1;
                Context context2 = this.f$0;
                String str5 = this.f$2;
                JSONObject appGateKeepersQueryResponse2 = FetchedAppGateKeepersManager.getAppGateKeepersQueryResponse();
                if (appGateKeepersQueryResponse2.length() != 0) {
                    FetchedAppGateKeepersManager.parseAppGateKeepersFromJSON$facebook_core_release(str4, appGateKeepersQueryResponse2);
                    context2.getSharedPreferences("com.facebook.internal.preferences.APP_GATEKEEPERS", 0).edit().putString(str5, appGateKeepersQueryResponse2.toString()).apply();
                    FetchedAppGateKeepersManager.timestamp = Long.valueOf(System.currentTimeMillis());
                }
                FetchedAppGateKeepersManager.pollCallbacks();
                FetchedAppGateKeepersManager.isLoading.set(false);
                return;
        }
    }

    public /* synthetic */ FetchedAppSettingsManager$$ExternalSyntheticLambda0(String str, Context context, String str2) {
        this.f$1 = str;
        this.f$0 = context;
        this.f$2 = str2;
    }
}
