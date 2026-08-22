package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class zzhbh {
    private final ArrayDeque zza = new ArrayDeque();

    private zzhbh() {
    }

    public static /* bridge */ /* synthetic */ zzgxz zza(zzhbh zzhbhVar, zzgxz zzgxzVar, zzgxz zzgxzVar2) {
        zzhbhVar.zzb(zzgxzVar);
        zzhbhVar.zzb(zzgxzVar2);
        ArrayDeque arrayDeque = zzhbhVar.zza;
        zzgxz zzhbkVar = (zzgxz) arrayDeque.pop();
        while (!arrayDeque.isEmpty()) {
            zzhbkVar = new zzhbk((zzgxz) arrayDeque.pop(), zzhbkVar);
        }
        return zzhbkVar;
    }

    private final void zzb(zzgxz zzgxzVar) {
        if (!zzgxzVar.zzh()) {
            if (!(zzgxzVar instanceof zzhbk)) {
                throw new IllegalArgumentException("Has a new type of ByteString been created? Found ".concat(String.valueOf(zzgxzVar.getClass())));
            }
            zzhbk zzhbkVar = (zzhbk) zzgxzVar;
            zzb(zzhbkVar.zzd);
            zzb(zzhbkVar.zze);
            return;
        }
        int iZzc = zzc(zzgxzVar.zzd());
        ArrayDeque arrayDeque = this.zza;
        int iZzc2 = zzhbk.zzc(iZzc + 1);
        if (arrayDeque.isEmpty() || ((zzgxz) arrayDeque.peek()).zzd() >= iZzc2) {
            arrayDeque.push(zzgxzVar);
            return;
        }
        int iZzc3 = zzhbk.zzc(iZzc);
        zzgxz zzhbkVar2 = (zzgxz) arrayDeque.pop();
        while (!arrayDeque.isEmpty() && ((zzgxz) arrayDeque.peek()).zzd() < iZzc3) {
            zzhbkVar2 = new zzhbk((zzgxz) arrayDeque.pop(), zzhbkVar2);
        }
        zzhbk zzhbkVar3 = new zzhbk(zzhbkVar2, zzgxzVar);
        while (!arrayDeque.isEmpty()) {
            if (((zzgxz) arrayDeque.peek()).zzd() >= zzhbk.zzc(zzc(zzhbkVar3.zzd()) + 1)) {
                break;
            } else {
                zzhbkVar3 = new zzhbk((zzgxz) arrayDeque.pop(), zzhbkVar3);
            }
        }
        arrayDeque.push(zzhbkVar3);
    }

    private static final int zzc(int i) {
        int iBinarySearch = Arrays.binarySearch(zzhbk.zza, i);
        return iBinarySearch < 0 ? (-(iBinarySearch + 1)) - 1 : iBinarySearch;
    }

    public /* synthetic */ zzhbh(zzhbj zzhbjVar) {
    }
}
