package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.rewarded.zQ.yzwzcWHcnH;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import okio.AsyncTimeout;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdmc {
    private final Context zza;
    private final zzdli zzb;
    private final zzavu zzc;
    private final VersionInfoParcel zzd;
    private final com.google.android.gms.ads.internal.zza zze;
    private final zzbcc zzf;
    private final Executor zzg;
    private final zzbge zzh;
    private final zzdmu zzi;
    private final zzdpj zzj;
    private final ScheduledExecutorService zzk;
    private final zzdoe zzl;
    private final zzdsj zzm;
    private final zzfjy zzn;
    private final zzeca zzo;
    private final zzecl zzp;
    private final zzfda zzq;
    private final zzdsd zzr;

    public zzdmc(Context context, zzdli zzdliVar, zzavu zzavuVar, VersionInfoParcel versionInfoParcel, com.google.android.gms.ads.internal.zza zzaVar, zzbcc zzbccVar, Executor executor, zzfcw zzfcwVar, zzdmu zzdmuVar, zzdpj zzdpjVar, ScheduledExecutorService scheduledExecutorService, zzdsj zzdsjVar, zzfjy zzfjyVar, zzeca zzecaVar, zzdoe zzdoeVar, zzecl zzeclVar, zzfda zzfdaVar, zzdsd zzdsdVar) {
        this.zza = context;
        this.zzb = zzdliVar;
        this.zzc = zzavuVar;
        this.zzd = versionInfoParcel;
        this.zze = zzaVar;
        this.zzf = zzbccVar;
        this.zzg = executor;
        this.zzh = zzfcwVar.zzi;
        this.zzi = zzdmuVar;
        this.zzj = zzdpjVar;
        this.zzk = scheduledExecutorService;
        this.zzm = zzdsjVar;
        this.zzn = zzfjyVar;
        this.zzo = zzecaVar;
        this.zzl = zzdoeVar;
        this.zzp = zzeclVar;
        this.zzq = zzfdaVar;
        this.zzr = zzdsdVar;
    }

    public static /* synthetic */ zzbfz zza(zzdmc zzdmcVar, JSONObject jSONObject, List list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        String strOptString = jSONObject.optString(yzwzcWHcnH.TnuHmqnOVn);
        Integer numZzs = zzs(jSONObject, "bg_color");
        Integer numZzs2 = zzs(jSONObject, "text_color");
        int iOptInt = jSONObject.optInt("text_size", -1);
        boolean zOptBoolean = jSONObject.optBoolean("allow_pub_rendering");
        int iOptInt2 = jSONObject.optInt("animation_ms", 1000);
        return new zzbfz(strOptString, list, numZzs, numZzs2, iOptInt > 0 ? Integer.valueOf(iOptInt) : null, jSONObject.optInt("presentation_ms", 4000) + iOptInt2, zzdmcVar.zzh.zze, zOptBoolean);
    }

    public static ListenableFuture zzb(zzdmc zzdmcVar, String str, zzbya zzbyaVar, com.google.android.gms.ads.internal.zzb zzbVar, Object obj) throws zzcfs {
        zzcft zzcftVar = com.google.android.gms.ads.internal.zzv.zza.zze;
        Context context = zzdmcVar.zza;
        zzecl zzeclVar = zzdmcVar.zzp;
        zzcfg zzcfgVarZza = zzcft.zza(context, zzchd.zza(), "native-omid", false, false, zzdmcVar.zzc, null, zzdmcVar.zzd, null, null, zzdmcVar.zze, zzdmcVar.zzf, null, null, zzeclVar, zzdmcVar.zzq, zzdmcVar.zzm);
        final zzcaj zzcajVarZza = zzcaj.zza((Object) zzcfgVarZza);
        zzcfgVarZza.zzN().zzC(new zzcgw() { // from class: com.google.android.gms.internal.ads.zzdlt
            @Override // com.google.android.gms.internal.ads.zzcgw
            public final void zza(boolean z, int i, String str2, String str3) {
                zzcajVarZza.zzb();
            }
        });
        zzcfgVarZza.loadData(Base64.encodeToString(str.getBytes(), 1), "text/html", "base64");
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zznP)).booleanValue()) {
            if (zzbyaVar != null) {
                zzcfgVarZza.zzN().zzL(zzbyaVar);
            }
            zzcfgVarZza.zzN().zzD(zzbVar);
        }
        return zzcajVarZza;
    }

    public static ListenableFuture zzc(zzdmc zzdmcVar, com.google.android.gms.ads.internal.client.zzr zzrVar, zzfca zzfcaVar, zzfcd zzfcdVar, com.google.android.gms.ads.internal.zzb zzbVar, zzbya zzbyaVar, String str, String str2, Object obj) {
        zzcfg zzcfgVarZza = zzdmcVar.zzj.zza(zzrVar, zzfcaVar, zzfcdVar);
        final zzcaj zzcajVarZza = zzcaj.zza((Object) zzcfgVarZza);
        zzdob zzdobVarZzb = zzdmcVar.zzl.zzb();
        zzcgy zzcgyVarZzN = zzcfgVarZza.zzN();
        zzbcv zzbcvVar = zzbde.zznP;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        zzcgyVarZzN.zzX(zzdobVarZzb, zzdobVarZzb, zzdobVarZzb, zzdobVarZzb, zzdobVarZzb, false, null, !((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue() ? new com.google.android.gms.ads.internal.zzb(zzdmcVar.zza, null) : zzbVar, null, true != ((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue() ? null : zzbyaVar, zzdmcVar.zzo, zzdmcVar.zzn, zzdmcVar.zzm, null, zzdobVarZzb, null, null, null, null);
        zzcfgVarZza.zzag("/getNativeAdViewSignals", zzbke.zzs);
        zzcfgVarZza.zzag("/getNativeClickMeta", zzbke.zzt);
        zzcfgVarZza.zzN().zzG(true);
        zzcfgVarZza.zzN().zzC(new zzcgw() { // from class: com.google.android.gms.internal.ads.zzdly
            @Override // com.google.android.gms.internal.ads.zzcgw
            public final void zza(boolean z, int i, String str3, String str4) {
                zzcaj zzcajVar = zzcajVarZza;
                if (z) {
                    zzcajVar.zzb();
                    return;
                }
                zzcajVar.zzd(new zzehf(1, "Image Web View failed to load. Error code: " + i + ", Description: " + str3 + ", Failing URL: " + str4));
            }
        });
        zzcfgVarZza.zzae(str, str2, null);
        return zzcajVarZza;
    }

    public static final com.google.android.gms.ads.internal.client.zzfa zzk(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("mute");
        if (jSONObjectOptJSONObject2 == null || (jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject("default_reason")) == null) {
            return null;
        }
        return zzt(jSONObjectOptJSONObject);
    }

    public static final List zzl(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("mute");
        if (jSONObjectOptJSONObject == null) {
            return zzfyq.zzn();
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("reasons");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return zzfyq.zzn();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            com.google.android.gms.ads.internal.client.zzfa zzfaVarZzt = zzt(jSONArrayOptJSONArray.optJSONObject(i));
            if (zzfaVarZzt != null) {
                arrayList.add(zzfaVarZzt);
            }
        }
        return zzfyq.zzl(arrayList);
    }

    private final com.google.android.gms.ads.internal.client.zzr zzm(int i, int i2) {
        if (i == 0) {
            if (i2 == 0) {
                return com.google.android.gms.ads.internal.client.zzr.zzc();
            }
            i = 0;
        }
        return new com.google.android.gms.ads.internal.client.zzr(this.zza, new AdSize(i, i2));
    }

    private static ListenableFuture zzn(ListenableFuture listenableFuture, Object obj) {
        final Object obj2 = null;
        return zzgdn.zzf(listenableFuture, Exception.class, new zzgcu(obj2) { // from class: com.google.android.gms.internal.ads.zzdlu
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj3) {
                com.google.android.gms.ads.internal.util.zze.zzb("Error during loading assets.", (Exception) obj3);
                return zzgdn.zzh(null);
            }
        }, zzcaf.zzg);
    }

    private static ListenableFuture zzo(boolean z, final ListenableFuture listenableFuture, Object obj) {
        return z ? zzgdn.zzn(listenableFuture, new zzgcu() { // from class: com.google.android.gms.internal.ads.zzdlw
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj2) {
                return obj2 != null ? listenableFuture : zzgdn.zzg(new zzehf(1, "Retrieve required value in native ad response failed."));
            }
        }, zzcaf.zzg) : zzn(listenableFuture, null);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0052  */
    private final ListenableFuture zzp(JSONObject jSONObject, boolean z, zzdrr zzdrrVar) {
        HashMap map;
        if (jSONObject == null) {
            return zzgdn.zzh(null);
        }
        zzbcv zzbcvVar = zzbde.zzek;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            zzbcv zzbcvVar2 = zzbde.zzel;
            zzbdc zzbdcVar = zzbdVar.zzd;
            if (jSONObject.has((String) zzbdcVar.zzb(zzbcvVar2))) {
                HashMap map2 = new HashMap();
                for (String str : ((String) zzbdcVar.zzb(zzbde.zzem)).split(",")) {
                    try {
                        map2.put(str, jSONObject.getString(str));
                    } catch (JSONException unused) {
                    }
                }
                map = map2;
            } else {
                map = null;
            }
        } else {
            map = null;
        }
        final String strOptString = jSONObject.optString("url");
        if (TextUtils.isEmpty(strOptString) && map == null) {
            return zzgdn.zzh(null);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzcx)).booleanValue() && zzdrrVar != null) {
            CoroutineAdapterKt$$ExternalSyntheticLambda0.m(com.google.android.gms.ads.internal.zzv.zza.zzl, this.zzr.zza(), zzdrrVar.zza());
        }
        final double dOptDouble = jSONObject.optDouble("scale", 1.0d);
        boolean zOptBoolean = jSONObject.optBoolean("is_transparent", true);
        final int iOptInt = jSONObject.optInt("width", -1);
        final int iOptInt2 = jSONObject.optInt("height", -1);
        if (z || map != null) {
            return zzgdn.zzh(new zzbgc(null, Uri.parse(strOptString), dOptDouble, iOptInt, iOptInt2, map));
        }
        return zzo(jSONObject.optBoolean("require"), zzgdn.zzm(this.zzb.zzb(strOptString, dOptDouble, zOptBoolean), new zzfve() { // from class: com.google.android.gms.internal.ads.zzdls
            @Override // com.google.android.gms.internal.ads.zzfve
            public final Object apply(Object obj) {
                return new zzbgc(new BitmapDrawable(Resources.getSystem(), (Bitmap) obj), Uri.parse(strOptString), dOptDouble, iOptInt, iOptInt2, null);
            }
        }, this.zzg), null);
    }

    private final ListenableFuture zzq(JSONArray jSONArray, boolean z, boolean z2, zzdrr zzdrrVar) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return zzgdn.zzh(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        int length = z2 ? jSONArray.length() : 1;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzcx)).booleanValue()) {
            CoroutineAdapterKt$$ExternalSyntheticLambda0.m(com.google.android.gms.ads.internal.zzv.zza.zzl, this.zzr.zza(), zzdrrVar.zza());
        }
        for (int i = 0; i < length; i++) {
            arrayList.add(zzp(jSONArray.optJSONObject(i), z, null));
        }
        return zzgdn.zzm(zzgdn.zzd(arrayList), new zzfve() { // from class: com.google.android.gms.internal.ads.zzdlp
            @Override // com.google.android.gms.internal.ads.zzfve
            public final Object apply(Object obj) {
                ArrayList arrayList2 = new ArrayList();
                for (zzbgc zzbgcVar : (List) obj) {
                    if (zzbgcVar != null) {
                        arrayList2.add(zzbgcVar);
                    }
                }
                return arrayList2;
            }
        }, this.zzg);
    }

    private final ListenableFuture zzr(JSONObject jSONObject, zzfca zzfcaVar, zzfcd zzfcdVar, com.google.android.gms.ads.internal.zzb zzbVar, zzbya zzbyaVar) {
        final ListenableFuture listenableFutureZze = this.zzi.zze(jSONObject.optString("base_url"), jSONObject.optString("html"), zzfcaVar, zzfcdVar, zzm(jSONObject.optInt("width", 0), jSONObject.optInt("height", 0)), zzbVar, zzbyaVar);
        return zzgdn.zzn(listenableFutureZze, new zzgcu() { // from class: com.google.android.gms.internal.ads.zzdlv
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) throws zzehf {
                zzcfg zzcfgVar = (zzcfg) obj;
                if (zzcfgVar == null || zzcfgVar.zzq() == null) {
                    throw new zzehf(1, "Retrieve video view in html5 ad response failed.");
                }
                return listenableFutureZze;
            }
        }, zzcaf.zzg);
    }

    private static Integer zzs(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt("r"), jSONObject2.getInt("g"), jSONObject2.getInt("b")));
        } catch (JSONException unused) {
            return null;
        }
    }

    private static final com.google.android.gms.ads.internal.client.zzfa zzt(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString("reason");
        String strOptString2 = jSONObject.optString("ping_url");
        if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2)) {
            return null;
        }
        return new com.google.android.gms.ads.internal.client.zzfa(strOptString, strOptString2);
    }

    public final ListenableFuture zzd(JSONObject jSONObject, String str, zzdrr zzdrrVar) {
        final JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("attribution");
        if (jSONObjectOptJSONObject == null) {
            return zzgdn.zzh(null);
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("images");
        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("image");
        if (jSONArrayOptJSONArray == null && jSONObjectOptJSONObject2 != null) {
            jSONArrayOptJSONArray = new JSONArray();
            jSONArrayOptJSONArray.put(jSONObjectOptJSONObject2);
        }
        return zzo(jSONObjectOptJSONObject.optBoolean("require"), zzgdn.zzm(zzq(jSONArrayOptJSONArray, false, true, zzdrrVar), new zzfve() { // from class: com.google.android.gms.internal.ads.zzdlx
            @Override // com.google.android.gms.internal.ads.zzfve
            public final Object apply(Object obj) {
                return zzdmc.zza(this.zza, jSONObjectOptJSONObject, (List) obj);
            }
        }, this.zzg), null);
    }

    public final ListenableFuture zze(JSONObject jSONObject, String str, zzdrr zzdrrVar) {
        return zzp(jSONObject.optJSONObject(str), this.zzh.zzb, zzdrrVar);
    }

    public final ListenableFuture zzf(JSONObject jSONObject, String str, zzdrr zzdrrVar) {
        zzbge zzbgeVar = this.zzh;
        return zzq(jSONObject.optJSONArray("images"), zzbgeVar.zzb, zzbgeVar.zzd, zzdrrVar);
    }

    public final ListenableFuture zzg(JSONObject jSONObject, String str, final zzfca zzfcaVar, final zzfcd zzfcdVar, final com.google.android.gms.ads.internal.zzb zzbVar, final zzbya zzbyaVar) {
        zzbcv zzbcvVar = zzbde.zzkw;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (!((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            return zzgdn.zzh(null);
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("images");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return zzgdn.zzh(null);
        }
        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(0);
        if (jSONObjectOptJSONObject == null) {
            return zzgdn.zzh(null);
        }
        zzbcv zzbcvVar2 = zzbde.zzek;
        zzbdc zzbdcVar = zzbdVar.zzd;
        if (((Boolean) zzbdcVar.zzb(zzbcvVar2)).booleanValue() && jSONObjectOptJSONObject.has((String) zzbdcVar.zzb(zzbde.zzel))) {
            return zzgdn.zzh(null);
        }
        final String strOptString = jSONObjectOptJSONObject.optString("base_url");
        final String strOptString2 = jSONObjectOptJSONObject.optString("html");
        final com.google.android.gms.ads.internal.client.zzr zzrVarZzm = zzm(jSONObjectOptJSONObject.optInt("width", 0), jSONObjectOptJSONObject.optInt("height", 0));
        if (TextUtils.isEmpty(strOptString2)) {
            return zzgdn.zzh(null);
        }
        if (((Boolean) zzbdcVar.zzb(zzbde.zzcx)).booleanValue()) {
            CoroutineAdapterKt$$ExternalSyntheticLambda0.m(com.google.android.gms.ads.internal.zzv.zza.zzl, this.zzr.zza(), zzdrr.NATIVE_ASSETS_LOADING_IMAGE_COMPOSITION_START.zza());
        }
        final ListenableFuture listenableFutureZzn = zzgdn.zzn(zzgdn.zzh(null), new zzgcu() { // from class: com.google.android.gms.internal.ads.zzdlz
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return zzdmc.zzc(this.zza, zzrVarZzm, zzfcaVar, zzfcdVar, zzbVar, zzbyaVar, strOptString, strOptString2, obj);
            }
        }, zzcaf.zzf);
        return zzgdn.zzn(listenableFutureZzn, new zzgcu() { // from class: com.google.android.gms.internal.ads.zzdlq
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) throws zzehf {
                if (((zzcfg) obj) != null) {
                    return listenableFutureZzn;
                }
                throw new zzehf(1, "Retrieve Web View from image ad response failed.");
            }
        }, zzcaf.zzg);
    }

    public final ListenableFuture zzh(ListenableFuture listenableFuture) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzcx)).booleanValue()) {
            CoroutineAdapterKt$$ExternalSyntheticLambda0.m(com.google.android.gms.ads.internal.zzv.zza.zzl, this.zzr.zza(), zzdrr.NATIVE_ASSETS_LOADING_MEDIA_START.zza());
        }
        zzcak zzcakVar = new zzcak();
        zzgdn.zzr(listenableFuture, new zzdmb(this, zzcakVar), zzcaf.zzf);
        return zzcakVar;
    }

    public final ListenableFuture zzi(JSONObject jSONObject, final com.google.android.gms.ads.internal.zzb zzbVar, final zzbya zzbyaVar) {
        if (!jSONObject.optBoolean("enable_omid")) {
            return zzgdn.zzh(null);
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("omid_settings");
        if (jSONObjectOptJSONObject == null) {
            return zzgdn.zzh(null);
        }
        final String strOptString = jSONObjectOptJSONObject.optString("omid_html");
        if (TextUtils.isEmpty(strOptString)) {
            return zzgdn.zzh(null);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzcx)).booleanValue()) {
            CoroutineAdapterKt$$ExternalSyntheticLambda0.m(com.google.android.gms.ads.internal.zzv.zza.zzl, this.zzr.zza(), zzdrr.NATIVE_ASSETS_LOADING_OMID_START.zza());
        }
        return zzgdn.zzn(zzgdn.zzh(null), new zzgcu() { // from class: com.google.android.gms.internal.ads.zzdlr
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return zzdmc.zzb(this.zza, strOptString, zzbyaVar, zzbVar, obj);
            }
        }, zzcaf.zzf);
    }

    public final ListenableFuture zzj(JSONObject jSONObject, zzfca zzfcaVar, zzfcd zzfcdVar, com.google.android.gms.ads.internal.zzb zzbVar, zzbya zzbyaVar) {
        ListenableFuture listenableFutureZzd;
        String[] strArr = {"html_containers", "instream"};
        JSONObject jSONObjectZzn = AsyncTimeout.Companion.zzn(jSONObject, strArr);
        JSONObject jSONObjectOptJSONObject = jSONObjectZzn == null ? null : jSONObjectZzn.optJSONObject(strArr[1]);
        if (jSONObjectOptJSONObject != null) {
            return zzr(jSONObjectOptJSONObject, zzfcaVar, zzfcdVar, zzbVar, zzbyaVar);
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("video");
        if (jSONObjectOptJSONObject2 == null) {
            return zzgdn.zzh(null);
        }
        String strOptString = jSONObjectOptJSONObject2.optString("vast_xml");
        zzbcv zzbcvVar = zzbde.zzkv;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        boolean z = ((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue() && jSONObjectOptJSONObject2.has("html");
        if (!TextUtils.isEmpty(strOptString)) {
            if (!z) {
                listenableFutureZzd = this.zzi.zzd(jSONObjectOptJSONObject2, zzbVar, zzbyaVar);
            }
            return zzn(zzgdn.zzo(listenableFutureZzd, ((Integer) zzbdVar.zzd.zzb(zzbde.zzec)).intValue(), TimeUnit.SECONDS, this.zzk), null);
        }
        if (!z) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Required field 'vast_xml' or 'html' is missing");
            return zzgdn.zzh(null);
        }
        listenableFutureZzd = zzr(jSONObjectOptJSONObject2, zzfcaVar, zzfcdVar, zzbVar, zzbyaVar);
        return zzn(zzgdn.zzo(listenableFutureZzd, ((Integer) zzbdVar.zzd.zzb(zzbde.zzec)).intValue(), TimeUnit.SECONDS, this.zzk), null);
    }
}
