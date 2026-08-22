package com.google.android.gms.internal.ads;

import com.google.android.gms.auth.IJ.gZrKCJ;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlinx.coroutines.internal.Jbo.ygoi;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbpj {
    public final List zza;
    public final String zzb;
    public final String zzc;

    public zzbpj(JSONObject jSONObject) {
        String string;
        jSONObject.optString("id");
        JSONArray jSONArray = jSONObject.getJSONArray("adapters");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        this.zza = Collections.unmodifiableList(arrayList);
        jSONObject.optString("allocation_id", null);
        com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
        zzbpl zzbplVar = zzvVar.zzx;
        zzbpl.zza(jSONObject, "clickurl");
        zzbpl zzbplVar2 = zzvVar.zzx;
        zzbpl.zza(jSONObject, "imp_urls");
        zzbpl zzbplVar3 = zzvVar.zzx;
        zzbpl.zza(jSONObject, gZrKCJ.zbmA);
        zzbpl zzbplVar4 = zzvVar.zzx;
        zzbpl.zza(jSONObject, "fill_urls");
        zzbpl zzbplVar5 = zzvVar.zzx;
        zzbpl.zza(jSONObject, "video_start_urls");
        zzbpl zzbplVar6 = zzvVar.zzx;
        zzbpl.zza(jSONObject, ygoi.JJhupPDgfXon);
        zzbpl zzbplVar7 = zzvVar.zzx;
        zzbpl.zza(jSONObject, "video_reward_urls");
        jSONObject.optString(FirebaseAnalytics.Param.TRANSACTION_ID);
        jSONObject.optString("valid_from_timestamp");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("ad");
        if (jSONObjectOptJSONObject != null) {
            zzbpl zzbplVar8 = zzvVar.zzx;
            zzbpl.zza(jSONObjectOptJSONObject, "manual_impression_urls");
        }
        if (jSONObjectOptJSONObject != null) {
            jSONObjectOptJSONObject.toString();
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("data");
        if (jSONObjectOptJSONObject2 != null) {
            string = jSONObjectOptJSONObject2.toString();
        } else {
            string = null;
        }
        this.zzb = string;
        if (jSONObjectOptJSONObject2 != null) {
            jSONObjectOptJSONObject2.optString("class_name");
        }
        jSONObject.optString("html_template", null);
        jSONObject.optString("ad_base_url", null);
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("assets");
        if (jSONObjectOptJSONObject3 != null) {
            jSONObjectOptJSONObject3.toString();
        }
        zzbpl zzbplVar9 = zzvVar.zzx;
        zzbpl.zza(jSONObject, "template_ids");
        JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("ad_loader_options");
        if (jSONObjectOptJSONObject4 != null) {
            jSONObjectOptJSONObject4.toString();
        }
        this.zzc = jSONObject.optString("response_type", null);
        jSONObject.optLong("ad_network_timeout_millis", -1L);
    }
}
