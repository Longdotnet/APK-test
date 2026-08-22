package com.facebook.appevents.codeless;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import com.android.billingclient.api.zzaz;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest$Companion$$ExternalSyntheticLambda1;
import com.facebook.GraphResponse;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.Logger;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.google.android.gms.common.stats.ZnFR.FKidOcdAYt;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class ViewIndexer {
    public static final String TAG;
    public final WeakReference activityReference;
    public Timer indexingTimer;
    public String previousDigest;
    public final Handler uiThreadHandler;

    static {
        String canonicalName = ViewIndexer.class.getCanonicalName();
        if (canonicalName == null) {
            canonicalName = "";
        }
        TAG = canonicalName;
    }

    public ViewIndexer(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activityReference = new WeakReference(activity);
        this.previousDigest = null;
        this.uiThreadHandler = new Handler(Looper.getMainLooper());
    }

    public static final /* synthetic */ String access$getTAG$cp() {
        if (CrashShieldHandler.isObjectCrashing(ViewIndexer.class)) {
            return null;
        }
        try {
            return TAG;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(ViewIndexer.class, th);
            return null;
        }
    }

    public final void processRequest(GraphRequest graphRequest, String str) {
        String str2 = TAG;
        if (CrashShieldHandler.isObjectCrashing(this) || graphRequest == null) {
            return;
        }
        try {
            GraphResponse graphResponseExecuteAndWait = graphRequest.executeAndWait();
            try {
                JSONObject jSONObject = graphResponseExecuteAndWait.graphObject;
                if (jSONObject == null) {
                    Log.e(str2, Intrinsics.stringPlus(graphResponseExecuteAndWait.error, "Error sending UI component tree to Facebook: "));
                    return;
                }
                if ("true".equals(jSONObject.optString(FirebaseAnalytics.Param.SUCCESS))) {
                    GraphRequest.Companion companion = Logger.Companion;
                    GraphRequest.Companion.log(LoggingBehavior.APP_EVENTS, str2, "Successfully send UI component tree to server");
                    this.previousDigest = str;
                }
                if (jSONObject.has("is_app_indexing_enabled")) {
                    boolean z = jSONObject.getBoolean("is_app_indexing_enabled");
                    CodelessManager codelessManager = CodelessManager.INSTANCE;
                    if (CrashShieldHandler.isObjectCrashing(CodelessManager.class)) {
                        return;
                    }
                    try {
                        CodelessManager.isAppIndexingEnabled.set(z);
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(CodelessManager.class, th);
                    }
                }
            } catch (JSONException e) {
                Log.e(str2, "Error decoding server response.", e);
            }
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(this, th2);
        }
    }

    public final void schedule() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            try {
                FacebookSdk.getExecutor().execute(new GraphRequest$Companion$$ExternalSyntheticLambda1(this, new TimerTask() { // from class: com.facebook.appevents.codeless.ViewIndexer$schedule$indexingTask$1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public final void run() {
                        WeakReference weakReference;
                        try {
                            boolean zIsObjectCrashing = CrashShieldHandler.isObjectCrashing(ViewIndexer.class);
                            Handler handler = null;
                            ViewIndexer viewIndexer = this.this$0;
                            if (zIsObjectCrashing) {
                                weakReference = null;
                            } else {
                                try {
                                    weakReference = viewIndexer.activityReference;
                                } catch (Throwable th) {
                                    CrashShieldHandler.handleThrowable(ViewIndexer.class, th);
                                    weakReference = null;
                                }
                            }
                            Activity activity = (Activity) weakReference.get();
                            View rootView = AppEventUtility.getRootView(activity);
                            if (activity != null && rootView != null) {
                                String simpleName = activity.getClass().getSimpleName();
                                CodelessManager codelessManager = CodelessManager.INSTANCE;
                                boolean z = false;
                                if (!CrashShieldHandler.isObjectCrashing(CodelessManager.class)) {
                                    try {
                                        z = CodelessManager.isAppIndexingEnabled.get();
                                    } catch (Throwable th2) {
                                        CrashShieldHandler.handleThrowable(CodelessManager.class, th2);
                                    }
                                }
                                if (z) {
                                    String str = "";
                                    if (Intrinsics.areEqual(null, Boolean.TRUE)) {
                                        StringsKt__IndentKt.sendMessage("CaptureViewHierarchy", "");
                                        return;
                                    }
                                    FutureTask futureTask = new FutureTask(new zzaz(rootView));
                                    if (!CrashShieldHandler.isObjectCrashing(ViewIndexer.class)) {
                                        try {
                                            handler = viewIndexer.uiThreadHandler;
                                        } catch (Throwable th3) {
                                            CrashShieldHandler.handleThrowable(ViewIndexer.class, th3);
                                        }
                                    }
                                    handler.post(futureTask);
                                    try {
                                        str = (String) futureTask.get(1L, TimeUnit.SECONDS);
                                    } catch (Exception e) {
                                        Log.e(ViewIndexer.access$getTAG$cp(), "Failed to take screenshot.", e);
                                    }
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        jSONObject.put("screenname", simpleName);
                                        jSONObject.put("screenshot", str);
                                        JSONArray jSONArray = new JSONArray();
                                        jSONArray.put(ViewHierarchy.getDictionaryOfView(rootView));
                                        jSONObject.put(FKidOcdAYt.BCwLEpnzYvdzXg, jSONArray);
                                    } catch (JSONException unused) {
                                        Log.e(ViewIndexer.access$getTAG$cp(), "Failed to create JSONObject");
                                    }
                                    String string = jSONObject.toString();
                                    Intrinsics.checkNotNullExpressionValue(string, "viewTree.toString()");
                                    if (CrashShieldHandler.isObjectCrashing(ViewIndexer.class)) {
                                        return;
                                    }
                                    try {
                                        viewIndexer.getClass();
                                        if (!CrashShieldHandler.isObjectCrashing(viewIndexer)) {
                                            try {
                                                FacebookSdk.getExecutor().execute(new GraphRequest$Companion$$ExternalSyntheticLambda1(string, viewIndexer, 16));
                                            } catch (Throwable th4) {
                                                CrashShieldHandler.handleThrowable(viewIndexer, th4);
                                            }
                                        }
                                    } catch (Throwable th5) {
                                        CrashShieldHandler.handleThrowable(ViewIndexer.class, th5);
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            Log.e(ViewIndexer.access$getTAG$cp(), "UI Component tree indexing failure!", e2);
                        }
                    }
                }, 15));
            } catch (RejectedExecutionException e) {
                Log.e(TAG, "Error scheduling indexing job", e);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
        }
    }
}
