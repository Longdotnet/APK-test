package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
final class zzali {
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;

    private zzali(int i, int i2, int i3, int i4, int i5, int i6) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = i4;
        this.zze = i5;
        this.zzf = i6;
    }

    public static zzali zza(String str) {
        byte b;
        zzdd.zzd(str.startsWith("Format:"));
        String[] strArrSplit = TextUtils.split(str.substring(7), ",");
        int i = 0;
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        while (true) {
            int length = strArrSplit.length;
            if (i >= length) {
                if (i3 == -1 || i4 == -1 || i6 == -1) {
                    return null;
                }
                return new zzali(i2, i3, i4, i5, i6, length);
            }
            switch (zzfuv.zza(strArrSplit[i].trim())) {
                case "end":
                    b = 2;
                    break;
                case "text":
                    b = 4;
                    break;
                case "layer":
                    b = 0;
                    break;
                case "start":
                    b = 1;
                    break;
                case "style":
                    b = 3;
                    break;
                default:
                    b = -1;
                    break;
            }
            if (b == 0) {
                i2 = i;
            } else if (b == 1) {
                i3 = i;
            } else if (b == 2) {
                i4 = i;
            } else if (b == 3) {
                i5 = i;
            } else if (b == 4) {
                i6 = i;
            }
            i++;
        }
    }
}
