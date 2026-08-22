package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzcbn implements Runnable {
    final /* synthetic */ zzcbp zza;

    public zzcbn(zzcbp zzcbpVar) {
        Objects.requireNonNull(zzcbpVar);
        this.zza = zzcbpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzK("surfaceDestroyed", new String[0]);
    }
}
