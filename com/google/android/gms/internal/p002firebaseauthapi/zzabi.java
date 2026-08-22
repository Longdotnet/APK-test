package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.zzah;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzabi implements zzxm {
    private final String zza;
    private final String zzb;

    public zzabi(String str, String str2) {
        zzah.checkNotEmpty(str);
        this.zza = str;
        zzah.checkNotEmpty(str2);
        this.zzb = str2;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxm
    public final String zza() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("idToken", this.zza);
        jSONObject.put("mfaEnrollmentId", this.zzb);
        return jSONObject.toString();
    }
}
