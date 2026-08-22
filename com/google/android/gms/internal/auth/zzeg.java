package com.google.android.gms.internal.auth;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzeg {
    static final zzeg zza = new zzeg(true);
    private static volatile boolean zzb = false;
    private static volatile zzeg zzc;
    private final Map zzd;

    public zzeg() {
        this.zzd = new HashMap();
    }

    public static zzeg zza() {
        zzeg zzegVar = zzc;
        if (zzegVar == null) {
            synchronized (zzeg.class) {
                try {
                    zzegVar = zzc;
                    if (zzegVar == null) {
                        zzegVar = zza;
                        zzc = zzegVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return zzegVar;
    }

    public zzeg(boolean z) {
        this.zzd = Collections.emptyMap();
    }
}
