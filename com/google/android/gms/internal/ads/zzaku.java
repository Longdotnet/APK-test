package com.google.android.gms.internal.ads;

import android.util.SparseArray;

/* JADX INFO: loaded from: classes.dex */
public final class zzaku implements zzady {
    private final zzady zzb;
    private final zzakr zzc;
    private final SparseArray zzd = new SparseArray();
    private boolean zze;

    public zzaku(zzady zzadyVar, zzakr zzakrVar) {
        this.zzb = zzadyVar;
        this.zzc = zzakrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzady
    public final void zzG() {
        this.zzb.zzG();
        if (!this.zze) {
            return;
        }
        int i = 0;
        while (true) {
            SparseArray sparseArray = this.zzd;
            if (i >= sparseArray.size()) {
                return;
            }
            ((zzakw) sparseArray.valueAt(i)).zzb(true);
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzady
    public final void zzP(zzaeu zzaeuVar) {
        this.zzb.zzP(zzaeuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzady
    public final zzafb zzw(int i, int i2) {
        if (i2 != 3) {
            this.zze = true;
            return this.zzb.zzw(i, i2);
        }
        SparseArray sparseArray = this.zzd;
        zzakw zzakwVar = (zzakw) sparseArray.get(i);
        if (zzakwVar != null) {
            return zzakwVar;
        }
        zzakw zzakwVar2 = new zzakw(this.zzb.zzw(i, 3), this.zzc);
        sparseArray.put(i, zzakwVar2);
        return zzakwVar2;
    }
}
