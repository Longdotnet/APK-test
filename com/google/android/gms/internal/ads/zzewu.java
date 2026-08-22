package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import okio.AsyncTimeout;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzewu implements zzeub {
    private final String zza;

    public zzewu(String str) {
        this.zza = str;
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* synthetic */ void zza(Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        try {
            String str = this.zza;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            AsyncTimeout.Companion.zzg("pii", jSONObject).put("adsid", str);
        } catch (JSONException e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Failed putting trustless token.", e);
        }
    }
}
