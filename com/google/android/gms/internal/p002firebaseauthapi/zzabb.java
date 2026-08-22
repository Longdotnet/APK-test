package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.zzah;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzabb implements zzxm {
    private final String zza;
    private final String zzb;

    public zzabb(String str, String str2) {
        zzah.checkNotEmpty(str);
        this.zza = str;
        this.zzb = str2;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxm
    public final String zza() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("token", this.zza);
        jSONObject.put("returnSecureToken", true);
        String str = this.zzb;
        if (str != null) {
            jSONObject.put("tenantId", str);
        }
        return jSONObject.toString();
    }
}
