package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzckk implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzckk(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
    }

    public static zzckk zza(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzckk(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new com.google.android.gms.ads.internal.util.client.zzu(((zzchl) this.zza).zza(), (String) this.zzb.zzb());
    }
}
