package com.facebook.appevents;

import android.content.Context;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.internal.FetchedAppGateKeepersManager;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.google.android.finsky.externalreferrer.jUdg.RDFWIi;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.Headers;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
public final class AppEventsLoggerImpl {
    public static String anonymousAppDeviceGUID;
    public static ScheduledThreadPoolExecutor backgroundExecutor;
    public static boolean isActivateAppEventRequested;
    public static final Object staticLock = new Object();
    public final AccessTokenAppIdPair accessTokenAppId;
    public final String contextName;

    public AppEventsLoggerImpl(String str, String str2) {
        Validate.sdkInitialized();
        this.contextName = str;
        Date date = AccessToken.DEFAULT_EXPIRATION_TIME;
        AccessToken currentAccessToken = Headers.Companion.getCurrentAccessToken();
        if (currentAccessToken == null || new Date().after(currentAccessToken.expires) || !(str2 == null || str2.equals(currentAccessToken.applicationId))) {
            if (str2 == null) {
                FacebookSdk.getApplicationContext();
                str2 = FacebookSdk.getApplicationId();
            }
            this.accessTokenAppId = new AccessTokenAppIdPair(null, str2);
        } else {
            this.accessTokenAppId = new AccessTokenAppIdPair(currentAccessToken.token, FacebookSdk.getApplicationId());
        }
        GraphRequest.Companion.initializeTimersIfNeeded();
    }

    public static final /* synthetic */ String access$getAnonymousAppDeviceGUID$cp() {
        if (CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
            return null;
        }
        try {
            return anonymousAppDeviceGUID;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(AppEventsLoggerImpl.class, th);
            return null;
        }
    }

    public static final /* synthetic */ ScheduledThreadPoolExecutor access$getBackgroundExecutor$cp() {
        if (CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
            return null;
        }
        try {
            return backgroundExecutor;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(AppEventsLoggerImpl.class, th);
            return null;
        }
    }

    public static final /* synthetic */ Object access$getStaticLock$cp() {
        if (CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
            return null;
        }
        try {
            return staticLock;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(AppEventsLoggerImpl.class, th);
            return null;
        }
    }

    public final void logEvent(String str, Bundle bundle) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            logEvent(str, null, bundle, false, ActivityLifecycleTracker.getCurrentSessionGuid());
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
        }
    }

    public final void logEventImplicitly(Bundle bundle, String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            logEvent(str, null, bundle, true, ActivityLifecycleTracker.getCurrentSessionGuid());
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
        }
    }

    public final void logEvent(String str, Double d, Bundle bundle, boolean z, UUID uuid) {
        if (CrashShieldHandler.isObjectCrashing(this) || str == null) {
            return;
        }
        try {
            if (str.length() == 0) {
                return;
            }
            AtomicBoolean atomicBoolean = FetchedAppGateKeepersManager.isLoading;
            boolean gateKeeperForKey = FetchedAppGateKeepersManager.getGateKeeperForKey("app_events_killswitch", FacebookSdk.getApplicationId(), false);
            LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
            if (gateKeeperForKey) {
                GraphRequest.Companion companion = Logger.Companion;
                synchronized (FacebookSdk.loggingBehaviors) {
                }
                return;
            }
            try {
                GraphRequest.Companion.access$logEvent(new AppEvent(this.contextName, str, d, bundle, z, ActivityLifecycleTracker.activityReferences == 0, uuid), this.accessTokenAppId);
            } catch (FacebookException e) {
                GraphRequest.Companion companion2 = Logger.Companion;
                GraphRequest.Companion.log(loggingBehavior, "AppEvents", "Invalid app event: %s", e.toString());
            } catch (JSONException e2) {
                GraphRequest.Companion companion3 = Logger.Companion;
                GraphRequest.Companion.log(loggingBehavior, "AppEvents", "JSON encoding for app event failed: '%s'", e2.toString());
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
        }
    }

    public final void logPurchase(BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        String str = RDFWIi.uvvkxHJoiQ;
        LoggingBehavior loggingBehavior = LoggingBehavior.DEVELOPER_ERRORS;
        try {
            if (bigDecimal == null) {
                GraphRequest.Companion companion = Logger.Companion;
                GraphRequest.Companion.log(loggingBehavior, str, "purchaseAmount cannot be null");
                return;
            }
            if (currency == null) {
                GraphRequest.Companion companion2 = Logger.Companion;
                GraphRequest.Companion.log(loggingBehavior, str, "currency cannot be null");
                return;
            }
            if (bundle == null) {
                bundle = new Bundle();
            }
            Bundle bundle2 = bundle;
            bundle2.putString("fb_currency", currency.getCurrencyCode());
            logEvent("fb_mobile_purchase", Double.valueOf(bigDecimal.doubleValue()), bundle2, true, ActivityLifecycleTracker.getCurrentSessionGuid());
            if (GraphRequest.Companion.getFlushBehavior() != AppEventsLogger$FlushBehavior.EXPLICIT_ONLY) {
                AppEventCollection appEventCollection = AppEventQueue.appEventCollection;
                AppEventQueue.flush(FlushReason.EAGER_FLUSHING_EVENT);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
        }
    }

    public AppEventsLoggerImpl(Context context, String str) {
        this(Utility.getActivityName(context), str);
    }
}
