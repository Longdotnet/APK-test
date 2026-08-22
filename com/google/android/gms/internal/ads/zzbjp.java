package com.google.android.gms.internal.ads;

import androidx.work.impl.WorkerWrapper;
import com.facebook.ProfileCache;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzbjp implements zzbkf {
    @Override // com.google.android.gms.internal.ads.zzbkf
    public final void zza(Object obj, Map map) {
        zzfte zzfteVar;
        com.android.billingclient.api.zzo zzoVar = com.google.android.gms.ads.internal.zzv.zza.zzt;
        if (!zzoVar.zzh || (zzfteVar = (zzfte) zzoVar.zzf) == null) {
            com.google.android.gms.ads.internal.util.zze.zza("LastMileDelivery not connected");
        } else {
            zzfteVar.zza(zzoVar.zzl(), (ProfileCache) zzoVar.zzg);
            zzcaf.zzf.execute(new WorkerWrapper.AnonymousClass1(zzoVar, "onLMDOverlayCollapse", new HashMap(), 10, false));
        }
    }
}
