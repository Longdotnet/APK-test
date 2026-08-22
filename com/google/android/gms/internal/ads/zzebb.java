package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzebb implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzebb(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
    }

    public static zzebb zzc(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzebb(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzeba zzb() {
        return new zzeba(((zzeat) this.zza).zzb(), ((zzchi) this.zzb).zzb());
    }
}
