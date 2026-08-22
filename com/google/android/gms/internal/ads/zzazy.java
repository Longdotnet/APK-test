package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzazy implements Runnable {
    final /* synthetic */ View zza;
    final /* synthetic */ zzbac zzb;

    public zzazy(zzbac zzbacVar, View view) {
        this.zza = view;
        Objects.requireNonNull(zzbacVar);
        this.zzb = zzbacVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzb(this.zza);
    }
}
