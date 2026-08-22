package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzeai implements zzfge {
    private static final Pattern zza = Pattern.compile("([^;]+=[^;]+)(;\\s|$)", 2);
    private final String zzb;
    private final zzfhj zzc;
    private final zzfhu zzd;

    public zzeai(String str, zzfhu zzfhuVar, zzfhj zzfhjVar) {
        this.zzb = str;
        this.zzd = zzfhuVar;
        this.zzc = zzfhjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfge
    public final Object zza(Object obj) throws zzdwm {
        zzdwm zzdwmVar;
        JSONObject jSONObject;
        String strConcat;
        zzeah zzeahVar = (zzeah) obj;
        int iOptInt = zzeahVar.zza.optInt("http_timeout_millis", 60000);
        zzbvs zzbvsVar = zzeahVar.zzb;
        String strJoin = "";
        if (zzbvsVar.zza() != -2) {
            if (zzbvsVar.zza() == 1) {
                if (zzbvsVar.zzh() != null) {
                    strJoin = TextUtils.join(", ", zzbvsVar.zzh());
                    int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zzg(strJoin);
                }
                zzdwmVar = new zzdwm(2, "Error building request URL: ".concat(String.valueOf(strJoin)));
            } else {
                zzdwmVar = new zzdwm(1);
            }
            zzfhu zzfhuVar = this.zzd;
            zzfhj zzfhjVar = this.zzc;
            zzfhjVar.zzh(zzdwmVar);
            zzfhjVar.zzg(false);
            zzfhuVar.zza(zzfhjVar);
            throw zzdwmVar;
        }
        HashMap map = new HashMap();
        if (zzeahVar.zzb.zzj()) {
            String str = this.zzb;
            if (!TextUtils.isEmpty(str)) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzbd)).booleanValue()) {
                    if (TextUtils.isEmpty(str)) {
                        strConcat = "";
                    } else {
                        Matcher matcher = zza.matcher(str);
                        strConcat = "";
                        while (matcher.find()) {
                            String strGroup = matcher.group(1);
                            if (strGroup != null) {
                                Locale locale = Locale.ROOT;
                                if (strGroup.toLowerCase(locale).startsWith("id=") || strGroup.toLowerCase(locale).startsWith("ide=")) {
                                    if (!TextUtils.isEmpty(strConcat)) {
                                        strConcat = strConcat.concat("; ");
                                    }
                                    strConcat = strConcat.concat(strGroup);
                                }
                            }
                        }
                    }
                    if (!TextUtils.isEmpty(strConcat)) {
                        map.put("Cookie", strConcat);
                    }
                } else {
                    map.put("Cookie", str);
                }
            }
        }
        if (zzeahVar.zzb.zzk() && (jSONObject = zzeahVar.zza) != null) {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("pii");
            if (jSONObjectOptJSONObject != null) {
                if (!TextUtils.isEmpty(jSONObjectOptJSONObject.optString("doritos", ""))) {
                    map.put("x-afma-drt-cookie", jSONObjectOptJSONObject.optString("doritos", ""));
                }
                if (!TextUtils.isEmpty(jSONObjectOptJSONObject.optString("doritos_v2", ""))) {
                    map.put("x-afma-drt-v2-cookie", jSONObjectOptJSONObject.optString("doritos_v2", ""));
                }
            } else {
                com.google.android.gms.ads.internal.util.zze.zza("DSID signal does not exist.");
            }
        }
        if (zzeahVar.zzb != null && !TextUtils.isEmpty(zzeahVar.zzb.zzf())) {
            strJoin = zzeahVar.zzb.zzf();
        }
        zzfhu zzfhuVar2 = this.zzd;
        zzfhj zzfhjVar2 = this.zzc;
        zzfhjVar2.zzg(true);
        zzfhuVar2.zza(zzfhjVar2);
        return new zzead(zzeahVar.zzb.zzg(), iOptInt, map, strJoin.getBytes(StandardCharsets.UTF_8), "", zzeahVar.zzb.zzk());
    }
}
