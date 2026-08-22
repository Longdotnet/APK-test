package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzbzm {
    private String zzd;
    private String zze;
    private long zzf;
    private JSONObject zzg;
    private boolean zzh;
    private boolean zzj;
    private final List zza = new ArrayList();
    private final List zzb = new ArrayList();
    private final Map zzc = new HashMap();
    private final List zzi = new ArrayList();

    public zzbzm(String str, long j) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        JSONArray jSONArrayOptJSONArray;
        JSONObject jSONObjectOptJSONObject3;
        this.zzd = "";
        this.zzh = false;
        this.zzj = false;
        this.zze = str;
        this.zzf = j;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.zzg = new JSONObject(str);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzmc)).booleanValue() && zzj()) {
                return;
            }
            if (this.zzg.optInt("status", -1) != 1) {
                this.zzh = false;
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("App settings could not be fetched successfully.");
                return;
            }
            this.zzh = true;
            this.zzd = this.zzg.optString("app_id");
            JSONArray jSONArrayOptJSONArray2 = this.zzg.optJSONArray("ad_unit_id_settings");
            if (jSONArrayOptJSONArray2 != null) {
                for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                    JSONObject jSONObject = jSONArrayOptJSONArray2.getJSONObject(i2);
                    String strOptString = jSONObject.optString("format");
                    String strOptString2 = jSONObject.optString("ad_unit_id");
                    if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString2)) {
                        if ("interstitial".equalsIgnoreCase(strOptString)) {
                            this.zzb.add(strOptString2);
                        } else if (("rewarded".equalsIgnoreCase(strOptString) || "rewarded_interstitial".equals(strOptString)) && (jSONObjectOptJSONObject3 = jSONObject.optJSONObject("mediation_config")) != null) {
                            this.zzc.put(strOptString2, new zzbpk(jSONObjectOptJSONObject3));
                        }
                    }
                }
            }
            JSONArray jSONArrayOptJSONArray3 = this.zzg.optJSONArray("persistable_banner_ad_unit_ids");
            if (jSONArrayOptJSONArray3 != null) {
                for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                    this.zza.add(jSONArrayOptJSONArray3.optString(i3));
                }
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzhc)).booleanValue() && (jSONObjectOptJSONObject2 = this.zzg.optJSONObject("common_settings")) != null && (jSONArrayOptJSONArray = jSONObjectOptJSONObject2.optJSONArray("loeid")) != null) {
                for (int i4 = 0; i4 < jSONArrayOptJSONArray.length(); i4++) {
                    this.zzi.add(jSONArrayOptJSONArray.get(i4).toString());
                }
            }
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzgy)).booleanValue() || (jSONObjectOptJSONObject = this.zzg.optJSONObject("common_settings")) == null) {
                return;
            }
            this.zzj = jSONObjectOptJSONObject.optBoolean("is_prefetching_enabled", false);
        } catch (JSONException e) {
            int i5 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Exception occurred while processing app setting json", e);
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "AppSettings.parseAppSettingsJson");
        }
    }

    public final long zza() {
        return this.zzf;
    }

    public final String zzb() {
        return this.zzd;
    }

    public final String zzc() {
        return this.zze;
    }

    public final List zzd() {
        return this.zzi;
    }

    public final Map zze() {
        return this.zzc;
    }

    public final JSONObject zzf() {
        return this.zzg;
    }

    public final void zzg(long j) {
        this.zzf = j;
    }

    public final boolean zzh() {
        return this.zzj;
    }

    public final boolean zzi() {
        return this.zzh;
    }

    public final boolean zzj() {
        if (!TextUtils.isEmpty(this.zze) && this.zzg != null) {
            zzbcv zzbcvVar = zzbde.zzmf;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
            long jLongValue = ((Long) zzbdVar.zzd.zzb(zzbcvVar)).longValue();
            zzbcv zzbcvVar2 = zzbde.zzme;
            zzbdc zzbdcVar = zzbdVar.zzd;
            if (((Boolean) zzbdcVar.zzb(zzbcvVar2)).booleanValue() && !TextUtils.isEmpty(this.zze)) {
                jLongValue = this.zzg.optLong("cache_ttl_sec", ((Long) zzbdcVar.zzb(zzbcvVar)).longValue());
            }
            com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jLongValue >= 0) {
                long j = this.zzf;
                if (j > jCurrentTimeMillis || TimeUnit.MILLISECONDS.toSeconds(jCurrentTimeMillis - j) > jLongValue) {
                    this.zza.clear();
                    this.zzb.clear();
                    this.zzc.clear();
                    this.zzd = "";
                    this.zze = "";
                    this.zzg = null;
                    this.zzh = false;
                    this.zzi.clear();
                    this.zzj = false;
                    return true;
                }
            }
        }
        return false;
    }
}
