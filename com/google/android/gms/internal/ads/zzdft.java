package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzdft implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzdft(zzdff zzdffVar, zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
    }

    public static zzdft zzc(zzdff zzdffVar, zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzdft(zzdffVar, zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzbyk zzb() {
        return new zzbyk(((zzchl) this.zza).zza(), ((zzcvp) this.zzb).zzc().zzf);
    }
}
