package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzgmj {
    final Map zza = new HashMap();
    final Map zzb = new HashMap();

    private zzgmj() {
    }

    public final zzgmj zza(Enum r2, Object obj) {
        this.zza.put(r2, obj);
        this.zzb.put(obj, r2);
        return this;
    }

    public final zzgml zzb() {
        return new zzgml(Collections.unmodifiableMap(this.zza), Collections.unmodifiableMap(this.zzb), null);
    }

    public /* synthetic */ zzgmj(zzgmk zzgmkVar) {
    }
}
