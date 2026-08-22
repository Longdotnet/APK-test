package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzcre implements zzhgr {
    private final zzhha zza;

    private zzcre(zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzcre zza(zzhha zzhhaVar) {
        return new zzcre(zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcrc(((zzhgv) this.zza).zzb());
    }
}
