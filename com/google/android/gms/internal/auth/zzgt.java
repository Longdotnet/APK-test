package com.google.android.gms.internal.auth;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
final class zzgt implements Iterator<String> {
    final Iterator<String> zza;
    final /* synthetic */ zzgu zzb;

    public zzgt(zzgu zzguVar) {
        this.zzb = zzguVar;
        this.zza = zzguVar.zza.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ String next() {
        return this.zza.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
