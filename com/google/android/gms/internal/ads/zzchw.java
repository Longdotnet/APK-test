package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzchw implements zzhgr {
    private final zzhha zza;

    private zzchw(zzchh zzchhVar, zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzchw zza(zzchh zzchhVar, zzhha zzhhaVar) {
        return new zzchw(zzchhVar, zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final zzcld zzb() {
        zzche zzcheVar = (zzche) this.zza.zzb();
        zzhgz.zzb(zzcheVar);
        return zzcheVar;
    }
}
