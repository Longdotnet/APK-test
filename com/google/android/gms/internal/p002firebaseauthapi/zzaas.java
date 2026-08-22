package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.internal.zzah;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzaas implements zzxm {
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private zzza zzg;

    private zzaas(String str, String str2, String str3, String str4, String str5, String str6) {
        zzah.checkNotEmpty(str);
        this.zza = str;
        zzah.checkNotEmpty("phone");
        this.zzb = "phone";
        this.zzc = str3;
        this.zzd = str4;
        this.zze = str5;
        this.zzf = str6;
    }

    public static zzaas zzb(String str, String str2, String str3, String str4, String str5) {
        zzah.checkNotEmpty(str2);
        return new zzaas(str, "phone", str2, str3, str4, str5);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxm
    public final String zza() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("idToken", this.zza);
        this.zzb.getClass();
        jSONObject.put("mfaProvider", 1);
        if (this.zzc != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("phoneNumber", this.zzc);
            if (!TextUtils.isEmpty(this.zze)) {
                jSONObject2.put("recaptchaToken", this.zze);
            }
            if (!TextUtils.isEmpty(this.zzf)) {
                jSONObject2.put("safetyNetToken", this.zzf);
            }
            zzza zzzaVar = this.zzg;
            if (zzzaVar != null) {
                jSONObject2.put("autoRetrievalInfo", zzzaVar.zza());
            }
            jSONObject.put("phoneEnrollmentInfo", jSONObject2);
        }
        return jSONObject.toString();
    }

    public final String zzc() {
        return this.zzd;
    }

    public final void zzd(zzza zzzaVar) {
        this.zzg = zzzaVar;
    }
}
