package com.facebook.appevents.aam;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import com.facebook.GraphRequest$Companion$$ExternalSyntheticLambda1;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes.dex */
public final class MetadataViewObserver implements ViewTreeObserver.OnGlobalFocusChangeListener {
    public static final HashMap observers = new HashMap();
    public final WeakReference activityWeakReference;
    public final LinkedHashSet processedText = new LinkedHashSet();
    public final Handler uiThreadHandler = new Handler(Looper.getMainLooper());
    public final AtomicBoolean isTracking = new AtomicBoolean(false);

    public MetadataViewObserver(Activity activity) {
        this.activityWeakReference = new WeakReference(activity);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
    public final void onGlobalFocusChanged(View view, View view2) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        if (view != null) {
            try {
                process(view);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(this, th);
                return;
            }
        }
        if (view2 != null) {
            process(view2);
        }
    }

    public final void process(View view) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            GraphRequest$Companion$$ExternalSyntheticLambda1 graphRequest$Companion$$ExternalSyntheticLambda1 = new GraphRequest$Companion$$ExternalSyntheticLambda1(view, this, 12);
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                    graphRequest$Companion$$ExternalSyntheticLambda1.run();
                } else {
                    this.uiThreadHandler.post(graphRequest$Companion$$ExternalSyntheticLambda1);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(this, th);
            }
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(this, th2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:60:0x00f8 A[Catch: all -> 0x00f4, TryCatch #1 {all -> 0x00f4, blocks: (B:5:0x0007, B:7:0x0014, B:9:0x001e, B:13:0x0031, B:15:0x0037, B:18:0x0041, B:19:0x005e, B:21:0x0064, B:24:0x0078, B:26:0x0092, B:31:0x009d, B:33:0x00a3, B:36:0x00aa, B:43:0x00ca, B:46:0x00d0, B:54:0x00e5, B:56:0x00eb, B:60:0x00f8, B:61:0x00fc, B:68:0x010f, B:70:0x0115, B:67:0x010b, B:53:0x00e1, B:71:0x011e, B:73:0x0122, B:74:0x0129, B:75:0x012a, B:76:0x0131, B:50:0x00da, B:40:0x00b4, B:64:0x0104), top: B:81:0x0007, inners: #0, #2, #3 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x0102  */
    /* JADX WARN: Code duplicated, block: B:84:0x0104 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:0x00f6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:91:0x00eb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:92:0x0115 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:94:0x005e A[SYNTHETIC] */
    public final void processEditText(View view) {
        String strReplaceAll;
        ArrayList arrayList;
        ArrayList arrayList2;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            String string = ((EditText) view).getText().toString();
            if (string == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            String string2 = StringsKt__StringsKt.trim(string).toString();
            if (string2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = string2.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
            if (lowerCase.length() == 0) {
                return;
            }
            LinkedHashSet linkedHashSet = this.processedText;
            if (!linkedHashSet.contains(lowerCase) && lowerCase.length() <= 100) {
                linkedHashSet.add(lowerCase);
                HashMap map = new HashMap();
                ArrayList currentViewIndicators = MetadataMatcher.getCurrentViewIndicators(view);
                CopyOnWriteArraySet copyOnWriteArraySet = MetadataRule.rules;
                ArrayList aroundViewIndicators = null;
                for (MetadataRule metadataRule : new HashSet(MetadataRule.access$getRules$cp())) {
                    if ("r2".equals(metadataRule.getName())) {
                        Pattern patternCompile = Pattern.compile("[^\\d.]");
                        Intrinsics.checkNotNullExpressionValue(patternCompile, "compile(pattern)");
                        strReplaceAll = patternCompile.matcher(lowerCase).replaceAll("");
                        Intrinsics.checkNotNullExpressionValue(strReplaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
                    } else {
                        strReplaceAll = lowerCase;
                    }
                    boolean zIsObjectCrashing = CrashShieldHandler.isObjectCrashing(metadataRule);
                    String rule = metadataRule.valRule;
                    if ((zIsObjectCrashing ? null : rule).length() > 0) {
                        if (CrashShieldHandler.isObjectCrashing(metadataRule)) {
                            rule = null;
                        }
                        boolean zMatches = false;
                        if (!CrashShieldHandler.isObjectCrashing(MetadataMatcher.class)) {
                            try {
                                Intrinsics.checkNotNullParameter(rule, "rule");
                                Pattern patternCompile2 = Pattern.compile(rule);
                                Intrinsics.checkNotNullExpressionValue(patternCompile2, "compile(pattern)");
                                zMatches = patternCompile2.matcher(strReplaceAll).matches();
                            } catch (Throwable th) {
                                CrashShieldHandler.handleThrowable(MetadataMatcher.class, th);
                            }
                        }
                        if (!zMatches) {
                        }
                    }
                    boolean zIsObjectCrashing2 = CrashShieldHandler.isObjectCrashing(metadataRule);
                    List list = metadataRule.keyRules;
                    if (zIsObjectCrashing2) {
                        arrayList = null;
                        if (MetadataMatcher.matchIndicator(currentViewIndicators, arrayList)) {
                            MetadataIndexer.access$putUserData(map, metadataRule.getName(), strReplaceAll);
                        } else {
                            if (aroundViewIndicators == null) {
                                aroundViewIndicators = MetadataMatcher.getAroundViewIndicators(view);
                            }
                            if (CrashShieldHandler.isObjectCrashing(metadataRule)) {
                                arrayList2 = null;
                            } else {
                                try {
                                    arrayList2 = new ArrayList(list);
                                } catch (Throwable th2) {
                                    CrashShieldHandler.handleThrowable(metadataRule, th2);
                                    arrayList2 = null;
                                }
                            }
                            if (MetadataMatcher.matchIndicator(aroundViewIndicators, arrayList2)) {
                                MetadataIndexer.access$putUserData(map, metadataRule.getName(), strReplaceAll);
                            }
                        }
                    } else {
                        try {
                            arrayList = new ArrayList(list);
                        } catch (Throwable th3) {
                            CrashShieldHandler.handleThrowable(metadataRule, th3);
                            arrayList = null;
                        }
                        if (MetadataMatcher.matchIndicator(currentViewIndicators, arrayList)) {
                            MetadataIndexer.access$putUserData(map, metadataRule.getName(), strReplaceAll);
                        } else {
                            if (aroundViewIndicators == null) {
                                aroundViewIndicators = MetadataMatcher.getAroundViewIndicators(view);
                            }
                            if (CrashShieldHandler.isObjectCrashing(metadataRule)) {
                                arrayList2 = null;
                            } else {
                                arrayList2 = new ArrayList(list);
                            }
                            if (MetadataMatcher.matchIndicator(aroundViewIndicators, arrayList2)) {
                                MetadataIndexer.access$putUserData(map, metadataRule.getName(), strReplaceAll);
                            }
                        }
                    }
                }
                TextStreamsKt.setInternalUserData(map);
            }
        } catch (Throwable th4) {
            CrashShieldHandler.handleThrowable(this, th4);
        }
    }
}
