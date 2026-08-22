package com.google.android.gms.internal.ads;

import android.graphics.PointF;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.zxing.BarcodeFormat$EnumUnboxingLocalUtility;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class zzalj implements zzakt {
    private static final Pattern zza = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");
    private final boolean zzb;
    private final zzali zzc;
    private final zzen zzd;
    private Map zze;
    private float zzf;
    private float zzg;

    public zzalj() {
        this(null);
    }

    private static float zzb(int i) {
        if (i == 0) {
            return 0.05f;
        }
        if (i != 1) {
            return i != 2 ? -3.4028235E38f : 0.95f;
        }
        return 0.5f;
    }

    private static int zzc(long j, List list, List list2) {
        int i;
        int size = list.size();
        while (true) {
            size--;
            if (size < 0) {
                i = 0;
                break;
            }
            if (((Long) list.get(size)).longValue() == j) {
                return size;
            }
            if (((Long) list.get(size)).longValue() < j) {
                i = size + 1;
                break;
            }
        }
        list.add(i, Long.valueOf(j));
        list2.add(i, i == 0 ? new ArrayList() : new ArrayList((Collection) list2.get(i - 1)));
        return i;
    }

    private static long zzd(String str) {
        Matcher matcher = zza.matcher(str.trim());
        if (!matcher.matches()) {
            return -9223372036854775807L;
        }
        String strGroup = matcher.group(1);
        String str2 = zzex.zza;
        long j = Long.parseLong(strGroup) * 3600000000L;
        long j2 = Long.parseLong(matcher.group(2)) * 60000000;
        return j + j2 + (Long.parseLong(matcher.group(3)) * 1000000) + (Long.parseLong(matcher.group(4)) * 10000);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:23:0x0053  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final void zze(zzen zzenVar, Charset charset) {
        while (true) {
            String strZzz = zzenVar.zzz(charset);
            if (strZzz == null) {
                return;
            }
            if ("[Script Info]".equalsIgnoreCase(strZzz)) {
                while (true) {
                    String strZzz2 = zzenVar.zzz(charset);
                    if (strZzz2 == null || (zzenVar.zza() != 0 && zzenVar.zze(charset) == 91)) {
                        break;
                    }
                    String[] strArrSplit = strZzz2.split(":");
                    if (strArrSplit.length == 2) {
                        byte b = 0;
                        String strZza = zzfuv.zza(strArrSplit[0].trim());
                        switch (strZza.hashCode()) {
                            case 1879649548:
                                if (!strZza.equals("playresx")) {
                                    b = -1;
                                }
                                break;
                            case 1879649549:
                                if (!strZza.equals("playresy")) {
                                    b = -1;
                                } else {
                                    b = 1;
                                }
                                break;
                            default:
                                b = -1;
                                break;
                        }
                        if (b == 0) {
                            this.zzf = Float.parseFloat(strArrSplit[1].trim());
                        } else if (b == 1) {
                            try {
                                this.zzg = Float.parseFloat(strArrSplit[1].trim());
                            } catch (NumberFormatException unused) {
                            }
                        }
                    }
                }
            } else if ("[V4+ Styles]".equalsIgnoreCase(strZzz)) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                zzalk zzalkVarZza = null;
                while (true) {
                    String strZzz3 = zzenVar.zzz(charset);
                    if (strZzz3 != null && (zzenVar.zza() == 0 || zzenVar.zze(charset) != 91)) {
                        if (strZzz3.startsWith("Format:")) {
                            zzalkVarZza = zzalk.zza(strZzz3);
                        } else if (strZzz3.startsWith("Style:")) {
                            if (zzalkVarZza == null) {
                                zzea.zzf("SsaParser", "Skipping 'Style:' line before 'Format:' line: ".concat(strZzz3));
                            } else {
                                zzalm zzalmVarZzb = zzalm.zzb(strZzz3, zzalkVarZza);
                                if (zzalmVarZzb != null) {
                                    linkedHashMap.put(zzalmVarZzb.zza, zzalmVarZzb);
                                }
                            }
                        }
                    }
                }
                this.zze = linkedHashMap;
            } else if ("[V4 Styles]".equalsIgnoreCase(strZzz)) {
                zzea.zze("SsaParser", "[V4 Styles] are not supported");
            } else if ("[Events]".equalsIgnoreCase(strZzz)) {
                return;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:125:0x0299  */
    /* JADX WARN: Code duplicated, block: B:141:0x02be A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:74:0x01c0  */
    @Override // com.google.android.gms.internal.ads.zzakt
    public final void zza(byte[] bArr, int i, int i2, zzaks zzaksVar, zzdn zzdnVar) {
        zzali zzaliVarZza;
        int i3;
        zzali zzaliVar;
        int i4;
        int i5;
        Layout.Alignment alignment;
        int i6;
        int i7;
        int i8;
        Integer num;
        int i9;
        zzalj zzaljVar = this;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        zzen zzenVar = zzaljVar.zzd;
        zzenVar.zzJ(bArr, i + i2);
        zzenVar.zzL(i);
        Charset charsetZzC = zzenVar.zzC();
        if (charsetZzC == null) {
            charsetZzC = StandardCharsets.UTF_8;
        }
        if (zzaljVar.zzb) {
            zzaliVarZza = zzaljVar.zzc;
        } else {
            zzaljVar.zze(zzenVar, charsetZzC);
            zzaliVarZza = null;
        }
        while (true) {
            String strZzz = zzenVar.zzz(charsetZzC);
            if (strZzz == null) {
                int i10 = 0;
                while (i10 < arrayList.size()) {
                    List list = (List) arrayList.get(i10);
                    if (!list.isEmpty()) {
                        if (i10 != arrayList.size() - 1) {
                            throw new IllegalStateException();
                        }
                        long jLongValue = ((Long) arrayList2.get(i10)).longValue();
                        zzdnVar.zza(new zzakl(list, jLongValue, ((Long) arrayList2.get(i10 + 1)).longValue() - jLongValue));
                        i3 = 1;
                    } else if (i10 != 0) {
                        i3 = 1;
                    } else {
                        i10 = 0;
                        if (i10 != arrayList.size() - 1) {
                            throw new IllegalStateException();
                        }
                        long jLongValue2 = ((Long) arrayList2.get(i10)).longValue();
                        zzdnVar.zza(new zzakl(list, jLongValue2, ((Long) arrayList2.get(i10 + 1)).longValue() - jLongValue2));
                        i3 = 1;
                    }
                    i10 += i3;
                }
                return;
            }
            if (strZzz.startsWith("Format:")) {
                zzaliVarZza = zzali.zza(strZzz);
            } else {
                if (strZzz.startsWith("Dialogue:")) {
                    if (zzaliVarZza == null) {
                        zzea.zzf("SsaParser", "Skipping dialogue line before complete format: ".concat(strZzz));
                    } else {
                        zzdd.zzd(strZzz.startsWith("Dialogue:"));
                        String strSubstring = strZzz.substring(9);
                        int i11 = zzaliVarZza.zzf;
                        String[] strArrSplit = strSubstring.split(",", i11);
                        if (strArrSplit.length != i11) {
                            zzea.zzf("SsaParser", "Skipping dialogue line with fewer columns than format: ".concat(strZzz));
                        } else {
                            int i12 = zzaliVarZza.zza;
                            if (i12 != -1) {
                                try {
                                    i4 = Integer.parseInt(strArrSplit[i12].trim());
                                } catch (RuntimeException unused) {
                                    BarcodeFormat$EnumUnboxingLocalUtility.m(strArrSplit[zzaliVarZza.zza], "Fail to parse layer: ", "SsaParser");
                                    i4 = 0;
                                }
                            } else {
                                i4 = 0;
                            }
                            long jZzd = zzd(strArrSplit[zzaliVarZza.zzb]);
                            if (jZzd == -9223372036854775807L) {
                                zzea.zzf("SsaParser", "Skipping invalid timing: ".concat(strZzz));
                            } else {
                                long jZzd2 = zzd(strArrSplit[zzaliVarZza.zzc]);
                                if (jZzd2 == -9223372036854775807L || jZzd2 <= jZzd) {
                                    zzaliVar = zzaliVarZza;
                                    zzenVar = zzenVar;
                                    zzea.zzf("SsaParser", "Skipping invalid timing: ".concat(strZzz));
                                } else {
                                    Map map = zzaljVar.zze;
                                    zzalm zzalmVar = (map == null || (i9 = zzaliVarZza.zzd) == -1) ? null : (zzalm) map.get(strArrSplit[i9].trim());
                                    String str = strArrSplit[zzaliVarZza.zze];
                                    zzall zzallVarZza = zzall.zza(str);
                                    String strReplace = zzall.zzb(str).replace("\\N", "\n").replace("\\n", "\n").replace("\\h", " ");
                                    float f = zzaljVar.zzf;
                                    float f2 = zzaljVar.zzg;
                                    SpannableString spannableString = new SpannableString(strReplace);
                                    zzcs zzcsVar = new zzcs();
                                    zzcsVar.zzl(spannableString);
                                    zzcsVar.zzp(i4);
                                    if (zzalmVar != null) {
                                        Integer num2 = zzalmVar.zzc;
                                        zzaliVar = zzaliVarZza;
                                        if (num2 != null) {
                                            spannableString.setSpan(new ForegroundColorSpan(num2.intValue()), 0, spannableString.length(), 33);
                                        }
                                        if (zzalmVar.zzj == 3 && (num = zzalmVar.zzd) != null) {
                                            spannableString.setSpan(new BackgroundColorSpan(num.intValue()), 0, spannableString.length(), 33);
                                        }
                                        float f3 = zzalmVar.zze;
                                        if (f3 != -3.4028235E38f && f2 != -3.4028235E38f) {
                                            zzcsVar.zzn(f3 / f2, 1);
                                        }
                                        if (!zzalmVar.zzf) {
                                            i7 = 0;
                                            i8 = 33;
                                            if (zzalmVar.zzg) {
                                                i5 = 2;
                                                spannableString.setSpan(new StyleSpan(2), 0, spannableString.length(), 33);
                                            }
                                            if (zzalmVar.zzh) {
                                                spannableString.setSpan(new UnderlineSpan(), i7, spannableString.length(), i8);
                                            }
                                            if (zzalmVar.zzi) {
                                                spannableString.setSpan(new StrikethroughSpan(), i7, spannableString.length(), i8);
                                            }
                                        } else if (zzalmVar.zzg) {
                                            i7 = 0;
                                            i8 = 33;
                                            spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
                                        } else {
                                            i7 = 0;
                                            i8 = 33;
                                            spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 33);
                                        }
                                        i5 = 2;
                                        if (zzalmVar.zzh) {
                                            spannableString.setSpan(new UnderlineSpan(), i7, spannableString.length(), i8);
                                        }
                                        if (zzalmVar.zzi) {
                                            spannableString.setSpan(new StrikethroughSpan(), i7, spannableString.length(), i8);
                                        }
                                    } else {
                                        zzaliVar = zzaliVarZza;
                                        zzenVar = zzenVar;
                                        jZzd2 = jZzd2;
                                        i5 = 2;
                                    }
                                    int i13 = zzallVarZza.zza;
                                    if (i13 == -1) {
                                        i13 = zzalmVar != null ? zzalmVar.zzb : -1;
                                    }
                                    switch (i13) {
                                        case 0:
                                        default:
                                            CoroutineAdapterKt$$ExternalSyntheticLambda0.m23m(i13, "Unknown alignment: ", "SsaParser");
                                        case -1:
                                            alignment = null;
                                            break;
                                        case 1:
                                        case 4:
                                        case 7:
                                            alignment = Layout.Alignment.ALIGN_NORMAL;
                                            break;
                                        case 2:
                                        case 5:
                                        case 8:
                                            alignment = Layout.Alignment.ALIGN_CENTER;
                                            break;
                                        case 3:
                                        case 6:
                                        case 9:
                                            alignment = Layout.Alignment.ALIGN_OPPOSITE;
                                            break;
                                    }
                                    zzcsVar.zzm(alignment);
                                    int i14 = Integer.MIN_VALUE;
                                    switch (i13) {
                                        case 0:
                                        default:
                                            CoroutineAdapterKt$$ExternalSyntheticLambda0.m23m(i13, "Unknown alignment: ", "SsaParser");
                                        case -1:
                                            i6 = Integer.MIN_VALUE;
                                            break;
                                        case 1:
                                        case 4:
                                        case 7:
                                            i6 = 0;
                                            break;
                                        case 2:
                                        case 5:
                                        case 8:
                                            i6 = 1;
                                            break;
                                        case 3:
                                        case 6:
                                        case 9:
                                            i6 = i5;
                                            break;
                                    }
                                    zzcsVar.zzi(i6);
                                    switch (i13) {
                                        case -1:
                                            break;
                                        case 0:
                                        default:
                                            CoroutineAdapterKt$$ExternalSyntheticLambda0.m23m(i13, "Unknown alignment: ", "SsaParser");
                                            break;
                                        case 1:
                                        case 2:
                                        case 3:
                                            i14 = i5;
                                            break;
                                        case 4:
                                        case 5:
                                        case 6:
                                            i14 = 1;
                                            break;
                                        case 7:
                                        case 8:
                                        case 9:
                                            i14 = 0;
                                            break;
                                    }
                                    zzcsVar.zzf(i14);
                                    PointF pointF = zzallVarZza.zzb;
                                    if (pointF == null || f2 == -3.4028235E38f || f == -3.4028235E38f) {
                                        zzcsVar.zzh(zzb(zzcsVar.zzb()));
                                        zzcsVar.zze(zzb(zzcsVar.zza()), 0);
                                    } else {
                                        zzcsVar.zzh(pointF.x / f);
                                        zzcsVar.zze(pointF.y / f2, 0);
                                    }
                                    zzcu zzcuVarZzq = zzcsVar.zzq();
                                    int iZzc = zzc(jZzd2, arrayList2, arrayList);
                                    for (int iZzc2 = zzc(jZzd, arrayList2, arrayList); iZzc2 < iZzc; iZzc2++) {
                                        ((List) arrayList.get(iZzc2)).add(zzcuVarZzq);
                                    }
                                }
                            }
                        }
                    }
                    zzaliVar = zzaliVarZza;
                    zzenVar = zzenVar;
                } else {
                    zzaliVar = zzaliVarZza;
                    zzenVar = zzenVar;
                }
                zzaljVar = this;
                charsetZzC = charsetZzC;
                zzaliVarZza = zzaliVar;
                zzenVar = zzenVar;
            }
        }
    }

    public zzalj(List list) {
        this.zzf = -3.4028235E38f;
        this.zzg = -3.4028235E38f;
        this.zzd = new zzen();
        if (list == null || list.isEmpty()) {
            this.zzb = false;
            this.zzc = null;
            return;
        }
        this.zzb = true;
        String strZzB = zzex.zzB((byte[]) list.get(0));
        zzdd.zzd(strZzB.startsWith("Format:"));
        zzali zzaliVarZza = zzali.zza(strZzB);
        zzaliVarZza.getClass();
        this.zzc = zzaliVarZza;
        zze(new zzen((byte[]) list.get(1)), StandardCharsets.UTF_8);
    }
}
