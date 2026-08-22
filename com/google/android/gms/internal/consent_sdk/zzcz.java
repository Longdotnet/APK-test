package com.google.android.gms.internal.consent_sdk;

import com.google.android.gms.internal.common.Ko.TSDAbK;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
abstract class zzcz extends zzdl {
    private final int zza;
    private int zzb;

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.zzb < this.zza;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.zzb > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.zzb;
        this.zzb = i + 1;
        return zza(i);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.zzb;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i = this.zzb - 1;
        this.zzb = i;
        return zza(i);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.zzb - 1;
    }

    public abstract Object zza(int i);

    public zzcz(int i, int i2) {
        zzcx.zzb(i2, i, TSDAbK.HuUHklXiCyFh);
        this.zza = i;
        this.zzb = i2;
    }
}
