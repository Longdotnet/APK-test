package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import okio.AsyncTimeout;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzevn implements zzeub {
    final String zza;
    final int zzb;

    public zzevn(String str, int i) {
        this.zza = str;
        this.zzb = i;
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* synthetic */ void zza(Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        int i;
        String str = this.zza;
        JSONObject jSONObject = (JSONObject) obj;
        if (TextUtils.isEmpty(str) || (i = this.zzb) == -1) {
            return;
        }
        try {
            JSONObject jSONObjectZzg = AsyncTimeout.Companion.zzg("pii", jSONObject);
            jSONObjectZzg.put("pvid", str);
            jSONObjectZzg.put("pvid_s", i);
        } catch (JSONException e) {
            com.google.android.gms.ads.internal.util.zze.zzb("Failed putting gms core app set ID info.", e);
        }
    }
}
