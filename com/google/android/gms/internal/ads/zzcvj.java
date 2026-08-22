package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class zzcvj implements zzhgr {
    private final zzcvh zza;
    private final zzhha zzb;

    private zzcvj(zzcvh zzcvhVar, zzhha zzhhaVar) {
        this.zza = zzcvhVar;
        this.zzb = zzhhaVar;
    }

    public static zzcvj zza(zzcvh zzcvhVar, zzhha zzhhaVar) {
        return new zzcvj(zzcvhVar, zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        Context contextZzb = this.zza.zzb(((zzchl) this.zzb).zza());
        zzhgz.zzb(contextZzb);
        return contextZzb;
    }
}
