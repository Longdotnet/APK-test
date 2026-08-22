package com.google.android.gms.internal.ads;

import com.google.android.finsky.externalreferrer.jUdg.RDFWIi;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class zzbkd implements zzbkf {
    @Override // com.google.android.gms.internal.ads.zzbkf
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcfg zzcfgVar = (zzcfg) obj;
        if (map.containsKey(RDFWIi.jPeIuQ)) {
            zzcfgVar.zzax(true);
        }
        if (map.containsKey("stop")) {
            zzcfgVar.zzax(false);
        }
    }
}
