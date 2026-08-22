package com.google.android.gms.ads.nonagon.signalgeneration;

import android.text.TextUtils;
import android.util.Pair;
import androidx.emoji2.text.flatbuffer.bs.bUqMCsuPSX;
import com.facebook.login.vu.dLDI;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.internal.ads.zzbcv;
import com.google.android.gms.internal.ads.zzbdc;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzcaf;
import com.google.android.gms.internal.ads.zzdsd;
import com.google.android.gms.internal.ads.zzdso;
import com.yoyogames.runner.RunnerJNILib;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.MediaType;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzv {
    public final int zza;
    public final long zzb;
    public final boolean zzc;
    public final boolean zzd;
    public final Map zze;
    public final ArrayDeque zzf = new ArrayDeque();
    public final ArrayDeque zzg = new ArrayDeque();
    public final zzdso zzh;
    public ConcurrentHashMap zzi;

    public zzv(zzdso zzdsoVar) {
        this.zzh = zzdsoVar;
        zzbcv zzbcvVar = zzbde.zzhe;
        zzbd zzbdVar = zzbd.zza;
        this.zza = ((Integer) zzbdVar.zzd.zzb(zzbcvVar)).intValue();
        zzbcv zzbcvVar2 = zzbde.zzhf;
        zzbdc zzbdcVar = zzbdVar.zzd;
        this.zzb = ((Long) zzbdcVar.zzb(zzbcvVar2)).longValue();
        this.zzc = ((Boolean) zzbdcVar.zzb(zzbde.zzhj)).booleanValue();
        this.zzd = ((Boolean) zzbdcVar.zzb(zzbde.zzhi)).booleanValue();
        this.zze = Collections.synchronizedMap(new zzt(this));
    }

    public final synchronized String zzb(String str, zzdsd zzdsdVar) {
        zzu zzuVar = (zzu) this.zze.get(str);
        zzdsdVar.zzb().put("request_id", str);
        if (zzuVar == null) {
            zzdsdVar.zzb().put("mhit", "false");
            return null;
        }
        zzdsdVar.zzb().put(dLDI.Whx, bUqMCsuPSX.tGBhhfg);
        return zzuVar.zzb;
    }

    public final synchronized void zze(String str, String str2, zzdsd zzdsdVar) {
        com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
        this.zze.put(str, new zzu(Long.valueOf(System.currentTimeMillis()), str2, new HashSet()));
        zzk();
        zzi(zzdsdVar);
    }

    public final synchronized void zzf(String str) {
        this.zze.remove(str);
    }

    public final synchronized boolean zzg(int i, String str, String str2) {
        zzu zzuVar = (zzu) this.zze.get(str);
        if (zzuVar == null) {
            return false;
        }
        HashSet hashSet = zzuVar.zzc;
        hashSet.add(str2);
        return hashSet.size() < i;
    }

    public final synchronized boolean zzh(String str, String str2) {
        zzu zzuVar = (zzu) this.zze.get(str);
        return zzuVar != null && zzuVar.zzc.contains(str2);
    }

    public final synchronized void zzi(zzdsd zzdsdVar) {
        if (this.zzc) {
            ArrayDeque arrayDeque = this.zzg;
            ArrayDeque arrayDequeClone = arrayDeque.clone();
            arrayDeque.clear();
            ArrayDeque arrayDeque2 = this.zzf;
            ArrayDeque arrayDequeClone2 = arrayDeque2.clone();
            arrayDeque2.clear();
            zzcaf.zza.execute(new RunnerJNILib.AnonymousClass2((Object) this, (Object) zzdsdVar, (Serializable) arrayDequeClone, (Serializable) arrayDequeClone2, 6));
        }
    }

    public final void zzj(zzdsd zzdsdVar, ArrayDeque arrayDeque, String str) {
        Pair pair;
        while (!arrayDeque.isEmpty()) {
            Pair pair2 = (Pair) arrayDeque.poll();
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(zzdsdVar.zzb());
            this.zzi = concurrentHashMap;
            concurrentHashMap.put("action", "ev");
            this.zzi.put("e_r", str);
            this.zzi.put("e_id", (String) pair2.first);
            if (this.zzd) {
                try {
                    JSONObject jSONObject = new JSONObject((String) pair2.second);
                    pair = new Pair(MediaType.Companion.zzb(jSONObject.getJSONObject("extras").getString("query_info_type")), jSONObject.getString("request_agent"));
                } catch (JSONException unused) {
                    pair = new Pair("", "");
                }
                ConcurrentHashMap concurrentHashMap2 = this.zzi;
                String str2 = (String) pair.first;
                if (!TextUtils.isEmpty(str2)) {
                    concurrentHashMap2.put("e_type", str2);
                }
                ConcurrentHashMap concurrentHashMap3 = this.zzi;
                String str3 = (String) pair.second;
                if (!TextUtils.isEmpty(str3)) {
                    concurrentHashMap3.put("e_agent", str3);
                }
            }
            this.zzh.zzg(this.zzi);
        }
    }

    public final synchronized void zzk() {
        com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            Iterator it = this.zze.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (jCurrentTimeMillis - ((zzu) entry.getValue()).zza.longValue() <= this.zzb) {
                    break;
                }
                this.zzg.add(new Pair((String) entry.getKey(), ((zzu) entry.getValue()).zzb));
                it.remove();
                throw th;
            }
        } catch (ConcurrentModificationException e) {
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "QueryJsonMap.removeExpiredEntries");
        }
    }
}
