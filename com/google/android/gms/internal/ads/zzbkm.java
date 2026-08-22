package com.google.android.gms.internal.ads;

import androidx.collection.ArrayMap;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzbkm implements zzbkf {
    static final Map zza;
    private final com.google.android.gms.ads.internal.zzb zzb;
    private final zzbso zzc;
    private final zzbsv zzd;

    static {
        String[] strArr = {"resize", "playVideo", "storePicture", "createCalendarEvent", "setOrientationProperties", "closeResizedAd", "unload"};
        Integer[] numArr = {1, 2, 3, 4, 5, 6, 7};
        ArrayMap arrayMap = new ArrayMap(7);
        for (int i = 0; i < 7; i++) {
            arrayMap.put(strArr[i], numArr[i]);
        }
        zza = Collections.unmodifiableMap(arrayMap);
    }

    public zzbkm(com.google.android.gms.ads.internal.zzb zzbVar, zzbso zzbsoVar, zzbsv zzbsvVar) {
        this.zzb = zzbVar;
        this.zzc = zzbsoVar;
        this.zzd = zzbsvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbkf
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcfg zzcfgVar = (zzcfg) obj;
        int iIntValue = ((Integer) zza.get((String) map.get("a"))).intValue();
        int i = 6;
        if (iIntValue != 5) {
            if (iIntValue != 7) {
                com.google.android.gms.ads.internal.zzb zzbVar = this.zzb;
                if (!zzbVar.zzc()) {
                    zzbVar.zzb(null);
                    return;
                }
                if (iIntValue == 1) {
                    this.zzc.zzc(map);
                    return;
                }
                if (iIntValue == 3) {
                    new zzbsr(zzcfgVar, map).zzb();
                    return;
                }
                if (iIntValue == 4) {
                    new zzbsl(zzcfgVar, map).zzc();
                    return;
                }
                if (iIntValue != 5) {
                    if (iIntValue == 6) {
                        this.zzc.zzb(true);
                        return;
                    } else if (iIntValue != 7) {
                        int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                        com.google.android.gms.ads.internal.util.client.zzo.zzi("Unknown MRAID command called.");
                        return;
                    }
                }
            }
            this.zzd.zzc();
            return;
        }
        String str = (String) map.get("forceOrientation");
        boolean z = map.containsKey("allowOrientationChange") ? Boolean.parseBoolean((String) map.get("allowOrientationChange")) : true;
        if (zzcfgVar == null) {
            int i3 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("AdWebView is null");
            return;
        }
        if ("portrait".equalsIgnoreCase(str)) {
            i = 7;
        } else if (!"landscape".equalsIgnoreCase(str)) {
            i = z ? -1 : 14;
        }
        zzcfgVar.zzau(i);
    }
}
