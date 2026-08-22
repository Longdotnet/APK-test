package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline0;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.location.zzn;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes.dex */
public final class zzq {
    public static final zzq zza = new zzq();

    /* JADX WARN: Code duplicated, block: B:12:0x0043  */
    /* JADX WARN: Code duplicated, block: B:48:0x00f2  */
    public static zzm zza(Context context, zzek zzekVar) {
        boolean z;
        String str;
        String className;
        String str2 = zzekVar.zza;
        Set set = zzekVar.zzc;
        List listUnmodifiableList = !set.isEmpty() ? Collections.unmodifiableList(new ArrayList(set)) : null;
        RequestConfiguration requestConfiguration = zzey.zzf().zzn;
        zzf zzfVar = zzbb.zzb.zzc;
        String strZzD = zzf.zzD(context);
        int i = 0;
        if (zzekVar.zzh.contains(strZzD)) {
            z = true;
        } else {
            requestConfiguration.getClass();
            if (new ArrayList(requestConfiguration.zze).contains(strZzD)) {
                z = true;
            } else {
                z = false;
            }
        }
        Bundle bundle = zzekVar.zzd.getBundle(AdMobAdapter.class.getName());
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            String packageName = applicationContext.getPackageName();
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            while (true) {
                int i2 = i + 1;
                if (i2 >= stackTrace.length) {
                    className = null;
                    break;
                }
                StackTraceElement stackTraceElement = stackTrace[i];
                String className2 = stackTraceElement.getClassName();
                if ("loadAd".equalsIgnoreCase(stackTraceElement.getMethodName()) && (zzf.zzb.equalsIgnoreCase(className2) || zzf.zzc.equalsIgnoreCase(className2) || zzf.zzd.equalsIgnoreCase(className2) || zzf.zze.equalsIgnoreCase(className2) || zzf.zzf.equalsIgnoreCase(className2) || zzf.zzg.equalsIgnoreCase(className2))) {
                    className = stackTrace[i2].getClassName();
                    break;
                }
                i = i2;
            }
            if (packageName != null) {
                StringTokenizer stringTokenizer = new StringTokenizer(packageName, ".");
                StringBuilder sb = new StringBuilder();
                if (stringTokenizer.hasMoreElements()) {
                    sb.append(stringTokenizer.nextToken());
                    for (int i3 = 2; i3 > 0 && stringTokenizer.hasMoreElements(); i3--) {
                        sb.append(".");
                        sb.append(stringTokenizer.nextToken());
                    }
                    packageName = sb.toString();
                }
                if (className == null || className.contains(packageName)) {
                    className = null;
                }
            } else {
                className = null;
            }
            str = className;
        } else {
            str = null;
        }
        RequestConfiguration requestConfiguration2 = zzey.zzf().zzn;
        int iMax = Math.max(zzekVar.zzg, requestConfiguration2.zzb);
        String str3 = requestConfiguration2.zzd;
        if (str3 == null) {
            str3 = "";
        }
        return new zzm(8, -1L, bundle, -1, listUnmodifiableList, z, iMax, false, zzekVar.zze, null, null, str2, zzekVar.zzd, zzekVar.zzi, Collections.unmodifiableList(new ArrayList(zzekVar.zzj)), zzekVar.zzf, str, zzekVar.zzk, null, requestConfiguration2.zzc, (String) Collections.max(Arrays.asList(null, str3), new zzn(2)), new ArrayList(zzekVar.zzb), zzekVar.zzm, null, Fragment$$ExternalSyntheticOutline0.ordinal(requestConfiguration2.zzf), zzekVar.zzn, 0L);
    }
}
