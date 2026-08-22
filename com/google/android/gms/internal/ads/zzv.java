package com.google.android.gms.internal.ads;

import android.os.Build;
import android.util.SparseBooleanArray;

/* JADX INFO: loaded from: classes.dex */
public final class zzv {
    private final SparseBooleanArray zza;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzv)) {
            return false;
        }
        zzv zzvVar = (zzv) obj;
        if (Build.VERSION.SDK_INT >= 24) {
            return this.zza.equals(zzvVar.zza);
        }
        SparseBooleanArray sparseBooleanArray = this.zza;
        if (sparseBooleanArray.size() != zzvVar.zza.size()) {
            return false;
        }
        for (int i = 0; i < sparseBooleanArray.size(); i++) {
            if (zza(i) != zzvVar.zza(i)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        if (Build.VERSION.SDK_INT >= 24) {
            return this.zza.hashCode();
        }
        SparseBooleanArray sparseBooleanArray = this.zza;
        int size = sparseBooleanArray.size();
        for (int i = 0; i < sparseBooleanArray.size(); i++) {
            size = (size * 31) + zza(i);
        }
        return size;
    }

    public final int zza(int i) {
        SparseBooleanArray sparseBooleanArray = this.zza;
        zzdd.zza(i, 0, sparseBooleanArray.size());
        return sparseBooleanArray.keyAt(i);
    }

    public final int zzb() {
        return this.zza.size();
    }

    public final boolean zzc(int i) {
        return this.zza.get(i);
    }
}
