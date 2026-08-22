package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
final class zzamc {
    private static final Pattern zza = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
    private static final Pattern zzb = Pattern.compile("^((?:[0-9]*\\.)?[0-9]+)(px|em|%)$");
    private final zzen zzc = new zzen();
    private final StringBuilder zzd = new StringBuilder();

    public static String zza(zzen zzenVar, StringBuilder sb) {
        zzc(zzenVar);
        if (zzenVar.zza() == 0) {
            return null;
        }
        String strZzd = zzd(zzenVar, sb);
        if (!"".equals(strZzd)) {
            return strZzd;
        }
        char cZzm = (char) zzenVar.zzm();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(cZzm);
        return sb2.toString();
    }

    public static void zzc(zzen zzenVar) {
        while (true) {
            for (boolean z = true; zzenVar.zza() > 0 && z; z = false) {
                char c = (char) zzenVar.zzN()[zzenVar.zzc()];
                if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') {
                    zzenVar.zzM(1);
                } else {
                    int iZzc = zzenVar.zzc();
                    int iZzd = zzenVar.zzd();
                    byte[] bArrZzN = zzenVar.zzN();
                    if (iZzc + 2 <= iZzd) {
                        int i = iZzc + 1;
                        if (bArrZzN[iZzc] == 47) {
                            int i2 = iZzc + 2;
                            if (bArrZzN[i] == 42) {
                                while (true) {
                                    int i3 = i2 + 1;
                                    if (i3 >= iZzd) {
                                        break;
                                    }
                                    if (((char) bArrZzN[i2]) == '*' && ((char) bArrZzN[i3]) == '/') {
                                        iZzd = i2 + 2;
                                        i2 = iZzd;
                                    } else {
                                        i2 = i3;
                                    }
                                }
                                zzenVar.zzM(iZzd - zzenVar.zzc());
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
            return;
        }
    }

    private static String zzd(zzen zzenVar, StringBuilder sb) {
        char c;
        sb.setLength(0);
        int iZzc = zzenVar.zzc();
        int iZzd = zzenVar.zzd();
        loop0: while (true) {
            boolean z = false;
            while (true) {
                if (iZzc < iZzd && !z) {
                    c = (char) zzenVar.zzN()[iZzc];
                    if ((c >= 'A' && c <= 'Z') || ((c >= 'a' && c <= 'z') || ((c >= '0' && c <= '9') || c == '#' || c == '-' || c == '.' || c == '_'))) {
                        break;
                    }
                    z = true;
                } else {
                    break loop0;
                }
            }
            sb.append(c);
            iZzc++;
        }
        zzenVar.zzM(iZzc - zzenVar.zzc());
        return sb.toString();
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01db  */
    /* JADX WARN: Code duplicated, block: B:103:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:104:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:106:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:107:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:109:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:113:0x020d  */
    /* JADX WARN: Code duplicated, block: B:116:0x0215  */
    /* JADX WARN: Code duplicated, block: B:118:0x021d  */
    /* JADX WARN: Code duplicated, block: B:120:0x0225  */
    /* JADX WARN: Code duplicated, block: B:121:0x022a  */
    /* JADX WARN: Code duplicated, block: B:123:0x0232  */
    /* JADX WARN: Code duplicated, block: B:124:0x0237  */
    /* JADX WARN: Code duplicated, block: B:126:0x023f  */
    /* JADX WARN: Code duplicated, block: B:128:0x0247  */
    /* JADX WARN: Code duplicated, block: B:129:0x024c  */
    /* JADX WARN: Code duplicated, block: B:131:0x0254  */
    /* JADX WARN: Code duplicated, block: B:133:0x025c  */
    /* JADX WARN: Code duplicated, block: B:134:0x0261  */
    /* JADX WARN: Code duplicated, block: B:136:0x0269  */
    /* JADX WARN: Code duplicated, block: B:138:0x0279  */
    /* JADX WARN: Code duplicated, block: B:139:0x0292  */
    /* JADX WARN: Code duplicated, block: B:141:0x02a1  */
    /* JADX WARN: Code duplicated, block: B:143:0x02a5  */
    /* JADX WARN: Code duplicated, block: B:149:0x02b4  */
    /* JADX WARN: Code duplicated, block: B:151:0x02bc  */
    /* JADX WARN: Code duplicated, block: B:152:0x02be  */
    /* JADX WARN: Code duplicated, block: B:154:0x02c6  */
    /* JADX WARN: Code duplicated, block: B:155:0x02c8  */
    /* JADX WARN: Code duplicated, block: B:157:0x02cb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:158:0x02cd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:159:0x02cf  */
    /* JADX WARN: Code duplicated, block: B:162:0x02da  */
    /* JADX WARN: Code duplicated, block: B:163:0x02de  */
    /* JADX WARN: Code duplicated, block: B:175:0x02d4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:186:0x02ef A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:189:0x02ef A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:192:0x02ef A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:194:0x02ef A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:196:0x02ef A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:8:0x003f  */
    /* JADX WARN: Code duplicated, block: B:95:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:96:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:98:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:99:0x01d2  */
    /* JADX WARN: Instruction removed from duplicated block: B:138:0x0279, please report this as an issue */
    public final List zzb(zzen zzenVar) {
        String strTrim;
        String string;
        Matcher matcher;
        String strGroup;
        int iHashCode;
        byte b;
        boolean z;
        int i = -1;
        StringBuilder sb = this.zzd;
        int i2 = 0;
        sb.setLength(0);
        int iZzc = zzenVar.zzc();
        while (!TextUtils.isEmpty(zzenVar.zzz(StandardCharsets.UTF_8))) {
        }
        zzen zzenVar2 = this.zzc;
        zzenVar2.zzJ(zzenVar.zzN(), zzenVar.zzc());
        zzenVar2.zzL(iZzc);
        ArrayList arrayList = new ArrayList();
        while (true) {
            zzc(zzenVar2);
            if (zzenVar2.zza() >= 5 && "::cue".equals(zzenVar2.zzB(5, StandardCharsets.UTF_8))) {
                int iZzc2 = zzenVar2.zzc();
                String strZza = zza(zzenVar2, sb);
                if (strZza == null) {
                    strTrim = null;
                } else if ("{".equals(strZza)) {
                    zzenVar2.zzL(iZzc2);
                    strTrim = "";
                } else {
                    if ("(".equals(strZza)) {
                        int iZzc3 = zzenVar2.zzc();
                        int iZzd = zzenVar2.zzd();
                        int i3 = i2;
                        while (iZzc3 < iZzd && i3 == 0) {
                            int i4 = iZzc3 + 1;
                            i3 = ((char) zzenVar2.zzN()[iZzc3]) == ')' ? 1 : i2;
                            iZzc3 = i4;
                        }
                        strTrim = zzenVar2.zzB((iZzc3 + i) - zzenVar2.zzc(), StandardCharsets.UTF_8).trim();
                    } else {
                        strTrim = null;
                    }
                    if (!")".equals(zza(zzenVar2, sb))) {
                        strTrim = null;
                    }
                }
            } else {
                strTrim = null;
            }
            if (strTrim == null || !"{".equals(zza(zzenVar2, sb))) {
                break;
            }
            zzamd zzamdVar = new zzamd();
            if (!"".equals(strTrim)) {
                int iIndexOf = strTrim.indexOf(91);
                if (iIndexOf != i) {
                    Matcher matcher2 = zza.matcher(strTrim.substring(iIndexOf));
                    if (matcher2.matches()) {
                        String strGroup2 = matcher2.group(1);
                        strGroup2.getClass();
                        zzamdVar.zzv(strGroup2);
                    }
                    strTrim = strTrim.substring(i2, iIndexOf);
                }
                String str = zzex.zza;
                String[] strArrSplit = strTrim.split("\\.", i);
                String str2 = strArrSplit[i2];
                int iIndexOf2 = str2.indexOf(35);
                if (iIndexOf2 != i) {
                    zzamdVar.zzu(str2.substring(i2, iIndexOf2));
                    zzamdVar.zzt(str2.substring(iIndexOf2 + 1));
                } else {
                    zzamdVar.zzu(str2);
                }
                int length = strArrSplit.length;
                if (length > 1) {
                    zzamdVar.zzs((String[]) Arrays.copyOfRange(strArrSplit, 1, length));
                }
            }
            int i5 = i2;
            String strZza2 = null;
            while (i5 == 0) {
                int iZzc4 = zzenVar2.zzc();
                strZza2 = zza(zzenVar2, sb);
                int i6 = (strZza2 == null || "}".equals(strZza2)) ? 1 : i2;
                if (i6 == 0) {
                    zzenVar2.zzL(iZzc4);
                    zzc(zzenVar2);
                    String strZzd = zzd(zzenVar2, sb);
                    if (!"".equals(strZzd) && ":".equals(zza(zzenVar2, sb))) {
                        zzc(zzenVar2);
                        StringBuilder sb2 = new StringBuilder();
                        int i7 = i2;
                        while (true) {
                            if (i7 != 0) {
                                string = sb2.toString();
                                break;
                            }
                            int iZzc5 = zzenVar2.zzc();
                            String strZza3 = zza(zzenVar2, sb);
                            if (strZza3 == null) {
                                string = null;
                                break;
                            }
                            if ("}".equals(strZza3) || ";".equals(strZza3)) {
                                zzenVar2.zzL(iZzc5);
                                i7 = 1;
                            } else {
                                sb2.append(strZza3);
                            }
                        }
                        if (string != null && !"".equals(string)) {
                            int iZzc6 = zzenVar2.zzc();
                            String strZza4 = zza(zzenVar2, sb);
                            if (";".equals(strZza4)) {
                                if ("color".equals(strZzd)) {
                                    zzamdVar.zzk(zzdl.zza(string));
                                } else if ("background-color".equals(strZzd)) {
                                    zzamdVar.zzh(zzdl.zza(string));
                                } else if ("ruby-position".equals(strZzd)) {
                                    if ("over".equals(string)) {
                                        zzamdVar.zzp(1);
                                    } else if ("under".equals(string)) {
                                        zzamdVar.zzp(2);
                                    }
                                } else if ("text-combine-upright".equals(strZzd)) {
                                    if ("all".equals(string)) {
                                        z = true;
                                    } else {
                                        z = true;
                                    }
                                    zzamdVar.zzj(z);
                                } else if ("text-decoration".equals(strZzd)) {
                                    if ("underline".equals(string)) {
                                        zzamdVar.zzq(true);
                                    }
                                } else if ("font-family".equals(strZzd)) {
                                    zzamdVar.zzl(string);
                                } else if ("font-weight".equals(strZzd)) {
                                    if ("bold".equals(string)) {
                                        zzamdVar.zzi(true);
                                    }
                                } else if ("font-style".equals(strZzd)) {
                                    if ("italic".equals(string)) {
                                        zzamdVar.zzo(true);
                                    }
                                } else if ("font-size".equals(strZzd)) {
                                    matcher = zzb.matcher(zzfuv.zza(string));
                                    if (matcher.matches()) {
                                        strGroup = matcher.group(2);
                                        strGroup.getClass();
                                        iHashCode = strGroup.hashCode();
                                        if (iHashCode != 37) {
                                            if (iHashCode != 3240) {
                                                if (iHashCode != 3592) {
                                                    b = -1;
                                                } else {
                                                    b = 0;
                                                }
                                            } else if (strGroup.equals("em")) {
                                                b = 1;
                                            } else {
                                                b = -1;
                                            }
                                        } else if (strGroup.equals("%")) {
                                            b = 2;
                                        } else {
                                            b = -1;
                                        }
                                        if (b != 0) {
                                            zzamdVar.zzn(1);
                                        } else if (b != 1) {
                                            zzamdVar.zzn(2);
                                        } else {
                                            if (b == 2) {
                                                throw new IllegalStateException();
                                            }
                                            zzamdVar.zzn(3);
                                        }
                                        String strGroup3 = matcher.group(1);
                                        strGroup3.getClass();
                                        zzamdVar.zzm(Float.parseFloat(strGroup3));
                                    } else {
                                        zzea.zzf("WebvttCssParser", "Invalid font-size: '" + string + "'.");
                                    }
                                } else {
                                    continue;
                                }
                            } else if ("}".equals(strZza4)) {
                                zzenVar2.zzL(iZzc6);
                                if ("color".equals(strZzd)) {
                                    zzamdVar.zzk(zzdl.zza(string));
                                } else if ("background-color".equals(strZzd)) {
                                    zzamdVar.zzh(zzdl.zza(string));
                                } else if ("ruby-position".equals(strZzd)) {
                                    if ("over".equals(string)) {
                                        zzamdVar.zzp(1);
                                    } else if ("under".equals(string)) {
                                        zzamdVar.zzp(2);
                                    }
                                } else if ("text-combine-upright".equals(strZzd)) {
                                    if ("all".equals(string) || string.startsWith("digits")) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    zzamdVar.zzj(z);
                                } else if ("text-decoration".equals(strZzd)) {
                                    if ("underline".equals(string)) {
                                        zzamdVar.zzq(true);
                                    }
                                } else if ("font-family".equals(strZzd)) {
                                    zzamdVar.zzl(string);
                                } else if ("font-weight".equals(strZzd)) {
                                    if ("bold".equals(string)) {
                                        zzamdVar.zzi(true);
                                    }
                                } else if ("font-style".equals(strZzd)) {
                                    if ("italic".equals(string)) {
                                        zzamdVar.zzo(true);
                                    }
                                } else if ("font-size".equals(strZzd)) {
                                    matcher = zzb.matcher(zzfuv.zza(string));
                                    if (matcher.matches()) {
                                        zzea.zzf("WebvttCssParser", "Invalid font-size: '" + string + "'.");
                                    } else {
                                        strGroup = matcher.group(2);
                                        strGroup.getClass();
                                        iHashCode = strGroup.hashCode();
                                        if (iHashCode != 37) {
                                            if (iHashCode != 3240) {
                                                if (iHashCode != 3592 && strGroup.equals("px")) {
                                                    b = 0;
                                                } else {
                                                    b = -1;
                                                }
                                            } else if (strGroup.equals("em")) {
                                                b = 1;
                                            } else {
                                                b = -1;
                                            }
                                        } else if (strGroup.equals("%")) {
                                            b = 2;
                                        } else {
                                            b = -1;
                                        }
                                        if (b != 0) {
                                            zzamdVar.zzn(1);
                                        } else if (b != 1) {
                                            zzamdVar.zzn(2);
                                        } else {
                                            if (b == 2) {
                                                throw new IllegalStateException();
                                            }
                                            zzamdVar.zzn(3);
                                        }
                                        String strGroup4 = matcher.group(1);
                                        strGroup4.getClass();
                                        zzamdVar.zzm(Float.parseFloat(strGroup4));
                                    }
                                } else {
                                    continue;
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                }
                i5 = i6;
                i2 = 0;
            }
            if ("}".equals(strZza2)) {
                arrayList.add(zzamdVar);
            }
            i = -1;
            i2 = 0;
        }
        return arrayList;
    }
}
