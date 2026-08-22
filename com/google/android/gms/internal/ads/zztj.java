package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.os.Build;
import java.util.List;
import okhttp3.internal.platform.Jdk9Platform$$ExternalSyntheticApiModelOutline0;

/* JADX INFO: loaded from: classes.dex */
final class zztj {
    /* JADX WARN: Code duplicated, block: B:13:0x0026  */
    public static int zza(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        List supportedPerformancePoints = videoCapabilities.getSupportedPerformancePoints();
        if (supportedPerformancePoints == null || supportedPerformancePoints.isEmpty()) {
            return 0;
        }
        int iZzc = zzc(supportedPerformancePoints, Jdk9Platform$$ExternalSyntheticApiModelOutline0.m(i, i2, (int) d));
        boolean z = true;
        if (iZzc == 1 && zztk.zza == null) {
            if (Build.VERSION.SDK_INT >= 35) {
                z = false;
            } else {
                int iZzb = zzb(false);
                int iZzb2 = zzb(true);
                if (iZzb != 0 && (iZzb2 != 0 ? !(iZzb != 2 || iZzb2 != 2) : iZzb == 2)) {
                    z = false;
                }
            }
            zztk.zza = Boolean.valueOf(z);
            if (zztk.zza.booleanValue()) {
                return 0;
            }
        }
        return iZzc;
    }

    private static int zzb(boolean z) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        List supportedPerformancePoints;
        try {
            zzx zzxVar = new zzx();
            zzxVar.zzah("video/avc");
            zzz zzzVarZzan = zzxVar.zzan();
            if (zzzVarZzan.zzo != null) {
                List listZze = zzuc.zze(zztr.zza, zzzVarZzan, z, false);
                for (int i = 0; i < listZze.size(); i++) {
                    if (((zzti) listZze.get(i)).zzd != null && (videoCapabilities = ((zzti) listZze.get(i)).zzd.getVideoCapabilities()) != null && (supportedPerformancePoints = videoCapabilities.getSupportedPerformancePoints()) != null && !supportedPerformancePoints.isEmpty()) {
                        Jdk9Platform$$ExternalSyntheticApiModelOutline0.m121m();
                        return zzc(supportedPerformancePoints, Jdk9Platform$$ExternalSyntheticApiModelOutline0.m());
                    }
                }
            }
        } catch (zztw unused) {
        }
        return 0;
    }

    private static int zzc(List list, MediaCodecInfo.VideoCapabilities.PerformancePoint performancePoint) {
        for (int i = 0; i < list.size(); i++) {
            if (Jdk9Platform$$ExternalSyntheticApiModelOutline0.m(list.get(i)).covers(performancePoint)) {
                return 2;
            }
        }
        return 1;
    }
}
