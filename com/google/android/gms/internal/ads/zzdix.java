package com.google.android.gms.internal.ads;

import okio.AsyncTimeout;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzdix extends zzdiy {
    private final JSONObject zzb;
    private final boolean zzc;
    private final boolean zzd;
    private final boolean zze;
    private final boolean zzf;
    private final String zzg;
    private final JSONObject zzh;

    public zzdix(zzfca zzfcaVar, JSONObject jSONObject) {
        super(zzfcaVar);
        String[] strArr = {"tracking_urls_and_actions", "active_view"};
        JSONObject jSONObjectZzn = AsyncTimeout.Companion.zzn(jSONObject, strArr);
        this.zzb = jSONObjectZzn == null ? null : jSONObjectZzn.optJSONObject(strArr[1]);
        String[] strArr2 = {"allow_pub_owned_ad_view"};
        JSONObject jSONObjectZzn2 = AsyncTimeout.Companion.zzn(jSONObject, strArr2);
        this.zzc = jSONObjectZzn2 == null ? false : jSONObjectZzn2.optBoolean(strArr2[0], false);
        String[] strArr3 = {"attribution", "allow_pub_rendering"};
        JSONObject jSONObjectZzn3 = AsyncTimeout.Companion.zzn(jSONObject, strArr3);
        this.zzd = jSONObjectZzn3 == null ? false : jSONObjectZzn3.optBoolean(strArr3[1], false);
        String[] strArr4 = {"enable_omid"};
        JSONObject jSONObjectZzn4 = AsyncTimeout.Companion.zzn(jSONObject, strArr4);
        this.zze = jSONObjectZzn4 == null ? false : jSONObjectZzn4.optBoolean(strArr4[0], false);
        String[] strArr5 = {"watermark_overlay_png_base64"};
        JSONObject jSONObjectZzn5 = AsyncTimeout.Companion.zzn(jSONObject, strArr5);
        this.zzg = jSONObjectZzn5 != null ? jSONObjectZzn5.optString(strArr5[0], "") : "";
        this.zzf = jSONObject.optJSONObject("overlay") != null;
        this.zzh = jSONObject.optJSONObject("omid_settings");
    }

    @Override // com.google.android.gms.internal.ads.zzdiy
    public final zzfcz zza() {
        JSONObject jSONObject = this.zzh;
        return jSONObject != null ? new zzfcz(jSONObject) : this.zza.zzV;
    }

    @Override // com.google.android.gms.internal.ads.zzdiy
    public final String zzb() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzdiy
    public final JSONObject zzc() {
        JSONObject jSONObject = this.zzb;
        if (jSONObject != null) {
            return jSONObject;
        }
        try {
            return new JSONObject(this.zza.zzz);
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdiy
    public final boolean zzd() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzdiy
    public final boolean zze() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzdiy
    public final boolean zzf() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzdiy
    public final boolean zzg() {
        return this.zzf;
    }
}
