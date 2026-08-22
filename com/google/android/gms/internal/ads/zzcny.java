package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzcny implements zzhgr {
    private final zzhha zza;

    private zzcny(zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzcny zza(zzhha zzhhaVar) {
        return new zzcny(zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        try {
            return new JSONObject(((zzcrr) this.zza).zzc().zzz);
        } catch (JSONException unused) {
            return null;
        }
    }
}
