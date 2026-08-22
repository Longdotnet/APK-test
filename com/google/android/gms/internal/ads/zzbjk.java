package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class zzbjk implements zzbkf {
    @Override // com.google.android.gms.internal.ads.zzbkf
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        JSONObject jSONObjectZza;
        zzcfg zzcfgVar = (zzcfg) obj;
        zzbgd zzbgdVarZzK = zzcfgVar.zzK();
        if (zzbgdVarZzK == null || (jSONObjectZza = zzbgdVarZzK.zza()) == null) {
            zzcfgVar.zze("nativeAdViewSignalsReady", new JSONObject());
        } else {
            zzcfgVar.zze("nativeAdViewSignalsReady", jSONObjectZza);
        }
    }
}
