package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzbyq {
    public static Uri zza(String str, String str2, String str3) {
        int iIndexOf = str.indexOf("&adurl");
        if (iIndexOf == -1) {
            iIndexOf = str.indexOf("?adurl");
        }
        if (iIndexOf == -1) {
            return Uri.parse(str).buildUpon().appendQueryParameter(str2, str3).build();
        }
        int i = iIndexOf + 1;
        return Uri.parse(str.substring(0, i) + str2 + "=" + str3 + "&" + str.substring(i));
    }

    public static String zzb(Uri uri, Context context, Map map) {
        com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
        if (!zzvVar.zzB.zzp(context)) {
            return uri.toString();
        }
        String strZzb = zzvVar.zzB.zzb(context);
        if (strZzb == null) {
            return uri.toString();
        }
        zzbcv zzbcvVar = zzbde.zzay;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        String str = (String) zzbdVar.zzd.zzb(zzbcvVar);
        String string = uri.toString();
        if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzax)).booleanValue() && string.contains(str)) {
            zzvVar.zzB.zzj(context, strZzb, (Map) map.get("_ac"));
            return zzd(string, context).replace(str, strZzb);
        }
        if (!TextUtils.isEmpty(uri.getQueryParameter("fbs_aeid"))) {
            return string;
        }
        if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzaw)).booleanValue()) {
            return string;
        }
        String string2 = zza(zzd(string, context), "fbs_aeid", strZzb).toString();
        zzvVar.zzB.zzj(context, strZzb, (Map) map.get("_ac"));
        return string2;
    }

    public static String zzc(String str, Context context, boolean z, Map map) {
        zzbyo zzbyoVar;
        String strZzb;
        zzbcv zzbcvVar = zzbde.zzaF;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue() && !z) {
            return str;
        }
        com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
        if (!zzvVar.zzB.zzp(context) || TextUtils.isEmpty(str) || (strZzb = (zzbyoVar = zzvVar.zzB).zzb(context)) == null) {
            return str;
        }
        zzbcv zzbcvVar2 = zzbde.zzay;
        zzbdc zzbdcVar = zzbdVar.zzd;
        String str2 = (String) zzbdcVar.zzb(zzbcvVar2);
        boolean zBooleanValue = ((Boolean) zzbdcVar.zzb(zzbde.zzax)).booleanValue();
        com.google.android.gms.ads.internal.util.zzs zzsVar = zzvVar.zzd;
        if (zBooleanValue && str.contains(str2)) {
            zzsVar.getClass();
            if (com.google.android.gms.ads.internal.util.zzs.zzac(str, zzsVar.zzb, (String) zzbdVar.zzd.zzb(zzbde.zzau))) {
                zzbyoVar.zzj(context, strZzb, (Map) map.get("_ac"));
                return zzd(str, context).replace(str2, strZzb);
            }
            zzsVar.getClass();
            if (!com.google.android.gms.ads.internal.util.zzs.zzac(str, zzsVar.zzc, (String) zzbdVar.zzd.zzb(zzbde.zzav))) {
                return str;
            }
            zzbyoVar.zzk(context, strZzb, (Map) map.get("_ai"));
            return zzd(str, context).replace(str2, strZzb);
        }
        if (str.contains("fbs_aeid") || ((Boolean) zzbdcVar.zzb(zzbde.zzaw)).booleanValue()) {
            return str;
        }
        zzsVar.getClass();
        if (com.google.android.gms.ads.internal.util.zzs.zzac(str, zzsVar.zzb, (String) zzbdVar.zzd.zzb(zzbde.zzau))) {
            zzbyoVar.zzj(context, strZzb, (Map) map.get("_ac"));
            return zza(zzd(str, context), "fbs_aeid", strZzb).toString();
        }
        zzsVar.getClass();
        if (!com.google.android.gms.ads.internal.util.zzs.zzac(str, zzsVar.zzc, (String) zzbdVar.zzd.zzb(zzbde.zzav))) {
            return str;
        }
        zzbyoVar.zzk(context, strZzb, (Map) map.get("_ai"));
        return zza(zzd(str, context), "fbs_aeid", strZzb).toString();
    }

    private static String zzd(String str, Context context) {
        com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
        String strZze = zzvVar.zzB.zze(context);
        String strZzc = zzvVar.zzB.zzc(context);
        if (!str.contains("gmp_app_id") && !TextUtils.isEmpty(strZze)) {
            str = zza(str, "gmp_app_id", strZze).toString();
        }
        return (str.contains("fbs_aiid") || TextUtils.isEmpty(strZzc)) ? str : zza(str, "fbs_aiid", strZzc).toString();
    }
}
