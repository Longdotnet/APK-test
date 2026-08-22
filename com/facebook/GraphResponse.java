package com.facebook;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class GraphResponse {
    public final HttpURLConnection connection;
    public final FacebookRequestError error;
    public final JSONObject graphObject;
    public final JSONObject jsonObject;

    public GraphResponse(GraphRequest request, HttpURLConnection httpURLConnection, JSONObject jSONObject, JSONArray jSONArray, FacebookRequestError facebookRequestError) {
        Intrinsics.checkNotNullParameter(request, "request");
        this.connection = httpURLConnection;
        this.graphObject = jSONObject;
        this.error = facebookRequestError;
        this.jsonObject = jSONObject;
    }

    public final String toString() {
        String str;
        try {
            Locale locale = Locale.US;
            HttpURLConnection httpURLConnection = this.connection;
            str = String.format(locale, "%d", Arrays.copyOf(new Object[]{Integer.valueOf(httpURLConnection == null ? 200 : httpURLConnection.getResponseCode())}, 1));
        } catch (IOException unused) {
            str = "unknown";
        }
        StringBuilder sbM21m = CoroutineAdapterKt$$ExternalSyntheticLambda0.m21m("{Response:  responseCode: ", str, ", graphObject: ");
        sbM21m.append(this.graphObject);
        sbM21m.append(", error: ");
        sbM21m.append(this.error);
        sbM21m.append("}");
        String string = sbM21m.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder()\n        .append(\"{Response: \")\n        .append(\" responseCode: \")\n        .append(responseCode)\n        .append(\", graphObject: \")\n        .append(graphObject)\n        .append(\", error: \")\n        .append(error)\n        .append(\"}\")\n        .toString()");
        return string;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GraphResponse(GraphRequest request, HttpURLConnection httpURLConnection, String rawResponse, JSONObject jSONObject) {
        this(request, httpURLConnection, jSONObject, null, null);
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(rawResponse, "rawResponse");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GraphResponse(GraphRequest request, HttpURLConnection httpURLConnection, FacebookRequestError facebookRequestError) {
        this(request, httpURLConnection, null, null, facebookRequestError);
        Intrinsics.checkNotNullParameter(request, "request");
    }
}
