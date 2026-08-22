package com.facebook.internal.instrument.anrreport;

import android.app.ActivityManager;
import android.os.Looper;
import android.os.Process;
import com.daerisoft.thespikerm.GamepadHandler_API19;
import com.facebook.appevents.AppEventQueue$$ExternalSyntheticLambda0;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public abstract class ANRDetector {
    public static final int myUid = Process.myUid();
    public static final ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
    public static String previousStackTrace = "";
    public static final AppEventQueue$$ExternalSyntheticLambda0 anrDetectorRunnable = new AppEventQueue$$ExternalSyntheticLambda0(15);

    public static final void checkProcessError(ActivityManager activityManager) {
        if (CrashShieldHandler.isObjectCrashing(ANRDetector.class)) {
            return;
        }
        try {
            List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
            if (processesInErrorState == null) {
                return;
            }
            for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                if (processErrorStateInfo.condition == 2 && processErrorStateInfo.uid == myUid) {
                    Thread thread = Looper.getMainLooper().getThread();
                    Intrinsics.checkNotNullExpressionValue(thread, "getMainLooper().thread");
                    StackTraceElement[] stackTrace = thread.getStackTrace();
                    JSONArray jSONArray = new JSONArray();
                    Intrinsics.checkNotNullExpressionValue(stackTrace, "stackTrace");
                    int length = stackTrace.length;
                    int i = 0;
                    while (i < length) {
                        StackTraceElement stackTraceElement = stackTrace[i];
                        i++;
                        jSONArray.put(stackTraceElement.toString());
                    }
                    String string = jSONArray.toString();
                    if (!Intrinsics.areEqual(string, previousStackTrace) && Headers.Companion.isSDKRelatedThread(thread)) {
                        previousStackTrace = string;
                        GamepadHandler_API19.build(processErrorStateInfo.shortMsg, string).save();
                    }
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(ANRDetector.class, th);
        }
    }
}
