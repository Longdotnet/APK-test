package com.google.android.gms.internal.ads;

import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class zzbkt implements zzbku {
    final /* synthetic */ zzcak zza;

    public zzbkt(zzbkv zzbkvVar, zzcak zzcakVar) {
        this.zza = zzcakVar;
        Objects.requireNonNull(zzbkvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbku
    public final void zza(String str) {
        this.zza.zzd(new zzbol(str));
    }

    @Override // com.google.android.gms.internal.ads.zzbku
    public final void zzb(JSONObject jSONObject) {
        this.zza.zzc(jSONObject);
    }
}
