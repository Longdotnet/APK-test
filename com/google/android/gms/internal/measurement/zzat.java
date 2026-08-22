package com.google.android.gms.internal.measurement;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class zzat implements Iterable, zzap {
    private final String zza;

    public zzat(String str) {
        if (str == null) {
            throw new IllegalArgumentException("StringValue cannot be null.");
        }
        this.zza = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzat) {
            return this.zza.equals(((zzat) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new zzas(this);
    }

    public final String toString() {
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("\"", this.zza, "\"");
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0176  */
    /* JADX WARN: Code duplicated, block: B:103:0x017e  */
    /* JADX WARN: Code duplicated, block: B:105:0x0195  */
    /* JADX WARN: Code duplicated, block: B:106:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:107:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:108:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:109:0x01df  */
    /* JADX WARN: Code duplicated, block: B:110:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:112:0x0204  */
    /* JADX WARN: Code duplicated, block: B:113:0x021e  */
    /* JADX WARN: Code duplicated, block: B:116:0x0228  */
    /* JADX WARN: Code duplicated, block: B:118:0x0241  */
    /* JADX WARN: Code duplicated, block: B:120:0x0271  */
    /* JADX WARN: Code duplicated, block: B:122:0x0283  */
    /* JADX WARN: Code duplicated, block: B:124:0x0296  */
    /* JADX WARN: Code duplicated, block: B:126:0x02a2  */
    /* JADX WARN: Code duplicated, block: B:127:0x02a7  */
    /* JADX WARN: Code duplicated, block: B:129:0x02bc  */
    /* JADX WARN: Code duplicated, block: B:130:0x02d3  */
    /* JADX WARN: Code duplicated, block: B:133:0x02dc  */
    /* JADX WARN: Code duplicated, block: B:134:0x02e2  */
    /* JADX WARN: Code duplicated, block: B:140:0x030a  */
    /* JADX WARN: Code duplicated, block: B:143:0x0312  */
    /* JADX WARN: Code duplicated, block: B:145:0x0315 A[LOOP:0: B:144:0x0313->B:145:0x0315, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:147:0x0329  */
    /* JADX WARN: Code duplicated, block: B:149:0x033b  */
    /* JADX WARN: Code duplicated, block: B:150:0x034f  */
    /* JADX WARN: Code duplicated, block: B:153:0x0358  */
    /* JADX WARN: Code duplicated, block: B:154:0x0363  */
    /* JADX WARN: Code duplicated, block: B:157:0x0374  */
    /* JADX WARN: Code duplicated, block: B:158:0x0387  */
    /* JADX WARN: Code duplicated, block: B:161:0x0394  */
    /* JADX WARN: Code duplicated, block: B:162:0x039f  */
    /* JADX WARN: Code duplicated, block: B:164:0x03bb  */
    /* JADX WARN: Code duplicated, block: B:166:0x03cc  */
    /* JADX WARN: Code duplicated, block: B:169:0x03ea  */
    /* JADX WARN: Code duplicated, block: B:170:0x03fa  */
    /* JADX WARN: Code duplicated, block: B:171:0x0407  */
    /* JADX WARN: Code duplicated, block: B:173:0x041b  */
    /* JADX WARN: Code duplicated, block: B:175:0x0431  */
    /* JADX WARN: Code duplicated, block: B:178:0x0445  */
    /* JADX WARN: Code duplicated, block: B:180:0x0449  */
    /* JADX WARN: Code duplicated, block: B:181:0x046f  */
    /* JADX WARN: Code duplicated, block: B:183:0x048c  */
    /* JADX WARN: Code duplicated, block: B:185:0x049f  */
    /* JADX WARN: Code duplicated, block: B:186:0x04a2  */
    /* JADX WARN: Code duplicated, block: B:189:0x04bf  */
    /* JADX WARN: Code duplicated, block: B:190:0x04d9  */
    /* JADX WARN: Code duplicated, block: B:191:0x04dd  */
    /* JADX WARN: Code duplicated, block: B:194:0x04f5  */
    /* JADX WARN: Code duplicated, block: B:197:0x050a  */
    /* JADX WARN: Code duplicated, block: B:198:0x050d  */
    /* JADX WARN: Code duplicated, block: B:201:0x0526  */
    /* JADX WARN: Code duplicated, block: B:202:0x0529  */
    /* JADX WARN: Code duplicated, block: B:204:0x0540  */
    /* JADX WARN: Code duplicated, block: B:207:0x0555  */
    /* JADX WARN: Code duplicated, block: B:211:0x056c  */
    /* JADX WARN: Code duplicated, block: B:213:0x0599  */
    /* JADX WARN: Code duplicated, block: B:215:0x05bc  */
    /* JADX WARN: Code duplicated, block: B:216:0x05c0  */
    /* JADX WARN: Code duplicated, block: B:223:0x05dd  */
    /* JADX WARN: Code duplicated, block: B:224:0x05e1  */
    /* JADX WARN: Code duplicated, block: B:226:0x05ed  */
    /* JADX WARN: Code duplicated, block: B:229:0x05fb A[LOOP:1: B:227:0x05f5->B:229:0x05fb, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:232:0x061c  */
    /* JADX WARN: Code duplicated, block: B:234:0x062c  */
    /* JADX WARN: Code duplicated, block: B:235:0x0645  */
    /* JADX WARN: Code duplicated, block: B:247:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:248:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:249:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:250:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:251:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:252:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:253:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:254:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:255:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:256:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:257:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:258:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:259:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:43:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:44:0x00ba A[PHI: r6
  0x00ba: PHI (r6v52 java.lang.String) = 
  (r6v5 java.lang.String)
  (r6v6 java.lang.String)
  (r6v7 java.lang.String)
  (r6v8 java.lang.String)
  (r6v10 java.lang.String)
  (r6v11 java.lang.String)
  (r6v12 java.lang.String)
  (r6v13 java.lang.String)
  (r6v14 java.lang.String)
  (r6v15 java.lang.String)
  (r6v16 java.lang.String)
  (r6v17 java.lang.String)
  (r6v18 java.lang.String)
  (r6v19 java.lang.String)
  (r6v22 java.lang.String)
  (r6v23 java.lang.String)
  (r6v53 java.lang.String)
 binds: [B:93:0x0158, B:90:0x014d, B:87:0x0141, B:259:?, B:258:?, B:257:?, B:256:?, B:255:?, B:254:?, B:253:?, B:252:?, B:251:?, B:250:?, B:249:?, B:248:?, B:247:?, B:43:0x00b8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:45:0x00be  */
    /* JADX WARN: Code duplicated, block: B:47:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:48:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:50:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:53:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:55:0x00de  */
    /* JADX WARN: Code duplicated, block: B:56:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:58:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:61:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:62:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:64:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:65:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:67:0x0101  */
    /* JADX WARN: Code duplicated, block: B:68:0x0104  */
    /* JADX WARN: Code duplicated, block: B:70:0x010a  */
    /* JADX WARN: Code duplicated, block: B:71:0x010d  */
    /* JADX WARN: Code duplicated, block: B:73:0x0113  */
    /* JADX WARN: Code duplicated, block: B:74:0x0115  */
    /* JADX WARN: Code duplicated, block: B:76:0x011b  */
    /* JADX WARN: Code duplicated, block: B:77:0x011e  */
    /* JADX WARN: Code duplicated, block: B:79:0x0124  */
    /* JADX WARN: Code duplicated, block: B:80:0x0126  */
    /* JADX WARN: Code duplicated, block: B:82:0x012c  */
    /* JADX WARN: Code duplicated, block: B:83:0x012f  */
    /* JADX WARN: Code duplicated, block: B:85:0x0135  */
    /* JADX WARN: Code duplicated, block: B:86:0x013b  */
    /* JADX WARN: Code duplicated, block: B:88:0x0143  */
    /* JADX WARN: Code duplicated, block: B:89:0x0147  */
    /* JADX WARN: Code duplicated, block: B:91:0x014f  */
    /* JADX WARN: Code duplicated, block: B:92:0x0152  */
    /* JADX WARN: Code duplicated, block: B:94:0x015a  */
    /* JADX WARN: Code duplicated, block: B:95:0x015e  */
    /* JADX WARN: Code duplicated, block: B:97:0x0168  */
    /* JADX WARN: Code duplicated, block: B:98:0x016a A[PHI: r6 r12
  0x016a: PHI (r6v51 java.lang.String) = (r6v4 java.lang.String), (r6v52 java.lang.String) binds: [B:96:0x0166, B:44:0x00ba] A[DONT_GENERATE, DONT_INLINE]
  0x016a: PHI (r12v7 java.lang.String) = (r12v1 java.lang.String), (r12v8 java.lang.String) binds: [B:96:0x0166, B:44:0x00ba] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzap
    public final zzap zzbR(String str, zzg zzgVar, List list) {
        String str2;
        String str3;
        String str4;
        String str5;
        byte b;
        String strZzi;
        int iZza;
        zzat zzatVar;
        StringBuilder sb;
        int i;
        zzap zzatVar2;
        zzap zzapVarZzb;
        double dDoubleValue;
        int i2;
        double dDoubleValue2;
        double dZza;
        String strZzi2;
        Matcher matcher;
        zzap zzaeVar;
        zzap zzapVarZza;
        String str6;
        String str7;
        int iIndexOf;
        int i3;
        Matcher matcher2;
        String str8;
        double dDoubleValue3;
        double dZza2;
        double dMin;
        double length;
        double dZza3;
        double dMin2;
        String str9;
        ArrayList arrayList;
        String strZzi3;
        long jZzd;
        String[] strArrSplit;
        int length2;
        int i4;
        int i5;
        int i6;
        boolean zIsEmpty;
        String str10;
        zzg zzgVar2;
        int iZza2;
        int length3;
        if (!"charAt".equals(str) && !"concat".equals(str) && !"hasOwnProperty".equals(str) && !"indexOf".equals(str) && !"lastIndexOf".equals(str) && !"match".equals(str) && !"replace".equals(str) && !FirebaseAnalytics.Event.SEARCH.equals(str) && !"slice".equals(str) && !"split".equals(str) && !"substring".equals(str) && !"toLowerCase".equals(str) && !"toLocaleLowerCase".equals(str) && !"toString".equals(str) && !"toUpperCase".equals(str)) {
            str2 = "toLocaleUpperCase";
            if (!str2.equals(str)) {
                str3 = "trim";
                if (!str3.equals(str)) {
                    throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(str, " is not a String function"));
                }
            }
            switch (str.hashCode()) {
                case -1789698943:
                    str4 = "charAt";
                    str5 = r6;
                    if (str.equals(str5)) {
                        b = 2;
                    } else {
                        b = -1;
                    }
                    break;
                case -1776922004:
                    str4 = "charAt";
                    if (str.equals("toString")) {
                        b = 14;
                        str5 = r6;
                    }
                    str5 = "hasOwnProperty";
                    b = -1;
                    break;
                case -1464939364:
                    str4 = "charAt";
                    if (str.equals("toLocaleLowerCase")) {
                        b = 12;
                        str5 = r6;
                    }
                    str5 = "hasOwnProperty";
                    b = -1;
                    break;
                case -1361633751:
                    str4 = "charAt";
                    if (str.equals(str4)) {
                        str5 = r6;
                        b = 0;
                    } else {
                        str5 = "hasOwnProperty";
                        b = -1;
                    }
                    break;
                case -1354795244:
                    if (str.equals("concat")) {
                        str4 = "charAt";
                        str5 = r6;
                        b = 1;
                    } else {
                        str4 = "charAt";
                        str5 = "hasOwnProperty";
                        b = -1;
                    }
                    break;
                case -1137582698:
                    if (str.equals("toLowerCase")) {
                        b = 13;
                        str4 = "charAt";
                        str5 = r6;
                    } else {
                        str4 = "charAt";
                        str5 = "hasOwnProperty";
                        b = -1;
                    }
                    break;
                case -906336856:
                    if (str.equals(FirebaseAnalytics.Event.SEARCH)) {
                        b = 7;
                        str4 = "charAt";
                        str5 = r6;
                    } else {
                        str4 = "charAt";
                        str5 = "hasOwnProperty";
                        b = -1;
                    }
                    break;
                case -726908483:
                    if (str.equals(str2)) {
                        b = 11;
                        str4 = "charAt";
                        str5 = r6;
                    } else {
                        str4 = "charAt";
                        str5 = "hasOwnProperty";
                        b = -1;
                    }
                    break;
                case -467511597:
                    if (str.equals("lastIndexOf")) {
                        b = 4;
                        str4 = "charAt";
                        str5 = r6;
                    } else {
                        str4 = "charAt";
                        str5 = "hasOwnProperty";
                        b = -1;
                    }
                    break;
                case -399551817:
                    if (str.equals("toUpperCase")) {
                        b = 15;
                        str4 = "charAt";
                        str5 = r6;
                    } else {
                        str4 = "charAt";
                        str5 = "hasOwnProperty";
                        b = -1;
                    }
                    break;
                case 3568674:
                    if (str.equals(str3)) {
                        b = 16;
                        str4 = "charAt";
                        str5 = r6;
                    } else {
                        str4 = "charAt";
                        str5 = "hasOwnProperty";
                        b = -1;
                    }
                    break;
                case 103668165:
                    if (str.equals("match")) {
                        b = 5;
                        str4 = "charAt";
                        str5 = r6;
                    } else {
                        str4 = "charAt";
                        str5 = "hasOwnProperty";
                        b = -1;
                    }
                    break;
                case 109526418:
                    if (str.equals("slice")) {
                        b = 8;
                        str4 = "charAt";
                        str5 = r6;
                    } else {
                        str4 = "charAt";
                        str5 = "hasOwnProperty";
                        b = -1;
                    }
                    break;
                case 109648666:
                    if (str.equals("split")) {
                        b = 9;
                        str4 = "charAt";
                        str5 = r6;
                    } else {
                        str4 = "charAt";
                        str5 = "hasOwnProperty";
                        b = -1;
                    }
                    break;
                case 530542161:
                    if (str.equals("substring")) {
                        b = 10;
                        str4 = "charAt";
                        str5 = r6;
                    } else {
                        str4 = "charAt";
                        str5 = "hasOwnProperty";
                        b = -1;
                    }
                    break;
                case 1094496948:
                    if (str.equals("replace")) {
                        b = 6;
                        str4 = "charAt";
                        str5 = r6;
                    } else {
                        str4 = "charAt";
                        str5 = "hasOwnProperty";
                        b = -1;
                    }
                    break;
                case 1943291465:
                    if (str.equals("indexOf")) {
                        str4 = "charAt";
                        str5 = r6;
                        b = 3;
                    } else {
                        str4 = "charAt";
                        str5 = "hasOwnProperty";
                        b = -1;
                    }
                    break;
                default:
                    str4 = "charAt";
                    str5 = "hasOwnProperty";
                    b = -1;
                    break;
            }
            strZzi = "undefined";
            switch (b) {
                case 0:
                    zzh.zzj(str4, 1, list);
                    if (list.isEmpty()) {
                        iZza = 0;
                    } else {
                        iZza = (int) zzh.zza(zzgVar.zzb((zzap) list.get(0)).zzh().doubleValue());
                    }
                    String str11 = this.zza;
                    return (iZza >= 0 || iZza >= str11.length()) ? zzap.zzm : new zzat(String.valueOf(str11.charAt(iZza)));
                case 1:
                    zzatVar = this;
                    if (!list.isEmpty()) {
                        sb = new StringBuilder(zzatVar.zza);
                        for (i = 0; i < list.size(); i++) {
                            sb.append(zzgVar.zzb((zzap) list.get(i)).zzi());
                        }
                        zzatVar2 = new zzat(sb.toString());
                        return zzatVar2;
                    }
                    return zzatVar;
                case 2:
                    zzatVar = this;
                    zzh.zzh(str5, 1, list);
                    String str12 = zzatVar.zza;
                    zzapVarZzb = zzgVar.zzb((zzap) list.get(0));
                    if ("length".equals(zzapVarZzb.zzi())) {
                        zzatVar2 = zzap.zzk;
                    } else {
                        dDoubleValue = zzapVarZzb.zzh().doubleValue();
                        if (dDoubleValue == Math.floor(dDoubleValue) || (i2 = (int) dDoubleValue) < 0 || i2 >= str12.length()) {
                            zzatVar2 = zzap.zzl;
                        } else {
                            zzatVar2 = zzap.zzk;
                        }
                    }
                    return zzatVar2;
                case 3:
                    zzh.zzj("indexOf", 2, list);
                    return new zzah(Double.valueOf(this.zza.indexOf(list.size() > 0 ? zzgVar.zzb((zzap) list.get(0)).zzi() : "undefined", (int) zzh.zza(list.size() >= 2 ? zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue() : 0.0d))));
                case 4:
                    zzh.zzj("lastIndexOf", 2, list);
                    String str13 = this.zza;
                    String strZzi4 = list.size() > 0 ? zzgVar.zzb((zzap) list.get(0)).zzi() : "undefined";
                    if (list.size() < 2) {
                        dDoubleValue2 = Double.NaN;
                    } else {
                        dDoubleValue2 = zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue();
                    }
                    if (Double.isNaN(dDoubleValue2)) {
                        dZza = Double.POSITIVE_INFINITY;
                    } else {
                        dZza = zzh.zza(dDoubleValue2);
                    }
                    return new zzah(Double.valueOf(str13.lastIndexOf(strZzi4, (int) dZza)));
                case 5:
                    zzatVar = this;
                    zzh.zzj("match", 1, list);
                    String str14 = zzatVar.zza;
                    if (list.size() <= 0) {
                        strZzi2 = "";
                    } else {
                        strZzi2 = zzgVar.zzb((zzap) list.get(0)).zzi();
                    }
                    matcher = Pattern.compile(strZzi2).matcher(str14);
                    if (matcher.find()) {
                        zzaeVar = new zzae(Arrays.asList(new zzat(matcher.group())));
                        return zzaeVar;
                    }
                    zzatVar2 = zzap.zzg;
                    return zzatVar2;
                case 6:
                    zzatVar = this;
                    zzh.zzj("replace", 2, list);
                    zzapVarZza = zzap.zzf;
                    if (!list.isEmpty()) {
                        strZzi = zzgVar.zzb((zzap) list.get(0)).zzi();
                        if (list.size() > 1) {
                            zzapVarZza = zzgVar.zzb((zzap) list.get(1));
                        }
                    }
                    str6 = strZzi;
                    str7 = zzatVar.zza;
                    iIndexOf = str7.indexOf(str6);
                    if (iIndexOf >= 0) {
                        if (zzapVarZza instanceof zzai) {
                            i3 = 0;
                            zzapVarZza = ((zzai) zzapVarZza).zza(zzgVar, Arrays.asList(new zzat(str6), new zzah(Double.valueOf(iIndexOf)), zzatVar));
                        } else {
                            i3 = 0;
                        }
                        zzaeVar = new zzat(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(str7.substring(i3, iIndexOf), zzapVarZza.zzi(), str7.substring(str6.length() + iIndexOf)));
                        return zzaeVar;
                    }
                    return zzatVar;
                case 7:
                    zzatVar = this;
                    zzh.zzj(FirebaseAnalytics.Event.SEARCH, 1, list);
                    matcher2 = Pattern.compile(list.isEmpty() ? "undefined" : zzgVar.zzb((zzap) list.get(0)).zzi()).matcher(zzatVar.zza);
                    if (matcher2.find()) {
                        zzaeVar = new zzah(Double.valueOf(matcher2.start()));
                        return zzaeVar;
                    }
                    zzatVar2 = new zzah(Double.valueOf(-1.0d));
                    return zzatVar2;
                case 8:
                    zzatVar = this;
                    zzh.zzj("slice", 2, list);
                    str8 = zzatVar.zza;
                    if (list.isEmpty()) {
                        dDoubleValue3 = 0.0d;
                    } else {
                        dDoubleValue3 = zzgVar.zzb((zzap) list.get(0)).zzh().doubleValue();
                    }
                    dZza2 = zzh.zza(dDoubleValue3);
                    if (dZza2 < 0.0d) {
                        dMin = Math.max(((double) str8.length()) + dZza2, 0.0d);
                    } else {
                        dMin = Math.min(dZza2, str8.length());
                    }
                    int i7 = (int) dMin;
                    if (list.size() > 1) {
                        length = zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue();
                    } else {
                        length = str8.length();
                    }
                    dZza3 = zzh.zza(length);
                    if (dZza3 < 0.0d) {
                        dMin2 = Math.max(((double) str8.length()) + dZza3, 0.0d);
                    } else {
                        dMin2 = Math.min(dZza3, str8.length());
                    }
                    zzaeVar = new zzat(str8.substring(i7, Math.max(0, ((int) dMin2) - i7) + i7));
                    return zzaeVar;
                case 9:
                    zzatVar = this;
                    zzh.zzj("split", 2, list);
                    str9 = zzatVar.zza;
                    if (str9.length() == 0) {
                        zzatVar2 = new zzae(Arrays.asList(zzatVar));
                    } else {
                        arrayList = new ArrayList();
                        if (list.isEmpty()) {
                            arrayList.add(zzatVar);
                        } else {
                            strZzi3 = zzgVar.zzb((zzap) list.get(0)).zzi();
                            if (list.size() > 1) {
                                jZzd = zzh.zzd(zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue());
                            } else {
                                jZzd = 2147483647L;
                            }
                            if (jZzd == 0) {
                                zzatVar2 = new zzae();
                            } else {
                                strArrSplit = str9.split(Pattern.quote(strZzi3), ((int) jZzd) + 1);
                                length2 = strArrSplit.length;
                                if (strZzi3.isEmpty() || length2 <= 0) {
                                    i4 = -1;
                                    i5 = length2;
                                    i6 = 0;
                                } else {
                                    zIsEmpty = strArrSplit[0].isEmpty();
                                    i4 = -1;
                                    i5 = length2 - 1;
                                    if (!strArrSplit[i5].isEmpty()) {
                                        i6 = zIsEmpty;
                                        i5 = length2;
                                        i6 = zIsEmpty;
                                    }
                                }
                                i6 = zIsEmpty;
                                if (length2 > jZzd) {
                                    i5 += i4;
                                }
                                while (i6 < i5) {
                                    arrayList.add(new zzat(strArrSplit[i6]));
                                    i6++;
                                }
                            }
                        }
                        zzatVar2 = new zzae(arrayList);
                    }
                    return zzatVar2;
                case 10:
                    zzatVar = this;
                    zzh.zzj("substring", 2, list);
                    str10 = zzatVar.zza;
                    if (list.isEmpty()) {
                        zzgVar2 = zzgVar;
                        iZza2 = 0;
                    } else {
                        zzgVar2 = zzgVar;
                        iZza2 = (int) zzh.zza(zzgVar2.zzb((zzap) list.get(0)).zzh().doubleValue());
                    }
                    if (list.size() > 1) {
                        length3 = (int) zzh.zza(zzgVar2.zzb((zzap) list.get(1)).zzh().doubleValue());
                    } else {
                        length3 = str10.length();
                    }
                    int iMin = Math.min(Math.max(iZza2, 0), str10.length());
                    int iMin2 = Math.min(Math.max(length3, 0), str10.length());
                    zzaeVar = new zzat(str10.substring(Math.min(iMin, iMin2), Math.max(iMin, iMin2)));
                    return zzaeVar;
                case 11:
                    zzatVar = this;
                    zzh.zzh(str2, 0, list);
                    zzaeVar = new zzat(zzatVar.zza.toUpperCase());
                    return zzaeVar;
                case 12:
                    zzatVar = this;
                    zzh.zzh("toLocaleLowerCase", 0, list);
                    zzaeVar = new zzat(zzatVar.zza.toLowerCase());
                    return zzaeVar;
                case 13:
                    zzatVar = this;
                    zzh.zzh("toLowerCase", 0, list);
                    zzaeVar = new zzat(zzatVar.zza.toLowerCase(Locale.ENGLISH));
                    return zzaeVar;
                case 14:
                    zzatVar = this;
                    zzh.zzh("toString", 0, list);
                    return zzatVar;
                case 15:
                    zzatVar = this;
                    zzh.zzh("toUpperCase", 0, list);
                    zzaeVar = new zzat(zzatVar.zza.toUpperCase(Locale.ENGLISH));
                    return zzaeVar;
                case 16:
                    zzh.zzh("toUpperCase", 0, list);
                    zzatVar = this;
                    zzaeVar = new zzat(zzatVar.zza.trim());
                    return zzaeVar;
                default:
                    throw new IllegalArgumentException("Command not supported");
            }
        }
        str2 = "toLocaleUpperCase";
        str3 = "trim";
        switch (str.hashCode()) {
            case -1789698943:
                str4 = "charAt";
                str5 = r6;
                if (str.equals(str5)) {
                    b = 2;
                } else {
                    b = -1;
                }
                break;
            case -1776922004:
                str4 = "charAt";
                if (str.equals("toString")) {
                    b = 14;
                    str5 = r6;
                }
                str5 = "hasOwnProperty";
                b = -1;
                break;
            case -1464939364:
                str4 = "charAt";
                if (str.equals("toLocaleLowerCase")) {
                    b = 12;
                    str5 = r6;
                }
                str5 = "hasOwnProperty";
                b = -1;
                break;
            case -1361633751:
                str4 = "charAt";
                if (str.equals(str4)) {
                    str5 = r6;
                    b = 0;
                } else {
                    str5 = "hasOwnProperty";
                    b = -1;
                }
                break;
            case -1354795244:
                if (str.equals("concat")) {
                    str4 = "charAt";
                    str5 = r6;
                    b = 1;
                } else {
                    str4 = "charAt";
                    str5 = "hasOwnProperty";
                    b = -1;
                }
                break;
            case -1137582698:
                if (str.equals("toLowerCase")) {
                    b = 13;
                    str4 = "charAt";
                    str5 = r6;
                } else {
                    str4 = "charAt";
                    str5 = "hasOwnProperty";
                    b = -1;
                }
                break;
            case -906336856:
                if (str.equals(FirebaseAnalytics.Event.SEARCH)) {
                    b = 7;
                    str4 = "charAt";
                    str5 = r6;
                } else {
                    str4 = "charAt";
                    str5 = "hasOwnProperty";
                    b = -1;
                }
                break;
            case -726908483:
                if (str.equals(str2)) {
                    b = 11;
                    str4 = "charAt";
                    str5 = r6;
                } else {
                    str4 = "charAt";
                    str5 = "hasOwnProperty";
                    b = -1;
                }
                break;
            case -467511597:
                if (str.equals("lastIndexOf")) {
                    b = 4;
                    str4 = "charAt";
                    str5 = r6;
                } else {
                    str4 = "charAt";
                    str5 = "hasOwnProperty";
                    b = -1;
                }
                break;
            case -399551817:
                if (str.equals("toUpperCase")) {
                    b = 15;
                    str4 = "charAt";
                    str5 = r6;
                } else {
                    str4 = "charAt";
                    str5 = "hasOwnProperty";
                    b = -1;
                }
                break;
            case 3568674:
                if (str.equals(str3)) {
                    b = 16;
                    str4 = "charAt";
                    str5 = r6;
                } else {
                    str4 = "charAt";
                    str5 = "hasOwnProperty";
                    b = -1;
                }
                break;
            case 103668165:
                if (str.equals("match")) {
                    b = 5;
                    str4 = "charAt";
                    str5 = r6;
                } else {
                    str4 = "charAt";
                    str5 = "hasOwnProperty";
                    b = -1;
                }
                break;
            case 109526418:
                if (str.equals("slice")) {
                    b = 8;
                    str4 = "charAt";
                    str5 = r6;
                } else {
                    str4 = "charAt";
                    str5 = "hasOwnProperty";
                    b = -1;
                }
                break;
            case 109648666:
                if (str.equals("split")) {
                    b = 9;
                    str4 = "charAt";
                    str5 = r6;
                } else {
                    str4 = "charAt";
                    str5 = "hasOwnProperty";
                    b = -1;
                }
                break;
            case 530542161:
                if (str.equals("substring")) {
                    b = 10;
                    str4 = "charAt";
                    str5 = r6;
                } else {
                    str4 = "charAt";
                    str5 = "hasOwnProperty";
                    b = -1;
                }
                break;
            case 1094496948:
                if (str.equals("replace")) {
                    b = 6;
                    str4 = "charAt";
                    str5 = r6;
                } else {
                    str4 = "charAt";
                    str5 = "hasOwnProperty";
                    b = -1;
                }
                break;
            case 1943291465:
                if (str.equals("indexOf")) {
                    str4 = "charAt";
                    str5 = r6;
                    b = 3;
                } else {
                    str4 = "charAt";
                    str5 = "hasOwnProperty";
                    b = -1;
                }
                break;
            default:
                str4 = "charAt";
                str5 = "hasOwnProperty";
                b = -1;
                break;
        }
        strZzi = "undefined";
        switch (b) {
            case 0:
                zzh.zzj(str4, 1, list);
                if (list.isEmpty()) {
                    iZza = (int) zzh.zza(zzgVar.zzb((zzap) list.get(0)).zzh().doubleValue());
                } else {
                    iZza = 0;
                }
                String str15 = this.zza;
                if (iZza >= 0) {
                }
                break;
            case 1:
                zzatVar = this;
                if (!list.isEmpty()) {
                    sb = new StringBuilder(zzatVar.zza);
                    while (i < list.size()) {
                        sb.append(zzgVar.zzb((zzap) list.get(i)).zzi());
                    }
                    zzatVar2 = new zzat(sb.toString());
                    return zzatVar2;
                }
                return zzatVar;
            case 2:
                zzatVar = this;
                zzh.zzh(str5, 1, list);
                String str16 = zzatVar.zza;
                zzapVarZzb = zzgVar.zzb((zzap) list.get(0));
                if ("length".equals(zzapVarZzb.zzi())) {
                    zzatVar2 = zzap.zzk;
                } else {
                    dDoubleValue = zzapVarZzb.zzh().doubleValue();
                    if (dDoubleValue == Math.floor(dDoubleValue)) {
                        zzatVar2 = zzap.zzl;
                    } else {
                        zzatVar2 = zzap.zzl;
                    }
                }
                return zzatVar2;
            case 3:
                zzh.zzj("indexOf", 2, list);
                return new zzah(Double.valueOf(this.zza.indexOf(list.size() > 0 ? zzgVar.zzb((zzap) list.get(0)).zzi() : "undefined", (int) zzh.zza(list.size() >= 2 ? zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue() : 0.0d))));
            case 4:
                zzh.zzj("lastIndexOf", 2, list);
                String str17 = this.zza;
                String strZzi5 = list.size() > 0 ? zzgVar.zzb((zzap) list.get(0)).zzi() : "undefined";
                if (list.size() < 2) {
                    dDoubleValue2 = Double.NaN;
                } else {
                    dDoubleValue2 = zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue();
                }
                if (Double.isNaN(dDoubleValue2)) {
                    dZza = Double.POSITIVE_INFINITY;
                } else {
                    dZza = zzh.zza(dDoubleValue2);
                }
                return new zzah(Double.valueOf(str17.lastIndexOf(strZzi5, (int) dZza)));
            case 5:
                zzatVar = this;
                zzh.zzj("match", 1, list);
                String str18 = zzatVar.zza;
                if (list.size() <= 0) {
                    strZzi2 = "";
                } else {
                    strZzi2 = zzgVar.zzb((zzap) list.get(0)).zzi();
                }
                matcher = Pattern.compile(strZzi2).matcher(str18);
                if (matcher.find()) {
                    zzaeVar = new zzae(Arrays.asList(new zzat(matcher.group())));
                    return zzaeVar;
                }
                zzatVar2 = zzap.zzg;
                return zzatVar2;
            case 6:
                zzatVar = this;
                zzh.zzj("replace", 2, list);
                zzapVarZza = zzap.zzf;
                if (!list.isEmpty()) {
                    strZzi = zzgVar.zzb((zzap) list.get(0)).zzi();
                    if (list.size() > 1) {
                        zzapVarZza = zzgVar.zzb((zzap) list.get(1));
                    }
                }
                str6 = strZzi;
                str7 = zzatVar.zza;
                iIndexOf = str7.indexOf(str6);
                if (iIndexOf >= 0) {
                    if (zzapVarZza instanceof zzai) {
                        i3 = 0;
                        zzapVarZza = ((zzai) zzapVarZza).zza(zzgVar, Arrays.asList(new zzat(str6), new zzah(Double.valueOf(iIndexOf)), zzatVar));
                    } else {
                        i3 = 0;
                    }
                    zzaeVar = new zzat(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(str7.substring(i3, iIndexOf), zzapVarZza.zzi(), str7.substring(str6.length() + iIndexOf)));
                    return zzaeVar;
                }
                return zzatVar;
            case 7:
                zzatVar = this;
                zzh.zzj(FirebaseAnalytics.Event.SEARCH, 1, list);
                matcher2 = Pattern.compile(list.isEmpty() ? "undefined" : zzgVar.zzb((zzap) list.get(0)).zzi()).matcher(zzatVar.zza);
                if (matcher2.find()) {
                    zzaeVar = new zzah(Double.valueOf(matcher2.start()));
                    return zzaeVar;
                }
                zzatVar2 = new zzah(Double.valueOf(-1.0d));
                return zzatVar2;
            case 8:
                zzatVar = this;
                zzh.zzj("slice", 2, list);
                str8 = zzatVar.zza;
                if (list.isEmpty()) {
                    dDoubleValue3 = zzgVar.zzb((zzap) list.get(0)).zzh().doubleValue();
                } else {
                    dDoubleValue3 = 0.0d;
                }
                dZza2 = zzh.zza(dDoubleValue3);
                if (dZza2 < 0.0d) {
                    dMin = Math.max(((double) str8.length()) + dZza2, 0.0d);
                } else {
                    dMin = Math.min(dZza2, str8.length());
                }
                int i8 = (int) dMin;
                if (list.size() > 1) {
                    length = zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue();
                } else {
                    length = str8.length();
                }
                dZza3 = zzh.zza(length);
                if (dZza3 < 0.0d) {
                    dMin2 = Math.max(((double) str8.length()) + dZza3, 0.0d);
                } else {
                    dMin2 = Math.min(dZza3, str8.length());
                }
                zzaeVar = new zzat(str8.substring(i8, Math.max(0, ((int) dMin2) - i8) + i8));
                return zzaeVar;
            case 9:
                zzatVar = this;
                zzh.zzj("split", 2, list);
                str9 = zzatVar.zza;
                if (str9.length() == 0) {
                    zzatVar2 = new zzae(Arrays.asList(zzatVar));
                } else {
                    arrayList = new ArrayList();
                    if (list.isEmpty()) {
                        arrayList.add(zzatVar);
                    } else {
                        strZzi3 = zzgVar.zzb((zzap) list.get(0)).zzi();
                        if (list.size() > 1) {
                            jZzd = zzh.zzd(zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue());
                        } else {
                            jZzd = 2147483647L;
                        }
                        if (jZzd == 0) {
                            zzatVar2 = new zzae();
                        } else {
                            strArrSplit = str9.split(Pattern.quote(strZzi3), ((int) jZzd) + 1);
                            length2 = strArrSplit.length;
                            if (strZzi3.isEmpty()) {
                                i4 = -1;
                                i5 = length2;
                                i6 = 0;
                            } else {
                                i4 = -1;
                                i5 = length2;
                                i6 = 0;
                            }
                            i6 = zIsEmpty;
                            if (length2 > jZzd) {
                                i5 += i4;
                            }
                            while (i6 < i5) {
                                arrayList.add(new zzat(strArrSplit[i6]));
                                i6++;
                            }
                        }
                    }
                    zzatVar2 = new zzae(arrayList);
                }
                return zzatVar2;
            case 10:
                zzatVar = this;
                zzh.zzj("substring", 2, list);
                str10 = zzatVar.zza;
                if (list.isEmpty()) {
                    zzgVar2 = zzgVar;
                    iZza2 = (int) zzh.zza(zzgVar2.zzb((zzap) list.get(0)).zzh().doubleValue());
                } else {
                    zzgVar2 = zzgVar;
                    iZza2 = 0;
                }
                if (list.size() > 1) {
                    length3 = (int) zzh.zza(zzgVar2.zzb((zzap) list.get(1)).zzh().doubleValue());
                } else {
                    length3 = str10.length();
                }
                int iMin3 = Math.min(Math.max(iZza2, 0), str10.length());
                int iMin4 = Math.min(Math.max(length3, 0), str10.length());
                zzaeVar = new zzat(str10.substring(Math.min(iMin3, iMin4), Math.max(iMin3, iMin4)));
                return zzaeVar;
            case 11:
                zzatVar = this;
                zzh.zzh(str2, 0, list);
                zzaeVar = new zzat(zzatVar.zza.toUpperCase());
                return zzaeVar;
            case 12:
                zzatVar = this;
                zzh.zzh("toLocaleLowerCase", 0, list);
                zzaeVar = new zzat(zzatVar.zza.toLowerCase());
                return zzaeVar;
            case 13:
                zzatVar = this;
                zzh.zzh("toLowerCase", 0, list);
                zzaeVar = new zzat(zzatVar.zza.toLowerCase(Locale.ENGLISH));
                return zzaeVar;
            case 14:
                zzatVar = this;
                zzh.zzh("toString", 0, list);
                return zzatVar;
            case 15:
                zzatVar = this;
                zzh.zzh("toUpperCase", 0, list);
                zzaeVar = new zzat(zzatVar.zza.toUpperCase(Locale.ENGLISH));
                return zzaeVar;
            case 16:
                zzh.zzh("toUpperCase", 0, list);
                zzatVar = this;
                zzaeVar = new zzat(zzatVar.zza.trim());
                return zzaeVar;
            default:
                throw new IllegalArgumentException("Command not supported");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final zzap zzd() {
        return new zzat(this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Boolean zzg() {
        return Boolean.valueOf(!this.zza.isEmpty());
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Double zzh() {
        if (this.zza.isEmpty()) {
            return Double.valueOf(0.0d);
        }
        try {
            return Double.valueOf(this.zza);
        } catch (NumberFormatException unused) {
            return Double.valueOf(Double.NaN);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final String zzi() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Iterator zzl() {
        return new zzar(this);
    }
}
