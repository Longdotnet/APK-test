package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzgc {
    private final Class zza;
    private final Map zzb;
    private final Class zzc;

    @SafeVarargs
    public zzgc(Class cls, zzgw... zzgwVarArr) {
        this.zza = cls;
        HashMap map = new HashMap();
        for (int i = 0; i <= 0; i++) {
            zzgw zzgwVar = zzgwVarArr[i];
            if (map.containsKey(zzgwVar.zzb())) {
                throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive ".concat(String.valueOf(zzgwVar.zzb().getCanonicalName())));
            }
            map.put(zzgwVar.zzb(), zzgwVar);
        }
        this.zzc = zzgwVarArr[0].zzb();
        this.zzb = Collections.unmodifiableMap(map);
    }

    public zzgb zza() {
        throw new UnsupportedOperationException("Creating keys is not supported.");
    }

    public abstract zznr zzb();

    public abstract zzaek zzc(zzacc zzaccVar);

    public abstract String zzd();

    public abstract void zze(zzaek zzaekVar);

    public int zzf() {
        return 1;
    }

    public final Class zzj() {
        return this.zzc;
    }

    public final Class zzk() {
        return this.zza;
    }

    public final Object zzl(zzaek zzaekVar, Class cls) {
        zzgw zzgwVar = (zzgw) this.zzb.get(cls);
        if (zzgwVar != null) {
            return zzgwVar.zza(zzaekVar);
        }
        throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Requested primitive class ", cls.getCanonicalName(), " not supported."));
    }

    public final Set zzm() {
        return this.zzb.keySet();
    }
}
