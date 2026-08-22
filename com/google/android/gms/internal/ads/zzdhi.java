package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzdhi implements zzbkf {
    private final WeakReference zza;

    public /* synthetic */ zzdhi(zzdhn zzdhnVar, zzdhm zzdhmVar) {
        this.zza = new WeakReference(zzdhnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbkf
    public final void zza(Object obj, Map map) {
        zzdhn zzdhnVar = (zzdhn) this.zza.get();
        if (zzdhnVar != null && "_ac".equals((String) map.get("eventName"))) {
            zzdhnVar.zzh.onAdClicked();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzli)).booleanValue()) {
                zzdhnVar.zzi.zzdf();
                if (TextUtils.isEmpty((CharSequence) map.get("sccg"))) {
                    return;
                }
                zzdhnVar.zzi.zzdH();
            }
        }
    }
}
