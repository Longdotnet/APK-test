package com.google.android.gms.internal.ads;

import android.text.Layout;
import com.facebook.login.vu.dLDI;
import com.google.android.finsky.externalreferrer.jUdg.RDFWIi;
import com.google.android.gms.appset.vSSa.iafHZUfOuHNwvy;
import com.google.android.gms.auth.api.LNi.xPQrbOSWiEdU;
import com.google.android.gms.common.util.concurrent.dN.MnHfHMYQDPUO;
import com.google.android.gms.internal.common.Ko.TSDAbK;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.zxing.BarcodeFormat$EnumUnboxingLocalUtility;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.coroutines.jvm.internal.DEXi.JuorMn;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: loaded from: classes2.dex */
public final class zzalt implements zzakt {
    private final XmlPullParserFactory zzi;
    private static final Pattern zzc = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    private static final Pattern zzd = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
    private static final Pattern zze = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
    static final Pattern zza = Pattern.compile("^([-+]?\\d+\\.?\\d*?)%$");
    static final Pattern zzb = Pattern.compile("^([-+]?\\d+\\.?\\d*?)% ([-+]?\\d+\\.?\\d*?)%$");
    private static final Pattern zzf = Pattern.compile("^([-+]?\\d+\\.?\\d*?)px ([-+]?\\d+\\.?\\d*?)px$");
    private static final Pattern zzg = Pattern.compile(TSDAbK.VRVpJr);
    private static final zzalr zzh = new zzalr(30.0f, 1, 1);

    public zzalt() {
        try {
            XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
            this.zzi = xmlPullParserFactoryNewInstance;
            xmlPullParserFactoryNewInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:50:0x00f2  */
    private static long zzc(String str, zzalr zzalrVar) throws zzakp {
        double d;
        double d2;
        Matcher matcher = zzc.matcher(str);
        byte b = 2;
        if (matcher.matches()) {
            String strGroup = matcher.group(1);
            strGroup.getClass();
            long j = Long.parseLong(strGroup) * 3600;
            String strGroup2 = matcher.group(2);
            strGroup2.getClass();
            long j2 = Long.parseLong(strGroup2) * 60;
            String strGroup3 = matcher.group(3);
            strGroup3.getClass();
            double d3 = j + j2;
            double d4 = Long.parseLong(strGroup3);
            String strGroup4 = matcher.group(4);
            double d5 = 0.0d;
            double d6 = strGroup4 != null ? Double.parseDouble(strGroup4) : 0.0d;
            double d7 = d3 + d4;
            String strGroup5 = matcher.group(5);
            double d8 = strGroup5 != null ? Long.parseLong(strGroup5) / zzalrVar.zza : 0.0d;
            double d9 = d7 + d6;
            String strGroup6 = matcher.group(6);
            if (strGroup6 != null) {
                d5 = (Long.parseLong(strGroup6) / ((double) zzalrVar.zzb)) / ((double) zzalrVar.zza);
            }
            return (long) ((d9 + d8 + d5) * 1000000.0d);
        }
        Matcher matcher2 = zzd.matcher(str);
        if (!matcher2.matches()) {
            throw new zzakp("Malformed time expression: ".concat(String.valueOf(str)));
        }
        String strGroup7 = matcher2.group(1);
        strGroup7.getClass();
        double d10 = Double.parseDouble(strGroup7);
        String strGroup8 = matcher2.group(2);
        strGroup8.getClass();
        int iHashCode = strGroup8.hashCode();
        if (iHashCode != 102) {
            if (iHashCode != 104) {
                if (iHashCode != 109) {
                    if (iHashCode != 3494) {
                        if (iHashCode != 115) {
                            if (iHashCode == 116 && strGroup8.equals("t")) {
                                b = 5;
                            } else {
                                b = -1;
                            }
                        } else if (!strGroup8.equals("s")) {
                            b = -1;
                        }
                    } else if (strGroup8.equals("ms")) {
                        b = 3;
                    } else {
                        b = -1;
                    }
                } else if (strGroup8.equals("m")) {
                    b = 1;
                } else {
                    b = -1;
                }
            } else if (strGroup8.equals("h")) {
                b = 0;
            } else {
                b = -1;
            }
        } else if (strGroup8.equals("f")) {
            b = 4;
        } else {
            b = -1;
        }
        if (b != 0) {
            if (b != 1) {
                if (b == 3) {
                    d2 = 1000.0d;
                } else if (b == 4) {
                    d2 = zzalrVar.zza;
                } else if (b == 5) {
                    d2 = zzalrVar.zzc;
                }
                d10 /= d2;
            } else {
                d = 60.0d;
            }
            return (long) (d10 * 1000000.0d);
        }
        d = 3600.0d;
        d10 *= d;
        return (long) (d10 * 1000000.0d);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:20:0x0042  */
    private static Layout.Alignment zzd(String str) {
        byte b;
        switch (zzfuv.zza(str)) {
            case "center":
                b = 4;
                break;
            case "end":
                b = 3;
                break;
            case "left":
                b = 0;
                break;
            case "right":
                b = 2;
                break;
            case "start":
                b = 1;
                break;
            default:
                b = -1;
                break;
        }
        if (b == 0 || b == 1) {
            return Layout.Alignment.ALIGN_NORMAL;
        }
        if (b == 2 || b == 3) {
            return Layout.Alignment.ALIGN_OPPOSITE;
        }
        if (b != 4) {
            return null;
        }
        return Layout.Alignment.ALIGN_CENTER;
    }

    private static zzalw zze(zzalw zzalwVar) {
        return zzalwVar == null ? new zzalw() : zzalwVar;
    }

    private static String[] zzg(String str) {
        String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            return new String[0];
        }
        String str2 = zzex.zza;
        return strTrim.split("\\s+", -1);
    }

    @Override // com.google.android.gms.internal.ads.zzakt
    public final void zza(byte[] bArr, int i, int i2, zzaks zzaksVar, zzdn zzdnVar) {
        zzakn.zza(zzb(bArr, i, i2), zzaksVar, zzdnVar);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r11v22 */
    /* JADX WARN: Type inference failed for: r11v23 */
    /* JADX WARN: Type inference failed for: r11v24 */
    /* JADX WARN: Type inference failed for: r11v25 */
    /* JADX WARN: Type inference failed for: r11v26 */
    /* JADX WARN: Type inference failed for: r11v27 */
    /* JADX WARN: Type inference failed for: r11v28 */
    /* JADX WARN: Type inference failed for: r11v29 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v30 */
    /* JADX WARN: Type inference failed for: r11v31 */
    /* JADX WARN: Type inference failed for: r11v32 */
    /* JADX WARN: Type inference failed for: r11v33 */
    /* JADX WARN: Type inference failed for: r11v34 */
    /* JADX WARN: Type inference failed for: r11v35 */
    /* JADX WARN: Type inference failed for: r11v36 */
    /* JADX WARN: Type inference failed for: r11v37 */
    /* JADX WARN: Type inference failed for: r11v38 */
    /* JADX WARN: Type inference failed for: r11v39 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v40 */
    /* JADX WARN: Type inference failed for: r11v41 */
    /* JADX WARN: Type inference failed for: r11v42 */
    /* JADX WARN: Type inference failed for: r11v43 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v27 */
    /* JADX WARN: Type inference failed for: r7v28 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v30 */
    /* JADX WARN: Type inference failed for: r7v31 */
    /* JADX WARN: Type inference failed for: r7v33 */
    /* JADX WARN: Type inference failed for: r7v34 */
    /* JADX WARN: Type inference failed for: r7v36 */
    /* JADX WARN: Type inference failed for: r7v37 */
    /* JADX WARN: Type inference failed for: r7v39 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v40 */
    /* JADX WARN: Type inference failed for: r7v42 */
    /* JADX WARN: Type inference failed for: r7v43 */
    /* JADX WARN: Type inference failed for: r7v45 */
    /* JADX WARN: Type inference failed for: r7v46 */
    /* JADX WARN: Type inference failed for: r7v48 */
    /* JADX WARN: Type inference failed for: r7v49 */
    /* JADX WARN: Type inference failed for: r7v50 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v88 */
    /* JADX WARN: Type inference failed for: r7v89 */
    /* JADX WARN: Type inference failed for: r7v9 */
    private static zzalw zzf(XmlPullParser xmlPullParser, zzalw zzalwVar) {
        ?? r7;
        Matcher matcher;
        int attributeCount = xmlPullParser.getAttributeCount();
        boolean z = false;
        zzalw zzalwVarZze = zzalwVar;
        int i = 0;
        while (i < attributeCount) {
            String attributeValue = xmlPullParser.getAttributeValue(i);
            String attributeName = xmlPullParser.getAttributeName(i);
            ?? r11 = -1;
             = -1;
             = -1;
             = -1;
             = -1;
            ?? r12 = -1;
             = -1;
             = -1;
            ?? r13 = -1;
             = -1;
             = -1;
             = -1;
             = -1;
             = -1;
             = -1;
            ?? r14 = -1;
             = -1;
             = -1;
            ?? r15 = -1;
            r11 = -1;
            r11 = -1;
            r11 = -1;
            switch (attributeName.hashCode()) {
                case -1550943582:
                    r7 = !attributeName.equals("fontStyle") ? -1 : 6;
                    break;
                case -1289044182:
                    r7 = !attributeName.equals("extent") ? -1 : 16;
                    break;
                case -1224696685:
                    r7 = !attributeName.equals("fontFamily") ? -1 : 3;
                    break;
                case -1065511464:
                    r7 = !attributeName.equals("textAlign") ? -1 : 7;
                    break;
                case -1008619738:
                    r7 = !attributeName.equals(FirebaseAnalytics.Param.ORIGIN) ? -1 : 15;
                    break;
                case -879295043:
                    r7 = !attributeName.equals("textDecoration") ? -1 : 12;
                    break;
                case -734428249:
                    r7 = !attributeName.equals("fontWeight") ? -1 : 5;
                    break;
                case 3355:
                    r7 = !attributeName.equals("id") ? -1 : z;
                    break;
                case 3511770:
                    r7 = !attributeName.equals("ruby") ? -1 : 10;
                    break;
                case 94842723:
                    r7 = !attributeName.equals("color") ? -1 : 2;
                    break;
                case 109403361:
                    r7 = !attributeName.equals(xPQrbOSWiEdU.cDYjKvcxkiWp) ? -1 : 14;
                    break;
                case 110138194:
                    r7 = !attributeName.equals("textCombine") ? -1 : 9;
                    break;
                case 365601008:
                    r7 = !attributeName.equals("fontSize") ? -1 : 4;
                    break;
                case 921125321:
                    r7 = !attributeName.equals("textEmphasis") ? -1 : 13;
                    break;
                case 1115953443:
                    r7 = !attributeName.equals("rubyPosition") ? -1 : 11;
                    break;
                case 1287124693:
                    r7 = !attributeName.equals("backgroundColor") ? -1 : 1;
                    break;
                case 1754920356:
                    r7 = !attributeName.equals("multiRowAlign") ? -1 : 8;
                    break;
                default:
                    r7 = -1;
                    break;
            }
            switch (r7) {
                case 0:
                    if ("style".equals(xmlPullParser.getName())) {
                        zzalwVarZze = zze(zzalwVarZze);
                        zzalwVarZze.zzt(attributeValue);
                    }
                    break;
                case 1:
                    zzalwVarZze = zze(zzalwVarZze);
                    try {
                        zzalwVarZze.zzm(zzdl.zzb(attributeValue));
                    } catch (IllegalArgumentException unused) {
                        BarcodeFormat$EnumUnboxingLocalUtility.m(attributeValue, "Failed parsing background value: ", "TtmlParser");
                    }
                    break;
                case 2:
                    zzalwVarZze = zze(zzalwVarZze);
                    try {
                        zzalwVarZze.zzp(zzdl.zzb(attributeValue));
                    } catch (IllegalArgumentException unused2) {
                        BarcodeFormat$EnumUnboxingLocalUtility.m(attributeValue, "Failed parsing color value: ", "TtmlParser");
                    }
                    break;
                case 3:
                    zzalwVarZze = zze(zzalwVarZze);
                    zzalwVarZze.zzq(attributeValue);
                    break;
                case 4:
                    try {
                        zzalwVarZze = zze(zzalwVarZze);
                        String str = zzex.zza;
                        String[] strArrSplit = attributeValue.split("\\s+", -1);
                        int length = strArrSplit.length;
                        if (length == 1) {
                            matcher = zze.matcher(attributeValue);
                        } else {
                            if (length != 2) {
                                throw new zzakp("Invalid number of entries for fontSize: " + length + ".");
                            }
                            matcher = zze.matcher(strArrSplit[1]);
                            zzea.zzf("TtmlParser", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
                        }
                        if (!matcher.matches()) {
                            throw new zzakp("Invalid expression for fontSize: '" + attributeValue + "'.");
                        }
                        String strGroup = matcher.group(3);
                        if (strGroup == null) {
                            throw null;
                        }
                        int iHashCode = strGroup.hashCode();
                        if (iHashCode != 37) {
                            if (iHashCode != 3240) {
                                if (iHashCode == 3592 && strGroup.equals("px")) {
                                    r11 = 0;
                                }
                            } else if (strGroup.equals("em")) {
                                r11 = 1;
                            }
                        } else if (strGroup.equals("%")) {
                            r11 = 2;
                        }
                        if (r11 == 0) {
                            zzalwVarZze.zzs(1);
                        } else if (r11 == 1) {
                            zzalwVarZze.zzs(2);
                        } else {
                            if (r11 != 2) {
                                throw new zzakp("Invalid unit for fontSize: '" + strGroup + "'.");
                            }
                            zzalwVarZze.zzs(3);
                        }
                        String strGroup2 = matcher.group(1);
                        if (strGroup2 == null) {
                            throw null;
                        }
                        zzalwVarZze.zzr(Float.parseFloat(strGroup2));
                    } catch (zzakp unused3) {
                        BarcodeFormat$EnumUnboxingLocalUtility.m(attributeValue, "Failed parsing fontSize value: ", "TtmlParser");
                    }
                    break;
                case 5:
                    zzalwVarZze = zze(zzalwVarZze);
                    zzalwVarZze.zzn("bold".equalsIgnoreCase(attributeValue));
                    break;
                case 6:
                    zzalwVarZze = zze(zzalwVarZze);
                    zzalwVarZze.zzu("italic".equalsIgnoreCase(attributeValue));
                    break;
                case 7:
                    zzalwVarZze = zze(zzalwVarZze);
                    zzalwVarZze.zzB(zzd(attributeValue));
                    break;
                case 8:
                    zzalwVarZze = zze(zzalwVarZze);
                    zzalwVarZze.zzw(zzd(attributeValue));
                    break;
                case 9:
                    String strZza = zzfuv.zza(attributeValue);
                    int iHashCode2 = strZza.hashCode();
                    if (iHashCode2 != 96673) {
                        if (iHashCode2 == 3387192 && strZza.equals("none")) {
                            r15 = z;
                        }
                    } else if (strZza.equals("all")) {
                        r15 = 1;
                    }
                    if (r15 == 0) {
                        zzalwVarZze = zze(zzalwVarZze);
                        zzalwVarZze.zzC(z);
                    } else if (r15 == 1) {
                        zzalwVarZze = zze(zzalwVarZze);
                        zzalwVarZze.zzC(true);
                    }
                    break;
                case 10:
                    String strZza2 = zzfuv.zza(attributeValue);
                    switch (strZza2.hashCode()) {
                        case -618561360:
                            if (strZza2.equals("baseContainer")) {
                                r14 = 2;
                            }
                            break;
                        case -410956671:
                            if (strZza2.equals("container")) {
                                r14 = z;
                            }
                            break;
                        case -250518009:
                            if (strZza2.equals(RDFWIi.oIWOMcVuK)) {
                                r14 = 5;
                            }
                            break;
                        case -136074796:
                            if (strZza2.equals("textContainer")) {
                                r14 = 4;
                            }
                            break;
                        case 3016401:
                            if (strZza2.equals("base")) {
                                r14 = 1;
                            }
                            break;
                        case 3556653:
                            if (strZza2.equals("text")) {
                                r14 = 3;
                            }
                            break;
                    }
                    if (r14 == 0) {
                        zzalwVarZze = zze(zzalwVarZze);
                        zzalwVarZze.zzz(1);
                    } else if (r14 == 1 || r14 == 2) {
                        zzalwVarZze = zze(zzalwVarZze);
                        zzalwVarZze.zzz(2);
                    } else if (r14 == 3 || r14 == 4) {
                        zzalwVarZze = zze(zzalwVarZze);
                        zzalwVarZze.zzz(3);
                    } else if (r14 == 5) {
                        zzalwVarZze = zze(zzalwVarZze);
                        zzalwVarZze.zzz(4);
                    }
                    break;
                case 11:
                    String strZza3 = zzfuv.zza(attributeValue);
                    int iHashCode3 = strZza3.hashCode();
                    if (iHashCode3 != -1392885889) {
                        if (iHashCode3 == 92734940 && strZza3.equals("after")) {
                            r13 = 1;
                        }
                    } else if (strZza3.equals("before")) {
                        r13 = z;
                    }
                    if (r13 == 0) {
                        zzalwVarZze = zze(zzalwVarZze);
                        zzalwVarZze.zzy(1);
                    } else if (r13 == 1) {
                        zzalwVarZze = zze(zzalwVarZze);
                        zzalwVarZze.zzy(2);
                    }
                    break;
                case 12:
                    String strZza4 = zzfuv.zza(attributeValue);
                    switch (strZza4.hashCode()) {
                        case -1461280213:
                            if (strZza4.equals("nounderline")) {
                                r12 = 3;
                            }
                            break;
                        case -1026963764:
                            if (strZza4.equals("underline")) {
                                r12 = 2;
                            }
                            break;
                        case 913457136:
                            if (strZza4.equals("nolinethrough")) {
                                r12 = 1;
                            }
                            break;
                        case 1679736913:
                            if (strZza4.equals("linethrough")) {
                                r12 = z;
                            }
                            break;
                    }
                    if (r12 == 0) {
                        zzalwVarZze = zze(zzalwVarZze);
                        zzalwVarZze.zzv(true);
                    } else if (r12 == 1) {
                        zzalwVarZze = zze(zzalwVarZze);
                        zzalwVarZze.zzv(z);
                    } else if (r12 == 2) {
                        zzalwVarZze = zze(zzalwVarZze);
                        zzalwVarZze.zzE(true);
                    } else if (r12 == 3) {
                        zzalwVarZze = zze(zzalwVarZze);
                        zzalwVarZze.zzE(z);
                    }
                    break;
                case 13:
                    zzalwVarZze = zze(zzalwVarZze);
                    zzalwVarZze.zzD(zzalp.zza(attributeValue));
                    break;
                case 14:
                    zzalw zzalwVarZze2 = zze(zzalwVarZze);
                    Matcher matcher2 = zza.matcher(attributeValue);
                    float fMin = Float.MAX_VALUE;
                    if (matcher2.matches()) {
                        try {
                            String strGroup3 = matcher2.group(1);
                            if (strGroup3 == null) {
                                throw null;
                            }
                            fMin = Math.min(100.0f, Math.max(-100.0f, Float.parseFloat(strGroup3)));
                        } catch (NumberFormatException e) {
                            zzea.zzg("TtmlParser", "Failed to parse shear: ".concat(String.valueOf(attributeValue)), e);
                        }
                    } else {
                        BarcodeFormat$EnumUnboxingLocalUtility.m(attributeValue, "Invalid value for shear: ", "TtmlParser");
                    }
                    zzalwVarZze2.zzA(fMin);
                    zzalwVarZze = zzalwVarZze2;
                    break;
                case 15:
                    zzalwVarZze = zze(zzalwVarZze);
                    zzalwVarZze.zzx(attributeValue);
                    break;
                case 16:
                    zzalwVarZze = zze(zzalwVarZze);
                    zzalwVarZze.zzo(attributeValue);
                    break;
            }
            i++;
            z = false;
        }
        return zzalwVarZze;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:263:0x056e  */
    /* JADX WARN: Code duplicated, block: B:267:0x0574  */
    /* JADX WARN: Code duplicated, block: B:290:0x05cb  */
    /* JADX WARN: Code duplicated, block: B:296:0x05d4  */
    /* JADX WARN: Code duplicated, block: B:301:0x05e9 A[Catch: IOException -> 0x00a3, XmlPullParserException -> 0x00a7, TryCatch #21 {IOException -> 0x00a3, XmlPullParserException -> 0x00a7, blocks: (B:3:0x0010, B:5:0x0071, B:7:0x0079, B:10:0x0086, B:13:0x0094, B:15:0x009c, B:22:0x00ae, B:25:0x00bb, B:29:0x00ce, B:31:0x00ea, B:33:0x00f4, B:34:0x00f8, B:36:0x0104, B:38:0x010f, B:72:0x01ab, B:92:0x020e, B:95:0x021c, B:97:0x0222, B:99:0x022a, B:101:0x0232, B:103:0x023a, B:105:0x0242, B:107:0x024b, B:109:0x0251, B:111:0x0259, B:113:0x0261, B:115:0x0267, B:117:0x026d, B:119:0x0273, B:121:0x027b, B:124:0x0284, B:444:0x082b, B:125:0x02b9, B:127:0x02bf, B:129:0x02c8, B:131:0x02d7, B:133:0x02e2, B:135:0x02f6, B:137:0x02fc, B:303:0x05f3, B:140:0x0313, B:142:0x031b, B:144:0x0321, B:146:0x032a, B:148:0x0332, B:151:0x0343, B:155:0x035d, B:301:0x05e9, B:160:0x037a, B:162:0x0382, B:164:0x0388, B:166:0x0390, B:168:0x0396, B:171:0x03ad, B:173:0x03b3, B:175:0x03c1, B:205:0x0468, B:207:0x046e, B:209:0x0474, B:211:0x047c, B:213:0x0482, B:216:0x0497, B:218:0x049d, B:220:0x04ab, B:249:0x053e, B:251:0x0546, B:271:0x058c, B:273:0x0594, B:299:0x05dc, B:222:0x04bd, B:224:0x04bf, B:225:0x04c0, B:228:0x04d2, B:231:0x04dc, B:234:0x04e9, B:236:0x04ef, B:238:0x04f6, B:240:0x04fc, B:242:0x0510, B:246:0x0518, B:245:0x0517, B:247:0x0524, B:178:0x03d9, B:180:0x03db, B:181:0x03dc, B:182:0x03ed, B:185:0x03f9, B:189:0x0412, B:191:0x0418, B:193:0x041f, B:195:0x0425, B:197:0x0437, B:201:0x043f, B:200:0x043e, B:203:0x0449, B:308:0x0629, B:311:0x064b, B:345:0x06a7, B:347:0x06af, B:420:0x07ab, B:353:0x06c6, B:356:0x06d0, B:360:0x06de, B:363:0x06ea, B:364:0x06f2, B:372:0x070c, B:404:0x0779, B:406:0x0787, B:408:0x078c, B:395:0x0760, B:75:0x01b4, B:77:0x01c0, B:80:0x01cc, B:82:0x01d2, B:84:0x01dd, B:86:0x01ea, B:88:0x01ec, B:89:0x01ed, B:42:0x0128, B:45:0x0136, B:48:0x013f, B:50:0x0145, B:52:0x014c, B:54:0x0152, B:60:0x0168, B:62:0x016f, B:71:0x01a2, B:67:0x0194, B:70:0x01a1, B:424:0x07d7, B:426:0x07e4, B:429:0x07e8, B:431:0x07f2, B:433:0x07fc, B:437:0x0808, B:435:0x0805, B:440:0x081f, B:443:0x0828, B:448:0x084b), top: B:488:0x0010, inners: #4, #8, #17 }] */
    /* JADX WARN: Code duplicated, block: B:302:0x05f1  */
    /* JADX WARN: Code duplicated, block: B:306:0x0603 A[LOOP:1: B:127:0x02bf->B:306:0x0603, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:332:0x0694  */
    /* JADX WARN: Code duplicated, block: B:390:0x074f  */
    /* JADX WARN: Code duplicated, block: B:392:0x0753  */
    /* JADX WARN: Code duplicated, block: B:393:0x075b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:394:0x075d  */
    /* JADX WARN: Code duplicated, block: B:398:0x0766  */
    /* JADX WARN: Code duplicated, block: B:402:0x0770  */
    /* JADX WARN: Code duplicated, block: B:403:0x0774  */
    /* JADX WARN: Code duplicated, block: B:408:0x078c A[Catch: IOException -> 0x00a3, XmlPullParserException -> 0x00a7, zzakp -> 0x0790, TRY_LEAVE, TryCatch #0 {zzakp -> 0x0790, blocks: (B:406:0x0787, B:408:0x078c), top: B:456:0x0787 }] */
    /* JADX WARN: Code duplicated, block: B:508:0x05f9 A[SYNTHETIC] */
    public final zzako zzb(byte[] bArr, int i, int i2) {
        String str;
        HashMap map;
        String str2;
        String str3;
        XmlPullParser xmlPullParser;
        HashMap map2;
        ArrayDeque arrayDeque;
        int i3;
        HashMap map3;
        int i4;
        zzals zzalsVar;
        zzalr zzalrVar;
        zzakp zzakpVar;
        zzalq zzalqVar;
        long j;
        zzalq zzalqVar2;
        long j2;
        long j3;
        zzalq zzalqVarZzb;
        long j4;
        byte b;
        float f;
        float f2;
        String str4;
        float f3;
        float f4;
        float f5;
        int i5;
        int i6;
        zzalu zzaluVar;
        byte b2;
        byte b3;
        String strZza;
        zzalw zzalwVar;
        String strZza2;
        zzalw zzalwVar2;
        HashMap map4;
        String str5;
        float f6;
        boolean z;
        String str6 = "Ignoring region with malformed extent: ";
        String str7 = "Ignoring region with missing tts:extent: ";
        String str8 = "Ignoring region with malformed origin: ";
        String str9 = "id";
        String str10 = "image";
        String str11 = "http://www.w3.org/ns/ttml#parameter";
        try {
            XmlPullParser xmlPullParserNewPullParser = this.zzi.newPullParser();
            HashMap map5 = new HashMap();
            HashMap map6 = new HashMap();
            HashMap map7 = new HashMap();
            map6.put("", new zzalu("", -3.4028235E38f, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, Integer.MIN_VALUE, -3.4028235E38f, Integer.MIN_VALUE));
            xmlPullParserNewPullParser.setInput(new ByteArrayInputStream(bArr, i, i2), null);
            ArrayDeque arrayDeque2 = new ArrayDeque();
            int eventType = xmlPullParserNewPullParser.getEventType();
            zzalr zzalrVar2 = zzh;
            zzalx zzalxVar = null;
            zzals zzalsVar2 = null;
            zzalr zzalrVar3 = zzalrVar2;
            int i7 = 15;
            int i8 = 0;
            int i9 = 1;
            while (eventType != i9) {
                zzalq zzalqVar3 = (zzalq) arrayDeque2.peek();
                if (i8 == 0) {
                    String name = xmlPullParserNewPullParser.getName();
                    ArrayDeque arrayDeque3 = arrayDeque2;
                    if (eventType == 2) {
                        String str12 = "extent";
                        map = map6;
                        if ("tt".equals(name)) {
                            String attributeValue = xmlPullParserNewPullParser.getAttributeValue(str11, "frameRate");
                            int i10 = attributeValue != null ? Integer.parseInt(attributeValue) : 30;
                            str2 = str6;
                            String attributeValue2 = xmlPullParserNewPullParser.getAttributeValue(str11, "frameRateMultiplier");
                            str3 = str7;
                            String str13 = dLDI.GzaIK;
                            if (attributeValue2 != null) {
                                String str14 = zzex.zza;
                                String[] strArrSplit = attributeValue2.split(str13, -1);
                                zzdd.zze(strArrSplit.length == 2, "frameRateMultiplier doesn't have 2 parts");
                                f6 = Integer.parseInt(strArrSplit[0]) / Integer.parseInt(strArrSplit[1]);
                            } else {
                                f6 = 1.0f;
                            }
                            int i11 = zzalrVar2.zzb;
                            String attributeValue3 = xmlPullParserNewPullParser.getAttributeValue(str11, "subFrameRate");
                            if (attributeValue3 != null) {
                                i11 = Integer.parseInt(attributeValue3);
                            }
                            int i12 = zzalrVar2.zzc;
                            String attributeValue4 = xmlPullParserNewPullParser.getAttributeValue(str11, "tickRate");
                            zzalr zzalrVar4 = new zzalr(i10 * f6, i11, attributeValue4 != null ? Integer.parseInt(attributeValue4) : i12);
                            String attributeValue5 = xmlPullParserNewPullParser.getAttributeValue(str11, "cellResolution");
                            if (attributeValue5 == null) {
                                str9 = str9;
                                zzalrVar3 = zzalrVar4;
                                str11 = str11;
                                i7 = 15;
                            } else {
                                Matcher matcher = zzg.matcher(attributeValue5);
                                if (matcher.matches()) {
                                    try {
                                        String strGroup = matcher.group(1);
                                        if (strGroup == null) {
                                            throw null;
                                        }
                                        int i13 = Integer.parseInt(strGroup);
                                        zzalrVar3 = zzalrVar4;
                                        try {
                                            String strGroup2 = matcher.group(2);
                                            if (strGroup2 == null) {
                                                throw null;
                                            }
                                            int i14 = Integer.parseInt(strGroup2);
                                            if (i13 == 0) {
                                                z = false;
                                            } else if (i14 != 0) {
                                                z = true;
                                            } else {
                                                i14 = 0;
                                                z = false;
                                            }
                                            try {
                                                StringBuilder sb = new StringBuilder();
                                                str9 = str9;
                                                try {
                                                    sb.append("Invalid cell resolution ");
                                                    sb.append(i13);
                                                    sb.append(str13);
                                                    sb.append(i14);
                                                    zzdd.zze(z, sb.toString());
                                                    i7 = i14;
                                                } catch (NumberFormatException unused) {
                                                    zzea.zzf("TtmlParser", "Ignoring malformed cell resolution: ".concat(attributeValue5));
                                                    i7 = 15;
                                                }
                                            } catch (NumberFormatException unused2) {
                                                str9 = str9;
                                            }
                                        } catch (NumberFormatException unused3) {
                                            str11 = str11;
                                        }
                                    } catch (NumberFormatException unused4) {
                                        zzalrVar3 = zzalrVar4;
                                    }
                                    str11 = str11;
                                    zzea.zzf("TtmlParser", "Ignoring malformed cell resolution: ".concat(attributeValue5));
                                    i7 = 15;
                                } else {
                                    zzea.zzf("TtmlParser", "Ignoring malformed cell resolution: ".concat(attributeValue5));
                                    str9 = str9;
                                    zzalrVar3 = zzalrVar4;
                                    str11 = str11;
                                    i7 = 15;
                                }
                            }
                            String strZza3 = zzey.zza(xmlPullParserNewPullParser, "extent");
                            if (strZza3 == null) {
                                zzalsVar2 = null;
                            } else {
                                Matcher matcher2 = zzf.matcher(strZza3);
                                if (matcher2.matches()) {
                                    try {
                                        String strGroup3 = matcher2.group(1);
                                        if (strGroup3 == null) {
                                            throw null;
                                        }
                                        int i15 = Integer.parseInt(strGroup3);
                                        String strGroup4 = matcher2.group(2);
                                        if (strGroup4 == null) {
                                            throw null;
                                        }
                                        zzalsVar2 = new zzals(i15, Integer.parseInt(strGroup4));
                                    } catch (NumberFormatException unused5) {
                                        zzea.zzf("TtmlParser", xPQrbOSWiEdU.efbimJVyCobBIn.concat(strZza3));
                                        zzalsVar2 = null;
                                    }
                                } else {
                                    zzea.zzf("TtmlParser", iafHZUfOuHNwvy.NLJRuDJOXSPQMA.concat(strZza3));
                                }
                                zzalsVar2 = null;
                            }
                        } else {
                            str2 = str6;
                            map7 = map7;
                            str3 = str7;
                            str8 = str8;
                            str9 = str9;
                            zzalrVar2 = zzalrVar2;
                            str11 = str11;
                        }
                        zzalr zzalrVar5 = zzalrVar3;
                        int i16 = i7;
                        zzals zzalsVar3 = zzalsVar2;
                        String str15 = "metadata";
                        if (name.equals("tt") || name.equals("head") || name.equals("body") || name.equals("div") || name.equals("p") || name.equals("span") || name.equals(JuorMn.jRanfeOUPy) || name.equals("style") || name.equals("styling") || name.equals("layout") || name.equals("region") || name.equals("metadata") || name.equals(str10) || name.equals("data") || name.equals("information")) {
                            if ("head".equals(name)) {
                                while (true) {
                                    xmlPullParserNewPullParser.next();
                                    if (zzey.zzc(xmlPullParserNewPullParser, "style")) {
                                        String strZza4 = zzey.zza(xmlPullParserNewPullParser, "style");
                                        zzalw zzalwVarZzf = zzf(xmlPullParserNewPullParser, new zzalw());
                                        if (strZza4 != null) {
                                            String[] strArrZzg = zzg(strZza4);
                                            int i17 = 0;
                                            for (int length = strArrZzg.length; i17 < length; length = length) {
                                                zzalwVarZzf.zzl((zzalw) map5.get(strArrZzg[i17]));
                                                i17++;
                                            }
                                        }
                                        String strZzH = zzalwVarZzf.zzH();
                                        if (strZzH != null) {
                                            map5.put(strZzH, zzalwVarZzf);
                                        }
                                    } else {
                                        zzalrVar5 = zzalrVar5;
                                        if (zzey.zzc(xmlPullParserNewPullParser, "region")) {
                                            map3 = map7;
                                            String str16 = str9;
                                            String strZza5 = zzey.zza(xmlPullParserNewPullParser, str16);
                                            if (strZza5 == null) {
                                                str = str16;
                                                str15 = str15;
                                                str8 = str8;
                                                zzaluVar = null;
                                            } else {
                                                String strZza6 = zzey.zza(xmlPullParserNewPullParser, FirebaseAnalytics.Param.ORIGIN);
                                                if (strZza6 == null && (strZza2 = zzey.zza(xmlPullParserNewPullParser, "style")) != null && (zzalwVar2 = (zzalw) map5.get(strZza2)) != null) {
                                                    strZza6 = zzalwVar2.zzI();
                                                }
                                                if (strZza6 != null) {
                                                    Matcher matcher3 = zzb.matcher(strZza6);
                                                    str = str16;
                                                    Matcher matcher4 = zzf.matcher(strZza6);
                                                    if (matcher3.matches()) {
                                                        str15 = str15;
                                                        try {
                                                            String strGroup5 = matcher3.group(1);
                                                            if (strGroup5 == null) {
                                                                throw null;
                                                            }
                                                            float f7 = Float.parseFloat(strGroup5) / 100.0f;
                                                            String strGroup6 = matcher3.group(2);
                                                            if (strGroup6 == null) {
                                                                throw null;
                                                            }
                                                            f2 = f7;
                                                            f = Float.parseFloat(strGroup6) / 100.0f;
                                                            str3 = str3;
                                                            str8 = str8;
                                                            str10 = str10;
                                                            map3 = map3;
                                                        } catch (NumberFormatException unused6) {
                                                            String str17 = str8;
                                                            zzea.zzf("TtmlParser", str17.concat(strZza6));
                                                            str8 = str17;
                                                            zzaluVar = null;
                                                            str4 = str12;
                                                        }
                                                    } else {
                                                        str15 = str15;
                                                        str8 = str8;
                                                        if (!matcher4.matches()) {
                                                            map3 = map3;
                                                            str3 = str3;
                                                            str10 = str10;
                                                            zzea.zzf("TtmlParser", "Ignoring region with unsupported origin: ".concat(strZza6));
                                                        } else if (zzalsVar3 == null) {
                                                            str3 = str3;
                                                            zzea.zzf("TtmlParser", str3.concat(strZza6));
                                                            str10 = str10;
                                                            map3 = map3;
                                                            zzaluVar = null;
                                                            str4 = str12;
                                                            if (zzaluVar != null) {
                                                                map = map;
                                                                map.put(zzaluVar.zza, zzaluVar);
                                                            } else {
                                                                map = map;
                                                            }
                                                        } else {
                                                            str3 = str3;
                                                            str10 = str10;
                                                            try {
                                                                String strGroup7 = matcher4.group(1);
                                                                if (strGroup7 == null) {
                                                                    throw null;
                                                                }
                                                                int i18 = Integer.parseInt(strGroup7);
                                                                map3 = map3;
                                                                try {
                                                                    String strGroup8 = matcher4.group(2);
                                                                    if (strGroup8 == null) {
                                                                        throw null;
                                                                    }
                                                                    int i19 = Integer.parseInt(strGroup8);
                                                                    float f8 = i18 / zzalsVar3.zza;
                                                                    f = i19 / zzalsVar3.zzb;
                                                                    f2 = f8;
                                                                } catch (NumberFormatException unused7) {
                                                                    zzea.zzf("TtmlParser", str8.concat(strZza6));
                                                                    zzaluVar = null;
                                                                    str4 = str12;
                                                                }
                                                            } catch (NumberFormatException unused8) {
                                                                map3 = map3;
                                                            }
                                                            zzea.zzf("TtmlParser", str8.concat(strZza6));
                                                        }
                                                        zzaluVar = null;
                                                        str4 = str12;
                                                        if (zzaluVar != null) {
                                                            map = map;
                                                            map.put(zzaluVar.zza, zzaluVar);
                                                        } else {
                                                            map = map;
                                                        }
                                                    }
                                                } else {
                                                    str = str16;
                                                    str15 = str15;
                                                    str3 = str3;
                                                    str8 = str8;
                                                    str10 = str10;
                                                    map3 = map3;
                                                    f = 0.0f;
                                                    f2 = 0.0f;
                                                }
                                                String strZza7 = zzey.zza(xmlPullParserNewPullParser, str12);
                                                if (strZza7 == null && (strZza = zzey.zza(xmlPullParserNewPullParser, "style")) != null && (zzalwVar = (zzalw) map5.get(strZza)) != null) {
                                                    strZza7 = zzalwVar.zzF();
                                                }
                                                if (strZza7 != null) {
                                                    Matcher matcher5 = zzb.matcher(strZza7);
                                                    str8 = str8;
                                                    Matcher matcher6 = zzf.matcher(strZza7);
                                                    if (matcher5.matches()) {
                                                        try {
                                                            String strGroup9 = matcher5.group(1);
                                                            if (strGroup9 == null) {
                                                                throw null;
                                                            }
                                                            float f9 = Float.parseFloat(strGroup9) / 100.0f;
                                                            String strGroup10 = matcher5.group(2);
                                                            if (strGroup10 == null) {
                                                                throw null;
                                                            }
                                                            f4 = Float.parseFloat(strGroup10) / 100.0f;
                                                            f3 = f9;
                                                            str2 = str2;
                                                            str4 = str12;
                                                        } catch (NumberFormatException unused9) {
                                                            str2 = str2;
                                                            zzea.zzf("TtmlParser", str2.concat(String.valueOf(strZza6)));
                                                            str4 = str12;
                                                            zzaluVar = null;
                                                        }
                                                    } else {
                                                        str2 = str2;
                                                        if (!matcher6.matches()) {
                                                            str4 = str12;
                                                            zzea.zzf("TtmlParser", "Ignoring region with unsupported extent: ".concat(String.valueOf(strZza6)));
                                                        } else if (zzalsVar3 == null) {
                                                            zzea.zzf("TtmlParser", str3.concat(String.valueOf(strZza6)));
                                                            str4 = str12;
                                                        } else {
                                                            try {
                                                                String strGroup11 = matcher6.group(1);
                                                                if (strGroup11 == null) {
                                                                    throw null;
                                                                }
                                                                int i20 = Integer.parseInt(strGroup11);
                                                                str4 = str12;
                                                                try {
                                                                    String strGroup12 = matcher6.group(2);
                                                                    if (strGroup12 == null) {
                                                                        throw null;
                                                                    }
                                                                    int i21 = Integer.parseInt(strGroup12);
                                                                    float f10 = i20 / zzalsVar3.zza;
                                                                    f4 = i21 / zzalsVar3.zzb;
                                                                    f3 = f10;
                                                                } catch (NumberFormatException unused10) {
                                                                    zzea.zzf("TtmlParser", str2.concat(String.valueOf(strZza6)));
                                                                    zzaluVar = null;
                                                                }
                                                            } catch (NumberFormatException unused11) {
                                                                str4 = str12;
                                                            }
                                                            zzea.zzf("TtmlParser", str2.concat(String.valueOf(strZza6)));
                                                        }
                                                        zzaluVar = null;
                                                        if (zzaluVar != null) {
                                                            map = map;
                                                            map.put(zzaluVar.zza, zzaluVar);
                                                        } else {
                                                            map = map;
                                                        }
                                                    }
                                                } else {
                                                    str8 = str8;
                                                    str2 = str2;
                                                    str4 = str12;
                                                    f3 = 1.0f;
                                                    f4 = 1.0f;
                                                }
                                                String strZza8 = zzey.zza(xmlPullParserNewPullParser, "displayAlign");
                                                if (strZza8 != null) {
                                                    String strZza9 = zzfuv.zza(strZza8);
                                                    int iHashCode = strZza9.hashCode();
                                                    if (iHashCode != -1364013995) {
                                                        if (iHashCode == 92734940 && strZza9.equals("after")) {
                                                            b3 = 1;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                    } else if (strZza9.equals("center")) {
                                                        b3 = 0;
                                                    } else {
                                                        b3 = -1;
                                                    }
                                                    if (b3 == 0) {
                                                        f5 = (f4 / 2.0f) + f;
                                                        i5 = 1;
                                                    } else if (b3 != 1) {
                                                        f5 = f;
                                                        i5 = 0;
                                                    } else {
                                                        f5 = f + f4;
                                                        i5 = 2;
                                                    }
                                                } else {
                                                    f5 = f;
                                                    i5 = 0;
                                                }
                                                float f11 = 1.0f / i16;
                                                String strZza10 = zzey.zza(xmlPullParserNewPullParser, "writingMode");
                                                if (strZza10 != null) {
                                                    String strZza11 = zzfuv.zza(strZza10);
                                                    int iHashCode2 = strZza11.hashCode();
                                                    if (iHashCode2 != 3694) {
                                                        if (iHashCode2 != 3553396) {
                                                            if (iHashCode2 == 3553576 && strZza11.equals(MnHfHMYQDPUO.qNVrhxe)) {
                                                                b2 = 2;
                                                            } else {
                                                                b2 = -1;
                                                            }
                                                        } else if (strZza11.equals("tblr")) {
                                                            b2 = 1;
                                                        } else {
                                                            b2 = -1;
                                                        }
                                                    } else if (strZza11.equals("tb")) {
                                                        b2 = 0;
                                                    } else {
                                                        b2 = -1;
                                                    }
                                                    if (b2 == 0 || b2 == 1) {
                                                        i6 = 2;
                                                    } else if (b2 != 2) {
                                                        i6 = Integer.MIN_VALUE;
                                                    } else {
                                                        i6 = 1;
                                                    }
                                                } else {
                                                    i6 = Integer.MIN_VALUE;
                                                }
                                                zzaluVar = new zzalu(strZza5, f2, f5, 0, i5, f3, f4, 1, f11, i6);
                                                if (zzaluVar != null) {
                                                    map = map;
                                                    map.put(zzaluVar.zza, zzaluVar);
                                                } else {
                                                    map = map;
                                                }
                                            }
                                            str4 = str12;
                                            if (zzaluVar != null) {
                                                map = map;
                                                map.put(zzaluVar.zza, zzaluVar);
                                            } else {
                                                map = map;
                                            }
                                        } else {
                                            if (zzey.zzc(xmlPullParserNewPullParser, str15)) {
                                                while (true) {
                                                    xmlPullParserNewPullParser.next();
                                                    if (zzey.zzc(xmlPullParserNewPullParser, str10)) {
                                                        str5 = str9;
                                                        String strZza12 = zzey.zza(xmlPullParserNewPullParser, str5);
                                                        if (strZza12 != null) {
                                                            map4 = map7;
                                                            map4.put(strZza12, xmlPullParserNewPullParser.nextText());
                                                        } else {
                                                            map4 = map7;
                                                        }
                                                    } else {
                                                        map4 = map7;
                                                        str5 = str9;
                                                    }
                                                    if (zzey.zzb(xmlPullParserNewPullParser, str15)) {
                                                        str = str5;
                                                        map3 = map4;
                                                    } else {
                                                        str9 = str5;
                                                        map7 = map4;
                                                    }
                                                }
                                            }
                                            str2 = str2;
                                            str4 = str12;
                                        }
                                        if (zzey.zzb(xmlPullParserNewPullParser, "head")) {
                                            i4 = i16;
                                            zzalsVar = zzalsVar3;
                                            xmlPullParser = xmlPullParserNewPullParser;
                                            zzalrVar = zzalrVar5;
                                            arrayDeque = arrayDeque3;
                                        } else {
                                            map = map;
                                            zzalrVar5 = zzalrVar5;
                                            str15 = str15;
                                            str12 = str4;
                                            str9 = str;
                                            str2 = str2;
                                            str10 = str10;
                                            map7 = map3;
                                            str8 = str8;
                                            str3 = str3;
                                        }
                                    }
                                    map3 = map7;
                                    str = str9;
                                    str2 = str2;
                                    str4 = str12;
                                    if (zzey.zzb(xmlPullParserNewPullParser, "head")) {
                                        i4 = i16;
                                        zzalsVar = zzalsVar3;
                                        xmlPullParser = xmlPullParserNewPullParser;
                                        zzalrVar = zzalrVar5;
                                        arrayDeque = arrayDeque3;
                                    } else {
                                        map = map;
                                        zzalrVar5 = zzalrVar5;
                                        str15 = str15;
                                        str12 = str4;
                                        str9 = str;
                                        str2 = str2;
                                        str10 = str10;
                                        map7 = map3;
                                        str8 = str8;
                                        str3 = str3;
                                    }
                                }
                            } else {
                                zzalr zzalrVar6 = zzalrVar5;
                                map = map;
                                str3 = str3;
                                str8 = str8;
                                map3 = map7;
                                str = str9;
                                str10 = str10;
                                str2 = str2;
                                try {
                                    int attributeCount = xmlPullParserNewPullParser.getAttributeCount();
                                    zzalw zzalwVarZzf2 = zzf(xmlPullParserNewPullParser, null);
                                    String str18 = "";
                                    int i22 = 0;
                                    long jZzc = -9223372036854775807L;
                                    long jZzc2 = -9223372036854775807L;
                                    long jZzc3 = -9223372036854775807L;
                                    String[] strArr = null;
                                    String strSubstring = null;
                                    while (i22 < attributeCount) {
                                        try {
                                            String attributeName = xmlPullParserNewPullParser.getAttributeName(i22);
                                            String attributeValue6 = xmlPullParserNewPullParser.getAttributeValue(i22);
                                            switch (attributeName) {
                                                case "region":
                                                    b = 4;
                                                    break;
                                                case "dur":
                                                    b = 2;
                                                    break;
                                                case "end":
                                                    b = 1;
                                                    break;
                                                case "begin":
                                                    b = 0;
                                                    break;
                                                case "style":
                                                    b = 3;
                                                    break;
                                                case "backgroundImage":
                                                    b = 5;
                                                    break;
                                                default:
                                                    b = -1;
                                                    break;
                                            }
                                            if (b == 0) {
                                                zzalrVar = zzalrVar6;
                                                jZzc2 = zzc(attributeValue6, zzalrVar);
                                            } else if (b == 1) {
                                                zzalrVar = zzalrVar6;
                                                jZzc = zzc(attributeValue6, zzalrVar);
                                            } else if (b != 2) {
                                                if (b == 3) {
                                                    String[] strArrZzg2 = zzg(attributeValue6);
                                                    if (strArrZzg2.length > 0) {
                                                        strArr = strArrZzg2;
                                                    }
                                                } else if (b != 4) {
                                                    if (b == 5) {
                                                        try {
                                                            if (attributeValue6.startsWith("#")) {
                                                                strSubstring = attributeValue6.substring(1);
                                                            }
                                                        } catch (zzakp e) {
                                                            zzakpVar = e;
                                                            i4 = i16;
                                                            zzalsVar = zzalsVar3;
                                                            xmlPullParser = xmlPullParserNewPullParser;
                                                            zzalrVar = zzalrVar6;
                                                            arrayDeque = arrayDeque3;
                                                            zzea.zzg("TtmlParser", "Suppressing parser error", zzakpVar);
                                                            zzalsVar2 = zzalsVar;
                                                            i7 = i4;
                                                            zzalrVar3 = zzalrVar;
                                                            map2 = map3;
                                                            i3 = 1;
                                                            i8 = 1;
                                                            xmlPullParser.next();
                                                            eventType = xmlPullParser.getEventType();
                                                            i9 = i3;
                                                            xmlPullParserNewPullParser = xmlPullParser;
                                                            arrayDeque2 = arrayDeque;
                                                            map7 = map2;
                                                            map6 = map;
                                                            str6 = str2;
                                                            str7 = str3;
                                                            str10 = str10;
                                                            str9 = str;
                                                            zzalrVar2 = zzalrVar2;
                                                            str11 = str11;
                                                            str8 = str8;
                                                        }
                                                    }
                                                } else if (map.containsKey(attributeValue6)) {
                                                    str18 = attributeValue6;
                                                }
                                                zzalrVar = zzalrVar6;
                                            } else {
                                                zzalrVar = zzalrVar6;
                                                try {
                                                    jZzc3 = zzc(attributeValue6, zzalrVar);
                                                } catch (zzakp e2) {
                                                    e = e2;
                                                    zzakpVar = e;
                                                    i4 = i16;
                                                    zzalsVar = zzalsVar3;
                                                    xmlPullParser = xmlPullParserNewPullParser;
                                                    arrayDeque = arrayDeque3;
                                                    zzea.zzg("TtmlParser", "Suppressing parser error", zzakpVar);
                                                    zzalsVar2 = zzalsVar;
                                                    i7 = i4;
                                                    zzalrVar3 = zzalrVar;
                                                    map2 = map3;
                                                    i3 = 1;
                                                    i8 = 1;
                                                    xmlPullParser.next();
                                                    eventType = xmlPullParser.getEventType();
                                                    i9 = i3;
                                                    xmlPullParserNewPullParser = xmlPullParser;
                                                    arrayDeque2 = arrayDeque;
                                                    map7 = map2;
                                                    map6 = map;
                                                    str6 = str2;
                                                    str7 = str3;
                                                    str10 = str10;
                                                    str9 = str;
                                                    zzalrVar2 = zzalrVar2;
                                                    str11 = str11;
                                                    str8 = str8;
                                                }
                                            }
                                            i22++;
                                            zzalrVar6 = zzalrVar;
                                        } catch (zzakp e3) {
                                            e = e3;
                                            zzalrVar = zzalrVar6;
                                        }
                                    }
                                    zzalrVar = zzalrVar6;
                                    try {
                                        try {
                                            if (zzalqVar3 != null) {
                                                xmlPullParser = xmlPullParserNewPullParser;
                                                zzalqVar = zzalqVar3;
                                                try {
                                                    long j5 = zzalqVar.zzd;
                                                    if (j5 != -9223372036854775807L) {
                                                        j = jZzc2 != -9223372036854775807L ? jZzc2 + j5 : -9223372036854775807L;
                                                        if (jZzc != -9223372036854775807L) {
                                                            jZzc += j5;
                                                            zzalqVar2 = zzalqVar;
                                                        } else {
                                                            zzalqVar2 = zzalqVar;
                                                            j2 = -9223372036854775807L;
                                                            jZzc = -9223372036854775807L;
                                                        }
                                                        if (jZzc == j2) {
                                                            i4 = i16;
                                                            zzalsVar = zzalsVar3;
                                                            j3 = jZzc;
                                                        } else if (jZzc3 != j2) {
                                                            i4 = i16;
                                                            zzalsVar = zzalsVar3;
                                                            j3 = j + jZzc3;
                                                        } else {
                                                            if (zzalqVar2 != null) {
                                                                i4 = i16;
                                                                zzalsVar = zzalsVar3;
                                                                try {
                                                                    j4 = zzalqVar2.zze;
                                                                    if (j4 != j2) {
                                                                        j3 = j4;
                                                                    }
                                                                } catch (zzakp e4) {
                                                                    zzakpVar = e4;
                                                                    arrayDeque = arrayDeque3;
                                                                    zzea.zzg("TtmlParser", "Suppressing parser error", zzakpVar);
                                                                    zzalsVar2 = zzalsVar;
                                                                    i7 = i4;
                                                                    zzalrVar3 = zzalrVar;
                                                                    map2 = map3;
                                                                    i3 = 1;
                                                                    i8 = 1;
                                                                }
                                                            } else {
                                                                i4 = i16;
                                                                zzalsVar = zzalsVar3;
                                                            }
                                                            j3 = j2;
                                                        }
                                                        zzalqVarZzb = zzalq.zzb(xmlPullParser.getName(), j, j3, zzalwVarZzf2, strArr, str18, strSubstring, zzalqVar2);
                                                        arrayDeque = arrayDeque3;
                                                        arrayDeque.push(zzalqVarZzb);
                                                        if (zzalqVar != null) {
                                                            zzalqVar.zzf(zzalqVarZzb);
                                                        }
                                                    } else {
                                                        zzalqVar2 = zzalqVar;
                                                        j = jZzc2;
                                                    }
                                                } catch (zzakp e5) {
                                                    zzakpVar = e5;
                                                    i4 = i16;
                                                    zzalsVar = zzalsVar3;
                                                    arrayDeque = arrayDeque3;
                                                    zzea.zzg("TtmlParser", "Suppressing parser error", zzakpVar);
                                                    zzalsVar2 = zzalsVar;
                                                    i7 = i4;
                                                    zzalrVar3 = zzalrVar;
                                                    map2 = map3;
                                                    i3 = 1;
                                                    i8 = 1;
                                                    xmlPullParser.next();
                                                    eventType = xmlPullParser.getEventType();
                                                    i9 = i3;
                                                    xmlPullParserNewPullParser = xmlPullParser;
                                                    arrayDeque2 = arrayDeque;
                                                    map7 = map2;
                                                    map6 = map;
                                                    str6 = str2;
                                                    str7 = str3;
                                                    str10 = str10;
                                                    str9 = str;
                                                    zzalrVar2 = zzalrVar2;
                                                    str11 = str11;
                                                    str8 = str8;
                                                }
                                            } else {
                                                xmlPullParser = xmlPullParserNewPullParser;
                                                zzalqVar = zzalqVar3;
                                                j = jZzc2;
                                                zzalqVar2 = null;
                                            }
                                            arrayDeque.push(zzalqVarZzb);
                                            if (zzalqVar != null) {
                                                zzalqVar.zzf(zzalqVarZzb);
                                            }
                                        } catch (zzakp e6) {
                                            e = e6;
                                            zzakpVar = e;
                                            zzea.zzg("TtmlParser", "Suppressing parser error", zzakpVar);
                                            zzalsVar2 = zzalsVar;
                                            i7 = i4;
                                            zzalrVar3 = zzalrVar;
                                            map2 = map3;
                                            i3 = 1;
                                            i8 = 1;
                                        }
                                        zzalqVarZzb = zzalq.zzb(xmlPullParser.getName(), j, j3, zzalwVarZzf2, strArr, str18, strSubstring, zzalqVar2);
                                        arrayDeque = arrayDeque3;
                                    } catch (zzakp e7) {
                                        e = e7;
                                        arrayDeque = arrayDeque3;
                                        zzakpVar = e;
                                        zzea.zzg("TtmlParser", "Suppressing parser error", zzakpVar);
                                        zzalsVar2 = zzalsVar;
                                        i7 = i4;
                                        zzalrVar3 = zzalrVar;
                                        map2 = map3;
                                        i3 = 1;
                                        i8 = 1;
                                        xmlPullParser.next();
                                        eventType = xmlPullParser.getEventType();
                                        i9 = i3;
                                        xmlPullParserNewPullParser = xmlPullParser;
                                        arrayDeque2 = arrayDeque;
                                        map7 = map2;
                                        map6 = map;
                                        str6 = str2;
                                        str7 = str3;
                                        str10 = str10;
                                        str9 = str;
                                        zzalrVar2 = zzalrVar2;
                                        str11 = str11;
                                        str8 = str8;
                                    }
                                    j2 = -9223372036854775807L;
                                    if (jZzc == j2) {
                                        i4 = i16;
                                        zzalsVar = zzalsVar3;
                                        j3 = jZzc;
                                    } else if (jZzc3 != j2) {
                                        i4 = i16;
                                        zzalsVar = zzalsVar3;
                                        j3 = j + jZzc3;
                                    } else {
                                        if (zzalqVar2 != null) {
                                            i4 = i16;
                                            zzalsVar = zzalsVar3;
                                            j4 = zzalqVar2.zze;
                                            if (j4 != j2) {
                                                j3 = j4;
                                            }
                                        } else {
                                            i4 = i16;
                                            zzalsVar = zzalsVar3;
                                        }
                                        j3 = j2;
                                    }
                                } catch (zzakp e8) {
                                    e = e8;
                                    i4 = i16;
                                    zzalsVar = zzalsVar3;
                                    xmlPullParser = xmlPullParserNewPullParser;
                                    zzalrVar = zzalrVar6;
                                }
                            }
                            zzalsVar2 = zzalsVar;
                            i7 = i4;
                            zzalrVar3 = zzalrVar;
                        } else {
                            zzea.zze("TtmlParser", "Ignoring unsupported tag: " + xmlPullParserNewPullParser.getName());
                            zzalrVar3 = zzalrVar5;
                            i7 = i16;
                            zzalsVar2 = zzalsVar3;
                            xmlPullParser = xmlPullParserNewPullParser;
                            arrayDeque = arrayDeque3;
                            map = map;
                            str3 = str3;
                            str8 = str8;
                            map2 = map7;
                            str = str9;
                            i3 = 1;
                            i8 = 1;
                            str10 = str10;
                            str2 = str2;
                        }
                    } else {
                        map3 = map7;
                        str8 = str8;
                        str = str9;
                        str10 = str10;
                        zzalrVar2 = zzalrVar2;
                        str11 = str11;
                        arrayDeque = arrayDeque3;
                        map = map6;
                        str2 = str6;
                        str3 = str7;
                        xmlPullParser = xmlPullParserNewPullParser;
                        if (eventType != 4) {
                            if (eventType == 3) {
                                if (xmlPullParser.getName().equals("tt")) {
                                    zzalq zzalqVar4 = (zzalq) arrayDeque.peek();
                                    if (zzalqVar4 == null) {
                                        throw null;
                                    }
                                    map2 = map3;
                                    zzalxVar = new zzalx(zzalqVar4, map5, map, map2);
                                } else {
                                    map2 = map3;
                                }
                                arrayDeque.pop();
                            }
                            i3 = 1;
                        } else {
                            if (zzalqVar3 == null) {
                                throw null;
                            }
                            zzalqVar3.zzf(zzalq.zzc(xmlPullParser.getText()));
                        }
                    }
                    map2 = map3;
                    i3 = 1;
                } else {
                    str8 = str8;
                    str = str9;
                    str10 = str10;
                    zzalrVar2 = zzalrVar2;
                    str11 = str11;
                    map = map6;
                    str2 = str6;
                    str3 = str7;
                    xmlPullParser = xmlPullParserNewPullParser;
                    map2 = map7;
                    arrayDeque = arrayDeque2;
                    if (eventType == 2) {
                        i3 = 1;
                        i8++;
                    } else {
                        i3 = 1;
                        if (eventType == 3) {
                            i8--;
                        }
                    }
                }
                xmlPullParser.next();
                eventType = xmlPullParser.getEventType();
                i9 = i3;
                xmlPullParserNewPullParser = xmlPullParser;
                arrayDeque2 = arrayDeque;
                map7 = map2;
                map6 = map;
                str6 = str2;
                str7 = str3;
                str10 = str10;
                str9 = str;
                zzalrVar2 = zzalrVar2;
                str11 = str11;
                str8 = str8;
            }
            if (zzalxVar != null) {
                return zzalxVar;
            }
            throw null;
        } catch (IOException e9) {
            throw new IllegalStateException("Unexpected error when reading input.", e9);
        } catch (XmlPullParserException e10) {
            throw new IllegalStateException("Unable to decode source", e10);
        }
    }
}
