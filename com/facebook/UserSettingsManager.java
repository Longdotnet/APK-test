package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.facebook.appevents.AppEventsLoggerImpl;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Validate;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.google.android.gms.ads.internal.gMU.QTaELkFI;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class UserSettingsManager {
    public static SharedPreferences userSettingPref;
    public static final UserSettingsManager INSTANCE = new UserSettingsManager();
    public static final AtomicBoolean isInitialized = new AtomicBoolean(false);
    public static final AtomicBoolean isFetchingCodelessStatus = new AtomicBoolean(false);
    public static final UserSetting autoInitEnabled = new UserSetting(true, "com.facebook.sdk.AutoInitEnabled");
    public static final UserSetting autoLogAppEventsEnabled = new UserSetting(true, "com.facebook.sdk.AutoLogAppEventsEnabled");
    public static final UserSetting advertiserIDCollectionEnabled = new UserSetting(true, "com.facebook.sdk.AdvertiserIDCollectionEnabled");
    public static final UserSetting codelessSetupEnabled = new UserSetting(false, "auto_event_setup_enabled");
    public static final UserSetting monitorEnabled = new UserSetting(true, "com.facebook.sdk.MonitorEnabled");

    /* JADX INFO: loaded from: classes.dex */
    public final class UserSetting {
        public final boolean defaultVal;
        public final String key;
        public long lastTS;
        public Boolean value;

        public UserSetting(boolean z, String str) {
            this.defaultVal = z;
            this.key = str;
        }

        public final boolean getValue() {
            Boolean bool = this.value;
            return bool == null ? this.defaultVal : bool.booleanValue();
        }
    }

    public static final boolean getAdvertiserIDCollectionEnabled() {
        if (CrashShieldHandler.isObjectCrashing(UserSettingsManager.class)) {
            return false;
        }
        try {
            INSTANCE.initializeIfNotInitialized();
            return advertiserIDCollectionEnabled.getValue();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(UserSettingsManager.class, th);
            return false;
        }
    }

    public static final boolean getAutoLogAppEventsEnabled() {
        if (CrashShieldHandler.isObjectCrashing(UserSettingsManager.class)) {
            return false;
        }
        try {
            INSTANCE.initializeIfNotInitialized();
            return autoLogAppEventsEnabled.getValue();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(UserSettingsManager.class, th);
            return false;
        }
    }

    public final void initializeCodelessSetupEnabledAsync() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            UserSetting userSetting = codelessSetupEnabled;
            readSettingFromCache(userSetting);
            final long jCurrentTimeMillis = System.currentTimeMillis();
            if (userSetting.value == null || jCurrentTimeMillis - userSetting.lastTS >= 604800000) {
                userSetting.value = null;
                userSetting.lastTS = 0L;
                if (isFetchingCodelessStatus.compareAndSet(false, true)) {
                    FacebookSdk.getExecutor().execute(new Runnable() { // from class: com.facebook.UserSettingsManager$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            long j = jCurrentTimeMillis;
                            if (CrashShieldHandler.isObjectCrashing(UserSettingsManager.class)) {
                                return;
                            }
                            try {
                                if (UserSettingsManager.advertiserIDCollectionEnabled.getValue()) {
                                    FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
                                    FetchedAppSettings fetchedAppSettingsQueryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
                                    if (fetchedAppSettingsQueryAppSettings != null && fetchedAppSettingsQueryAppSettings.codelessEventsEnabled) {
                                        AttributionIdentifiers attributionIdentifiers = Validate.getAttributionIdentifiers(FacebookSdk.getApplicationContext());
                                        String androidAdvertiserId = (attributionIdentifiers == null || attributionIdentifiers.getAndroidAdvertiserId() == null) ? null : attributionIdentifiers.getAndroidAdvertiserId();
                                        if (androidAdvertiserId != null) {
                                            Bundle bundle = new Bundle();
                                            bundle.putString("advertiser_id", androidAdvertiserId);
                                            bundle.putString("fields", "auto_event_setup_enabled");
                                            String str = GraphRequest.MIME_BOUNDARY;
                                            GraphRequest graphRequestNewGraphPathRequest = GraphRequest.Companion.newGraphPathRequest(null, "app", null);
                                            graphRequestNewGraphPathRequest.parameters = bundle;
                                            JSONObject jSONObject = graphRequestNewGraphPathRequest.executeAndWait().graphObject;
                                            if (jSONObject != null) {
                                                UserSettingsManager.UserSetting userSetting2 = UserSettingsManager.codelessSetupEnabled;
                                                userSetting2.value = Boolean.valueOf(jSONObject.optBoolean("auto_event_setup_enabled", false));
                                                userSetting2.lastTS = j;
                                                UserSettingsManager.INSTANCE.writeSettingToCache(userSetting2);
                                            }
                                        }
                                    }
                                }
                                UserSettingsManager.isFetchingCodelessStatus.set(false);
                            } catch (Throwable th) {
                                CrashShieldHandler.handleThrowable(UserSettingsManager.class, th);
                            }
                        }
                    });
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
        }
    }

    public final void initializeIfNotInitialized() {
        int i = 0;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if (FacebookSdk.sdkInitialized.get() && isInitialized.compareAndSet(false, true)) {
                SharedPreferences sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.sdk.USER_SETTINGS", 0);
                Intrinsics.checkNotNullExpressionValue(sharedPreferences, "FacebookSdk.getApplicationContext()\n            .getSharedPreferences(USER_SETTINGS, Context.MODE_PRIVATE)");
                userSettingPref = sharedPreferences;
                UserSetting[] userSettingArr = {autoLogAppEventsEnabled, advertiserIDCollectionEnabled, autoInitEnabled};
                if (!CrashShieldHandler.isObjectCrashing(this)) {
                    while (i < 3) {
                        try {
                            UserSetting userSetting = userSettingArr[i];
                            i++;
                            if (userSetting == codelessSetupEnabled) {
                                initializeCodelessSetupEnabledAsync();
                            } else if (userSetting.value == null) {
                                readSettingFromCache(userSetting);
                                if (userSetting.value == null) {
                                    loadSettingFromManifest(userSetting);
                                }
                            } else {
                                writeSettingToCache(userSetting);
                            }
                        } catch (Throwable th) {
                            CrashShieldHandler.handleThrowable(this, th);
                            initializeCodelessSetupEnabledAsync();
                            logWarnings();
                            logIfSDKSettingsChanged();
                        }
                    }
                }
                initializeCodelessSetupEnabledAsync();
                logWarnings();
                logIfSDKSettingsChanged();
            }
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(this, th2);
        }
    }

    public final void loadSettingFromManifest(UserSetting userSetting) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            validateInitialized();
            try {
                Context applicationContext = FacebookSdk.getApplicationContext();
                ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128);
                Intrinsics.checkNotNullExpressionValue(applicationInfo, "ctx.packageManager.getApplicationInfo(ctx.packageName, PackageManager.GET_META_DATA)");
                Bundle bundle = applicationInfo.metaData;
                if (bundle == null || !bundle.containsKey(userSetting.key)) {
                    return;
                }
                userSetting.value = Boolean.valueOf(applicationInfo.metaData.getBoolean(userSetting.key, userSetting.defaultVal));
                return;
            } catch (PackageManager.NameNotFoundException unused) {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                return;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
        }
        CrashShieldHandler.handleThrowable(this, th);
    }

    public final void logIfSDKSettingsChanged() {
        int i;
        int i2;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if (isInitialized.get() && FacebookSdk.sdkInitialized.get()) {
                Context applicationContext = FacebookSdk.getApplicationContext();
                int i3 = (autoInitEnabled.getValue() ? 1 : 0) | ((autoLogAppEventsEnabled.getValue() ? 1 : 0) << 1) | ((advertiserIDCollectionEnabled.getValue() ? 1 : 0) << 2) | ((monitorEnabled.getValue() ? 1 : 0) << 3);
                SharedPreferences sharedPreferences = userSettingPref;
                if (sharedPreferences == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("userSettingPref");
                    throw null;
                }
                int i4 = 0;
                int i5 = sharedPreferences.getInt("com.facebook.sdk.USER_SETTINGS_BITMASK", 0);
                if (i5 != i3) {
                    SharedPreferences sharedPreferences2 = userSettingPref;
                    if (sharedPreferences2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("userSettingPref");
                        throw null;
                    }
                    sharedPreferences2.edit().putInt("com.facebook.sdk.USER_SETTINGS_BITMASK", i3).apply();
                    try {
                        ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128);
                        Intrinsics.checkNotNullExpressionValue(applicationInfo, "ctx.packageManager.getApplicationInfo(ctx.packageName, PackageManager.GET_META_DATA)");
                        if (applicationInfo.metaData != null) {
                            String[] strArr = {"com.facebook.sdk.AutoInitEnabled", "com.facebook.sdk.AutoLogAppEventsEnabled", "com.facebook.sdk.AdvertiserIDCollectionEnabled", "com.facebook.sdk.MonitorEnabled"};
                            boolean[] zArr = {true, true, true, true};
                            i = 0;
                            i2 = 0;
                            while (true) {
                                int i6 = i4 + 1;
                                try {
                                    i |= (applicationInfo.metaData.containsKey(strArr[i4]) ? 1 : 0) << i4;
                                    i2 |= (applicationInfo.metaData.getBoolean(strArr[i4], zArr[i4]) ? 1 : 0) << i4;
                                    if (i6 > 3) {
                                        break;
                                    } else {
                                        i4 = i6;
                                    }
                                } catch (PackageManager.NameNotFoundException unused) {
                                    i4 = i2;
                                    i2 = i4;
                                }
                            }
                            i4 = i;
                        } else {
                            i2 = 0;
                        }
                    } catch (PackageManager.NameNotFoundException unused2) {
                        i = 0;
                    }
                    AppEventsLoggerImpl appEventsLoggerImpl = new AppEventsLoggerImpl(applicationContext, (String) null);
                    Bundle bundle = new Bundle();
                    bundle.putInt("usage", i4);
                    bundle.putInt("initial", i2);
                    bundle.putInt("previous", i5);
                    bundle.putInt("current", i3);
                    if ((bundle.getInt("previous") & 2) == 0) {
                        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                        if (!getAutoLogAppEventsEnabled()) {
                            return;
                        }
                    }
                    appEventsLoggerImpl.logEventImplicitly(bundle, "fb_sdk_settings_changed");
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
        }
    }

    public final void logWarnings() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Context applicationContext = FacebookSdk.getApplicationContext();
            ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128);
            Intrinsics.checkNotNullExpressionValue(applicationInfo, "ctx.packageManager.getApplicationInfo(ctx.packageName, PackageManager.GET_META_DATA)");
            Bundle bundle = applicationInfo.metaData;
            if (bundle != null) {
                if (!bundle.containsKey("com.facebook.sdk.AutoLogAppEventsEnabled")) {
                    Log.w("com.facebook.UserSettingsManager", "Please set a value for AutoLogAppEventsEnabled. Set the flag to TRUE if you want to collect app install, app launch and in-app purchase events automatically. To request user consent before collecting data, set the flag value to FALSE, then change to TRUE once user consent is received. Learn more: https://developers.facebook.com/docs/app-events/getting-started-app-events-android#disable-auto-events.");
                }
                if (!applicationInfo.metaData.containsKey("com.facebook.sdk.AdvertiserIDCollectionEnabled")) {
                    Log.w("com.facebook.UserSettingsManager", "You haven't set a value for AdvertiserIDCollectionEnabled. Set the flag to TRUE if you want to collect Advertiser ID for better advertising and analytics results. To request user consent before collecting data, set the flag value to FALSE, then change to TRUE once user consent is received. Learn more: https://developers.facebook.com/docs/app-events/getting-started-app-events-android#disable-auto-events.");
                }
                if (getAdvertiserIDCollectionEnabled()) {
                    return;
                }
                Log.w("com.facebook.UserSettingsManager", "The value for AdvertiserIDCollectionEnabled is currently set to FALSE so you're sending app events without collecting Advertiser ID. This can affect the quality of your advertising and analytics results.");
            }
        } catch (PackageManager.NameNotFoundException unused) {
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
        }
    }

    public final void validateInitialized() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if (isInitialized.get()) {
            } else {
                throw new FacebookSdkNotInitializedException("The UserSettingManager has not been initialized successfully");
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
        }
    }

    public final void writeSettingToCache(UserSetting userSetting) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            validateInitialized();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(FirebaseAnalytics.Param.VALUE, userSetting.value);
                jSONObject.put("last_timestamp", userSetting.lastTS);
                SharedPreferences sharedPreferences = userSettingPref;
                if (sharedPreferences == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("userSettingPref");
                    throw null;
                }
                sharedPreferences.edit().putString(userSetting.key, jSONObject.toString()).apply();
                logIfSDKSettingsChanged();
            } catch (Exception unused) {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
        }
    }

    public final void readSettingFromCache(UserSetting userSetting) {
        String str = "";
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            validateInitialized();
            try {
                SharedPreferences sharedPreferences = userSettingPref;
                if (sharedPreferences == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("userSettingPref");
                    throw null;
                }
                String string = sharedPreferences.getString(userSetting.key, "");
                if (string != null) {
                    str = string;
                }
                if (str.length() > 0) {
                    JSONObject jSONObject = new JSONObject(str);
                    userSetting.value = Boolean.valueOf(jSONObject.getBoolean(QTaELkFI.zFxdPvxJIVDJBaS));
                    userSetting.lastTS = jSONObject.getLong("last_timestamp");
                }
            } catch (JSONException unused) {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
        }
    }
}
