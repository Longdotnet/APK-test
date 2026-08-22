package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzblz implements Runnable {
    final /* synthetic */ zzbmc zza;

    public zzblz(zzbmc zzbmcVar) {
        Objects.requireNonNull(zzbmcVar);
        this.zza = zzbmcVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbmc.zzc(this.zza);
    }
}
