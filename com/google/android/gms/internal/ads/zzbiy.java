package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class zzbiy implements zzbkf {
    private static final Pattern zza = Pattern.compile("^[a-zA-Z]([a-zA-Z0-9]|:|-|_)*$");
    private static final Pattern zzb = Pattern.compile("^[0-9]*(,[0-9]*)*$");

    @Override // com.google.android.gms.internal.ads.zzbkf
    public final void zza(Object obj, Map map) {
        zzcfg zzcfgVar = (zzcfg) obj;
        String str = (String) map.get("action");
        if (!"tick".equals(str)) {
            if ("experiment".equals(str)) {
                String str2 = (String) map.get(FirebaseAnalytics.Param.VALUE);
                if (TextUtils.isEmpty(str2)) {
                    int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("No value given for CSI experiment.");
                    return;
                }
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzcm)).booleanValue() || zzb.matcher(str2).matches()) {
                    zzcfgVar.zzl().zza().zzd("e", str2);
                    return;
                } else {
                    int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zze("Invalid value given for CSI experiment. Should be a comma separated list of numbers.");
                    return;
                }
            }
            if ("extra".equals(str)) {
                String str3 = (String) map.get("name");
                String str4 = (String) map.get(FirebaseAnalytics.Param.VALUE);
                if (TextUtils.isEmpty(str4)) {
                    int i3 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("No value given for CSI extra.");
                    return;
                }
                if (TextUtils.isEmpty(str3)) {
                    int i4 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("No name given for CSI extra.");
                    return;
                }
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzcm)).booleanValue() || zza.matcher(str3).matches()) {
                    zzcfgVar.zzl().zza().zzd(str3, str4);
                    return;
                } else {
                    int i5 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zze("Invalid name given for CSI extra. Should start with a letter and only alphanumerics, :, -, _ are allowed.");
                    return;
                }
            }
            return;
        }
        String str5 = (String) map.get("label");
        String str6 = (String) map.get("start_label");
        String str7 = (String) map.get("timestamp");
        if (TextUtils.isEmpty(str5)) {
            int i6 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("No label given for CSI tick.");
            return;
        }
        zzbcv zzbcvVar = zzbde.zzcm;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue() && !zza.matcher(str5).matches()) {
            int i7 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zze("Invalid label given for CSI tick. Should start with a letter and only alphanumerics, :, -, _ are allowed.");
            return;
        }
        if (TextUtils.isEmpty(str7)) {
            int i8 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("No timestamp given for CSI tick.");
            return;
        }
        try {
            long j = Long.parseLong(str7);
            com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
            zzvVar.zzl.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            zzvVar.zzl.getClass();
            long jElapsedRealtime = (j - jCurrentTimeMillis) + SystemClock.elapsedRealtime();
            if (true == TextUtils.isEmpty(str6)) {
                str6 = "native:view_load";
            }
            if (!((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue() || zza.matcher(str6).matches()) {
                zzcfgVar.zzl().zzc(str5, str6, jElapsedRealtime);
            } else {
                int i9 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zze("Invalid start label given for CSI tick. Should start with a letter and only alphanumerics, :, -, _ are allowed.");
            }
        } catch (NumberFormatException e) {
            int i10 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Malformed timestamp for CSI tick.", e);
        }
    }
}
