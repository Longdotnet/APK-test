package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzfhf implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;
    private final zzhha zzc;

    private zzfhf(zzfhe zzfheVar, zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
        this.zzc = zzhhaVar3;
    }

    public static zzfhf zza(zzfhe zzfheVar, zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3) {
        return new zzfhf(zzfheVar, zzhhaVar, zzhhaVar2, zzhhaVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzbow zzbowVarZza = new zzbon().zza(((zzchl) this.zza).zza(), ((zzchz) this.zzb).zza(), (zzfhx) this.zzc.zzb());
        zzhgz.zzb(zzbowVarZza);
        return zzbowVarZza;
    }
}
