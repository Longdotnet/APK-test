package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzefu implements zzedo {
    private final zzdpz zza;

    public zzefu(zzdpz zzdpzVar) {
        this.zza = zzdpzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzedo
    public final zzedp zza(String str, JSONObject jSONObject) {
        return new zzedp(this.zza.zzc(str, jSONObject), new zzefd(), str);
    }
}
