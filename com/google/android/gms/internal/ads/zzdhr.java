package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzdhr implements zzhgr {
    private final zzdhp zza;

    private zzdhr(zzdhp zzdhpVar) {
        this.zza = zzdhpVar;
    }

    public static zzdhr zza(zzdhp zzdhpVar) {
        return new zzdhr(zzdhpVar);
    }

    public static JSONObject zzc(zzdhp zzdhpVar) {
        JSONObject jSONObjectZzd = zzdhpVar.zzd();
        zzhgz.zzb(jSONObjectZzd);
        return jSONObjectZzd;
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* synthetic */ Object zzb() {
        return zzc(this.zza);
    }

    public final JSONObject zzd() {
        return zzc(this.zza);
    }
}
