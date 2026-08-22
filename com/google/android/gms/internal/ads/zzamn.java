package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.common.Ko.TSDAbK;
import kotlinx.coroutines.internal.Jbo.ygoi;

/* JADX INFO: loaded from: classes2.dex */
public final class zzamn {
    public static long zzb(String str) {
        String str2 = zzex.zza;
        String[] strArrSplit = str.split("\\.", 2);
        long j = 0;
        for (String str3 : strArrSplit[0].split(":", -1)) {
            j = (j * 60) + Long.parseLong(str3);
        }
        long j2 = j * 1000;
        if (strArrSplit.length == 2) {
            String strTrim = strArrSplit[1].trim();
            if (strTrim.length() != 3) {
                throw new IllegalArgumentException(ygoi.yfTBZxBJXMSNYn.concat(strTrim));
            }
            j2 += Long.parseLong(strTrim);
        }
        return j2 * 1000;
    }

    public static float zza(String str) {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException(TSDAbK.tnL);
    }
}
