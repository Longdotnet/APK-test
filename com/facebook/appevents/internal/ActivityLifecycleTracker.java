package com.facebook.appevents.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import androidx.core.view.DifferentialMotionFlingController$$ExternalSyntheticLambda0;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventCollection;
import com.facebook.appevents.AppEventQueue;
import com.facebook.appevents.AppEventQueue$$ExternalSyntheticLambda0;
import com.facebook.appevents.aam.MetadataIndexer;
import com.facebook.appevents.aam.MetadataRule;
import com.facebook.appevents.aam.MetadataViewObserver;
import com.facebook.appevents.codeless.CodelessManager;
import com.facebook.appevents.codeless.CodelessManager$$ExternalSyntheticLambda0;
import com.facebook.appevents.codeless.CodelessMatcher;
import com.facebook.appevents.codeless.ViewIndexer;
import com.facebook.appevents.codeless.ViewIndexingTrigger;
import com.facebook.appevents.iap.InAppPurchaseManager;
import com.facebook.appevents.suggestedevents.SuggestedEventsManager;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Timer;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class ActivityLifecycleTracker {
    public static final String TAG;
    public static int activityReferences;
    public static String appId;
    public static WeakReference currActivity;
    public static long currentActivityAppearTime;
    public static volatile ScheduledFuture currentFuture;
    public static final Object currentFutureLock;
    public static volatile SessionInfo currentSession;
    public static final AtomicInteger foregroundActivityCount;
    public static final ScheduledExecutorService singleThreadExecutor;
    public static final AtomicBoolean tracking;

    /* JADX INFO: renamed from: com.facebook.appevents.internal.ActivityLifecycleTracker$startTracking$2, reason: invalid class name */
    public final class AnonymousClass2 implements Application.ActivityLifecycleCallbacks {
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            GraphRequest.Companion companion = Logger.Companion;
            GraphRequest.Companion.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityCreated");
            ActivityLifecycleTracker.singleThreadExecutor.execute(new AppEventQueue$$ExternalSyntheticLambda0(9));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            GraphRequest.Companion companion = Logger.Companion;
            GraphRequest.Companion.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityDestroyed");
            CodelessManager codelessManager = CodelessManager.INSTANCE;
            if (CrashShieldHandler.isObjectCrashing(CodelessManager.class)) {
                return;
            }
            try {
                CodelessMatcher companion2 = CodelessMatcher.Companion.getInstance();
                if (CrashShieldHandler.isObjectCrashing(companion2)) {
                    return;
                }
                try {
                    companion2.activityToListenerMap.remove(Integer.valueOf(activity.hashCode()));
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(companion2, th);
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(CodelessManager.class, th2);
            }
        }

        /* JADX WARN: Code duplicated, block: B:32:0x007a A[Catch: all -> 0x0085, TryCatch #1 {all -> 0x0085, blocks: (B:8:0x0037, B:11:0x0040, B:32:0x007a, B:35:0x007f, B:14:0x004e, B:31:0x0077, B:17:0x0055, B:20:0x0060, B:24:0x0068, B:23:0x0065, B:29:0x006f), top: B:43:0x0037, inners: #2 }] */
        /* JADX WARN: Code duplicated, block: B:34:0x007e  */
        /* JADX WARN: Code duplicated, block: B:35:0x007f A[Catch: all -> 0x0085, TRY_LEAVE, TryCatch #1 {all -> 0x0085, blocks: (B:8:0x0037, B:11:0x0040, B:32:0x007a, B:35:0x007f, B:14:0x004e, B:31:0x0077, B:17:0x0055, B:20:0x0060, B:24:0x0068, B:23:0x0065, B:29:0x006f), top: B:43:0x0037, inners: #2 }] */
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            SensorManager sensorManager;
            int i = 0;
            Intrinsics.checkNotNullParameter(activity, "activity");
            GraphRequest.Companion companion = Logger.Companion;
            LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
            String str = ActivityLifecycleTracker.TAG;
            GraphRequest.Companion.log(loggingBehavior, str, "onActivityPaused");
            AtomicInteger atomicInteger = ActivityLifecycleTracker.foregroundActivityCount;
            if (atomicInteger.decrementAndGet() < 0) {
                atomicInteger.set(0);
                Log.w(str, "Unexpected activity pause without a matching activity resume. Logging data may be incorrect. Make sure you call activateApp from your Application's onCreate method");
            }
            ActivityLifecycleTracker.cancelCurrentTask();
            long jCurrentTimeMillis = System.currentTimeMillis();
            String activityName = Utility.getActivityName(activity);
            CodelessManager codelessManager = CodelessManager.INSTANCE;
            if (!CrashShieldHandler.isObjectCrashing(CodelessManager.class)) {
                try {
                    if (CodelessManager.isCodelessEnabled.get()) {
                        CodelessMatcher.Companion.getInstance().remove(activity);
                        ViewIndexer viewIndexer = CodelessManager.viewIndexer;
                        if (viewIndexer == null || CrashShieldHandler.isObjectCrashing(viewIndexer)) {
                            sensorManager = CodelessManager.sensorManager;
                            if (sensorManager != null) {
                                sensorManager.unregisterListener(CodelessManager.viewIndexingTrigger);
                            }
                        } else {
                            try {
                                if (((Activity) viewIndexer.activityReference.get()) == null) {
                                    sensorManager = CodelessManager.sensorManager;
                                    if (sensorManager != null) {
                                        sensorManager.unregisterListener(CodelessManager.viewIndexingTrigger);
                                    }
                                } else {
                                    try {
                                        Timer timer = viewIndexer.indexingTimer;
                                        if (timer != null) {
                                            timer.cancel();
                                        }
                                        viewIndexer.indexingTimer = null;
                                    } catch (Exception e) {
                                        Log.e(ViewIndexer.TAG, "Error unscheduling indexing job", e);
                                    }
                                    sensorManager = CodelessManager.sensorManager;
                                    if (sensorManager != null) {
                                        sensorManager.unregisterListener(CodelessManager.viewIndexingTrigger);
                                    }
                                }
                            } catch (Throwable th) {
                                CrashShieldHandler.handleThrowable(viewIndexer, th);
                            }
                        }
                    }
                } catch (Throwable th2) {
                    CrashShieldHandler.handleThrowable(CodelessManager.class, th2);
                }
            }
            ActivityLifecycleTracker.singleThreadExecutor.execute(new ActivityLifecycleTracker$$ExternalSyntheticLambda2(jCurrentTimeMillis, activityName, i));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            GraphRequest.Companion companion = Logger.Companion;
            GraphRequest.Companion.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityResumed");
            ActivityLifecycleTracker.currActivity = new WeakReference(activity);
            ActivityLifecycleTracker.foregroundActivityCount.incrementAndGet();
            ActivityLifecycleTracker.cancelCurrentTask();
            final long jCurrentTimeMillis = System.currentTimeMillis();
            ActivityLifecycleTracker.currentActivityAppearTime = jCurrentTimeMillis;
            final String activityName = Utility.getActivityName(activity);
            CodelessManager codelessManager = CodelessManager.INSTANCE;
            if (!CrashShieldHandler.isObjectCrashing(CodelessManager.class)) {
                try {
                    if (CodelessManager.isCodelessEnabled.get()) {
                        CodelessMatcher.Companion.getInstance().add(activity);
                        Context applicationContext = activity.getApplicationContext();
                        String applicationId = FacebookSdk.getApplicationId();
                        FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(applicationId);
                        boolean zAreEqual = Intrinsics.areEqual(appSettingsWithoutQuery == null ? null : Boolean.valueOf(appSettingsWithoutQuery.codelessEventsEnabled), Boolean.TRUE);
                        CodelessManager codelessManager2 = CodelessManager.INSTANCE;
                        if (zAreEqual) {
                            SensorManager sensorManager = (SensorManager) applicationContext.getSystemService("sensor");
                            if (sensorManager != null) {
                                CodelessManager.sensorManager = sensorManager;
                                Sensor defaultSensor = sensorManager.getDefaultSensor(1);
                                ViewIndexer viewIndexer = new ViewIndexer(activity);
                                CodelessManager.viewIndexer = viewIndexer;
                                ViewIndexingTrigger viewIndexingTrigger = CodelessManager.viewIndexingTrigger;
                                CodelessManager$$ExternalSyntheticLambda0 codelessManager$$ExternalSyntheticLambda0 = new CodelessManager$$ExternalSyntheticLambda0(appSettingsWithoutQuery, applicationId, 0);
                                if (!CrashShieldHandler.isObjectCrashing(viewIndexingTrigger)) {
                                    try {
                                        viewIndexingTrigger.onShakeListener = codelessManager$$ExternalSyntheticLambda0;
                                    } catch (Throwable th) {
                                        CrashShieldHandler.handleThrowable(viewIndexingTrigger, th);
                                    }
                                }
                                sensorManager.registerListener(viewIndexingTrigger, defaultSensor, 2);
                                if (appSettingsWithoutQuery != null && appSettingsWithoutQuery.codelessEventsEnabled) {
                                    viewIndexer.schedule();
                                }
                            }
                        } else {
                            CrashShieldHandler.isObjectCrashing(codelessManager2);
                        }
                        CrashShieldHandler.isObjectCrashing(codelessManager2);
                    }
                } catch (Throwable th2) {
                    CrashShieldHandler.handleThrowable(CodelessManager.class, th2);
                }
            }
            if (!CrashShieldHandler.isObjectCrashing(MetadataIndexer.class)) {
                try {
                    if (MetadataIndexer.enabled) {
                        CopyOnWriteArraySet copyOnWriteArraySet = MetadataRule.rules;
                        if (!new HashSet(MetadataRule.access$getRules$cp()).isEmpty()) {
                            HashMap map = MetadataViewObserver.observers;
                            MetadataIndexer.startTrackingActivity(activity);
                        }
                    }
                } catch (Exception unused) {
                } catch (Throwable th3) {
                    CrashShieldHandler.handleThrowable(MetadataIndexer.class, th3);
                }
            }
            SuggestedEventsManager.trackActivity(activity);
            InAppPurchaseManager.startTracking();
            final Context applicationContext2 = activity.getApplicationContext();
            ActivityLifecycleTracker.singleThreadExecutor.execute(new Runnable() { // from class: com.facebook.appevents.internal.ActivityLifecycleTracker$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    SessionInfo sessionInfo;
                    long j = jCurrentTimeMillis;
                    String str = activityName;
                    Context appContext = applicationContext2;
                    SessionInfo sessionInfo2 = ActivityLifecycleTracker.currentSession;
                    Long l = sessionInfo2 == null ? null : (Long) sessionInfo2.sessionLastEventTime;
                    if (ActivityLifecycleTracker.currentSession == null) {
                        ActivityLifecycleTracker.currentSession = new SessionInfo(Long.valueOf(j), null);
                        String str2 = ActivityLifecycleTracker.appId;
                        Intrinsics.checkNotNullExpressionValue(appContext, "appContext");
                        SessionLogger.logActivateApp(appContext, str, str2);
                    } else if (l != null) {
                        long jLongValue = j - l.longValue();
                        String str3 = ActivityLifecycleTracker.TAG;
                        FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
                        FetchedAppSettings appSettingsWithoutQuery2 = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
                        if (jLongValue > (appSettingsWithoutQuery2 == null ? 60 : appSettingsWithoutQuery2.sessionTimeoutInSeconds) * 1000) {
                            SessionLogger.logDeactivateApp(str, ActivityLifecycleTracker.currentSession, ActivityLifecycleTracker.appId);
                            String str4 = ActivityLifecycleTracker.appId;
                            Intrinsics.checkNotNullExpressionValue(appContext, "appContext");
                            SessionLogger.logActivateApp(appContext, str, str4);
                            ActivityLifecycleTracker.currentSession = new SessionInfo(Long.valueOf(j), null);
                        } else if (jLongValue > 1000 && (sessionInfo = ActivityLifecycleTracker.currentSession) != null) {
                            sessionInfo.interruptionCount++;
                        }
                    }
                    SessionInfo sessionInfo3 = ActivityLifecycleTracker.currentSession;
                    if (sessionInfo3 != null) {
                        sessionInfo3.sessionLastEventTime = Long.valueOf(j);
                    }
                    SessionInfo sessionInfo4 = ActivityLifecycleTracker.currentSession;
                    if (sessionInfo4 == null) {
                        return;
                    }
                    sessionInfo4.writeSessionToDisk();
                }
            });
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(outState, "outState");
            GraphRequest.Companion companion = Logger.Companion;
            GraphRequest.Companion.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivitySaveInstanceState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            ActivityLifecycleTracker.activityReferences++;
            GraphRequest.Companion companion = Logger.Companion;
            GraphRequest.Companion.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityStarted");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            GraphRequest.Companion companion = Logger.Companion;
            GraphRequest.Companion.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityStopped");
            AppEventCollection appEventCollection = AppEventQueue.appEventCollection;
            if (!CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
                try {
                    AppEventQueue.singleThreadExecutor.execute(new AppEventQueue$$ExternalSyntheticLambda0(2));
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(AppEventQueue.class, th);
                }
            }
            ActivityLifecycleTracker.activityReferences--;
        }
    }

    static {
        String canonicalName = ActivityLifecycleTracker.class.getCanonicalName();
        if (canonicalName == null) {
            canonicalName = "com.facebook.appevents.internal.ActivityLifecycleTracker";
        }
        TAG = canonicalName;
        singleThreadExecutor = Executors.newSingleThreadScheduledExecutor();
        currentFutureLock = new Object();
        foregroundActivityCount = new AtomicInteger(0);
        tracking = new AtomicBoolean(false);
    }

    public static void cancelCurrentTask() {
        ScheduledFuture scheduledFuture;
        synchronized (currentFutureLock) {
            try {
                if (currentFuture != null && (scheduledFuture = currentFuture) != null) {
                    scheduledFuture.cancel(false);
                }
                currentFuture = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static final UUID getCurrentSessionGuid() {
        SessionInfo sessionInfo;
        if (currentSession == null || (sessionInfo = currentSession) == null) {
            return null;
        }
        return (UUID) sessionInfo.sessionId;
    }

    public static final void startTracking(Application application, String str) {
        Intrinsics.checkNotNullParameter(application, "application");
        if (tracking.compareAndSet(false, true)) {
            FeatureManager featureManager = FeatureManager.INSTANCE;
            FeatureManager.checkFeature(new DifferentialMotionFlingController$$ExternalSyntheticLambda0(15), FeatureManager.Feature.CodelessEvents);
            appId = str;
            application.registerActivityLifecycleCallbacks(new AnonymousClass2());
        }
    }
}
