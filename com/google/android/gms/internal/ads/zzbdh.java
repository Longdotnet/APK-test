package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Future;
import kotlin.coroutines.jvm.internal.DEXi.JuorMn;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbdh {
    private final String zza = (String) zzbey.zza.zze();
    private final Map zzb;
    private final Context zzc;
    private final String zzd;

    public final Context zza() {
        return this.zzc;
    }

    public final String zzb() {
        return this.zzd;
    }

    public final String zzc() {
        return this.zza;
    }

    public final Map zzd() {
        return this.zzb;
    }

    public zzbdh(Context context, String str) {
        String packageName;
        String str2;
        this.zzc = context;
        this.zzd = str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.zzb = linkedHashMap;
        linkedHashMap.put("s", "gmob_sdk");
        linkedHashMap.put("v", "3");
        linkedHashMap.put("os", Build.VERSION.RELEASE);
        linkedHashMap.put("api_v", Build.VERSION.SDK);
        com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
        com.google.android.gms.ads.internal.util.zzs zzsVar = zzvVar.zzd;
        linkedHashMap.put("device", com.google.android.gms.ads.internal.util.zzs.zzs());
        if (context.getApplicationContext() != null) {
            packageName = context.getApplicationContext().getPackageName();
        } else {
            packageName = context.getPackageName();
        }
        linkedHashMap.put("app", packageName);
        com.google.android.gms.ads.internal.util.zzs zzsVar2 = zzvVar.zzd;
        boolean zZzF = com.google.android.gms.ads.internal.util.zzs.zzF(context);
        String str3 = JuorMn.ksQjDY;
        if (true == zZzF) {
            str2 = "1";
        } else {
            str2 = str3;
        }
        linkedHashMap.put("is_lite_sdk", str2);
        Future futureZzb = zzvVar.zzq.zzb(context);
        try {
            linkedHashMap.put("network_coarse", Integer.toString(((zzbvu) futureZzb.get()).zzj));
            linkedHashMap.put("network_fine", Integer.toString(((zzbvu) futureZzb.get()).zzk));
        } catch (Exception e) {
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "CsiConfiguration.CsiConfiguration");
        }
        zzbcv zzbcvVar = zzbde.zzlM;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            Map map = this.zzb;
            com.google.android.gms.ads.internal.util.zzs zzsVar3 = com.google.android.gms.ads.internal.zzv.zza.zzd;
            map.put("is_bstar", true != com.google.android.gms.ads.internal.util.zzs.zzC(context) ? str3 : "1");
        }
        if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzjQ)).booleanValue()) {
            if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzcC)).booleanValue()) {
                com.google.android.gms.ads.internal.zzv zzvVar2 = com.google.android.gms.ads.internal.zzv.zza;
                if (!zzfwg.zzd(zzvVar2.zzi.zzn())) {
                    this.zzb.put("plugin", zzvVar2.zzi.zzn());
                }
            }
        }
    }
}
