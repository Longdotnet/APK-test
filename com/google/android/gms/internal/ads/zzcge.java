package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzcge implements Runnable {
    final /* synthetic */ zzcgf zza;

    public zzcge(zzcgf zzcgfVar) {
        Objects.requireNonNull(zzcgfVar);
        this.zza = zzcgfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        super/*android.webkit.WebView*/.destroy();
    }
}
