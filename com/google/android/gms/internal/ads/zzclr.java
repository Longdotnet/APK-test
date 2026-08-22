package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzclr implements zzclh {
    private final zzdvi zza;

    public zzclr(zzdvi zzdviVar) {
        this.zza = zzdviVar;
    }

    @Override // com.google.android.gms.internal.ads.zzclh
    public final void zza(JSONObject jSONObject) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzjF)).booleanValue()) {
            this.zza.zzn(jSONObject);
        }
    }
}
