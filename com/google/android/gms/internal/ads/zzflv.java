package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.webkit.WebView;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline0;
import androidx.webkit.JavaScriptReplyProxy;
import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebViewCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class zzflv implements WebViewCompat.WebMessageListener {
    final /* synthetic */ zzflw zza;

    public zzflv(zzflw zzflwVar) {
        Objects.requireNonNull(zzflwVar);
        this.zza = zzflwVar;
    }

    @Override // androidx.webkit.WebViewCompat.WebMessageListener
    public final void onPostMessage(WebView webView, WebMessageCompat webMessageCompat, Uri uri, boolean z, JavaScriptReplyProxy javaScriptReplyProxy) {
        String str;
        int i = webMessageCompat.mType;
        if (i != 0) {
            StringBuilder sb = new StringBuilder("Wrong data accessor type detected. ");
            if (i != 0) {
                str = i != 1 ? "Unknown" : "ArrayBuffer";
            } else {
                str = "String";
            }
            throw new IllegalStateException(Fragment$$ExternalSyntheticOutline0.m(sb, str, " expected, but got ", "String"));
        }
        try {
            JSONObject jSONObject = new JSONObject(webMessageCompat.mString);
            String string = jSONObject.getString(FirebaseAnalytics.Param.METHOD);
            String string2 = jSONObject.getJSONObject("data").getString("adSessionId");
            if (string.equals("startSession")) {
                zzflw.zze(this.zza, string2);
            } else if (string.equals("finishSession")) {
                zzflw.zzc(this.zza, string2);
            } else {
                zzfli.zza.getClass();
            }
        } catch (JSONException e) {
            zzfnf.zza("Error parsing JS message in JavaScriptSessionService.", e);
        }
    }
}
