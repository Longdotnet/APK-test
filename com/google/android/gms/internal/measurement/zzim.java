package com.google.android.gms.internal.measurement;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class zzim {
    public static zzii zza(zzii zziiVar) {
        if ((zziiVar instanceof zzik) || (zziiVar instanceof zzij)) {
            return zziiVar;
        }
        return zziiVar instanceof Serializable ? new zzij(zziiVar) : new zzik(zziiVar);
    }

    public static zzii zzb(Object obj) {
        return new zzil(obj);
    }
}
