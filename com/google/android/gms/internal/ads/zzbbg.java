package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzbbg implements Runnable {
    final /* synthetic */ zzbbk zza;

    public zzbbg(zzbbk zzbbkVar) {
        Objects.requireNonNull(zzbbkVar);
        this.zza = zzbbkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbbk.zzh(this.zza);
    }
}
