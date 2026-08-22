package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzenl implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzenl(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3) {
        this.zza = zzhhaVar2;
        this.zzb = zzhhaVar3;
    }

    public static zzenl zza(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3) {
        return new zzenl(zzhhaVar, zzhhaVar2, zzhhaVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzenj(zzffu.zzc(), ((zzcvp) this.zza).zzc(), ((zzcic) this.zzb).zzb());
    }
}
