package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzalv {
    public static zzalw zza(zzalw zzalwVar, String[] strArr, Map map) {
        int length;
        int i = 0;
        if (zzalwVar == null) {
            if (strArr == null) {
                return null;
            }
            int length2 = strArr.length;
            if (length2 == 1) {
                return (zzalw) map.get(strArr[0]);
            }
            if (length2 > 1) {
                zzalw zzalwVar2 = new zzalw();
                while (i < length2) {
                    zzalwVar2.zzl((zzalw) map.get(strArr[i]));
                    i++;
                }
                return zzalwVar2;
            }
        } else {
            if (strArr != null && strArr.length == 1) {
                zzalwVar.zzl((zzalw) map.get(strArr[0]));
                return zzalwVar;
            }
            if (strArr != null && (length = strArr.length) > 1) {
                while (i < length) {
                    zzalwVar.zzl((zzalw) map.get(strArr[i]));
                    i++;
                }
            }
        }
        return zzalwVar;
    }
}
