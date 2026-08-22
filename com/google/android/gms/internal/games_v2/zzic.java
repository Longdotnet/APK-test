package com.google.android.gms.internal.games_v2;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
final class zzic extends zzhk {
    private final transient zzhg zza;
    private final transient zzhd zzb;

    public zzic(zzhg zzhgVar, zzhd zzhdVar) {
        this.zza = zzhgVar;
        this.zzb = zzhdVar;
    }

    @Override // com.google.android.gms.internal.games_v2.zzgy, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.zza.get(obj) != null;
    }

    @Override // com.google.android.gms.internal.games_v2.zzhk, com.google.android.gms.internal.games_v2.zzgy, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return this.zzb.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.games_v2.zzhk, com.google.android.gms.internal.games_v2.zzgy
    /* JADX INFO: renamed from: zza */
    public final zzil iterator() {
        return this.zzb.listIterator(0);
    }

    @Override // com.google.android.gms.internal.games_v2.zzgy
    public final int zze(Object[] objArr, int i) {
        return this.zzb.zze(objArr, 0);
    }
}
