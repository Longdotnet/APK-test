package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import androidx.loader.app.gv.DYYbQc;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.work.impl.constraints.controllers.pST.ehgOP;
import com.google.android.finsky.externalreferrer.jUdg.RDFWIi;
import com.google.android.gms.ads.jY.UUFMQdNK;
import com.google.android.gms.appset.vSSa.iafHZUfOuHNwvy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcdb implements zzbkf {
    private boolean zza;

    private static int zzb(Context context, Map map, String str, int i) {
        String str2 = (String) map.get(str);
        if (str2 != null) {
            try {
                com.google.android.gms.ads.internal.util.client.zzf zzfVar = com.google.android.gms.ads.internal.client.zzbb.zzb.zzc;
                i = com.google.android.gms.ads.internal.util.client.zzf.zzC(context, Integer.parseInt(str2));
            } catch (NumberFormatException unused) {
                String strM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m("Could not parse ", str, " in a video GMSG: ", str2);
                int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzj(strM);
            }
        }
        if (com.google.android.gms.ads.internal.util.zze.zzc()) {
            StringBuilder sbM22m = CoroutineAdapterKt$$ExternalSyntheticLambda0.m22m("Parse pixels for ", str, ", got string ", str2, ", int ");
            sbM22m.append(i);
            sbM22m.append(".");
            com.google.android.gms.ads.internal.util.zze.zza(sbM22m.toString());
        }
        return i;
    }

    private static void zzc(zzcbp zzcbpVar, Map map) {
        String str = (String) map.get("minBufferMs");
        String str2 = (String) map.get("maxBufferMs");
        String str3 = (String) map.get("bufferForPlaybackMs");
        String str4 = (String) map.get("bufferForPlaybackAfterRebufferMs");
        String str5 = (String) map.get("socketReceiveBufferSize");
        if (str != null) {
            try {
                zzcbpVar.zzB(Integer.parseInt(str));
            } catch (NumberFormatException unused) {
                String strM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m("Could not parse buffer parameters in loadControl video GMSG: (", str, ", ", str2, UUFMQdNK.vYkOKbn);
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzj(strM);
                return;
            }
        }
        if (str2 != null) {
            zzcbpVar.zzA(Integer.parseInt(str2));
        }
        if (str3 != null) {
            zzcbpVar.zzy(Integer.parseInt(str3));
        }
        if (str4 != null) {
            zzcbpVar.zzz(Integer.parseInt(str4));
        }
        if (str5 != null) {
            zzcbpVar.zzD(Integer.parseInt(str5));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbkf
    public final void zza(Object obj, Map map) {
        int iMin;
        int iMin2;
        int i;
        Integer numValueOf;
        zzccb zzccbVar = (zzccb) obj;
        String str = (String) map.get("action");
        if (str == null) {
            int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Action missing from video GMSG.");
            return;
        }
        Integer numValueOf2 = map.containsKey("playerId") ? Integer.valueOf(Integer.parseInt((String) map.get("playerId"))) : null;
        Integer numZzb = zzccbVar.zzn() != null ? zzccbVar.zzn().zzb() : null;
        if (numValueOf2 != null && numZzb != null && !numValueOf2.equals(numZzb) && !str.equals("load")) {
            Locale locale = Locale.US;
            int i3 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Event intended for player " + numValueOf2 + ", but sent to player " + numZzb + " - event ignored");
            return;
        }
        if (com.google.android.gms.ads.internal.util.client.zzo.zzm(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            com.google.android.gms.ads.internal.util.client.zzo.zze("Video GMSG: " + str + " " + jSONObject.toString());
        }
        if (str.equals("background")) {
            String str2 = (String) map.get("color");
            if (TextUtils.isEmpty(str2)) {
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Color parameter missing from background video GMSG.");
                return;
            }
            try {
                zzccbVar.setBackgroundColor(Color.parseColor(str2));
                return;
            } catch (IllegalArgumentException unused) {
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Invalid color parameter in background video GMSG.");
                return;
            }
        }
        if (str.equals("playerBackground")) {
            String str3 = (String) map.get("color");
            if (TextUtils.isEmpty(str3)) {
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Color parameter missing from playerBackground video GMSG.");
                return;
            }
            try {
                zzccbVar.zzB(Color.parseColor(str3));
                return;
            } catch (IllegalArgumentException unused2) {
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Invalid color parameter in playerBackground video GMSG.");
                return;
            }
        }
        if (str.equals("decoderProps")) {
            String str4 = (String) map.get("mimeTypes");
            if (str4 == null) {
                com.google.android.gms.ads.internal.util.client.zzo.zzj("No MIME types specified for decoder properties inspection.");
                HashMap map2 = new HashMap();
                map2.put("event", "decoderProps");
                map2.put("error", "missingMimeTypes");
                zzccbVar.zzd("onVideoEvent", map2);
                return;
            }
            HashMap map3 = new HashMap();
            for (String str5 : str4.split(",")) {
                map3.put(str5, com.google.android.gms.ads.internal.util.zzcj.zza(str5.trim()));
            }
            HashMap map4 = new HashMap();
            map4.put("event", "decoderProps");
            map4.put("mimeTypes", map3);
            zzccbVar.zzd("onVideoEvent", map4);
            return;
        }
        zzcbq zzcbqVarZzn = zzccbVar.zzn();
        if (zzcbqVarZzn == null) {
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not get underlay container for a video GMSG.");
            return;
        }
        boolean zEquals = str.equals("new");
        boolean zEquals2 = str.equals("position");
        if (zEquals || zEquals2) {
            Context context = zzccbVar.getContext();
            int iZzb = zzb(context, map, "x", 0);
            int iZzb2 = zzb(context, map, "y", 0);
            int iZzb3 = zzb(context, map, "w", -1);
            zzbcv zzbcvVar = zzbde.zzeg;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
            if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
                iMin = iZzb3 == -1 ? zzccbVar.zzh() : Math.min(iZzb3, zzccbVar.zzh());
            } else {
                if (com.google.android.gms.ads.internal.util.zze.zzc()) {
                    StringBuilder sbM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m("Calculate width with original width ", iZzb3, ", videoHost.getVideoBoundingWidth() ", zzccbVar.zzh(), ", x ");
                    sbM.append(iZzb);
                    sbM.append(".");
                    com.google.android.gms.ads.internal.util.zze.zza(sbM.toString());
                }
                iMin = Math.min(iZzb3, zzccbVar.zzh() - iZzb);
            }
            int i4 = iMin;
            int iZzb4 = zzb(context, map, "h", -1);
            if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
                iMin2 = iZzb4 == -1 ? zzccbVar.zzg() : Math.min(iZzb4, zzccbVar.zzg());
            } else {
                if (com.google.android.gms.ads.internal.util.zze.zzc()) {
                    StringBuilder sbM2 = CoroutineAdapterKt$$ExternalSyntheticLambda0.m("Calculate height with original height ", iZzb4, DYYbQc.CpPfSbkADSd, zzccbVar.zzg(), ", y ");
                    sbM2.append(iZzb2);
                    sbM2.append(".");
                    com.google.android.gms.ads.internal.util.zze.zza(sbM2.toString());
                }
                iMin2 = Math.min(iZzb4, zzccbVar.zzg() - iZzb2);
            }
            try {
                i = Integer.parseInt((String) map.get("player"));
            } catch (NumberFormatException unused3) {
                i = 0;
            }
            boolean z = Boolean.parseBoolean((String) map.get("spherical"));
            if (!zEquals || zzcbqVarZzn.zza() != null) {
                zzcbqVarZzn.zzc(iZzb, iZzb2, i4, iMin2);
                return;
            }
            zzcbqVarZzn.zzd(iZzb, iZzb2, i4, iMin2, i, z, new zzcca((String) map.get("flags")));
            zzcbp zzcbpVarZza = zzcbqVarZzn.zza();
            if (zzcbpVarZza != null) {
                zzc(zzcbpVarZza, map);
                return;
            }
            return;
        }
        zzcgi zzcgiVarZzq = zzccbVar.zzq();
        if (zzcgiVarZzq != null) {
            if (str.equals("timeupdate")) {
                String str6 = (String) map.get("currentTime");
                if (str6 == null) {
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("currentTime parameter missing from timeupdate video GMSG.");
                    return;
                }
                try {
                    zzcgiVarZzq.zzt(Float.parseFloat(str6));
                    return;
                } catch (NumberFormatException unused4) {
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not parse currentTime parameter from timeupdate video GMSG: ".concat(str6));
                    return;
                }
            }
            if (str.equals("skip")) {
                zzcgiVarZzq.zzu();
                return;
            }
        }
        zzcbp zzcbpVarZza2 = zzcbqVarZzn.zza();
        if (zzcbpVarZza2 == null) {
            HashMap map5 = new HashMap();
            map5.put("event", "no_video_view");
            zzccbVar.zzd("onVideoEvent", map5);
            return;
        }
        if (str.equals("click")) {
            Context context2 = zzccbVar.getContext();
            int iZzb5 = zzb(context2, map, "x", 0);
            float fZzb = zzb(context2, map, "y", 0);
            long jUptimeMillis = SystemClock.uptimeMillis();
            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, iZzb5, fZzb, 0);
            zzcbpVarZza2.zzx(motionEventObtain);
            motionEventObtain.recycle();
            return;
        }
        if (str.equals("currentTime")) {
            String str7 = (String) map.get("time");
            if (str7 == null) {
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Time parameter missing from currentTime video GMSG.");
                return;
            }
            try {
                zzcbpVarZza2.zzw((int) (Float.parseFloat(str7) * 1000.0f));
                return;
            } catch (NumberFormatException unused5) {
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not parse time parameter from currentTime video GMSG: ".concat(str7));
                return;
            }
        }
        if (str.equals("hide")) {
            zzcbpVarZza2.setVisibility(4);
            return;
        }
        if (str.equals("remove")) {
            zzcbpVarZza2.setVisibility(8);
            return;
        }
        if (str.equals("load")) {
            zzcbpVarZza2.zzr(numValueOf2);
            return;
        }
        if (str.equals("loadControl")) {
            zzc(zzcbpVarZza2, map);
            return;
        }
        if (str.equals("muted")) {
            if (Boolean.parseBoolean((String) map.get("muted"))) {
                zzcbpVarZza2.zzs();
                return;
            } else {
                zzcbpVarZza2.zzI();
                return;
            }
        }
        if (str.equals("pause")) {
            zzcbpVarZza2.zzu();
            return;
        }
        if (str.equals("play")) {
            zzcbpVarZza2.zzv();
            return;
        }
        if (str.equals("show")) {
            zzcbpVarZza2.setVisibility(0);
            return;
        }
        String str8 = RDFWIi.HfOfTxsw;
        if (!str.equals(str8)) {
            if (str.equals("touchMove")) {
                Context context3 = zzccbVar.getContext();
                zzcbpVarZza2.zzH(zzb(context3, map, "dx", 0), zzb(context3, map, "dy", 0));
                if (this.zza) {
                    return;
                }
                zzccbVar.zzdi();
                this.zza = true;
                return;
            }
            if (!str.equals("volume")) {
                if (str.equals("watermark")) {
                    zzcbpVarZza2.zzp();
                    return;
                } else {
                    com.google.android.gms.ads.internal.util.client.zzo.zzj(DYYbQc.RCkzUtTYLW.concat(str));
                    return;
                }
            }
            String str9 = (String) map.get("volume");
            if (str9 == null) {
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Level parameter missing from volume video GMSG.");
                return;
            }
            try {
                zzcbpVarZza2.zzG(Float.parseFloat(str9));
                return;
            } catch (NumberFormatException unused6) {
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not parse volume parameter from volume video GMSG: ".concat(str9));
                return;
            }
        }
        String str10 = (String) map.get(str8);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzcn)).booleanValue() && TextUtils.isEmpty(str10)) {
            com.google.android.gms.ads.internal.util.client.zzo.zzj(ehgOP.UMXwOHo);
            return;
        }
        if (map.containsKey("periodicReportIntervalMs")) {
            try {
                numValueOf = Integer.valueOf(Integer.parseInt((String) map.get("periodicReportIntervalMs")));
            } catch (NumberFormatException unused7) {
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Video gmsg invalid numeric parameter 'periodicReportIntervalMs': ".concat(String.valueOf((String) map.get("periodicReportIntervalMs"))));
                numValueOf = null;
            }
        } else {
            numValueOf = null;
        }
        String[] strArr = {str10};
        String str11 = (String) map.get(iafHZUfOuHNwvy.kPqvkeeJCgDqH);
        if (str11 != null) {
            try {
                JSONArray jSONArray = new JSONArray(str11);
                ArrayList arrayList = new ArrayList();
                for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                    String string = jSONArray.getString(i5);
                    if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzcn)).booleanValue() || !TextUtils.isEmpty(string)) {
                        arrayList.add(string);
                    }
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzcn)).booleanValue() && arrayList.isEmpty()) {
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("All demuxed URLs are empty for playback: " + str11);
                    return;
                }
                strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
            } catch (JSONException unused8) {
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Malformed demuxed URL list for playback: ".concat(str11));
                strArr = new String[]{str10};
            }
        }
        if (numValueOf != null) {
            zzccbVar.zzA(numValueOf.intValue());
        }
        zzcbpVarZza2.zzE(str10, strArr);
    }
}
