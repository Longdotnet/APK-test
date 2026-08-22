package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzctb implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzctb(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
    }

    public static zzctb zza(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzctb(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcta((zzcte) this.zza.zzb(), ((zzcvp) this.zzb).zzc());
    }
}
