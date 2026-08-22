package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.stats.ZnFR.FKidOcdAYt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzabg implements zzxm {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private boolean zzf;

    private zzabg() {
    }

    public static zzabg zzb(String str, String str2, boolean z) {
        zzabg zzabgVar = new zzabg();
        zzah.checkNotEmpty(str);
        zzabgVar.zzb = str;
        zzah.checkNotEmpty(str2);
        zzabgVar.zzc = str2;
        zzabgVar.zzf = z;
        return zzabgVar;
    }

    public static zzabg zzc(String str, String str2, boolean z) {
        zzabg zzabgVar = new zzabg();
        zzah.checkNotEmpty(str);
        zzabgVar.zza = str;
        zzah.checkNotEmpty(str2);
        zzabgVar.zzd = str2;
        zzabgVar.zzf = z;
        return zzabgVar;
    }

    public final void zzd(String str) {
        this.zze = str;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxm
    public final String zza() {
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(this.zzd)) {
            jSONObject.put("sessionInfo", this.zzb);
            jSONObject.put("code", this.zzc);
        } else {
            jSONObject.put("phoneNumber", this.zza);
            jSONObject.put(FKidOcdAYt.OgSkGUiW, this.zzd);
        }
        String str = this.zze;
        if (str != null) {
            jSONObject.put("idToken", str);
        }
        if (!this.zzf) {
            jSONObject.put("operation", 2);
        }
        return jSONObject.toString();
    }
}
