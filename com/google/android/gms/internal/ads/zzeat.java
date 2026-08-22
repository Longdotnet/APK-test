package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzeat implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzeat(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
    }

    public static zzeat zzc(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzeat(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzeas zzb() {
        return new zzeas(((zzeap) this.zza).zzb(), (zzgdy) this.zzb.zzb());
    }
}
