package com.google.android.gms.internal.games_v2;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
final class zzho extends zzil {
    private final Object zza;
    private boolean zzb;

    public zzho(Object obj) {
        this.zza = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.zzb;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.zzb) {
            throw new NoSuchElementException();
        }
        this.zzb = true;
        return this.zza;
    }
}
