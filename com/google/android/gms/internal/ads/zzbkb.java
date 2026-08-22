package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzbkb implements zzbkf {
    @Override // com.google.android.gms.internal.ads.zzbkf
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcfg zzcfgVar = (zzcfg) obj;
        String str = (String) map.get("action");
        if ("pause".equals(str)) {
            zzcfgVar.zzdg();
        } else if ("resume".equals(str)) {
            zzcfgVar.zzdh();
        }
    }
}
