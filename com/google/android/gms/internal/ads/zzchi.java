package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzchi implements zzhgr {
    private final zzhha zza;

    private zzchi(zzchh zzchhVar, zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzchi zzc(zzchh zzchhVar, zzhha zzhhaVar) {
        return new zzchi(zzchhVar, zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final com.google.android.gms.ads.internal.util.zzg zzb() {
        return ((zzbzs) this.zza.zzb()).zzi();
    }
}
