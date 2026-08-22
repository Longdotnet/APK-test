package com.google.android.gms.ads.internal.util;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.util.Range;
import androidx.core.internal.view.Oteb.nYVxXTZQ;
import com.google.android.gms.auth.api.LNi.xPQrbOSWiEdU;
import com.google.android.gms.common.stats.ZnFR.FKidOcdAYt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzcj {
    public static List zzb;
    public static final HashMap zza = new HashMap();
    public static final Object zzc = new Object();

    public static List zza(String str) {
        ArrayList arrayList;
        Object obj = zzc;
        synchronized (obj) {
            HashMap map = zza;
            if (map.containsKey(str)) {
                return (List) map.get(str);
            }
            try {
                synchronized (obj) {
                    try {
                        if (zzb == null) {
                            zzb = Arrays.asList(new MediaCodecList(0).getCodecInfos());
                        }
                        arrayList = new ArrayList();
                        for (MediaCodecInfo mediaCodecInfo : zzb) {
                            if (!mediaCodecInfo.isEncoder() && Arrays.asList(mediaCodecInfo.getSupportedTypes()).contains(str)) {
                                HashMap map2 = new HashMap();
                                map2.put(FKidOcdAYt.gsEYcOWfFeMVeNS, mediaCodecInfo.getName());
                                MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
                                ArrayList arrayList2 = new ArrayList();
                                for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : capabilitiesForType.profileLevels) {
                                    arrayList2.add(new Integer[]{Integer.valueOf(codecProfileLevel.profile), Integer.valueOf(codecProfileLevel.level)});
                                }
                                map2.put("profileLevels", arrayList2);
                                MediaCodecInfo.VideoCapabilities videoCapabilities = capabilitiesForType.getVideoCapabilities();
                                if (videoCapabilities != null) {
                                    map2.put("bitRatesBps", zzb(videoCapabilities.getBitrateRange()));
                                    map2.put("widthAlignment", Integer.valueOf(videoCapabilities.getWidthAlignment()));
                                    map2.put("heightAlignment", Integer.valueOf(videoCapabilities.getHeightAlignment()));
                                    map2.put(nYVxXTZQ.unXBxoGsnjoR, zzb(videoCapabilities.getSupportedFrameRates()));
                                    map2.put("widths", zzb(videoCapabilities.getSupportedWidths()));
                                    map2.put("heights", zzb(videoCapabilities.getSupportedHeights()));
                                }
                                map2.put(xPQrbOSWiEdU.LoudJAlvWrXkaR, Integer.valueOf(capabilitiesForType.getMaxSupportedInstances()));
                                arrayList.add(map2);
                            }
                        }
                        zza.put(str, arrayList);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return arrayList;
            } catch (LinkageError e) {
                e = e;
                HashMap map3 = new HashMap();
                map3.put("error", e.getClass().getSimpleName());
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(map3);
                zza.put(str, arrayList3);
                return arrayList3;
            } catch (RuntimeException e2) {
                e = e2;
                HashMap map4 = new HashMap();
                map4.put("error", e.getClass().getSimpleName());
                ArrayList arrayList4 = new ArrayList();
                arrayList4.add(map4);
                zza.put(str, arrayList4);
                return arrayList4;
            }
        }
    }

    public static Integer[] zzb(Range range) {
        return new Integer[]{(Integer) range.getLower(), (Integer) range.getUpper()};
    }
}
