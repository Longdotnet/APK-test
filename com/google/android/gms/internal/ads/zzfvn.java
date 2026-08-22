package com.google.android.gms.internal.ads;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzfvn implements Serializable {
    public static zzfvn zzc() {
        return zzfut.zza;
    }

    public static zzfvn zzd(Object obj) {
        return obj == null ? zzfut.zza : new zzfvu(obj);
    }

    public abstract zzfvn zza(zzfve zzfveVar);

    public abstract Object zzb(Object obj);
}
