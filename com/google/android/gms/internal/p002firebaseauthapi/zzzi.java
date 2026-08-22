package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.games.snapshot.Xa.JrbhsraGtto;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzzi implements zzxm {
    private final String zza;
    private String zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;

    public zzzi(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        zzah.checkNotEmpty("phone");
        this.zza = "phone";
        zzah.checkNotEmpty(str2);
        this.zzb = str2;
        this.zzc = str3;
        this.zze = str4;
        this.zzd = str7;
    }

    public static zzzi zzb(String str, String str2, String str3, String str4) {
        zzah.checkNotEmpty(str3);
        zzah.checkNotEmpty(str2);
        return new zzzi("phone", str, str2, str3, null, null, str4);
    }

    public final zzzi zzc(String str) {
        this.zzb = str;
        return this;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxm
    public final String zza() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("idToken", this.zzb);
        this.zza.getClass();
        jSONObject.put("mfaProvider", 1);
        String str = this.zzd;
        if (str != null) {
            jSONObject.put("displayName", str);
        }
        JSONObject jSONObject2 = new JSONObject();
        String str2 = this.zzc;
        if (str2 != null) {
            jSONObject2.put("sessionInfo", str2);
        }
        String str3 = this.zze;
        if (str3 != null) {
            jSONObject2.put("code", str3);
        }
        jSONObject.put(JrbhsraGtto.wFJlErpcHHAMu, jSONObject2);
        return jSONObject.toString();
    }
}
