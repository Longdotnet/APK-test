package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzamp implements zzako {
    private final List zza;
    private final long[] zzb;
    private final long[] zzc;

    public zzamp(List list) {
        this.zza = Collections.unmodifiableList(new ArrayList(list));
        int size = list.size();
        this.zzb = new long[size + size];
        for (int i = 0; i < list.size(); i++) {
            zzame zzameVar = (zzame) list.get(i);
            long[] jArr = this.zzb;
            int i2 = i + i;
            jArr[i2] = zzameVar.zzb;
            jArr[i2 + 1] = zzameVar.zzc;
        }
        long[] jArr2 = this.zzb;
        long[] jArrCopyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.zzc = jArrCopyOf;
        Arrays.sort(jArrCopyOf);
    }

    @Override // com.google.android.gms.internal.ads.zzako
    public final int zza() {
        return this.zzc.length;
    }

    @Override // com.google.android.gms.internal.ads.zzako
    public final long zzb(int i) {
        zzdd.zzd(i >= 0);
        long[] jArr = this.zzc;
        zzdd.zzd(i < jArr.length);
        return jArr[i];
    }

    @Override // com.google.android.gms.internal.ads.zzako
    public final List zzc(long j) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        while (true) {
            List list = this.zza;
            if (i >= list.size()) {
                break;
            }
            long[] jArr = this.zzb;
            int i2 = i + i;
            if (jArr[i2] <= j && j < jArr[i2 + 1]) {
                zzame zzameVar = (zzame) list.get(i);
                zzcu zzcuVar = zzameVar.zza;
                if (zzcuVar.zze == -3.4028235E38f) {
                    arrayList2.add(zzameVar);
                } else {
                    arrayList.add(zzcuVar);
                }
            }
            i++;
        }
        Collections.sort(arrayList2, new Comparator() { // from class: com.google.android.gms.internal.ads.zzamo
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return Long.compare(((zzame) obj).zzb, ((zzame) obj2).zzb);
            }
        });
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            zzcs zzcsVarZzb = ((zzame) arrayList2.get(i3)).zza.zzb();
            zzcsVarZzb.zze((-1) - i3, 1);
            arrayList.add(zzcsVarZzb.zzq());
        }
        return arrayList;
    }
}
