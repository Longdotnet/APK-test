package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzcmc implements zzclg {
    private final CookieManager zza = com.google.android.gms.ads.internal.zzv.zza.zzg.zza();

    public zzcmc(Context context) {
    }

    @Override // com.google.android.gms.internal.ads.zzclg
    public final void zza(Map map) {
        CookieManager cookieManager = this.zza;
        if (cookieManager == null) {
            return;
        }
        if (((String) map.get("clear")) == null) {
            String str = (String) map.get("cookie");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            cookieManager.setCookie((String) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzbc), str);
            return;
        }
        String str2 = (String) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzbc);
        String cookie = cookieManager.getCookie(str2);
        if (cookie != null) {
            List listZzf = zzfwe.zzb(zzfva.zzc(';')).zzf(cookie);
            for (int i = 0; i < listZzf.size(); i++) {
                Iterator it = zzfwe.zzb(zzfva.zzc('=')).zzd((String) listZzf.get(i)).iterator();
                it.getClass();
                if (!it.hasNext()) {
                    throw new IndexOutOfBoundsException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(0, "position (0) must be less than the number of elements that remained (", ")"));
                }
                cookieManager.setCookie(str2, String.valueOf((String) it.next()).concat(String.valueOf((String) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzaO))));
            }
        }
    }
}
