package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzcki implements zzhgr {
    private final zzhha zza;

    private zzcki(zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzcki zza(zzhha zzhhaVar) {
        return new zzcki(zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final Object zzb() {
        return new zzfot(((zzchl) this.zza).zza(), com.google.android.gms.ads.internal.zzv.zza.zzu.zzb());
    }
}
