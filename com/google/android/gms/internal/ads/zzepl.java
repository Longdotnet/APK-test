package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzepl implements zzhgr {
    public static zzepl zza() {
        return zzepk.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final Object zzb() {
        Object arrayList = new ArrayList();
        zzbcv zzbcvVar = zzbde.zzmh;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (!((String) zzbdVar.zzd.zzb(zzbcvVar)).isEmpty()) {
            arrayList = Arrays.asList(((String) zzbdVar.zzd.zzb(zzbcvVar)).split(","));
        }
        zzhgz.zzb(arrayList);
        return arrayList;
    }
}
