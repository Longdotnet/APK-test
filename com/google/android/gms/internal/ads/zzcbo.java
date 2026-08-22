package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzcbo implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzcbp zzb;

    public zzcbo(zzcbp zzcbpVar, boolean z) {
        this.zza = z;
        Objects.requireNonNull(zzcbpVar);
        this.zzb = zzcbpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzK("windowVisibilityChanged", "isVisible", String.valueOf(this.zza));
    }
}
