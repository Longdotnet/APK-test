package com.google.android.gms.internal.ads;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
abstract class zzfxu implements Iterator {
    int zzb;
    int zzc;
    int zzd;
    final /* synthetic */ zzfxz zze;

    public /* synthetic */ zzfxu(zzfxz zzfxzVar, zzfxy zzfxyVar) {
        Objects.requireNonNull(zzfxzVar);
        this.zze = zzfxzVar;
        this.zzb = zzfxzVar.zzf;
        this.zzc = zzfxzVar.zze();
        this.zzd = -1;
    }

    private final void zzb() {
        if (this.zze.zzf != this.zzb) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzc >= 0;
    }

    @Override // java.util.Iterator
    public final Object next() {
        zzb();
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.zzc;
        this.zzd = i;
        Object objZza = zza(i);
        this.zzc = this.zze.zzf(this.zzc);
        return objZza;
    }

    @Override // java.util.Iterator
    public final void remove() {
        zzb();
        zzfvp.zzm(this.zzd >= 0, "no calls to next() since the last call to remove()");
        this.zzb += 32;
        int i = this.zzd;
        zzfxz zzfxzVar = this.zze;
        zzfxzVar.remove(zzfxz.zzg(zzfxzVar, i));
        this.zzc--;
        this.zzd = -1;
    }

    public abstract Object zza(int i);
}
