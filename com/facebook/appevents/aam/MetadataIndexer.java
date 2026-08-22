package com.facebook.appevents.aam;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.google.android.gms.ads.internal.offline.buffering.Dk.eoBKjVuj;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import okio.Okio;

/* JADX INFO: loaded from: classes2.dex */
public final class MetadataIndexer {
    public static final MetadataIndexer INSTANCE = new MetadataIndexer();
    public static boolean enabled;

    public static void startTrackingActivity(Activity activity) {
        View rootView;
        Intrinsics.checkNotNullParameter(activity, "activity");
        int iHashCode = activity.hashCode();
        HashMap map = null;
        if (!CrashShieldHandler.isObjectCrashing(MetadataViewObserver.class)) {
            try {
                map = MetadataViewObserver.observers;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(MetadataViewObserver.class, th);
            }
        }
        Integer numValueOf = Integer.valueOf(iHashCode);
        Object metadataViewObserver = map.get(numValueOf);
        if (metadataViewObserver == null) {
            metadataViewObserver = new MetadataViewObserver(activity);
            map.put(numValueOf, metadataViewObserver);
        }
        MetadataViewObserver metadataViewObserver2 = (MetadataViewObserver) metadataViewObserver;
        if (CrashShieldHandler.isObjectCrashing(MetadataViewObserver.class)) {
            return;
        }
        try {
            if (CrashShieldHandler.isObjectCrashing(metadataViewObserver2)) {
                return;
            }
            try {
                if (!metadataViewObserver2.isTracking.getAndSet(true) && (rootView = AppEventUtility.getRootView((Activity) metadataViewObserver2.activityWeakReference.get())) != null) {
                    ViewTreeObserver viewTreeObserver = rootView.getViewTreeObserver();
                    if (viewTreeObserver.isAlive()) {
                        viewTreeObserver.addOnGlobalFocusChangeListener(metadataViewObserver2);
                        return;
                    }
                    return;
                    CrashShieldHandler.handleThrowable(MetadataViewObserver.class, th);
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(metadataViewObserver2, th2);
            }
        } catch (Throwable th3) {
            CrashShieldHandler.handleThrowable(MetadataViewObserver.class, th3);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:28:0x0095  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final void access$putUserData(HashMap map, String str, String str2) {
        List listListOf;
        HashMap map2 = MetadataViewObserver.observers;
        switch (str.hashCode()) {
            case 3585:
                if (str.equals("r3")) {
                    str2 = (StringsKt__StringsKt.startsWith(str2, "m", false) || StringsKt__StringsKt.startsWith(str2, eoBKjVuj.RvbNz, false) || StringsKt__StringsKt.startsWith(str2, "ge", false)) ? "m" : "f";
                }
                map.put(str, str2);
                return;
            case 3586:
                if (str.equals("r4")) {
                    Pattern patternCompile = Pattern.compile("[^a-z]+");
                    Intrinsics.checkNotNullExpressionValue(patternCompile, "compile(pattern)");
                    str2 = patternCompile.matcher(str2).replaceAll("");
                    Intrinsics.checkNotNullExpressionValue(str2, "nativePattern.matcher(in…).replaceAll(replacement)");
                }
                map.put(str, str2);
                return;
            case 3587:
                if (str.equals("r5")) {
                    Pattern patternCompile2 = Pattern.compile("[^a-z]+");
                    Intrinsics.checkNotNullExpressionValue(patternCompile2, "compile(pattern)");
                    str2 = patternCompile2.matcher(str2).replaceAll("");
                    Intrinsics.checkNotNullExpressionValue(str2, "nativePattern.matcher(in…).replaceAll(replacement)");
                }
                map.put(str, str2);
                return;
            case 3588:
                if (str.equals("r6") && StringsKt__StringsKt.contains$default(str2, "-")) {
                    Pattern patternCompile3 = Pattern.compile("-");
                    Intrinsics.checkNotNullExpressionValue(patternCompile3, "compile(pattern)");
                    StringsKt__StringsKt.requireNonNegativeLimit(0);
                    Matcher matcher = patternCompile3.matcher(str2);
                    if (matcher.find()) {
                        ArrayList arrayList = new ArrayList(10);
                        int iEnd = 0;
                        do {
                            arrayList.add(str2.subSequence(iEnd, matcher.start()).toString());
                            iEnd = matcher.end();
                        } while (matcher.find());
                        arrayList.add(str2.subSequence(iEnd, str2.length()).toString());
                        listListOf = arrayList;
                    } else {
                        listListOf = Okio.listOf(str2.toString());
                    }
                    Object[] array = listListOf.toArray(new String[0]);
                    if (array == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                    str2 = ((String[]) array)[0];
                }
                map.put(str, str2);
                return;
            default:
                map.put(str, str2);
                return;
        }
    }
}
