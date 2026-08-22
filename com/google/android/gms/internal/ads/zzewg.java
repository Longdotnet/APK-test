package com.google.android.gms.internal.ads;

import android.os.Bundle;
import okio.AsyncTimeout;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzewg implements zzeub {
    private final Bundle zza;

    public zzewg(Bundle bundle) {
        this.zza = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* synthetic */ void zza(Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final void zzb(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        Bundle bundle = this.zza;
        if (bundle != null) {
            try {
                AsyncTimeout.Companion.zzg("play_store", AsyncTimeout.Companion.zzg("device", jSONObject)).put("parental_controls", com.google.android.gms.ads.internal.client.zzbb.zzb.zzc.zzn(bundle));
            } catch (JSONException unused) {
                com.google.android.gms.ads.internal.util.zze.zza("Failed putting parental controls bundle.");
            }
        }
    }
}
