package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzcmt implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzcmt(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
    }

    public static zzcmt zza(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzcmt(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcms(((zzcrr) this.zza).zzc(), ((zzcic) this.zzb).zzb());
    }
}
