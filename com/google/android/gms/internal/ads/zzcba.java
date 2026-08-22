package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzcba implements Runnable {
    final /* synthetic */ zzcbf zza;

    public zzcba(zzcbf zzcbfVar) {
        Objects.requireNonNull(zzcbfVar);
        this.zza = zzcbfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcbf zzcbfVar = this.zza;
        if (zzcbfVar.zzr != null) {
            zzcbfVar.zzr.zzh();
        }
    }
}
