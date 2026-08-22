package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzdyv implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzdyv(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar3;
    }

    public static zzdyv zzc(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3) {
        return new zzdyv(zzhhaVar, zzhhaVar2, zzhhaVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzdyu zzb() {
        return new zzdyu(((zzhgy) this.zza).zzd(), zzffu.zzc(), ((zzcyz) this.zzb).zzb());
    }
}
