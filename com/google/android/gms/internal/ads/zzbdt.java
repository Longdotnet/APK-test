package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class zzbdt {
    private final List zza = new LinkedList();
    private final Map zzb;
    private final Object zzc;

    public zzbdt(boolean z, String str, String str2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.zzb = linkedHashMap;
        this.zzc = new Object();
        linkedHashMap.put("action", "make_wv");
        linkedHashMap.put(FirebaseAnalytics.Param.AD_FORMAT, str2);
    }

    public static final zzbdq zzf() {
        com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
        return new zzbdq(SystemClock.elapsedRealtime(), null, null);
    }

    public final zzbds zza() {
        zzbds zzbdsVar;
        boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzcc)).booleanValue();
        StringBuilder sb = new StringBuilder();
        HashMap map = new HashMap();
        synchronized (this.zzc) {
            try {
                List<zzbdq> list = this.zza;
                for (zzbdq zzbdqVar : list) {
                    long jZza = zzbdqVar.zza();
                    String strZzc = zzbdqVar.zzc();
                    zzbdq zzbdqVarZzb = zzbdqVar.zzb();
                    if (zzbdqVarZzb != null && jZza > 0) {
                        long jZza2 = jZza - zzbdqVarZzb.zza();
                        sb.append(strZzc);
                        sb.append('.');
                        sb.append(jZza2);
                        sb.append(',');
                        if (zBooleanValue) {
                            if (map.containsKey(Long.valueOf(zzbdqVarZzb.zza()))) {
                                StringBuilder sb2 = (StringBuilder) map.get(Long.valueOf(zzbdqVarZzb.zza()));
                                sb2.append('+');
                                sb2.append(strZzc);
                            } else {
                                map.put(Long.valueOf(zzbdqVarZzb.zza()), new StringBuilder(strZzc));
                            }
                        }
                    }
                }
                list.clear();
                String string = null;
                if (!TextUtils.isEmpty(null)) {
                    sb.append((String) null);
                } else if (sb.length() > 0) {
                    sb.setLength(sb.length() - 1);
                }
                StringBuilder sb3 = new StringBuilder();
                if (zBooleanValue) {
                    for (Map.Entry entry : map.entrySet()) {
                        sb3.append((CharSequence) entry.getValue());
                        sb3.append('.');
                        long jLongValue = ((Long) entry.getKey()).longValue();
                        com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
                        zzvVar.zzl.getClass();
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        zzvVar.zzl.getClass();
                        sb3.append(jCurrentTimeMillis + (jLongValue - SystemClock.elapsedRealtime()));
                        sb3.append(',');
                    }
                    if (sb3.length() > 0) {
                        sb3.setLength(sb3.length() - 1);
                    }
                    string = sb3.toString();
                }
                zzbdsVar = new zzbds(sb.toString(), string);
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdsVar;
    }

    public final Map zzb() {
        Map map;
        synchronized (this.zzc) {
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzg();
            map = this.zzb;
        }
        return map;
    }

    public final void zzc(zzbdt zzbdtVar) {
        synchronized (this.zzc) {
        }
    }

    public final void zzd(String str, String str2) {
        zzbdj zzbdjVarZzg;
        if (TextUtils.isEmpty(str2) || (zzbdjVarZzg = com.google.android.gms.ads.internal.zzv.zza.zzi.zzg()) == null) {
            return;
        }
        synchronized (this.zzc) {
            zzbdp zzbdpVarZza = zzbdjVarZzg.zza(str);
            Map map = this.zzb;
            map.put(str, zzbdpVarZza.zza((String) map.get(str), str2));
        }
    }

    public final boolean zze(zzbdq zzbdqVar, long j, String... strArr) {
        synchronized (this.zzc) {
            this.zza.add(new zzbdq(j, strArr[0], zzbdqVar));
        }
        return true;
    }
}
