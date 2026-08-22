package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzcbd implements Runnable {
    final /* synthetic */ zzcbf zza;

    public zzcbd(zzcbf zzcbfVar) {
        Objects.requireNonNull(zzcbfVar);
        this.zza = zzcbfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcbf zzcbfVar = this.zza;
        if (zzcbfVar.zzr != null) {
            if (!zzcbfVar.zzs) {
                zzcbfVar.zzr.zzg();
                zzcbfVar.zzs = true;
            }
            zzcbfVar.zzr.zze();
        }
    }
}
