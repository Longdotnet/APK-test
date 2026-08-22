package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.appset.vSSa.iafHZUfOuHNwvy;
import com.google.android.gms.common.internal.zzah;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzzn implements zzxm {
    private final String zza = zzzm.REFRESH_TOKEN.toString();
    private final String zzb;

    public zzzn(String str) {
        zzah.checkNotEmpty(str);
        this.zzb = str;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxm
    public final String zza() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("grantType", this.zza);
        jSONObject.put(iafHZUfOuHNwvy.oRxsiXLfzeRjo, this.zzb);
        return jSONObject.toString();
    }
}
