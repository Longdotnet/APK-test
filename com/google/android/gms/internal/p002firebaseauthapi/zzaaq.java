package com.google.android.gms.internal.p002firebaseauthapi;

import com.facebook.login.vu.dLDI;
import com.google.android.gms.common.internal.zzah;
import kotlin.coroutines.jvm.internal.DEXi.JuorMn;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzaaq implements zzxm {
    private String zza;
    private String zzb;
    private final String zzc;

    public zzaaq(String str) {
        this.zzc = str;
    }

    public zzaaq(String str, String str2, String str3, String str4) {
        zzah.checkNotEmpty(str);
        this.zza = str;
        zzah.checkNotEmpty(str2);
        this.zzb = str2;
        this.zzc = str4;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxm
    public final String zza() {
        JSONObject jSONObject = new JSONObject();
        String str = this.zza;
        if (str != null) {
            jSONObject.put(JuorMn.qoUZxieheWmbPmg, str);
        }
        String str2 = this.zzb;
        if (str2 != null) {
            jSONObject.put(dLDI.avfGCFZhxMSZ, str2);
        }
        String str3 = this.zzc;
        if (str3 != null) {
            jSONObject.put("tenantId", str3);
        }
        return jSONObject.toString();
    }
}
