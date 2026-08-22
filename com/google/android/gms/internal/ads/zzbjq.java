package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.facebook.ProfileCache;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzbjq implements zzbkf {
    @Override // com.google.android.gms.internal.ads.zzbkf
    public final void zza(Object obj, Map map) {
        zzfte zzfteVar;
        com.android.billingclient.api.zzo zzoVar = com.google.android.gms.ads.internal.zzv.zza.zzt;
        if (!zzoVar.zzh || (zzfteVar = (zzfte) zzoVar.zzf) == null) {
            com.google.android.gms.ads.internal.util.zze.zza("LastMileDelivery not connected");
            return;
        }
        zzftc zzftcVarZzc = zzftd.zzc();
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzlU)).booleanValue() || TextUtils.isEmpty((String) zzoVar.zzb)) {
            String str = (String) zzoVar.zza;
            if (str != null) {
                zzftcVarZzc.zzb(str);
            } else {
                zzoVar.zzg("Missing session token and/or appId", "onLMDupdate");
            }
        } else {
            zzftcVarZzc.zza((String) zzoVar.zzb);
        }
        zzfteVar.zzb(zzftcVarZzc.zzc(), (ProfileCache) zzoVar.zzg);
    }
}
