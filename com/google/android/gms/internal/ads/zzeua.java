package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzeua implements zzhgr {
    private final zzhha zza;

    private zzeua(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar2;
    }

    public static zzeua zzc(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzeua(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzetz zzb() {
        return new zzetz(zzffu.zzc(), ((zzchl) this.zza).zza());
    }
}
