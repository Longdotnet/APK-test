package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class zzgda extends zzgcn {
    private zzgcz zza;

    public zzgda(zzfyl zzfylVar, boolean z, Executor executor, Callable callable) {
        super(zzfylVar, z, false);
        this.zza = new zzgcy(this, callable, executor);
        zzz();
    }

    @Override // com.google.android.gms.internal.ads.zzgcn
    public final void zzA(int i) {
        super.zzA(i);
        if (i == 1) {
            this.zza = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgcb
    public final void zzk() {
        zzgcz zzgczVar = this.zza;
        if (zzgczVar != null) {
            zzgczVar.zzh();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgcn
    public final void zzx(int i, Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzgcn
    public final void zzy() {
        zzgcz zzgczVar = this.zza;
        if (zzgczVar != null) {
            zzgczVar.zzf();
        }
    }
}
