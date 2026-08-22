package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzeon implements zzhgr {
    private final zzhha zza;

    private zzeon(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar2;
    }

    public static zzeon zzc(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzeon(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzeol zzb() {
        return new zzeol(zzffu.zzc(), ((zzchl) this.zza).zza());
    }
}
