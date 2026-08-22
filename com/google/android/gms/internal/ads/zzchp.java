package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzchp implements zzhgr {
    private final zzhha zza;

    private zzchp(zzchh zzchhVar, zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzchp zza(zzchh zzchhVar, zzhha zzhhaVar) {
        return new zzchp(zzchhVar, zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzavu((com.google.android.gms.ads.internal.zzk) this.zza.zzb());
    }
}
