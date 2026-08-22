package com.google.android.gms.internal.ads;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.os.Build;
import android.util.Pair;
import android.util.Range;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.sqlite.db.framework.VERT.YcVWhnLsj;
import androidx.work.impl.constraints.controllers.pST.ehgOP;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class zzti {
    public final String zza;
    public final String zzb;
    public final String zzc;
    public final MediaCodecInfo.CodecCapabilities zzd;
    public final boolean zze;
    public final boolean zzf;
    public final boolean zzg;
    public final boolean zzh;
    private final boolean zzi;
    private int zzj;
    private int zzk;
    private float zzl;

    public zzti(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        str.getClass();
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = codecCapabilities;
        this.zzg = z;
        this.zze = z4;
        this.zzf = z6;
        this.zzh = z7;
        this.zzi = zzay.zzj(str2);
        this.zzl = -3.4028235E38f;
        this.zzj = -1;
        this.zzk = -1;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0059  */
    public static zzti zzd(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        boolean z6;
        boolean z7 = codecCapabilities != null && codecCapabilities.isFeatureSupported("adaptive-playback");
        boolean z8 = codecCapabilities != null && codecCapabilities.isFeatureSupported("tunneled-playback");
        boolean z9 = z5 || (codecCapabilities != null && codecCapabilities.isFeatureSupported("secure-playback"));
        if (Build.VERSION.SDK_INT < 35 || codecCapabilities == null || !codecCapabilities.isFeatureSupported("detached-surface")) {
            z6 = false;
        } else {
            String str4 = Build.MANUFACTURER;
            if (str4.equals("Xiaomi") || str4.equals("OPPO") || str4.equals("realme")) {
                z6 = false;
            } else {
                z6 = true;
            }
        }
        return new zzti(str, str2, str3, codecCapabilities, z, z2, z3, z7, z8, z9, z6);
    }

    private static Point zzj(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        String str = zzex.zza;
        return new Point((((i + widthAlignment) - 1) / widthAlignment) * widthAlignment, (((i2 + heightAlignment) - 1) / heightAlignment) * heightAlignment);
    }

    private final void zzk(String str) {
        String str2 = zzex.zza;
        StringBuilder sbM21m = CoroutineAdapterKt$$ExternalSyntheticLambda0.m21m("NoSupport [", str, "] [");
        sbM21m.append(this.zza);
        sbM21m.append(", ");
        sbM21m.append(this.zzb);
        sbM21m.append("] [");
        sbM21m.append(str2);
        sbM21m.append("]");
        zzea.zzb("MediaCodecInfo", sbM21m.toString());
    }

    private static boolean zzl(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        Range<Double> achievableFrameRatesFor;
        Point pointZzj = zzj(videoCapabilities, i, i2);
        int i3 = pointZzj.x;
        int i4 = pointZzj.y;
        if (d == -1.0d || d < 1.0d) {
            return videoCapabilities.isSizeSupported(i3, i4);
        }
        double dFloor = Math.floor(d);
        if (videoCapabilities.areSizeAndRateSupported(i3, i4, dFloor)) {
            return Build.VERSION.SDK_INT < 24 || (achievableFrameRatesFor = videoCapabilities.getAchievableFrameRatesFor(i3, i4)) == null || dFloor <= ((Double) achievableFrameRatesFor.getUpper()).doubleValue();
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:112:0x0161 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:16:0x0048  */
    /* JADX WARN: Code duplicated, block: B:18:0x0064  */
    /* JADX WARN: Code duplicated, block: B:20:0x006f  */
    /* JADX WARN: Code duplicated, block: B:22:0x0074  */
    /* JADX WARN: Code duplicated, block: B:28:0x0084  */
    /* JADX WARN: Code duplicated, block: B:30:0x008a  */
    /* JADX WARN: Code duplicated, block: B:31:0x008c  */
    /* JADX WARN: Code duplicated, block: B:33:0x0094  */
    /* JADX WARN: Code duplicated, block: B:35:0x0097  */
    /* JADX WARN: Code duplicated, block: B:40:0x009f  */
    /* JADX WARN: Code duplicated, block: B:43:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:45:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:46:0x00aa A[PHI: r5
  0x00aa: PHI (r5v4 int) = (r5v3 int), (r5v5 int) binds: [B:42:0x00a3, B:45:0x00a9] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:48:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:54:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:57:0x00da  */
    /* JADX WARN: Code duplicated, block: B:60:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:61:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:63:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:64:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:66:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:67:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:69:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:70:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:72:0x0100  */
    /* JADX WARN: Code duplicated, block: B:73:0x0103  */
    /* JADX WARN: Code duplicated, block: B:75:0x0108  */
    /* JADX WARN: Code duplicated, block: B:76:0x010b  */
    /* JADX WARN: Code duplicated, block: B:78:0x0110  */
    /* JADX WARN: Code duplicated, block: B:79:0x0113  */
    /* JADX WARN: Code duplicated, block: B:82:0x0119  */
    /* JADX WARN: Code duplicated, block: B:84:0x011e  */
    /* JADX WARN: Code duplicated, block: B:85:0x0120  */
    /* JADX WARN: Code duplicated, block: B:87:0x0125  */
    /* JADX WARN: Code duplicated, block: B:88:0x0127  */
    /* JADX WARN: Code duplicated, block: B:92:0x0139  */
    /* JADX WARN: Code duplicated, block: B:94:0x013f  */
    private final boolean zzm(zzz zzzVar, boolean z) {
        int iIntValue;
        int iIntValue2;
        int i;
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArrZzi;
        int length;
        int i2;
        MediaCodecInfo.CodecProfileLevel codecProfileLevel;
        MediaCodecInfo.CodecCapabilities codecCapabilities;
        int iIntValue3;
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        String str;
        int iHashCode;
        int i3 = zzuc.zza;
        Pair pairZza = zzdk.zza(zzzVar);
        String str2 = zzzVar.zzo;
        byte b = -1;
        if (str2 != null && str2.equals("video/mv-hevc")) {
            String strZze = zzay.zze(this.zzc);
            if (!strZze.equals("video/mv-hevc")) {
                if (strZze.equals("video/hevc")) {
                    String strZzh = zzfv.zzh(zzzVar.zzr);
                    if (strZzh == null) {
                        pairZza = null;
                    } else {
                        String strTrim = strZzh.trim();
                        String str3 = zzex.zza;
                        pairZza = zzdk.zzb(strZzh, strTrim.split("\\.", -1), zzzVar.zzE);
                    }
                }
                if (pairZza != null) {
                    iIntValue = ((Integer) pairZza.first).intValue();
                    iIntValue2 = ((Integer) pairZza.second).intValue();
                    i = 8;
                    if ("video/dolby-vision".equals(str2)) {
                        str = this.zzb;
                        iHashCode = str.hashCode();
                        if (iHashCode != -1662735862) {
                            if (iHashCode != -1662541442) {
                                if (iHashCode == 1331836730) {
                                    b = 0;
                                }
                            } else if (str.equals("video/hevc")) {
                                b = 1;
                            }
                        } else if (str.equals("video/av01")) {
                            b = 2;
                        }
                        if (b == 0) {
                            if (b != 1) {
                            }
                            iIntValue = 2;
                        } else {
                            iIntValue = 8;
                        }
                        iIntValue2 = 0;
                    }
                    if (this.zzi) {
                        codecProfileLevelArrZzi = zzi();
                        if (Build.VERSION.SDK_INT <= 23) {
                            codecCapabilities = this.zzd;
                            if (codecCapabilities != null) {
                                iIntValue3 = 0;
                            } else {
                                iIntValue3 = 0;
                            }
                            if (iIntValue3 >= 180000000) {
                                i = 1024;
                            } else if (iIntValue3 >= 120000000) {
                                i = 512;
                            } else if (iIntValue3 >= 60000000) {
                                i = 256;
                            } else if (iIntValue3 >= 30000000) {
                                i = 128;
                            } else if (iIntValue3 >= 18000000) {
                                i = 64;
                            } else if (iIntValue3 >= 12000000) {
                                i = 32;
                            } else if (iIntValue3 >= 7200000) {
                                i = 16;
                            } else if (iIntValue3 < 3600000) {
                                if (iIntValue3 >= 1800000) {
                                    i = 4;
                                } else if (iIntValue3 >= 800000) {
                                    i = 2;
                                } else {
                                    i = 1;
                                }
                            }
                            MediaCodecInfo.CodecProfileLevel codecProfileLevel2 = new MediaCodecInfo.CodecProfileLevel();
                            codecProfileLevel2.profile = 1;
                            codecProfileLevel2.level = i;
                            codecProfileLevelArrZzi = new MediaCodecInfo.CodecProfileLevel[]{codecProfileLevel2};
                        }
                        length = codecProfileLevelArrZzi.length;
                        for (i2 = 0; i2 < length; i2++) {
                            codecProfileLevel = codecProfileLevelArrZzi[i2];
                            if (codecProfileLevel.profile != iIntValue) {
                            }
                        }
                        zzk(CoroutineAdapterKt$$ExternalSyntheticLambda0.m("codec.profileLevel, ", zzzVar.zzk, ", ", this.zzc));
                        return false;
                    }
                    if (iIntValue == 42) {
                        iIntValue = 42;
                        codecProfileLevelArrZzi = zzi();
                        if (Build.VERSION.SDK_INT <= 23) {
                            codecCapabilities = this.zzd;
                            if (codecCapabilities != null) {
                                iIntValue3 = 0;
                            } else {
                                iIntValue3 = 0;
                            }
                            if (iIntValue3 >= 180000000) {
                                i = 1024;
                            } else if (iIntValue3 >= 120000000) {
                                i = 512;
                            } else if (iIntValue3 >= 60000000) {
                                i = 256;
                            } else if (iIntValue3 >= 30000000) {
                                i = 128;
                            } else if (iIntValue3 >= 18000000) {
                                i = 64;
                            } else if (iIntValue3 >= 12000000) {
                                i = 32;
                            } else if (iIntValue3 >= 7200000) {
                                i = 16;
                            } else if (iIntValue3 < 3600000) {
                                if (iIntValue3 >= 1800000) {
                                    i = 4;
                                } else if (iIntValue3 >= 800000) {
                                    i = 2;
                                } else {
                                    i = 1;
                                }
                            }
                            MediaCodecInfo.CodecProfileLevel codecProfileLevel3 = new MediaCodecInfo.CodecProfileLevel();
                            codecProfileLevel3.profile = 1;
                            codecProfileLevel3.level = i;
                            codecProfileLevelArrZzi = new MediaCodecInfo.CodecProfileLevel[]{codecProfileLevel3};
                        }
                        length = codecProfileLevelArrZzi.length;
                        while (i2 < length) {
                            codecProfileLevel = codecProfileLevelArrZzi[i2];
                            if (codecProfileLevel.profile != iIntValue) {
                            }
                        }
                        zzk(CoroutineAdapterKt$$ExternalSyntheticLambda0.m("codec.profileLevel, ", zzzVar.zzk, ", ", this.zzc));
                        return false;
                    }
                }
            }
        } else if (pairZza != null) {
            iIntValue = ((Integer) pairZza.first).intValue();
            iIntValue2 = ((Integer) pairZza.second).intValue();
            i = 8;
            if ("video/dolby-vision".equals(str2)) {
                str = this.zzb;
                iHashCode = str.hashCode();
                if (iHashCode != -1662735862) {
                    if (iHashCode != -1662541442) {
                        if (iHashCode == 1331836730 && str.equals("video/avc")) {
                            b = 0;
                        }
                    } else if (str.equals("video/hevc")) {
                        b = 1;
                    }
                } else if (str.equals("video/av01")) {
                    b = 2;
                }
                if (b == 0) {
                    iIntValue = 8;
                } else if (b != 1 || b == 2) {
                    iIntValue = 2;
                }
                iIntValue2 = 0;
            }
            if (this.zzi) {
                codecProfileLevelArrZzi = zzi();
                if (Build.VERSION.SDK_INT <= 23 && "video/x-vnd.on2.vp9".equals(this.zzb) && codecProfileLevelArrZzi.length == 0) {
                    codecCapabilities = this.zzd;
                    if (codecCapabilities != null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
                        iIntValue3 = 0;
                    } else {
                        iIntValue3 = ((Integer) videoCapabilities.getBitrateRange().getUpper()).intValue();
                    }
                    if (iIntValue3 >= 180000000) {
                        i = 1024;
                    } else if (iIntValue3 >= 120000000) {
                        i = 512;
                    } else if (iIntValue3 >= 60000000) {
                        i = 256;
                    } else if (iIntValue3 >= 30000000) {
                        i = 128;
                    } else if (iIntValue3 >= 18000000) {
                        i = 64;
                    } else if (iIntValue3 >= 12000000) {
                        i = 32;
                    } else if (iIntValue3 >= 7200000) {
                        i = 16;
                    } else if (iIntValue3 < 3600000) {
                        if (iIntValue3 >= 1800000) {
                            i = 4;
                        } else if (iIntValue3 >= 800000) {
                            i = 2;
                        } else {
                            i = 1;
                        }
                    }
                    MediaCodecInfo.CodecProfileLevel codecProfileLevel4 = new MediaCodecInfo.CodecProfileLevel();
                    codecProfileLevel4.profile = 1;
                    codecProfileLevel4.level = i;
                    codecProfileLevelArrZzi = new MediaCodecInfo.CodecProfileLevel[]{codecProfileLevel4};
                }
                length = codecProfileLevelArrZzi.length;
                while (i2 < length) {
                    codecProfileLevel = codecProfileLevelArrZzi[i2];
                    if (codecProfileLevel.profile != iIntValue && (codecProfileLevel.level >= iIntValue2 || !z)) {
                        if ("video/hevc".equals(this.zzb) && iIntValue == 2) {
                            String str4 = Build.DEVICE;
                            if ("sailfish".equals(str4) || "marlin".equals(str4)) {
                            }
                        }
                    }
                }
                zzk(CoroutineAdapterKt$$ExternalSyntheticLambda0.m("codec.profileLevel, ", zzzVar.zzk, ", ", this.zzc));
                return false;
            }
            if (iIntValue == 42) {
                iIntValue = 42;
                codecProfileLevelArrZzi = zzi();
                if (Build.VERSION.SDK_INT <= 23) {
                    codecCapabilities = this.zzd;
                    if (codecCapabilities != null) {
                        iIntValue3 = 0;
                    } else {
                        iIntValue3 = 0;
                    }
                    if (iIntValue3 >= 180000000) {
                        i = 1024;
                    } else if (iIntValue3 >= 120000000) {
                        i = 512;
                    } else if (iIntValue3 >= 60000000) {
                        i = 256;
                    } else if (iIntValue3 >= 30000000) {
                        i = 128;
                    } else if (iIntValue3 >= 18000000) {
                        i = 64;
                    } else if (iIntValue3 >= 12000000) {
                        i = 32;
                    } else if (iIntValue3 >= 7200000) {
                        i = 16;
                    } else if (iIntValue3 < 3600000) {
                        if (iIntValue3 >= 1800000) {
                            i = 4;
                        } else if (iIntValue3 >= 800000) {
                            i = 2;
                        } else {
                            i = 1;
                        }
                    }
                    MediaCodecInfo.CodecProfileLevel codecProfileLevel5 = new MediaCodecInfo.CodecProfileLevel();
                    codecProfileLevel5.profile = 1;
                    codecProfileLevel5.level = i;
                    codecProfileLevelArrZzi = new MediaCodecInfo.CodecProfileLevel[]{codecProfileLevel5};
                }
                length = codecProfileLevelArrZzi.length;
                while (i2 < length) {
                    codecProfileLevel = codecProfileLevelArrZzi[i2];
                    if (codecProfileLevel.profile != iIntValue) {
                    }
                }
                zzk(CoroutineAdapterKt$$ExternalSyntheticLambda0.m("codec.profileLevel, ", zzzVar.zzk, ", ", this.zzc));
                return false;
            }
        }
        return true;
    }

    private final boolean zzo(zzz zzzVar) {
        String str = this.zzb;
        return str.equals(zzzVar.zzo) || str.equals(zzuc.zzb(zzzVar));
    }

    public final String toString() {
        return this.zza;
    }

    public final float zza(int i, int i2) {
        if (!this.zzi) {
            return -3.4028235E38f;
        }
        float f = this.zzl;
        if (f != -3.4028235E38f && this.zzj == i && this.zzk == i2) {
            return f;
        }
        float f2 = 1024.0f;
        if (!zzh(i, i2, 1024.0d)) {
            float f3 = 0.0f;
            while (true) {
                float f4 = f2 - f3;
                if (Math.abs(f4) <= 5.0f) {
                    break;
                }
                float f5 = (f4 / 2.0f) + f3;
                boolean zZzh = zzh(i, i2, f5);
                if (true == zZzh) {
                    f3 = f5;
                }
                if (true != zZzh) {
                    f2 = f5;
                }
            }
            f2 = f3;
        }
        this.zzl = f2;
        this.zzj = i;
        this.zzk = i2;
        return f2;
    }

    public final Point zzb(int i, int i2) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
        if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
            return null;
        }
        return zzj(videoCapabilities, i, i2);
    }

    public final zzie zzc(zzz zzzVar, zzz zzzVar2) {
        int i;
        int i2 = true != Objects.equals(zzzVar.zzo, zzzVar2.zzo) ? 8 : 0;
        if (this.zzi) {
            if (zzzVar.zzA != zzzVar2.zzA) {
                i2 |= 1024;
            }
            boolean z = (zzzVar.zzv == zzzVar2.zzv && zzzVar.zzw == zzzVar2.zzw) ? false : true;
            if (!this.zze && z) {
                i2 |= 512;
            }
            zzk zzkVar = zzzVar.zzE;
            if ((!zzk.zzg(zzkVar) || !zzk.zzg(zzzVar2.zzE)) && !Objects.equals(zzkVar, zzzVar2.zzE)) {
                i2 |= 2048;
            }
            String str = this.zza;
            if (Build.MODEL.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(str) && !zzzVar.zzd(zzzVar2)) {
                i2 |= 2;
            }
            int i3 = zzzVar.zzx;
            if (i3 != -1 && (i = zzzVar.zzy) != -1 && i3 == zzzVar2.zzx && i == zzzVar2.zzy && z) {
                i2 |= 2;
            }
            if (i2 == 0) {
                return new zzie(str, zzzVar, zzzVar2, true == zzzVar.zzd(zzzVar2) ? 3 : 2, 0);
            }
        } else {
            if (zzzVar.zzG != zzzVar2.zzG) {
                i2 |= 4096;
            }
            if (zzzVar.zzH != zzzVar2.zzH) {
                i2 |= 8192;
            }
            if (zzzVar.zzI != zzzVar2.zzI) {
                i2 |= 16384;
            }
            if (i2 == 0 && "audio/mp4a-latm".equals(this.zzb)) {
                int i4 = zzuc.zza;
                Pair pairZza = zzdk.zza(zzzVar);
                Pair pairZza2 = zzdk.zza(zzzVar2);
                if (pairZza != null && pairZza2 != null) {
                    int iIntValue = ((Integer) pairZza.first).intValue();
                    int iIntValue2 = ((Integer) pairZza2.first).intValue();
                    if (iIntValue == 42 && iIntValue2 == 42) {
                        return new zzie(this.zza, zzzVar, zzzVar2, 3, 0);
                    }
                }
            }
            if (!zzzVar.zzd(zzzVar2)) {
                i2 |= 32;
            }
            if ("audio/opus".equals(this.zzb)) {
                i2 |= 2;
            }
            if (i2 == 0) {
                return new zzie(this.zza, zzzVar, zzzVar2, 1, 0);
            }
        }
        return new zzie(this.zza, zzzVar, zzzVar2, 0, i2);
    }

    public final boolean zze(zzz zzzVar) {
        return zzo(zzzVar) && zzm(zzzVar, false) && zzn(zzzVar);
    }

    public final boolean zzf(zzz zzzVar) {
        int i;
        int i2;
        if (!zzo(zzzVar) || !zzm(zzzVar, true) || !zzn(zzzVar)) {
            return false;
        }
        if (this.zzi) {
            int i3 = zzzVar.zzv;
            if (i3 <= 0 || (i2 = zzzVar.zzw) <= 0) {
                return true;
            }
            return zzh(i3, i2, zzzVar.zzz);
        }
        int i4 = zzzVar.zzH;
        if (i4 != -1) {
            MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
            if (codecCapabilities == null) {
                zzk("sampleRate.caps");
                return false;
            }
            MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
            if (audioCapabilities == null) {
                zzk("sampleRate.aCaps");
                return false;
            }
            if (!audioCapabilities.isSampleRateSupported(i4)) {
                zzk(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i4, "sampleRate.support, "));
                return false;
            }
        }
        int i5 = zzzVar.zzG;
        if (i5 == -1) {
            return true;
        }
        MediaCodecInfo.CodecCapabilities codecCapabilities2 = this.zzd;
        if (codecCapabilities2 == null) {
            zzk("channelCount.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities2 = codecCapabilities2.getAudioCapabilities();
        if (audioCapabilities2 == null) {
            zzk("channelCount.aCaps");
            return false;
        }
        String str = this.zza;
        String str2 = this.zzb;
        int maxInputChannelCount = audioCapabilities2.getMaxInputChannelCount();
        if (maxInputChannelCount <= 1 && ((Build.VERSION.SDK_INT < 26 || maxInputChannelCount <= 0) && !"audio/mpeg".equals(str2) && !"audio/3gpp".equals(str2) && !"audio/amr-wb".equals(str2) && !"audio/mp4a-latm".equals(str2) && !"audio/vorbis".equals(str2) && !"audio/opus".equals(str2) && !"audio/raw".equals(str2) && !"audio/flac".equals(str2) && !"audio/g711-alaw".equals(str2) && !"audio/g711-mlaw".equals(str2) && !"audio/gsm".equals(str2))) {
            if ("audio/ac3".equals(str2)) {
                i = 6;
            } else {
                i = "audio/eac3".equals(str2) ? 16 : 30;
            }
            zzea.zzf("MediaCodecInfo", "AssumedMaxChannelAdjustment: " + str + ", [" + maxInputChannelCount + " to " + i + "]");
            maxInputChannelCount = i;
        }
        if (maxInputChannelCount >= i5) {
            return true;
        }
        zzk(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i5, "channelCount.support, "));
        return false;
    }

    public final boolean zzg(zzz zzzVar) {
        if (this.zzi) {
            return this.zze;
        }
        int i = zzuc.zza;
        Pair pairZza = zzdk.zza(zzzVar);
        return pairZza != null && ((Integer) pairZza.first).intValue() == 42;
    }

    public final MediaCodecInfo.CodecProfileLevel[] zzi() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
        return (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) ? new MediaCodecInfo.CodecProfileLevel[0] : codecProfileLevelArr;
    }

    private final boolean zzn(zzz zzzVar) {
        return (Objects.equals(zzzVar.zzo, "audio/flac") && zzzVar.zzI == 22 && Build.VERSION.SDK_INT < 34 && this.zza.equals(ehgOP.ERytniFdBFcw)) ? false : true;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0046 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:22:0x0048  */
    public final boolean zzh(int i, int i2, double d) {
        String str;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
        if (codecCapabilities == null) {
            zzk("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            zzk("sizeAndRate.vCaps");
            return false;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            int iZza = zztk.zza(videoCapabilities, i, i2, d);
            if (iZza != 2) {
                if (iZza == 1) {
                    StringBuilder sbM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(YcVWhnLsj.kRqu, i, "x", i2, "@");
                    sbM.append(d);
                    zzk(sbM.toString());
                    return false;
                }
                if (!zzl(videoCapabilities, i, i2, d)) {
                    if (i < i2) {
                        str = this.zza;
                        if ("OMX.MTK.VIDEO.DECODER.HEVC".equals(str)) {
                            StringBuilder sbM2 = CoroutineAdapterKt$$ExternalSyntheticLambda0.m("sizeAndRate.rotated, ", i, "x", i2, "@");
                            sbM2.append(d);
                            String string = sbM2.toString();
                            String str2 = this.zzb;
                            String str3 = zzex.zza;
                            StringBuilder sbM22m = CoroutineAdapterKt$$ExternalSyntheticLambda0.m22m("AssumedSupport [", string, "] [", str, ", ");
                            sbM22m.append(str2);
                            sbM22m.append("] [");
                            sbM22m.append(str3);
                            sbM22m.append("]");
                            zzea.zzb("MediaCodecInfo", sbM22m.toString());
                        } else {
                            StringBuilder sbM3 = CoroutineAdapterKt$$ExternalSyntheticLambda0.m("sizeAndRate.rotated, ", i, "x", i2, "@");
                            sbM3.append(d);
                            String string2 = sbM3.toString();
                            String str4 = this.zzb;
                            String str5 = zzex.zza;
                            StringBuilder sbM22m2 = CoroutineAdapterKt$$ExternalSyntheticLambda0.m22m("AssumedSupport [", string2, "] [", str, ", ");
                            sbM22m2.append(str4);
                            sbM22m2.append("] [");
                            sbM22m2.append(str5);
                            sbM22m2.append("]");
                            zzea.zzb("MediaCodecInfo", sbM22m2.toString());
                        }
                    }
                    StringBuilder sbM4 = CoroutineAdapterKt$$ExternalSyntheticLambda0.m("sizeAndRate.support, ", i, "x", i2, "@");
                    sbM4.append(d);
                    zzk(sbM4.toString());
                    return false;
                }
            }
        } else if (!zzl(videoCapabilities, i, i2, d)) {
            if (i < i2) {
                str = this.zza;
                if (("OMX.MTK.VIDEO.DECODER.HEVC".equals(str) || !"mcv5a".equals(Build.DEVICE)) && zzl(videoCapabilities, i2, i, d)) {
                    StringBuilder sbM5 = CoroutineAdapterKt$$ExternalSyntheticLambda0.m("sizeAndRate.rotated, ", i, "x", i2, "@");
                    sbM5.append(d);
                    String string3 = sbM5.toString();
                    String str6 = this.zzb;
                    String str7 = zzex.zza;
                    StringBuilder sbM22m3 = CoroutineAdapterKt$$ExternalSyntheticLambda0.m22m("AssumedSupport [", string3, "] [", str, ", ");
                    sbM22m3.append(str6);
                    sbM22m3.append("] [");
                    sbM22m3.append(str7);
                    sbM22m3.append("]");
                    zzea.zzb("MediaCodecInfo", sbM22m3.toString());
                }
            }
            StringBuilder sbM6 = CoroutineAdapterKt$$ExternalSyntheticLambda0.m("sizeAndRate.support, ", i, "x", i2, "@");
            sbM6.append(d);
            zzk(sbM6.toString());
            return false;
        }
        return true;
    }
}
