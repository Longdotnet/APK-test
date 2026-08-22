package com.facebook.appevents.suggestedevents;

import android.view.View;
import com.facebook.FacebookSdk;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.ml.ModelManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class ViewOnClickListener implements View.OnClickListener {
    public static final HashSet viewsAttachedListener = new HashSet();
    public final String activityName;
    public final View.OnClickListener baseListener;
    public final WeakReference hostViewWeakReference;
    public final WeakReference rootViewWeakReference;

    public ViewOnClickListener(View view, View view2, String str) {
        this.baseListener = ViewHierarchy.getExistingOnClickListener(view);
        this.rootViewWeakReference = new WeakReference(view2);
        this.hostViewWeakReference = new WeakReference(view);
        String lowerCase = str.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        this.activityName = StringsKt__StringsKt.replace$default(lowerCase, "activity", "");
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                Intrinsics.checkNotNullParameter(view, "view");
                View.OnClickListener onClickListener = this.baseListener;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
                process();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(this, th);
            }
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(this, th2);
        }
    }

    public final void process() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            View view = (View) this.rootViewWeakReference.get();
            View view2 = (View) this.hostViewWeakReference.get();
            if (view == null || view2 == null) {
                return;
            }
            try {
                final String textOfViewRecursively = SuggestedEventViewHierarchy.getTextOfViewRecursively(view2);
                final String pathID = PredictionHistoryManager.getPathID(view2, textOfViewRecursively);
                if (pathID == null || FeatureExtractor.access$queryHistoryAndProcess(pathID, textOfViewRecursively)) {
                    return;
                }
                final JSONObject jSONObject = new JSONObject();
                jSONObject.put("view", SuggestedEventViewHierarchy.getDictionaryOfView(view, view2));
                jSONObject.put("screenname", this.activityName);
                if (CrashShieldHandler.isObjectCrashing(this)) {
                    return;
                }
                try {
                    Utility.runOnNonUiThread(new Runnable() { // from class: com.facebook.appevents.suggestedevents.ViewOnClickListener$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            JSONObject jSONObject2 = jSONObject;
                            String buttonText = textOfViewRecursively;
                            ViewOnClickListener this$0 = this;
                            String str = pathID;
                            if (CrashShieldHandler.isObjectCrashing(ViewOnClickListener.class)) {
                                return;
                            }
                            try {
                                Intrinsics.checkNotNullParameter(buttonText, "$buttonText");
                                Intrinsics.checkNotNullParameter(this$0, "this$0");
                                try {
                                    String appName = Utility.getAppName(FacebookSdk.getApplicationContext());
                                    if (appName == null) {
                                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                    }
                                    String lowerCase = appName.toLowerCase();
                                    Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                                    float[] denseFeatures = FeatureExtractor.getDenseFeatures(lowerCase, jSONObject2);
                                    String textFeature = FeatureExtractor.getTextFeature(buttonText, this$0.activityName, lowerCase);
                                    if (denseFeatures == null) {
                                        return;
                                    }
                                    ModelManager modelManager = ModelManager.INSTANCE;
                                    String[] strArrPredict = ModelManager.predict(ModelManager.Task.MTML_APP_EVENT_PREDICTION, new float[][]{denseFeatures}, new String[]{textFeature});
                                    if (strArrPredict == null) {
                                        return;
                                    }
                                    String str2 = strArrPredict[0];
                                    PredictionHistoryManager.addPrediction(str, str2);
                                    if (Intrinsics.areEqual(str2, "other")) {
                                        return;
                                    }
                                    HashSet hashSet = ViewOnClickListener.viewsAttachedListener;
                                    FeatureExtractor.processPredictedResult(str2, buttonText, denseFeatures);
                                } catch (Exception unused) {
                                }
                            } catch (Throwable th) {
                                CrashShieldHandler.handleThrowable(ViewOnClickListener.class, th);
                            }
                        }
                    });
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(this, th);
                }
            } catch (Exception unused) {
            }
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(this, th2);
        }
    }
}
