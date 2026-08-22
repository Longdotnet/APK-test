package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzemj implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;
    private final zzhha zzc;

    private zzemj(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4) {
        this.zza = zzhhaVar2;
        this.zzb = zzhhaVar3;
        this.zzc = zzhhaVar4;
    }

    public static zzemj zzc(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4) {
        return new zzemj(zzhhaVar, zzhhaVar2, zzhhaVar3, zzhhaVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzemh zzb() {
        return new zzemh(zzffu.zzc(), ((zzcvp) this.zza).zzc(), (zzfdl) this.zzb.zzb(), ((Integer) this.zzc.zzb()).intValue());
    }
}
