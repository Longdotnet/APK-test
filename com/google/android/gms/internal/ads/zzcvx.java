package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzcvx implements zzhgr {
    private final zzhha zza;

    private zzcvx(zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzcvx zza(zzhha zzhhaVar) {
        return new zzcvx(zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcvw(((zzhhd) this.zza).zzb());
    }
}
