package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzchq implements zzhgr {
    private final zzhha zza;

    private zzchq(zzchh zzchhVar, zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzchq zza(zzchh zzchhVar, zzhha zzhhaVar) {
        return new zzchq(zzchhVar, zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final String zzb() {
        return zzfds.zzd(((zzchl) this.zza).zza()).zze();
    }
}
