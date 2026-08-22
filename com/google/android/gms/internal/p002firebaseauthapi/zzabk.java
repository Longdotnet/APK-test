package com.google.android.gms.internal.p002firebaseauthapi;

import android.util.Log;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public final class zzabk {
    public static zzvg zza(Exception exc, String str, String str2) {
        String message = exc.getMessage();
        StringBuilder sbM22m = CoroutineAdapterKt$$ExternalSyntheticLambda0.m22m("Failed to parse ", str, " for string [", str2, "] with exception: ");
        sbM22m.append(message);
        Log.e(str, sbM22m.toString());
        return new zzvg(CoroutineAdapterKt$$ExternalSyntheticLambda0.m("Failed to parse ", str, " for string [", str2, "]"), exc);
    }

    public static List zzb(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null && jSONArray.length() != 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.getString(i));
            }
        }
        return arrayList;
    }
}
