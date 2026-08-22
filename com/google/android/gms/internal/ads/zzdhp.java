package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzdhp {
    private final JSONObject zza;
    private final zzdny zzb;
    private final com.google.android.gms.ads.internal.zzb zzc;
    private final zzbya zzd;

    public zzdhp(JSONObject jSONObject, zzdny zzdnyVar, com.google.android.gms.ads.internal.zzb zzbVar, zzbya zzbyaVar) {
        this.zza = jSONObject;
        this.zzb = zzdnyVar;
        this.zzc = zzbVar;
        this.zzd = zzbyaVar;
    }

    public final com.google.android.gms.ads.internal.zzb zza() {
        return this.zzc;
    }

    public final zzbya zzb() {
        return this.zzd;
    }

    public final zzdny zzc() {
        return this.zzb;
    }

    public final JSONObject zzd() {
        return this.zza;
    }
}
