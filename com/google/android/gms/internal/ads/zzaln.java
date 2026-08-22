package com.google.android.gms.internal.ads;

import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import com.google.android.gms.common.util.concurrent.dN.MnHfHMYQDPUO;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class zzaln implements zzakt {
    private static final Pattern zza = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d{3}))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d{3}))?)\\s*");
    private static final Pattern zzb = Pattern.compile("\\{\\\\.*?\\}");
    private final StringBuilder zzc = new StringBuilder();
    private final ArrayList zzd = new ArrayList();
    private final zzen zze = new zzen();

    public static float zzb(int i) {
        if (i == 0) {
            return 0.08f;
        }
        if (i == 1) {
            return 0.5f;
        }
        if (i == 2) {
            return 0.92f;
        }
        throw new IllegalArgumentException();
    }

    private static long zzc(Matcher matcher, int i) {
        String strGroup = matcher.group(i + 1);
        long j = strGroup != null ? Long.parseLong(strGroup) * 3600000 : 0L;
        String strGroup2 = matcher.group(i + 2);
        strGroup2.getClass();
        long j2 = (Long.parseLong(strGroup2) * 60000) + j;
        String strGroup3 = matcher.group(i + 3);
        strGroup3.getClass();
        long j3 = (Long.parseLong(strGroup3) * 1000) + j2;
        String strGroup4 = matcher.group(i + 4);
        if (strGroup4 != null) {
            j3 += Long.parseLong(strGroup4);
        }
        return j3 * 1000;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:59:0x0132  */
    /* JADX WARN: Code duplicated, block: B:94:0x018d  */
    @Override // com.google.android.gms.internal.ads.zzakt
    public final void zza(byte[] bArr, int i, int i2, zzaks zzaksVar, zzdn zzdnVar) {
        zzen zzenVar;
        String str;
        byte b;
        byte b2;
        int i3;
        zzcu zzcuVarZzq;
        zzaln zzalnVar = this;
        zzen zzenVar2 = zzalnVar.zze;
        zzenVar2.zzJ(bArr, i + i2);
        zzenVar2.zzL(i);
        Charset charsetZzC = zzenVar2.zzC();
        if (charsetZzC == null) {
            charsetZzC = StandardCharsets.UTF_8;
        }
        while (true) {
            String strZzz = zzenVar2.zzz(charsetZzC);
            if (strZzz == null) {
                return;
            }
            if (strZzz.length() != 0) {
                try {
                    Integer.parseInt(strZzz);
                    zzen zzenVar3 = zzalnVar.zze;
                    String strZzz2 = zzenVar3.zzz(charsetZzC);
                    if (strZzz2 == null) {
                        zzea.zzf("SubripParser", "Unexpected end");
                        return;
                    }
                    Matcher matcher = zza.matcher(strZzz2);
                    if (matcher.matches()) {
                        long jZzc = zzc(matcher, 1);
                        long jZzc2 = zzc(matcher, 6);
                        StringBuilder sb = zzalnVar.zzc;
                        int i4 = 0;
                        sb.setLength(0);
                        ArrayList arrayList = zzalnVar.zzd;
                        arrayList.clear();
                        String strZzz3 = zzenVar3.zzz(charsetZzC);
                        while (!TextUtils.isEmpty(strZzz3)) {
                            if (sb.length() > 0) {
                                sb.append("<br>");
                            }
                            String strTrim = strZzz3.trim();
                            StringBuilder sb2 = new StringBuilder(strTrim);
                            Matcher matcher2 = zzb.matcher(strTrim);
                            int i5 = i4;
                            while (matcher2.find()) {
                                String strGroup = matcher2.group();
                                arrayList.add(strGroup);
                                int iStart = matcher2.start() - i5;
                                int length = strGroup.length();
                                sb2.replace(iStart, iStart + length, "");
                                i5 += length;
                                zzenVar2 = zzenVar2;
                            }
                            sb.append(sb2.toString());
                            strZzz3 = zzenVar3.zzz(charsetZzC);
                            i4 = 0;
                        }
                        zzenVar = zzenVar2;
                        Spanned spannedFromHtml = Html.fromHtml(sb.toString());
                        int i6 = 0;
                        while (true) {
                            if (i6 < arrayList.size()) {
                                str = (String) arrayList.get(i6);
                                if (!str.matches("\\{\\\\an[1-9]\\}")) {
                                    i6++;
                                }
                            } else {
                                str = null;
                            }
                        }
                        zzcs zzcsVar = new zzcs();
                        zzcsVar.zzl(spannedFromHtml);
                        if (str == null) {
                            zzcuVarZzq = zzcsVar.zzq();
                        } else {
                            switch (str) {
                                case "{\an1}":
                                    b = 0;
                                    break;
                                case "{\an3}":
                                    b = 3;
                                    break;
                                case "{\an4}":
                                    b = 1;
                                    break;
                                case "{\an6}":
                                    b = 4;
                                    break;
                                case "{\an7}":
                                    b = 2;
                                    break;
                                case "{\an9}":
                                    b = 5;
                                    break;
                                default:
                                    b = -1;
                                    break;
                            }
                            if (b == 0 || b == 1 || b == 2) {
                                zzcsVar.zzi(0);
                            } else if (b == 3 || b == 4 || b == 5) {
                                zzcsVar.zzi(2);
                            } else {
                                zzcsVar.zzi(1);
                            }
                            switch (str.hashCode()) {
                                case -685620710:
                                    if (!str.equals("{\\an1}")) {
                                        b2 = -1;
                                    } else {
                                        b2 = 0;
                                    }
                                    break;
                                case -685620679:
                                    if (!str.equals(MnHfHMYQDPUO.NeHMuHmGj)) {
                                        b2 = -1;
                                    } else {
                                        b2 = 1;
                                    }
                                    break;
                                case -685620648:
                                    if (!str.equals("{\\an3}")) {
                                        b2 = -1;
                                    } else {
                                        b2 = 2;
                                    }
                                    break;
                                case -685620524:
                                    if (!str.equals("{\\an7}")) {
                                        b2 = -1;
                                    } else {
                                        b2 = 3;
                                    }
                                    break;
                                case -685620493:
                                    if (!str.equals("{\\an8}")) {
                                        b2 = -1;
                                    } else {
                                        b2 = 4;
                                    }
                                    break;
                                case -685620462:
                                    if (!str.equals("{\\an9}")) {
                                        b2 = -1;
                                    } else {
                                        b2 = 5;
                                    }
                                    break;
                                default:
                                    b2 = -1;
                                    break;
                            }
                            if (b2 == 0 || b2 == 1) {
                                i3 = 2;
                            } else {
                                if (b2 == 2) {
                                    i3 = 2;
                                } else if (b2 == 3 || b2 == 4 || b2 == 5) {
                                    zzcsVar.zzf(0);
                                } else {
                                    zzcsVar.zzf(1);
                                }
                                zzcsVar.zzh(zzb(zzcsVar.zzb()));
                                zzcsVar.zze(zzb(zzcsVar.zza()), 0);
                                zzcuVarZzq = zzcsVar.zzq();
                            }
                            zzcsVar.zzf(i3);
                            zzcsVar.zzh(zzb(zzcsVar.zzb()));
                            zzcsVar.zze(zzb(zzcsVar.zza()), 0);
                            zzcuVarZzq = zzcsVar.zzq();
                        }
                        zzdnVar.zza(new zzakl(zzfyq.zzo(zzcuVarZzq), jZzc, jZzc2 - jZzc));
                    } else {
                        zzenVar = zzenVar2;
                        zzea.zzf("SubripParser", "Skipping invalid timing: ".concat(strZzz2));
                    }
                } catch (NumberFormatException unused) {
                    zzenVar = zzenVar2;
                    zzea.zzf("SubripParser", "Skipping invalid index: ".concat(strZzz));
                }
            } else {
                zzenVar = zzenVar2;
            }
            zzalnVar = this;
            zzenVar2 = zzenVar;
        }
    }
}
