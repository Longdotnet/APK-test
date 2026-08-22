package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.appevents.suggestedevents.naLU.DaWYVMJ;
import com.google.common.util.concurrent.ListenableFuture;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbke {
    public static final zzbkf zza = new zzbkf() { // from class: com.google.android.gms.internal.ads.zzbjc
        @Override // com.google.android.gms.internal.ads.zzbkf
        public final void zza(Object obj, Map map) {
            zzcgn zzcgnVar = (zzcgn) obj;
            zzbkf zzbkfVar = zzbke.zza;
            String str = (String) map.get("urls");
            if (TextUtils.isEmpty(str)) {
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("URLs missing in canOpenURLs GMSG.");
                return;
            }
            String[] strArrSplit = str.split(",");
            HashMap map2 = new HashMap();
            PackageManager packageManager = zzcgnVar.getContext().getPackageManager();
            for (String str2 : strArrSplit) {
                String[] strArrSplit2 = str2.split(";", 2);
                Boolean boolValueOf = Boolean.valueOf(packageManager.resolveActivity(new Intent(strArrSplit2.length > 1 ? strArrSplit2[1].trim() : "android.intent.action.VIEW", Uri.parse(strArrSplit2[0].trim())), 65536) != null);
                map2.put(str2, boolValueOf);
                com.google.android.gms.ads.internal.util.zze.zza("/canOpenURLs;" + str2 + ";" + boolValueOf);
            }
            ((zzbna) zzcgnVar).zzd("openableURLs", map2);
        }
    };
    public static final zzbkf zzb = new zzbkf() { // from class: com.google.android.gms.internal.ads.zzbje
        @Override // com.google.android.gms.internal.ads.zzbkf
        public final void zza(Object obj, Map map) {
            zzcgn zzcgnVar = (zzcgn) obj;
            zzbkf zzbkfVar = zzbke.zza;
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zziE)).booleanValue()) {
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("canOpenAppGmsgHandler disabled.");
                return;
            }
            String str = (String) map.get("package_name");
            if (TextUtils.isEmpty(str)) {
                int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Package name missing in canOpenApp GMSG.");
                return;
            }
            HashMap map2 = new HashMap();
            Boolean boolValueOf = Boolean.valueOf(zzcgnVar.getContext().getPackageManager().getLaunchIntentForPackage(str) != null);
            map2.put(str, boolValueOf);
            com.google.android.gms.ads.internal.util.zze.zza("/canOpenApp;" + str + ";" + boolValueOf);
            ((zzbna) zzcgnVar).zzd("openableApp", map2);
        }
    };
    public static final zzbkf zzc = new zzbkf() { // from class: com.google.android.gms.internal.ads.zzbjh
        @Override // com.google.android.gms.internal.ads.zzbkf
        public final void zza(Object obj, Map map) {
            zzbke.zzb((zzcgn) obj, map);
        }
    };
    public static final zzbkf zzd = new zzbjw();
    public static final zzbkf zze = new zzbjx();
    public static final zzbkf zzf = new zzbkf() { // from class: com.google.android.gms.internal.ads.zzbji
        @Override // com.google.android.gms.internal.ads.zzbkf
        public final void zza(Object obj, Map map) {
            zzcgn zzcgnVar = (zzcgn) obj;
            zzbkf zzbkfVar = zzbke.zza;
            String str = (String) map.get("u");
            if (str == null) {
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("URL missing from httpTrack GMSG.");
            } else {
                zzcex zzcexVar = (zzcex) zzcgnVar;
                new com.google.android.gms.ads.internal.util.zzbw(zzcgnVar.getContext(), ((zzcgu) zzcgnVar).zzm().afmaVersion, str, zzcexVar.zzD() != null ? zzcexVar.zzD().zzax : null).zzb();
            }
        }
    };
    public static final zzbkf zzg = new zzbjy();
    public static final zzbkf zzh = new zzbjz();
    public static final zzbkf zzi = new zzbkf() { // from class: com.google.android.gms.internal.ads.zzbjf
        @Override // com.google.android.gms.internal.ads.zzbkf
        public final void zza(Object obj, Map map) {
            zzcgt zzcgtVar = (zzcgt) obj;
            zzbkf zzbkfVar = zzbke.zza;
            String str = (String) map.get("tx");
            String str2 = (String) map.get("ty");
            String str3 = (String) map.get("td");
            try {
                int i = Integer.parseInt(str);
                int i2 = Integer.parseInt(str2);
                int i3 = Integer.parseInt(str3);
                zzavu zzavuVarZzI = zzcgtVar.zzI();
                if (zzavuVarZzI != null) {
                    zzavuVarZzI.zzc().zzl(i, i2, i3);
                }
            } catch (NumberFormatException unused) {
                int i4 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not parse touch parameters from gmsg.");
            }
        }
    };
    public static final zzbkf zzj = new zzbka();
    public static final zzbkf zzk = new zzbkb();
    public static final zzbkf zzl = new zzcdb();
    public static final zzbkf zzm = new zzcdc();
    public static final zzbkf zzn = new zzbiy();
    public static final zzbkv zzo = new zzbkv();
    public static final zzbkf zzp = new zzbkc();
    public static final zzbkf zzq = new zzbkd();
    public static final zzbkf zzr = new zzbjj();
    public static final zzbkf zzs = new zzbjk();
    public static final zzbkf zzt = new zzbjl();
    public static final zzbkf zzu = new zzbjm();
    public static final zzbkf zzv = new zzbjn();
    public static final zzbkf zzw = new zzbjo();
    public static final zzbkf zzx = new zzbjp();
    public static final zzbkf zzy = new zzbjq();
    public static final zzbkf zzz = new zzbjr();
    public static final zzbkf zzA = new zzbjs();
    public static final zzbkf zzB = new zzbju();
    public static final zzbkf zzC = new zzbjv();

    public static ListenableFuture zza(zzcfg zzcfgVar, String str) {
        Uri uriZza = Uri.parse(str);
        try {
            zzavu zzavuVarZzI = zzcfgVar.zzI();
            zzfda zzfdaVarZzS = zzcfgVar.zzS();
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzmu)).booleanValue() || zzfdaVarZzS == null) {
                if (zzavuVarZzI != null && zzavuVarZzI.zzf(uriZza)) {
                    uriZza = zzavuVarZzI.zza(uriZza, zzcfgVar.getContext(), zzcfgVar.zzF(), zzcfgVar.zzi());
                }
            } else if (zzavuVarZzI != null && zzavuVarZzI.zzf(uriZza)) {
                uriZza = zzfdaVarZzS.zza(uriZza, zzcfgVar.getContext(), zzcfgVar.zzF(), zzcfgVar.zzi());
            }
        } catch (zzavv unused) {
            String strConcat = "Unable to append parameter to URL: ".concat(str);
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj(strConcat);
        }
        Map map = new HashMap();
        if (zzcfgVar.zzD() != null) {
            map = zzcfgVar.zzD().zzaw;
        }
        final String strZzb = zzbyq.zzb(uriZza, zzcfgVar.getContext(), map);
        long jLongValue = ((Long) zzbfd.zze.zze()).longValue();
        if (jLongValue <= 0 || jLongValue > 252530000) {
            return zzgdn.zzh(strZzb);
        }
        zzgde zzgdeVarZzw = zzgde.zzw(zzcfgVar.zzT());
        zzfve zzfveVar = new zzfve() { // from class: com.google.android.gms.internal.ads.zzbiz
            @Override // com.google.android.gms.internal.ads.zzfve
            public final Object apply(Object obj) {
                Throwable th = (Throwable) obj;
                zzbkf zzbkfVar = zzbke.zza;
                if (!((Boolean) zzbfd.zzi.zze()).booleanValue()) {
                    return "failure_click_attok";
                }
                com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(th, "prepareClickUrl.attestation1");
                return "failure_click_attok";
            }
        };
        zzgdy zzgdyVar = zzcaf.zzg;
        return (zzgde) zzgdn.zze((zzgde) zzgdn.zzm((zzgde) zzgdn.zze(zzgdeVarZzw, Throwable.class, zzfveVar, zzgdyVar), new zzfve() { // from class: com.google.android.gms.internal.ads.zzbja
            /* JADX WARN: Code duplicated, block: B:16:0x004f  */
            /* JADX WARN: Code duplicated, block: B:19:0x0059  */
            /* JADX WARN: Code duplicated, block: B:21:0x0067  */
            @Override // com.google.android.gms.internal.ads.zzfve
            public final Object apply(Object obj) {
                String str2;
                String str3;
                Uri uri;
                String str4 = (String) obj;
                zzbkf zzbkfVar = zzbke.zza;
                String strReplace = strZzb;
                if (str4 != null) {
                    if (((Boolean) zzbfd.zzf.zze()).booleanValue()) {
                        String[] strArr = {".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
                        String host = Uri.parse(strReplace).getHost();
                        for (int i2 = 0; i2 < 3; i2++) {
                            if (host.endsWith(strArr[i2])) {
                                str2 = (String) zzbfd.zza.zze();
                                str3 = (String) zzbfd.zzb.zze();
                                if (!TextUtils.isEmpty(str2)) {
                                    strReplace = strReplace.replace(str2, str4);
                                }
                                if (!TextUtils.isEmpty(str3)) {
                                    uri = Uri.parse(strReplace);
                                    if (!TextUtils.isEmpty(uri.getQueryParameter(str3))) {
                                        break;
                                    }
                                    return uri.buildUpon().appendQueryParameter(str3, str4).toString();
                                }
                                break;
                            }
                        }
                    } else {
                        str2 = (String) zzbfd.zza.zze();
                        str3 = (String) zzbfd.zzb.zze();
                        if (!TextUtils.isEmpty(str2)) {
                            strReplace = strReplace.replace(str2, str4);
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            uri = Uri.parse(strReplace);
                            if (!TextUtils.isEmpty(uri.getQueryParameter(str3))) {
                                return uri.buildUpon().appendQueryParameter(str3, str4).toString();
                            }
                        }
                    }
                }
                return strReplace;
            }
        }, zzgdyVar), Throwable.class, new zzfve() { // from class: com.google.android.gms.internal.ads.zzbjb
            @Override // com.google.android.gms.internal.ads.zzfve
            public final Object apply(Object obj) {
                Throwable th = (Throwable) obj;
                zzbkf zzbkfVar = zzbke.zza;
                if (((Boolean) zzbfd.zzi.zze()).booleanValue()) {
                    com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(th, "prepareClickUrl.attestation2");
                }
                return strZzb;
            }
        }, zzgdyVar);
    }

    public static void zzb(zzcgn zzcgnVar, Map map) {
        Intent uri;
        ResolveInfo resolveInfoResolveActivity;
        PackageManager packageManager = zzcgnVar.getContext().getPackageManager();
        try {
            try {
                JSONArray jSONArray = new JSONObject((String) map.get("data")).getJSONArray("intents");
                JSONObject jSONObject = new JSONObject();
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        String strOptString = jSONObject2.optString("id");
                        String strOptString2 = jSONObject2.optString("u");
                        String strOptString3 = jSONObject2.optString("i");
                        String strOptString4 = jSONObject2.optString("m");
                        String strOptString5 = jSONObject2.optString("p");
                        String strOptString6 = jSONObject2.optString("c");
                        String strOptString7 = jSONObject2.optString("intent_url");
                        if (TextUtils.isEmpty(strOptString7)) {
                            uri = null;
                        } else {
                            try {
                                uri = Intent.parseUri(strOptString7, 0);
                            } catch (URISyntaxException e) {
                                String strValueOf = String.valueOf(strOptString7);
                                int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                                com.google.android.gms.ads.internal.util.client.zzo.zzh("Error parsing the url: ".concat(strValueOf), e);
                                uri = null;
                            }
                        }
                        if (uri == null) {
                            uri = new Intent();
                            if (!TextUtils.isEmpty(strOptString2)) {
                                uri.setData(Uri.parse(strOptString2));
                            }
                            if (!TextUtils.isEmpty(strOptString3)) {
                                uri.setAction(strOptString3);
                            }
                            if (!TextUtils.isEmpty(strOptString4)) {
                                uri.setType(strOptString4);
                            }
                            if (!TextUtils.isEmpty(strOptString5)) {
                                uri.setPackage(strOptString5);
                            }
                            if (!TextUtils.isEmpty(strOptString6)) {
                                String[] strArrSplit = strOptString6.split("/", 2);
                                if (strArrSplit.length == 2) {
                                    uri.setComponent(new ComponentName(strArrSplit[0], strArrSplit[1]));
                                }
                            }
                        }
                        Intent intent = uri;
                        try {
                            resolveInfoResolveActivity = packageManager.resolveActivity(intent, 65536);
                        } catch (NullPointerException e2) {
                            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e2, intent.toString());
                            resolveInfoResolveActivity = null;
                        }
                        try {
                            jSONObject.put(strOptString, resolveInfoResolveActivity != null);
                        } catch (JSONException e3) {
                            int i3 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                            com.google.android.gms.ads.internal.util.client.zzo.zzh("Error constructing openable urls response.", e3);
                        }
                    } catch (JSONException e4) {
                        int i4 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                        com.google.android.gms.ads.internal.util.client.zzo.zzh("Error parsing the intent data.", e4);
                    }
                }
                ((zzbna) zzcgnVar).zze("openableIntents", jSONObject);
            } catch (JSONException unused) {
                ((zzbna) zzcgnVar).zze("openableIntents", new JSONObject());
            }
        } catch (JSONException unused2) {
            ((zzbna) zzcgnVar).zze("openableIntents", new JSONObject());
        }
    }

    public static void zzc(Map map, zzded zzdedVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzlh)).booleanValue()) {
            String str = DaWYVMJ.ravTb;
            if (map.containsKey(str) && ((String) map.get(str)).equals("1") && zzdedVar != null) {
                zzdedVar.zzdf();
            }
        }
    }
}
