package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import okio.AsyncTimeout;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzfcf {
    public final String zza;
    public final String zzb;
    public final JSONObject zzc;
    public final JSONObject zzd;

    public zzfcf(JsonReader jsonReader) {
        JSONObject jSONObjectZzi = AsyncTimeout.Companion.zzi(jsonReader);
        this.zzd = jSONObjectZzi;
        this.zza = jSONObjectZzi.optString("ad_html", null);
        this.zzb = jSONObjectZzi.optString("ad_base_url", null);
        this.zzc = jSONObjectZzi.optJSONObject("ad_json");
    }
}
