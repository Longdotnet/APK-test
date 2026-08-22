package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzbkh implements zzbkf {
    private final zzbki zza;

    public zzbkh(zzbki zzbkiVar) {
        this.zza = zzbkiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbkf
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcfg zzcfgVar = (zzcfg) obj;
        boolean zEquals = "1".equals(map.get("transparentBackground"));
        boolean zEquals2 = "1".equals(map.get("blur"));
        float f = 0.0f;
        try {
            if (map.get("blurRadius") != null) {
                f = Float.parseFloat((String) map.get("blurRadius"));
            }
        } catch (NumberFormatException e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Fail to parse float", e);
        }
        zzbki zzbkiVar = this.zza;
        zzbkiVar.zzc(zEquals);
        zzbkiVar.zzb(zEquals2, f);
        zzcfgVar.zzay(zEquals);
    }
}
