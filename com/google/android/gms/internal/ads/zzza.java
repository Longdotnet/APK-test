package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzza extends zzzd {
    public abstract Pair zzd(zzyz zzyzVar, int[][][] iArr, int[] iArr2, zzvh zzvhVar, zzbl zzblVar);

    @Override // com.google.android.gms.internal.ads.zzzd
    public final zzze zzo(zzmd[] zzmdVarArr, zzxk zzxkVar, zzvh zzvhVar, zzbl zzblVar) {
        List[] listArr;
        boolean z;
        int[] iArr;
        int[] iArr2 = new int[3];
        zzbm[][] zzbmVarArr = new zzbm[3][];
        int[][][] iArr3 = new int[3][][];
        for (int i = 0; i < 3; i++) {
            int i2 = zzxkVar.zzb;
            zzbmVarArr[i] = new zzbm[i2];
            iArr3[i] = new int[i2][];
        }
        int i3 = 2;
        int[] iArr4 = new int[2];
        for (int i4 = 0; i4 < 2; i4++) {
            iArr4[i4] = zzmdVarArr[i4].zze();
        }
        int i5 = 0;
        while (i5 < zzxkVar.zzb) {
            zzbm zzbmVarZzb = zzxkVar.zzb(i5);
            int i6 = zzbmVarZzb.zzc;
            int i7 = i3;
            int i8 = 0;
            int i9 = 0;
            boolean z2 = true;
            while (i8 < i3) {
                zzmd zzmdVar = zzmdVarArr[i8];
                int iMax = 0;
                for (int i10 = 0; i10 < zzbmVarZzb.zza; i10++) {
                    iMax = Math.max(iMax, zzmdVar.zzZ(zzbmVarZzb.zzb(i10)) & 7);
                }
                boolean z3 = iArr2[i8] == 0;
                if (iMax > i9) {
                    z2 = z3;
                    i7 = i8;
                    i9 = iMax;
                } else if (iMax == i9 && i6 == 5 && !z2 && z3) {
                    i7 = i8;
                    i9 = iMax;
                    z2 = true;
                }
                i8++;
                i3 = 2;
            }
            if (i7 == i3) {
                iArr = new int[zzbmVarZzb.zza];
            } else {
                zzmd zzmdVar2 = zzmdVarArr[i7];
                int i11 = zzbmVarZzb.zza;
                int[] iArr5 = new int[i11];
                for (int i12 = 0; i12 < i11; i12++) {
                    iArr5[i12] = zzmdVar2.zzZ(zzbmVarZzb.zzb(i12));
                }
                iArr = iArr5;
            }
            int i13 = iArr2[i7];
            zzbmVarArr[i7][i13] = zzbmVarZzb;
            iArr3[i7][i13] = iArr;
            iArr2[i7] = i13 + 1;
            i5++;
            i3 = 2;
        }
        int i14 = i3;
        boolean z4 = true;
        zzxk[] zzxkVarArr = new zzxk[i14];
        String[] strArr = new String[i14];
        int[] iArr6 = new int[i14];
        int i15 = 0;
        while (i15 < i14) {
            int i16 = iArr2[i15];
            zzxkVarArr[i15] = new zzxk((zzbm[]) zzex.zzQ(zzbmVarArr[i15], i16));
            iArr3[i15] = (int[][]) zzex.zzQ(iArr3[i15], i16);
            strArr[i15] = zzmdVarArr[i15].zzV();
            iArr6[i15] = zzmdVarArr[i15].zzb();
            i15++;
            i14 = 2;
        }
        int i17 = i14;
        zzyz zzyzVar = new zzyz(strArr, iArr6, zzxkVarArr, iArr4, iArr3, new zzxk((zzbm[]) zzex.zzQ(zzbmVarArr[i17], iArr2[i17])));
        Pair pairZzd = zzd(zzyzVar, iArr3, iArr4, zzvhVar, zzblVar);
        zzzb[] zzzbVarArr = (zzzb[]) pairZzd.second;
        List[] listArr2 = new List[zzzbVarArr.length];
        for (int i18 = 0; i18 < zzzbVarArr.length; i18++) {
            zzzb zzzbVar = zzzbVarArr[i18];
            listArr2[i18] = zzzbVar != null ? zzfyq.zzo(zzzbVar) : zzfyq.zzn();
        }
        zzfyn zzfynVar = new zzfyn();
        int i19 = 0;
        for (int i20 = 2; i19 < i20; i20 = 2) {
            zzxk zzxkVarZzd = zzyzVar.zzd(i19);
            List list = listArr2[i19];
            int i21 = 0;
            while (i21 < zzxkVarZzd.zzb) {
                zzbm zzbmVarZzb2 = zzxkVarZzd.zzb(i21);
                boolean z5 = zzyzVar.zza(i19, i21, false) != 0 ? z4 : false;
                int i22 = zzbmVarZzb2.zza;
                int[] iArr7 = new int[i22];
                boolean[] zArr = new boolean[i22];
                int i23 = 0;
                while (i23 < i22) {
                    iArr7[i23] = zzyzVar.zzb(i19, i21, i23) & 7;
                    int i24 = 0;
                    while (true) {
                        if (i24 >= list.size()) {
                            listArr = listArr2;
                            z = false;
                            break;
                        }
                        zzzb zzzbVar2 = (zzzb) list.get(i24);
                        listArr = listArr2;
                        if (zzzbVar2.zzc().equals(zzbmVarZzb2) && zzzbVar2.zzg(i23) != -1) {
                            z = true;
                            break;
                        }
                        i24++;
                        listArr2 = listArr;
                    }
                    zArr[i23] = z;
                    i23++;
                    listArr2 = listArr;
                }
                zzfynVar.zzf(new zzbs(zzbmVarZzb2, z5, iArr7, zArr));
                i21++;
                z4 = true;
            }
            i19++;
            z4 = true;
        }
        zzxk zzxkVarZze = zzyzVar.zze();
        for (int i25 = 0; i25 < zzxkVarZze.zzb; i25++) {
            zzbm zzbmVarZzb3 = zzxkVarZze.zzb(i25);
            int i26 = zzbmVarZzb3.zza;
            int[] iArr8 = new int[i26];
            Arrays.fill(iArr8, 0);
            zzfynVar.zzf(new zzbs(zzbmVarZzb3, false, iArr8, new boolean[i26]));
        }
        return new zzze((zzme[]) pairZzd.first, (zzyw[]) pairZzd.second, new zzbt(zzfynVar.zzi()), zzyzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final void zzp(Object obj) {
    }
}
