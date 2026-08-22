package com.google.android.gms.internal.auth;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class zzdk {
    public static <T> zzdg<T> zza(zzdg<T> zzdgVar) {
        if ((zzdgVar instanceof zzdi) || (zzdgVar instanceof zzdh)) {
            return zzdgVar;
        }
        return zzdgVar instanceof Serializable ? new zzdh(zzdgVar) : new zzdi(zzdgVar);
    }

    public static <T> zzdg<T> zzb(T t) {
        return new zzdj(t);
    }
}
