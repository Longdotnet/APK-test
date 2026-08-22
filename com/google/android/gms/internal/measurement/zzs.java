package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzs extends zzai {
    final boolean zza;
    final boolean zzb;
    final /* synthetic */ zzt zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzs(zzt zztVar, boolean z, boolean z2) {
        super("log");
        this.zzc = zztVar;
        this.zza = z;
        this.zzb = z2;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0070  */
    /* JADX WARN: Code duplicated, block: B:22:0x0084  */
    /* JADX WARN: Code duplicated, block: B:25:0x0093 A[LOOP:0: B:23:0x0089->B:25:0x0093, LOOP_END] */
    @Override // com.google.android.gms.internal.measurement.zzai
    public final zzap zza(zzg zzgVar, List list) {
        int i;
        int i2;
        String strZzi;
        ArrayList arrayList;
        zzh.zzi("log", 1, list);
        if (list.size() == 1) {
            this.zzc.zza.zza(3, zzgVar.zzb((zzap) list.get(0)).zzi(), Collections.emptyList(), this.zza, this.zzb);
            return zzap.zzf;
        }
        int iZzb = zzh.zzb(zzgVar.zzb((zzap) list.get(0)).zzh().doubleValue());
        if (iZzb != 2) {
            i = 3;
            if (iZzb == 3) {
                i2 = 1;
            } else if (iZzb == 5) {
                i2 = 5;
            } else if (iZzb == 6) {
                i2 = 2;
            }
            strZzi = zzgVar.zzb((zzap) list.get(1)).zzi();
            if (list.size() == 2) {
                this.zzc.zza.zza(i2, strZzi, Collections.emptyList(), this.zza, this.zzb);
                return zzap.zzf;
            }
            arrayList = new ArrayList();
            for (int i3 = 2; i3 < Math.min(list.size(), 5); i3++) {
                arrayList.add(zzgVar.zzb((zzap) list.get(i3)).zzi());
            }
            this.zzc.zza.zza(i2, strZzi, arrayList, this.zza, this.zzb);
            return zzap.zzf;
        }
        i = 4;
        i2 = i;
        strZzi = zzgVar.zzb((zzap) list.get(1)).zzi();
        if (list.size() == 2) {
            this.zzc.zza.zza(i2, strZzi, Collections.emptyList(), this.zza, this.zzb);
            return zzap.zzf;
        }
        arrayList = new ArrayList();
        while (i3 < Math.min(list.size(), 5)) {
            arrayList.add(zzgVar.zzb((zzap) list.get(i3)).zzi());
        }
        this.zzc.zza.zza(i2, strZzi, arrayList, this.zza, this.zzb);
        return zzap.zzf;
    }
}
