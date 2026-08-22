package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzfcz {
    private final JSONObject zza;

    public zzfcz(JSONObject jSONObject) {
        this.zza = jSONObject;
    }

    public final String zza() {
        if (zzc() - 1 != 1) {
            return "javascript";
        }
        return null;
    }

    public final boolean zzb() {
        return this.zza.optBoolean((String) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzfE), true);
    }

    public final int zzc() {
        int iOptInt = this.zza.optInt("media_type", -1);
        if (iOptInt != 0) {
            return iOptInt != 1 ? 3 : 1;
        }
        return 2;
    }
}
