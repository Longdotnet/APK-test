package com.google.android.gms.internal.ads;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes.dex */
final class zzhbc {
    public static final /* synthetic */ int zza = 0;
    private static final zzhbc zzb = new zzhbc();
    private final ConcurrentMap zzd = new ConcurrentHashMap();
    private final zzhbm zzc = new zzhak();

    private zzhbc() {
    }

    public static zzhbc zza() {
        return zzb;
    }

    public final zzhbl zzb(Class cls) {
        zzgzu.zzc(cls, "messageType");
        ConcurrentMap concurrentMap = this.zzd;
        zzhbl zzhblVarZza = (zzhbl) concurrentMap.get(cls);
        if (zzhblVarZza == null) {
            zzhblVarZza = this.zzc.zza(cls);
            zzgzu.zzc(cls, "messageType");
            zzhbl zzhblVar = (zzhbl) concurrentMap.putIfAbsent(cls, zzhblVarZza);
            if (zzhblVar != null) {
                return zzhblVar;
            }
        }
        return zzhblVarZza;
    }
}
