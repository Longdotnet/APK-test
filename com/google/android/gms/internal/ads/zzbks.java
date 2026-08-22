package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.widget.AppCompatTextHelper;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzbks implements zzbkf {
    private final zzdwf zza;

    public zzbks(zzdwf zzdwfVar) {
        this.zza = zzdwfVar;
    }

    private static final Bundle zzb(Map map) {
        Bundle bundle = new Bundle();
        bundle.putString("request_origin", "inspector_ooct");
        if (map.containsKey("networkExtras")) {
            try {
                JSONObject jSONObject = new JSONObject((String) map.get("networkExtras"));
                Iterator itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String str = (String) itKeys.next();
                    Object obj = jSONObject.get(str);
                    if (obj instanceof String) {
                        bundle.putString(str, (String) obj);
                    } else if (obj instanceof Integer) {
                        bundle.putInt(str, ((Integer) obj).intValue());
                    } else if (obj instanceof Boolean) {
                        bundle.putBoolean(str, ((Boolean) obj).booleanValue());
                    } else if (obj instanceof Float) {
                        bundle.putFloat(str, ((Float) obj).floatValue());
                    } else if (obj instanceof Double) {
                        bundle.putDouble(str, ((Double) obj).doubleValue());
                    } else if (obj instanceof Long) {
                        bundle.putLong(str, ((Long) obj).longValue());
                    }
                }
            } catch (JSONException e) {
                com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "OutOfContextTestingGmsgHandler.generateNetworkExtras");
            }
        }
        return bundle;
    }

    private static final List zzc(String str, String str2) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.getString(i));
            }
            return arrayList;
        } catch (JSONException e) {
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "OutOfContextTestingGmsgHandler.stringArrayToList.".concat(str2));
            return new ArrayList();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbkf
    public final void zza(Object obj, Map map) {
        AdRequest adRequest;
        AdSize adSize;
        zzbcv zzbcvVar = zzbde.zzjN;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            zzdwg zzdwgVar = new zzdwg();
            String str = (String) map.get("adUnitId");
            if (!TextUtils.isEmpty(str)) {
                zzdwgVar.zzi(str);
            }
            String str2 = (String) map.get("format");
            if (!TextUtils.isEmpty(str2)) {
                zzdwgVar.zzj(str2);
            }
            if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzjP)).booleanValue()) {
                zzdwgVar.zzk(map.containsKey("isGamRequest") && ((String) map.get("isGamRequest")).equals("1"));
                if (zzdwgVar.zzn()) {
                    AdManagerAdRequest.Builder builder = new AdManagerAdRequest.Builder();
                    boolean zContainsKey = map.containsKey("keywords");
                    AppCompatTextHelper appCompatTextHelper = (AppCompatTextHelper) builder.mBuilder;
                    if (zContainsKey) {
                        Iterator it = zzc((String) map.get("keywords"), "keywords").iterator();
                        while (it.hasNext()) {
                            ((HashSet) appCompatTextHelper.mView).add((String) it.next());
                        }
                    }
                    builder.addNetworkExtrasBundle(zzb(map));
                    if (map.containsKey("customTargeting")) {
                        try {
                            JSONObject jSONObject = new JSONObject((String) map.get("customTargeting"));
                            Iterator itKeys = jSONObject.keys();
                            while (itKeys.hasNext()) {
                                String str3 = (String) itKeys.next();
                                builder.addCustomTargeting(str3, jSONObject.getString(str3));
                            }
                        } catch (JSONException e) {
                            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "OutOfContextTestingGmsgHandler.generateAdManagerAdRequest");
                        }
                    }
                    if (map.containsKey("contentUrl")) {
                        builder.setContentUrl((String) map.get("contentUrl"));
                    }
                    if (map.containsKey("neighboringContentUrlStrings")) {
                        builder.setNeighboringContentUrls(zzc((String) map.get("neighboringContentUrlStrings"), "neighboringContentUrlStrings"));
                    }
                    if (map.containsKey("requestAgent")) {
                        appCompatTextHelper.mFontTypeface = (String) map.get("requestAgent");
                    }
                    if (map.containsKey("publisherProvidedId")) {
                        appCompatTextHelper.mAutoSizeTextHelper = (String) map.get("publisherProvidedId");
                    }
                    if (map.containsKey("categoryExclusions")) {
                        Iterator it2 = zzc((String) map.get("categoryExclusions"), "categoryExclusions").iterator();
                        while (it2.hasNext()) {
                            ((HashSet) appCompatTextHelper.mDrawableStartTint).add((String) it2.next());
                        }
                    }
                    adRequest = new AdManagerAdRequest(builder);
                } else {
                    AdRequest.Builder builder2 = new AdRequest.Builder();
                    boolean zContainsKey2 = map.containsKey("keywords");
                    AppCompatTextHelper appCompatTextHelper2 = (AppCompatTextHelper) builder2.mBuilder;
                    if (zContainsKey2) {
                        Iterator it3 = zzc((String) map.get("keywords"), "keywords").iterator();
                        while (it3.hasNext()) {
                            ((HashSet) appCompatTextHelper2.mView).add((String) it3.next());
                        }
                    }
                    builder2.addNetworkExtrasBundle(zzb(map));
                    if (map.containsKey("customTargeting")) {
                        try {
                            JSONObject jSONObject2 = new JSONObject((String) map.get("customTargeting"));
                            Iterator itKeys2 = jSONObject2.keys();
                            while (itKeys2.hasNext()) {
                                String str4 = (String) itKeys2.next();
                                builder2.addCustomTargeting(str4, jSONObject2.getString(str4));
                            }
                        } catch (JSONException e2) {
                            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e2, "OutOfContextTestingGmsgHandler.generateAdMobAdRequest");
                        }
                    }
                    if (map.containsKey("contentUrl")) {
                        builder2.setContentUrl((String) map.get("contentUrl"));
                    }
                    if (map.containsKey("neighboringContentUrlStrings")) {
                        builder2.setNeighboringContentUrls(zzc((String) map.get("neighboringContentUrlStrings"), "neighboringContentUrlStrings"));
                    }
                    if (map.containsKey("requestAgent")) {
                        appCompatTextHelper2.mFontTypeface = (String) map.get("requestAgent");
                    }
                    adRequest = new AdRequest(builder2);
                }
                zzdwgVar.zzg(adRequest);
                String str5 = (String) map.get("width");
                String str6 = (String) map.get("height");
                if (TextUtils.isEmpty(str5) || TextUtils.isEmpty(str6)) {
                    adSize = AdSize.BANNER;
                } else {
                    try {
                        adSize = new AdSize(Integer.parseInt(str5), Integer.parseInt(str6));
                    } catch (NumberFormatException e3) {
                        com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e3, "OutOfContextTestingGmsgHandler.generateAdSize");
                        adSize = AdSize.BANNER;
                    }
                }
                zzdwgVar.zzh(adSize);
                if (map.containsKey("clickToExpandRequested") || map.containsKey("customControlsRequested") || map.containsKey("startMuted")) {
                    VideoOptions.Builder builder3 = new VideoOptions.Builder();
                    builder3.zza = true;
                    builder3.zzb = false;
                    builder3.zzc = false;
                    if (map.containsKey("startMuted")) {
                        builder3.zza = ((String) map.get("startMuted")).equals("1");
                    }
                    if (map.containsKey("customControlsRequested")) {
                        builder3.zzb = ((String) map.get("customControlsRequested")).equals("1");
                    }
                    if (map.containsKey("clickToExpandRequested")) {
                        builder3.zzc = ((String) map.get("clickToExpandRequested")).equals("1");
                    }
                    zzdwgVar.zzm(new VideoOptions(builder3));
                }
                if (map.containsKey("customMuteThisAdRequested") || map.containsKey("disableImageLoading") || map.containsKey("mediaAspectRatio") || map.containsKey("preferredAdChoicesPosition") || map.containsKey("shouldRequestMultipleImages") || (zzdwgVar.zzc() != null && zzdwgVar.zzf().equals("NATIVE"))) {
                    NativeAdOptions.Builder builder4 = new NativeAdOptions.Builder();
                    if (map.containsKey("disableImageLoading")) {
                        builder4.zza = ((String) map.get("disableImageLoading")).equals("1");
                    }
                    if (map.containsKey("mediaAspectRatio")) {
                        String str7 = (String) map.get("mediaAspectRatio");
                        if (!TextUtils.isEmpty(str7)) {
                            try {
                                builder4.zzb = Integer.parseInt(str7);
                            } catch (NumberFormatException e4) {
                                com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e4, "OutOfContextTestingGmsgHandler.generateNativeAdOptionsBuilder.mediaAspectRatio");
                            }
                        }
                    }
                    if (map.containsKey("shouldRequestMultipleImages")) {
                        builder4.zzc = ((String) map.get("shouldRequestMultipleImages")).equals("1");
                    }
                    if (map.containsKey("preferredAdChoicesPosition")) {
                        String str8 = (String) map.get("preferredAdChoicesPosition");
                        if (!TextUtils.isEmpty(str8)) {
                            try {
                                builder4.zze = Integer.parseInt(str8);
                            } catch (NumberFormatException e5) {
                                com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e5, "OutOfContextTestingGmsgHandler.generateNativeAdOptionsBuilder.preferredAdChoicesPosition");
                            }
                        }
                    }
                    if (map.containsKey("customMuteThisAdRequested")) {
                        builder4.zzf = ((String) map.get("customMuteThisAdRequested")).equals("1");
                    }
                    VideoOptions videoOptionsZzc = zzdwgVar.zzc();
                    if (videoOptionsZzc != null) {
                        builder4.zzd = videoOptionsZzc;
                    }
                    zzdwgVar.zzl(new NativeAdOptions(builder4));
                }
            }
            String str9 = (String) map.get("action");
            if (TextUtils.isEmpty(str9) || TextUtils.isEmpty(zzdwgVar.zze())) {
                return;
            }
            if (str9.equals("load") && !TextUtils.isEmpty(zzdwgVar.zzf())) {
                this.zza.zzh(zzdwgVar);
            } else if (str9.equals("show")) {
                this.zza.zzi(zzdwgVar.zze());
            }
        }
    }
}
