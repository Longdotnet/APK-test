package com.facebook;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.util.Log;
import androidx.core.view.DifferentialMotionFlingController$$ExternalSyntheticLambda0;
import androidx.room.RoomOpenHelper;
import androidx.work.Worker;
import com.daerisoft.thespikerm.GamepadHandler_API19;
import com.daerisoft.thespikerm.RunnerActivity;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.google.android.gms.ads.internal.util.zzq;
import com.google.android.gms.measurement.internal.RVw.ZRqOdXiy;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.Headers;

/* JADX INFO: loaded from: classes2.dex */
public final class FacebookSdk {
    public static final ReentrantLock LOCK;
    public static volatile String appClientToken;
    public static Context applicationContext;
    public static volatile String applicationId;
    public static volatile String applicationName;
    public static boolean bypassAppSwitch;
    public static int callbackRequestCodeOffset;
    public static volatile Boolean codelessDebugLogEnabled;
    public static Executor executor;
    public static volatile String facebookDomain;
    public static final String graphApiVersion;
    public static final DifferentialMotionFlingController$$ExternalSyntheticLambda0 graphRequestCreator;
    public static boolean hasCustomTabsPrefetching;
    public static boolean ignoreAppSwitchToLoggedOut;
    public static volatile String instagramDomain;
    public static boolean isFullyInitialized;
    public static final AtomicBoolean sdkInitialized;
    public static final FacebookSdk INSTANCE = new FacebookSdk();
    public static final HashSet loggingBehaviors = GamepadHandler_API19.hashSetOf(LoggingBehavior.DEVELOPER_ERRORS);

    static {
        new AtomicLong(65536L);
        callbackRequestCodeOffset = 64206;
        LOCK = new ReentrantLock();
        graphApiVersion = "v16.0";
        sdkInitialized = new AtomicBoolean(false);
        instagramDomain = "instagram.com";
        facebookDomain = "facebook.com";
        graphRequestCreator = new DifferentialMotionFlingController$$ExternalSyntheticLambda0(3);
    }

    public static final Context getApplicationContext() {
        Validate.sdkInitialized();
        Context context = applicationContext;
        if (context != null) {
            return context;
        }
        Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
        throw null;
    }

    public static final String getApplicationId() {
        Validate.sdkInitialized();
        String str = applicationId;
        if (str != null) {
            return str;
        }
        throw new FacebookException("A valid Facebook app id must be set in the AndroidManifest.xml or set by calling FacebookSdk.setApplicationId before initializing the sdk.");
    }

    public static final Executor getExecutor() {
        ReentrantLock reentrantLock = LOCK;
        reentrantLock.lock();
        try {
            if (executor == null) {
                executor = AsyncTask.THREAD_POOL_EXECUTOR;
            }
            reentrantLock.unlock();
            Executor executor2 = executor;
            if (executor2 != null) {
                return executor2;
            }
            throw new IllegalStateException("Required value was null.");
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public static final String getGraphApiVersion() {
        String str = graphApiVersion;
        String.format("getGraphApiVersion: %s", Arrays.copyOf(new Object[]{str}, 1));
        return str;
    }

    public static final String getGraphDomain() {
        Date date = AccessToken.DEFAULT_EXPIRATION_TIME;
        AccessToken currentAccessToken = Headers.Companion.getCurrentAccessToken();
        String str = currentAccessToken != null ? currentAccessToken.graphDomain : null;
        String str2 = facebookDomain;
        if (str == null) {
            return str2;
        }
        if (str.equals("gaming")) {
            return StringsKt__StringsKt.replace$default(str2, "facebook.com", "fb.gg");
        }
        return str.equals("instagram") ? StringsKt__StringsKt.replace$default(str2, "facebook.com", "instagram.com") : str2;
    }

    public static final boolean getLimitEventAndDataUsage(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Validate.sdkInitialized();
        return context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getBoolean("limitEventUsage", false);
    }

    public static final synchronized boolean isFullyInitialized() {
        return isFullyInitialized;
    }

    public static final void isLoggingBehaviorEnabled(LoggingBehavior loggingBehavior) {
        synchronized (loggingBehaviors) {
        }
    }

    public static final void loadDefaultsFromMetadata$facebook_core_release(Context context) {
        if (context == null) {
            return;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            Intrinsics.checkNotNullExpressionValue(applicationInfo, "try {\n          context.packageManager.getApplicationInfo(\n              context.packageName, PackageManager.GET_META_DATA)\n        } catch (e: PackageManager.NameNotFoundException) {\n          return\n        }");
            if (applicationInfo.metaData == null) {
                return;
            }
            if (applicationId == null) {
                Object obj = applicationInfo.metaData.get("com.facebook.sdk.ApplicationId");
                if (obj instanceof String) {
                    String str = (String) obj;
                    Locale ROOT = Locale.ROOT;
                    Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
                    String lowerCase = str.toLowerCase(ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                    if (StringsKt__StringsKt.startsWith(lowerCase, "fb", false)) {
                        String strSubstring = str.substring(2);
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
                        applicationId = strSubstring;
                    } else {
                        applicationId = str;
                    }
                } else if (obj instanceof Number) {
                    throw new FacebookException("App Ids cannot be directly placed in the manifest.They must be prefixed by 'fb' or be placed in the string resource file.");
                }
            }
            if (applicationName == null) {
                applicationName = applicationInfo.metaData.getString("com.facebook.sdk.ApplicationName");
            }
            if (appClientToken == null) {
                appClientToken = applicationInfo.metaData.getString("com.facebook.sdk.ClientToken");
            }
            if (callbackRequestCodeOffset == 64206) {
                callbackRequestCodeOffset = applicationInfo.metaData.getInt("com.facebook.sdk.CallbackOffset", 64206);
            }
            if (codelessDebugLogEnabled == null) {
                codelessDebugLogEnabled = Boolean.valueOf(applicationInfo.metaData.getBoolean("com.facebook.sdk.CodelessDebugLogEnabled", false));
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public static final synchronized void sdkInitialize(Context applicationContext2, RoomOpenHelper roomOpenHelper) {
        ActivityInfo activityInfo;
        boolean value;
        int i = 0;
        synchronized (FacebookSdk.class) {
            try {
                Intrinsics.checkNotNullParameter(applicationContext2, "applicationContext");
                if (sdkInitialized.get()) {
                    if (roomOpenHelper != null) {
                        ((RunnerActivity) roomOpenHelper.mConfiguration).runOnUiThread(new Worker.AnonymousClass1(roomOpenHelper, 20));
                    }
                    return;
                }
                PackageManager packageManager = applicationContext2.getPackageManager();
                if (packageManager != null) {
                    try {
                        activityInfo = packageManager.getActivityInfo(new ComponentName(applicationContext2, "com.facebook.FacebookActivity"), 1);
                    } catch (PackageManager.NameNotFoundException unused) {
                        activityInfo = null;
                    }
                } else {
                    activityInfo = null;
                }
                if (activityInfo == null) {
                    Log.w("com.facebook.internal.Validate", "FacebookActivity is not declared in the AndroidManifest.xml. If you are using the facebook-common module or dependent modules please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info.");
                }
                if (applicationContext2.checkCallingOrSelfPermission("android.permission.INTERNET") == -1) {
                    Log.w("com.facebook.internal.Validate", "No internet permissions granted for the app, please add <uses-permission android:name=\"android.permission.INTERNET\" /> to your AndroidManifest.xml.");
                }
                Context applicationContext3 = applicationContext2.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext3, "applicationContext.applicationContext");
                applicationContext = applicationContext3;
                CloseableKt.getAnonymousAppDeviceGUID(applicationContext2);
                Context context = applicationContext;
                if (context == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
                    throw null;
                }
                loadDefaultsFromMetadata$facebook_core_release(context);
                String str = applicationId;
                if (str == null || str.length() == 0) {
                    throw new FacebookException("A valid Facebook app id must be set in the AndroidManifest.xml or set by calling FacebookSdk.setApplicationId before initializing the sdk.");
                }
                String str2 = appClientToken;
                if (str2 == null || str2.length() == 0) {
                    throw new FacebookException("A valid Facebook app client token must be set in the AndroidManifest.xml or set by calling FacebookSdk.setClientToken before initializing the sdk.");
                }
                sdkInitialized.set(true);
                UserSettingsManager userSettingsManager = UserSettingsManager.INSTANCE;
                if (CrashShieldHandler.isObjectCrashing(UserSettingsManager.class)) {
                    value = false;
                } else {
                    try {
                        UserSettingsManager.INSTANCE.initializeIfNotInitialized();
                        value = UserSettingsManager.autoInitEnabled.getValue();
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(UserSettingsManager.class, th);
                        value = false;
                    }
                }
                if (value) {
                    isFullyInitialized = true;
                }
                Context context2 = applicationContext;
                if (context2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
                    throw null;
                }
                if ((context2 instanceof Application) && UserSettingsManager.getAutoLogAppEventsEnabled()) {
                    String str3 = ActivityLifecycleTracker.TAG;
                    Context context3 = applicationContext;
                    if (context3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
                        throw null;
                    }
                    ActivityLifecycleTracker.startTracking((Application) context3, applicationId);
                }
                FetchedAppSettingsManager.loadAppSettingsAsync();
                NativeProtocol.updateAllAvailableProtocolVersionsAsync();
                zzq zzqVar = zzq.singleton;
                Context context4 = applicationContext;
                if (context4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(ZRqOdXiy.bCc);
                    throw null;
                }
                Utility.getInstance(context4);
                final FacebookSdk$$ExternalSyntheticLambda1 facebookSdk$$ExternalSyntheticLambda1 = new FacebookSdk$$ExternalSyntheticLambda1();
                final RoomOpenHelper roomOpenHelper2 = new RoomOpenHelper(22);
                roomOpenHelper2.mDelegate = new CountDownLatch(1);
                getExecutor().execute(new FutureTask(new Callable() { // from class: com.facebook.internal.LockOnGetVariable$$ExternalSyntheticLambda0
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        RoomOpenHelper roomOpenHelper3 = roomOpenHelper2;
                        CountDownLatch countDownLatch = (CountDownLatch) roomOpenHelper3.mDelegate;
                        try {
                            roomOpenHelper3.mConfiguration = facebookSdk$$ExternalSyntheticLambda1.call();
                        } finally {
                            if (countDownLatch != null) {
                                countDownLatch.countDown();
                            }
                        }
                    }
                }));
                FeatureManager featureManager = FeatureManager.INSTANCE;
                FeatureManager.checkFeature(new DifferentialMotionFlingController$$ExternalSyntheticLambda0(4), FeatureManager.Feature.Instrument);
                FeatureManager.checkFeature(new DifferentialMotionFlingController$$ExternalSyntheticLambda0(5), FeatureManager.Feature.AppEvents);
                FeatureManager.checkFeature(new DifferentialMotionFlingController$$ExternalSyntheticLambda0(6), FeatureManager.Feature.ChromeCustomTabsPrefetching);
                FeatureManager.checkFeature(new DifferentialMotionFlingController$$ExternalSyntheticLambda0(7), FeatureManager.Feature.IgnoreAppSwitchToLoggedOut);
                FeatureManager.checkFeature(new DifferentialMotionFlingController$$ExternalSyntheticLambda0(8), FeatureManager.Feature.BypassAppSwitch);
                getExecutor().execute(new FutureTask(new FacebookSdk$$ExternalSyntheticLambda7(roomOpenHelper, i)));
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
