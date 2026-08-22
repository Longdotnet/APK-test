package com.google.android.gms.internal.ads;

import android.webkit.WebView;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzfnb implements Runnable {
    final /* synthetic */ zzfnc zza;
    private final WebView zzb;

    public zzfnb(zzfnc zzfncVar) {
        Objects.requireNonNull(zzfncVar);
        this.zza = zzfncVar;
        this.zzb = zzfncVar.zza;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.destroy();
    }
}
