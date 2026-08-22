package com.google.android.gms.ads;

import android.os.Bundle;
import com.facebook.appevents.suggestedevents.naLU.DaWYVMJ;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzv;
import com.google.android.gms.ads.internal.gMU.QTaELkFI;
import com.google.android.gms.ads.internal.offline.buffering.Dk.eoBKjVuj;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class AdapterResponseInfo {
    public final zzv zza;
    public final AdError zzb;

    public AdapterResponseInfo(zzv zzvVar) {
        this.zza = zzvVar;
        zze zzeVar = zzvVar.zzc;
        this.zzb = zzeVar == null ? null : zzeVar.zza();
    }

    public final String toString() {
        try {
            return zzb().toString(2);
        } catch (JSONException unused) {
            return "Error forming toString output.";
        }
    }

    public final JSONObject zzb() {
        JSONObject jSONObject = new JSONObject();
        zzv zzvVar = this.zza;
        jSONObject.put(DaWYVMJ.sPcjs, zzvVar.zza);
        jSONObject.put("Latency", zzvVar.zzb);
        String str = zzvVar.zze;
        String str2 = QTaELkFI.ebQAVJcBO;
        if (str == null) {
            jSONObject.put("Ad Source Name", str2);
        } else {
            jSONObject.put("Ad Source Name", str);
        }
        String str3 = zzvVar.zzf;
        if (str3 == null) {
            jSONObject.put("Ad Source ID", str2);
        } else {
            jSONObject.put("Ad Source ID", str3);
        }
        String str4 = zzvVar.zzg;
        if (str4 == null) {
            jSONObject.put("Ad Source Instance Name", str2);
        } else {
            jSONObject.put("Ad Source Instance Name", str4);
        }
        String str5 = zzvVar.zzh;
        if (str5 == null) {
            jSONObject.put("Ad Source Instance ID", str2);
        } else {
            jSONObject.put("Ad Source Instance ID", str5);
        }
        JSONObject jSONObject2 = new JSONObject();
        Bundle bundle = zzvVar.zzd;
        for (String str6 : bundle.keySet()) {
            jSONObject2.put(str6, bundle.get(str6));
        }
        jSONObject.put(eoBKjVuj.mZkwJeI, jSONObject2);
        AdError adError = this.zzb;
        if (adError == null) {
            jSONObject.put("Ad Error", str2);
        } else {
            jSONObject.put("Ad Error", adError.zzb());
        }
        return jSONObject;
    }
}
