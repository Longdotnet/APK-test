package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.facebook.login.vu.dLDI;
import com.google.android.gms.appset.vSSa.iafHZUfOuHNwvy;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlinx.coroutines.internal.Jbo.ygoi;

/* JADX INFO: loaded from: classes2.dex */
public final class zzay {
    public static final /* synthetic */ int zza = 0;
    private static final ArrayList zzb = new ArrayList();
    private static final Pattern zzc = Pattern.compile("^mp4a\\.([a-zA-Z0-9]{2})(?:\\.([0-9]{1,2}))?$");

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:41:0x008e  */
    public static int zza(String str, String str2) {
        zzax zzaxVarZzc;
        switch (str) {
            case "audio/mpeg":
                return 9;
            case "audio/mp4a-latm":
                if (str2 == null || (zzaxVarZzc = zzc(str2)) == null) {
                    return 0;
                }
                return zzaxVarZzc.zza();
            case "audio/ac3":
                return 5;
            case "audio/eac3":
                return 6;
            case "audio/eac3-joc":
                return 18;
            case "audio/ac4":
                return 17;
            case "audio/vnd.dts":
                return 7;
            case "audio/vnd.dts.hd":
            case "audio/vnd.dts.hd;profile=lbr":
                return 8;
            case "audio/vnd.dts.uhd;profile=p2":
                return 30;
            case "audio/true-hd":
                return 14;
            case "audio/opus":
                return 20;
            default:
                return 0;
        }
    }

    public static int zzb(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (zzh(str)) {
            return 1;
        }
        if (zzj(str)) {
            return 2;
        }
        if ("text".equals(zzk(str)) || "application/x-media3-cues".equals(str) || "application/cea-608".equals(str) || "application/cea-708".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/x-subrip".equals(str) || "application/ttml+xml".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-rawcc".equals(str) || "application/vobsub".equals(str) || "application/pgs".equals(str) || "application/dvbsubs".equals(str)) {
            return 3;
        }
        if (zzi(str)) {
            return 4;
        }
        if ("application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str) || "application/x-icy".equals(str) || "application/vnd.dvb.ait".equals(str)) {
            return 5;
        }
        if ("application/x-camera-motion".equals(str)) {
            return 6;
        }
        ArrayList arrayList = zzb;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            String str2 = ((zzaw) arrayList.get(i)).zza;
            if (str.equals(null)) {
                return 0;
            }
        }
        return -1;
    }

    public static zzax zzc(String str) {
        Matcher matcher = zzc.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        String strGroup = matcher.group(1);
        strGroup.getClass();
        String strGroup2 = matcher.group(2);
        try {
            return new zzax(Integer.parseInt(strGroup, 16), strGroup2 != null ? Integer.parseInt(strGroup2) : 0);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static String zzd(int i) {
        if (i == 32) {
            return "video/mp4v-es";
        }
        if (i == 33) {
            return "video/avc";
        }
        if (i == 35) {
            return "video/hevc";
        }
        if (i == 64) {
            return "audio/mp4a-latm";
        }
        if (i == 163) {
            return "video/wvc1";
        }
        if (i == 177) {
            return "video/x-vnd.on2.vp9";
        }
        if (i == 221) {
            return "audio/vorbis";
        }
        if (i == 165) {
            return "audio/ac3";
        }
        if (i == 166) {
            return "audio/eac3";
        }
        switch (i) {
            case 96:
            case 97:
            case 98:
            case TOSS_VERYHIGH_VALUE:
            case TOSS_SODAM_VALUE:
            case 101:
                return "video/mpeg2";
            case TOSS_OPEN_MASKED_SOLHWA_VALUE:
            case TOSS_OPEN_BALANCED_VALUE:
            case TOSS_FIXED_LOW_FOR_BEGINNER_VALUE:
                return "audio/mp4a-latm";
            case TOSS_NETUPOPEN_VALUE:
            case TOSS_SPOTLIGHT_VALUE:
                return "audio/mpeg";
            case TOSS_NETUPC_VALUE:
                return "video/mpeg";
            case TOSS_FIXED_MED_FOR_BEGINNER_VALUE:
                return "image/jpeg";
            default:
                switch (i) {
                    case 169:
                    case 172:
                        return "audio/vnd.dts";
                    case 170:
                    case 171:
                        return "audio/vnd.dts.hd";
                    case 173:
                        return "audio/opus";
                    case 174:
                        return "audio/ac4";
                    default:
                        return null;
                }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:29:0x0056  */
    public static String zze(String str) {
        if (str == null) {
            return null;
        }
        String strZza = zzfuv.zza(str);
        switch (strZza) {
            case "video/x-mvhevc":
                return "video/mv-hevc";
            case "audio/x-flac":
                return "audio/flac";
            case "audio/mp3":
                return "audio/mpeg";
            case "audio/x-wav":
                return "audio/wav";
            case "application/x-mpegurl":
                return "application/x-mpegURL";
            case "audio/mpeg-l1":
                return "audio/mpeg-L1";
            case "audio/mpeg-l2":
                return "audio/mpeg-L2";
            default:
                return strZza;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:41:0x0082  */
    public static boolean zzf(String str, String str2) {
        byte b;
        zzax zzaxVarZzc;
        int iZza;
        if (str == null) {
            return false;
        }
        switch (str.hashCode()) {
            case -2123537834:
                if (!str.equals("audio/eac3-joc")) {
                    b = -1;
                } else {
                    b = 9;
                }
                break;
            case -432837260:
                if (!str.equals("audio/mpeg-L1")) {
                    b = -1;
                } else {
                    b = 1;
                }
                break;
            case -432837259:
                if (!str.equals("audio/mpeg-L2")) {
                    b = -1;
                } else {
                    b = 2;
                }
                break;
            case -53558318:
                if (!str.equals("audio/mp4a-latm")) {
                    b = -1;
                } else {
                    b = 10;
                }
                break;
            case 187078296:
                if (!str.equals("audio/ac3")) {
                    b = -1;
                } else {
                    b = 7;
                }
                break;
            case 187094639:
                if (!str.equals("audio/raw")) {
                    b = -1;
                } else {
                    b = 3;
                }
                break;
            case 1504578661:
                if (!str.equals("audio/eac3")) {
                    b = -1;
                } else {
                    b = 8;
                }
                break;
            case 1504619009:
                if (!str.equals(ygoi.CbaPJOvIFwsTIep)) {
                    b = -1;
                } else {
                    b = 6;
                }
                break;
            case 1504831518:
                if (!str.equals("audio/mpeg")) {
                    b = -1;
                } else {
                    b = 0;
                }
                break;
            case 1903231877:
                if (!str.equals("audio/g711-alaw")) {
                    b = -1;
                } else {
                    b = 4;
                }
                break;
            case 1903589369:
                if (!str.equals("audio/g711-mlaw")) {
                    b = -1;
                } else {
                    b = 5;
                }
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return true;
            case 10:
                return (str2 == null || (zzaxVarZzc = zzc(str2)) == null || (iZza = zzaxVarZzc.zza()) == 0 || iZza == 16) ? false : true;
            default:
                return false;
        }
    }

    public static boolean zzg(String str, String str2) {
        String strZzd;
        zzax zzaxVarZzc;
        String string = null;
        if (str != null) {
            String str3 = zzex.zza;
            String[] strArrSplit = TextUtils.isEmpty(str) ? new String[0] : str.trim().split("(\\s*,\\s*)", -1);
            StringBuilder sb = new StringBuilder();
            for (String str4 : strArrSplit) {
                if (str4 == null) {
                    strZzd = null;
                } else {
                    String strZza = zzfuv.zza(str4.trim());
                    if (strZza.startsWith("avc1") || strZza.startsWith("avc3")) {
                        strZzd = "video/avc";
                    } else if (strZza.startsWith("hev1") || strZza.startsWith("hvc1")) {
                        strZzd = "video/hevc";
                    } else if (strZza.startsWith("dvav") || strZza.startsWith("dva1") || strZza.startsWith("dvhe") || strZza.startsWith("dvh1")) {
                        strZzd = "video/dolby-vision";
                    } else if (strZza.startsWith("av01")) {
                        strZzd = "video/av01";
                    } else if (strZza.startsWith("vp9") || strZza.startsWith("vp09")) {
                        strZzd = "video/x-vnd.on2.vp9";
                    } else if (strZza.startsWith("vp8") || strZza.startsWith("vp08")) {
                        strZzd = "video/x-vnd.on2.vp8";
                    } else if (strZza.startsWith("mp4a")) {
                        strZzd = (!strZza.startsWith("mp4a.") || (zzaxVarZzc = zzc(strZza)) == null) ? null : zzd(zzaxVarZzc.zza);
                        if (strZzd == null) {
                            strZzd = "audio/mp4a-latm";
                        }
                    } else if (strZza.startsWith("mha1")) {
                        strZzd = "audio/mha1";
                    } else if (strZza.startsWith("mhm1")) {
                        strZzd = "audio/mhm1";
                    } else if (strZza.startsWith("ac-3") || strZza.startsWith("dac3")) {
                        strZzd = "audio/ac3";
                    } else if (strZza.startsWith("ec-3") || strZza.startsWith("dec3")) {
                        strZzd = "audio/eac3";
                    } else if (strZza.startsWith("ec+3")) {
                        strZzd = "audio/eac3-joc";
                    } else if (strZza.startsWith("ac-4") || strZza.startsWith("dac4")) {
                        strZzd = "audio/ac4";
                    } else if (strZza.startsWith("dtsc")) {
                        strZzd = "audio/vnd.dts";
                    } else if (strZza.startsWith("dtse")) {
                        strZzd = "audio/vnd.dts.hd;profile=lbr";
                    } else if (strZza.startsWith("dtsh") || strZza.startsWith("dtsl")) {
                        strZzd = "audio/vnd.dts.hd";
                    } else if (strZza.startsWith("dtsx")) {
                        strZzd = "audio/vnd.dts.uhd;profile=p2";
                    } else if (strZza.startsWith("opus")) {
                        strZzd = "audio/opus";
                    } else if (strZza.startsWith("vorbis")) {
                        strZzd = "audio/vorbis";
                    } else if (strZza.startsWith(dLDI.WyGFRUsbUUpvd)) {
                        strZzd = "audio/flac";
                    } else if (strZza.startsWith("stpp")) {
                        strZzd = "application/ttml+xml";
                    } else if (strZza.startsWith("wvtt")) {
                        strZzd = "text/vtt";
                    } else if (strZza.contains("cea708")) {
                        strZzd = iafHZUfOuHNwvy.WfJ;
                    } else if (strZza.contains("eia608") || strZza.contains("cea608")) {
                        strZzd = "application/cea-608";
                    } else {
                        ArrayList arrayList = zzb;
                        int size = arrayList.size();
                        for (int i = 0; i < size; i++) {
                            String str5 = ((zzaw) arrayList.get(i)).zzb;
                            if (strZza.startsWith(null)) {
                                break;
                            }
                        }
                        strZzd = null;
                    }
                }
                if (str2.equals(strZzd)) {
                    if (sb.length() > 0) {
                        sb.append(",");
                    }
                    sb.append(str4);
                }
            }
            if (sb.length() > 0) {
                string = sb.toString();
            }
        }
        return string != null;
    }

    public static boolean zzh(String str) {
        return "audio".equals(zzk(str));
    }

    public static boolean zzi(String str) {
        return "image".equals(zzk(str)) || "application/x-image-uri".equals(str);
    }

    public static boolean zzj(String str) {
        return "video".equals(zzk(str));
    }

    private static String zzk(String str) {
        int iIndexOf;
        if (str == null || (iIndexOf = str.indexOf(47)) == -1) {
            return null;
        }
        return str.substring(0, iIndexOf);
    }
}
