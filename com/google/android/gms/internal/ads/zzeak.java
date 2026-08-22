package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzeak implements zzhgr {
    private final zzhha zza;

    private zzeak(zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzeak zzc(zzhha zzhhaVar) {
        return new zzeak(zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzeaj zzb() {
        return new zzeaj(((zzcih) this.zza).zzb());
    }
}
