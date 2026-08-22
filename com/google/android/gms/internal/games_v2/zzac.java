package com.google.android.gms.internal.games_v2;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzac {
    private final AtomicReference zza = new AtomicReference();

    public abstract zzab zza();

    public final void zzb() {
        zzab zzabVar = (zzab) this.zza.get();
        if (zzabVar != null) {
            zzabVar.zzc();
        }
    }

    public final void zzc(String str, int i) {
        AtomicReference atomicReference = this.zza;
        zzab zzabVar = (zzab) atomicReference.get();
        if (zzabVar == null) {
            zzab zzabVarZza = zza();
            while (!atomicReference.compareAndSet(null, zzabVarZza)) {
                if (atomicReference.get() != null) {
                    zzabVar = (zzab) atomicReference.get();
                }
            }
            zzabVar = zzabVarZza;
        }
        zzabVar.zzb(str, i);
    }
}
