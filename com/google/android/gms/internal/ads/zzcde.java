package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzcde implements Runnable {
    final /* synthetic */ zzcdf zza;

    public zzcde(zzcdf zzcdfVar) {
        Objects.requireNonNull(zzcdfVar);
        this.zza = zzcdfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.ads.internal.zzv.zza.zzD.zzc(this.zza);
    }
}
