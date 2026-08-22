package kotlin;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.content.res.FontResourcesParserCompat$FontFamilyFilesResourceEntry;
import androidx.core.provider.FontsContractCompat$FontInfo;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline0;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.work.InputMergerFactory$1;
import androidx.work.Logger$LogcatLogger;
import androidx.work.OneTimeWorkRequest;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.utils.EnqueueRunnable;
import com.facebook.appevents.codeless.internal.EventBinding;
import com.facebook.appevents.codeless.internal.ParameterComponent;
import com.facebook.appevents.codeless.internal.PathComponent;
import com.google.android.datatransport.runtime.synchronization.JDyk.FETmZwrVHuasmL;
import com.google.android.gms.ads.internal.util.client.zzq;
import com.google.android.gms.ads.internal.util.client.zzr;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt__IndentKt;
import okhttp3.Dispatcher;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ExceptionsKt {
    public ExceptionsKt() {
        new ConcurrentHashMap();
    }

    public static Object access$000(Parcel parcel, Parcelable.Creator creator) {
        if (parcel.readInt() != 0) {
            return creator.createFromParcel(parcel);
        }
        return null;
    }

    public static void addSuppressed(Throwable th, Throwable exception) {
        Intrinsics.checkNotNullParameter(th, "<this>");
        Intrinsics.checkNotNullParameter(exception, "exception");
        if (th != exception) {
            PlatformImplementationsKt.IMPLEMENTATIONS.addSuppressed(th, exception);
        }
    }

    public static void checkRadix(int i) {
        if (new IntRange(2, 36, 1).contains(i)) {
            return;
        }
        StringBuilder sbM = Fragment$$ExternalSyntheticOutline0.m(i, "radix ", " was not in valid range ");
        sbM.append(new IntRange(2, 36, 1));
        throw new IllegalArgumentException(sbM.toString());
    }

    public static final boolean equals(char c, char c2, boolean z) {
        if (c == c2) {
            return true;
        }
        if (!z) {
            return false;
        }
        char upperCase = Character.toUpperCase(c);
        char upperCase2 = Character.toUpperCase(c2);
        return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
    }

    public static String stackTraceToString(Exception exc) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        exc.printStackTrace(printWriter);
        printWriter.flush();
        String string = stringWriter.toString();
        Intrinsics.checkNotNullExpressionValue(string, "sw.toString()");
        return string;
    }

    public static String toLowerCase(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            char cCharAt = str.charAt(i);
            if (cCharAt >= 'A' && cCharAt <= 'Z') {
                char[] charArray = str.toCharArray();
                while (i < length) {
                    char c = charArray[i];
                    if (c >= 'A' && c <= 'Z') {
                        charArray[i] = (char) (c ^ ' ');
                    }
                    i++;
                }
                return String.valueOf(charArray);
            }
            i++;
        }
        return str;
    }

    public static String toUpperCase(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            char cCharAt = str.charAt(i);
            if (cCharAt >= 'a' && cCharAt <= 'z') {
                char[] charArray = str.toCharArray();
                while (i < length) {
                    char c = charArray[i];
                    if (c >= 'a' && c <= 'z') {
                        charArray[i] = (char) (c ^ ' ');
                    }
                    i++;
                }
                return String.valueOf(charArray);
            }
            i++;
        }
        return str;
    }

    public static Object zzb(Context context, String str, zzq zzqVar) throws zzr {
        try {
            return zzqVar.zza(zzc(context).instantiate(str));
        } catch (Exception e) {
            throw new zzr(e);
        }
    }

    public static DynamiteModule zzc(Context context) throws zzr {
        try {
            return DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, ModuleDescriptor.MODULE_ID);
        } catch (Exception e) {
            throw new zzr(e);
        }
    }

    public abstract List clean(String str, List list);

    public abstract Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat$FontFamilyFilesResourceEntry fontResourcesParserCompat$FontFamilyFilesResourceEntry, Resources resources, int i);

    public abstract Typeface createFromFontInfo(Context context, FontsContractCompat$FontInfo[] fontsContractCompat$FontInfoArr, int i);

    public Typeface createFromInputStream(Context context, InputStream inputStream) {
        File tempFile = StringsKt__IndentKt.getTempFile(context);
        if (tempFile == null) {
            return null;
        }
        try {
            if (StringsKt__IndentKt.copyToFile(tempFile, inputStream)) {
                return Typeface.createFromFile(tempFile.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            tempFile.delete();
        }
    }

    public Typeface createFromResourcesFontFile(Context context, Resources resources, int i, String str, int i2) {
        File tempFile = StringsKt__IndentKt.getTempFile(context);
        if (tempFile == null) {
            return null;
        }
        try {
            if (StringsKt__IndentKt.copyToFile(tempFile, resources, i)) {
                return Typeface.createFromFile(tempFile.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            tempFile.delete();
        }
    }

    public void enqueue(OneTimeWorkRequest oneTimeWorkRequest) {
        List listSingletonList = Collections.singletonList(oneTimeWorkRequest);
        WorkManagerImpl workManagerImpl = (WorkManagerImpl) this;
        if (listSingletonList.isEmpty()) {
            throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
        }
        WorkContinuationImpl workContinuationImpl = new WorkContinuationImpl(workManagerImpl, listSingletonList);
        if (workContinuationImpl.mEnqueued) {
            Logger$LogcatLogger.get().warning(WorkContinuationImpl.TAG, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Already enqueued work ids (", TextUtils.join(", ", workContinuationImpl.mIds), ")"), new Throwable[0]);
        } else {
            workManagerImpl.mWorkTaskExecutor.executeOnBackgroundThread(new EnqueueRunnable(workContinuationImpl));
        }
    }

    public FontsContractCompat$FontInfo findBestInfo(FontsContractCompat$FontInfo[] fontsContractCompat$FontInfoArr, int i) {
        new InputMergerFactory$1(6);
        int i2 = (i & 1) == 0 ? 400 : 700;
        boolean z = (i & 2) != 0;
        FontsContractCompat$FontInfo fontsContractCompat$FontInfo = null;
        int i3 = Integer.MAX_VALUE;
        for (FontsContractCompat$FontInfo fontsContractCompat$FontInfo2 : fontsContractCompat$FontInfoArr) {
            int iAbs = (Math.abs(fontsContractCompat$FontInfo2.mWeight - i2) * 2) + (fontsContractCompat$FontInfo2.mItalic == z ? 0 : 1);
            if (fontsContractCompat$FontInfo == null || i3 > iAbs) {
                fontsContractCompat$FontInfo = fontsContractCompat$FontInfo2;
                i3 = iAbs;
            }
        }
        return fontsContractCompat$FontInfo;
    }

    public abstract void onFailed(Throwable th);

    public abstract void onLoaded(Dispatcher dispatcher);

    public static EventBinding getInstanceFromJson(JSONObject jSONObject) throws JSONException {
        int length;
        String eventName = jSONObject.getString("event_name");
        String string = jSONObject.getString(FirebaseAnalytics.Param.METHOD);
        Intrinsics.checkNotNullExpressionValue(string, "mapping.getString(\"method\")");
        Locale ENGLISH = Locale.ENGLISH;
        Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
        String upperCase = string.toUpperCase(ENGLISH);
        Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase(locale)");
        EventBinding.MappingMethod mappingMethodValueOf = EventBinding.MappingMethod.valueOf(upperCase);
        String string2 = jSONObject.getString("event_type");
        Intrinsics.checkNotNullExpressionValue(string2, "mapping.getString(\"event_type\")");
        String upperCase2 = string2.toUpperCase(ENGLISH);
        Intrinsics.checkNotNullExpressionValue(upperCase2, "(this as java.lang.String).toUpperCase(locale)");
        EventBinding.ActionType actionTypeValueOf = EventBinding.ActionType.valueOf(upperCase2);
        String appVersion = jSONObject.getString(FETmZwrVHuasmL.FsVLMLxJteA);
        JSONArray jSONArray = jSONObject.getJSONArray("path");
        ArrayList arrayList = new ArrayList();
        int length2 = jSONArray.length();
        int i = 0;
        if (length2 > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                JSONObject jsonPath = jSONArray.getJSONObject(i2);
                Intrinsics.checkNotNullExpressionValue(jsonPath, "jsonPath");
                arrayList.add(new PathComponent(jsonPath));
                if (i3 >= length2) {
                    break;
                }
                i2 = i3;
            }
        }
        String pathType = jSONObject.optString("path_type", "absolute");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("parameters");
        ArrayList arrayList2 = new ArrayList();
        if (jSONArrayOptJSONArray != null && (length = jSONArrayOptJSONArray.length()) > 0) {
            while (true) {
                int i4 = i + 1;
                JSONObject jsonParameter = jSONArrayOptJSONArray.getJSONObject(i);
                Intrinsics.checkNotNullExpressionValue(jsonParameter, "jsonParameter");
                arrayList2.add(new ParameterComponent(jsonParameter));
                if (i4 >= length) {
                    break;
                }
                i = i4;
            }
        }
        String componentId = jSONObject.optString("component_id");
        String activityName = jSONObject.optString("activity_name");
        Intrinsics.checkNotNullExpressionValue(eventName, "eventName");
        Intrinsics.checkNotNullExpressionValue(appVersion, "appVersion");
        Intrinsics.checkNotNullExpressionValue(componentId, "componentId");
        Intrinsics.checkNotNullExpressionValue(pathType, "pathType");
        Intrinsics.checkNotNullExpressionValue(activityName, "activityName");
        return new EventBinding(eventName, mappingMethodValueOf, actionTypeValueOf, appVersion, arrayList, arrayList2, componentId, pathType, activityName);
    }
}
