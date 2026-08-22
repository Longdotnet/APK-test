package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzur implements zzxb {
    private final zzfyq zza;
    private long zzb;

    public zzur(List list, List list2) {
        int i = zzfyq.zzd;
        zzfyn zzfynVar = new zzfyn();
        zzdd.zzd(list.size() == list2.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzfynVar.zzf(new zzuq((zzxb) list.get(i2), (List) list2.get(i2)));
        }
        this.zza = zzfynVar.zzi();
        this.zzb = -9223372036854775807L;
    }

    @Override // com.google.android.gms.internal.ads.zzxb
    public final long zzb() {
        int i = 0;
        long jMin = Long.MAX_VALUE;
        long jMin2 = Long.MAX_VALUE;
        while (true) {
            zzfyq zzfyqVar = this.zza;
            if (i >= zzfyqVar.size()) {
                break;
            }
            zzuq zzuqVar = (zzuq) zzfyqVar.get(i);
            long jZzb = zzuqVar.zzb();
            if ((zzuqVar.zza().contains(1) || zzuqVar.zza().contains(2) || zzuqVar.zza().contains(4)) && jZzb != Long.MIN_VALUE) {
                jMin = Math.min(jMin, jZzb);
            }
            if (jZzb != Long.MIN_VALUE) {
                jMin2 = Math.min(jMin2, jZzb);
            }
            i++;
        }
        if (jMin != Long.MAX_VALUE) {
            this.zzb = jMin;
            return jMin;
        }
        if (jMin2 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        long j = this.zzb;
        return j != -9223372036854775807L ? j : jMin2;
    }

    @Override // com.google.android.gms.internal.ads.zzxb
    public final long zzc() {
        int i = 0;
        long jMin = Long.MAX_VALUE;
        while (true) {
            zzfyq zzfyqVar = this.zza;
            if (i >= zzfyqVar.size()) {
                break;
            }
            long jZzc = ((zzuq) zzfyqVar.get(i)).zzc();
            if (jZzc != Long.MIN_VALUE) {
                jMin = Math.min(jMin, jZzc);
            }
            i++;
        }
        if (jMin == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return jMin;
    }

    @Override // com.google.android.gms.internal.ads.zzxb
    public final void zzm(long j) {
        int i = 0;
        while (true) {
            zzfyq zzfyqVar = this.zza;
            if (i >= zzfyqVar.size()) {
                return;
            }
            ((zzuq) zzfyqVar.get(i)).zzm(j);
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxb
    public final boolean zzo(zzla zzlaVar) {
        boolean zZzo;
        boolean z = false;
        do {
            long jZzc = zzc();
            if (jZzc == Long.MIN_VALUE) {
                break;
            }
            int i = 0;
            zZzo = false;
            while (true) {
                zzfyq zzfyqVar = this.zza;
                if (i >= zzfyqVar.size()) {
                    break;
                }
                long jZzc2 = ((zzuq) zzfyqVar.get(i)).zzc();
                boolean z2 = jZzc2 != Long.MIN_VALUE && jZzc2 <= zzlaVar.zza;
                if (jZzc2 == jZzc || z2) {
                    zZzo |= ((zzuq) zzfyqVar.get(i)).zzo(zzlaVar);
                }
                i++;
            }
            z |= zZzo;
        } while (zZzo);
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzxb
    public final boolean zzp() {
        int i = 0;
        while (true) {
            zzfyq zzfyqVar = this.zza;
            if (i >= zzfyqVar.size()) {
                return false;
            }
            if (((zzuq) zzfyqVar.get(i)).zzp()) {
                return true;
            }
            i++;
        }
    }
}
