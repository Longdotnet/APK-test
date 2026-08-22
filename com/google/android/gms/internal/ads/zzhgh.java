package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzhgh implements Iterator {
    int zza = 0;
    final /* synthetic */ zzhgi zzb;

    public zzhgh(zzhgi zzhgiVar) {
        this.zzb = zzhgiVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.zza;
        zzhgi zzhgiVar = this.zzb;
        return i < zzhgiVar.zza.size() || zzhgiVar.zzb.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.zza;
        zzhgi zzhgiVar = this.zzb;
        List list = zzhgiVar.zza;
        if (i >= list.size()) {
            list.add(zzhgiVar.zzb.next());
            return next();
        }
        int i2 = this.zza;
        this.zza = i2 + 1;
        return list.get(i2);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
