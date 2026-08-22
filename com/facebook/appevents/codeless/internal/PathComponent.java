package com.facebook.appevents.codeless.internal;

import com.facebook.login.vu.dLDI;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class PathComponent {
    public final String className;
    public final String description;
    public final String hint;
    public final int id;
    public final int index;
    public final int matchBitmask;
    public final String tag;
    public final String text;

    public PathComponent(JSONObject jSONObject) {
        String string = jSONObject.getString("class_name");
        Intrinsics.checkNotNullExpressionValue(string, "component.getString(PATH_CLASS_NAME_KEY)");
        this.className = string;
        this.index = jSONObject.optInt(FirebaseAnalytics.Param.INDEX, -1);
        this.id = jSONObject.optInt("id");
        String strOptString = jSONObject.optString("text");
        Intrinsics.checkNotNullExpressionValue(strOptString, "component.optString(PATH_TEXT_KEY)");
        this.text = strOptString;
        String strOptString2 = jSONObject.optString("tag");
        Intrinsics.checkNotNullExpressionValue(strOptString2, "component.optString(PATH_TAG_KEY)");
        this.tag = strOptString2;
        String strOptString3 = jSONObject.optString("description");
        Intrinsics.checkNotNullExpressionValue(strOptString3, "component.optString(PATH_DESCRIPTION_KEY)");
        this.description = strOptString3;
        String strOptString4 = jSONObject.optString("hint");
        Intrinsics.checkNotNullExpressionValue(strOptString4, "component.optString(PATH_HINT_KEY)");
        this.hint = strOptString4;
        this.matchBitmask = jSONObject.optInt(dLDI.SbcUd);
    }
}
