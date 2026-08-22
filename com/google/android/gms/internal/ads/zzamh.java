package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
final class zzamh {
    public final String zza;
    public final int zzb;
    public final String zzc;
    public final Set zzd;

    private zzamh(String str, int i, String str2, Set set) {
        this.zzb = i;
        this.zza = str;
        this.zzc = str2;
        this.zzd = set;
    }

    public static zzamh zza(String str, int i) {
        String str2;
        String strTrim = str.trim();
        zzdd.zzd(!strTrim.isEmpty());
        int iIndexOf = strTrim.indexOf(" ");
        if (iIndexOf == -1) {
            str2 = "";
        } else {
            String strTrim2 = strTrim.substring(iIndexOf).trim();
            strTrim = strTrim.substring(0, iIndexOf);
            str2 = strTrim2;
        }
        String str3 = zzex.zza;
        String[] strArrSplit = strTrim.split("\\.", -1);
        String str4 = strArrSplit[0];
        HashSet hashSet = new HashSet();
        for (int i2 = 1; i2 < strArrSplit.length; i2++) {
            hashSet.add(strArrSplit[i2]);
        }
        return new zzamh(str4, i, str2, hashSet);
    }

    public static zzamh zzb() {
        return new zzamh("", 0, "", Collections.emptySet());
    }
}
