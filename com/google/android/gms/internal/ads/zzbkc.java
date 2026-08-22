package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzbkc implements zzbkf {
    @Override // com.google.android.gms.internal.ads.zzbkf
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcfg zzcfgVar = (zzcfg) obj;
        if (map.containsKey("start")) {
            zzcfgVar.zzN().zzp();
        } else if (map.containsKey("stop")) {
            zzcfgVar.zzN().zzq();
        } else if (map.containsKey("cancel")) {
            zzcfgVar.zzN().zzo();
        }
    }
}
