package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzeuo implements zzhgr {
    private final zzhha zza;

    private zzeuo(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar2;
    }

    public static zzeuo zzc(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzeuo(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzeun zzb() {
        return new zzeun(zzffu.zzc(), ((zzchl) this.zza).zza());
    }
}
