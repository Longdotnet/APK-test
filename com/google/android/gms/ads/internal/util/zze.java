package com.google.android.gms.ads.internal.util;

import android.util.Log;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.internal.ads.zzbfg;

/* JADX INFO: loaded from: classes.dex */
public abstract class zze extends zzo {
    public static final /* synthetic */ int $r8$clinit = 0;

    public static void zza(String str) {
        if (zzc()) {
            if (str == null || str.length() <= 4000) {
                Log.v("Ads", str);
                return;
            }
            boolean z = true;
            for (String str2 : zzo.zzb.zzd(str)) {
                if (z) {
                    Log.v("Ads", str2);
                } else {
                    Log.v("Ads-cont", str2);
                }
                z = false;
            }
        }
    }

    public static void zzb(String str, Throwable th) {
        if (zzc()) {
            Log.v("Ads", str, th);
        }
    }

    public static boolean zzc() {
        return zzo.zzm(2) && ((Boolean) zzbfg.zza.zze()).booleanValue();
    }
}
