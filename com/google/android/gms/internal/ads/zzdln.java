package com.google.android.gms.internal.ads;

import android.content.res.Resources;
import android.os.Bundle;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.daerisoft.thespikerm.R;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.inject.PVS.jIKWv;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdln {
    private final zzgdy zza;
    private final zzdmc zzb;
    private final zzdmh zzc;
    private final zzdsd zzd;

    public zzdln(zzgdy zzgdyVar, zzdmc zzdmcVar, zzdmh zzdmhVar, zzdsd zzdsdVar) {
        this.zza = zzgdyVar;
        this.zzb = zzdmcVar;
        this.zzc = zzdmhVar;
        this.zzd = zzdsdVar;
    }

    public static zzdit zza(zzdln zzdlnVar, ListenableFuture listenableFuture, ListenableFuture listenableFuture2, ListenableFuture listenableFuture3, ListenableFuture listenableFuture4, ListenableFuture listenableFuture5, JSONObject jSONObject, ListenableFuture listenableFuture6, ListenableFuture listenableFuture7, ListenableFuture listenableFuture8, ListenableFuture listenableFuture9, ListenableFuture listenableFuture10) {
        zzbcv zzbcvVar = zzbde.zzcs;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            CoroutineAdapterKt$$ExternalSyntheticLambda0.m(com.google.android.gms.ads.internal.zzv.zza.zzl, zzdlnVar.zzd.zza(), zzdrr.RENDERING_NATIVE_ASSETS_LOADING_END.zza());
        }
        zzdit zzditVar = (zzdit) listenableFuture.get();
        zzditVar.zzP((List) listenableFuture2.get());
        zzditVar.zzM((zzbgp) listenableFuture3.get());
        zzditVar.zzQ((zzbgp) listenableFuture4.get());
        zzditVar.zzJ((zzbgi) listenableFuture5.get());
        zzditVar.zzS(zzdmc.zzl(jSONObject));
        zzditVar.zzL(zzdmc.zzk(jSONObject));
        zzcfg zzcfgVar = (zzcfg) listenableFuture6.get();
        if (zzcfgVar != null) {
            zzditVar.zzad(zzcfgVar);
            zzditVar.zzac(zzcfgVar.zzF());
            zzditVar.zzab(zzcfgVar.zzq());
        }
        zzditVar.zzd().putAll((Bundle) listenableFuture7.get());
        zzcfg zzcfgVar2 = (zzcfg) listenableFuture8.get();
        if (zzcfgVar2 != null) {
            zzditVar.zzO(zzcfgVar2);
            zzditVar.zzae(zzcfgVar2.zzF());
        }
        if (!((Boolean) zzbdVar.zzd.zzb(zzbde.zzfG)).booleanValue() || zzf(jSONObject)) {
            zzcfg zzcfgVar3 = (zzcfg) listenableFuture9.get();
            if (zzcfgVar3 != null) {
                zzditVar.zzT(zzcfgVar3);
            }
        } else {
            zzditVar.zzU(listenableFuture9);
            zzditVar.zzX(new zzcak());
        }
        for (zzdmg zzdmgVar : (List) listenableFuture10.get()) {
            if (zzdmgVar.zza != 1) {
                zzditVar.zzN(zzdmgVar.zzb, zzdmgVar.zzd);
            } else {
                zzditVar.zzZ(zzdmgVar.zzb, zzdmgVar.zzc);
            }
        }
        return zzditVar;
    }

    private final ListenableFuture zze(ListenableFuture listenableFuture, zzdrr zzdrrVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzcx)).booleanValue()) {
            zzgdn.zzr(listenableFuture, new zzdlm(this, zzdrrVar), this.zza);
        }
        return listenableFuture;
    }

    private static final boolean zzf(JSONObject jSONObject) {
        return jSONObject.optInt("template_id") == 3;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0104  */
    public final ListenableFuture zzd(final zzfcn zzfcnVar, final zzfca zzfcaVar, final JSONObject jSONObject, com.google.android.gms.ads.internal.zzb zzbVar, zzbya zzbyaVar) {
        ListenableFuture listenableFutureZzh;
        JSONArray jSONArrayOptJSONArray;
        zzbcv zzbcvVar = zzbde.zzcs;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            CoroutineAdapterKt$$ExternalSyntheticLambda0.m(com.google.android.gms.ads.internal.zzv.zza.zzl, this.zzd.zza(), zzdrr.RENDERING_NATIVE_ASSETS_LOADING_START.zza());
        }
        final ListenableFuture listenableFutureZzb = this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzdlk
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzdln.zzb(this.zza, zzfcnVar, zzfcaVar, jSONObject);
            }
        });
        zze(listenableFutureZzb, zzdrr.NATIVE_ASSETS_LOADING_BASIC_END);
        zzdmc zzdmcVar = this.zzb;
        final ListenableFuture listenableFutureZzf = zzdmcVar.zzf(jSONObject, "images", zzdrr.zzU);
        zze(listenableFutureZzf, zzdrr.NATIVE_ASSETS_LOADING_IMAGE_END);
        zzfcd zzfcdVar = zzfcnVar.zzb.zzb;
        final ListenableFuture listenableFutureZzg = zzdmcVar.zzg(jSONObject, "images", zzfcaVar, zzfcdVar, zzbVar, zzbyaVar);
        zze(listenableFutureZzg, zzdrr.NATIVE_ASSETS_LOADING_IMAGE_COMPOSITION_END);
        final ListenableFuture listenableFutureZze = zzdmcVar.zze(jSONObject, "secondary_image", zzdrr.NATIVE_ASSETS_LOADING_LOGO_START);
        zze(listenableFutureZze, zzdrr.NATIVE_ASSETS_LOADING_LOGO_END);
        final ListenableFuture listenableFutureZze2 = zzdmcVar.zze(jSONObject, "app_icon", zzdrr.NATIVE_ASSETS_LOADING_ICON_START);
        zze(listenableFutureZze2, zzdrr.NATIVE_ASSETS_LOADING_ICON_END);
        final ListenableFuture listenableFutureZzd = zzdmcVar.zzd(jSONObject, "attribution", zzdrr.NATIVE_ASSETS_LOADING_ATTRIBUTION_START);
        zze(listenableFutureZzd, zzdrr.NATIVE_ASSETS_LOADING_ATTRIBUTION_END);
        final ListenableFuture listenableFutureZzj = zzdmcVar.zzj(jSONObject, zzfcaVar, zzfcdVar, zzbVar, zzbyaVar);
        zze(listenableFutureZzj, zzdrr.NATIVE_ASSETS_LOADING_VIDEO_END);
        if (!((Boolean) zzbdVar.zzd.zzb(zzbde.zznr)).booleanValue() || !jSONObject.has("video")) {
            listenableFutureZzh = zzgdn.zzh(new Bundle());
            break;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("video");
        if (jSONObjectOptJSONObject.has("flags") && (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("flags")) != null) {
            int i = 0;
            while (true) {
                if (i < jSONArrayOptJSONArray.length()) {
                    JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject2 == null || !jSONObjectOptJSONObject2.optString("key").equals("afma_video_player_type")) {
                        i++;
                    } else {
                        try {
                            if (Integer.parseInt(jSONObjectOptJSONObject2.optString(FirebaseAnalytics.Param.VALUE)) == 3) {
                                listenableFutureZzh = this.zzb.zzh(listenableFutureZzj);
                                zze(listenableFutureZzh, zzdrr.NATIVE_ASSETS_LOADING_MEDIA_END);
                                break;
                            }
                        } catch (NumberFormatException unused) {
                        }
                    }
                }
                listenableFutureZzh = zzgdn.zzh(new Bundle());
                break;
            }
        }
        listenableFutureZzh = zzgdn.zzh(new Bundle());
        break;
        final ListenableFuture listenableFuture = listenableFutureZzh;
        final ListenableFuture listenableFutureZza = this.zzc.zza(jSONObject, "custom_assets");
        zze(listenableFutureZza, zzdrr.zzak);
        final ListenableFuture listenableFutureZzi = this.zzb.zzi(jSONObject, zzbVar, zzbyaVar);
        zze(listenableFutureZzi, zzdrr.NATIVE_ASSETS_LOADING_OMID_END);
        ArrayList arrayList = new ArrayList();
        arrayList.add(listenableFutureZzb);
        arrayList.add(listenableFutureZzf);
        arrayList.add(listenableFutureZzg);
        arrayList.add(listenableFutureZze);
        arrayList.add(listenableFutureZze2);
        arrayList.add(listenableFutureZzd);
        arrayList.add(listenableFutureZzj);
        arrayList.add(listenableFuture);
        arrayList.add(listenableFutureZza);
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzfG)).booleanValue() || zzf(jSONObject)) {
            arrayList.add(listenableFutureZzi);
        }
        return zzgdn.zza(arrayList).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzdll
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzdln.zza(this.zza, listenableFutureZzb, listenableFutureZzf, listenableFutureZze2, listenableFutureZze, listenableFutureZzd, jSONObject, listenableFutureZzj, listenableFuture, listenableFutureZzg, listenableFutureZzi, listenableFutureZza);
            }
        }, this.zza);
    }

    public static zzdit zzb(zzdln zzdlnVar, zzfcn zzfcnVar, zzfca zzfcaVar, JSONObject jSONObject) throws zzehf {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzcx)).booleanValue()) {
            CoroutineAdapterKt$$ExternalSyntheticLambda0.m(com.google.android.gms.ads.internal.zzv.zza.zzl, zzdlnVar.zzd.zza(), zzdrr.NATIVE_ASSETS_LOADING_BASIC_START.zza());
        }
        zzdit zzditVar = new zzdit();
        zzditVar.zzaa(jSONObject.optInt("template_id", -1));
        zzditVar.zzK(jSONObject.optString("custom_template_id"));
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("omid_settings");
        zzditVar.zzV(jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("omid_partner_name") : null);
        zzfcw zzfcwVar = zzfcnVar.zza.zza;
        if (!zzfcwVar.zzg.contains(Integer.toString(zzditVar.zzc()))) {
            throw new zzehf(1, CoroutineAdapterKt$$ExternalSyntheticLambda0.m(zzditVar.zzc(), "Invalid template ID: "));
        }
        if (zzditVar.zzc() == 3) {
            if (zzditVar.zzA() == null) {
                throw new zzehf(1, "No custom template id for custom template ad response.");
            }
            if (!zzfcwVar.zzh.contains(zzditVar.zzA())) {
                throw new zzehf(1, "Unexpected custom template id in the response.");
            }
        }
        zzditVar.zzY(jSONObject.optDouble("rating", -1.0d));
        String strOptString = jSONObject.optString("headline", null);
        if (zzfcaVar.zzM) {
            com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
            com.google.android.gms.ads.internal.util.zzs zzsVar = zzvVar.zzd;
            Resources resourcesZze = zzvVar.zzi.zze();
            strOptString = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(resourcesZze != null ? resourcesZze.getString(R.string.s7) : "Test Ad", " : ", strOptString);
        }
        zzditVar.zzZ("headline", strOptString);
        String str = jIKWv.QwaKHKamrHXzSg;
        zzditVar.zzZ(str, jSONObject.optString(str, null));
        zzditVar.zzZ("call_to_action", jSONObject.optString("call_to_action", null));
        zzditVar.zzZ("store", jSONObject.optString("store", null));
        zzditVar.zzZ(FirebaseAnalytics.Param.PRICE, jSONObject.optString(FirebaseAnalytics.Param.PRICE, null));
        zzditVar.zzZ("advertiser", jSONObject.optString("advertiser", null));
        return zzditVar;
    }
}
