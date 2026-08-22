package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
final class zzas implements Iterator {
    final /* synthetic */ zzat zza;
    private int zzb = 0;

    public zzas(zzat zzatVar) {
        this.zza = zzatVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb < this.zza.zza.length();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        int i = this.zzb;
        zzat zzatVar = this.zza;
        if (i >= zzatVar.zza.length()) {
            throw new NoSuchElementException();
        }
        String str = zzatVar.zza;
        this.zzb = i + 1;
        return new zzat(String.valueOf(str.charAt(i)));
    }
}
