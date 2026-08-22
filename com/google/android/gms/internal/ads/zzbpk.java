package com.google.android.gms.internal.ads;

import com.google.android.gms.auth.api.LNi.xPQrbOSWiEdU;
import com.google.android.gms.common.util.concurrent.dN.MnHfHMYQDPUO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbpk {
    public final List zza;

    public zzbpk(JSONObject jSONObject) {
        if (com.google.android.gms.ads.internal.util.client.zzo.zzm(2)) {
            com.google.android.gms.ads.internal.util.zze.zza("Mediation Response JSON: ".concat(String.valueOf(jSONObject.toString(2))));
        }
        JSONArray jSONArray = jSONObject.getJSONArray("ad_networks");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        int i = -1;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                zzbpj zzbpjVar = new zzbpj(jSONArray.getJSONObject(i2));
                "banner".equalsIgnoreCase(zzbpjVar.zzc);
                arrayList.add(zzbpjVar);
                if (i < 0) {
                    Iterator it = zzbpjVar.zza.iterator();
                    while (it.hasNext()) {
                        if (((String) it.next()).equals("com.google.ads.mediation.admob.AdMobAdapter")) {
                            i = i2;
                            break;
                        }
                    }
                }
            } catch (JSONException unused) {
            }
        }
        jSONArray.length();
        this.zza = Collections.unmodifiableList(arrayList);
        jSONObject.optString("qdata");
        jSONObject.optInt("fs_model_type", -1);
        jSONObject.optLong(xPQrbOSWiEdU.FEB, -1L);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("settings");
        if (jSONObjectOptJSONObject != null) {
            jSONObjectOptJSONObject.optLong("ad_network_timeout_millis", -1L);
            com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
            zzbpl zzbplVar = zzvVar.zzx;
            zzbpl.zza(jSONObjectOptJSONObject, "click_urls");
            zzbpl zzbplVar2 = zzvVar.zzx;
            zzbpl.zza(jSONObjectOptJSONObject, "imp_urls");
            zzbpl zzbplVar3 = zzvVar.zzx;
            zzbpl.zza(jSONObjectOptJSONObject, "downloaded_imp_urls");
            zzbpl zzbplVar4 = zzvVar.zzx;
            zzbpl.zza(jSONObjectOptJSONObject, "nofill_urls");
            zzbpl zzbplVar5 = zzvVar.zzx;
            zzbpl.zza(jSONObjectOptJSONObject, "remote_ping_urls");
            jSONObjectOptJSONObject.optBoolean("render_in_browser", false);
            jSONObjectOptJSONObject.optLong("refresh", -1L);
            zzbwo.zza(jSONObjectOptJSONObject.optJSONArray("rewards"));
            jSONObjectOptJSONObject.optBoolean("use_displayed_impression", false);
            jSONObjectOptJSONObject.optBoolean(MnHfHMYQDPUO.vTe, false);
            jSONObjectOptJSONObject.optBoolean("allow_pub_owned_ad_view", false);
            jSONObjectOptJSONObject.optBoolean("allow_custom_click_gesture", false);
        }
    }
}
