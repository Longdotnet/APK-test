package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzeog implements zzhgr {
    private final zzhha zza;

    private zzeog(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar2;
    }

    public static zzeog zzc(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzeog(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzeoe zzb() {
        return new zzeoe(zzffu.zzc(), ((zzchl) this.zza).zza());
    }
}
