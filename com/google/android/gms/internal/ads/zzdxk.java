package com.google.android.gms.internal.ads;

import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class zzdxk implements zzhgr {
    public static zzdxk zza() {
        return zzdxj.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final Object zzb() {
        com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
        String string = UUID.randomUUID().toString();
        zzhgz.zzb(string);
        return string;
    }
}
