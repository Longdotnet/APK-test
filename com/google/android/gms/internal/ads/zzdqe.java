package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzdqe {
    private JSONObject zzb;
    private final Executor zzc;
    private boolean zzd;
    private JSONObject zze;
    private final Map zza = new ConcurrentHashMap();
    private final AtomicBoolean zzf = new AtomicBoolean(false);

    public zzdqe(Executor executor) {
        this.zzc = executor;
    }

    private final void zzg() {
        if (this.zzf.getAndSet(true)) {
            return;
        }
        com.google.android.gms.ads.internal.util.zzg zzgVarZzi = com.google.android.gms.ads.internal.zzv.zza.zzi.zzi();
        ((com.google.android.gms.ads.internal.util.zzj) zzgVarZzi).zzc.add(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdqc
            @Override // java.lang.Runnable
            public final void run() {
                zzdqe zzdqeVar = this.zza;
                zzdqeVar.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdqd
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzdqeVar.zzh();
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zzh() {
        JSONObject jSONObjectZzf;
        Map map;
        try {
            this.zzd = true;
            zzbzm zzbzmVarZzg = ((com.google.android.gms.ads.internal.util.zzj) com.google.android.gms.ads.internal.zzv.zza.zzi.zzi()).zzg();
            if (zzbzmVarZzg != null && (jSONObjectZzf = zzbzmVarZzg.zzf()) != null) {
                this.zzb = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzes)).booleanValue() ? jSONObjectZzf.optJSONObject("common_settings") : null;
                this.zze = jSONObjectZzf.optJSONObject("ad_unit_patterns");
                JSONArray jSONArrayOptJSONArray = jSONObjectZzf.optJSONArray("ad_unit_id_settings");
                if (jSONArrayOptJSONArray != null) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                        if (jSONObjectOptJSONObject != null) {
                            String strOptString = jSONObjectOptJSONObject.optString("ad_unit_id");
                            String strOptString2 = jSONObjectOptJSONObject.optString("format");
                            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("request_signals");
                            if (strOptString != null && jSONObjectOptJSONObject2 != null && strOptString2 != null) {
                                Map map2 = this.zza;
                                if (map2.containsKey(strOptString2)) {
                                    map = (Map) map2.get(strOptString2);
                                } else {
                                    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                                    map2.put(strOptString2, concurrentHashMap);
                                    map = concurrentHashMap;
                                }
                                map.put(strOptString, jSONObjectOptJSONObject2);
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final JSONObject zza() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzes)).booleanValue()) {
            return this.zzb;
        }
        return null;
    }

    public final JSONObject zzb(String str, String str2) {
        zzbcv zzbcvVar = zzbde.zzeq;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (!((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue() || str == null || str2 == null) {
            return null;
        }
        if (!this.zzd) {
            zzh();
            if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzer)).booleanValue()) {
                zzg();
            }
        }
        Map map = (Map) this.zza.get(str2);
        if (map == null) {
            return null;
        }
        JSONObject jSONObject = (JSONObject) map.get(str);
        if (jSONObject != null) {
            return jSONObject;
        }
        String strZza = zzdqg.zza(this.zze, str, str2);
        if (strZza != null) {
            return (JSONObject) map.get(strZza);
        }
        return null;
    }

    public final void zzf() {
        zzg();
        this.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdqb
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzh();
            }
        });
    }
}
