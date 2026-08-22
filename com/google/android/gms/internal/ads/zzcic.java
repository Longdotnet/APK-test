package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzcic implements zzhgr {
    private final zzhha zza;

    private zzcic(zzchh zzchhVar, zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzcic zzc(zzchh zzchhVar, zzhha zzhhaVar) {
        return new zzcic(zzchhVar, zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzbzw zzb() {
        return ((zzbzs) this.zza.zzb()).zzh();
    }
}
