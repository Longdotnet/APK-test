package com.google.android.gms.internal.ads;

import android.os.Looper;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzcbw implements Runnable {
    public zzcbw(zzcby zzcbyVar) {
        Objects.requireNonNull(zzcbyVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Looper.myLooper().quit();
    }
}
