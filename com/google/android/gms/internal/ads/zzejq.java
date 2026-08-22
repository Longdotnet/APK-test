package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzejq {
    private final ConcurrentHashMap zza = new ConcurrentHashMap();
    private final zzdpz zzb;

    public zzejq(zzdpz zzdpzVar) {
        this.zzb = zzdpzVar;
    }

    public final zzbrp zza(String str) {
        ConcurrentHashMap concurrentHashMap = this.zza;
        if (concurrentHashMap.containsKey(str)) {
            return (zzbrp) concurrentHashMap.get(str);
        }
        return null;
    }

    public final void zzb(String str) {
        try {
            this.zza.put(str, this.zzb.zzb(str));
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.zze.zzb("Couldn't create RTB adapter : ", e);
        }
    }
}
