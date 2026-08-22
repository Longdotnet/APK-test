package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class zzdtn {
    private Long zza;
    private final String zzb;
    private String zzc;
    private Integer zzd;
    private String zze;
    private Integer zzf;

    public /* synthetic */ zzdtn(String str, zzdto zzdtoVar) {
        this.zzb = str;
    }

    public static String zza(zzdtn zzdtnVar) {
        String str = (String) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzku);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("objectId", zzdtnVar.zza);
            jSONObject.put("eventCategory", zzdtnVar.zzb);
            jSONObject.putOpt("event", zzdtnVar.zzc);
            jSONObject.putOpt("errorCode", zzdtnVar.zzd);
            jSONObject.putOpt("rewardType", zzdtnVar.zze);
            jSONObject.putOpt("rewardAmount", zzdtnVar.zzf);
        } catch (JSONException unused) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not convert parameters to JSON.");
        }
        return str + "(\"h5adsEvent\"," + jSONObject.toString() + ");";
    }
}
