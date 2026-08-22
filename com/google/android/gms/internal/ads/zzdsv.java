package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzdsv implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzdsv(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
    }

    public static zzdsv zza(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzdsv(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdsu((String) this.zza.zzb(), (zzdso) this.zzb.zzb());
    }
}
