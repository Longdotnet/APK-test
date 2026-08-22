package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzesy implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;
    private final zzhha zzc;

    private zzesy(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar3;
        this.zzc = zzhhaVar4;
    }

    public static zzesy zzc(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4) {
        return new zzesy(zzhhaVar, zzhhaVar2, zzhhaVar3, zzhhaVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzesw zzb() {
        return new zzesw(((zzchl) this.zza).zza(), zzffu.zzc(), ((zzcvp) this.zzb).zzc(), ((zzchz) this.zzc).zza());
    }
}
