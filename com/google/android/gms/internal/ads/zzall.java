package com.google.android.gms.internal.ads;

import android.graphics.PointF;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
final class zzall {
    private static final Pattern zzc = Pattern.compile("\\{([^}]*)\\}");
    private static final Pattern zzd;
    private static final Pattern zze;
    private static final Pattern zzf;
    public final int zza;
    public final PointF zzb;

    static {
        String str = zzex.zza;
        Locale locale = Locale.US;
        zzd = Pattern.compile(String.format(locale, "\\\\pos\\((%1$s),(%1$s)\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));
        zze = Pattern.compile(String.format(locale, "\\\\move\\(%1$s,%1$s,(%1$s),(%1$s)(?:,%1$s,%1$s)?\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));
        zzf = Pattern.compile("\\\\an(\\d+)");
    }

    private zzall(int i, PointF pointF) {
        this.zza = i;
        this.zzb = pointF;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0081  */
    /* JADX WARN: Code duplicated, block: B:25:0x008e A[Catch: RuntimeException -> 0x000a, TryCatch #1 {RuntimeException -> 0x000a, blocks: (B:23:0x0082, B:25:0x008e, B:27:0x0094, B:28:0x0099), top: B:37:0x0082 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x0099 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:43:0x009d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x009a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:0x0094 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:0x000a A[SYNTHETIC] */
    public static zzall zza(String str) {
        Matcher matcher;
        int iZzd;
        String strGroup;
        PointF pointF;
        String strGroup2;
        String strGroup3;
        Matcher matcher2 = zzc.matcher(str);
        PointF pointF2 = null;
        int i = -1;
        while (matcher2.find()) {
            String strGroup4 = matcher2.group(1);
            strGroup4.getClass();
            try {
                Matcher matcher3 = zzd.matcher(strGroup4);
                Matcher matcher4 = zze.matcher(strGroup4);
                boolean zFind = matcher3.find();
                boolean zFind2 = matcher4.find();
                if (zFind) {
                    if (zFind2) {
                        zzea.zze("SsaStyle.Overrides", "Override has both \\pos(x,y) and \\move(x1,y1,x2,y2); using \\pos values. override='" + strGroup4 + "'");
                    }
                    strGroup2 = matcher3.group(1);
                    strGroup3 = matcher3.group(2);
                } else {
                    if (zFind2) {
                        String strGroup5 = matcher4.group(1);
                        String strGroup6 = matcher4.group(2);
                        strGroup2 = strGroup5;
                        strGroup3 = strGroup6;
                    } else {
                        pointF = null;
                    }
                    if (pointF != null) {
                        pointF2 = pointF;
                    }
                    try {
                        matcher = zzf.matcher(strGroup4);
                        if (matcher.find()) {
                            strGroup = matcher.group(1);
                            if (strGroup != null) {
                                throw null;
                            }
                            iZzd = zzalm.zzd(strGroup);
                        } else {
                            iZzd = -1;
                        }
                        if (iZzd != -1) {
                            i = iZzd;
                        }
                    } catch (RuntimeException unused) {
                    }
                }
                if (strGroup2 == null) {
                    throw null;
                }
                float f = Float.parseFloat(strGroup2.trim());
                if (strGroup3 == null) {
                    throw null;
                }
                pointF = new PointF(f, Float.parseFloat(strGroup3.trim()));
                if (pointF != null) {
                    pointF2 = pointF;
                }
                matcher = zzf.matcher(strGroup4);
                if (matcher.find()) {
                    strGroup = matcher.group(1);
                    if (strGroup != null) {
                        throw null;
                    }
                    iZzd = zzalm.zzd(strGroup);
                } else {
                    iZzd = -1;
                }
                if (iZzd != -1) {
                    i = iZzd;
                }
            } catch (RuntimeException unused2) {
            }
        }
        return new zzall(i, pointF2);
    }

    public static String zzb(String str) {
        return zzc.matcher(str).replaceAll("");
    }
}
