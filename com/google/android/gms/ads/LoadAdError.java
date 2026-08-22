package com.google.android.gms.ads;

import com.google.android.finsky.externalreferrer.jUdg.RDFWIi;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class LoadAdError extends AdError {
    public final ResponseInfo zza;

    public LoadAdError(int i, String str, String str2, AdError adError, ResponseInfo responseInfo) {
        super(i, str, str2, adError);
        this.zza = responseInfo;
    }

    @Override // com.google.android.gms.ads.AdError
    public final JSONObject zzb() {
        JSONObject jSONObjectZzb = super.zzb();
        ResponseInfo responseInfo = this.zza;
        if (responseInfo == null) {
            jSONObjectZzb.put("Response Info", "null");
        } else {
            jSONObjectZzb.put("Response Info", responseInfo.zzd());
        }
        return jSONObjectZzb;
    }

    @Override // com.google.android.gms.ads.AdError
    public final String toString() {
        try {
            return zzb().toString(2);
        } catch (JSONException unused) {
            return RDFWIi.maF;
        }
    }
}
