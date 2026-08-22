package com.google.android.gms.internal.play_billing;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes.dex */
final class zzel {
    private static final zzel zza = new zzel();
    private final ConcurrentMap zzc = new ConcurrentHashMap();
    private final zzep zzb = new zzdu();

    private zzel() {
    }

    public static zzel zza() {
        return zza;
    }

    public final zzeo zzb(Class cls) {
        zzda.zzc(cls, "messageType");
        zzeo zzeoVarZza = (zzeo) this.zzc.get(cls);
        if (zzeoVarZza == null) {
            zzeoVarZza = this.zzb.zza(cls);
            zzda.zzc(cls, "messageType");
            zzeo zzeoVar = (zzeo) this.zzc.putIfAbsent(cls, zzeoVarZza);
            if (zzeoVar != null) {
                return zzeoVar;
            }
        }
        return zzeoVarZza;
    }
}
