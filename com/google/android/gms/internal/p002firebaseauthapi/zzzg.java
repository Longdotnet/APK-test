package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.signin.internal.FVfQ.GsPcpBmONXh;
import com.google.firebase.auth.ActionCodeUrl;
import com.google.firebase.auth.EmailAuthCredential;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzzg implements zzxm {
    private static final String zza = "zzzg";
    private static final Logger zzb = new Logger(GsPcpBmONXh.vndcNJiIoaPkidt, new String[0]);
    private final String zzc;
    private final String zzd;
    private final String zze;

    public zzzg(EmailAuthCredential emailAuthCredential, String str) {
        String strZzd = emailAuthCredential.zzd();
        zzah.checkNotEmpty(strZzd);
        this.zzc = strZzd;
        String strZzf = emailAuthCredential.zzf();
        zzah.checkNotEmpty(strZzf);
        this.zzd = strZzf;
        this.zze = str;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxm
    public final String zza() {
        ActionCodeUrl link = ActionCodeUrl.parseLink(this.zzd);
        String code = link != null ? link.getCode() : null;
        String strZza = link != null ? link.zza() : null;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("email", this.zzc);
        if (code != null) {
            jSONObject.put("oobCode", code);
        }
        if (strZza != null) {
            jSONObject.put(GsPcpBmONXh.TGCYrWMzM, strZza);
        }
        String str = this.zze;
        if (str != null) {
            jSONObject.put("idToken", str);
        }
        return jSONObject.toString();
    }
}
