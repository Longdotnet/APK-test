package com.google.android.gms.ads;

import com.google.android.gms.ads.internal.client.zze;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class AdError {
    public final int zza;
    public final String zzb;
    public final String zzc;
    public final AdError zzd;

    public AdError(int i, String str, String str2, AdError adError) {
        this.zza = i;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = adError;
    }

    public String toString() {
        try {
            return zzb().toString(2);
        } catch (JSONException unused) {
            return "Error forming toString output.";
        }
    }

    public final zze zza() {
        AdError adError = this.zzd;
        return new zze(this.zza, this.zzb, this.zzc, adError == null ? null : new zze(adError.zza, adError.zzb, adError.zzc, null, null), null);
    }

    public JSONObject zzb() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("Code", this.zza);
        jSONObject.put("Message", this.zzb);
        jSONObject.put("Domain", this.zzc);
        AdError adError = this.zzd;
        if (adError == null) {
            jSONObject.put("Cause", "null");
        } else {
            jSONObject.put("Cause", adError.zzb());
        }
        return jSONObject;
    }
}
