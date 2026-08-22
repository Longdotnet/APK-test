package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.internal.zzah;
import com.google.firebase.inject.PVS.jIKWv;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzaau implements zzxm {
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final String zzg;
    private zzza zzh;

    public static zzaau zzb(String str, String str2, String str3, String str4, String str5, String str6) {
        zzah.checkNotEmpty(str3);
        return new zzaau("phone", str, str2, str3, str4, str5, str6);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxm
    public final String zza() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("mfaPendingCredential", this.zzb);
        jSONObject.put("mfaEnrollmentId", this.zzc);
        this.zza.getClass();
        jSONObject.put("mfaProvider", 1);
        if (this.zze != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("phoneNumber", this.zze);
            if (!TextUtils.isEmpty(this.zzf)) {
                jSONObject2.put("recaptchaToken", this.zzf);
            }
            if (!TextUtils.isEmpty(this.zzg)) {
                jSONObject2.put("safetyNetToken", this.zzg);
            }
            zzza zzzaVar = this.zzh;
            if (zzzaVar != null) {
                jSONObject2.put("autoRetrievalInfo", zzzaVar.zza());
            }
            jSONObject.put("phoneSignInInfo", jSONObject2);
        }
        return jSONObject.toString();
    }

    public final String zzc() {
        return this.zzd;
    }

    public final void zzd(zzza zzzaVar) {
        this.zzh = zzzaVar;
    }

    private zzaau(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        String str8 = jIKWv.YoyJKKYMoQ;
        zzah.checkNotEmpty(str8);
        this.zza = str8;
        zzah.checkNotEmpty(str2);
        this.zzb = str2;
        zzah.checkNotEmpty(str3);
        this.zzc = str3;
        this.zze = str4;
        this.zzd = str5;
        this.zzf = str6;
        this.zzg = str7;
    }
}
