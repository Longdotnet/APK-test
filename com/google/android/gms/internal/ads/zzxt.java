package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public class zzxt implements zzyw {
    protected final zzbm zza;
    protected final int zzb;
    protected final int[] zzc;
    private final zzz[] zzd;
    private int zze;

    public zzxt(zzbm zzbmVar, int[] iArr, int i) {
        int length = iArr.length;
        zzdd.zzf(length > 0);
        zzbmVar.getClass();
        this.zza = zzbmVar;
        this.zzb = length;
        this.zzd = new zzz[length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            this.zzd[i2] = zzbmVar.zzb(iArr[i2]);
        }
        Arrays.sort(this.zzd, new Comparator() { // from class: com.google.android.gms.internal.ads.zzxs
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((zzz) obj2).zzj - ((zzz) obj).zzj;
            }
        });
        this.zzc = new int[this.zzb];
        for (int i3 = 0; i3 < this.zzb; i3++) {
            this.zzc[i3] = zzbmVar.zza(this.zzd[i3]);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzxt zzxtVar = (zzxt) obj;
            if (this.zza.equals(zzxtVar.zza) && Arrays.equals(this.zzc, zzxtVar.zzc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zze;
        if (i != 0) {
            return i;
        }
        int iHashCode = Arrays.hashCode(this.zzc) + (System.identityHashCode(this.zza) * 31);
        this.zze = iHashCode;
        return iHashCode;
    }

    @Override // com.google.android.gms.internal.ads.zzzb
    public final zzz zza(int i) {
        return this.zzd[i];
    }

    @Override // com.google.android.gms.internal.ads.zzyw
    public final zzz zzb() {
        return this.zzd[0];
    }

    @Override // com.google.android.gms.internal.ads.zzzb
    public final zzbm zzc() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzzb
    public final int zze(int i) {
        return this.zzc[i];
    }

    @Override // com.google.android.gms.internal.ads.zzyw
    public final int zzf() {
        return this.zzc[0];
    }

    @Override // com.google.android.gms.internal.ads.zzzb
    public final int zzg(int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            if (this.zzc[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzzb
    public final int zzh() {
        return this.zzc.length;
    }
}
