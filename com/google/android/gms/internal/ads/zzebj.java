package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzebj implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzebj(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
    }

    public static zzebj zzc(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzebj(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzebi zzb() {
        return new zzebi((zzeaw) this.zza.zzb(), ((zzebb) this.zzb).zzb());
    }
}
