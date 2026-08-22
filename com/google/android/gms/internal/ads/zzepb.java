package com.google.android.gms.internal.ads;

import android.os.Bundle;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzepb implements zzeub {
    private final JSONObject zza;
    private final JSONObject zzb;

    public zzepb(JSONObject jSONObject, JSONObject jSONObject2) {
        this.zza = jSONObject;
        this.zzb = jSONObject2;
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        JSONObject jSONObject = this.zzb;
        zzcva zzcvaVar = (zzcva) obj;
        if (jSONObject != null) {
            zzcvaVar.zzb.putString("fwd_common_cld", jSONObject.toString());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Bundle bundle = ((zzcva) obj).zza;
        JSONObject jSONObject = this.zza;
        if (jSONObject != null) {
            bundle.putString("fwd_cld", jSONObject.toString());
        }
        JSONObject jSONObject2 = this.zzb;
        if (jSONObject2 != null) {
            bundle.putString("fwd_common_cld", jSONObject2.toString());
        }
    }
}
