package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzcmb implements zzhgr {
    private final zzhha zza;

    private zzcmb(zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzcmb zza(zzhha zzhhaVar) {
        return new zzcmb(zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcma(((zzckh) this.zza).zzb());
    }
}
