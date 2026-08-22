package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.work.impl.WorkerWrapper;
import java.util.HashMap;
import java.util.Map;
import kotlinx.coroutines.internal.Jbo.ygoi;

/* JADX INFO: loaded from: classes2.dex */
final class zzbjm implements zzbkf {
    @Override // com.google.android.gms.internal.ads.zzbkf
    public final void zza(Object obj, Map map) {
        zzcfg zzcfgVar = (zzcfg) obj;
        com.android.billingclient.api.zzo zzoVar = com.google.android.gms.ads.internal.zzv.zza.zzt;
        Context context = zzcfgVar.getContext();
        synchronized (zzoVar) {
            zzoVar.zze = zzcfgVar;
            if (!zzoVar.zzk(context)) {
                zzoVar.zzg("Unable to bind", "on_play_store_bind");
                return;
            }
            HashMap map2 = new HashMap();
            map2.put("action", "fetch_completed");
            zzcaf.zzf.execute(new WorkerWrapper.AnonymousClass1(zzoVar, ygoi.FTEFSSsqZOsP, map2, 10, false));
        }
    }
}
