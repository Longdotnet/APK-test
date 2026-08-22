package com.google.android.gms.internal.ads;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.loader.app.gv.DYYbQc;
import com.google.android.gms.ads.internal.gMU.QTaELkFI;
import com.google.android.gms.auth.api.LNi.xPQrbOSWiEdU;
import com.google.android.gms.games.provider.NtJ.wsbWxekY;
import com.google.gson.yWTz.kBfGXgdfpo;
import com.google.zxing.BarcodeFormat$EnumUnboxingLocalUtility;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdl {
    private static final Pattern zza = Pattern.compile("^rgb\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
    private static final Pattern zzb = Pattern.compile(wsbWxekY.tpLtgDeJhtqIH);
    private static final Pattern zzc = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d*\\.?\\d*?)\\)$");
    private static final Map zzd;

    public static int zza(String str) {
        return zzc(str, true);
    }

    public static int zzb(String str) {
        return zzc(str, false);
    }

    private static int zzc(String str, boolean z) {
        int i;
        zzdd.zzd(!TextUtils.isEmpty(str));
        String strReplace = str.replace(" ", "");
        if (strReplace.charAt(0) == '#') {
            int i2 = (int) Long.parseLong(strReplace.substring(1), 16);
            if (strReplace.length() == 7) {
                return (-16777216) | i2;
            }
            if (strReplace.length() == 9) {
                return ((i2 & 255) << 24) | (i2 >>> 8);
            }
            throw new IllegalArgumentException();
        }
        if (strReplace.startsWith("rgba")) {
            Matcher matcher = (z ? zzc : zzb).matcher(strReplace);
            if (matcher.matches()) {
                if (z) {
                    String strGroup = matcher.group(4);
                    strGroup.getClass();
                    i = (int) (Float.parseFloat(strGroup) * 255.0f);
                } else {
                    String strGroup2 = matcher.group(4);
                    strGroup2.getClass();
                    i = Integer.parseInt(strGroup2, 10);
                }
                String strGroup3 = matcher.group(1);
                strGroup3.getClass();
                int i3 = Integer.parseInt(strGroup3, 10);
                String strGroup4 = matcher.group(2);
                strGroup4.getClass();
                int i4 = Integer.parseInt(strGroup4, 10);
                String strGroup5 = matcher.group(3);
                strGroup5.getClass();
                return Color.argb(i, i3, i4, Integer.parseInt(strGroup5, 10));
            }
        } else if (strReplace.startsWith("rgb")) {
            Matcher matcher2 = zza.matcher(strReplace);
            if (matcher2.matches()) {
                String strGroup6 = matcher2.group(1);
                strGroup6.getClass();
                int i5 = Integer.parseInt(strGroup6, 10);
                String strGroup7 = matcher2.group(2);
                strGroup7.getClass();
                int i6 = Integer.parseInt(strGroup7, 10);
                String strGroup8 = matcher2.group(3);
                strGroup8.getClass();
                return Color.rgb(i5, i6, Integer.parseInt(strGroup8, 10));
            }
        } else {
            Integer num = (Integer) zzd.get(zzfuv.zza(strReplace));
            if (num != null) {
                return num.intValue();
            }
        }
        throw new IllegalArgumentException();
    }

    static {
        HashMap map = new HashMap();
        zzd = map;
        BarcodeFormat$EnumUnboxingLocalUtility.m(-984833, map, "aliceblue", -332841, "antiquewhite");
        map.put("aqua", -16711681);
        map.put("aquamarine", -8388652);
        BarcodeFormat$EnumUnboxingLocalUtility.m(-983041, map, "azure", -657956, "beige");
        BarcodeFormat$EnumUnboxingLocalUtility.m(-6972, map, "bisque", -16777216, "black");
        BarcodeFormat$EnumUnboxingLocalUtility.m(-5171, map, "blanchedalmond", -16776961, "blue");
        BarcodeFormat$EnumUnboxingLocalUtility.m(-7722014, map, "blueviolet", -5952982, "brown");
        BarcodeFormat$EnumUnboxingLocalUtility.m(-2180985, map, "burlywood", -10510688, "cadetblue");
        BarcodeFormat$EnumUnboxingLocalUtility.m(-8388864, map, "chartreuse", -2987746, "chocolate");
        BarcodeFormat$EnumUnboxingLocalUtility.m(-32944, map, "coral", -10185235, "cornflowerblue");
        BarcodeFormat$EnumUnboxingLocalUtility.m(-1828, map, "cornsilk", -2354116, "crimson");
        map.put("cyan", -16711681);
        map.put("darkblue", -16777077);
        BarcodeFormat$EnumUnboxingLocalUtility.m(-16741493, map, "darkcyan", -4684277, "darkgoldenrod");
        map.put("darkgray", -5658199);
        map.put("darkgreen", -16751616);
        map.put("darkgrey", -5658199);
        map.put("darkkhaki", -4343957);
        BarcodeFormat$EnumUnboxingLocalUtility.m(-7667573, map, "darkmagenta", -11179217, "darkolivegreen");
        BarcodeFormat$EnumUnboxingLocalUtility.m(-29696, map, "darkorange", -6737204, "darkorchid");
        BarcodeFormat$EnumUnboxingLocalUtility.m(-7667712, map, "darkred", -1468806, "darksalmon");
        BarcodeFormat$EnumUnboxingLocalUtility.m(-7357297, map, "darkseagreen", -12042869, "darkslateblue");
        map.put("darkslategray", -13676721);
        map.put("darkslategrey", -13676721);
        map.put("darkturquoise", -16724271);
        map.put("darkviolet", -7077677);
        BarcodeFormat$EnumUnboxingLocalUtility.m(-60269, map, "deeppink", -16728065, "deepskyblue");
        map.put("dimgray", -9868951);
        map.put("dimgrey", -9868951);
        map.put("dodgerblue", -14774017);
        map.put("firebrick", -5103070);
        BarcodeFormat$EnumUnboxingLocalUtility.m(-1296, map, "floralwhite", -14513374, "forestgreen");
        map.put("fuchsia", -65281);
        map.put(kBfGXgdfpo.PfgDcFUpSjOK, -2302756);
        BarcodeFormat$EnumUnboxingLocalUtility.m(-460545, map, "ghostwhite", -10496, "gold");
        map.put("goldenrod", -2448096);
        map.put("gray", -8355712);
        BarcodeFormat$EnumUnboxingLocalUtility.m(-16744448, map, "green", -5374161, "greenyellow");
        map.put("grey", -8355712);
        map.put("honeydew", -983056);
        BarcodeFormat$EnumUnboxingLocalUtility.m(-38476, map, "hotpink", -3318692, "indianred");
        BarcodeFormat$EnumUnboxingLocalUtility.m(-11861886, map, "indigo", -16, "ivory");
        BarcodeFormat$EnumUnboxingLocalUtility.m(-989556, map, "khaki", -1644806, "lavender");
        BarcodeFormat$EnumUnboxingLocalUtility.m(-3851, map, "lavenderblush", -8586240, "lawngreen");
        BarcodeFormat$EnumUnboxingLocalUtility.m(-1331, map, "lemonchiffon", -5383962, "lightblue");
        BarcodeFormat$EnumUnboxingLocalUtility.m(-1015680, map, "lightcoral", -2031617, "lightcyan");
        map.put("lightgoldenrodyellow", -329006);
        map.put("lightgray", -2894893);
        map.put("lightgreen", -7278960);
        map.put("lightgrey", -2894893);
        BarcodeFormat$EnumUnboxingLocalUtility.m(-18751, map, "lightpink", -24454, "lightsalmon");
        BarcodeFormat$EnumUnboxingLocalUtility.m(-14634326, map, "lightseagreen", -7876870, "lightskyblue");
        map.put("lightslategray", -8943463);
        map.put("lightslategrey", -8943463);
        map.put("lightsteelblue", -5192482);
        map.put("lightyellow", -32);
        BarcodeFormat$EnumUnboxingLocalUtility.m(-16711936, map, "lime", -13447886, "limegreen");
        map.put("linen", -331546);
        map.put("magenta", -65281);
        BarcodeFormat$EnumUnboxingLocalUtility.m(-8388608, map, "maroon", -10039894, "mediumaquamarine");
        BarcodeFormat$EnumUnboxingLocalUtility.m(-16777011, map, "mediumblue", -4565549, "mediumorchid");
        BarcodeFormat$EnumUnboxingLocalUtility.m(-7114533, map, "mediumpurple", -12799119, "mediumseagreen");
        BarcodeFormat$EnumUnboxingLocalUtility.m(-8689426, map, "mediumslateblue", -16713062, "mediumspringgreen");
        BarcodeFormat$EnumUnboxingLocalUtility.m(-12004916, map, "mediumturquoise", -3730043, "mediumvioletred");
        BarcodeFormat$EnumUnboxingLocalUtility.m(-15132304, map, "midnightblue", -655366, "mintcream");
        BarcodeFormat$EnumUnboxingLocalUtility.m(-6943, map, "mistyrose", -6987, "moccasin");
        BarcodeFormat$EnumUnboxingLocalUtility.m(-8531, map, "navajowhite", -16777088, "navy");
        BarcodeFormat$EnumUnboxingLocalUtility.m(-133658, map, "oldlace", -8355840, "olive");
        BarcodeFormat$EnumUnboxingLocalUtility.m(-9728477, map, "olivedrab", -23296, "orange");
        BarcodeFormat$EnumUnboxingLocalUtility.m(-47872, map, "orangered", -2461482, "orchid");
        BarcodeFormat$EnumUnboxingLocalUtility.m(-1120086, map, "palegoldenrod", -6751336, "palegreen");
        BarcodeFormat$EnumUnboxingLocalUtility.m(-5247250, map, "paleturquoise", -2396013, "palevioletred");
        BarcodeFormat$EnumUnboxingLocalUtility.m(-4139, map, QTaELkFI.XnAyQswZULWV, -9543, "peachpuff");
        BarcodeFormat$EnumUnboxingLocalUtility.m(-3308225, map, "peru", -16181, "pink");
        BarcodeFormat$EnumUnboxingLocalUtility.m(-2252579, map, "plum", -5185306, "powderblue");
        BarcodeFormat$EnumUnboxingLocalUtility.m(-8388480, map, "purple", -10079335, DYYbQc.wgzXET);
        BarcodeFormat$EnumUnboxingLocalUtility.m(-65536, map, "red", -4419697, "rosybrown");
        BarcodeFormat$EnumUnboxingLocalUtility.m(-12490271, map, "royalblue", -7650029, "saddlebrown");
        BarcodeFormat$EnumUnboxingLocalUtility.m(-360334, map, "salmon", -744352, "sandybrown");
        BarcodeFormat$EnumUnboxingLocalUtility.m(-13726889, map, "seagreen", -2578, "seashell");
        BarcodeFormat$EnumUnboxingLocalUtility.m(-6270419, map, "sienna", -4144960, "silver");
        BarcodeFormat$EnumUnboxingLocalUtility.m(-7876885, map, "skyblue", -9807155, "slateblue");
        map.put("slategray", -9404272);
        map.put("slategrey", -9404272);
        map.put("snow", -1286);
        map.put("springgreen", -16711809);
        BarcodeFormat$EnumUnboxingLocalUtility.m(-12156236, map, "steelblue", -2968436, "tan");
        BarcodeFormat$EnumUnboxingLocalUtility.m(-16744320, map, "teal", -2572328, "thistle");
        BarcodeFormat$EnumUnboxingLocalUtility.m(-40121, map, "tomato", 0, "transparent");
        BarcodeFormat$EnumUnboxingLocalUtility.m(-12525360, map, xPQrbOSWiEdU.nNtipkgaWJc, -1146130, "violet");
        BarcodeFormat$EnumUnboxingLocalUtility.m(-663885, map, "wheat", -1, "white");
        BarcodeFormat$EnumUnboxingLocalUtility.m(-657931, map, "whitesmoke", -256, "yellow");
        map.put("yellowgreen", -6632142);
    }
}
