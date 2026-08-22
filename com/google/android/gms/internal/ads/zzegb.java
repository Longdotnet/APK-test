package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.Hex;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzegb implements zzefv {
    private final zzdhb zza;
    private final zzgdy zzb;
    private final zzdln zzc;
    private final zzfdv zzd;
    private final zzdoe zze;
    private final zzdsd zzf;
    private final VersionInfoParcel zzg;
    private final Context zzh;
    private final zzbxw zzi;

    public zzegb(zzdhb zzdhbVar, zzgdy zzgdyVar, zzdln zzdlnVar, zzfdv zzfdvVar, zzdoe zzdoeVar, zzdsd zzdsdVar, VersionInfoParcel versionInfoParcel, Context context, zzbxw zzbxwVar) {
        this.zzg = versionInfoParcel;
        this.zzh = context;
        this.zzi = zzbxwVar;
        this.zza = zzdhbVar;
        this.zzb = zzgdyVar;
        this.zzc = zzdlnVar;
        this.zzd = zzfdvVar;
        this.zze = zzdoeVar;
        this.zzf = zzdsdVar;
    }

    public static zzdio zzc(zzegb zzegbVar, ListenableFuture listenableFuture, ListenableFuture listenableFuture2, zzfcn zzfcnVar, zzfca zzfcaVar, JSONObject jSONObject, com.google.android.gms.ads.internal.zzb zzbVar, zzbya zzbyaVar) {
        zzdit zzditVar = (zzdit) listenableFuture.get();
        zzdny zzdnyVar = (zzdny) listenableFuture2.get();
        zzbcv zzbcvVar = zzbde.zzct;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            CoroutineAdapterKt$$ExternalSyntheticLambda0.m(com.google.android.gms.ads.internal.zzv.zza.zzl, zzegbVar.zzf.zza(), zzdrr.RENDERING_WEBVIEW_CREATION_END.zza());
        }
        zzdiu zzdiuVarZzd = zzegbVar.zza.zzd(new zzcrq(zzfcnVar, zzfcaVar, null), new zzdjf(zzditVar), new zzdhp(jSONObject, zzdnyVar, zzbVar, zzbyaVar));
        zzbdc zzbdcVar = zzbdVar.zzd;
        if (((Boolean) zzbdcVar.zzb(zzbcvVar)).booleanValue()) {
            com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            zzdsd zzdsdVar = zzegbVar.zzf;
            zzdsdVar.zza().putLong(zzdrr.RENDERING_AD_COMPONENT_CREATION_END.zza(), jCurrentTimeMillis);
            zzdsdVar.zza().putLong(zzdrr.RENDERING_CONFIGURE_WEBVIEW_START.zza(), jCurrentTimeMillis);
        }
        zzdiuVarZzd.zzh().zzb();
        zzdiuVarZzd.zzi().zza(zzdnyVar);
        zzdiuVarZzd.zzg().zzc(zzditVar.zzs());
        zzdiuVarZzd.zzl().zza(zzegbVar.zze, zzditVar.zzq());
        if (((Boolean) zzbdcVar.zzb(zzbcvVar)).booleanValue()) {
            CoroutineAdapterKt$$ExternalSyntheticLambda0.m(com.google.android.gms.ads.internal.zzv.zza.zzl, zzegbVar.zzf.zza(), zzdrr.RENDERING_CONFIGURE_WEBVIEW_END.zza());
        }
        return zzdiuVarZzd.zza();
    }

    public static ListenableFuture zzd(zzegb zzegbVar, zzfcn zzfcnVar, zzfca zzfcaVar, JSONArray jSONArray) {
        if (jSONArray.length() == 0) {
            return zzgdn.zzg(new zzdwm(3));
        }
        int i = zzfcnVar.zza.zza.zzk;
        if (i <= 1) {
            return zzgdn.zzm(zzegbVar.zzg(zzfcnVar, zzfcaVar, jSONArray.getJSONObject(0)), new zzfve() { // from class: com.google.android.gms.internal.ads.zzega
                @Override // com.google.android.gms.internal.ads.zzfve
                public final Object apply(Object obj) {
                    return Collections.singletonList(zzgdn.zzh((zzdio) obj));
                }
            }, zzegbVar.zzb);
        }
        int length = jSONArray.length();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzcu)).booleanValue()) {
            zzegbVar.zzf.zzd("nsl", String.valueOf(length));
        }
        zzegbVar.zzd.zzc(Math.min(length, i));
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 < length) {
                arrayList.add(zzegbVar.zzg(zzfcnVar, zzfcaVar, jSONArray.getJSONObject(i2)));
            } else {
                arrayList.add(zzgdn.zzg(new zzdwm(3)));
            }
        }
        return zzgdn.zzh(arrayList);
    }

    public static ListenableFuture zze(final zzegb zzegbVar, zzfca zzfcaVar, final zzdny zzdnyVar) {
        zzbcv zzbcvVar = zzbde.zzcs;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            CoroutineAdapterKt$$ExternalSyntheticLambda0.m(com.google.android.gms.ads.internal.zzv.zza.zzl, zzegbVar.zzf.zza(), zzdrr.RENDERING_NATIVE_ADS_PREPROCESS_START.zza());
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("isNonagon", true);
        if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzjb)).booleanValue() && Hex.isAtLeastR()) {
            jSONObject.put("skipDeepLinkValidation", true);
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("response", zzfcaVar.zzs.zzc);
        jSONObject2.put("sdk_params", jSONObject);
        return zzgdn.zzn(zzdnyVar.zzg("google.afma.nativeAds.preProcessJson", jSONObject2), new zzgcu() { // from class: com.google.android.gms.internal.ads.zzefx
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return zzegb.zzf(this.zza, zzdnyVar, (JSONObject) obj);
            }
        }, zzegbVar.zzb);
    }

    public static ListenableFuture zzf(zzegb zzegbVar, zzdny zzdnyVar, JSONObject jSONObject) throws zzbol {
        zzegbVar.zzd.zzb(zzgdn.zzh(zzdnyVar));
        if (!jSONObject.optBoolean(FirebaseAnalytics.Param.SUCCESS)) {
            throw new zzbol("process json failed");
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzcs)).booleanValue()) {
            CoroutineAdapterKt$$ExternalSyntheticLambda0.m(com.google.android.gms.ads.internal.zzv.zza.zzl, zzegbVar.zzf.zza(), zzdrr.RENDERING_NATIVE_ADS_PREPROCESS_END.zza());
        }
        return zzgdn.zzh(jSONObject.getJSONObject("json").getJSONArray("ads"));
    }

    private final ListenableFuture zzg(final zzfcn zzfcnVar, final zzfca zzfcaVar, final JSONObject jSONObject) {
        final com.google.android.gms.ads.internal.zzb zzbVar;
        final zzbya zzbyaVar;
        zzbcv zzbcvVar = zzbde.zzct;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            CoroutineAdapterKt$$ExternalSyntheticLambda0.m(com.google.android.gms.ads.internal.zzv.zza.zzl, this.zzf.zza(), zzdrr.RENDERING_WEBVIEW_CREATION_START.zza());
        }
        final ListenableFuture listenableFutureZza = this.zzd.zza();
        if (((Boolean) zzbdVar.zzd.zzb(zzbde.zznP)).booleanValue()) {
            Context context = this.zzh;
            zzbya zzbyaVarZza = zzcvt.zza(context, this.zzg, zzfcaVar, this.zzi);
            zzbyaVar = zzbyaVarZza;
            zzbVar = new com.google.android.gms.ads.internal.zzb(context, zzbyaVarZza);
        } else {
            zzbVar = new com.google.android.gms.ads.internal.zzb(this.zzh, null);
            zzbyaVar = null;
        }
        final ListenableFuture listenableFutureZzd = this.zzc.zzd(zzfcnVar, zzfcaVar, jSONObject, zzbVar, zzbyaVar);
        return zzgdn.zzc(listenableFutureZza, listenableFutureZzd).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzefw
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzegb.zzc(this.zza, listenableFutureZzd, listenableFutureZza, zzfcnVar, zzfcaVar, jSONObject, zzbVar, zzbyaVar);
            }
        }, this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzedm
    public final ListenableFuture zza(final zzfcn zzfcnVar, final zzfca zzfcaVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzcs)).booleanValue()) {
            CoroutineAdapterKt$$ExternalSyntheticLambda0.m(com.google.android.gms.ads.internal.zzv.zza.zzl, this.zzf.zza(), zzdrr.RENDERING_NATIVE_ADS_NATIVE_JS_WEBVIEW_START.zza());
        }
        ListenableFuture listenableFutureZza = this.zzd.zza();
        zzgcu zzgcuVar = new zzgcu() { // from class: com.google.android.gms.internal.ads.zzefy
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return zzegb.zze(this.zza, zzfcaVar, (zzdny) obj);
            }
        };
        zzgdy zzgdyVar = this.zzb;
        return zzgdn.zzn(zzgdn.zzn(listenableFutureZza, zzgcuVar, zzgdyVar), new zzgcu() { // from class: com.google.android.gms.internal.ads.zzefz
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return zzegb.zzd(this.zza, zzfcnVar, zzfcaVar, (JSONArray) obj);
            }
        }, zzgdyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzedm
    public final boolean zzb(zzfcn zzfcnVar, zzfca zzfcaVar) {
        zzfcf zzfcfVar = zzfcaVar.zzs;
        return (zzfcfVar == null || zzfcfVar.zzc == null) ? false : true;
    }
}
