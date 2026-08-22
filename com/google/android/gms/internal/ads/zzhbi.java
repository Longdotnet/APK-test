package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
final class zzhbi implements Iterator {
    private final ArrayDeque zza;
    private zzgxv zzb;

    public /* synthetic */ zzhbi(zzgxz zzgxzVar, zzhbj zzhbjVar) {
        if (!(zzgxzVar instanceof zzhbk)) {
            this.zza = null;
            this.zzb = (zzgxv) zzgxzVar;
            return;
        }
        zzhbk zzhbkVar = (zzhbk) zzgxzVar;
        ArrayDeque arrayDeque = new ArrayDeque(zzhbkVar.zzf());
        this.zza = arrayDeque;
        arrayDeque.push(zzhbkVar);
        this.zzb = zzb(zzhbkVar.zzd);
    }

    private final zzgxv zzb(zzgxz zzgxzVar) {
        while (zzgxzVar instanceof zzhbk) {
            zzhbk zzhbkVar = (zzhbk) zzgxzVar;
            this.zza.push(zzhbkVar);
            zzgxzVar = zzhbkVar.zzd;
        }
        return (zzgxv) zzgxzVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb != null;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzgxv next() {
        zzgxv zzgxvVarZzb;
        zzgxv zzgxvVar = this.zzb;
        if (zzgxvVar == null) {
            throw new NoSuchElementException();
        }
        do {
            ArrayDeque arrayDeque = this.zza;
            zzgxvVarZzb = null;
            if (arrayDeque == null || arrayDeque.isEmpty()) {
                break;
            }
            zzgxvVarZzb = zzb(((zzhbk) arrayDeque.pop()).zze);
        } while (zzgxvVarZzb.zzd() == 0);
        this.zzb = zzgxvVarZzb;
        return zzgxvVar;
    }
}
