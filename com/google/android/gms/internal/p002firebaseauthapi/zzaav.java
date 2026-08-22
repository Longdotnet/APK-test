package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.finsky.externalreferrer.jUdg.RDFWIi;
import com.google.android.gms.common.util.Strings;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzaav implements zzxn {
    private static final String zza = "zzaav";
    private String zzb;

    public final String zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxn
    public final /* bridge */ /* synthetic */ zzxn zza(String str) throws zzvg {
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject(RDFWIi.ohuAcfMWLsFmEa);
            if (jSONObjectOptJSONObject != null) {
                this.zzb = Strings.emptyToNull(jSONObjectOptJSONObject.optString("sessionInfo"));
            }
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzabk.zza(e, zza, str);
        }
    }
}
