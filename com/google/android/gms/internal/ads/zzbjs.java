package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzbjs implements zzbkf {
    @Override // com.google.android.gms.internal.ads.zzbkf
    public final void zza(Object obj, Map map) {
        zzcfg zzcfgVar = (zzcfg) obj;
        try {
            String str = (String) map.get("enabled");
            zzbkf zzbkfVar = zzbke.zza;
            if (!zzfuv.zzc("true", str) && !zzfuv.zzc("false", str)) {
                return;
            }
            zzfsb.zza(zzcfgVar.getContext()).zzb(Boolean.parseBoolean(str));
        } catch (IOException e) {
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "DefaultGmsgHandlers.SetPaidv2PersonalizationEnabled");
        }
    }
}
