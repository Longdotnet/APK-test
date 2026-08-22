package com.google.android.gms.internal.ads;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import androidx.sqlite.db.framework.VERT.YcVWhnLsj;
import com.facebook.login.vu.dLDI;
import com.google.android.finsky.externalreferrer.jUdg.RDFWIi;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.coroutines.jvm.internal.DEXi.JuorMn;

/* JADX INFO: loaded from: classes2.dex */
public final class zzaml {
    public static final Pattern zza = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)((?:.|\\f)*)?$");
    private static final Pattern zzb = Pattern.compile("(\\S+?):(\\S+)");
    private static final Map zzc;
    private static final Map zzd;

    /* JADX WARN: Code duplicated, block: B:122:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:77:0x0125  */
    public static SpannedString zza(String str, String str2, List list) {
        int i;
        byte b;
        int i2 = -1;
        int i3 = 1;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        int i5 = 0;
        while (i5 < str2.length()) {
            int i6 = i5 + 1;
            char cCharAt = str2.charAt(i5);
            int i7 = 2;
            if (cCharAt != '&') {
                if (cCharAt != '<') {
                    spannableStringBuilder.append(cCharAt);
                } else {
                    if (i6 < str2.length()) {
                        char cCharAt2 = str2.charAt(i6);
                        int iIndexOf = str2.indexOf(62, i6);
                        int length = iIndexOf == i2 ? str2.length() : iIndexOf + i3;
                        int i8 = length - 2;
                        int i9 = str2.charAt(i8) == '/' ? i3 : i4;
                        int i10 = i5 + (cCharAt2 == '/' ? 2 : i3);
                        if (i9 == 0) {
                            i8 = length - 1;
                        }
                        String strSubstring = str2.substring(i10, i8);
                        if (!strSubstring.trim().isEmpty()) {
                            String strTrim = strSubstring.trim();
                            zzdd.zzd(!strTrim.isEmpty());
                            String str3 = zzex.zza;
                            String str4 = strTrim.split("[ \\.]", 2)[i4];
                            int iHashCode = str4.hashCode();
                            if (iHashCode != 98) {
                                if (iHashCode != 99) {
                                    if (iHashCode != 105) {
                                        if (iHashCode != 3650) {
                                            if (iHashCode != 3314158) {
                                                if (iHashCode != 3511770) {
                                                    if (iHashCode != 117) {
                                                        if (iHashCode == 118 && str4.equals("v")) {
                                                            i7 = 7;
                                                        } else {
                                                            i7 = i2;
                                                        }
                                                    } else if (str4.equals("u")) {
                                                        i7 = 6;
                                                    } else {
                                                        i7 = i2;
                                                    }
                                                } else if (str4.equals("ruby")) {
                                                    i7 = 4;
                                                } else {
                                                    i7 = i2;
                                                }
                                            } else if (str4.equals("lang")) {
                                                i7 = 3;
                                            } else {
                                                i7 = i2;
                                            }
                                        } else if (str4.equals("rt")) {
                                            i7 = 5;
                                        } else {
                                            i7 = i2;
                                        }
                                    } else if (!str4.equals("i")) {
                                        i7 = i2;
                                    }
                                } else if (str4.equals("c")) {
                                    i7 = 1;
                                } else {
                                    i7 = i2;
                                }
                            } else if (str4.equals("b")) {
                                i7 = 0;
                            } else {
                                i7 = i2;
                            }
                            switch (i7) {
                                case 0:
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                    if (cCharAt2 == '/') {
                                        while (!arrayDeque.isEmpty()) {
                                            zzamh zzamhVar = (zzamh) arrayDeque.pop();
                                            zzg(str, zzamhVar, arrayList, spannableStringBuilder, list);
                                            if (arrayDeque.isEmpty()) {
                                                arrayList.clear();
                                            } else {
                                                arrayList.add(new zzamg(zzamhVar, spannableStringBuilder.length(), null));
                                            }
                                            if (zzamhVar.zza.equals(str4)) {
                                                break;
                                            }
                                        }
                                    } else if (i9 == 0) {
                                        arrayDeque.push(zzamh.zza(strSubstring, spannableStringBuilder.length()));
                                    }
                                    break;
                            }
                        }
                        i5 = length;
                        i3 = 1;
                    }
                    i4 = 0;
                }
                i = i3;
            } else {
                int iIndexOf2 = str2.indexOf(59, i6);
                int iIndexOf3 = str2.indexOf(32, i6);
                if (iIndexOf2 == i2) {
                    iIndexOf2 = iIndexOf3;
                } else if (iIndexOf3 != i2) {
                    iIndexOf2 = Math.min(iIndexOf2, iIndexOf3);
                }
                if (iIndexOf2 != i2) {
                    String strSubstring2 = str2.substring(i6, iIndexOf2);
                    int iHashCode2 = strSubstring2.hashCode();
                    if (iHashCode2 != 3309) {
                        if (iHashCode2 != 3464) {
                            if (iHashCode2 != 96708) {
                                if (iHashCode2 == 3374865 && strSubstring2.equals("nbsp")) {
                                    b = 2;
                                } else {
                                    b = -1;
                                }
                            } else if (strSubstring2.equals("amp")) {
                                b = 3;
                            } else {
                                b = -1;
                            }
                        } else if (strSubstring2.equals("lt")) {
                            b = 0;
                        } else {
                            b = -1;
                        }
                    } else if (strSubstring2.equals("gt")) {
                        b = 1;
                    } else {
                        b = -1;
                    }
                    if (b == 0) {
                        spannableStringBuilder.append('<');
                    } else if (b == 1) {
                        spannableStringBuilder.append('>');
                    } else if (b == 2) {
                        spannableStringBuilder.append(' ');
                    } else if (b != 3) {
                        zzea.zzf("WebvttCueParser", "ignoring unsupported entity: '&" + strSubstring2 + ";'");
                    } else {
                        spannableStringBuilder.append('&');
                    }
                    if (iIndexOf2 == iIndexOf3) {
                        spannableStringBuilder.append((CharSequence) " ");
                    }
                    i5 = iIndexOf2 + 1;
                    i3 = 1;
                } else {
                    i = 1;
                    spannableStringBuilder.append(cCharAt);
                }
                i2 = -1;
                i4 = 0;
            }
            i3 = i;
            i5 = i6;
            i2 = -1;
            i4 = 0;
        }
        while (!arrayDeque.isEmpty()) {
            zzg(str, (zzamh) arrayDeque.pop(), arrayList, spannableStringBuilder, list);
        }
        zzg(str, zzamh.zzb(), Collections.emptyList(), spannableStringBuilder, list);
        return SpannedString.valueOf(spannableStringBuilder);
    }

    public static zzcs zzb(String str) {
        zzamj zzamjVar = new zzamj();
        zzh(str, zzamjVar);
        return zzamjVar.zza();
    }

    public static zzame zzc(zzen zzenVar, List list) {
        Charset charset = StandardCharsets.UTF_8;
        String strZzz = zzenVar.zzz(charset);
        if (strZzz != null) {
            Pattern pattern = zza;
            Matcher matcher = pattern.matcher(strZzz);
            if (matcher.matches()) {
                return zze(null, matcher, zzenVar, list);
            }
            String strZzz2 = zzenVar.zzz(charset);
            if (strZzz2 != null) {
                Matcher matcher2 = pattern.matcher(strZzz2);
                if (matcher2.matches()) {
                    return zze(strZzz.trim(), matcher2, zzenVar, list);
                }
            }
        }
        return null;
    }

    private static int zzd(List list, String str, zzamh zzamhVar) {
        List listZzf = zzf(list, str, zzamhVar);
        for (int i = 0; i < listZzf.size(); i++) {
            zzamd zzamdVar = ((zzami) listZzf.get(i)).zzb;
            if (zzamdVar.zze() != -1) {
                return zzamdVar.zze();
            }
        }
        return -1;
    }

    private static zzame zze(String str, Matcher matcher, zzen zzenVar, List list) {
        zzamj zzamjVar = new zzamj();
        try {
            String strGroup = matcher.group(1);
            if (strGroup == null) {
                throw null;
            }
            zzamjVar.zza = zzamn.zzb(strGroup);
            String strGroup2 = matcher.group(2);
            if (strGroup2 == null) {
                throw null;
            }
            zzamjVar.zzb = zzamn.zzb(strGroup2);
            String strGroup3 = matcher.group(3);
            strGroup3.getClass();
            zzh(strGroup3, zzamjVar);
            StringBuilder sb = new StringBuilder();
            String strZzz = zzenVar.zzz(StandardCharsets.UTF_8);
            while (!TextUtils.isEmpty(strZzz)) {
                if (sb.length() > 0) {
                    sb.append("\n");
                }
                sb.append(strZzz.trim());
                strZzz = zzenVar.zzz(StandardCharsets.UTF_8);
            }
            zzamjVar.zzc = zza(str, sb.toString(), list);
            return new zzame(zzamjVar.zza().zzq(), zzamjVar.zza, zzamjVar.zzb);
        } catch (IllegalArgumentException unused) {
            zzea.zzf("WebvttCueParser", "Skipping cue with bad header: ".concat(String.valueOf(matcher.group())));
            return null;
        }
    }

    private static List zzf(List list, String str, zzamh zzamhVar) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            zzamd zzamdVar = (zzamd) list.get(i);
            int iZzf = zzamdVar.zzf(str, zzamhVar.zza, zzamhVar.zzd, zzamhVar.zzc);
            if (iZzf > 0) {
                arrayList.add(new zzami(iZzf, zzamdVar));
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:43:0x0086  */
    private static void zzg(String str, zzamh zzamhVar, List list, SpannableStringBuilder spannableStringBuilder, List list2) {
        byte b;
        int i = zzamhVar.zzb;
        int length = spannableStringBuilder.length();
        String str2 = zzamhVar.zza;
        int iHashCode = str2.hashCode();
        int i2 = -1;
        if (iHashCode != 0) {
            if (iHashCode != 105) {
                if (iHashCode != 3314158) {
                    if (iHashCode != 3511770) {
                        if (iHashCode != 98) {
                            if (iHashCode != 99) {
                                if (iHashCode != 117) {
                                    if (iHashCode == 118 && str2.equals("v")) {
                                        b = 5;
                                    } else {
                                        b = -1;
                                    }
                                } else if (str2.equals("u")) {
                                    b = 3;
                                } else {
                                    b = -1;
                                }
                            } else if (str2.equals("c")) {
                                b = 4;
                            } else {
                                b = -1;
                            }
                        } else if (str2.equals("b")) {
                            b = 0;
                        } else {
                            b = -1;
                        }
                    } else if (str2.equals("ruby")) {
                        b = 2;
                    } else {
                        b = -1;
                    }
                } else if (str2.equals("lang")) {
                    b = 6;
                } else {
                    b = -1;
                }
            } else if (str2.equals("i")) {
                b = 1;
            } else {
                b = -1;
            }
        } else if (str2.equals("")) {
            b = 7;
        } else {
            b = -1;
        }
        switch (b) {
            case 0:
                spannableStringBuilder.setSpan(new StyleSpan(1), i, length, 33);
                break;
            case 1:
                spannableStringBuilder.setSpan(new StyleSpan(2), i, length, 33);
                break;
            case 2:
                int iZzd = zzd(list2, str, zzamhVar);
                ArrayList arrayList = new ArrayList(list.size());
                arrayList.addAll(list);
                Collections.sort(arrayList, zzamg.zza);
                int i3 = i;
                int i4 = 0;
                int length2 = 0;
                while (i4 < arrayList.size()) {
                    if ("rt".equals(((zzamg) arrayList.get(i4)).zzb.zza)) {
                        zzamg zzamgVar = (zzamg) arrayList.get(i4);
                        int iZzd2 = zzd(list2, str, zzamgVar.zzb);
                        if (iZzd2 == i2) {
                            iZzd2 = iZzd != i2 ? iZzd : 1;
                        }
                        int i5 = zzamgVar.zzb.zzb - length2;
                        int i6 = zzamgVar.zzc - length2;
                        CharSequence charSequenceSubSequence = spannableStringBuilder.subSequence(i5, i6);
                        spannableStringBuilder.delete(i5, i6);
                        spannableStringBuilder.setSpan(new zzcz(charSequenceSubSequence.toString(), iZzd2), i3, i5, 33);
                        length2 += charSequenceSubSequence.length();
                        i3 = i5;
                    }
                    i4++;
                    i2 = -1;
                }
                break;
            case 3:
                spannableStringBuilder.setSpan(new UnderlineSpan(), i, length, 33);
                break;
            case 4:
                for (String str3 : zzamhVar.zzd) {
                    Map map = zzc;
                    if (map.containsKey(str3)) {
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(((Integer) map.get(str3)).intValue()), i, length, 33);
                    } else {
                        Map map2 = zzd;
                        if (map2.containsKey(str3)) {
                            spannableStringBuilder.setSpan(new BackgroundColorSpan(((Integer) map2.get(str3)).intValue()), i, length, 33);
                        }
                    }
                }
                break;
            case 5:
                spannableStringBuilder.setSpan(new zzdc(zzamhVar.zzc), i, length, 33);
                break;
            case 6:
            case 7:
                break;
            default:
                return;
        }
        List listZzf = zzf(list2, str, zzamhVar);
        for (int i7 = 0; i7 < listZzf.size(); i7++) {
            zzamd zzamdVar = ((zzami) listZzf.get(i7)).zzb;
            if (zzamdVar != null) {
                if (zzamdVar.zzg() != -1) {
                    zzda.zzb(spannableStringBuilder, new StyleSpan(zzamdVar.zzg()), i, length, 33);
                }
                if (zzamdVar.zzz()) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), i, length, 33);
                }
                if (zzamdVar.zzy()) {
                    zzda.zzb(spannableStringBuilder, new ForegroundColorSpan(zzamdVar.zzc()), i, length, 33);
                }
                if (zzamdVar.zzx()) {
                    zzda.zzb(spannableStringBuilder, new BackgroundColorSpan(zzamdVar.zzb()), i, length, 33);
                }
                if (zzamdVar.zzr() != null) {
                    zzda.zzb(spannableStringBuilder, new TypefaceSpan(zzamdVar.zzr()), i, length, 33);
                }
                int iZzd3 = zzamdVar.zzd();
                if (iZzd3 == 1) {
                    zzda.zzb(spannableStringBuilder, new AbsoluteSizeSpan((int) zzamdVar.zza(), true), i, length, 33);
                } else if (iZzd3 == 2) {
                    zzda.zzb(spannableStringBuilder, new RelativeSizeSpan(zzamdVar.zza()), i, length, 33);
                } else if (iZzd3 == 3) {
                    zzda.zzb(spannableStringBuilder, new RelativeSizeSpan(zzamdVar.zza() / 100.0f), i, length, 33);
                }
                if (zzamdVar.zzw()) {
                    spannableStringBuilder.setSpan(new zzcy(), i, length, 33);
                }
            }
        }
    }

    static {
        HashMap map = new HashMap();
        map.put("white", Integer.valueOf(Color.rgb(255, 255, 255)));
        map.put("lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        map.put(JuorMn.HtSJTfz, Integer.valueOf(Color.rgb(0, 255, 255)));
        map.put("red", Integer.valueOf(Color.rgb(255, 0, 0)));
        map.put("yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        map.put("magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        map.put("blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        map.put("black", Integer.valueOf(Color.rgb(0, 0, 0)));
        zzc = Collections.unmodifiableMap(map);
        HashMap map2 = new HashMap();
        map2.put("bg_white", Integer.valueOf(Color.rgb(255, 255, 255)));
        map2.put("bg_lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        map2.put("bg_cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        map2.put("bg_red", Integer.valueOf(Color.rgb(255, 0, 0)));
        map2.put("bg_yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        map2.put(RDFWIi.BOxi, Integer.valueOf(Color.rgb(255, 0, 255)));
        map2.put("bg_blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        map2.put("bg_black", Integer.valueOf(Color.rgb(0, 0, 0)));
        zzd = Collections.unmodifiableMap(map2);
    }

    private static void zzh(String str, zzamj zzamjVar) {
        Matcher matcher = zzb.matcher(str);
        while (matcher.find()) {
            int i = 1;
            String strGroup = matcher.group(1);
            strGroup.getClass();
            int i2 = 2;
            String strGroup2 = matcher.group(2);
            strGroup2.getClass();
            try {
                boolean zEquals = dLDI.RWMfpAv.equals(strGroup);
                String str2 = YcVWhnLsj.lVxb;
                byte b = -1;
                if (zEquals) {
                    int iIndexOf = strGroup2.indexOf(44);
                    if (iIndexOf != -1) {
                        String strSubstring = strGroup2.substring(iIndexOf + 1);
                        switch (strSubstring.hashCode()) {
                            case -1364013995:
                                if (strSubstring.equals("center")) {
                                    b = 1;
                                }
                                break;
                            case -1074341483:
                                if (strSubstring.equals("middle")) {
                                    b = 2;
                                }
                                break;
                            case 100571:
                                if (strSubstring.equals("end")) {
                                    b = 3;
                                }
                                break;
                            case 109757538:
                                if (strSubstring.equals(str2)) {
                                    b = 0;
                                }
                                break;
                        }
                        if (b == 0) {
                            i2 = 0;
                        } else if (b == 1 || b == 2) {
                            i2 = 1;
                        } else if (b != 3) {
                            zzea.zzf("WebvttCueParser", "Invalid anchor value: ".concat(strSubstring));
                            i2 = Integer.MIN_VALUE;
                        }
                        zzamjVar.zzg = i2;
                        strGroup2 = strGroup2.substring(0, iIndexOf);
                    }
                    if (strGroup2.endsWith("%")) {
                        zzamjVar.zze = zzamn.zza(strGroup2);
                        zzamjVar.zzf = 0;
                    } else {
                        zzamjVar.zze = Integer.parseInt(strGroup2);
                        zzamjVar.zzf = 1;
                    }
                } else if ("align".equals(strGroup)) {
                    switch (strGroup2.hashCode()) {
                        case -1364013995:
                            if (strGroup2.equals("center")) {
                                b = 2;
                            }
                            break;
                        case -1074341483:
                            if (strGroup2.equals("middle")) {
                                b = 3;
                            }
                            break;
                        case 100571:
                            if (strGroup2.equals("end")) {
                                b = 4;
                            }
                            break;
                        case 3317767:
                            if (strGroup2.equals("left")) {
                                b = 1;
                            }
                            break;
                        case 108511772:
                            if (strGroup2.equals("right")) {
                                b = 5;
                            }
                            break;
                        case 109757538:
                            if (strGroup2.equals(str2)) {
                                b = 0;
                            }
                            break;
                    }
                    if (b != 0) {
                        if (b == 1) {
                            i = 4;
                        } else if (b == 2 || b == 3) {
                            i = 2;
                        } else if (b == 4) {
                            i = 3;
                        } else if (b != 5) {
                            zzea.zzf("WebvttCueParser", "Invalid alignment value: ".concat(strGroup2));
                            i = 2;
                        } else {
                            i = 5;
                        }
                    }
                    zzamjVar.zzd = i;
                } else if ("position".equals(strGroup)) {
                    int iIndexOf2 = strGroup2.indexOf(44);
                    if (iIndexOf2 != -1) {
                        String strSubstring2 = strGroup2.substring(iIndexOf2 + 1);
                        switch (strSubstring2.hashCode()) {
                            case -1842484672:
                                if (strSubstring2.equals("line-left")) {
                                    b = 0;
                                }
                                break;
                            case -1364013995:
                                if (strSubstring2.equals("center")) {
                                    b = 2;
                                }
                                break;
                            case -1276788989:
                                if (strSubstring2.equals("line-right")) {
                                    b = 4;
                                }
                                break;
                            case -1074341483:
                                if (strSubstring2.equals("middle")) {
                                    b = 3;
                                }
                                break;
                            case 100571:
                                if (strSubstring2.equals("end")) {
                                    b = 5;
                                }
                                break;
                            case 109757538:
                                if (strSubstring2.equals(str2)) {
                                    b = 1;
                                }
                                break;
                        }
                        if (b == 0 || b == 1) {
                            i = 0;
                        } else if (b != 2 && b != 3) {
                            if (b == 4 || b == 5) {
                                i = 2;
                            } else {
                                zzea.zzf("WebvttCueParser", "Invalid anchor value: ".concat(strSubstring2));
                                i = Integer.MIN_VALUE;
                            }
                        }
                        zzamjVar.zzi = i;
                        strGroup2 = strGroup2.substring(0, iIndexOf2);
                    }
                    zzamjVar.zzh = zzamn.zza(strGroup2);
                } else if ("size".equals(strGroup)) {
                    zzamjVar.zzj = zzamn.zza(strGroup2);
                } else if ("vertical".equals(strGroup)) {
                    int iHashCode = strGroup2.hashCode();
                    if (iHashCode != 3462) {
                        if (iHashCode == 3642 && strGroup2.equals("rl")) {
                            b = 0;
                        }
                    } else if (strGroup2.equals("lr")) {
                        b = 1;
                    }
                    if (b != 0) {
                        if (b != 1) {
                            zzea.zzf("WebvttCueParser", "Invalid 'vertical' value: ".concat(strGroup2));
                            i = Integer.MIN_VALUE;
                        } else {
                            i = 2;
                        }
                    }
                    zzamjVar.zzk = i;
                } else {
                    zzea.zzf("WebvttCueParser", "Unknown cue setting " + strGroup + ":" + strGroup2);
                }
            } catch (NumberFormatException unused) {
                zzea.zzf("WebvttCueParser", "Skipping bad cue setting: ".concat(String.valueOf(matcher.group())));
            }
        }
    }
}
