package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.appset.vSSa.iafHZUfOuHNwvy;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.gson.yWTz.kBfGXgdfpo;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;
import okhttp3.MediaType;
import okio.AsyncTimeout;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdyb {
    private static final Pattern zza = Pattern.compile("\\?");
    private final zzche zzb;
    private final Context zzc;
    private final VersionInfoParcel zzd;
    private final zzfcw zze;
    private final Executor zzf;
    private final ScheduledExecutorService zzg;
    private final String zzh;
    private final zzfhu zzi;
    private final zzdsd zzj;
    private final zzfjy zzk;
    private final zzcyy zzl;
    private final Object zzm = new Object();
    private String zzn;
    private List zzo;
    private Bundle zzp;
    private final zzbvy zzq;

    public zzdyb(zzche zzcheVar, Context context, VersionInfoParcel versionInfoParcel, zzfcw zzfcwVar, Executor executor, String str, zzfhu zzfhuVar, zzdsd zzdsdVar, zzbvy zzbvyVar, zzeag zzeagVar, ScheduledExecutorService scheduledExecutorService, zzfjy zzfjyVar, zzcyy zzcyyVar) {
        this.zzb = zzcheVar;
        this.zzc = context;
        this.zzd = versionInfoParcel;
        this.zze = zzfcwVar;
        this.zzf = executor;
        this.zzh = str;
        this.zzi = zzfhuVar;
        zzcheVar.zzw();
        this.zzj = zzdsdVar;
        this.zzq = zzbvyVar;
        this.zzg = scheduledExecutorService;
        this.zzk = zzfjyVar;
        this.zzl = zzcyyVar;
    }

    public static ListenableFuture zzb(zzdyb zzdybVar, List list, Exception exc) {
        zzehf zzehfVar;
        com.google.android.gms.ads.internal.zzv.zza.zzi.zzv(exc, "PreloadedLoader.getTypeTwoAdResponseString");
        if (exc instanceof TimeoutException) {
            zzehfVar = new zzehf(1, "Timed out waiting for ad response.");
        } else if (exc instanceof zzehf) {
            zzehfVar = (zzehf) exc;
        } else {
            zzehfVar = new zzehf(1, exc.getMessage() == null ? "Fetch failed." : exc.getMessage());
        }
        String message = zzehfVar.getMessage() == null ? "" : zzehfVar.getMessage();
        if (list != null && !list.isEmpty()) {
            String str = "0.6.0.0";
            if (!TextUtils.isEmpty(message)) {
                if (message.contains("Timed out waiting for ad response.")) {
                    message = "timeout";
                    str = "0.2.0.0";
                } else if (message.contains("Received HTTP error code from ad server:")) {
                    List listZzf = zzfwe.zzb(zzfva.zzc(':')).zzf(message);
                    if (listZzf.size() == 2) {
                        message = (String) listZzf.get(1);
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(zzfju.zzc(zzfju.zzc((String) it.next(), "@gw_adnetstatus@", str), "@error_code@", message));
            }
            zzdybVar.zzk.zze(arrayList, null);
        }
        return zzgdn.zzg(zzehfVar);
    }

    public static /* synthetic */ ListenableFuture zzc(zzdyb zzdybVar, JSONObject jSONObject) {
        zzfck zzfckVar = new zzfck(zzdybVar.zze);
        String string = jSONObject.toString();
        return zzgdn.zzh(new zzfcn(zzfckVar, zzfcm.zza(new StringReader(string), zzdybVar.zzp)));
    }

    public static ListenableFuture zzd(zzdyb zzdybVar, zzbom zzbomVar, JSONObject jSONObject) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzcs)).booleanValue()) {
            CoroutineAdapterKt$$ExternalSyntheticLambda0.m(com.google.android.gms.ads.internal.zzv.zza.zzl, zzdybVar.zzj.zza(), zzdrr.SCAR_PRELOADER_PROCESSING_DONE.zza());
        }
        return zzbomVar.zzb(jSONObject);
    }

    public static String zzf(zzdyb zzdybVar, zzead zzeadVar) throws zzehf {
        zzdybVar.zzi(zzdrr.RENDERING_ADSTRING_TYPE2_FETCH_START);
        int i = 0;
        int i2 = -1;
        while (true) {
            try {
                zzbcv zzbcvVar = zzbde.zzht;
                com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
                if (i >= ((Integer) zzbdVar.zzd.zzb(zzbcvVar)).intValue()) {
                    throw new zzehf(1, "Received HTTP error code from ad server:" + i2);
                }
                zzeae zzeaeVarZzb = new zzeaf(zzdybVar.zzc, zzdybVar.zzd.afmaVersion, zzdybVar.zzq, Binder.getCallingUid()).zza(zzeadVar);
                int i3 = zzeaeVarZzb.zza;
                if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzhu)).booleanValue()) {
                    zzdybVar.zzj.zzd("fr", String.valueOf(i));
                }
                if (i3 == 200) {
                    zzdybVar.zzi(zzdrr.RENDERING_ADSTRING_TYPE2_FETCH_END);
                    return zzeaeVarZzb.zzc;
                }
                i++;
                i2 = i3;
            } catch (Exception e) {
                throw new zzehf(1, e.getMessage() == null ? "Fetch failed." : e.getMessage(), e);
            }
        }
    }

    private final ListenableFuture zzg(String str, final String str2) {
        ListenableFuture listenableFutureZzh;
        String str3 = "";
        if (TextUtils.isEmpty(str)) {
            return zzgdn.zzg(new zzehf(15, "Invalid ad string."));
        }
        Context context = this.zzc;
        zzfhj zzfhjVarZza = zzfhi.zza(context, 11);
        zzfhjVarZza.zzi();
        zzbow zzbowVarZza = com.google.android.gms.ads.internal.zzv.zza.zzs.zza(context, this.zzd, this.zzb.zzy());
        zzboq zzboqVar = zzbot.zza;
        final zzbom zzbomVarZza = zzbowVarZza.zza("google.afma.response.normalize", zzboqVar, zzboqVar);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzhp)).booleanValue()) {
            try {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.zzn = jSONObject.optString("fetch_url", "");
                    this.zzo = AsyncTimeout.Companion.zzc(new JSONObject(jSONObject.optString("settings", "")).getJSONArray("nofill_urls"), null);
                } catch (JSONException unused) {
                    int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("Invalid ad response.");
                }
            } catch (JSONException unused2) {
            }
            String string = this.zzn;
            final List list = this.zzo;
            if (TextUtils.isEmpty(string)) {
                listenableFutureZzh = zzgdn.zzh(str);
                this.zzj.zzd("sst", "1");
            } else {
                this.zzj.zzd("sst", "2");
                zzbcv zzbcvVar = zzbde.zzhr;
                com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
                String str4 = (String) zzbdVar.zzd.zzb(zzbcvVar);
                zzbcv zzbcvVar2 = zzbde.zzhq;
                zzbdc zzbdcVar = zzbdVar.zzd;
                if (((Boolean) zzbdcVar.zzb(zzbcvVar2)).booleanValue()) {
                    List listZzf = zzfwe.zzc(zza).zzf(string);
                    if (listZzf.size() < 2) {
                        listenableFutureZzh = zzgdn.zzg(new zzehf(1, "Invalid fetch URL."));
                    } else {
                        str3 = (String) listZzf.get(1);
                        com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
                        string = Uri.parse(string).buildUpon().query(null).build().toString();
                        final zzead zzeadVar = new zzead(string, 60000, new HashMap(), str3.getBytes(StandardCharsets.UTF_8), str4, false);
                        listenableFutureZzh = (zzgde) zzgdn.zzf((zzgde) zzgdn.zzo(zzgde.zzw(zzcaf.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzdxy
                            @Override // java.util.concurrent.Callable
                            public final Object call() {
                                return zzdyb.zzf(this.zza, zzeadVar);
                            }
                        })), ((Integer) zzbdcVar.zzb(zzbde.zzhs)).intValue(), TimeUnit.MILLISECONDS, this.zzg), Exception.class, new zzgcu() { // from class: com.google.android.gms.internal.ads.zzdxz
                            @Override // com.google.android.gms.internal.ads.zzgcu
                            public final ListenableFuture zza(Object obj) {
                                return zzdyb.zzb(this.zza, list, (Exception) obj);
                            }
                        }, this.zzf);
                    }
                } else {
                    final zzead zzeadVar2 = new zzead(string, 60000, new HashMap(), str3.getBytes(StandardCharsets.UTF_8), str4, false);
                    listenableFutureZzh = (zzgde) zzgdn.zzf((zzgde) zzgdn.zzo(zzgde.zzw(zzcaf.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzdxy
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            return zzdyb.zzf(this.zza, zzeadVar2);
                        }
                    })), ((Integer) zzbdcVar.zzb(zzbde.zzhs)).intValue(), TimeUnit.MILLISECONDS, this.zzg), Exception.class, new zzgcu() { // from class: com.google.android.gms.internal.ads.zzdxz
                        @Override // com.google.android.gms.internal.ads.zzgcu
                        public final ListenableFuture zza(Object obj) {
                            return zzdyb.zzb(this.zza, list, (Exception) obj);
                        }
                    }, this.zzf);
                }
            }
        } else {
            listenableFutureZzh = zzgdn.zzh(str);
            this.zzj.zzd("sst", "1");
        }
        zzgcu zzgcuVar = new zzgcu(this) { // from class: com.google.android.gms.internal.ads.zzdxv
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) throws JSONException {
                String str5 = (String) obj;
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                JSONObject jSONObject4 = new JSONObject();
                String str6 = str2;
                try {
                    jSONObject4.put("headers", new JSONObject());
                    jSONObject4.put("body", str5);
                    jSONObject3.put("base_url", "");
                    jSONObject3.put("signals", new JSONObject(str6));
                    jSONObject2.put("request", jSONObject3);
                    jSONObject2.put("response", jSONObject4);
                    jSONObject2.put("flags", new JSONObject());
                    return zzgdn.zzh(jSONObject2);
                } catch (JSONException e) {
                    throw new JSONException("Preloaded loader: ".concat(String.valueOf(e.cause)));
                }
            }
        };
        Executor executor = this.zzf;
        ListenableFuture listenableFutureZzn = zzgdn.zzn(zzgdn.zzn(zzgdn.zzn(listenableFutureZzh, zzgcuVar, executor), new zzgcu() { // from class: com.google.android.gms.internal.ads.zzdxw
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return zzdyb.zzd(this.zza, zzbomVarZza, (JSONObject) obj);
            }
        }, executor), new zzgcu() { // from class: com.google.android.gms.internal.ads.zzdxx
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return zzdyb.zzc(this.zza, (JSONObject) obj);
            }
        }, executor);
        zzfht.zza(listenableFutureZzn, this.zzi, zzfhjVarZza);
        zzgdn.zzr(listenableFutureZzn, new zzdya(this), zzcaf.zzg);
        return listenableFutureZzn;
    }

    private final String zzh(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = jSONObject.getJSONArray("ad_types");
            if (jSONArray != null && "unknown".equals(jSONArray.getString(0))) {
                jSONObject.put("ad_types", new JSONArray().put(this.zzh));
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            String strConcat = "Failed to update the ad types for rendering. ".concat(e.toString());
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj(strConcat);
            return str;
        }
    }

    private final void zzi(zzdrr zzdrrVar) {
        Bundle bundleZza = this.zzj.zza();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzhu)).booleanValue()) {
            CoroutineAdapterKt$$ExternalSyntheticLambda0.m(com.google.android.gms.ads.internal.zzv.zza.zzl, bundleZza, zzdrrVar.zza());
        }
    }

    private static final String zzj(String str) {
        try {
            return new JSONObject(str).optString("request_id", "");
        } catch (JSONException unused) {
            return "";
        }
    }

    /* JADX WARN: Code duplicated, block: B:90:0x0228 A[Catch: all -> 0x00d6, TryCatch #5 {all -> 0x00d6, blocks: (B:21:0x007a, B:23:0x0096, B:25:0x009c, B:27:0x00a9, B:29:0x00c1, B:33:0x00ed, B:36:0x00f9, B:38:0x0101, B:40:0x0107, B:44:0x0110, B:55:0x014b, B:47:0x0122, B:54:0x0134, B:57:0x0150, B:32:0x00d9, B:58:0x0166, B:65:0x0180, B:68:0x0188, B:72:0x01ac, B:74:0x01c1, B:78:0x01e4, B:80:0x01f9, B:83:0x020d, B:85:0x0213, B:86:0x0220, B:88:0x0222, B:91:0x022b, B:90:0x0228, B:79:0x01ee, B:75:0x01d4, B:71:0x0196, B:62:0x016f, B:63:0x0174), top: B:121:0x007a, inners: #1 }] */
    public final ListenableFuture zze() {
        String strOptString;
        int i;
        List listAsList;
        String string;
        zzbcv zzbcvVar = zzbde.zzcs;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            this.zzp = this.zze.zzs;
            CoroutineAdapterKt$$ExternalSyntheticLambda0.m(com.google.android.gms.ads.internal.zzv.zza.zzl, this.zzj.zza(), zzdrr.SCAR_PRELOADER_READY.zza());
        }
        String strZzb = this.zze.zzd.zzx;
        if (!TextUtils.isEmpty(strZzb)) {
            String strZzj = zzj(strZzb);
            zzbcv zzbcvVar2 = zzbde.zzhl;
            if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar2)).booleanValue() && strZzj.isEmpty()) {
                int iLastIndexOf = strZzb.lastIndexOf("&request_id=");
                strZzj = iLastIndexOf != -1 ? strZzb.substring(iLastIndexOf + 12) : "";
            }
            if (TextUtils.isEmpty(strZzj)) {
                return zzgdn.zzg(new zzehf(15, "Invalid ad string."));
            }
            synchronized (this.zzm) {
                try {
                    com.google.android.gms.ads.nonagon.signalgeneration.zzv zzvVarZzn = this.zzb.zzn();
                    zzdsd zzdsdVar = this.zzj;
                    String strZzb2 = zzvVarZzn.zzb(strZzj, zzdsdVar);
                    String str = null;
                    if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar2)).booleanValue() && !TextUtils.isEmpty(strZzb2)) {
                        try {
                            JSONObject jSONObjectOptJSONObject = new JSONObject(strZzb2).optJSONObject("extras");
                            if (jSONObjectOptJSONObject != null) {
                                String strOptString2 = jSONObjectOptJSONObject.optString("query_info_type", "");
                                if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzhn)).booleanValue()) {
                                    listAsList = Arrays.asList(((String) zzbdVar.zzd.zzb(zzbde.zzho)).split(","));
                                } else {
                                    listAsList = Arrays.asList(((String) zzbdVar.zzd.zzb(zzbde.zzhm)).split(","));
                                }
                                if (listAsList.contains(MediaType.Companion.zzb(strOptString2))) {
                                    int iLastIndexOf2 = strZzb.lastIndexOf("&");
                                    String strSubstring = iLastIndexOf2 != -1 ? strZzb.substring(0, iLastIndexOf2) : null;
                                    if (!TextUtils.isEmpty(strSubstring)) {
                                        try {
                                            byte[] bArrDecode = Base64.decode(strSubstring, 11);
                                            byte[] bytes = strZzj.getBytes("UTF-8");
                                            if (TextUtils.isEmpty(strZzb2)) {
                                                string = null;
                                            } else {
                                                try {
                                                    string = new JSONObject(strZzb2).getString(iafHZUfOuHNwvy.uFyIc);
                                                } catch (JSONException e) {
                                                    com.google.android.gms.ads.internal.util.zze.zza("Failed to get key from QueryJSONMap".concat(e.toString()));
                                                    com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "CryptoUtils.getKeyFromQueryJsonMap");
                                                    string = null;
                                                }
                                            }
                                            strZzb = zzfdl.zzb(bArrDecode, bytes, string, zzdsdVar);
                                        } catch (UnsupportedEncodingException | IllegalArgumentException e2) {
                                            com.google.android.gms.ads.internal.util.zze.zza("Failed to decode the adResponse. ".concat(e2.toString()));
                                            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e2, "PreloadedLoader.decryptAdResponseIfNecessary");
                                        }
                                    }
                                }
                            }
                        } catch (JSONException unused) {
                        }
                    }
                    if (TextUtils.isEmpty(strZzb)) {
                        strOptString = "";
                    } else {
                        try {
                            strOptString = new JSONObject(strZzb).optString("render_id", iafHZUfOuHNwvy.FIiz);
                        } catch (JSONException unused2) {
                            strOptString = "";
                        }
                    }
                    if (TextUtils.isEmpty(strOptString)) {
                        i = 0;
                    } else {
                        String str2 = "";
                        try {
                            str2 = new String(Base64.decode(strOptString, 0), StandardCharsets.UTF_8);
                        } catch (IllegalArgumentException e3) {
                            com.google.android.gms.ads.internal.util.zze.zza("Ad grouping: Has render_id, but not base64 encoded: ".concat(String.valueOf(strOptString)));
                            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e3, "PreloadedLoader.decodeRenderId");
                        }
                        List listZzf = zzfwe.zzb(zzfva.zzc(':')).zzf(str2);
                        if (listZzf.size() == 2) {
                            str = (String) listZzf.get(0);
                            i = Integer.parseInt((String) listZzf.get(1));
                        } else {
                            com.google.android.gms.ads.internal.util.zze.zza("Ad grouping: Has render_id, but invalid format: ".concat(String.valueOf(strOptString)));
                            i = 0;
                        }
                    }
                    Pair pair = str != null ? new Pair(str, Integer.valueOf(i)) : new Pair("", 0);
                    String str3 = (String) pair.first;
                    int iIntValue = ((Integer) pair.second).intValue();
                    if (TextUtils.isEmpty(str3) || iIntValue <= 0) {
                        zzvVarZzn.zzf(strZzj);
                    } else {
                        if (zzvVarZzn.zzh(strZzj, str3)) {
                            return zzgdn.zzg(new zzehf(10, "The ad has already been shown."));
                        }
                        if (!zzvVarZzn.zzg(iIntValue, strZzj, str3)) {
                            zzvVarZzn.zzf(strZzj);
                        }
                    }
                    if (!TextUtils.isEmpty(strZzb2)) {
                        return zzg(strZzb, zzh(strZzb2));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        com.google.android.gms.ads.internal.client.zzc zzcVar = this.zze.zzd.zzs;
        if (zzcVar != null) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzhd)).booleanValue()) {
                String str4 = zzcVar.zza;
                String str5 = zzcVar.zzb;
                String strZzj2 = zzj(str4);
                String strZzj3 = zzj(str5);
                if (TextUtils.isEmpty(strZzj3) || !strZzj2.equals(strZzj3)) {
                    this.zzj.zzb().put(kBfGXgdfpo.oUqU, "true");
                } else {
                    this.zzb.zzn().zzf(strZzj2);
                    this.zzj.zzb().put("request_id", strZzj2);
                }
            }
            return zzg(zzcVar.zza, zzh(zzcVar.zzb));
        }
        return zzgdn.zzg(new zzehf(14, "Mismatch request IDs."));
    }
}
