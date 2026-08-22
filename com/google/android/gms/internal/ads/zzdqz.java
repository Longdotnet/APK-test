package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzdqz implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzdqz(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
    }

    public static zzdqz zza(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzdqz(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdqy((zzbcc) this.zza.zzb(), (zzezv) this.zzb.zzb());
    }
}
