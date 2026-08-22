package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzcyn implements zzhgr {
    private final zzhha zza;

    private zzcyn(zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzcyn zza(zzhha zzhhaVar) {
        return new zzcyn(zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcym(((zzhhd) this.zza).zzb());
    }
}
