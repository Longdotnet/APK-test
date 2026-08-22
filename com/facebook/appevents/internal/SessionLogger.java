package com.facebook.appevents.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.room.RoomOpenHelper;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.LoggingBehavior;
import com.facebook.UserSettingsManager;
import com.facebook.appevents.AppEventCollection;
import com.facebook.appevents.AppEventQueue;
import com.facebook.appevents.AppEventsLogger$FlushBehavior;
import com.facebook.appevents.AppEventsLoggerImpl;
import com.facebook.appevents.FlushReason;
import com.facebook.internal.Logger;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;

/* JADX INFO: loaded from: classes.dex */
public final class SessionLogger {
    public static final SessionLogger INSTANCE = new SessionLogger();
    public static final long[] INACTIVE_SECONDS_QUANTA = {300000, 900000, 1800000, 3600000, 21600000, 43200000, 86400000, 172800000, 259200000, 604800000, 1209600000, 1814400000, 2419200000L, 5184000000L, 7776000000L, 10368000000L, 12960000000L, 15552000000L, 31536000000L};

    public static final void logActivateApp(Context context, String str, String str2) {
        if (CrashShieldHandler.isObjectCrashing(SessionLogger.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(context, "context");
            Bundle bundle = new Bundle();
            bundle.putString("fb_mobile_launch_source", "Unclassified");
            bundle.putString("fb_mobile_pckg_fp", INSTANCE.computePackageChecksum(context));
            bundle.putString("fb_mobile_app_cert_hash", MediaType.Companion.getCertificateHash(context));
            AppEventsLoggerImpl appEventsLoggerImpl = new AppEventsLoggerImpl(str, str2);
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            if (UserSettingsManager.getAutoLogAppEventsEnabled()) {
                appEventsLoggerImpl.logEvent("fb_mobile_activate_app", bundle);
            }
            if (GraphRequest.Companion.getFlushBehavior() == AppEventsLogger$FlushBehavior.EXPLICIT_ONLY || CrashShieldHandler.isObjectCrashing(appEventsLoggerImpl)) {
                return;
            }
            try {
                AppEventCollection appEventCollection = AppEventQueue.appEventCollection;
                AppEventQueue.flush(FlushReason.EXPLICIT);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(appEventsLoggerImpl, th);
            }
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(SessionLogger.class, th2);
        }
    }

    public static final void logDeactivateApp(String str, SessionInfo sessionInfo, String str2) {
        int i;
        String string;
        Long l;
        if (CrashShieldHandler.isObjectCrashing(SessionLogger.class) || sessionInfo == null) {
            return;
        }
        try {
            Long l2 = (Long) sessionInfo.diskRestoreTime;
            if (l2 == null) {
                l2 = 0L;
            }
            long jLongValue = l2.longValue();
            SessionLogger sessionLogger = INSTANCE;
            if (jLongValue < 0) {
                sessionLogger.logClockSkewEvent();
                jLongValue = 0;
            }
            Long l3 = (Long) sessionInfo.sessionStartTime;
            long jLongValue2 = (l3 == null || (l = (Long) sessionInfo.sessionLastEventTime) == null) ? 0L : l.longValue() - l3.longValue();
            if (jLongValue2 < 0) {
                sessionLogger.logClockSkewEvent();
                jLongValue2 = 0;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("fb_mobile_app_interruptions", sessionInfo.interruptionCount);
            Locale locale = Locale.ROOT;
            if (CrashShieldHandler.isObjectCrashing(SessionLogger.class)) {
                i = 0;
            } else {
                i = 0;
                while (true) {
                    try {
                        long[] jArr = INACTIVE_SECONDS_QUANTA;
                        if (i >= 19 || jArr[i] >= jLongValue) {
                            break;
                        } else {
                            i++;
                        }
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(SessionLogger.class, th);
                        i = 0;
                    }
                }
            }
            bundle.putString("fb_mobile_time_between_sessions", String.format(locale, "session_quanta_%d", Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1)));
            RoomOpenHelper.ValidationResult validationResult = (RoomOpenHelper.ValidationResult) sessionInfo.sourceApplicationInfo;
            String str3 = "Unclassified";
            if (validationResult != null && (string = validationResult.toString()) != null) {
                str3 = string;
            }
            bundle.putString("fb_mobile_launch_source", str3);
            Long l4 = (Long) sessionInfo.sessionLastEventTime;
            bundle.putLong("_logTime", (l4 == null ? 0L : l4.longValue()) / ((long) 1000));
            AppEventsLoggerImpl appEventsLoggerImpl = new AppEventsLoggerImpl(str, str2);
            double d = jLongValue2 / 1000;
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            if (!UserSettingsManager.getAutoLogAppEventsEnabled() || CrashShieldHandler.isObjectCrashing(appEventsLoggerImpl)) {
                return;
            }
            try {
                appEventsLoggerImpl.logEvent("fb_mobile_deactivate_app", Double.valueOf(d), bundle, false, ActivityLifecycleTracker.getCurrentSessionGuid());
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(appEventsLoggerImpl, th2);
            }
        } catch (Throwable th3) {
            CrashShieldHandler.handleThrowable(SessionLogger.class, th3);
        }
    }

    public final String computePackageChecksum(Context context) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            String strStringPlus = Intrinsics.stringPlus(packageManager.getPackageInfo(context.getPackageName(), 0).versionName, "PCKGCHKSUM;");
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0);
            String string = sharedPreferences.getString(strStringPlus, null);
            if (string != null && string.length() == 32) {
                return string;
            }
            String strComputeChecksumWithPackageManager = HashUtils.computeChecksumWithPackageManager(context);
            if (strComputeChecksumWithPackageManager == null) {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
                Intrinsics.checkNotNullExpressionValue(applicationInfo, "pm.getApplicationInfo(context.packageName, 0)");
                strComputeChecksumWithPackageManager = HashUtils.computeChecksum(applicationInfo.sourceDir);
            }
            sharedPreferences.edit().putString(strStringPlus, strComputeChecksumWithPackageManager).apply();
            return strComputeChecksumWithPackageManager;
        } catch (Exception unused) {
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
            return null;
        }
    }

    public final void logClockSkewEvent() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            GraphRequest.Companion companion = Logger.Companion;
            GraphRequest.Companion.log(LoggingBehavior.APP_EVENTS, "com.facebook.appevents.internal.SessionLogger", "Clock skew detected");
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
        }
    }
}
