package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzcpf implements zzhgr {
    private final zzcoz zza;
    private final zzhha zzb;

    private zzcpf(zzcoz zzcozVar, zzhha zzhhaVar) {
        this.zza = zzcozVar;
        this.zzb = zzhhaVar;
    }

    public static zzcos zzc(zzcoz zzcozVar, Object obj) {
        return (zzcov) obj;
    }

    public static zzcpf zzd(zzcoz zzcozVar, zzhha zzhhaVar) {
        return new zzcpf(zzcozVar, zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzcos zzb() {
        return ((zzcow) this.zzb).zzb();
    }
}
