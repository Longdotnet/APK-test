package com.google.android.gms.internal.ads;

import android.util.SparseArray;

/* JADX INFO: loaded from: classes.dex */
public final class zzmq {
    private final zzv zza;
    private final SparseArray zzb;

    public zzmq(zzv zzvVar, SparseArray sparseArray) {
        this.zza = zzvVar;
        SparseArray sparseArray2 = new SparseArray(zzvVar.zzb());
        for (int i = 0; i < zzvVar.zzb(); i++) {
            int iZza = zzvVar.zza(i);
            zzmp zzmpVar = (zzmp) sparseArray.get(iZza);
            zzmpVar.getClass();
            sparseArray2.append(iZza, zzmpVar);
        }
        this.zzb = sparseArray2;
    }

    public final int zza(int i) {
        return this.zza.zza(i);
    }

    public final int zzb() {
        return this.zza.zzb();
    }

    public final zzmp zzc(int i) {
        zzmp zzmpVar = (zzmp) this.zzb.get(i);
        zzmpVar.getClass();
        return zzmpVar;
    }

    public final boolean zzd(int i) {
        return this.zza.zzc(i);
    }
}
