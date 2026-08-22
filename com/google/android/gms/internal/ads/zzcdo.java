package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzcdo implements zzbkf {
    private static final Integer zzb(Map map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt((String) map.get(str)));
        } catch (NumberFormatException unused) {
            String strM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m("Precache invalid numeric parameter '", str, "': ", (String) map.get(str));
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj(strM);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbkf
    public final void zza(Object obj, Map map) {
        zzcdn zzcdqVar;
        zzcdf zzcdfVarZza;
        zzccb zzccbVar = (zzccb) obj;
        if (com.google.android.gms.ads.internal.util.client.zzo.zzm(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            com.google.android.gms.ads.internal.util.client.zzo.zze("Precache GMSG: ".concat(jSONObject.toString()));
        }
        zzcdg zzcdgVar = com.google.android.gms.ads.internal.zzv.zza.zzD;
        if (map.containsKey("abort")) {
            if (zzcdgVar.zzd(zzccbVar)) {
                return;
            }
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Precache abort but no precache task running.");
            return;
        }
        String str = (String) map.get("src");
        Integer numZzb = zzb(map, "periodicReportIntervalMs");
        Integer numZzb2 = zzb(map, "exoPlayerRenderingIntervalMs");
        Integer numZzb3 = zzb(map, "exoPlayerIdleIntervalMs");
        zzcca zzccaVar = new zzcca((String) map.get("flags"));
        boolean z = zzccaVar.zzk;
        if (str != null) {
            String[] strArr = {str};
            String str2 = (String) map.get("demuxed");
            if (str2 != null) {
                try {
                    JSONArray jSONArray = new JSONArray(str2);
                    String[] strArr2 = new String[jSONArray.length()];
                    for (int i = 0; i < jSONArray.length(); i++) {
                        strArr2[i] = jSONArray.getString(i);
                    }
                    strArr = strArr2;
                } catch (JSONException unused) {
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("Malformed demuxed URL list for precache: ".concat(str2));
                    strArr = null;
                }
            }
            if (strArr == null) {
                strArr = new String[]{str};
            }
            if (z) {
                Iterator it = zzcdgVar.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        zzcdfVarZza = null;
                        break;
                    }
                    zzcdf zzcdfVar = (zzcdf) it.next();
                    if (zzcdfVar.zza == zzccbVar && str.equals(zzcdfVar.zze())) {
                        zzcdfVarZza = zzcdfVar;
                        break;
                    }
                }
            } else {
                zzcdfVarZza = zzcdgVar.zza(zzccbVar);
            }
            if (zzcdfVarZza != null) {
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Precache task is already running.");
                return;
            }
            if (zzccbVar.zzj() == null) {
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Precache requires a dependency provider.");
                return;
            }
            Integer numZzb4 = zzb(map, "player");
            if (numZzb4 == null) {
                numZzb4 = 0;
            }
            if (numZzb != null) {
                zzccbVar.zzA(numZzb.intValue());
            }
            if (numZzb2 != null) {
                zzccbVar.zzy(numZzb2.intValue());
            }
            if (numZzb3 != null) {
                zzccbVar.zzx(numZzb3.intValue());
            }
            int iIntValue = numZzb4.intValue();
            zzccy zzccyVar = zzccbVar.zzj().zzb;
            if (iIntValue > 0) {
                int i2 = zzccaVar.zzg;
                int iZzu = zzcbs.zzu();
                if (iZzu < i2) {
                    zzcdqVar = new zzcdw(zzccbVar, zzccaVar);
                } else {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzp)).booleanValue()) {
                        iZzu = zzcdt.zzi();
                    }
                    zzcdqVar = iZzu < zzccaVar.zzb ? new zzcdt(zzccbVar, zzccaVar) : new zzcdr(zzccbVar);
                }
            } else {
                zzcdqVar = new zzcdq(zzccbVar);
            }
            new zzcdf(zzccbVar, zzcdqVar, str, strArr).zzb();
        } else {
            zzcdf zzcdfVarZza2 = zzcdgVar.zza(zzccbVar);
            if (zzcdfVarZza2 == null) {
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Precache must specify a source.");
                return;
            }
            zzcdqVar = zzcdfVarZza2.zzb;
        }
        Integer numZzb5 = zzb(map, "minBufferMs");
        if (numZzb5 != null) {
            zzcdqVar.zzs(numZzb5.intValue());
        }
        Integer numZzb6 = zzb(map, "maxBufferMs");
        if (numZzb6 != null) {
            zzcdqVar.zzr(numZzb6.intValue());
        }
        Integer numZzb7 = zzb(map, "bufferForPlaybackMs");
        if (numZzb7 != null) {
            zzcdqVar.zzp(numZzb7.intValue());
        }
        Integer numZzb8 = zzb(map, "bufferForPlaybackAfterRebufferMs");
        if (numZzb8 != null) {
            zzcdqVar.zzq(numZzb8.intValue());
        }
    }
}
