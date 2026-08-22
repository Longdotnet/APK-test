package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzfkk implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzfkk(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
    }

    public static zzfkk zza(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzfkk(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzfkj((zzfkp) this.zza.zzb(), (zzfkc) this.zzb.zzb());
    }
}
