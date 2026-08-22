package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzedl implements zzhgr {
    private final zzhha zza;

    private zzedl(zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzedl zzc(zzhha zzhhaVar) {
        return new zzedl(zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzedk zzb() {
        return new zzedk(((zzchl) this.zza).zza());
    }
}
