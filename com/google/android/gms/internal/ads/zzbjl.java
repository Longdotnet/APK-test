package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class zzbjl implements zzbkf {
    @Override // com.google.android.gms.internal.ads.zzbkf
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        JSONObject jSONObjectZzb;
        zzcfg zzcfgVar = (zzcfg) obj;
        zzbgd zzbgdVarZzK = zzcfgVar.zzK();
        if (zzbgdVarZzK == null || (jSONObjectZzb = zzbgdVarZzK.zzb()) == null) {
            zzcfgVar.zze("nativeClickMetaReady", new JSONObject());
        } else {
            zzcfgVar.zze("nativeClickMetaReady", jSONObjectZzb);
        }
    }
}
