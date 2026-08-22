package com.google.android.gms.internal.ads;

import android.graphics.Color;
import com.google.zxing.BarcodeFormat$EnumUnboxingLocalUtility;

/* JADX INFO: loaded from: classes.dex */
final class zzalm {
    public final String zza;
    public final int zzb;
    public final Integer zzc;
    public final Integer zzd;
    public final float zze;
    public final boolean zzf;
    public final boolean zzg;
    public final boolean zzh;
    public final boolean zzi;
    public final int zzj;

    private zzalm(String str, int i, Integer num, Integer num2, float f, boolean z, boolean z2, boolean z3, boolean z4, int i2) {
        this.zza = str;
        this.zzb = i;
        this.zzc = num;
        this.zzd = num2;
        this.zze = f;
        this.zzf = z;
        this.zzg = z2;
        this.zzh = z3;
        this.zzi = z4;
        this.zzj = i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x0110, code lost:
    
        if (r4 != 3) goto L60;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.ads.zzalm zzb(java.lang.String r20, com.google.android.gms.internal.ads.zzalk r21) {
        /*
            Method dump skipped, instruction units count: 323
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzalm.zzb(java.lang.String, com.google.android.gms.internal.ads.zzalk):com.google.android.gms.internal.ads.zzalm");
    }

    public static Integer zzc(String str) {
        try {
            long j = str.startsWith("&H") ? Long.parseLong(str.substring(2), 16) : Long.parseLong(str);
            zzdd.zzd(j <= 4294967295L);
            return Integer.valueOf(Color.argb(zzgbt.zzb(((j >> 24) & 255) ^ 255), zzgbt.zzb(j & 255), zzgbt.zzb((j >> 8) & 255), zzgbt.zzb((j >> 16) & 255)));
        } catch (IllegalArgumentException e) {
            zzea.zzg("SsaStyle", "Failed to parse color expression: '" + str + "'", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzd(String str) {
        try {
            int i = Integer.parseInt(str.trim());
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    return i;
                default:
                    BarcodeFormat$EnumUnboxingLocalUtility.m(str, "Ignoring unknown alignment: ", "SsaStyle");
                    return -1;
            }
        } catch (NumberFormatException unused) {
        }
    }

    private static boolean zze(String str) {
        try {
            int i = Integer.parseInt(str);
            return i == 1 || i == -1;
        } catch (NumberFormatException e) {
            zzea.zzg("SsaStyle", "Failed to parse boolean value: '" + str + "'", e);
            return false;
        }
    }
}
