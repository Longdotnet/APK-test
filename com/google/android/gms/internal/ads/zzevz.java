package com.google.android.gms.internal.ads;

import okio.AsyncTimeout;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzevz implements zzeub {
    private final String zza;
    private final String zzb;

    public zzevz(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* synthetic */ void zza(Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        try {
            JSONObject jSONObjectZzg = AsyncTimeout.Companion.zzg("pii", (JSONObject) obj);
            jSONObjectZzg.put("doritos", this.zza);
            jSONObjectZzg.put("doritos_v2", this.zzb);
        } catch (JSONException unused) {
            com.google.android.gms.ads.internal.util.zze.zza("Failed putting doritos string.");
        }
    }
}
