package com.google.android.gms.internal.location;

import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public final class zzbj {
    public static Looper zza(Looper looper) {
        return looper != null ? looper : zzb();
    }

    public static Looper zzb() {
        com.google.android.gms.common.internal.zzah.checkState(Looper.myLooper() != null, "Can't create handler inside thread that has not called Looper.prepare()");
        return Looper.myLooper();
    }
}
