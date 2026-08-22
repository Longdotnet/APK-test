package com.google.android.gms.internal.ads;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class zzfwl {
    public static zzfwh zza(zzfwh zzfwhVar) {
        if ((zzfwhVar instanceof zzfwk) || (zzfwhVar instanceof zzfwi)) {
            return zzfwhVar;
        }
        return zzfwhVar instanceof Serializable ? new zzfwi(zzfwhVar) : new zzfwk(zzfwhVar);
    }
}
