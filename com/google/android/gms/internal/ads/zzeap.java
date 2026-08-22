package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzeap implements zzhgr {
    private final zzhha zza;

    private zzeap(zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzeap zzc(zzhha zzhhaVar) {
        return new zzeap(zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzeao zzb() {
        return new zzeao(((zzchl) this.zza).zza());
    }
}
