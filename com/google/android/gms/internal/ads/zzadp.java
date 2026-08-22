package com.google.android.gms.internal.ads;

import java.lang.reflect.Constructor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
final class zzadp {
    private final zzado zza;
    private final AtomicBoolean zzb = new AtomicBoolean(false);

    public zzadp(zzado zzadoVar) {
        this.zza = zzadoVar;
    }

    public final zzadv zza(Object... objArr) {
        Constructor constructorZza;
        AtomicBoolean atomicBoolean = this.zzb;
        synchronized (atomicBoolean) {
            if (!atomicBoolean.get()) {
                try {
                    constructorZza = this.zza.zza();
                } catch (ClassNotFoundException unused) {
                    this.zzb.set(true);
                    constructorZza = null;
                } catch (Exception e) {
                    throw new RuntimeException("Error instantiating extension", e);
                }
            }
            constructorZza = null;
        }
        if (constructorZza == null) {
            return null;
        }
        try {
            return (zzadv) constructorZza.newInstance(objArr);
        } catch (Exception e2) {
            throw new IllegalStateException("Unexpected error creating extractor", e2);
        }
    }
}
