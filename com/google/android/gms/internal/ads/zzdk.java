package com.google.android.gms.internal.ads;

import android.util.Pair;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.sqlite.db.framework.VERT.YcVWhnLsj;
import com.google.android.gms.ads.internal.offline.buffering.Dk.eoBKjVuj;
import com.google.android.gms.ads.jY.UUFMQdNK;
import com.google.android.gms.games.event.AfJ.oKjScaD;
import com.google.android.gms.games.snapshot.Xa.JrbhsraGtto;
import com.google.android.gms.signin.internal.FVfQ.GsPcpBmONXh;
import com.google.protobuf.DescriptorProtos;
import com.google.zxing.BarcodeFormat$EnumUnboxingLocalUtility;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlinx.coroutines.internal.Jbo.ygoi;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdk {
    public static final /* synthetic */ int zza = 0;
    private static final byte[] zzb = {0, 0, 0, 1};
    private static final String[] zzc = {"", eoBKjVuj.XCYnYBNUg, "B", "C"};
    private static final Pattern zzd = Pattern.compile("^\\D?(\\d+)$");

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:107:0x0188  */
    /* JADX WARN: Code duplicated, block: B:25:0x0052  */
    public static Pair zzb(String str, String[] strArr, zzk zzkVar) {
        int i;
        Integer num;
        if (strArr.length < 4) {
            BarcodeFormat$EnumUnboxingLocalUtility.m(str, "Ignoring malformed HEVC codec string: ", "CodecSpecificDataUtil");
            return null;
        }
        Matcher matcher = zzd.matcher(strArr[1]);
        if (!matcher.matches()) {
            BarcodeFormat$EnumUnboxingLocalUtility.m(str, "Ignoring malformed HEVC codec string: ", "CodecSpecificDataUtil");
            return null;
        }
        String strGroup = matcher.group(1);
        byte b = 6;
        if ("1".equals(strGroup)) {
            i = 1;
        } else if ("2".equals(strGroup)) {
            i = (zzkVar == null || zzkVar.zzd != 6) ? 2 : 4096;
        } else {
            if (!"6".equals(strGroup)) {
                BarcodeFormat$EnumUnboxingLocalUtility.m(strGroup, "Unknown HEVC profile string: ", "CodecSpecificDataUtil");
                return null;
            }
            i = 6;
        }
        String str2 = strArr[3];
        if (str2 != null) {
            switch (str2.hashCode()) {
                case 70821:
                    if (!str2.equals("H30")) {
                        b = -1;
                    } else {
                        b = 13;
                    }
                    break;
                case 70914:
                    if (!str2.equals("H60")) {
                        b = -1;
                    } else {
                        b = 14;
                    }
                    break;
                case 70917:
                    if (!str2.equals("H63")) {
                        b = -1;
                    } else {
                        b = 15;
                    }
                    break;
                case 71007:
                    if (!str2.equals("H90")) {
                        b = -1;
                    } else {
                        b = 16;
                    }
                    break;
                case 71010:
                    if (!str2.equals("H93")) {
                        b = -1;
                    } else {
                        b = 17;
                    }
                    break;
                case 74665:
                    if (!str2.equals("L30")) {
                        b = -1;
                    } else {
                        b = 0;
                    }
                    break;
                case 74758:
                    if (!str2.equals(ygoi.pmhHV)) {
                        b = -1;
                    } else {
                        b = 1;
                    }
                    break;
                case 74761:
                    if (!str2.equals(UUFMQdNK.hyxbRb)) {
                        b = -1;
                    } else {
                        b = 2;
                    }
                    break;
                case 74851:
                    if (!str2.equals("L90")) {
                        b = -1;
                    } else {
                        b = 3;
                    }
                    break;
                case 74854:
                    if (!str2.equals("L93")) {
                        b = -1;
                    } else {
                        b = 4;
                    }
                    break;
                case 2193639:
                    if (!str2.equals("H120")) {
                        b = -1;
                    } else {
                        b = 18;
                    }
                    break;
                case 2193642:
                    if (!str2.equals("H123")) {
                        b = -1;
                    } else {
                        b = 19;
                    }
                    break;
                case 2193732:
                    if (!str2.equals("H150")) {
                        b = -1;
                    } else {
                        b = 20;
                    }
                    break;
                case 2193735:
                    if (!str2.equals("H153")) {
                        b = -1;
                    } else {
                        b = 21;
                    }
                    break;
                case 2193738:
                    if (!str2.equals("H156")) {
                        b = -1;
                    } else {
                        b = 22;
                    }
                    break;
                case 2193825:
                    if (!str2.equals("H180")) {
                        b = -1;
                    } else {
                        b = 23;
                    }
                    break;
                case 2193828:
                    if (!str2.equals("H183")) {
                        b = -1;
                    } else {
                        b = 24;
                    }
                    break;
                case 2193831:
                    if (!str2.equals("H186")) {
                        b = -1;
                    } else {
                        b = 25;
                    }
                    break;
                case 2312803:
                    if (!str2.equals("L120")) {
                        b = -1;
                    } else {
                        b = 5;
                    }
                    break;
                case 2312806:
                    if (!str2.equals("L123")) {
                        b = -1;
                    }
                    break;
                case 2312896:
                    if (!str2.equals("L150")) {
                        b = -1;
                    } else {
                        b = 7;
                    }
                    break;
                case 2312899:
                    if (!str2.equals("L153")) {
                        b = -1;
                    } else {
                        b = 8;
                    }
                    break;
                case 2312902:
                    if (!str2.equals("L156")) {
                        b = -1;
                    } else {
                        b = 9;
                    }
                    break;
                case 2312989:
                    if (!str2.equals("L180")) {
                        b = -1;
                    } else {
                        b = 10;
                    }
                    break;
                case 2312992:
                    if (!str2.equals("L183")) {
                        b = -1;
                    } else {
                        b = 11;
                    }
                    break;
                case 2312995:
                    if (!str2.equals("L186")) {
                        b = -1;
                    } else {
                        b = 12;
                    }
                    break;
                default:
                    b = -1;
                    break;
            }
            switch (b) {
                case 0:
                    num = 1;
                    break;
                case 1:
                    num = 4;
                    break;
                case 2:
                    num = 16;
                    break;
                case 3:
                    num = 64;
                    break;
                case 4:
                    num = 256;
                    break;
                case 5:
                    num = 1024;
                    break;
                case 6:
                    num = 4096;
                    break;
                case 7:
                    num = 16384;
                    break;
                case 8:
                    num = 65536;
                    break;
                case 9:
                    num = 262144;
                    break;
                case 10:
                    num = 1048576;
                    break;
                case 11:
                    num = 4194304;
                    break;
                case 12:
                    num = 16777216;
                    break;
                case 13:
                    num = 2;
                    break;
                case 14:
                    num = 8;
                    break;
                case 15:
                    num = 32;
                    break;
                case 16:
                    num = 128;
                    break;
                case 17:
                    num = 512;
                    break;
                case 18:
                    num = 2048;
                    break;
                case 19:
                    num = 8192;
                    break;
                case 20:
                    num = 32768;
                    break;
                case 21:
                    num = 131072;
                    break;
                case 22:
                    num = 524288;
                    break;
                case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
                    num = 2097152;
                    break;
                case 24:
                    num = 8388608;
                    break;
                case 25:
                    num = 33554432;
                    break;
                default:
                    num = null;
                    break;
            }
        } else {
            num = null;
        }
        if (num != null) {
            return new Pair(Integer.valueOf(i), num);
        }
        BarcodeFormat$EnumUnboxingLocalUtility.m(str2, "Unknown HEVC level string: ", "CodecSpecificDataUtil");
        return null;
    }

    public static String zzc(int i, int i2, int i3) {
        return String.format("avc1.%02X%02X%02X", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public static String zzd(int i, boolean z, int i2, int i3, int[] iArr, int i4) {
        Object[] objArr = {zzc[i], Integer.valueOf(i2), Integer.valueOf(i3), Character.valueOf(true != z ? 'L' : 'H'), Integer.valueOf(i4)};
        String str = zzex.zza;
        StringBuilder sb = new StringBuilder(String.format(Locale.US, "hvc1.%s%d.%X.%c%d", objArr));
        int i5 = 6;
        while (i5 > 0) {
            int i6 = i5 - 1;
            if (iArr[i6] != 0) {
                break;
            }
            i5 = i6;
        }
        for (int i7 = 0; i7 < i5; i7++) {
            sb.append(String.format(".%02X", Integer.valueOf(iArr[i7])));
        }
        return sb.toString();
    }

    public static byte[] zze(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2 + 4];
        System.arraycopy(zzb, 0, bArr2, 0, 4);
        System.arraycopy(bArr, i, bArr2, 4, i2);
        return bArr2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:145:0x0277  */
    /* JADX WARN: Code duplicated, block: B:15:0x0058  */
    /* JADX WARN: Code duplicated, block: B:57:0x010a  */
    /* JADX WARN: Failed to clean up code after switch over string restore
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r3v39 int, still in use, count: 1, list:
  (r3v39 int) from 0x0114: SWITCH (r3v39 int)
 case 1567: goto B:71:0x0148
 case 1568: goto B:68:0x0138
 case 1569: goto B:65:0x0128
 case 1570: goto B:62:0x0118
 default: goto B:57:0x010a A[RegionRef:SW:60] (LINE:277)
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
    	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
    	at jadx.core.utils.InsnRemover.remove(InsnRemover.java:226)
    	at jadx.core.utils.InsnRemover.remove(InsnRemover.java:215)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.replaceWithMergedSwitch(SwitchOverStringVisitor.java:355)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:111)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:72)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:140)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:47)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:66)
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static Pair zza(zzz zzzVar) {
        byte b;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Integer num;
        Integer num2;
        String str = zzzVar.zzk;
        if (str != null) {
            String[] strArrSplit = str.split("\\.");
            int i8 = 8;
            int i9 = 3;
            int i10 = 2;
            if (!"video/dolby-vision".equals(zzzVar.zzo)) {
                int i11 = 0;
                String str2 = strArrSplit[0];
                switch (str2.hashCode()) {
                    case 2986313:
                        b = !str2.equals("ac-4") ? (byte) -1 : (byte) 8;
                        break;
                    case 3004662:
                        b = !str2.equals("av01") ? (byte) -1 : (byte) 6;
                        break;
                    case 3006243:
                        b = !str2.equals("avc1") ? (byte) -1 : (byte) 1;
                        break;
                    case 3006244:
                        b = !str2.equals("avc2") ? (byte) -1 : (byte) 2;
                        break;
                    case 3199032:
                        b = !str2.equals("hev1") ? (byte) -1 : (byte) 4;
                        break;
                    case 3214780:
                        b = !str2.equals("hvc1") ? (byte) -1 : (byte) 5;
                        break;
                    case 3356560:
                        b = !str2.equals("mp4a") ? (byte) -1 : (byte) 7;
                        break;
                    case 3475740:
                        b = !str2.equals(YcVWhnLsj.WcuCXR) ? (byte) -1 : (byte) 0;
                        break;
                    case 3624515:
                        b = !str2.equals("vp09") ? (byte) -1 : (byte) 3;
                        break;
                    default:
                        b = -1;
                        break;
                }
                switch (b) {
                    case 0:
                        String str3 = zzzVar.zzk;
                        Pair pair = new Pair(1, 1);
                        if (strArrSplit.length < 3) {
                            BarcodeFormat$EnumUnboxingLocalUtility.m(str3, GsPcpBmONXh.eCePQyJmiZPU, "CodecSpecificDataUtil");
                            return pair;
                        }
                        try {
                            return new Pair(Integer.valueOf(Integer.parseInt(strArrSplit[1])), Integer.valueOf(Integer.parseInt(strArrSplit[2])));
                        } catch (NumberFormatException unused) {
                            BarcodeFormat$EnumUnboxingLocalUtility.m(str3, "Ignoring malformed H263 codec string: ", "CodecSpecificDataUtil");
                            return pair;
                        }
                    case 1:
                    case 2:
                        String str4 = zzzVar.zzk;
                        int length = strArrSplit.length;
                        if (length >= 2) {
                            try {
                                if (strArrSplit[1].length() == 6) {
                                    i = Integer.parseInt(strArrSplit[1].substring(0, 2), 16);
                                    i2 = Integer.parseInt(strArrSplit[1].substring(4), 16);
                                } else if (length < 3) {
                                    zzea.zzf("CodecSpecificDataUtil", "Ignoring malformed AVC codec string: " + str4);
                                } else {
                                    i = Integer.parseInt(strArrSplit[1]);
                                    i2 = Integer.parseInt(strArrSplit[2]);
                                }
                                if (i == 66) {
                                    i10 = 1;
                                } else if (i != 77) {
                                    if (i == 88) {
                                        i10 = 4;
                                    } else if (i == 100) {
                                        i10 = 8;
                                    } else if (i == 110) {
                                        i10 = 16;
                                    } else if (i != 122) {
                                        i10 = i != 244 ? -1 : 64;
                                    } else {
                                        i10 = 32;
                                    }
                                }
                                if (i10 == -1) {
                                    CoroutineAdapterKt$$ExternalSyntheticLambda0.m23m(i, "Unknown AVC profile: ", "CodecSpecificDataUtil");
                                } else {
                                    switch (i2) {
                                        case 10:
                                            i3 = 1;
                                            break;
                                        case 11:
                                            i3 = 4;
                                            break;
                                        case 12:
                                            i3 = 8;
                                            break;
                                        case 13:
                                            i3 = 16;
                                            break;
                                        default:
                                            switch (i2) {
                                                case 20:
                                                    i3 = 32;
                                                    break;
                                                case 21:
                                                    i3 = 64;
                                                    break;
                                                case 22:
                                                    i3 = 128;
                                                    break;
                                                default:
                                                    switch (i2) {
                                                        case 30:
                                                            i3 = 256;
                                                            break;
                                                        case DescriptorProtos.FileOptions.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
                                                            i3 = 512;
                                                            break;
                                                        case 32:
                                                            i3 = 1024;
                                                            break;
                                                        default:
                                                            switch (i2) {
                                                                case DescriptorProtos.FileOptions.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
                                                                    i3 = 2048;
                                                                    break;
                                                                case DescriptorProtos.FileOptions.PHP_NAMESPACE_FIELD_NUMBER /* 41 */:
                                                                    i3 = 4096;
                                                                    break;
                                                                case 42:
                                                                    i3 = 8192;
                                                                    break;
                                                                default:
                                                                    switch (i2) {
                                                                        case 50:
                                                                            i3 = 16384;
                                                                            break;
                                                                        case 51:
                                                                            i3 = 32768;
                                                                            break;
                                                                        case 52:
                                                                            i3 = 65536;
                                                                            break;
                                                                        default:
                                                                            i3 = -1;
                                                                            break;
                                                                    }
                                                                    break;
                                                            }
                                                            break;
                                                    }
                                                    break;
                                            }
                                            break;
                                    }
                                    if (i3 != -1) {
                                        return new Pair(Integer.valueOf(i10), Integer.valueOf(i3));
                                    }
                                    CoroutineAdapterKt$$ExternalSyntheticLambda0.m23m(i2, "Unknown AVC level: ", "CodecSpecificDataUtil");
                                }
                            } catch (NumberFormatException unused2) {
                                BarcodeFormat$EnumUnboxingLocalUtility.m(str4, "Ignoring malformed AVC codec string: ", "CodecSpecificDataUtil");
                            }
                        } else {
                            BarcodeFormat$EnumUnboxingLocalUtility.m(str4, "Ignoring malformed AVC codec string: ", "CodecSpecificDataUtil");
                        }
                        break;
                    case 3:
                        String str5 = zzzVar.zzk;
                        if (strArrSplit.length >= 3) {
                            try {
                                int i12 = Integer.parseInt(strArrSplit[1]);
                                int i13 = Integer.parseInt(strArrSplit[2]);
                                if (i12 == 0) {
                                    i4 = 1;
                                } else if (i12 == 1) {
                                    i4 = 2;
                                } else if (i12 != 2) {
                                    i4 = i12 != 3 ? -1 : 8;
                                } else {
                                    i4 = 4;
                                }
                                if (i4 == -1) {
                                    CoroutineAdapterKt$$ExternalSyntheticLambda0.m23m(i12, "Unknown VP9 profile: ", "CodecSpecificDataUtil");
                                } else {
                                    if (i13 == 10) {
                                        i10 = 1;
                                    } else if (i13 != 11) {
                                        if (i13 == 20) {
                                            i10 = 4;
                                        } else if (i13 == 21) {
                                            i10 = 8;
                                        } else if (i13 == 30) {
                                            i10 = 16;
                                        } else if (i13 == 31) {
                                            i10 = 32;
                                        } else if (i13 == 40) {
                                            i10 = 64;
                                        } else if (i13 == 41) {
                                            i10 = 128;
                                        } else if (i13 == 50) {
                                            i10 = 256;
                                        } else if (i13 != 51) {
                                            switch (i13) {
                                                case 60:
                                                    i10 = 2048;
                                                    break;
                                                case 61:
                                                    i10 = 4096;
                                                    break;
                                                case 62:
                                                    i10 = 8192;
                                                    break;
                                                default:
                                                    i10 = -1;
                                                    break;
                                            }
                                        } else {
                                            i10 = 512;
                                        }
                                    }
                                    if (i10 != -1) {
                                        return new Pair(Integer.valueOf(i4), Integer.valueOf(i10));
                                    }
                                    CoroutineAdapterKt$$ExternalSyntheticLambda0.m23m(i13, "Unknown VP9 level: ", "CodecSpecificDataUtil");
                                }
                            } catch (NumberFormatException unused3) {
                                BarcodeFormat$EnumUnboxingLocalUtility.m(str5, "Ignoring malformed VP9 codec string: ", "CodecSpecificDataUtil");
                            }
                        } else {
                            BarcodeFormat$EnumUnboxingLocalUtility.m(str5, "Ignoring malformed VP9 codec string: ", "CodecSpecificDataUtil");
                        }
                        break;
                    case 4:
                    case 5:
                        return zzb(zzzVar.zzk, strArrSplit, zzzVar.zzE);
                    case 6:
                        String str6 = zzzVar.zzk;
                        zzk zzkVar = zzzVar.zzE;
                        if (strArrSplit.length >= 4) {
                            try {
                                int i14 = Integer.parseInt(strArrSplit[1]);
                                int i15 = Integer.parseInt(strArrSplit[2].substring(0, 2));
                                int i16 = Integer.parseInt(strArrSplit[3]);
                                if (i14 != 0) {
                                    CoroutineAdapterKt$$ExternalSyntheticLambda0.m23m(i14, "Unknown AV1 profile: ", "CodecSpecificDataUtil");
                                } else {
                                    if (i16 == 8) {
                                        i5 = 1;
                                    } else if (i16 != 10) {
                                        CoroutineAdapterKt$$ExternalSyntheticLambda0.m23m(i16, "Unknown AV1 bit depth: ", "CodecSpecificDataUtil");
                                    } else {
                                        i5 = (zzkVar == null || !(zzkVar.zze != null || (i6 = zzkVar.zzd) == 7 || i6 == 6)) ? 2 : 4096;
                                    }
                                    switch (i15) {
                                        case 0:
                                            i10 = 1;
                                            break;
                                        case 1:
                                            break;
                                        case 2:
                                            i10 = 4;
                                            break;
                                        case 3:
                                            i10 = 8;
                                            break;
                                        case 4:
                                            i10 = 16;
                                            break;
                                        case 5:
                                            i10 = 32;
                                            break;
                                        case 6:
                                            i10 = 64;
                                            break;
                                        case 7:
                                            i10 = 128;
                                            break;
                                        case 8:
                                            i10 = 256;
                                            break;
                                        case 9:
                                            i10 = 512;
                                            break;
                                        case 10:
                                            i10 = 1024;
                                            break;
                                        case 11:
                                            i10 = 2048;
                                            break;
                                        case 12:
                                            i10 = 4096;
                                            break;
                                        case 13:
                                            i10 = 8192;
                                            break;
                                        case 14:
                                            i10 = 16384;
                                            break;
                                        case 15:
                                            i10 = 32768;
                                            break;
                                        case 16:
                                            i10 = 65536;
                                            break;
                                        case 17:
                                            i10 = 131072;
                                            break;
                                        case 18:
                                            i10 = 262144;
                                            break;
                                        case 19:
                                            i10 = 524288;
                                            break;
                                        case 20:
                                            i10 = 1048576;
                                            break;
                                        case 21:
                                            i10 = 2097152;
                                            break;
                                        case 22:
                                            i10 = 4194304;
                                            break;
                                        case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
                                            i10 = 8388608;
                                            break;
                                        default:
                                            i10 = -1;
                                            break;
                                    }
                                    if (i10 != -1) {
                                        return new Pair(Integer.valueOf(i5), Integer.valueOf(i10));
                                    }
                                    CoroutineAdapterKt$$ExternalSyntheticLambda0.m23m(i15, "Unknown AV1 level: ", "CodecSpecificDataUtil");
                                }
                            } catch (NumberFormatException unused4) {
                                BarcodeFormat$EnumUnboxingLocalUtility.m(str6, "Ignoring malformed AV1 codec string: ", "CodecSpecificDataUtil");
                            }
                        } else {
                            BarcodeFormat$EnumUnboxingLocalUtility.m(str6, "Ignoring malformed AV1 codec string: ", "CodecSpecificDataUtil");
                        }
                        break;
                    case 7:
                        String str7 = zzzVar.zzk;
                        if (strArrSplit.length == 3) {
                            try {
                                if ("audio/mp4a-latm".equals(zzay.zzd(Integer.parseInt(strArrSplit[1], 16)))) {
                                    int i17 = Integer.parseInt(strArrSplit[2]);
                                    if (i17 == 17) {
                                        i9 = 17;
                                    } else if (i17 == 20) {
                                        i9 = 20;
                                    } else if (i17 == 23) {
                                        i9 = 23;
                                    } else if (i17 == 29) {
                                        i9 = 29;
                                    } else if (i17 == 39) {
                                        i9 = 39;
                                    } else if (i17 != 42) {
                                        switch (i17) {
                                            case 1:
                                                i9 = 1;
                                                break;
                                            case 2:
                                                i9 = 2;
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                i9 = 4;
                                                break;
                                            case 5:
                                                i9 = 5;
                                                break;
                                            case 6:
                                                i9 = 6;
                                                break;
                                            default:
                                                i9 = -1;
                                                break;
                                        }
                                    } else {
                                        i9 = 42;
                                    }
                                    if (i9 != -1) {
                                        return new Pair(Integer.valueOf(i9), 0);
                                    }
                                }
                            } catch (NumberFormatException unused5) {
                                BarcodeFormat$EnumUnboxingLocalUtility.m(str7, "Ignoring malformed MP4A codec string: ", "CodecSpecificDataUtil");
                            }
                        } else {
                            BarcodeFormat$EnumUnboxingLocalUtility.m(str7, "Ignoring malformed MP4A codec string: ", "CodecSpecificDataUtil");
                        }
                        break;
                    case 8:
                        if (strArrSplit.length == 4) {
                            try {
                                int i18 = Integer.parseInt(strArrSplit[1]);
                                int i19 = Integer.parseInt(strArrSplit[2]);
                                int i20 = Integer.parseInt(strArrSplit[3]);
                                if (i18 != 0) {
                                    if (i18 != 1) {
                                        if (i18 != 2) {
                                            i11 = i19;
                                            i7 = -1;
                                        } else if (i19 == 1) {
                                            i7 = 1026;
                                            i11 = 1;
                                        } else if (i19 == 2) {
                                            i7 = 1028;
                                            i11 = 2;
                                        } else {
                                            i11 = i19;
                                            i7 = -1;
                                        }
                                    } else if (i19 == 0) {
                                        i7 = 513;
                                    } else if (i19 == 1) {
                                        i7 = 514;
                                        i11 = 1;
                                    } else {
                                        i11 = i19;
                                        i7 = -1;
                                    }
                                } else if (i19 == 0) {
                                    i7 = 257;
                                } else {
                                    i11 = i19;
                                    i7 = -1;
                                }
                                if (i7 == -1) {
                                    zzea.zzf("CodecSpecificDataUtil", "Unknown AC-4 profile: " + i18 + "." + i11);
                                } else {
                                    if (i20 == 0) {
                                        i8 = 1;
                                    } else if (i20 == 1) {
                                        i8 = 2;
                                    } else if (i20 == 2) {
                                        i8 = 4;
                                    } else if (i20 != 3) {
                                        i8 = i20 != 4 ? -1 : 16;
                                    }
                                    if (i8 != -1) {
                                        return new Pair(Integer.valueOf(i7), Integer.valueOf(i8));
                                    }
                                    CoroutineAdapterKt$$ExternalSyntheticLambda0.m23m(i20, "Unknown AC-4 level: ", "CodecSpecificDataUtil");
                                }
                            } catch (NumberFormatException unused6) {
                                zzea.zzf("CodecSpecificDataUtil", "Ignoring malformed AC-4 codec string: ".concat(str));
                            }
                        } else {
                            zzea.zzf("CodecSpecificDataUtil", "Ignoring malformed AC-4 codec string: ".concat(str));
                        }
                        break;
                }
            } else if (strArrSplit.length < 3) {
                zzea.zzf("CodecSpecificDataUtil", "Ignoring malformed Dolby Vision codec string: ".concat(str));
            } else {
                Matcher matcher = zzd.matcher(strArrSplit[1]);
                if (matcher.matches()) {
                    String strGroup = matcher.group(1);
                    if (strGroup != null) {
                        int iHashCode = strGroup.hashCode();
                        if (iHashCode != 1567) {
                            switch (iHashCode) {
                                case 1536:
                                    if (!strGroup.equals("00")) {
                                        num = null;
                                    } else {
                                        num = 1;
                                    }
                                    break;
                                case 1537:
                                    if (!strGroup.equals(JrbhsraGtto.zslhncYmYSMuCGU)) {
                                        num = null;
                                    } else {
                                        num = 2;
                                    }
                                    break;
                                case 1538:
                                    if (!strGroup.equals("02")) {
                                        num = null;
                                    } else {
                                        num = 4;
                                    }
                                    break;
                                case 1539:
                                    if (!strGroup.equals("03")) {
                                        num = null;
                                    } else {
                                        num = 8;
                                    }
                                    break;
                                case 1540:
                                    if (!strGroup.equals("04")) {
                                        num = null;
                                    } else {
                                        num = 16;
                                    }
                                    break;
                                case 1541:
                                    if (!strGroup.equals("05")) {
                                        num = null;
                                    } else {
                                        num = 32;
                                    }
                                    break;
                                case 1542:
                                    if (!strGroup.equals("06")) {
                                        num = null;
                                    } else {
                                        num = 64;
                                    }
                                    break;
                                case 1543:
                                    if (!strGroup.equals("07")) {
                                        num = null;
                                    } else {
                                        num = 128;
                                    }
                                    break;
                                case 1544:
                                    if (!strGroup.equals("08")) {
                                        num = null;
                                    } else {
                                        num = 256;
                                    }
                                    break;
                                case 1545:
                                    if (!strGroup.equals("09")) {
                                        num = null;
                                    } else {
                                        num = 512;
                                    }
                                    break;
                                default:
                                    num = null;
                                    break;
                            }
                        } else if (strGroup.equals("10")) {
                            num = 1024;
                        } else {
                            num = null;
                        }
                    } else {
                        num = null;
                    }
                    if (num == null) {
                        BarcodeFormat$EnumUnboxingLocalUtility.m(strGroup, oKjScaD.RozfErxJtDag, "CodecSpecificDataUtil");
                    } else {
                        String str8 = strArrSplit[2];
                        if (str8 != null) {
                            switch (str8) {
                                case "01":
                                    num2 = 1;
                                    break;
                                case "02":
                                    num2 = 2;
                                    break;
                                case "03":
                                    num2 = 4;
                                    break;
                                case "04":
                                    num2 = 8;
                                    break;
                                case "05":
                                    num2 = 16;
                                    break;
                                case "06":
                                    num2 = 32;
                                    break;
                                case "07":
                                    num2 = 64;
                                    break;
                                case "08":
                                    num2 = 128;
                                    break;
                                case "09":
                                    num2 = 256;
                                    break;
                                default:
                                    switch (str8) {
                                        case 1567:
                                            if (!str8.equals("10")) {
                                                num2 = null;
                                            } else {
                                                num2 = 512;
                                            }
                                            break;
                                        case 1568:
                                            if (!str8.equals("11")) {
                                                num2 = null;
                                            } else {
                                                num2 = 1024;
                                            }
                                            break;
                                        case 1569:
                                            if (!str8.equals("12")) {
                                                num2 = null;
                                            } else {
                                                num2 = 2048;
                                            }
                                            break;
                                        case 1570:
                                            if (!str8.equals("13")) {
                                                num2 = null;
                                            } else {
                                                num2 = 4096;
                                            }
                                            break;
                                        default:
                                            num2 = null;
                                            break;
                                    }
                            }
                        } else {
                            num2 = null;
                        }
                        if (num2 != null) {
                            return new Pair(num, num2);
                        }
                        BarcodeFormat$EnumUnboxingLocalUtility.m(str8, "Unknown Dolby Vision level string: ", "CodecSpecificDataUtil");
                    }
                } else {
                    zzea.zzf("CodecSpecificDataUtil", "Ignoring malformed Dolby Vision codec string: ".concat(str));
                }
            }
        }
        return null;
    }
}
