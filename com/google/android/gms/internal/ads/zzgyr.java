package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzgyr {
    static final zzgyr zza = new zzgyr(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc = false;
    private static volatile zzgyr zzd;
    private final Map zze;

    public zzgyr() {
        this.zze = new HashMap();
    }

    public static zzgyr zza() {
        int i = zzhbc.zza;
        return zza;
    }

    public static zzgyr zzb() {
        zzgyr zzgyrVar = zzd;
        if (zzgyrVar != null) {
            return zzgyrVar;
        }
        synchronized (zzgyr.class) {
            try {
                zzgyr zzgyrVar2 = zzd;
                if (zzgyrVar2 != null) {
                    return zzgyrVar2;
                }
                int i = zzhbc.zza;
                zzgyr zzgyrVarZzb = zzgyz.zzb(zzgyr.class);
                zzd = zzgyrVarZzb;
                return zzgyrVarZzb;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final zzgzf zzc(zzhas zzhasVar, int i) {
        return (zzgzf) this.zze.get(new zzgyq(zzhasVar, i));
    }

    public zzgyr(boolean z) {
        this.zze = Collections.emptyMap();
    }
}
