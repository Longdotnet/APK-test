package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzecb implements zzhgr {
    private final zzhha zza;

    private zzecb(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
    }

    public static zzecb zza(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzecb(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzeca(((zzchl) this.zza).zza(), zzffu.zzc());
    }
}
