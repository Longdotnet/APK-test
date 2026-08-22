package com.google.android.gms.ads.internal.util;

import android.os.Process;
import android.webkit.CookieManager;
import com.google.android.gms.ads.internal.util.client.zzo;

/* JADX INFO: loaded from: classes.dex */
public class zzt extends zzaa {
    public final CookieManager zza() {
        zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
        int iMyUid = Process.myUid();
        if (iMyUid == 0 || iMyUid == 1000) {
            return null;
        }
        try {
            return CookieManager.getInstance();
        } catch (Throwable th) {
            int i = zze.$r8$clinit;
            zzo.zzh("Failed to obtain CookieManager.", th);
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzv(th, "ApiLevelUtil.getCookieManager");
            return null;
        }
    }
}
