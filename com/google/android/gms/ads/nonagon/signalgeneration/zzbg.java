package com.google.android.gms.ads.nonagon.signalgeneration;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.JsonReader;
import androidx.fragment.app.Fragment;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.internal.ads.zzbcv;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbze;
import com.google.android.gms.internal.ads.zzcaf;
import com.google.android.gms.internal.ads.zzcvb;
import com.google.android.gms.internal.ads.zzcvc;
import com.google.android.gms.internal.ads.zzcvp;
import com.google.android.gms.internal.ads.zzdes;
import com.google.android.gms.internal.ads.zzdrr;
import com.google.android.gms.internal.ads.zzdxp;
import com.google.android.gms.internal.ads.zzffu;
import com.google.android.gms.internal.ads.zzfgu;
import com.google.android.gms.internal.ads.zzfha;
import com.google.android.gms.internal.ads.zzfsa;
import com.google.android.gms.internal.ads.zzfse;
import com.google.android.gms.internal.ads.zzfsf;
import com.google.android.gms.internal.ads.zzgdn;
import com.google.android.gms.internal.ads.zzhgr;
import com.google.android.gms.internal.ads.zzhgz;
import com.google.android.gms.internal.ads.zzhha;
import com.google.common.util.concurrent.ListenableFuture;
import com.yoyogames.runner.RunnerJNILib;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzbg implements zzhgr {
    public final zzhha zza;
    public final zzhha zzb;
    public final zzy zzc;
    public final zzcvc zzd;
    public final zzhha zze;
    public final zzhha zzf;
    public final zzhha zzg;
    public final zzhha zzh;
    public final zzcvp zzi;

    public zzbg(zzhha zzhhaVar, zzhha zzhhaVar2, zzy zzyVar, zzcvc zzcvcVar, zzhha zzhhaVar3, zzhha zzhhaVar4, zzhha zzhhaVar5, zzhha zzhhaVar6, zzcvp zzcvpVar) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
        this.zzc = zzyVar;
        this.zzd = zzcvcVar;
        this.zze = zzhhaVar3;
        this.zzf = zzhhaVar4;
        this.zzg = zzhhaVar5;
        this.zzh = zzhhaVar6;
        this.zzi = zzcvpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final Object zzb() {
        zzfha zzfhaVar;
        zzbi zzbiVar;
        zzcvb zzcvbVar;
        zzdes zzdesVar;
        ListenableFuture listenableFutureZza;
        String string;
        zzbk zzbkVar;
        Iterator it;
        zzfha zzfhaVar2;
        zzbi zzbiVar2;
        zzcvb zzcvbVar2;
        zzdes zzdesVar2;
        zzau zzauVar = (zzau) this.zza.zzb();
        zzfha zzfhaVar3 = (zzfha) this.zzb.zzb();
        zzbi zzbiVar3 = new zzbi(zzffu.zzc(), ((zzdxp) this.zzc.zza).zzb());
        zzcvb zzcvbVarZzb = this.zzd.zzb();
        zzdes zzdesVar3 = (zzdes) this.zze.zzb();
        zzb zzbVar = (zzb) this.zzf.zzb();
        zzbze zzbzeVar = (zzbze) this.zzg.zzb();
        int iIntValue = ((Integer) this.zzh.zzb()).intValue();
        Bundle bundle = this.zzi.zzc().zzs;
        zzbk zzbkVar2 = null;
        if (iIntValue != 1 || zzbzeVar == null) {
            zzfhaVar = zzfhaVar3;
            zzbiVar = zzbiVar3;
            zzcvbVar = zzcvbVarZzb;
            zzdesVar = zzdesVar3;
        } else {
            String strZza = zzdrr.READ_FROM_DISK_START.zza();
            com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
            zzvVar.zzl.getClass();
            bundle.putLong(strZza, System.currentTimeMillis());
            zzbVar.getClass();
            zzb.zzf(bundle, zzdrr.SIGNAL_ON_DISK_VALIDATION_START);
            if (((com.google.android.gms.ads.internal.util.zzj) zzvVar.zzi.zzi()).zzN()) {
                zzbVar.zzb.zzg();
                zzb.zzg(7, bundle);
            } else {
                PackageInfo packageInfo = zzbVar.zze;
                if (packageInfo == null) {
                    zzbVar.zzb.zzg();
                    zzb.zzg(10, bundle);
                } else {
                    zzd zzdVar = zzbVar.zzb;
                    Context context = zzbVar.zza;
                    zzdVar.zzk();
                    synchronized (zzdVar.zzd) {
                        string = zzdVar.zza.getString("pn", null);
                    }
                    int iZzb = zzdVar.zzb();
                    String strZzd = zzdVar.zzd();
                    int iZza = zzdVar.zza();
                    if (TextUtils.equals(context.getApplicationInfo().packageName, string) && iZzb == packageInfo.versionCode && TextUtils.equals(Build.MODEL, strZzd) && iZza == Build.VERSION.SDK_INT) {
                        Iterator it2 = zzdVar.zzf().entrySet().iterator();
                        while (it2.hasNext()) {
                            Map.Entry entry = (Map.Entry) it2.next();
                            try {
                                long j = new JSONObject((String) entry.getValue()).getLong("ts_ms");
                                com.google.android.gms.ads.internal.zzv zzvVar2 = com.google.android.gms.ads.internal.zzv.zza;
                                zzvVar2.zzl.getClass();
                                long jCurrentTimeMillis = System.currentTimeMillis() - j;
                                zzbcv zzbcvVar = zzbde.zzhR;
                                it = it2;
                                try {
                                    zzbd zzbdVar = zzbd.zza;
                                    zzbiVar2 = zzbiVar3;
                                    try {
                                        try {
                                            if (jCurrentTimeMillis > ((Long) zzbdVar.zzd.zzb(zzbcvVar)).longValue()) {
                                                zzfhaVar2 = zzfhaVar3;
                                                zzcvbVar2 = zzcvbVarZzb;
                                                zzdesVar2 = zzdesVar3;
                                            } else {
                                                zzfhaVar2 = zzfhaVar3;
                                                try {
                                                    zzcvbVar2 = zzcvbVarZzb;
                                                    zzdesVar2 = zzdesVar3;
                                                    zzfsa zzfsaVarZzh = zzfse.zzj(context).zzh(((Long) zzbdVar.zzd.zzb(zzbde.zzdz)).longValue(), ((com.google.android.gms.ads.internal.util.zzj) zzvVar2.zzi.zzi()).zzN());
                                                    zzfsa zzfsaVarZzh2 = zzfsf.zzi(context).zzh(((Long) zzbdVar.zzd.zzb(zzbde.zzdA)).longValue(), ((com.google.android.gms.ads.internal.util.zzj) zzvVar2.zzi.zzi()).zzN());
                                                    if ((zzfsaVarZzh.zza() == -1 || zzfsaVarZzh.zza() <= j) && (zzfsaVarZzh2.zza() == -1 || zzfsaVarZzh2.zza() <= j)) {
                                                    }
                                                } catch (IOException | JSONException unused) {
                                                    zzcvbVar2 = zzcvbVarZzb;
                                                    zzdesVar2 = zzdesVar3;
                                                }
                                                zzcvbVarZzb = zzcvbVar2;
                                                zzfhaVar3 = zzfhaVar2;
                                                zzdesVar3 = zzdesVar2;
                                                it2 = it;
                                                zzbiVar3 = zzbiVar2;
                                            }
                                            zzdVar.zzc((String) entry.getKey());
                                        } catch (IOException | JSONException unused2) {
                                        }
                                    } catch (IOException | JSONException unused3) {
                                        zzfhaVar2 = zzfhaVar3;
                                    }
                                } catch (IOException | JSONException unused4) {
                                    zzfhaVar2 = zzfhaVar3;
                                    zzbiVar2 = zzbiVar3;
                                    zzcvbVar2 = zzcvbVarZzb;
                                    zzdesVar2 = zzdesVar3;
                                    zzcvbVarZzb = zzcvbVar2;
                                    zzfhaVar3 = zzfhaVar2;
                                    zzdesVar3 = zzdesVar2;
                                    it2 = it;
                                    zzbiVar3 = zzbiVar2;
                                }
                            } catch (IOException | JSONException unused5) {
                                it = it2;
                            }
                            zzcvbVarZzb = zzcvbVar2;
                            zzfhaVar3 = zzfhaVar2;
                            zzdesVar3 = zzdesVar2;
                            it2 = it;
                            zzbiVar3 = zzbiVar2;
                        }
                        zzfhaVar = zzfhaVar3;
                        zzbiVar = zzbiVar3;
                        zzcvbVar = zzcvbVarZzb;
                        zzdesVar = zzdesVar3;
                    } else {
                        zzfhaVar = zzfhaVar3;
                        zzbiVar = zzbiVar3;
                        zzcvbVar = zzcvbVarZzb;
                        zzdesVar = zzdesVar3;
                        zzdVar.zzg();
                        zzdVar.zzi(packageInfo.versionCode, Build.VERSION.SDK_INT, context.getApplicationInfo().packageName, Build.MODEL);
                    }
                    zzb.zzf(bundle, zzdrr.SIGNAL_ON_DISK_VALIDATION_END);
                    com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
                    long jCurrentTimeMillis2 = System.currentTimeMillis() - zzbVar.zzc;
                    zzbcv zzbcvVar2 = zzbde.zzhO;
                    zzbd zzbdVar2 = zzbd.zza;
                    if (jCurrentTimeMillis2 > ((Long) zzbdVar2.zzd.zzb(zzbcvVar2)).longValue()) {
                        zzb.zzg(2, bundle);
                    } else {
                        zzb.zzf(bundle, zzdrr.SIGNAL_ON_DISK_CACHE_KEY_START);
                        String str = zzbzeVar.zza;
                        String str2 = zzbzeVar.zzb;
                        zzm zzmVar = zzbzeVar.zzd;
                        String strZzE = com.google.android.gms.ads.internal.util.client.zzf.zzE(str + str2 + zzmVar.zzn.toString() + zzmVar.zzc.toString() + zzmVar.zzi + zzmVar.zzp + String.valueOf(zzmVar.zzo), "SHA-256");
                        if (TextUtils.isEmpty(strZzE)) {
                            zzb.zzg(3, bundle);
                        } else {
                            zzb.zzf(bundle, zzdrr.SIGNAL_ON_DISK_CACHE_KEY_END);
                            zzb.zzf(bundle, zzdrr.SIGNAL_ON_DISK_READ_AND_REMOVE_START);
                            String strZzc = zzbVar.zzb.zzc(strZzE);
                            zzb.zzf(bundle, zzdrr.SIGNAL_ON_DISK_READ_AND_REMOVE_END);
                            if (!zzbVar.zze()) {
                                zzbVar.zzd.schedule(new RunnerJNILib.AnonymousClass2(5, strZzE, zzbVar, zzauVar, new zzbze(str, str2, zzbzeVar.zzc, zzmVar, 2, strZzE)), ((Long) zzbdVar2.zzd.zzb(zzbde.zzhQ)).longValue(), TimeUnit.MILLISECONDS);
                            }
                            if (TextUtils.isEmpty(strZzc)) {
                                zzb.zzg(4, bundle);
                            } else {
                                zzb.zzf(bundle, zzdrr.SIGNAL_ON_DISK_DECODE_START);
                                try {
                                    JSONObject jSONObject = new JSONObject(strZzc);
                                    String string2 = jSONObject.getString("sr");
                                    if (TextUtils.isEmpty(string2)) {
                                        zzb.zzg(8, bundle);
                                    } else {
                                        String string3 = jSONObject.getString("rs");
                                        if (TextUtils.isEmpty(string3)) {
                                            zzb.zzg(9, bundle);
                                        } else {
                                            String strZzb = zzb.zzb(new String(Base64.decode(string3, 10), StandardCharsets.UTF_8));
                                            zzb.zzf(bundle, zzdrr.SIGNAL_ON_DISK_DECODE_END);
                                            try {
                                                JsonReader jsonReader = new JsonReader(new StringReader(string2));
                                                zzbkVar = null;
                                                try {
                                                    zzbk zzbkVar3 = new zzbk(jsonReader, null);
                                                    zzbkVar3.zzc = strZzb;
                                                    zzbkVar3.zze = bundle;
                                                    bundle.putBoolean("sod_h", true);
                                                    zzbkVar2 = zzbkVar3;
                                                } catch (IOException e) {
                                                    e = e;
                                                    zzb.zzg(6, bundle);
                                                    com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "DiskCachingManager.getSignalResponse");
                                                    zzbkVar2 = zzbkVar;
                                                }
                                            } catch (IOException e2) {
                                                e = e2;
                                                zzbkVar = null;
                                            }
                                        }
                                    }
                                } catch (JSONException e3) {
                                    zzbkVar = null;
                                    zzb.zzg(5, bundle);
                                    com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e3, "DiskCachingManager.getSignalResponse");
                                }
                            }
                        }
                    }
                    zzbkVar2 = null;
                }
                CoroutineAdapterKt$$ExternalSyntheticLambda0.m(com.google.android.gms.ads.internal.zzv.zza.zzl, bundle, zzdrr.READ_FROM_DISK_END.zza());
            }
            zzfhaVar = zzfhaVar3;
            zzbiVar = zzbiVar3;
            zzcvbVar = zzcvbVarZzb;
            zzdesVar = zzdesVar3;
            CoroutineAdapterKt$$ExternalSyntheticLambda0.m(com.google.android.gms.ads.internal.zzv.zza.zzl, bundle, zzdrr.READ_FROM_DISK_END.zza());
        }
        if (zzbkVar2 != null) {
            zzdesVar.zza(zzbkVar2);
            listenableFutureZza = zzgdn.zzh(zzbkVar2);
        } else {
            listenableFutureZza = zzfhaVar.zzb(zzfgu.GENERATE_SIGNALS, zzcvbVar.zzc()).zzf(zzbiVar).zzi(((Integer) zzbd.zza.zzd.zzb(zzbde.zzfS)).intValue(), TimeUnit.SECONDS).zza();
            zzgdn.zzr(listenableFutureZza, new Fragment.AnonymousClass7(zzdesVar, 22), zzcaf.zza);
        }
        zzhgz.zzb(listenableFutureZza);
        return listenableFutureZza;
    }
}
