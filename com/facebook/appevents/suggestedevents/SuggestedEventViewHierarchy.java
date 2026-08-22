package com.facebook.appevents.suggestedevents;

import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TimePicker;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class SuggestedEventViewHierarchy {
    public static final SuggestedEventViewHierarchy INSTANCE = new SuggestedEventViewHierarchy();
    public static final List blacklistedViews = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{Switch.class, Spinner.class, DatePicker.class, TimePicker.class, RadioGroup.class, RatingBar.class, EditText.class, AdapterView.class});

    public static final ArrayList getAllClickableViews(View view) {
        if (CrashShieldHandler.isObjectCrashing(SuggestedEventViewHierarchy.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(view, "view");
            ArrayList arrayList = new ArrayList();
            Iterator it = blacklistedViews.iterator();
            while (it.hasNext()) {
                if (((Class) it.next()).isInstance(view)) {
                    return arrayList;
                }
            }
            if (view.isClickable()) {
                arrayList.add(view);
            }
            Iterator it2 = ViewHierarchy.getChildrenOfView(view).iterator();
            while (it2.hasNext()) {
                arrayList.addAll(getAllClickableViews((View) it2.next()));
            }
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(SuggestedEventViewHierarchy.class, th);
            return null;
        }
    }

    public static final JSONObject getDictionaryOfView(View view, View view2) {
        if (CrashShieldHandler.isObjectCrashing(SuggestedEventViewHierarchy.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(view, "view");
            JSONObject jSONObject = new JSONObject();
            if (view == view2) {
                try {
                    jSONObject.put("is_interacted", true);
                } catch (JSONException unused) {
                }
            }
            updateBasicInfo(view, jSONObject);
            JSONArray jSONArray = new JSONArray();
            Iterator it = ViewHierarchy.getChildrenOfView(view).iterator();
            while (it.hasNext()) {
                jSONArray.put(getDictionaryOfView((View) it.next(), view2));
            }
            jSONObject.put("childviews", jSONArray);
            return jSONObject;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(SuggestedEventViewHierarchy.class, th);
            return null;
        }
    }

    public static final String getTextOfViewRecursively(View hostView) {
        if (CrashShieldHandler.isObjectCrashing(SuggestedEventViewHierarchy.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(hostView, "hostView");
            String textOfView = ViewHierarchy.getTextOfView(hostView);
            if (textOfView.length() > 0) {
                return textOfView;
            }
            String strJoin = TextUtils.join(" ", INSTANCE.getTextOfChildren(hostView));
            Intrinsics.checkNotNullExpressionValue(strJoin, "join(\" \", childrenText)");
            return strJoin;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(SuggestedEventViewHierarchy.class, th);
            return null;
        }
    }

    public static final void updateBasicInfo(View view, JSONObject jSONObject) {
        if (CrashShieldHandler.isObjectCrashing(SuggestedEventViewHierarchy.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(view, "view");
            try {
                String textOfView = ViewHierarchy.getTextOfView(view);
                String hintOfView = ViewHierarchy.getHintOfView(view);
                jSONObject.put("classname", view.getClass().getSimpleName());
                jSONObject.put("classtypebitmask", ViewHierarchy.getClassTypeBitmask(view));
                if (textOfView.length() > 0) {
                    jSONObject.put("text", textOfView);
                }
                if (hintOfView.length() > 0) {
                    jSONObject.put("hint", hintOfView);
                }
                if (view instanceof EditText) {
                    jSONObject.put("inputtype", ((EditText) view).getInputType());
                }
            } catch (JSONException unused) {
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(SuggestedEventViewHierarchy.class, th);
        }
    }

    public final ArrayList getTextOfChildren(View view) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            for (View view2 : ViewHierarchy.getChildrenOfView(view)) {
                String textOfView = ViewHierarchy.getTextOfView(view2);
                if (textOfView.length() > 0) {
                    arrayList.add(textOfView);
                }
                arrayList.addAll(getTextOfChildren(view2));
            }
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
            return null;
        }
    }
}
