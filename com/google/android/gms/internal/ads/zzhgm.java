package com.google.android.gms.internal.ads;

import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
public class zzhgm {
    final LinkedHashMap zza;

    public zzhgm(int i) {
        this.zza = zzhgo.zzb(i);
    }

    public final zzhgm zza(Object obj, zzhha zzhhaVar) {
        zzhgz.zza(obj, "key");
        zzhgz.zza(zzhhaVar, "provider");
        this.zza.put(obj, zzhhaVar);
        return this;
    }
}
