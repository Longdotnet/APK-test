package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzeri implements zzhgr {
    private final zzhha zza;

    private zzeri(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar2;
    }

    public static zzeri zzc(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzeri(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzerg zzb() {
        return new zzerg(zzffu.zzc(), ((zzchl) this.zza).zza());
    }
}
