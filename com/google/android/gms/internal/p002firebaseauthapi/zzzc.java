package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.zzah;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzzc implements zzxm {
    private final String zza;
    private final String zzb;
    private final String zzc;

    public zzzc(String str, String str2) {
        zzah.checkNotEmpty(str);
        this.zza = str;
        this.zzb = "http://localhost";
        this.zzc = str2;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxm
    public final String zza() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("identifier", this.zza);
        jSONObject.put("continueUri", this.zzb);
        String str = this.zzc;
        if (str != null) {
            jSONObject.put("tenantId", str);
        }
        return jSONObject.toString();
    }
}
