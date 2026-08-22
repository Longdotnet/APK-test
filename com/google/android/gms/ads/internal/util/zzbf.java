package com.google.android.gms.ads.internal.util;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzbf {
    public ArrayList zza;
    public ArrayList zzb;
    public ArrayList zzc;

    public void zza(String str, double d, double d2) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        int i = 0;
        while (true) {
            arrayList = this.zza;
            int size = arrayList.size();
            arrayList2 = this.zzb;
            arrayList3 = this.zzc;
            if (i >= size) {
                break;
            }
            double dDoubleValue = ((Double) arrayList3.get(i)).doubleValue();
            double dDoubleValue2 = ((Double) arrayList2.get(i)).doubleValue();
            if (d < dDoubleValue || (dDoubleValue == d && d2 < dDoubleValue2)) {
                break;
            } else {
                i++;
            }
        }
        arrayList.add(i, str);
        arrayList3.add(i, Double.valueOf(d));
        arrayList2.add(i, Double.valueOf(d2));
    }
}
