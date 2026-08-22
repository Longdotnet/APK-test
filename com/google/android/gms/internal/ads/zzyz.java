package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzyz {
    private final int[] zza;
    private final zzxk[] zzb;
    private final int[] zzc;
    private final int[][][] zzd;
    private final zzxk zze;

    public zzyz(String[] strArr, int[] iArr, zzxk[] zzxkVarArr, int[] iArr2, int[][][] iArr3, zzxk zzxkVar) {
        this.zza = iArr;
        this.zzb = zzxkVarArr;
        this.zzd = iArr3;
        this.zzc = iArr2;
        this.zze = zzxkVar;
    }

    public final int zza(int i, int i2, boolean z) {
        zzxk[] zzxkVarArr = this.zzb;
        int i3 = zzxkVarArr[i].zzb(i2).zza;
        int[] iArr = new int[i3];
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < i3; i6++) {
            if ((this.zzd[i][i2][i6] & 7) == 4) {
                iArr[i5] = i6;
                i5++;
            }
        }
        int[] iArrCopyOf = Arrays.copyOf(iArr, i5);
        String str = null;
        int i7 = 0;
        int iMin = 16;
        boolean z2 = false;
        while (i4 < iArrCopyOf.length) {
            String str2 = zzxkVarArr[i].zzb(i2).zzb(iArrCopyOf[i4]).zzo;
            int i8 = i7 + 1;
            if (i7 == 0) {
                str = str2;
            } else {
                z2 |= !Objects.equals(str, str2);
            }
            iMin = Math.min(iMin, this.zzd[i][i2][i4] & 24);
            i4++;
            i7 = i8;
        }
        return z2 ? Math.min(iMin, this.zzc[i]) : iMin;
    }

    public final int zzb(int i, int i2, int i3) {
        return this.zzd[i][i2][i3];
    }

    public final int zzc(int i) {
        return this.zza[i];
    }

    public final zzxk zzd(int i) {
        return this.zzb[i];
    }

    public final zzxk zze() {
        return this.zze;
    }
}
