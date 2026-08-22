package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class zzcvk implements zzhgr {
    private final zzcvh zza;

    private zzcvk(zzcvh zzcvhVar) {
        this.zza = zzcvhVar;
    }

    public static zzcvk zzc(zzcvh zzcvhVar) {
        return new zzcvk(zzcvhVar);
    }

    public final Bundle zza() {
        return this.zza.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* synthetic */ Object zzb() {
        return this.zza.zzc();
    }
}
