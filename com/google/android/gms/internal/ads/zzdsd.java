package com.google.android.gms.internal.ads;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.MediaType;

/* JADX INFO: loaded from: classes.dex */
public final class zzdsd {
    private final ConcurrentHashMap zza;
    private final zzbzw zzb;
    private final zzfcw zzc;
    private final String zzd;
    private final String zze;
    private final com.google.android.gms.ads.internal.zzk zzf;
    private final Bundle zzg = new Bundle();
    private final Context zzh;

    public zzdsd(Context context, zzdso zzdsoVar, zzbzw zzbzwVar, zzfcw zzfcwVar, String str, String str2, com.google.android.gms.ads.internal.zzk zzkVar) {
        ActivityManager activityManager;
        String str3;
        ConcurrentHashMap concurrentHashMapZzc = zzdsoVar.zzc();
        this.zza = concurrentHashMapZzc;
        this.zzb = zzbzwVar;
        this.zzc = zzfcwVar;
        this.zzd = str;
        this.zze = str2;
        this.zzf = zzkVar;
        this.zzh = context;
        concurrentHashMapZzc.put(FirebaseAnalytics.Param.AD_FORMAT, str2.toUpperCase(Locale.ROOT));
        zzbcv zzbcvVar = zzbde.zzjW;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        ActivityManager.MemoryInfo memoryInfo = null;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            int i = zzkVar.zzp;
            int i2 = i - 1;
            if (i == 0) {
                throw null;
            }
            if (i2 != 0) {
                str3 = i2 != 1 ? "na" : "2";
            } else {
                str3 = "1";
            }
            concurrentHashMapZzc.put("asv", str3);
        }
        zzbcv zzbcvVar2 = zzbde.zzcq;
        zzbdc zzbdcVar = zzbdVar.zzd;
        if (((Boolean) zzbdcVar.zzb(zzbcvVar2)).booleanValue()) {
            Runtime runtime = Runtime.getRuntime();
            zzd("rt_f", String.valueOf(runtime.freeMemory()));
            zzd("rt_m", String.valueOf(runtime.maxMemory()));
            zzd("rt_t", String.valueOf(runtime.totalMemory()));
            zzd("wv_c", String.valueOf(com.google.android.gms.ads.internal.zzv.zza.zzi.zzb()));
            if (((Boolean) zzbdcVar.zzb(zzbde.zzcy)).booleanValue()) {
                zzfrw zzfrwVar = com.google.android.gms.ads.internal.util.client.zzf.zza;
                if (context != null && (activityManager = (ActivityManager) context.getSystemService("activity")) != null) {
                    memoryInfo = new ActivityManager.MemoryInfo();
                    try {
                        activityManager.getMemoryInfo(memoryInfo);
                    } catch (NullPointerException unused) {
                        com.google.android.gms.ads.internal.util.client.zzo.zzj("Error retrieving the memory information.");
                    }
                }
                if (memoryInfo != null) {
                    zzd("mem_avl", String.valueOf(memoryInfo.availMem));
                    zzd("mem_tt", String.valueOf(memoryInfo.totalMem));
                    zzd("low_m", true != memoryInfo.lowMemory ? "0" : "1");
                }
            }
        }
        if (((Boolean) zzbdcVar.zzb(zzbde.zzhg)).booleanValue()) {
            int iZzg = MediaType.Companion.zzg(zzfcwVar) - 1;
            if (iZzg == 0) {
                concurrentHashMapZzc.put("request_id", str);
                concurrentHashMapZzc.put("scar", "false");
                return;
            }
            if (iZzg == 1) {
                concurrentHashMapZzc.put("request_id", str);
                concurrentHashMapZzc.put("se", "query_g");
            } else if (iZzg == 2) {
                concurrentHashMapZzc.put("se", "r_adinfo");
            } else if (iZzg != 3) {
                concurrentHashMapZzc.put("se", "r_both");
            } else {
                concurrentHashMapZzc.put("se", "r_adstring");
            }
            concurrentHashMapZzc.put("scar", "true");
            zzd("ragent", zzfcwVar.zzd.zzp);
            zzd("rtype", MediaType.Companion.zzb(MediaType.Companion.zzc(zzfcwVar.zzd)));
        }
    }

    public final Bundle zza() {
        return this.zzg;
    }

    public final Map zzb() {
        return this.zza;
    }

    public final void zzc() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zznG)).booleanValue()) {
            zzd("brr", true != this.zzc.zzp ? "0" : "1");
        }
    }

    public final void zzd(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.zza.put(str, str2);
    }

    public final void zze(zzfcn zzfcnVar) {
        zzfcm zzfcmVar = zzfcnVar.zzb;
        List list = zzfcmVar.zza;
        if (!list.isEmpty()) {
            int i = ((zzfca) list.get(0)).zzb;
            zzd(FirebaseAnalytics.Param.AD_FORMAT, zzfca.zza(i));
            if (i == 6) {
                this.zza.put("as", true != this.zzb.zzm() ? "0" : "1");
            }
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzcs)).booleanValue()) {
            zzd("mwl", Integer.toString(list.size()));
        }
        zzd("gqi", zzfcmVar.zzb.zzb);
    }

    public final void zzf(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        if (bundle.containsKey("cnt")) {
            zzd("network_coarse", Integer.toString(bundle.getInt("cnt")));
        }
        if (bundle.containsKey("gnt")) {
            zzd("network_fine", Integer.toString(bundle.getInt("gnt")));
        }
    }
}
