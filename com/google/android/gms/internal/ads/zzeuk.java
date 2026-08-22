package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzeuk implements zzhgr {
    private final zzhha zza;

    private zzeuk(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
    }

    public static zzeuk zzc(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzeuk(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzeui zzb() {
        return new zzeui(((zzchl) this.zza).zza(), zzffu.zzc());
    }
}
