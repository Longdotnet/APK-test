package com.facebook.appevents.ml;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.startup.StartupException;
import androidx.work.impl.constraints.controllers.pST.ehgOP;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.AppEventQueue$$ExternalSyntheticLambda0;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgressionIterator;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt__StringsKt;
import okio.AsyncTimeout;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class ModelManager {
    public static final ModelManager INSTANCE = new ModelManager();
    public static final ConcurrentHashMap taskHandlers = new ConcurrentHashMap();
    public static final List MTML_SUGGESTED_EVENTS_PREDICTION = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"other", "fb_mobile_complete_registration", "fb_mobile_add_to_cart", "fb_mobile_purchase", "fb_mobile_initiated_checkout"});
    public static final List MTML_INTEGRITY_DETECT_PREDICTION = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"none", "address", "health"});

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: loaded from: classes.dex */
    public final class Task {
        public static final /* synthetic */ Task[] $VALUES;
        public static final Task MTML_APP_EVENT_PREDICTION;
        public static final Task MTML_INTEGRITY_DETECT;

        static {
            Task task = new Task("MTML_INTEGRITY_DETECT", 0);
            MTML_INTEGRITY_DETECT = task;
            Task task2 = new Task("MTML_APP_EVENT_PREDICTION", 1);
            MTML_APP_EVENT_PREDICTION = task2;
            $VALUES = new Task[]{task, task2};
        }

        public static Task valueOf(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return (Task) Enum.valueOf(Task.class, value);
        }

        public static Task[] values() {
            return (Task[]) Arrays.copyOf($VALUES, 2);
        }

        public final String toKey() {
            int iOrdinal = ordinal();
            if (iOrdinal == 0) {
                return "integrity_detect";
            }
            if (iOrdinal == 1) {
                return "app_event_pred";
            }
            throw new StartupException();
        }

        public final String toUseCase() {
            int iOrdinal = ordinal();
            if (iOrdinal == 0) {
                return "MTML_INTEGRITY_DETECT";
            }
            if (iOrdinal == 1) {
                return "MTML_APP_EVENT_PRED";
            }
            throw new StartupException();
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    public final class TaskHandler {
        public final String assetUri;
        public Model model;
        public Runnable onPostExecute;
        public File ruleFile;
        public final String ruleUri;
        public final float[] thresholds;
        public final String useCase;
        public final int versionId;

        public TaskHandler(String str, String str2, String str3, int i, float[] fArr) {
            this.useCase = str;
            this.assetUri = str2;
            this.ruleUri = str3;
            this.versionId = i;
            this.thresholds = fArr;
        }
    }

    public static final File getRuleFile() {
        Task task = Task.MTML_APP_EVENT_PREDICTION;
        if (CrashShieldHandler.isObjectCrashing(ModelManager.class)) {
            return null;
        }
        try {
            TaskHandler taskHandler = (TaskHandler) taskHandlers.get(task.toUseCase());
            if (taskHandler == null) {
                return null;
            }
            return taskHandler.ruleFile;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(ModelManager.class, th);
            return null;
        }
    }

    public static final String[] predict(Task task, float[][] fArr, String[] strArr) {
        if (CrashShieldHandler.isObjectCrashing(ModelManager.class)) {
            return null;
        }
        try {
            TaskHandler taskHandler = (TaskHandler) taskHandlers.get(task.toUseCase());
            Model model = taskHandler == null ? null : taskHandler.model;
            if (model == null) {
                return null;
            }
            float[] fArr2 = taskHandler.thresholds;
            int length = strArr.length;
            int length2 = fArr[0].length;
            MTensor mTensor = new MTensor(new int[]{length, length2});
            if (length > 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    System.arraycopy(fArr[i], 0, mTensor.data, i * length2, length2);
                    if (i2 >= length) {
                        break;
                    }
                    i = i2;
                }
            }
            MTensor mTensorPredictOnMTML = model.predictOnMTML(mTensor, strArr, task.toKey());
            if (mTensorPredictOnMTML != null && fArr2 != null && mTensorPredictOnMTML.data.length != 0 && fArr2.length != 0) {
                int iOrdinal = task.ordinal();
                ModelManager modelManager = INSTANCE;
                if (iOrdinal == 0) {
                    return modelManager.processIntegrityDetectionResult(mTensorPredictOnMTML, fArr2);
                }
                if (iOrdinal == 1) {
                    return modelManager.processSuggestedEventResult(mTensorPredictOnMTML, fArr2);
                }
                throw new StartupException();
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(ModelManager.class, th);
            return null;
        }
    }

    public final void addModels(JSONObject jSONObject) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Iterator itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                try {
                    TaskHandler taskHandlerBuild = AsyncTimeout.Companion.build(jSONObject.getJSONObject((String) itKeys.next()));
                    if (taskHandlerBuild != null) {
                        taskHandlers.put(taskHandlerBuild.useCase, taskHandlerBuild);
                    }
                } catch (JSONException unused) {
                    return;
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0080 A[Catch: all -> 0x008d, TryCatch #2 {all -> 0x008d, blocks: (B:5:0x0007, B:6:0x001a, B:8:0x0020, B:10:0x003e, B:12:0x0050, B:24:0x0080, B:23:0x007c, B:28:0x0090, B:30:0x009c, B:32:0x00ae, B:35:0x00c0, B:37:0x00c6, B:15:0x0057, B:19:0x0069), top: B:43:0x0007, inners: #1 }] */
    public final void enableMTML() {
        Locale locale;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            ArrayList arrayList = new ArrayList();
            String str = null;
            int iMax = 0;
            for (Map.Entry entry : taskHandlers.entrySet()) {
                String str2 = (String) entry.getKey();
                TaskHandler taskHandler = (TaskHandler) entry.getValue();
                if (Intrinsics.areEqual(str2, Task.MTML_APP_EVENT_PREDICTION.toUseCase())) {
                    str = taskHandler.assetUri;
                    int iMax2 = Math.max(iMax, taskHandler.versionId);
                    FeatureManager featureManager = FeatureManager.INSTANCE;
                    if (FeatureManager.isEnabled(FeatureManager.Feature.SuggestedEvents) && !CrashShieldHandler.isObjectCrashing(this)) {
                        try {
                            try {
                                locale = FacebookSdk.getApplicationContext().getResources().getConfiguration().locale;
                            } catch (Throwable th) {
                                CrashShieldHandler.handleThrowable(this, th);
                            }
                        } catch (Exception unused) {
                            locale = null;
                        }
                        if (locale != null) {
                            String language = locale.getLanguage();
                            Intrinsics.checkNotNullExpressionValue(language, "locale.language");
                            if (StringsKt__StringsKt.contains$default(language, "en")) {
                                taskHandler.onPostExecute = new AppEventQueue$$ExternalSyntheticLambda0(11);
                                arrayList.add(taskHandler);
                            }
                        } else {
                            taskHandler.onPostExecute = new AppEventQueue$$ExternalSyntheticLambda0(11);
                            arrayList.add(taskHandler);
                        }
                    }
                    iMax = iMax2;
                }
                if (Intrinsics.areEqual(str2, Task.MTML_INTEGRITY_DETECT.toUseCase())) {
                    str = taskHandler.assetUri;
                    iMax = Math.max(iMax, taskHandler.versionId);
                    FeatureManager featureManager2 = FeatureManager.INSTANCE;
                    if (FeatureManager.isEnabled(FeatureManager.Feature.IntelligentIntegrity)) {
                        taskHandler.onPostExecute = new AppEventQueue$$ExternalSyntheticLambda0(12);
                        arrayList.add(taskHandler);
                    }
                }
            }
            if (str == null || iMax <= 0 || arrayList.isEmpty()) {
                return;
            }
            AsyncTimeout.Companion.execute(new TaskHandler("MTML", str, null, iMax, null), arrayList);
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(this, th2);
        }
    }

    public final JSONObject parseRawJsonObject(JSONObject jSONObject) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("data");
                int length = jSONArray.length();
                if (length <= 0) {
                    return jSONObject2;
                }
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("version_id", jSONObject3.getString("version_id"));
                    jSONObject4.put("use_case", jSONObject3.getString("use_case"));
                    jSONObject4.put("thresholds", jSONObject3.getJSONArray("thresholds"));
                    jSONObject4.put("asset_uri", jSONObject3.getString("asset_uri"));
                    if (jSONObject3.has("rules_uri")) {
                        jSONObject4.put("rules_uri", jSONObject3.getString("rules_uri"));
                    }
                    jSONObject2.put(jSONObject3.getString("use_case"), jSONObject4);
                    if (i2 >= length) {
                        return jSONObject2;
                    }
                    i = i2;
                }
            } catch (JSONException unused) {
                return new JSONObject();
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
            return null;
        }
        CrashShieldHandler.handleThrowable(this, th);
        return null;
    }

    public final String[] processIntegrityDetectionResult(MTensor mTensor, float[] fArr) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            int[] iArr = mTensor.shape;
            int i = iArr[0];
            int i2 = iArr[1];
            float[] fArr2 = mTensor.data;
            if (i2 != fArr.length) {
                return null;
            }
            IntRange intRangeUntil = RangesKt.until(0, i);
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(intRangeUntil));
            Iterator it = intRangeUntil.iterator();
            while (((IntProgressionIterator) it).hasNext) {
                int iNextInt = ((IntProgressionIterator) it).nextInt();
                Object obj = "none";
                int length = fArr.length;
                int i3 = 0;
                int i4 = 0;
                while (i3 < length) {
                    int i5 = i4 + 1;
                    if (fArr2[(iNextInt * i2) + i4] >= fArr[i3]) {
                        obj = MTML_INTEGRITY_DETECT_PREDICTION.get(i4);
                    }
                    i3++;
                    i4 = i5;
                }
                arrayList.add((String) obj);
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array != null) {
                return (String[]) array;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
            return null;
        }
    }

    public final String[] processSuggestedEventResult(MTensor mTensor, float[] fArr) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            int[] iArr = mTensor.shape;
            int i = iArr[0];
            int i2 = iArr[1];
            float[] fArr2 = mTensor.data;
            if (i2 != fArr.length) {
                return null;
            }
            IntRange intRangeUntil = RangesKt.until(0, i);
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(intRangeUntil));
            Iterator it = intRangeUntil.iterator();
            while (((IntProgressionIterator) it).hasNext) {
                int iNextInt = ((IntProgressionIterator) it).nextInt();
                Object obj = "other";
                int length = fArr.length;
                int i3 = 0;
                int i4 = 0;
                while (i3 < length) {
                    int i5 = i4 + 1;
                    if (fArr2[(iNextInt * i2) + i4] >= fArr[i3]) {
                        obj = MTML_SUGGESTED_EVENTS_PREDICTION.get(i4);
                    }
                    i3++;
                    i4 = i5;
                }
                arrayList.add((String) obj);
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array != null) {
                return (String[]) array;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
            return null;
        }
    }

    public final JSONObject fetchModels() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            String[] strArr = {"use_case", "version_id", ehgOP.utHVGh, "rules_uri", "thresholds"};
            Bundle bundle = new Bundle();
            bundle.putString("fields", TextUtils.join(",", strArr));
            String str = GraphRequest.MIME_BOUNDARY;
            GraphRequest graphRequestNewGraphPathRequest = GraphRequest.Companion.newGraphPathRequest(null, "app/model_asset", null);
            graphRequestNewGraphPathRequest.parameters = bundle;
            JSONObject jSONObject = graphRequestNewGraphPathRequest.executeAndWait().graphObject;
            if (jSONObject == null) {
                return null;
            }
            return parseRawJsonObject(jSONObject);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
            return null;
        }
    }
}
