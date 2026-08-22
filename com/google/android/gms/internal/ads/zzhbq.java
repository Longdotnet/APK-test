package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzhbq implements Iterator {
    final /* synthetic */ zzhbt zza;
    private int zzb;
    private boolean zzc;
    private Iterator zzd;

    public /* synthetic */ zzhbq(zzhbt zzhbtVar, zzhbs zzhbsVar) {
        Objects.requireNonNull(zzhbtVar);
        this.zza = zzhbtVar;
        this.zzb = -1;
    }

    private final Iterator zza() {
        if (this.zzd == null) {
            this.zzd = this.zza.zzc.entrySet().iterator();
        }
        return this.zzd;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.zzb + 1;
        zzhbt zzhbtVar = this.zza;
        if (i >= zzhbtVar.zzb) {
            return !zzhbtVar.zzc.isEmpty() && zza().hasNext();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        this.zzc = true;
        int i = this.zzb + 1;
        this.zzb = i;
        zzhbt zzhbtVar = this.zza;
        return i < zzhbtVar.zzb ? (zzhbp) zzhbtVar.zza[i] : (Map.Entry) zza().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.zzc) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzc = false;
        zzhbt zzhbtVar = this.zza;
        zzhbtVar.zzo();
        int i = this.zzb;
        if (i >= zzhbtVar.zzb) {
            zza().remove();
        } else {
            this.zzb = i - 1;
            zzhbtVar.zzm(i);
        }
    }
}
