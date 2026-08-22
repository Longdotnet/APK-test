package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.zzah;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzabe implements zzxm {
    private final String zza;
    private final String zzb;
    private final String zzc;

    public zzabe(String str, String str2, String str3) {
        zzah.checkNotEmpty(str);
        this.zza = str;
        zzah.checkNotEmpty(str2);
        this.zzb = str2;
        this.zzc = str3;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxm
    public final String zza() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("email", this.zza);
        jSONObject.put("password", this.zzb);
        jSONObject.put("returnSecureToken", true);
        String str = this.zzc;
        if (str != null) {
            jSONObject.put("tenantId", str);
        }
        return jSONObject.toString();
    }
}
