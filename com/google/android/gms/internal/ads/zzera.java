package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzera implements zzhgr {
    private final zzhha zza;

    private zzera(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
    }

    public static zzera zzc(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzera(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzeqz zzb() {
        return new zzeqz(((zzchl) this.zza).zza(), zzffu.zzc());
    }
}
