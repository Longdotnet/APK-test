package com.facebook.appevents.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import androidx.fragment.app.Fragment;
import com.facebook.FacebookSdk;
import com.facebook.UserSettingsManager;
import com.facebook.appevents.AppEventsLoggerImpl;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ActivityLifecycleTracker$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ long f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ ActivityLifecycleTracker$$ExternalSyntheticLambda2(long j, String str, int i) {
        this.$r8$classId = i;
        this.f$0 = j;
        this.f$1 = str;
    }

    private final void run$com$facebook$appevents$internal$ActivityLifecycleTracker$$ExternalSyntheticLambda2() {
        int i = 1;
        long j = this.f$0;
        String str = this.f$1;
        if (ActivityLifecycleTracker.currentSession == null) {
            ActivityLifecycleTracker.currentSession = new SessionInfo(Long.valueOf(j), null);
        }
        SessionInfo sessionInfo = ActivityLifecycleTracker.currentSession;
        if (sessionInfo != null) {
            sessionInfo.sessionLastEventTime = Long.valueOf(j);
        }
        if (ActivityLifecycleTracker.foregroundActivityCount.get() <= 0) {
            ActivityLifecycleTracker$$ExternalSyntheticLambda2 activityLifecycleTracker$$ExternalSyntheticLambda2 = new ActivityLifecycleTracker$$ExternalSyntheticLambda2(j, str, i);
            synchronized (ActivityLifecycleTracker.currentFutureLock) {
                ScheduledExecutorService scheduledExecutorService = ActivityLifecycleTracker.singleThreadExecutor;
                FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
                FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
                ActivityLifecycleTracker.currentFuture = scheduledExecutorService.schedule(activityLifecycleTracker$$ExternalSyntheticLambda2, appSettingsWithoutQuery == null ? 60 : appSettingsWithoutQuery.sessionTimeoutInSeconds, TimeUnit.SECONDS);
            }
        }
        long j2 = ActivityLifecycleTracker.currentActivityAppearTime;
        long j3 = j2 > 0 ? (j - j2) / ((long) 1000) : 0L;
        Fragment.AnonymousClass7 anonymousClass7 = AutomaticAnalyticsLogger.internalAppEventsLogger;
        Context applicationContext = FacebookSdk.getApplicationContext();
        FetchedAppSettings fetchedAppSettingsQueryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
        if (fetchedAppSettingsQueryAppSettings != null && fetchedAppSettingsQueryAppSettings.automaticLoggingEnabled && j3 > 0) {
            AppEventsLoggerImpl appEventsLoggerImpl = new AppEventsLoggerImpl(applicationContext, (String) null);
            Bundle bundle = new Bundle(1);
            bundle.putCharSequence("fb_aa_time_spent_view_name", str);
            double d = j3;
            if (UserSettingsManager.getAutoLogAppEventsEnabled() && !CrashShieldHandler.isObjectCrashing(appEventsLoggerImpl)) {
                try {
                    appEventsLoggerImpl.logEvent("fb_aa_time_spent_on_view", Double.valueOf(d), bundle, false, ActivityLifecycleTracker.getCurrentSessionGuid());
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(appEventsLoggerImpl, th);
                }
            }
        }
        SessionInfo sessionInfo2 = ActivityLifecycleTracker.currentSession;
        if (sessionInfo2 == null) {
            return;
        }
        sessionInfo2.writeSessionToDisk();
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                run$com$facebook$appevents$internal$ActivityLifecycleTracker$$ExternalSyntheticLambda2();
                return;
            default:
                long j = this.f$0;
                String str = this.f$1;
                if (ActivityLifecycleTracker.currentSession == null) {
                    ActivityLifecycleTracker.currentSession = new SessionInfo(Long.valueOf(j), null);
                }
                if (ActivityLifecycleTracker.foregroundActivityCount.get() <= 0) {
                    SessionLogger.logDeactivateApp(str, ActivityLifecycleTracker.currentSession, ActivityLifecycleTracker.appId);
                    SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
                    editorEdit.remove("com.facebook.appevents.SessionInfo.sessionStartTime");
                    editorEdit.remove("com.facebook.appevents.SessionInfo.sessionEndTime");
                    editorEdit.remove("com.facebook.appevents.SessionInfo.interruptionCount");
                    editorEdit.remove("com.facebook.appevents.SessionInfo.sessionId");
                    editorEdit.apply();
                    SharedPreferences.Editor editorEdit2 = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
                    editorEdit2.remove("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage");
                    editorEdit2.remove("com.facebook.appevents.SourceApplicationInfo.openedByApplink");
                    editorEdit2.apply();
                    ActivityLifecycleTracker.currentSession = null;
                }
                synchronized (ActivityLifecycleTracker.currentFutureLock) {
                    ActivityLifecycleTracker.currentFuture = null;
                }
                return;
        }
    }
}
