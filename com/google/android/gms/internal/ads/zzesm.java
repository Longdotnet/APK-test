package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzesm implements zzhgr {
    private final zzhha zza;

    private zzesm(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar2;
    }

    public static zzesm zzc(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzesm(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzesk zzb() {
        return new zzesk(zzffu.zzc(), ((zzchl) this.zza).zza());
    }
}
