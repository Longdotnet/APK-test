package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzeco implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;
    private final zzhha zzc;
    private final zzhha zzd;

    private zzeco(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
        this.zzc = zzhhaVar3;
        this.zzd = zzhhaVar4;
    }

    public static zzeco zza(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4) {
        return new zzeco(zzhhaVar, zzhhaVar2, zzhhaVar3, zzhhaVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzecl(((zzchl) this.zza).zza(), (zzeca) this.zzb.zzb(), (com.google.android.gms.ads.internal.util.client.zzu) this.zzc.zzb(), (zzdsj) this.zzd.zzb());
    }
}
