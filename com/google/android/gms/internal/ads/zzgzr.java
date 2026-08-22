package com.google.android.gms.internal.ads;

import java.util.AbstractList;

/* JADX INFO: loaded from: classes.dex */
public final class zzgzr extends AbstractList {
    private final zzgzp zza;
    private final zzgzq zzb;

    public zzgzr(zzgzp zzgzpVar, zzgzq zzgzqVar) {
        this.zza = zzgzpVar;
        this.zzb = zzgzqVar;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        return this.zzb.zzb(this.zza.zzd(i));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }
}
