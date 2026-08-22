package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzdzk implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzdzk(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3) {
        this.zza = zzhhaVar2;
        this.zzb = zzhhaVar3;
    }

    public static zzdzk zzc(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3) {
        return new zzdzk(zzhhaVar, zzhhaVar2, zzhhaVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzdzj zzb() {
        return new zzdzj(zzffu.zzc(), ((zzdyp) this.zza).zzb(), zzhgq.zza(this.zzb));
    }
}
