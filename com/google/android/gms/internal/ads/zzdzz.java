package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class zzdzz implements zzbop {
    @Override // com.google.android.gms.internal.ads.zzbop
    public final JSONObject zzb(Object obj) {
        zzeaa zzeaaVar = (zzeaa) obj;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzjI)).booleanValue()) {
            zzbvs zzbvsVar = zzeaaVar.zzd;
            jSONObject2.put("ad_request_url", zzbvsVar.zzg());
            jSONObject2.put("ad_request_post_body", zzbvsVar.zzf());
        }
        zzbvs zzbvsVar2 = zzeaaVar.zzd;
        jSONObject2.put("base_url", zzbvsVar2.zzd());
        jSONObject2.put("signals", zzeaaVar.zzc);
        zzeae zzeaeVar = zzeaaVar.zzb;
        jSONObject3.put("body", zzeaeVar.zzc);
        jSONObject3.put("headers", com.google.android.gms.ads.internal.client.zzbb.zzb.zzc.zzo(zzeaeVar.zzb));
        jSONObject3.put("response_code", zzeaeVar.zza);
        jSONObject3.put("latency", zzeaeVar.zzd);
        jSONObject.put("request", jSONObject2);
        jSONObject.put("response", jSONObject3);
        jSONObject.put("flags", zzbvsVar2.zzi());
        return jSONObject;
    }
}
