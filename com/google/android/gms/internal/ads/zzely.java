package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzely implements zzhgr {
    private final zzhha zza;

    private zzely(zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzely zzc(zzhha zzhhaVar) {
        return new zzely(zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzelw zzb() {
        return new zzelw(((zzchl) this.zza).zza());
    }
}
