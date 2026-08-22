package com.facebook.appevents.codeless.internal;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class ParameterComponent {
    public final String name;
    public final ArrayList path;
    public final String pathType;
    public final String value;

    public ParameterComponent(JSONObject jSONObject) throws JSONException {
        int length;
        String string = jSONObject.getString("name");
        Intrinsics.checkNotNullExpressionValue(string, "component.getString(PARAMETER_NAME_KEY)");
        this.name = string;
        String strOptString = jSONObject.optString(FirebaseAnalytics.Param.VALUE);
        Intrinsics.checkNotNullExpressionValue(strOptString, "component.optString(PARAMETER_VALUE_KEY)");
        this.value = strOptString;
        String strOptString2 = jSONObject.optString("path_type", "absolute");
        Intrinsics.checkNotNullExpressionValue(strOptString2, "component.optString(Constants.EVENT_MAPPING_PATH_TYPE_KEY, Constants.PATH_TYPE_ABSOLUTE)");
        this.pathType = strOptString2;
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("path");
        if (jSONArrayOptJSONArray != null && (length = jSONArrayOptJSONArray.length()) > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i);
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonPathArray.getJSONObject(i)");
                arrayList.add(new PathComponent(jSONObject2));
                if (i2 >= length) {
                    break;
                } else {
                    i = i2;
                }
            }
        }
        this.path = arrayList;
    }
}
