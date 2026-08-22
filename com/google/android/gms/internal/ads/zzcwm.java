package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzcwm implements zzhgr {
    private final zzhha zza;

    private zzcwm(zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzcwm zzc(zzhha zzhhaVar) {
        return new zzcwm(zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzcwk zzb() {
        return new zzcwk(((zzhhd) this.zza).zzb());
    }
}
