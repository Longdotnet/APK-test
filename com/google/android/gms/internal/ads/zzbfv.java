package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class zzbfv {
    private static final AtomicReference zza = new AtomicReference();
    private static final AtomicReference zzb = new AtomicReference();

    static {
        new AtomicBoolean();
    }

    public static zzbft zza() {
        return (zzbft) zza.get();
    }

    public static zzbfu zzb() {
        return (zzbfu) zzb.get();
    }

    public static void zzc(zzbft zzbftVar) {
        zza.set(zzbftVar);
    }
}
