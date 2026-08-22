package com.google.android.gms.internal.games_v2;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline0;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
final class zzii extends zzhk {
    final transient Object zza;

    public zzii(Object obj) {
        obj.getClass();
        this.zza = obj;
    }

    @Override // com.google.android.gms.internal.games_v2.zzgy, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.zza.equals(obj);
    }

    @Override // com.google.android.gms.internal.games_v2.zzhk, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.zza.hashCode();
    }

    @Override // com.google.android.gms.internal.games_v2.zzhk, com.google.android.gms.internal.games_v2.zzgy, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzho(this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        String string = this.zza.toString();
        return Fragment$$ExternalSyntheticOutline0.m(new StringBuilder(String.valueOf(string).length() + 2), "[", string, "]");
    }

    @Override // com.google.android.gms.internal.games_v2.zzhk, com.google.android.gms.internal.games_v2.zzgy
    /* JADX INFO: renamed from: zza */
    public final zzil iterator() {
        return new zzho(this.zza);
    }

    @Override // com.google.android.gms.internal.games_v2.zzgy
    public final int zze(Object[] objArr, int i) {
        objArr[0] = this.zza;
        return 1;
    }
}
