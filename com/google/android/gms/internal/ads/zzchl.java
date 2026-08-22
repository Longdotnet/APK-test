package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class zzchl implements zzhgr {
    private final zzchh zza;

    private zzchl(zzchh zzchhVar) {
        this.zza = zzchhVar;
    }

    public static Context zzc(zzchh zzchhVar) {
        Context contextZzb = zzchhVar.zzb();
        zzhgz.zzb(contextZzb);
        return contextZzb;
    }

    public static zzchl zzd(zzchh zzchhVar) {
        return new zzchl(zzchhVar);
    }

    public final Context zza() {
        return zzc(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* synthetic */ Object zzb() {
        return zzc(this.zza);
    }
}
