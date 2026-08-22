package com.facebook.appevents.aam;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import okio.Okio;

/* JADX INFO: loaded from: classes.dex */
public final class MetadataMatcher {
    public static final MetadataMatcher INSTANCE = new MetadataMatcher();

    public static final ArrayList getAroundViewIndicators(View view) {
        if (CrashShieldHandler.isObjectCrashing(MetadataMatcher.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(view, "view");
            ArrayList arrayList = new ArrayList();
            ViewGroup parentOfView = ViewHierarchy.getParentOfView(view);
            if (parentOfView != null) {
                for (View view2 : ViewHierarchy.getChildrenOfView(parentOfView)) {
                    if (view != view2) {
                        arrayList.addAll(INSTANCE.getTextIndicators(view2));
                    }
                }
            }
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(MetadataMatcher.class, th);
            return null;
        }
    }

    public static final ArrayList getCurrentViewIndicators(View view) {
        List listListOf;
        if (CrashShieldHandler.isObjectCrashing(MetadataMatcher.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(view, "view");
            ArrayList<String> arrayList = new ArrayList();
            arrayList.add(ViewHierarchy.getHintOfView(view));
            Object tag = view.getTag();
            if (tag != null) {
                arrayList.add(tag.toString());
            }
            CharSequence contentDescription = view.getContentDescription();
            if (contentDescription != null) {
                arrayList.add(contentDescription.toString());
            }
            try {
                if (view.getId() != -1) {
                    String resourceName = view.getResources().getResourceName(view.getId());
                    Intrinsics.checkNotNullExpressionValue(resourceName, "resourceName");
                    Pattern patternCompile = Pattern.compile("/");
                    Intrinsics.checkNotNullExpressionValue(patternCompile, "compile(pattern)");
                    StringsKt__StringsKt.requireNonNegativeLimit(0);
                    Matcher matcher = patternCompile.matcher(resourceName);
                    if (matcher.find()) {
                        ArrayList arrayList2 = new ArrayList(10);
                        int iEnd = 0;
                        do {
                            arrayList2.add(resourceName.subSequence(iEnd, matcher.start()).toString());
                            iEnd = matcher.end();
                        } while (matcher.find());
                        arrayList2.add(resourceName.subSequence(iEnd, resourceName.length()).toString());
                        listListOf = arrayList2;
                    } else {
                        listListOf = Okio.listOf(resourceName.toString());
                    }
                    Object[] array = listListOf.toArray(new String[0]);
                    if (array == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                    String[] strArr = (String[]) array;
                    if (strArr.length == 2) {
                        arrayList.add(strArr[1]);
                    }
                }
            } catch (Resources.NotFoundException unused) {
            }
            ArrayList arrayList3 = new ArrayList();
            for (String str : arrayList) {
                if (str.length() > 0 && str.length() <= 100) {
                    String lowerCase = str.toLowerCase();
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                    arrayList3.add(lowerCase);
                }
            }
            return arrayList3;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(MetadataMatcher.class, th);
            return null;
        }
    }

    public static final boolean matchIndicator(ArrayList indicators, ArrayList keys) {
        if (CrashShieldHandler.isObjectCrashing(MetadataMatcher.class)) {
            return false;
        }
        try {
            Intrinsics.checkNotNullParameter(indicators, "indicators");
            Intrinsics.checkNotNullParameter(keys, "keys");
            Iterator it = indicators.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                MetadataMatcher metadataMatcher = INSTANCE;
                if (!CrashShieldHandler.isObjectCrashing(metadataMatcher)) {
                    try {
                        Iterator it2 = keys.iterator();
                        while (it2.hasNext()) {
                            if (StringsKt__StringsKt.contains$default(str, (String) it2.next())) {
                                return true;
                            }
                        }
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(metadataMatcher, th);
                    }
                }
            }
            return false;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(MetadataMatcher.class, th2);
            return false;
        }
    }

    public final ArrayList getTextIndicators(View view) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            if (view instanceof EditText) {
                return arrayList;
            }
            if (!(view instanceof TextView)) {
                Iterator it = ViewHierarchy.getChildrenOfView(view).iterator();
                while (it.hasNext()) {
                    arrayList.addAll(getTextIndicators((View) it.next()));
                }
                return arrayList;
            }
            String string = ((TextView) view).getText().toString();
            if (string.length() > 0 && string.length() < 100) {
                String lowerCase = string.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                arrayList.add(lowerCase);
            }
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
            return null;
        }
    }
}
