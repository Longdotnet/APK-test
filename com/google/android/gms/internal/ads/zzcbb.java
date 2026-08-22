package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzcbb implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ zzcbf zzc;

    public zzcbb(zzcbf zzcbfVar, int i, int i2) {
        this.zza = i;
        this.zzb = i2;
        Objects.requireNonNull(zzcbfVar);
        this.zzc = zzcbfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcbf zzcbfVar = this.zzc;
        if (zzcbfVar.zzr != null) {
            zzcbfVar.zzr.zzj(this.zza, this.zzb);
        }
    }
}
